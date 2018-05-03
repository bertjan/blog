package org.gertje.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Category category;

	private String title;

	@Column(length = 3000)
	private String content;

	@ManyToMany(cascade = {CascadeType.ALL})
	private List<Tag> tagList;

	@OneToMany
	private List<Comment> commentList;

	protected Post() {}

	public Post(String title, String content) {
		this.title = title;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Post{" +
				"id=" + id +
				", category=" + category +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", tagList=" + tagList +
				", commentList=" + commentList +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
}