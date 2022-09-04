package com.elliott.JavaLeetCodeSolutions.repositories;

import com.elliott.JavaLeetCodeSolutions.models.BlogPost;
import com.elliott.JavaLeetCodeSolutions.models.Series;
import com.elliott.JavaLeetCodeSolutions.models.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import static org.springframework.data.domain.ExampleMatcher.*;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
public class BlogPostRepositoryTest {

    @Autowired
    private BlogPostRepository underTest;

    @Autowired TagRepository tagRepository;


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

    @Test
    public void findTestByTitle(){
        //GIVEN
        String EXPECTED_TITLE = "RECURSION";
        String EXPECTED_TITLE2 = "RECURSION part 2";
        BlogPost postOne = new BlogPost(EXPECTED_TITLE,"body","EXPECTED_FILTER",new Date());
        BlogPost postTwo = new BlogPost(EXPECTED_TITLE2,"body","EXPECTED_FILTER",new Date());
        BlogPost postThree = new BlogPost("title","body","leetCode",new Date());

        //WHEN
        underTest.save(postOne);
        underTest.save(postTwo);
        underTest.save(postThree);


        List<BlogPost> blogPostList = underTest.findByTitleIgnoreCaseContaining("RECURSION");


        //THEN
        assertThat(blogPostList.size()).isEqualTo(2);
    }

    @Test //for right now, this test is not necessary
    public void findTestByTitleAndFilter(){
        //GIVEN
        String EXPECTED_TITLE = "RECURSION";
        String EXPECTED_TITLE2 = "RECURSION part 2";
        BlogPost postOne = new BlogPost(EXPECTED_TITLE,"body","EXPECTED_FILTER",new Date());
        BlogPost postTwo = new BlogPost(EXPECTED_TITLE2,"body","EXPECTED_FILTER",new Date());
        BlogPost postThree = new BlogPost("title","body","leetCode",new Date());

        //WHEN
        underTest.save(postOne);
        underTest.save(postTwo);
        underTest.save(postThree);


        List<BlogPost> blogPostList = underTest.findBlogPostByTitleNFilter(EXPECTED_TITLE,"EXPECTED_FILTER");


        //THEN
        assertThat(blogPostList.size()).isEqualTo(2);
    }

    @Test
    public void testingTags(){
        //GIVEN
        String EXPECTED_TITLE = "RECURSION";
        String EXPECTED_TAG_TITLE="EASY";

        BlogPost postOne = new BlogPost(EXPECTED_TITLE,"body","EXPECTED_FILTER",new Date());
        Tag tag = new Tag(EXPECTED_TAG_TITLE);
        postOne.addTag(tag);

        //WHEN
        underTest.save(postOne);
        int tagSize = tagRepository.findAll().size();

        //THEN
        assertThat(tagSize).isEqualTo(1);

    }

    @Test
    public void findByTag(){
        //GIVEN
        String EXPECTED_TITLE = "RECURSION";
        String EXPECTED_TAG_TITLE="EASY";

        BlogPost postOne = new BlogPost(EXPECTED_TITLE,"body","EXPECTED_FILTER",new Date());
        BlogPost postTwo = new BlogPost("MEAT BALL","body","EXPECTED_FILTER",new Date());

        Tag tag = new Tag(EXPECTED_TAG_TITLE);
        postOne.addTag(tag);
        postTwo.addTag(tag);

        //WHEN
        underTest.save(postOne);
        underTest.save(postTwo);
        List<BlogPost> foundBlogs= underTest.findByTags(tag);

        //THEN
        assertThat(foundBlogs.size()).isEqualTo(2);


    }

    @Test
    public void findByTitleOrTag(){
        //GIVEN
        String EXPECTED_TITLE = "RECURSION";
        String EXPECTED_TAG_TITLE="EASY";

        BlogPost postOne = new BlogPost(EXPECTED_TITLE,"body","EXPECTED_FILTER",new Date());
        BlogPost postTwo = new BlogPost("MEAT BALL","body","EXPECTED_FILTER",new Date());

        Tag tag = new Tag(EXPECTED_TAG_TITLE);
        postOne.addTag(tag);
        postTwo.addTag(tag);

        //WHEN
        underTest.save(postOne);
        underTest.save(postTwo);

        List<BlogPost> foundBlogs= underTest.findByTitleIgnoreCaseContainingOrTags(null,null);

        //THEN
        assertThat(foundBlogs.size()).isEqualTo(1);

    }


//    @Test
//    public void findBySeriesTest(){
//        //GIVEN
//        String EXPECTED_TITLE = "RECURSION";
//        String EXPECTED_SERIES_NAME="BOB";
//
//        Series series1 = new Series(EXPECTED_SERIES_NAME);
//        BlogPost postOne = new BlogPost(EXPECTED_TITLE,"body","EXPECTED_FILTER",new Date());
//        postOne.setSeries(series1);
//
//        //WHEN
//        underTest.save(postOne);
//        List<BlogPost> foundBlogPosts = underTest.findBySeries(series1);
//
//
//        //THEN
//        assertThat(foundBlogPosts.size()).isEqualTo(1);
//
//
//    }
}
