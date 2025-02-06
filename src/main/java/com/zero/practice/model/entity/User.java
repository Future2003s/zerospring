package com.zero.practice.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Blob;

@Table(name = "tbl_usr")
@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

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

    @Lob
    Blob desc;
}
