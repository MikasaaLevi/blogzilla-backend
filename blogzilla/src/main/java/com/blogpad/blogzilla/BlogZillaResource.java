package com.blogpad.blogzilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return new ResponseEntity<>(cuser,HttpStatus.OK);
	}
	

}
