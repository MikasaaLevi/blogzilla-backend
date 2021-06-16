package com.blogpad.blogzilla.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogpad.blogzilla.model.User;

public interface UserRepo extends JpaRepository<User,Long>{
	
	Optional<User> findUserByUserId(Long id);
	
	Optional<User> findUserByUname(String uname);
	
	void deleteUserByUserId(Long id);
	
}
