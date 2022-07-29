package com.rydzwr.mapper;

import com.rydzwr.DTO.UserDto;
import com.rydzwr.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper
{
    public UserDto mapToUserDto(User user)
    {
        return new UserDto(
                user.getUserId(),
                user.getUserName(),
                user.getPassword(),
                user.getPermission(),
                user.getReadonly()
        );
    }

    public User mapToUser(UserDto userDto)
    {
        return new User(
                userDto.getUserName(),
                userDto.getPassword(),
                userDto.getPermission(),
                userDto.getReadonly(),
                userDto.getPosts()
        );
    }
}
