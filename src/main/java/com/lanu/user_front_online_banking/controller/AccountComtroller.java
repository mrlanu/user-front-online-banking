package com.lanu.user_front_online_banking.controller;

import com.lanu.user_front_online_banking.domain.PrimaryAccount;
import com.lanu.user_front_online_banking.domain.SavingsAccount;
import com.lanu.user_front_online_banking.domain.User;
import com.lanu.user_front_online_banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/account")
public class AccountComtroller {

    @Autowired
    private UserService userService;

    @RequestMapping("/primaryAccount")
    public String primaryAccount(Principal principal, Model model){
        User user = userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        model.addAttribute("primaryAccount", primaryAccount);
        return "primaryAccount";
    }

    @RequestMapping("/savingsAccount")
    public String primarysavingsaccountAccount(Principal principal, Model model){
        User user = userService.findByUsername(principal.getName());
        SavingsAccount savingsAccount = user.getSavingsAccount();
        model.addAttribute("savingsAccount", savingsAccount);
        return "savingsAccount";
    }
}
