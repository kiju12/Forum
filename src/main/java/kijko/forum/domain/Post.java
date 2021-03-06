package kijko.forum.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Post implements Comparable<Post> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "dateOfCreate")
	private Date dateOfCreate;
	
	@Column(name = "content")
	private String content;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="author_id")
	private User author;
	
	
	
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Date getDateOfCreate() {
		return dateOfCreate;
	}
	public void setDateOfCreate(Date dateOfCreate) {
		this.dateOfCreate = dateOfCreate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public int compareTo(Post post) {
		if(this.getDateOfCreate().before(post.getDateOfCreate())) {
			return -1;
		} else if(this.getDateOfCreate().after(post.getDateOfCreate())) {
			return 1;
		}
		
		return 0;
	}
	
	
}
