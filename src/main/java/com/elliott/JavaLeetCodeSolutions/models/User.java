package com.elliott.JavaLeetCodeSolutions.models;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity(name="users")
public class User extends AbstractEntity{

    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    private Boolean paided;

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
    public Boolean getPaided(){return this.paided;}
    public String getEmail(){return this.email;}

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
    public void setPaided(Boolean paided){this.paided = paided;}
    public void setEmail(String email){
        this.email = email;
    }
}
