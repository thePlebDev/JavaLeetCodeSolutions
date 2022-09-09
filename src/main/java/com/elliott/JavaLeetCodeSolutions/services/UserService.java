package com.elliott.JavaLeetCodeSolutions.services;

import com.elliott.JavaLeetCodeSolutions.models.Authority;
import com.elliott.JavaLeetCodeSolutions.models.User;
import com.elliott.JavaLeetCodeSolutions.repositories.AuthorityRepository;
import com.elliott.JavaLeetCodeSolutions.repositories.UserRepository;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private AuthorityRepository authorityRepository;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder,
                       AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }


//TODO: THIS SHOULD RETURN THE CUSTOMER ID THAT WE ARE PASSING TO CREATE THE SUBSCRIPTION
    //TODO: CLEAN UP THE REGISTER PAGE AND MAKE IT 100%
    public void saveUser(User user) throws StripeException {
        Customer customer = createCustomer(user.getUsername(), user.getEmail());
        user.setPassword(encryptPassword(user.getPassword()));
        user.setCustomerId(customer.getId());
        Authority foundAuth = authorityRepository.findByTitle("READ");
        user.addAuthority(foundAuth);
        userRepository.save(user);

    }


    private Customer createCustomer(String username, String email) throws StripeException {
        CustomerCreateParams params =
                CustomerCreateParams
                        .builder()
                        .setEmail(email)
                        .setName(username)
                        .build();
        Customer customer = Customer.create(params);
        return customer;

    }

    private String encryptPassword(String oldPassword){
        return this.passwordEncoder.encode(oldPassword);
    }

}
