package com.elliott.JavaLeetCodeSolutions.controllers;

import com.elliott.JavaLeetCodeSolutions.models.BlogPost;
import com.elliott.JavaLeetCodeSolutions.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Home {

    @Autowired
    private BlogPostService blogPostService;


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
        this.blogPostService.saveBlogPost(post);

        return "home";

    }
}
