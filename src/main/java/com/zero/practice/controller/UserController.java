package com.zero.practice.controller;


import com.zero.practice.dto.request.UserRequest;
import com.zero.practice.dto.response.ResponseSuccess;
import com.zero.practice.model.User;
import com.zero.practice.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;


    @GetMapping("/getAll")
    public Page<User> getAll(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String id,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ?
                Sort.Direction.ASC : Sort.Direction.DESC;

        Sort sortBy = Sort.by(sortDirection, id);

        Pageable pageable = PageRequest.of(page, size, sortBy);
        log.info(String.valueOf(sortBy));

        return userService.findAllUsers(pageable);
    }

    @PostMapping("/addUser")

    public User createUser(@RequestBody @Valid UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("/allUser")
    public ResponseSuccess getAllUsers() {
        return new ResponseSuccess(HttpStatus.OK, "Get All User SuccessFully", userService.getAllUsers());
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable(name = "id") @Min(value = 1) Long id,
                           @RequestBody UserRequest request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        log.info("Delete active user {}", id);
    }

    @GetMapping("/user")
    public User getUser(@RequestParam(name = "id") Long id) {
        return userService.findUserById(id);
    }

}
