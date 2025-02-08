package com.zero.practice.mapper;


import com.zero.practice.dto.request.UserRequest;
import com.zero.practice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest request);

    User updateUser(@MappingTarget User user, UserRequest request);
}
