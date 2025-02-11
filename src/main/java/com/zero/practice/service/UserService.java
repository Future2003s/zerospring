package com.zero.practice.service;

import com.zero.practice.dto.request.UserRequest;
import com.zero.practice.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User createUser(UserRequest userRequest);

    User updateUser(Long id, UserRequest request);

    void deleteUser(Long id);

    User findUserById(Long id);
}
