package com.capgemini.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.project.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	@Query("SELECT COUNT(u) FROM User u WHERE u.userType = :userType")
	public long userCount(String userType);

	Optional<User> findByEmail(String email);

	Optional<User> findByNameOrEmail(String username, String email);

	Optional<User> findByName(String username);

	boolean existsByName(String username);

	boolean existsByEmail(String email);

}
