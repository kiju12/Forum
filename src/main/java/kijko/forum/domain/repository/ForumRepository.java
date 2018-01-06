package kijko.forum.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kijko.forum.domain.Forum;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Long> {
	Forum findByTitle(String title);
}
