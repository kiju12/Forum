package kijko.forum.services.impl;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kijko.forum.domain.Role;
import kijko.forum.domain.User;
import kijko.forum.domain.repository.RoleRepository;
import kijko.forum.domain.repository.UserRepository;
import kijko.forum.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	

	@Override
	public void save(User user) {
		Role userRole = roleRepository.findByName("ROLE_USER");
		user.getRole().add(userRole);
		
        userRepository.save(user);
	}

	@Override
	public User findByLogin(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public ArrayList<User> findAll() {
		return (ArrayList<User>) userRepository.findAll();
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	

}
