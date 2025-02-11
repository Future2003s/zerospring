package com.zero.practice.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public class ResponseSuccess<T> extends ResponseEntity<ResponseSuccess.Payload<T>> implements Serializable {

    public ResponseSuccess(HttpStatus status, String message) {
        super(new Payload<T>(status.value(), message), status);
    }

    public ResponseSuccess(HttpStatus status, String message, T data) {
        super(new Payload<T>(status.value(), message, data), status);
    }


    @Getter
    @Setter
    @RequiredArgsConstructor
    public static class Payload<T> {
        private final int statusCode;
        private final String message;
        T data;


        public Payload(int statusCode, String message, T data) {
            this.statusCode = statusCode;
            this.message = message;
            this.data = data;
        }

    }
}
