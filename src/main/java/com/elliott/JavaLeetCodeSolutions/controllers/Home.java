package com.elliott.JavaLeetCodeSolutions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/admin/blogPost/create")
    public String createBlogPost(){
        return "createBlogPost";
    }
}
