package com.rydzwr.DTO;

import com.rydzwr.model.Blog;

import java.util.List;

public class UserDto
{
    private int userId;
    private String userName;
    private String password;
    private String permission;
    private String readonly;
    private List<Blog> posts;

    public UserDto()
    {
    }

    public UserDto(String userName, String password, String permission, String readonly, List<Blog> posts)
    {
        this.userName = userName;
        this.password = password;
        this.permission = permission;
        this.readonly = readonly;
        this.posts = posts;
    }

    public UserDto(int userId, String userName, String password, String permission, String readonly)
    {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.permission = permission;
        this.readonly = readonly;
    }

    public UserDto(int userId, String userName, String password, String permission, String readonly, List<Blog> posts)
    {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.permission = permission;
        this.readonly = readonly;
        this.posts = posts;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPermission()
    {
        return permission;
    }

    public void setPermission(String permission)
    {
        this.permission = permission;
    }

    public String getReadonly()
    {
        return readonly;
    }

    public void setReadonly(String readonly)
    {
        this.readonly = readonly;
    }

    public List<Blog> getPosts()
    {
        return posts;
    }

    public void setPosts(List<Blog> posts)
    {
        this.posts = posts;
    }
}
