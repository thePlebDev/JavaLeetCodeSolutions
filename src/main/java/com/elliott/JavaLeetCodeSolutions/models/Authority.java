package com.elliott.JavaLeetCodeSolutions.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Authority extends AbstractEntity{

    private String title;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users = new HashSet<>();;

    public Authority(){}
    public Authority(String title, User user){
        this.title = title;
        this.users.add(user);
    }
    public Authority(String title){
        this.title = title;
    }

    //GETTERS
    public String getName(){
        return this.title;
    }
    public Set<User> getUser(){
        return this.users;
    }

    //SETTERS
    public void setName(String title){
        this.title = title;
    }
    public void setUser(User user){
        this.users.add(user);
    }


    //UTILITY
    public void addUser(User user){
        this.users.add(user);
        user.getAuthorities().add(this);
    }

    public void removeUser(User user){
        this.users.remove(user);
        user.getAuthorities().remove(this);
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }

        Authority other = (Authority) obj;
        return getId() != null && getId().equals(other.getId());

    }


}
