package com.blogpad.blogzilla.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogpad.blogzilla.model.Blog;
import com.blogpad.blogzilla.model.Category;
import com.blogpad.blogzilla.model.User;

public interface BlogRepo extends JpaRepository<Blog,Long>{

	void deleteBlogByBlogId(Long blogId);
	
	List<Blog> findBlogByCategoriesIn(Set<Category> categories);
	
	List<Blog> findByUser(User user);
}
