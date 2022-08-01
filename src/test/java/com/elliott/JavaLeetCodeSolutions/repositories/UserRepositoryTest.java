package com.elliott.JavaLeetCodeSolutions.repositories;

import com.elliott.JavaLeetCodeSolutions.models.Authority;
import com.elliott.JavaLeetCodeSolutions.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @Test
    public void findUserByUsernameTest(){
        //GIVEN
        String EXPECTED_USERNAME = "BOB";
        User user = new User(EXPECTED_USERNAME,"another one",new Authority());


        //WHEN
        underTest.save(user);
        User foundUser = underTest.findUserByUsername(EXPECTED_USERNAME).get();


        //THEN
        assertThat(foundUser.getUsername()).isEqualTo(EXPECTED_USERNAME);
    }
}
