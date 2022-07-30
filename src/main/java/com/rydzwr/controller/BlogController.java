package com.rydzwr.controller;

import com.rydzwr.DTO.BlogDto;
import com.rydzwr.DTO.UserDto;
import com.rydzwr.service.BlogService;
import com.rydzwr.service.PasswordAuth;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController
{
    private final BlogService service;

    public BlogController(BlogService service)
    {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BlogDto>> getAllPosts()
    {
        return ResponseEntity.ok(service.getAllPosts());
    }

    @PostMapping(value = "/add/{userName}")
    public ResponseEntity<Void> addPost(
            @PathVariable String userName,
            @RequestBody BlogDto blogDto,
            @RequestHeader("Authorization") String auth)
    {
        String password = PasswordAuth.getInstance().passwordFromAuthHeader(auth);
        service.addPost(userName, password, blogDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete/{postId}")
    public ResponseEntity<Void> deletePost(@RequestBody UserDto userDto, @PathVariable int postId)
    {
        service.deletePost(userDto, postId);
        return ResponseEntity.ok().build();
    }
}
