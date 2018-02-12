package com.lanu.user_front_online_banking.controller;

import com.lanu.user_front_online_banking.domain.*;
import com.lanu.user_front_online_banking.service.AccountService;
import com.lanu.user_front_online_banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/primaryAccount")
    public String primaryAccount(Principal principal, Model model){
        User user = userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        List<PrimaryTransaction> primaryTransactionList = primaryAccount.getPrimaryTransactionList();
        model.addAttribute("primaryAccount", primaryAccount);
        model.addAttribute("primaryTransactionList", primaryTransactionList);
        return "primaryAccount";
    }

    @RequestMapping("/savingsAccount")
    public String primarysavingsaccountAccount(Principal principal, Model model){
        User user = userService.findByUsername(principal.getName());
        SavingsAccount savingsAccount = user.getSavingsAccount();
        List<SavingsTransaction> savingsTransactionList = savingsAccount.getSavingsTransactionList();
        model.addAttribute("savingsAccount", savingsAccount);
        model.addAttribute("savingsTransactionList", savingsTransactionList);
        return "savingsAccount";
    }

    @GetMapping("/deposit")
    public String deposit(Model model){
        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");
        return "deposit";
    }

    @PostMapping("/deposit")
    public String deposit(@ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal){
        accountService.deposit(accountType, Double.parseDouble(amount), principal);
        return "redirect:/userFront";
    }

    @GetMapping("/withdraw")
    public String withdraw(Model model){
        model.addAttribute("accountType","");
        model.addAttribute("amount", "");
        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdraw(@ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal){
        accountService.withdraw(accountType, Double.parseDouble(amount), principal);
        return "redirect:/userFront";
    }
}
