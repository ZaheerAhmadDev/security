package com.zaheer.springsecurity.service;

import com.zaheer.springsecurity.model.Users;
import com.zaheer.springsecurity.repo.userepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userservice implements UserDetailsService {
    @Autowired
    private userepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user = repo.findByUsername(username);
        if (user == null) {
            System.out.println("the user not found");
            throw new UsernameNotFoundException("user not found");
        }
        return new myuserdetail(user);
    }
}
