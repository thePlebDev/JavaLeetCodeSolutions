package com.elliott.JavaLeetCodeSolutions.controllers;

import com.elliott.JavaLeetCodeSolutions.models.BlogPost;
import com.elliott.JavaLeetCodeSolutions.models.Filters;
import com.elliott.JavaLeetCodeSolutions.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class Home {

    @Autowired
    private BlogPostService blogPostService;


    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/leetCodeSolution")
    public String getLeetCodeSolutions(Model model){
        List<BlogPost> blogPosts = this.blogPostService.getLeetCodeSolutions();
//        BlogPost post1 = new BlogPost();
//        BlogPost post2 = new BlogPost();
//        post1.setTitle("Two Sum");
//        post2.setTitle("Shortest array length");
//        List<BlogPost> posts = new ArrayList<>();
//        posts.add(post1);
//        posts.add(post2);

        model.addAttribute("posts",blogPosts);

        return "leetCodeSolutions";
    }

    @GetMapping("/dataStructureTutorial")
    public String getDataStructure(){
        return "dataStructureTutorial";
    }

    @GetMapping("/admin/blogPost/create")
    public String createBlogPost(Model model){

        model.addAttribute("blogPost",new BlogPost());

        return "createBlogPost";
    }

    @GetMapping("/test/blog")
    public String testBlog(){

        return "testBlog";
    }

    @PostMapping("/admin/blogPost/create")
    public String createBlogPostPost(@ModelAttribute BlogPost post){
        this.blogPostService.saveBlogPost(post);

        return "home";

    }
}
