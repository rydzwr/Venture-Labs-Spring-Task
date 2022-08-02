package com.rydzwr.controller;

import com.rydzwr.DTO.UserDto;
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

    @GetMapping(value = "/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(service.login(userDto));
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto)
    {
        service.createUser(userDto);
        return ResponseEntity.ok().build();
    }
}
