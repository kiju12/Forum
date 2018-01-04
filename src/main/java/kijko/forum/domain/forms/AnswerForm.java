package kijko.forum.domain.forms;

import java.util.Date;

import org.springframework.stereotype.Component;

import kijko.forum.domain.Post;

@Component
public class AnswerForm {

	private String content;

	public Post createPost() {
		Post post = new Post();
			post.setDateOfCreate(new Date());
			post.setContent(content);
			
		return post;
	}
	
	@Override
	public String toString() {
		return "AnswerForm [content=" + content + "]";
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
