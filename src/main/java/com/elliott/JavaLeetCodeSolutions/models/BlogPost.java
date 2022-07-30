package com.elliott.JavaLeetCodeSolutions.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "blogpost")
public class BlogPost extends AbstractEntity{

    public BlogPost(){}

    private String title;
    private String body;
    private Integer seriesNumber;
    private Date dateCreated;

    @ManyToOne
    @JoinColumn
    private Series series;

    public BlogPost(String title,String body, Integer seriesNumber,Date date){
        this.title = title;
        this.body = body;
        this.seriesNumber = seriesNumber;
        this.dateCreated = date;
    }

    //GETTERS
    public String getTitle(){
        return this.title;
    }
    public String getBody(){
        return this.body;
    }
    public Integer getSeriesNumber(){
        return this.seriesNumber;
    }
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
    public void setSeriesNumber(Integer seriesNumber){
        this.seriesNumber = seriesNumber;
    }
    public void  setDateCreated(Date date){
        this.dateCreated = date;
    }


}
