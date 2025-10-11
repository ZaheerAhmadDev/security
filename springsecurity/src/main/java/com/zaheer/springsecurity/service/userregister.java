package com.zaheer.springsecurity.service;

import com.zaheer.springsecurity.model.Users;
import com.zaheer.springsecurity.repo.userepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userregister {
@Autowired
    private userepo repo;
@Autowired
    AuthenticationManager authmanager;
@Autowired
private  JWTservice jwTservice;

private BCryptPasswordEncoder passincoder = new BCryptPasswordEncoder(12);
    public Users register(Users user){
        user.setPassword(passincoder.encode(user.getPassword()));
     return repo.save(user);
 }

    public String verify(Users user) {
        Authentication authentication =
                authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwTservice.generatetoken(user.getUsername());
        }
        return "fail";
    }
}
