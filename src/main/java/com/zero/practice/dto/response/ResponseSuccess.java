package com.zero.practice.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseSuccess extends ResponseEntity<ResponseSuccess.Payload> {

    public ResponseSuccess(HttpStatus status, String message) {
        super(new Payload(status.value(), message), status);
    }

    public ResponseSuccess(HttpStatus status, String message, Object data) {
        super(new Payload(status.value(), message, data), status);
    }


    @Getter
    @Setter
    @RequiredArgsConstructor
    public static class Payload {
        private final int statusCode;
        private final String message;
        Object data;


        public Payload(int statusCode, String message, Object data) {
            this.statusCode = statusCode;
            this.message = message;
            this.data = data;
        }

    }
}
