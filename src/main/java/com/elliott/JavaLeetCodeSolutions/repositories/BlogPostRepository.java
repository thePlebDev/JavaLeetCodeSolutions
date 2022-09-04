package com.elliott.JavaLeetCodeSolutions.repositories;

import com.elliott.JavaLeetCodeSolutions.models.BlogPost;
import com.elliott.JavaLeetCodeSolutions.models.Series;
import com.elliott.JavaLeetCodeSolutions.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//TODO: SWITCH ALL METHODS OVER TO DERIVED QUERY METHODS
@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost,Long> {



    @Query(value = "SELECT * FROM blogPost WHERE blogPost.id = ?1",nativeQuery = true)
    Optional<BlogPost> findBlogPostByPrimaryKey(Long id);


    @Transactional
    @Query(value = "select * from blogPost where blogPost.filter = ?1",nativeQuery = true)
    List<BlogPost> findBlogPostByFilter(String filter);


    @Query(value = "SELECT * FROM blogPost WHERE blogPost.title LIKE  %:title%",nativeQuery = true)
    List<BlogPost> findBlogPostByTitle(@Param("title") String title);

    @Query(value = "SELECT * FROM blogPost WHERE blogPost.filter = :filter AND blogPost.title LIKE  :title ",nativeQuery = true)
    List<BlogPost> findBlogPostByTitleNFilter(@Param("title") String title,@Param("filter") String filter);


    //DERIVED QUERY METHODS BELOW:


    List<BlogPost>findByTitleIgnoreCaseContaining(String title);

    // SEARCHING FOR THE TAGS
    List<BlogPost> findByTags(Tag tag);

    //SEARCH BY TAG OR TITLE
    List<BlogPost> findByTitleIgnoreCaseContainingOrTags(String title,Tag tag);

//    //FIND BY SERIES
//    List<BlogPost> findBySeries(Series series);



}
