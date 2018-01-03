package kijko.forum.domain;

import org.springframework.stereotype.Component;

@Component
public class Role {

	private long id;
	private String name;
	
	public Role(String role) {
		this.name = role;
	}
	
	public Role() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
