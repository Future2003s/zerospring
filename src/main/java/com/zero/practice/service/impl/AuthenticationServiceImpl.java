package com.zero.practice.service.impl;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.zero.practice.dto.request.AuthenticateRequest;
import com.zero.practice.dto.response.AuthenticationResponse;
import com.zero.practice.exception.AppException;
import com.zero.practice.exception.ErrorCode;
import com.zero.practice.model.User;
import com.zero.practice.repository.UserRepository;
import com.zero.practice.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    UserRepository userRepository;


    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;

    @Override

    public AuthenticationResponse login(AuthenticateRequest request) {
        User user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.USERNAME_INVALID));


        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean checkPassword = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!checkPassword) {
            throw new AppException(ErrorCode.PASSWORD_INCORRECT);
        }

        log.info("TOKEN: {}", generateToken(request.getEmail()));

        String token = generateToken(request.getEmail());


        return AuthenticationResponse.builder()
                .user(user)
                .token(token)
                .build();
    }

    private String generateToken(String email) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(email)
                .issuer("adadasd")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("userId", "Custom")
                .build();


        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
