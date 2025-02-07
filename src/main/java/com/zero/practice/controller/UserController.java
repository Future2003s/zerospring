package com.zero.practice.controller;


import com.zero.practice.dto.request.UserRequest;
import com.zero.practice.model.entity.User;
import com.zero.practice.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @PostMapping("/addUser")
    public User createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("/allUser")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
