package com.biblioteca.repository;

import com.biblioteca.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);

}
