package com.blogpad.blogzilla.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Blog")
public class Blog implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bid", nullable = false, updatable = false)
	private Long blogId;
	@Lob
	private String blogContent;
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	private String comments;
	private String editedOn;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userId", nullable = false)
	private User user;
	@ManyToMany
	@JoinTable(
			  name = "blog_category", 
			  joinColumns = @JoinColumn(name = "blogId"), 
			  inverseJoinColumns = @JoinColumn(name = "cid"))
	private Set<Category> categories;
	
	
	public Blog() {
		super();
	}
	public Blog(Long blogId,String blogContent, String comments, String editedOn, User user, Set<Category> categories) {
		super();
		this.blogId = blogId;
		this.comments = comments;
		this.editedOn = editedOn;
		this.user = user;
		this.categories = categories;
		this.blogContent = blogContent;
	}
	public Long getBlogId() {
		return blogId;
	}
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getEditedOn() {
		return editedOn;
	}
	public void setEditedOn(String editedOn) {
		this.editedOn = editedOn;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", comments=" + comments + ", editedOn=" + editedOn + ", user=" + user
				+ ", categories=" + categories + "]";
	}
	
}
