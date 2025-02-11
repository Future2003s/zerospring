package com.zero.practice.dto.response;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Builder
public class ErrorResponse implements Serializable {
    Date timestamp;
    int status;
    String path;
    String error;
    String message;
}
