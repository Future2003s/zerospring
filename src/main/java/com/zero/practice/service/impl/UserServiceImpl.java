package com.zero.practice.service.impl;


import com.zero.practice.dto.request.UserRequest;
import com.zero.practice.model.entity.User;
import com.zero.practice.repository.UserRepository;
import com.zero.practice.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Map<String, String>> getAllUsers() {
        List<Map<String, String>> rs = new ArrayList<>();
        Map<String, String> usr1 = new HashMap<>();
        usr1.put("name", "Nguyen Van A");
        rs.add(usr1);
        Map<String, String> usr2 = new HashMap<>();
        usr2.put("name", "Nguyen Van B");
        rs.add(usr2);

        return rs;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(UserRequest userRequest) {
        User user = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();

        return userRepository.save(user);
    }
}
