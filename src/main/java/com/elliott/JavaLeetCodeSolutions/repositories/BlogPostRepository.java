package com.elliott.JavaLeetCodeSolutions.repositories;

import com.elliott.JavaLeetCodeSolutions.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost,Long>, QueryByExampleExecutor<BlogPost> {



    @Query(value = "SELECT * FROM blogPost WHERE blogPost.id = ?1",nativeQuery = true)
    Optional<BlogPost> findBlogPostByPrimaryKey(Long id);


    @Transactional
    @Query(value = "select * from blogPost where blogPost.filter = ?1",nativeQuery = true)
    List<BlogPost> findBlogPostByFilter(String filter);





}
