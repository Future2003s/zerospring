package com.zero.practice.service.impl;


import com.zero.practice.model.entity.User;
import com.zero.practice.repository.UserRepository;
import com.zero.practice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
