package kijko.forum.domain;


import org.springframework.stereotype.Component;

@Component
public class RegisterForm {
	

	private String username;
	private String password;
	private String passConfirm;
	private String email;
	
	public User createUser() {
		User u = new User();
		
		u.setLogin(username);
		u.setPassword(password);
		u.setEmail(email);
		
		return u;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassConfirm() {
		return passConfirm;
	}
	public void setPassConfirm(String passConfirm) {
		this.passConfirm = passConfirm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
