package com.elliott.JavaLeetCodeSolutions.security.util;

import com.elliott.JavaLeetCodeSolutions.models.Authority;
import com.elliott.JavaLeetCodeSolutions.models.User;
import com.elliott.JavaLeetCodeSolutions.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String...args) throws Exception {
        String password = "12345";
        User admin = new User("bob",password, new Authority());
        admin.setPassword(passwordEncoder.encode(password));

        userRepository.save(admin);
    }
}
