package com.rydzwr.service;

import com.rydzwr.DTO.BlogDto;
import com.rydzwr.DTO.UserDto;
import com.rydzwr.exceptions.IdNotFoundException;
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

    public void addPost(String userName, String password, BlogDto blogDto)
    {
        if (!userRepository.existsByUserNameAndPassword(userName, password))
            throw new WrongUserNameOrPasswordException("Wrong User Name Or Password");

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
        try
        {
            Blog blog = blogRepository.getById(postId);
            User user = userRepository.getUserByUserNameAndPassword(userDto.getUserName(), userDto.getPassword());

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
