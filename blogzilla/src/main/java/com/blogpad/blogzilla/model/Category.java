package com.blogpad.blogzilla.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long cid;
	private String cname;
	@ManyToMany(mappedBy = "categories")
	private Set<Blog> blogs;
	
	
	public Category() {
		super();
	}
	public Category(Long cid, String cname, Set<Blog> blogs) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.blogs = blogs;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Blog> getBlogs() {
		return blogs;
	}
	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", blogs=" + blogs + "]";
	}
	
}
