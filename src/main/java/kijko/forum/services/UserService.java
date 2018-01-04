package kijko.forum.services;

import kijko.forum.domain.User;

public interface UserService {
	void save(User user);
	User findByLogin(String login);
	User findByEmail(String email);
}
