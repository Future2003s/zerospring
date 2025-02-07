package com.zero.practice.service;

import com.zero.practice.dto.request.UserRequest;
import com.zero.practice.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User createUser(UserRequest userRequest);

    void deleteUser(Long id);
}
