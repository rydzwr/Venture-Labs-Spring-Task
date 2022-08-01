package com.rydzwr.service;

import com.rydzwr.DTO.BlogDto;
import com.rydzwr.DTO.UserDto;
import com.rydzwr.exceptions.IdNotFoundException;
import com.rydzwr.exceptions.NoPermissionException;
import com.rydzwr.exceptions.WrongUserNameOrPasswordException;
import com.rydzwr.mapper.BlogMapper;
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

    public BlogService(BlogRepository blogRepository, BlogMapper blogMapper, UserRepository userRepository)
    {
        this.blogRepository = blogRepository;
        this.blogMapper = blogMapper;
        this.userRepository = userRepository;
    }

    public List<BlogDto> getAllPosts()
    {
        return blogMapper.mapToBlogDtoList(blogRepository.findAll());
    }

    public void addPost(String userName, String password, BlogDto blogDto)
    {
        // At first I need to check is given user valid

        if (!userRepository.existsByUserNameAndPassword(userName, password))
            throw new WrongUserNameOrPasswordException("Wrong User Name Or Password");

            // if true I'm creating newPost object and sets userId again
            // just to be sure, and to avoid frontend invalid data problems
            // Then saves valid object in database

        else
        {
            User user = userRepository.getUserByUserNameAndPassword(userName, password);
            Blog newPost = blogMapper.mapToBlog(blogDto);
            newPost.setUserId(user.getUserId());
            blogRepository.save(newPost);
        }
    }

    public void deletePost(UserDto userDto, int postId)
    {
        // I'm wrapping everything in "try-catch" to throw custom exception when
        // given postId is not in database, I could use Optional when returning blog from repository,
        // but assumed it's better solution

        try
        {
            Blog blog = blogRepository.getById(postId);
            User user = userRepository.getUserByUserNameAndPassword(userDto.getUserName(), userDto.getPassword());

            // Then checking is user trying to remove his post or user is an admin

            if (user.getUserId() == blog.getUserId() || user.getPermission().equals("superuser"))
            {
                blogRepository.deleteById(blog.getId());
            }
            else throw new NoPermissionException("You are not allowed to remove given post");
        }
        catch (Exception e)
        {
            throw  new IdNotFoundException("Post with given ID not found");
        }
    }
}
