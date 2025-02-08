package com.zero.practice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Table(name = "tbl_usr")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends AbstractEntity {
    @Column(name = "firstName", columnDefinition = "varchar(255) comment 'first name'")
    String firstName;

    @Column(name = "lastName", columnDefinition = "varchar(255) comment 'lastName'")
    String lastName;

    @Column(name = "fullName", columnDefinition = "varchar(255) comment 'fullName'")
    String fullName;

    @Column(name = "phone", columnDefinition = "varchar(255) comment 'phone'")
    String phone;

    @Column(name = "email", columnDefinition = "varchar(255) comment 'email'")
    String email;

    @Column(name = "password", columnDefinition = "varchar(255) comment 'password'")
    String password;
}
