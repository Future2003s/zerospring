package com.zero.practice.controller;


import com.zero.practice.dto.request.UserRequest;
import com.zero.practice.model.entity.User;
import com.zero.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api")
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
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

    @GetMapping("/allUsers")
    public List<User> getAllUser() {
        return userService.findAllUsers();
    }
}
