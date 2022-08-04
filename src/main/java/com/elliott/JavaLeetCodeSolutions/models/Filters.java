package com.elliott.JavaLeetCodeSolutions.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class Filters {

    private String name;


    private List<BlogPost> blogPosts = new ArrayList<>();

    public Filters(){}

    public Filters(String name){
        this.name = name;

    }


    public void removeBlogPost(BlogPost post){
        this.blogPosts.remove(post);
    }



    //GETTERS
    public String getName(){
        return this.name;
    }
    public List<BlogPost> getBlogPosts(){return this.blogPosts;}


    //SETTERS
    public void setName(String name){
        this.name = name;
    }
    public void setBlogPost(BlogPost post){this.blogPosts.add(post);}

}
