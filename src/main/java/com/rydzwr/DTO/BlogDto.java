package com.rydzwr.DTO;

public class BlogDto
{
    private int id;
    private String text;
    private int userId;

    public BlogDto()
    {
    }

    public BlogDto(int id, String text, int userId)
    {
        this.id = id;
        this.text = text;
        this.userId = userId;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
