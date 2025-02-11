package com.zero.practice.service.impl;

import com.zero.practice.dto.request.AuthenticateRequest;
import com.zero.practice.exception.AppException;
import com.zero.practice.exception.ErrorCode;
import com.zero.practice.model.User;
import com.zero.practice.repository.UserRepository;
import com.zero.practice.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    UserRepository userRepository;


    @Override
    public User login(AuthenticateRequest request) {
        User user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.USERNAME_INVALID));


        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean checkPassword = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!checkPassword) {
            throw new AppException(ErrorCode.PASSWORD_INCORRECT);
        }

        return user;
    }
}
