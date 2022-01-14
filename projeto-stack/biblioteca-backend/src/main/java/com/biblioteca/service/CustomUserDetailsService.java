package com.biblioteca.service;

import com.biblioteca.repository.UserRepository;
import com.biblioteca.entity.User;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> roles = new ArrayList<>();
		User user = repository.findByUsername(username);
		roles.add(new SimpleGrantedAuthority(user.getRole()));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
	}

}
