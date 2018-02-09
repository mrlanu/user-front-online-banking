package com.lanu.user_front_online_banking.controller;

import com.lanu.user_front_online_banking.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/signup")
    public String signup(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/signup")
    public String signupPost(@ModelAttribute("user") User user, Model model){

    }
}










