package com.elliott.JavaLeetCodeSolutions.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "blogpost")
public class BlogPost extends AbstractEntity{

    public BlogPost(){}

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    private String filter;


    private Date dateCreated;




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



}
