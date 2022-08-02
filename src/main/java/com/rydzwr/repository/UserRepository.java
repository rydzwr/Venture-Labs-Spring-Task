package com.rydzwr.repository;

import com.rydzwr.model.User;

import java.util.List;

public interface UserRepository
{
    List<User> findAll();
    boolean existsByUserId(Integer userId);
    User getByUserId(int userId);
    User save(User entity);
    void deleteUserByUserId(Integer userId);
    boolean existsByUserName(String userName);
    boolean existsByUserNameAndPassword(String userName, String password);
    User getUserByUserNameAndPassword(String userName, String password);
    User getByUserName(String userName);
}
