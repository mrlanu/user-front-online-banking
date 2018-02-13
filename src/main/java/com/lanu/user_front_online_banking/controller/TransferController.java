package com.lanu.user_front_online_banking.controller;

import com.lanu.user_front_online_banking.domain.PrimaryAccount;
import com.lanu.user_front_online_banking.domain.SavingsAccount;
import com.lanu.user_front_online_banking.domain.SavingsTransaction;
import com.lanu.user_front_online_banking.domain.User;
import com.lanu.user_front_online_banking.service.TransactionService;
import com.lanu.user_front_online_banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

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
}
