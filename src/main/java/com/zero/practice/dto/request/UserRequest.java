package com.zero.practice.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    String firstName;

    String lastName;

    String fullName;

    String phone;
    String desc;
    String password;
    String email;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
