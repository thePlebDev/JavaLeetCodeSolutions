package com.elliott.JavaLeetCodeSolutions.models;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Series extends AbstractEntity{

    private String title;

    @OneToMany(mappedBy = "series")
    private List<BlogPost> posts = new ArrayList<>();

    public Series() {
    }

    public Series(String title){
        this.title = title;
    }


    //GETTERS
    public String getTitle(){
        return this.title;
    }

    public List<BlogPost> getPosts() {
        return posts;
    }

    //SETTERS
    public void setTitle(String title){
        this.title = title;
    }
    public void addPost(BlogPost post){
        this.posts.add(post);
    }
}
