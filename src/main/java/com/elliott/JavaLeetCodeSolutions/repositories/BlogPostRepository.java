package com.elliott.JavaLeetCodeSolutions.repositories;

import com.elliott.JavaLeetCodeSolutions.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost,Long> {

    //@Query(value = "SELECT * FROM calf WHERE calf.tag_number = ?1",nativeQuery = true)
//    @Query(value = "SELECT * FROM blogpost WHERE blogpost.title = ?1",nativeQuery = true)
//    public BlogPost

    @Transactional
    @Query(value = "select * from blogPost where blogPost.id = ?1",nativeQuery = true)
    BlogPost findBlogPostByIdIs(Long id);
}
