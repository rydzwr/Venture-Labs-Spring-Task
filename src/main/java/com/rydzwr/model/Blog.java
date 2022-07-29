package com.rydzwr.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "blogs")
public class Blog
{
    @Id
    @NotNull
    private int id;

    @NotNull
    private String text;

    @NotNull
    private int userId;

    public Blog()
    {
    }

    public Blog(String text, int userId)
    {
        this.text = text;
        this.userId = userId;
    }

    public Blog(int id, String text, int userId)
    {
        this.id = id;
        this.text = text;
        this.userId = userId;
    }

    public int getId()
    {
        return id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }
}
