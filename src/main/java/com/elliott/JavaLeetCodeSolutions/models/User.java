package com.elliott.JavaLeetCodeSolutions.models;



import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name="users")//TODO: add the hashcode and equals()
public class User extends AbstractEntity{

    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    private Boolean paid;

    @ManyToMany
    private Set<Authority> authorities = new HashSet<>();


    public User(String username,String password,String email,Authority authority){
        this.username = username;
        this.password = password;
        this.email = email;
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
    public Set<Authority> getAuthorities(){
        return this.authorities;
    }
    public Boolean getPaided(){return this.paid;}
    public String getEmail(){return this.email;}

    //SETTERS
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setPaid(Boolean paid){this.paid = paid;}
    public void setEmail(String email){
        this.email = email;
    }


    //UTILITY
    public void addAuthority(Authority auth){
        this.authorities.add(auth);
        auth.getUser().add(this);
    }
    public void removeAuth(Authority auth){
        this.authorities.remove(auth);
        auth.getUser().remove(this);
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

        User other = (User) obj;
        return getId() != null && getId().equals(other.getId());

    }

}
