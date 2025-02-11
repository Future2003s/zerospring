package com.zero.practice.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest implements Serializable {
    @Length(min = 5, message = "firstName minimum 5 character")
    String firstName;
    String lastName;
    String fullName;
    String phone;
    String desc;
    String password;
    String email;
}
