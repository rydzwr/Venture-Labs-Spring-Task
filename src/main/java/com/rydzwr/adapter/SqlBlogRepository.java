package com.rydzwr.adapter;

import com.rydzwr.model.Blog;
import com.rydzwr.repository.BlogRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlBlogRepository extends BlogRepository, JpaRepository<Blog, Integer>
{
}
