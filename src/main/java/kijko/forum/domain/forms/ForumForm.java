package kijko.forum.domain.forms;

import org.springframework.stereotype.Component;

@Component
public class ForumForm {

	private String name;

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
