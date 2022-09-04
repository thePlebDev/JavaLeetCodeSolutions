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
import java.util.Optional;

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
    public String signupSuccess(@Valid User user,String secondPassword, BindingResult bindingResult,Model model){


        if(bindingResult.hasErrors()){
            return "signup";
        }
       Optional<String> message = signupService.signupUser(user,secondPassword);
        if(message.isPresent()){
            model.addAttribute("passwordError",message.get());
            return "signup";
        }

        return "signupSuccess";
    }



}
