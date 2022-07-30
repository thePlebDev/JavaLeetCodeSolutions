package com.elliott.JavaLeetCodeSolutions.controllers;

import com.elliott.JavaLeetCodeSolutions.models.BlogPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Home {


    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/admin/blogPost/create")
    public String createBlogPost(Model model){
        model.addAttribute("blogPost",new BlogPost());
        return "createBlogPost";
    }

    @PostMapping("/admin/blogPost/create")
    public String createBlogPostPost(@ModelAttribute BlogPost post){
        System.out.println(post.getBody());
        System.out.println(post.getTitle());
        return "home";

    }
}
