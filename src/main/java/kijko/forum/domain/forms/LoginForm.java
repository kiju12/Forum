package kijko.forum.domain.forms;

import org.springframework.stereotype.Component;

@Component
public class LoginForm {

	private String login;
	private String password;
	
	
	
	@Override
	public String toString() {
		return "LoginForm [login=" + login + ", password=" + password + "]";
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
	
	
	
}
