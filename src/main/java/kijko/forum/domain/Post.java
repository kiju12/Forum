package kijko.forum.domain;

import org.springframework.stereotype.Component;

@Component
public class Post {

	private long id;
	private User author;
	private String dateOfCreate;
	private String content;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public String getDateOfCreate() {
		return dateOfCreate;
	}
	public void setDateOfCreate(String dateOfCreate) {
		this.dateOfCreate = dateOfCreate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
