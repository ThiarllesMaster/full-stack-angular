package com.biblioteca.controller;

import com.biblioteca.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.entity.AuthRequest;
import com.biblioteca.util.JwtUtil;

@RestController
public class AuthenticationController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/authenticate")
	public Token generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), 
					authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Invalid username/password");
		}
		return new Token(jwtUtil.generateToken(authRequest.getUsername()));

	}
}
