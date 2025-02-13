package com.zero.practice.service;

import com.nimbusds.jose.JOSEException;
import com.zero.practice.dto.request.AuthenticateRequest;
import com.zero.practice.dto.request.IntrospectRequest;
import com.zero.practice.dto.response.AuthenticationResponse;
import com.zero.practice.dto.response.IntrospectResponse;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationResponse login(AuthenticateRequest request);

    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
}
