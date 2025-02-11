package com.zero.practice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class ResponseData<T> implements Serializable {
    final int status;
    final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    T data;
}
