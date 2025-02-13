package com.zero.practice.dto.response;


import com.zero.practice.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class AuthenticationResponse {
    User user;
    String token;
    Map<String, Object> data;
    boolean authenticated;
}
