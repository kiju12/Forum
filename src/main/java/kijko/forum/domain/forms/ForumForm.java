package kijko.forum.domain.forms;

import java.util.Date;

import org.springframework.stereotype.Component;

import kijko.forum.domain.Forum;

@Component
public class ForumForm {

	private String name;
	
	public Forum createForum() {
		Forum forum = new Forum();
		forum.setTitle(this.name);
		forum.setDateOfCreate(new Date());
		
		return forum;
	}
	
	@Override
	public String toString() {
		return "ForumForm [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
