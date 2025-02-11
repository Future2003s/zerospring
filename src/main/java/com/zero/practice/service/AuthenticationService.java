package com.zero.practice.service;

import com.zero.practice.dto.request.AuthenticateRequest;
import com.zero.practice.model.User;

public interface AuthenticationService {
    User login(AuthenticateRequest request);
}
