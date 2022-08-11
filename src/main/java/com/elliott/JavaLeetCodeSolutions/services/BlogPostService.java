package com.elliott.JavaLeetCodeSolutions.services;

import com.elliott.JavaLeetCodeSolutions.models.BlogPost;
import com.elliott.JavaLeetCodeSolutions.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public List<BlogPost> getLeetCodeSolutions(){
        return this.blogPostRepository.findBlogPostByFilter("LEETCODE");
    }
    public List<BlogPost> getDSATutorials(){
        return this.blogPostRepository.findBlogPostByFilter("DSA");
    }

    public Optional<BlogPost> getBlogPostById(Long id){
        return this.blogPostRepository.findBlogPostByPrimaryKey(id);
    }

    public List<BlogPost> getAllByTitleNFilter(String title,String filter){
        return this.blogPostRepository.findBlogPostByTitleNFilter(title,filter);
    }
}
