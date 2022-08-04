package com.elliott.JavaLeetCodeSolutions.repositories;

import com.elliott.JavaLeetCodeSolutions.models.BlogPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class BlogPostRepositoryTest {

    @Autowired
    private BlogPostRepository underTest;


    @Test
    public void saveNRetrieveBlogPostTest(){
        //GIVEN
        BlogPost blogPost = new BlogPost();

        //WHEN
        underTest.save(blogPost);
        BlogPost foundBlogPost = underTest.getReferenceById(1l);

        //THEN
        assertThat(foundBlogPost.getId()).isEqualTo(1l);

    }

    @Test // H2 does not like the Lob data type
    public void findBlogPostByFilter(){
        //GIVEN
        String EXPECTED_FILTER = "DSA";
        BlogPost postOne = new BlogPost("title","body",EXPECTED_FILTER,new Date());
        BlogPost postTwo = new BlogPost("title","body",EXPECTED_FILTER,new Date());
        BlogPost postThree = new BlogPost("title","body","leetCode",new Date());

        //WHEN
        underTest.save(postOne);
        underTest.save(postTwo);
        underTest.save(postThree);
        List<BlogPost> foundBlogPosts = underTest.findBlogPostByFilter(EXPECTED_FILTER);


        //THEN
        assertThat(foundBlogPosts.size()).isEqualTo(2);


    }
}
