package com.elliott.JavaLeetCodeSolutions.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {
    //default implementations of equals() and hashCode() work for now

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    //GETTERS
    public Long getId() {
        return id;
    }

    //SETTERS
    private void setId(Long id){
        this.id = id;
    }
}
