package com.elliott.JavaLeetCodeSolutions.repositories;

import com.elliott.JavaLeetCodeSolutions.models.Authority;
import com.elliott.JavaLeetCodeSolutions.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @Test
    public void findUserByUsernameTest(){
        //GIVEN
        String EXPECTED_USERNAME = "BOB";
        User user = new User(EXPECTED_USERNAME,"another one","meatball@sub.com",new Authority());


        //WHEN
        underTest.save(user);
        User foundUser = underTest.findUserByUsername(EXPECTED_USERNAME).get();


        //THEN
        assertThat(foundUser.getUsername()).isEqualTo(EXPECTED_USERNAME);
    }


    @Test
    public void findUserByEmail(){
        //GIVEN
        String EXPECTED_EMAIL = "BOB@BOBMAIL.COM";
        User user = new User("BOB","another one",EXPECTED_EMAIL,new Authority());

        //WHEN
        underTest.save(user);
        Optional<User> foundUser = underTest.findByEmail(EXPECTED_EMAIL);


        //THEN
        assertThat(foundUser.isPresent()).isEqualTo(true);
    }
}
