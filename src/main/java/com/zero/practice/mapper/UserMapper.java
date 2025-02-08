package com.zero.practice.mapper;


import com.zero.practice.dto.request.UserRequest;
import com.zero.practice.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest request);
    
}
