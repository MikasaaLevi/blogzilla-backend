package com.blogpad.blogzilla.exception;

public class BlogNotFoundException extends RuntimeException{
	public BlogNotFoundException(String message) {
		super(message);
	}
}
