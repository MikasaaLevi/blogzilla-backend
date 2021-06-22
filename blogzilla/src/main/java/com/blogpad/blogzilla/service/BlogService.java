package com.blogpad.blogzilla.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogpad.blogzilla.exception.BlogNotFoundException;
import com.blogpad.blogzilla.exception.UserNotFoundException;
import com.blogpad.blogzilla.model.Blog;
import com.blogpad.blogzilla.model.Category;
import com.blogpad.blogzilla.model.User;
import com.blogpad.blogzilla.repository.BlogRepo;
import com.blogpad.blogzilla.repository.CategoryRepo;
import com.blogpad.blogzilla.repository.UserRepo;


@Service
@Transactional
public class BlogService {
	
	@Autowired
	private UserRepo userRepository;
	@Autowired
	private BlogRepo blogRepository;
	@Autowired
	private CategoryRepo categoryRepository;

	/*
	 * public BlogService(UserRepo userRepository, BlogRepo blogRepository,
	 * CategoryRepo categoryRepository) { super(); this.userRepository =
	 * userRepository; this.blogRepository = blogRepository; this.categoryRepository
	 * = categoryRepository; }
	 */
	public User createUser(User user)
	{
		return userRepository.save(user);
	}
	
	public User updateUser(User user)
	{
		return userRepository.save(user);
	}
	
	public List<User> listAllUsers()
	{
		List<User> list=userRepository.findAll();
		System.out.println(list);
		return userRepository.findAll();
	}
	
	public User findUserById(long id)
	{
		return userRepository.findUserByUserId(id).orElseThrow(()-> new UserNotFoundException("Employee with id "+ id + " not found"));
	}
	
	public User findUserByUserName(String uname)
	{
		return userRepository.findUserByUname(uname).orElseThrow(()-> new UserNotFoundException("Employee with username "+ uname + " not found"));
	}
	
	public void deleteUser(long id)
	{
		userRepository.deleteUserByUserId(id);
	}
	
	//Blogs
	
	public Blog createBlog(Blog blog)
	{
		return blogRepository.save(blog);
	}
	
	public Blog updateBlog(Blog blog)
	{
		return blogRepository.save(blog);
	}
	
	public List<Blog> listAllBlogs()
	{
		return blogRepository.findAll();
	}
	
	public Blog findBlogById(long id)
	{
		return blogRepository.findBlogByBlogId(id).orElseThrow(()-> new BlogNotFoundException("Blog with id "+ id + " not found"));
	}
	
	public List<Blog> findBlogByUserName(String uname)
	{
		User user=userRepository.findUserByUname(uname).orElse(null);
		if(user != null)
		return blogRepository.findByUser(user);
		else
			return null;
	}
	
	public void deleteBlog(long id)
	{
		blogRepository.deleteBlogByBlogId(id);
	}
	
	//category
	public List<Category> findCategoryByBlogs(Set<Blog> blogs)
	{
		return categoryRepository.findByBlogsIn(blogs);
	}
}
