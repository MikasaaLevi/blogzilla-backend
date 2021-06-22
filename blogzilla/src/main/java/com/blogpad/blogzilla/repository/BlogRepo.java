package com.blogpad.blogzilla.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpad.blogzilla.model.Blog;
import com.blogpad.blogzilla.model.Category;
import com.blogpad.blogzilla.model.User;

@Repository
public interface BlogRepo extends JpaRepository<Blog,Long>{

	void deleteBlogByBlogId(Long blogId);
	
	List<Blog> findBlogByCategoriesIn(Set<Category> categories);
	
	List<Blog> findByUser(User user);

	Optional<Blog> findBlogByBlogId(long id);

}
