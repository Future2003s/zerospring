package com.zero.practice.service.impl;


import com.zero.practice.dto.request.UserRequest;
import com.zero.practice.mapper.UserMapper;
import com.zero.practice.model.entity.User;
import com.zero.practice.repository.UserRepository;
import com.zero.practice.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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

        findUser.setFirstName(request.getFirstName());
        findUser.setLastName(request.getLastName());
        findUser.setEmail(request.getEmail());
        findUser.setFullName(request.getFullName());

        return userRepository.save(findUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
