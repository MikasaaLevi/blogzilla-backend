package com.blogpad.blogzilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogpad.blogzilla.model.Blog;

public interface BlogRepo extends JpaRepository<Blog,Long>{

}
