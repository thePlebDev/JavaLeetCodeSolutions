package com.elliott.JavaLeetCodeSolutions.controllers;

import com.elliott.JavaLeetCodeSolutions.models.User;
import com.elliott.JavaLeetCodeSolutions.security.services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private SignupService signupService;

    @GetMapping
    public String signup(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }

    @PostMapping
    public String signupSuccess(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "signup";
        }
        signupService.signupUser(user);

        return "signupSuccess";
    }



}
