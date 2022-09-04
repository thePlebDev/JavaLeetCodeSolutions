package com.elliott.JavaLeetCodeSolutions.security.util;

import com.elliott.JavaLeetCodeSolutions.models.Authority;
import com.elliott.JavaLeetCodeSolutions.models.Tag;
import com.elliott.JavaLeetCodeSolutions.models.User;
import com.elliott.JavaLeetCodeSolutions.repositories.TagRepository;
import com.elliott.JavaLeetCodeSolutions.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    //USERNAME AND PASSWORD
    @Value( "${admin.username}" )
    private String username;
    @Value( "${admin.password}" )
    private String password;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String...args) throws Exception {
        //CREATING ADMIN USER
//        String encryptedPassword = passwordEncoder.encode("123456789");
//        User user = new User(username,encryptedPassword,null);
//        user.setEmail("MEATB@BALL.COM");

//        this.userRepository.save(user);
        this.tagRepository.save(new Tag("EASY"));
        this.tagRepository.save(new Tag("MEDIUM"));
        this.tagRepository.save(new Tag("HARD"));
    }
}
