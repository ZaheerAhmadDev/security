package com.zaheer.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @RequestMapping("/pass")
    public String hello(){
    return "hello it working";
    }

}
