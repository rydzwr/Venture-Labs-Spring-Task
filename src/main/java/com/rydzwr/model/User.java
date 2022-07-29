package com.rydzwr.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @NotNull
    private int userId;

    @NotNull
    private String userName;

    @NotNull
    private String password;

    @NotNull
    private String permission;

    @NotNull
    private String readonly;

    @OneToMany(mappedBy = "userId")
    private List<Blog> posts;

    public User()
    {
    }

    public User(String userName, String password, String permission, String readonly, List<Blog> posts)
    {
        this.userName = userName;
        this.password = password;
        this.permission = permission;
        this.readonly = readonly;
        this.posts = posts;
    }

    public User(int userId, String userName, String password, String permission, String readonly, List<Blog> posts)
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
