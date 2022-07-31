package com.elliott.JavaLeetCodeSolutions.repositories;

import com.elliott.JavaLeetCodeSolutions.models.BlogPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
}
