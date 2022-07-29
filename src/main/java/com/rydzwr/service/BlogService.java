package com.rydzwr.service;

import com.rydzwr.DTO.BlogDto;
import com.rydzwr.DTO.UserDto;
import com.rydzwr.exceptions.NoPermissionException;
import com.rydzwr.exceptions.WrongUserNameOrPasswordException;
import com.rydzwr.mapper.BlogMapper;
import com.rydzwr.mapper.UserMapper;
import com.rydzwr.model.Blog;
import com.rydzwr.model.User;
import com.rydzwr.repository.BlogRepository;
import com.rydzwr.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService
{
    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public BlogService(BlogRepository blogRepository, BlogMapper blogMapper, UserRepository userRepository, UserMapper userMapper)
    {
        this.blogRepository = blogRepository;
        this.blogMapper = blogMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<BlogDto> getAllPosts()
    {
        return blogMapper.mapToBlogDtoList(blogRepository.findAll());
    }

    public void addPost(UserDto userDto, BlogDto blogDto)
    {
        if (!userRepository.existsByUserNameAndPassword(userDto.getUserName(), userDto.getPassword()))
            throw new WrongUserNameOrPasswordException("Wrong User Name Or Password");

        else
        {
            Blog newPost = blogMapper.mapToBlog(blogDto);
            blogRepository.save(newPost);
        }
    }

    public void deletePost(UserDto userDto, BlogDto blogDto)
    {
        if (userDto.getUserId() == blogDto.getUserId() || userDto.getPermission().equals("superuser"))
        {
            blogRepository.deleteById(blogDto.getId());
        }
        else throw new NoPermissionException("You are not allowed to remove given post");
    }
}
