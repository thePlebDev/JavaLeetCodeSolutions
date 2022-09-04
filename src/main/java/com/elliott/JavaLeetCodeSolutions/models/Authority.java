package com.elliott.JavaLeetCodeSolutions.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Authority extends AbstractEntity{

    private String title;

    @JoinColumn
    @ManyToOne
    private User user;
    public Authority(){}
    public Authority(String title, User user){
        this.title = title;
        this.user = user;
    }
    public Authority(String title){
        this.title = title;
    }

    //GETTERS
    public String getName(){
        return this.title;
    }
    public User getUser(){
        return this.user;
    }

    //SETTERS
    public void setName(String title){
        this.title = title;
    }
    public void setUser(User user){
        this.user = user;
    }


}
