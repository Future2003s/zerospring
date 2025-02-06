package com.zero.practice.service;

import com.zero.practice.dto.request.UserRequest;
import com.zero.practice.model.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<Map<String, String>> getAllUsers();

    List<User> findAllUsers();

    User createUser(UserRequest userRequest);
}
