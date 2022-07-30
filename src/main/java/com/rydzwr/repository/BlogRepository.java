package com.rydzwr.repository;

import com.rydzwr.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogRepository
{
    List<Blog> findAll();
    Blog save(Blog entity);
    void deleteById(Integer id);
    Blog getById(Integer postId);
}
