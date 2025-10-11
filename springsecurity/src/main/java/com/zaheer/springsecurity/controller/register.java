package com.zaheer.springsecurity.controller;

import com.zaheer.springsecurity.model.Users;
import com.zaheer.springsecurity.service.userregister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class register {
    @Autowired
    private userregister reg;
    @PostMapping("/register")
    public Users reg(@RequestBody Users user){
        return reg.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody  Users user){

           return reg.verify(user);
    }

}
