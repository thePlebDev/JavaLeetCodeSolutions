package com.elliott.JavaLeetCodeSolutions.security.services;

import com.elliott.JavaLeetCodeSolutions.models.User;
import com.elliott.JavaLeetCodeSolutions.repositories.UserRepository;
import com.elliott.JavaLeetCodeSolutions.security.models.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s = ()-> new UsernameNotFoundException("Problem during authentication");
        User u = this.userRepository.findUserByUsername(username).orElseThrow(s);
        return new AuthUser(u);
    }
}
