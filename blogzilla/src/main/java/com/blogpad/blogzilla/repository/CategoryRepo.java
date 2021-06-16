package com.blogpad.blogzilla.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogpad.blogzilla.model.Blog;
import com.blogpad.blogzilla.model.Category;

public interface CategoryRepo extends JpaRepository<Category,Long>{

	List<Category> findByBlogsIn(Set<Blog> blogs);
}
