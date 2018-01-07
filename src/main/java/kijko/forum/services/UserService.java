package kijko.forum.services;

import java.util.ArrayList;

import kijko.forum.domain.User;

public interface UserService {
	void save(User user);
	User findByLogin(String login);
	User findByEmail(String email);
	ArrayList<User> findAll();
	void deleteUser(User user);
}
