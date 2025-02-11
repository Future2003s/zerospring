package com.zero.practice.exception;


import com.zero.practice.dto.response.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleValidation(MethodArgumentNotValidException e, WebRequest request) {
        ErrorResponse err = ErrorResponse.builder()
                .error("validation")
                .message(e.getFieldError().getDefaultMessage())
                .status(BAD_REQUEST.value())
                .timestamp(new Date())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();

        return err;
    }
}
