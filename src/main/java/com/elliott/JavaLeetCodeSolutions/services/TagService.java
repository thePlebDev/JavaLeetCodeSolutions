package com.elliott.JavaLeetCodeSolutions.services;

import com.elliott.JavaLeetCodeSolutions.models.Tag;
import com.elliott.JavaLeetCodeSolutions.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }

    public List<Tag> findAllTags(){

        return this.tagRepository.findAll();

    }
}
