package com.elliott.JavaLeetCodeSolutions.security.configuration;

import com.elliott.JavaLeetCodeSolutions.security.authenticationProvider.CustomAuthenticationProvider;
import com.elliott.JavaLeetCodeSolutions.security.services.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        return  new CustomUserDetailService();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public CustomAuthenticationProvider authenticationProvider(){
        return new CustomAuthenticationProvider();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin();
        http.authenticationProvider(authenticationProvider());
        http.authorizeRequests()
                .mvcMatchers("/admin/blogPost/create").hasAuthority("ADMIN");


        return http.build();
    }
//    @Bean//TODO:Change the management of CSRF tokens when scaling(pg 258 Spring Security in Action)
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.formLogin();
//        http.authorizeRequests()
//                .mvcMatchers("/profile").authenticated()
//                .mvcMatchers("/calf/add").authenticated()
//                .mvcMatchers("/calf/all").authenticated()
//                .anyRequest().permitAll();
//        http.csrf(c-> c.ignoringAntMatchers("/signup"));
//        http.authenticationProvider( authenticationProvider());
//
//
//        return http.build();
//    }
}
