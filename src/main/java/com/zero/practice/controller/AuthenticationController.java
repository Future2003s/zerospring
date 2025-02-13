package com.zero.practice.controller;


import com.nimbusds.jose.JOSEException;
import com.zero.practice.dto.request.AuthenticateRequest;
import com.zero.practice.dto.request.IntrospectRequest;
import com.zero.practice.dto.response.AuthenticationResponse;
import com.zero.practice.dto.response.IntrospectResponse;
import com.zero.practice.dto.response.ResponseSuccess;
import com.zero.practice.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


@RestController
@RequestMapping("/v1/api")
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    public ResponseSuccess<AuthenticationResponse> login(@RequestBody @Valid AuthenticateRequest authenticateRequest) {
        return new ResponseSuccess<>(HttpStatus.OK, "Login SuccessFully", authenticationService.login(authenticateRequest));
    }


    @PostMapping("/token")
    public ResponseSuccess<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws JOSEException, ParseException {
        return new ResponseSuccess<>(HttpStatus.OK, "Token SuccessFully", authenticationService.introspect(request));
    }
}
