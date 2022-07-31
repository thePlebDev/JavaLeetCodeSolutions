package com.elliott.JavaLeetCodeSolutions.controllers;

import com.elliott.JavaLeetCodeSolutions.models.BlogPost;
import com.elliott.JavaLeetCodeSolutions.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/tree/1")
    public String getBlogPostOne(Model model){
        BlogPost foundBlogPost = this.blogPostService.getBlogPostById();

        model.addAttribute("title",foundBlogPost.getTitle());
        model.addAttribute("body",foundBlogPost.getBody());
        return "blogPostOne";
    }
}


















