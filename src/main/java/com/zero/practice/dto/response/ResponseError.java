package com.zero.practice.dto.response;

public class ResponseError extends ResponseData<Object> {
    public ResponseError(int status, String message) {
        super(status, message);
    }
}
