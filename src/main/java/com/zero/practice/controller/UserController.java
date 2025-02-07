package com.zero.practice.controller;


import com.zero.practice.dto.request.UserRequest;
import com.zero.practice.model.entity.User;
import com.zero.practice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("/allUser")
    public List<Map<String, String>> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/allUsers")
    public List<User> getAllUser(@RequestBody UserRequest request) {
        log.info("OKKKK");
        System.out.println("this is body >>>>" + request.getEmail());
        return userService.findAllUsers();
    }
}
