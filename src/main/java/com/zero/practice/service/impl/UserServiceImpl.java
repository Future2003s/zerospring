package com.zero.practice.service.impl;


import com.zero.practice.dto.request.UserRequest;
import com.zero.practice.mapper.UserMapper;
import com.zero.practice.model.User;
import com.zero.practice.repository.UserRepository;
import com.zero.practice.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserRequest request) {
        User findUser = userRepository.findById(id).orElseThrow();
        userMapper.updateUser(findUser, request);
        return userRepository.save(findUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("ERR"));
    }

    @Override
    public Page<User> findAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
