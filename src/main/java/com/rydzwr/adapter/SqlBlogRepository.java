package com.rydzwr.adapter;

import com.rydzwr.model.Blog;
import com.rydzwr.model.User;
import com.rydzwr.repository.BlogRepository;
import com.rydzwr.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SqlBlogRepository extends BlogRepository, JpaRepository<Blog, Integer>
{

}
