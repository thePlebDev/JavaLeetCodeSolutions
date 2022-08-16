package com.elliott.JavaLeetCodeSolutions.repositories;
import com.elliott.JavaLeetCodeSolutions.models.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
public class TagRepositoryTest {

    @Autowired
    private TagRepository underTest;

    @Test
    public void findTagByTitleTest(){
        //GIVEN
        String EXPECTED_TITLE = "TESTING";
        Tag tag = new Tag(EXPECTED_TITLE);

        //THEN
        underTest.save(tag);
        Tag foundTag = underTest.findByTitle(EXPECTED_TITLE);

        assertThat(foundTag.getTitle()).isEqualTo(EXPECTED_TITLE);

    }
}
