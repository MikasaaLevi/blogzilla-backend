package com.blogpad.blogzilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogpad.blogzilla.model.Category;

public interface CategoryRepo extends JpaRepository<Category,Long>{

}
