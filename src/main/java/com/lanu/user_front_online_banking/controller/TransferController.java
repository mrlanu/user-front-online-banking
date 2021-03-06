package com.lanu.user_front_online_banking.controller;

import com.lanu.user_front_online_banking.dao.RecipientDao;
import com.lanu.user_front_online_banking.domain.*;
import com.lanu.user_front_online_banking.service.RecipientService;
import com.lanu.user_front_online_banking.service.TransactionService;
import com.lanu.user_front_online_banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private RecipientService recipientService;

    @GetMapping("/betweenAccounts")
    public String betweenAccounts(Model model){
        model.addAttribute("accountFrom", "");
        model.addAttribute("accountTo", "");
        model.addAttribute("amount", "");
        return "betweenAccounts";
    }

    @PostMapping("/betweenAccounts")
    public String betweenAccountsPost(
            @ModelAttribute("transferFrom") String transferFrom,
            @ModelAttribute("transferTo") String  transferTo,
            @ModelAttribute("amount") String amount,
            Principal principal) throws Exception {

        User user = userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        SavingsAccount savingsAccount = user.getSavingsAccount();
        transactionService.betweenAccountsTransfer(transferFrom, transferTo, amount, primaryAccount, savingsAccount);

        return "redirect:/userFront";
    }

    @GetMapping("/recipient")
    public String recipient(Model model, Principal principal){
        Recipient recipient = new Recipient();
        User user = userService.findByUsername(principal.getName());
        List<Recipient> recipientList = user.getRecipientList();
        model.addAttribute("recipient", recipient);
        model.addAttribute("recipientList", recipientList);
        return "recipient";
    }

    @PostMapping("/recipient/save")
    public String recipientSave(@ModelAttribute("recipient") Recipient recipient, Principal principal){
        User user = userService.findByUsername(principal.getName());
        recipient.setUser(user);
        transactionService.saveRecipient(recipient);
        return "redirect:/transfer/recipient";
    }

    @GetMapping("/recipient/edit")
    @ResponseBody
    public Optional<Recipient> findOne(Long id) {
        return recipientService.findById(id);
    }

    @GetMapping("/recipient/delete")
    public String deleterecipient(Long id) {
        recipientService.deleteById(id);
        return "redirect:/transfer/recipient";
    }

    @GetMapping("/toSomeoneElse")
    public String toSomeoneElse(Model model, Principal principal){
        List<Recipient> recipientList = transactionService.findRecipientList(principal);
        model.addAttribute("recipientList", recipientList);
        model.addAttribute("accountType","");
        return "toSomeoneElse";
    }

    @PostMapping("/toSomeoneElse")
    public String toSomeoneElsePost(@ModelAttribute("recipientName") String recipientName, @ModelAttribute("accountType") String accountType,
                                    @ModelAttribute("amount") String amount, Principal principal){
        User user = userService.findByUsername(principal.getName());
        Recipient recipient = transactionService.findRecipientByName(recipientName);
        transactionService.toSomeoneElseTransfer(recipient, accountType, amount, user.getPrimaryAccount(), user.getSavingsAccount());
        return "redirect:/userFront";
    }

}
