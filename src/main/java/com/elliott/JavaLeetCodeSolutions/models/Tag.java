package com.elliott.JavaLeetCodeSolutions.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag extends AbstractEntity{

    private String title;

    @ManyToMany(mappedBy = "tags")
    private Set<BlogPost> blogPosts = new HashSet<>();

    public Tag() {
    }

    public Tag(String title){
        this.title = title;
    }


    //GETTERS
    public String getTitle(){
        return this.title;
    }
    public Set<BlogPost> getBlogPosts(){
        return this.blogPosts;
    }

    //SETTERS
    public void setTitle(String title){
        this.title = title;
    }


    //UTILITY
    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        if(!(o instanceof BlogPost)){
            return false;
        }
        BlogPost other = (BlogPost) o;

        return this.getId() != null &&
                this.getId().equals(other.getId());
    }

    public void addBlogPost(BlogPost post){
        this.blogPosts.add(post);
        post.getTags().add(this);
    }
    public void removeBlogPost(BlogPost post){
        this.blogPosts.remove(post);
        post.getTags().remove(post);
    }

}
