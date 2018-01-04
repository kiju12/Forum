package kijko.forum.domain.forms;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kijko.forum.domain.Role;
import kijko.forum.domain.User;
import kijko.forum.domain.repository.RoleRepository;


@Component
public class RegisterForm {
	
	@Autowired
	private RoleRepository roleRepo;

	private String username;
	private String password;
	private String passConfirm;
	private String email;
	
	@Override
	public String toString() {
		return "RegisterForm [username=" + username + ", password=" + password + ", passConfirm=" + passConfirm
				+ ", email=" + email + "]";
	}


	public User createUser() {
		User user = new User();
			user.setLogin(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setJoinDate(new Date());
		Role userRole = roleRepo.getOne(new Long(2));
			user.getRoles().add(userRole);
		
//			ArrayList<Role> roles = new ArrayList<>();
//				roles.add(new Role("USER"));
//			user.setRoles(roles);
			
		return user;
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
