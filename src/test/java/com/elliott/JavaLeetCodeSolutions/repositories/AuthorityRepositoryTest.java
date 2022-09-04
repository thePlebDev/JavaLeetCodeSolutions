package com.elliott.JavaLeetCodeSolutions.repositories;

import com.elliott.JavaLeetCodeSolutions.models.Authority;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class AuthorityRepositoryTest {

    @Autowired
    private AuthorityRepository underTest;


    @Test
    public void findAuthorityByTitle(){
        //GIVEN
        String EXPECTED_TITLE = "READ";
        Authority auth = new Authority(EXPECTED_TITLE);

        //WHEN
        underTest.save(auth);

        Authority foundAuth = underTest.findByTitle(EXPECTED_TITLE);

        //THEN
        assertThat(foundAuth.getName()).isEqualTo(EXPECTED_TITLE);


    }
}
