package com.elliott.JavaLeetCodeSolutions.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.*;

@Entity(name = "blogpost")
public class BlogPost extends AbstractEntity{

    public BlogPost(){}

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    private String filter;


    private Date dateCreated;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="BLOG_TAG",
            joinColumns = @JoinColumn(name = "BLOG_ID"),
            inverseJoinColumns = @JoinColumn(name="TAG_ID"))
    private Set<Tag> tags = new HashSet<>();






    public BlogPost(String title,String body,String filter,Date date){
        this.title = title;
        this.body = body;
        this.filter = filter;
        this.dateCreated = date;

    }
    public BlogPost(String title,String filter,Date date){
        this.title = title;

        this.filter = filter;
        this.dateCreated = date;

    }


    //GETTERS
    public String getTitle(){
        return this.title;
    }
    public String getBody(){
        return this.body;
    }
    public String getFilter(){return this.filter;}
    public Date getDateCreated(){
        return this.dateCreated;
    }
    public Set<Tag> getTags(){return this.tags;}



    //SETTERS
    public void setTitle(String title){
        this.title = title;
    }
    public void setBody(String body){
        this.body = body;
    }
    public void setFilter(String filter){
        this.filter = filter;
    }
    public void  setDateCreated(Date date){
        this.dateCreated = date;
    }
    public void setTags(Set<Tag> tags){
        this.tags = tags;
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

    public void addTag(Tag tag){
        this.tags.add(tag);
        tag.addBlogPost(this);
    }
    public void removeTag(Tag tag){
        this.tags.remove(tag);
        tag.removeBlogPost(this);
    }


}
