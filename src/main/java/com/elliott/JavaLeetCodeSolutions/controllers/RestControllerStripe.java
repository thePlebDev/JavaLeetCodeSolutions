package com.elliott.JavaLeetCodeSolutions.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class RestControllerStripe {

    @GetMapping("/config")
    public Map<String, Object> configStripe(){
        System.out.println("INSIDE OF THE CONFIG");
        System.out.println("INSIDE OF THE CONFIG");
        System.out.println("INSIDE OF THE CONFIG");

        Map<String, Object> responseData = new HashMap<>();
        String stripeKey = "pk_test_VXyyQFowid4YOcK4QRXsb7PG";
        responseData.put("publishableKey",stripeKey);
        return responseData;
    }
}
