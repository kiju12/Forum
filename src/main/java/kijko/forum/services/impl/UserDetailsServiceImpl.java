package kijko.forum.services.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kijko.forum.domain.Role;
import kijko.forum.domain.User;
import kijko.forum.domain.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userRepo.findByLogin(login);
		
		if(user == null) {
			throw new UsernameNotFoundException("Nie znaleziono użytkownika: " + login);
		}
		return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), convertAuth(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> convertAuth(Set<Role> roles) {
		Set<GrantedAuthority> authSet = new HashSet<>();
		for(Role r : roles) {
			authSet.add(new SimpleGrantedAuthority(r.getName()));
		}
		
		return authSet;
	}

}
