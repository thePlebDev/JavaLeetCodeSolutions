package com.elliott.JavaLeetCodeSolutions.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name="users")
public class User extends AbstractEntity{

    private String username;
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Authority> authorities = new ArrayList<>();

    public User(String username,String password,Authority authority){
        this.username = username;
        this.password = password;
        this.authorities.add(authority);
    }
    public User(){}

    //GETTERS
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public List<Authority> getAuthorities(){
        return this.authorities;
    }

    //SETTERS
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void addAuthority(Authority auth){
        this.authorities.add(auth);
    }
}
