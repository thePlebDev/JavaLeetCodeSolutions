package com.elliott.JavaLeetCodeSolutions.services;

import com.elliott.JavaLeetCodeSolutions.models.BlogPost;
import com.elliott.JavaLeetCodeSolutions.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlogPostService {

    private BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository){
        this.blogPostRepository = blogPostRepository;
    }

    public String saveBlogPost(BlogPost blogPost){
        blogPost.setDateCreated(new Date());
        this.blogPostRepository.save(blogPost);
        return "";
    }

    public BlogPost getBlogPostById(){
        //todo:NEEDS TO BE REFACTORED WITH AN OPTIONAL
        return this.blogPostRepository.findBlogPostByIdIs(1l);
    }
}
