package com.elliott.JavaLeetCodeSolutions.models;

import com.sun.xml.bind.annotation.OverrideAnnotationOf;
import jdk.jfr.Enabled;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Series extends AbstractEntity{

    @NaturalId
    @Column(unique=true)
    private String title;

    @OneToMany(mappedBy = "series")
    private List<BlogPost> posts = new ArrayList<>();

    public Series() {
    }

    public Series(String title){
        this.title = title;
    }


    //GETTERS
    public String getTitle(){
        return this.title;
    }

    public List<BlogPost> getPosts() {
        return posts;
    }

    //SETTERS
    public void setTitle(String title){
        this.title = title;
    }
    public void addPost(BlogPost post){
        this.posts.add(post);
    }

   @Override
   public int hashCode() {
       return Objects.hashCode(title);
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
        Series other = (Series) obj;
        return Objects.equals(title,other.getTitle());
   }
}
