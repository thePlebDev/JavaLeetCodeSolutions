package com.elliott.JavaLeetCodeSolutions.security.services;

import com.elliott.JavaLeetCodeSolutions.models.User;
import com.elliott.JavaLeetCodeSolutions.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignupService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public SignupService(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Optional<String> signupUser(User user, String secondPassword){
        String oldPassword = user.getPassword();

        if(!usernameFound(user.getUsername())){
            return Optional.of("Username taken");
        }

        if(!emailFound(user.getEmail())){
            return Optional.of("Email already in use");
        }

        if(secondPassword.equals(oldPassword)){
            String encodedPassword = bCryptPasswordEncoder.encode(oldPassword);
            user.setPassword(encodedPassword);
            userRepository.save(user);
            return Optional.empty();
        }else{
            return Optional.of("Passwords do not match");
        }


    }

    private Boolean usernameFound(String username){
        Optional<User> foundUser = userRepository.findUserByUsername(username);
        return foundUser.isEmpty();
    }
    private Boolean emailFound(String email){
        Optional<User> emailUser = userRepository.findByEmail(email);
        return emailUser.isEmpty();
    }
}
