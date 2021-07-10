package com.blogpad.blogzilla;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpad.blogzilla.model.Blog;
import com.blogpad.blogzilla.model.Category;
import com.blogpad.blogzilla.model.User;
import com.blogpad.blogzilla.service.BlogService;



@RestController
@RequestMapping("/blogzilla")
public class BlogZillaResource {
	
	@Autowired
	private BlogService blogService;

	/*
	 * public BlogZillaResource(BlogService blogService) { this.blogService =
	 * blogService; }
	 */
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> users=blogService.listAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addEmployee(@RequestBody User user)
	{
		User cuser=blogService.createUser(user);
		if(cuser == null)
			return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		return new ResponseEntity<>(cuser,HttpStatus.OK);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user)
	{
		User cuser=blogService.updateUser(user);
		return new ResponseEntity<>(cuser,HttpStatus.OK);
	}
	
	@GetMapping("/findUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id)
	{
		User cuser=blogService.findUserById(id);
		return new ResponseEntity<>(cuser,HttpStatus.OK);
	}
	
	@GetMapping("/findUserByUserName/{uname}") //error duplicate username
	public ResponseEntity<User> getUserByUname(@PathVariable("uname") String uname)
	{
		User cuser=blogService.findUserByUserName(uname);
		return new ResponseEntity<>(cuser,HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<User> deleteUserById(@PathVariable("id") long id)
	{
		blogService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//blogs
	@GetMapping("/blogs")
	public ResponseEntity<List<Blog>> getAllBlogs()
	{
		List<Blog> blogs=blogService.listAllBlogs();
		return new ResponseEntity<>(blogs,HttpStatus.OK);
	}
	
	@PostMapping("/addBlog") //need to work here
	public ResponseEntity<Blog> addBlog(@RequestBody Blog blog)
	{
		Blog cblog=blogService.createBlog(blog);
		return new ResponseEntity<>(cblog,HttpStatus.OK);
	}
	
	@PutMapping("/updateBlog")
	public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog)
	{
		Blog cblog=blogService.createBlog(blog);
		return new ResponseEntity<>(cblog,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteBlog/{id}")
	public ResponseEntity<Blog> deleteBlogById(@PathVariable("id") long id)
	{
		blogService.deleteBlog(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/findBlogById/{id}")
	public ResponseEntity<Blog> getBlogById(@PathVariable("id") long id)
	{
		Blog cblog=blogService.findBlogById(id);
		return new ResponseEntity<>(cblog,HttpStatus.OK);
	}
	
	@GetMapping("/findBlogsByUserName/{uname}")
	public ResponseEntity<List<Blog>> getBlogByUname(@PathVariable("uname") String uname)
	{
		List<Blog> cblogs=blogService.findBlogByUserName(uname);
		return new ResponseEntity<>(cblogs,HttpStatus.OK);
	}
	
	/*
	 * @GetMapping("/findBlogsByCategory/{category}") public
	 * ResponseEntity<List<Blog>> getBlogByCategory(@PathVariable("category") String
	 * category) { Set<Category> catset=new HashSet<>(); catset.add(category);
	 * List<Blog> cblogs=blogService.findBlogByCategory(catset); return new
	 * ResponseEntity<>(cblogs,HttpStatus.OK); }
	 */
}
