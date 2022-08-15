package com.elliott.JavaLeetCodeSolutions.security.util;

import com.elliott.JavaLeetCodeSolutions.models.Authority;
import com.elliott.JavaLeetCodeSolutions.models.User;
import com.elliott.JavaLeetCodeSolutions.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    }
}
