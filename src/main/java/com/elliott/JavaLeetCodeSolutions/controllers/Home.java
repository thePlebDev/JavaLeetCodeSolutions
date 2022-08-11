package com.elliott.JavaLeetCodeSolutions.controllers;

import com.elliott.JavaLeetCodeSolutions.models.BlogPost;
import com.elliott.JavaLeetCodeSolutions.models.Filters;
import com.elliott.JavaLeetCodeSolutions.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
//TODO: NO MORE IN THIS CONTROLLER
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

        model.addAttribute("posts",blogPosts);

        return "leetCodeSolutions";
    }

    //TODO: TEST THIS OUT
    @GetMapping("/leetCodeSolution/search")
    public String getLeetCodeSolutionsByTitle(@RequestParam String title,Model model){
        List<BlogPost> blogPosts = this.blogPostService.getAllByTitleNFilter(title,"LEETCODE");

        model.addAttribute("posts",blogPosts);

        return "leetCodeSolutions";
    }
    @GetMapping("/leetcode")
    public String getSpecificLeetCode(@RequestParam Long id,Model model){
        Optional<BlogPost> post = this.blogPostService.getBlogPostById(id);
        if (post.isEmpty()){
            return "home";
        }else{
            model.addAttribute("body",post.get().getBody());
            return "leetCodeSolution";
        }

    }
    @GetMapping("/dsa")
    public String getSpecificDSA(@RequestParam Long id,Model model){
        Optional<BlogPost> post = this.blogPostService.getBlogPostById(id);
        if (post.isEmpty()){
            return "home";
        }else{
            model.addAttribute("body",post.get().getBody());
            return "indivDSATutorial";
        }

    }

    @GetMapping("/dataStructureTutorial")
    public String getDataStructure(Model model){

        List<BlogPost> blogPosts = this.blogPostService.getDSATutorials();
        model.addAttribute("posts",blogPosts);

        return "dataStructureTutorial";
    }

    @GetMapping("/dataStructureTutorial/search")
    public String getDataStructureByTitle(@RequestParam String title,Model model){

        List<BlogPost> blogPosts = this.blogPostService.getAllByTitleNFilter(title,"DSA");

        model.addAttribute("posts",blogPosts);

        return "dataStructureTutorial";
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

//    @GetMapping("/test/blog")
//    public String testBlog(){
//
//        return "testBlog";
//    }
}
