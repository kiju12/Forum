package kijko.forum.domain;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private long id;
	private String login;
	private String password;
	private String email;
	private String joinDate;
	private ArrayList<Thema> themas;
	private ArrayList<Post> posts;
	private ArrayList<Role> roles;
	
	public User() {
		
	}
	
	
	public String getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}


	public ArrayList<Thema> getThemas() {
		return themas;
	}


	public void setThemas(ArrayList<Thema> themas) {
		this.themas = themas;
	}


	public ArrayList<Post> getPosts() {
		return posts;
	}


	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}


	public ArrayList<Role> getRoles() {
		return roles;
	}


	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}


	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
