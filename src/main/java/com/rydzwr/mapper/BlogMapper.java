package com.rydzwr.mapper;

import com.rydzwr.DTO.BlogDto;
import com.rydzwr.model.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogMapper
{
    public Blog mapToBlog(BlogDto blogDto)
    {
        return new Blog(
                blogDto.getId(),
                blogDto.getText(),
                blogDto.getUserId()
        );
    }

    public BlogDto mapToBlogDto(Blog blog)
    {
        return new BlogDto(
                blog.getId(),
                blog.getText(),
                blog.getUserId()
        );
    }

    public List<BlogDto> mapToBlogDtoList(List<Blog> blogList)
    {
        List<BlogDto> blogDtosList = new ArrayList<>();
        for (Blog blog : blogList)
        {
            blogDtosList.add(mapToBlogDto(blog));
        }
        return blogDtosList;
    }
}
