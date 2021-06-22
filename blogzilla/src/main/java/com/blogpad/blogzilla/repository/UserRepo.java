package com.blogpad.blogzilla.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.blogpad.blogzilla.model.User;

@Repository
@EnableJpaRepositories(basePackages = "com.blogpad.blogzilla")
public interface UserRepo extends JpaRepository<User,Long>{
	
	Optional<User> findUserByUserId(Long id);
	
	Optional<User> findUserByUname(String uname);
	
	void deleteUserByUserId(Long id);
	
}
