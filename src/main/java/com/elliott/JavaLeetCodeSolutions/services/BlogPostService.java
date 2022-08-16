package com.elliott.JavaLeetCodeSolutions.services;

import com.elliott.JavaLeetCodeSolutions.models.BlogPost;
import com.elliott.JavaLeetCodeSolutions.models.Tag;
import com.elliott.JavaLeetCodeSolutions.repositories.BlogPostRepository;
import com.elliott.JavaLeetCodeSolutions.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    private BlogPostRepository blogPostRepository;
    private TagRepository tagRepository;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository,TagRepository tagRepository){
        this.blogPostRepository = blogPostRepository;
        this.tagRepository = tagRepository;
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

    //todo:changing this
    public List<BlogPost> getAllByTitleNFilter(String title,String filter){
        return this.blogPostRepository.findBlogPostByTitleNFilter(title,filter);
    }

    public List<BlogPost> getAllByTitle(String title){
        return this.blogPostRepository.findByTitleIgnoreCaseContaining(title);
    }

    public List<BlogPost> getAllByTitleOrTag(String title,String filter){
        if(title == "" && filter == null){

            return this.blogPostRepository.findBlogPostByFilter("LEETCODE");
        }
        else if (filter == null){

            return this.blogPostRepository.findBlogPostByTitle(title);
        }
        else if (title == ""){
            
            Tag foundTag = this.tagRepository.findByTitle(filter);
            return this.blogPostRepository.findByTags(foundTag);
        }
        else {
            Tag foundTag = this.tagRepository.findByTitle(filter);
            return this.blogPostRepository.findByTitleIgnoreCaseContainingOrTags(title,foundTag);
        }



    }
}
