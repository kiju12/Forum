package kijko.forum.domain.forms;


import org.springframework.stereotype.Component;


@Component
public class RegisterForm {
	

	private String username;
	private String password;
	private String passConfirm;
	private String email;
	
	@Override
	public String toString() {
		return "RegisterForm [username=" + username + ", password=" + password + ", passConfirm=" + passConfirm
				+ ", email=" + email + "]";
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
