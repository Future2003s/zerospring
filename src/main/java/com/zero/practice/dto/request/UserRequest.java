package com.zero.practice.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @Length(min = 5, message = "firstName minimum five character")
    String firstName;

    @Length(min = 5, message = "lastName minimum five character")
    String lastName;

    String phone;
    String desc;
    String password;
    String email;
}
