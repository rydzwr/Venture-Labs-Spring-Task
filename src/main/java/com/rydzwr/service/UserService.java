package com.rydzwr.service;

import com.rydzwr.DTO.UserDto;
import com.rydzwr.exceptions.UserWithGivenLoginAlreadyExistsException;
import com.rydzwr.exceptions.WrongUserNameOrPasswordException;
import com.rydzwr.mapper.UserMapper;
import com.rydzwr.model.User;
import com.rydzwr.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UserDto login(String login, String password)
    {
        if (!repository.existsByUserNameAndPassword(login, password))
            throw new WrongUserNameOrPasswordException("User with given login or password not found");
        else
        {
            User user = repository.getUserByUserNameAndPassword(login, password);
            return mapper.mapToUserDto(user);
        }
    }

    public boolean createUser(UserDto userDto)
    {
        if (repository.existsByUserName(userDto.getUserName()))
        {
            throw new UserWithGivenLoginAlreadyExistsException("User with given login already exists");
        }
        else
        {
            User newUser = mapper.mapToUser(userDto);
            repository.save(newUser);
            return true;
        }
    }
}
