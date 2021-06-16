package com.blogpad.blogzilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogpad.blogzilla.model.User;

public interface UserRepo extends JpaRepository<User,Long>{
	
}
