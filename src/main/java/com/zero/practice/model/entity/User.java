package com.zero.practice.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Table(name = "tbl_usr")
@Entity
@AllArgsConstructor
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


    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
}
