package com.blogpad.blogzilla.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "bloguser")
@Table(name = "bloguser")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long userId;
	@Column(nullable = false, unique = true)
	private String uname;
	@Column(nullable = false, unique = true)
	private String email;
	private String phoneNo;
	@Column(nullable = false)
	private String password;
	private String role;
	private String dob;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Blog> blogs;

	public User() {
		super();
	}

	public User(Long uid, String uname, String email, String phoneNo, String password, String role, String dob,
			Set<Blog> blogs) {
		super();
		this.userId = uid;
		this.uname = uname;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
		this.role = role;
		this.dob = dob;
		this.blogs = blogs;
	}

	public Long getuserId() {
		return this.userId;
	}

	public void setuserId(Long userId) {
		this.userId = userId;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Set<Blog> getBlogs() {
		return this.blogs;
	}

	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", uname=" + uname + ", email=" + email + ", phoneNo=" + phoneNo + ", password="
				+ password + ", role=" + role + ", dob=" + dob + "]";
	}
	
}
