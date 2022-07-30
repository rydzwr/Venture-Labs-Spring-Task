package com.rydzwr.controller;

import com.rydzwr.DTO.UserDto;
import com.rydzwr.service.PasswordAuth;
import com.rydzwr.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{
    private final UserService service;

    public UserController(UserService service)
    {
        this.service = service;
    }

    @GetMapping(value = "/login/{userName}")
    public ResponseEntity<UserDto> login(@PathVariable String userName, @RequestHeader("Authorization") String auth)
    {
        String password = PasswordAuth.getInstance().passwordFromAuthHeader(auth);
        return ResponseEntity.ok(service.login(userName, password));
    }

    @PostMapping
    public ResponseEntity<Boolean> createUser(@RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(service.createUser(userDto));
    }
}
