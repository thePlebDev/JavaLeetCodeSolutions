package com.elliott.JavaLeetCodeSolutions.models;



import com.elliott.JavaLeetCodeSolutions.util.customValidators.Length;
import com.elliott.JavaLeetCodeSolutions.util.customValidators.SizeTwo;

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
    @SizeTwo(min = 99,max= 1000, message = "MEATBALL")
    private String password;
    @NotNull
    private String email;

    private String customerId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_authority",
                joinColumns = {@JoinColumn(name="fk_user")},
                inverseJoinColumns = {@JoinColumn(name="fk_authority")})
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
    public String getEmail(){return this.email;}
    public String getCustomerId(){return this.customerId;}

    //SETTERS
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setCustomerId(String customerId){this.customerId = customerId;}


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
