package com.rydzwr.service;

import com.rydzwr.DTO.UserDto;
import com.rydzwr.exceptions.UserWithGivenLoginAlreadyExistsException;
import com.rydzwr.exceptions.WrongUserNameOrPasswordException;
import com.rydzwr.mapper.UserMapper;
import com.rydzwr.model.User;
import com.rydzwr.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public UserDto login(UserDto userIn)
    {
        // First, I'm checking is given user in database, if not -> throwing an exception

        if (!repository.existsByUserName(userIn.getUserName()))
            throw new WrongUserNameOrPasswordException("Invalid credentials!");

        // Returning whole user data as JSON object

        User user = repository.getByUserName(userIn.getUserName());

        if (userIn.getPassword() != user.getPassword())
            throw new WrongUserNameOrPasswordException("Invalid credentials!");

        return mapper.mapToUserDto(user);
    }

    public void createUser(UserDto userDto)
    {
        // Checking for userName duplicate in database

        if (repository.existsByUserName(userDto.getUserName()))
            throw new UserWithGivenLoginAlreadyExistsException("User with given login already exists");

        // If userName is not already in use, I'm creating new userObject from given JSON and saving in database

        User newUser = mapper.mapToUser(userDto);
        repository.save(newUser);
    }
}
