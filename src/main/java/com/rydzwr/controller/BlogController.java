package com.rydzwr.controller;

import com.rydzwr.DTO.BlogDto;
import com.rydzwr.DTO.UserDto;
import com.rydzwr.service.BlogService;
import com.rydzwr.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController
{
    private final BlogService service;
    private final UserService userService;

    public BlogController(BlogService service, UserService userService)
    {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<BlogDto>> getAllPosts()
    {
        return ResponseEntity.ok(service.getAllPosts());
    }

    @PostMapping(value = "/{userId}")
    public ResponseEntity<Void> addPost(@RequestBody BlogDto blogDto, @PathVariable int userId)
    {
        service.addPost(userId, blogDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePost(@RequestParam int userId, @RequestParam int postId)
    {
        service.deletePost(userId, postId);
        return ResponseEntity.ok().build();
    }
}
