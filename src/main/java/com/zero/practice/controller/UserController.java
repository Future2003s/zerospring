package com.zero.practice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String getHello() {
        return "<h1>Hello world;</h1>";
    }
}
