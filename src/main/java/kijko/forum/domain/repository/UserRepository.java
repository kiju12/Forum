package kijko.forum.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kijko.forum.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByLogin(String login);
	User findByEmail(String email);
}
