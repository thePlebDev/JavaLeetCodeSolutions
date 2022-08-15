package com.elliott.JavaLeetCodeSolutions.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Tag extends AbstractEntity{

    @NaturalId
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        Tag tag = (Tag) o;
        return Objects.equals(getTitle(), tag.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
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
