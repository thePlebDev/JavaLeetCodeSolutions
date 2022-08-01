package com.elliott.JavaLeetCodeSolutions.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Authority extends AbstractEntity{

    private String name;

    @JoinColumn
    @ManyToOne
    private User user;
    public Authority(){}
    public Authority(String name, User user){
        this.name = name;
        this.user = user;
    }

    //GETTERS
    public String getName(){
        return this.name;
    }
    public User getUser(){
        return this.user;
    }

    //SETTERS
    public void setName(String name){
        this.name = name;
    }
    public void setUser(User user){
        this.user = user;
    }


}
