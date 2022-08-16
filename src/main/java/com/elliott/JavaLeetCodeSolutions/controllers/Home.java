package com.elliott.JavaLeetCodeSolutions.controllers;

import com.elliott.JavaLeetCodeSolutions.models.BlogPost;
import com.elliott.JavaLeetCodeSolutions.models.Filters;
import com.elliott.JavaLeetCodeSolutions.models.Tag;
import com.elliott.JavaLeetCodeSolutions.repositories.TagRepository;
import com.elliott.JavaLeetCodeSolutions.services.BlogPostService;
import com.elliott.JavaLeetCodeSolutions.services.TagService;
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

    @Autowired
    private TagService tagService;


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


    @GetMapping("/leetCodeSolution/search")
    public String getLeetCodeSolutionsByTitle(@RequestParam(required = false) String title,@RequestParam(required = false)  String filter,Model model){

        List<BlogPost> blogPosts = this.blogPostService.getAllByTitleOrTag(title,filter);

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
    public String getDataStructureByTitle(@RequestParam String title, Model model){
        List<BlogPost> blogPosts = this.blogPostService.getAllByTitle(title);

        model.addAttribute("posts",blogPosts);

        return "dataStructureTutorial";
    }

    @GetMapping("/admin/blogPost/create")
    public String createBlogPost(Model model){
        List<Tag> allTags = this.tagService.findAllTags();
        model.addAttribute("blogPost",new BlogPost());
        model.addAttribute("allTags",allTags);

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
