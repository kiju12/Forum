package kijko.forum.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kijko.forum.domain.Forum;

public interface ForumRepository extends JpaRepository<Forum, Long> {
	
	Forum findByTitle(String title);
}
