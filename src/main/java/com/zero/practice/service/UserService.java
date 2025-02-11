package com.zero.practice.service;

import com.zero.practice.dto.request.UserRequest;
import com.zero.practice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User createUser(UserRequest userRequest);

    User updateUser(Long id, UserRequest request);

    void deleteUser(Long id);

    User findUserById(Long id);

    Page<User> findAllUsers(Pageable pageable);


}
