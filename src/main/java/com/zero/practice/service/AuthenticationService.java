package com.zero.practice.service;

import com.zero.practice.dto.request.AuthenticateRequest;
import com.zero.practice.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse login(AuthenticateRequest request);

}
