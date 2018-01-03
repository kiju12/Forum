package kijko.forum.domain.repository;

import java.util.ArrayList;


import org.springframework.stereotype.Repository;
import kijko.forum.domain.User;

@Repository
public class UserRepository {

	private ArrayList<User> users = new ArrayList<>();;

	public UserRepository() {
		User u1 = new User();
		u1.setLogin("kijkowski");
		u1.setPassword("hwdp");
		
		addUser(u1);
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	
	
}
