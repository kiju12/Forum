package kijko.forum.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kijko.forum.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
