package kijko.forum.domain;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private Long id;
	private String login;
	private String password;
	private String email;
	
	
	public User() {
		
	}
	
	public void print() {
		System.out.println(this.id + " " + this.login + " " + this.password + " " + this.email);
	}
	
	public Long getId() {
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
