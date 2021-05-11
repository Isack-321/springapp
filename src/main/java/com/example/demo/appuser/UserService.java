package com.example.demo.appuser;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


	@Service
	@AllArgsConstructor
public class UserService implements UserDetailsService {

		private static final String USER_NOT_FOUND ="user with email %s not found";
		private final userRepo userRepo = null;
		
		
	@Override
	public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		return userRepo.findByEmail(Email).orElseThrow(()-> new UsernameNotFoundException(String.format( USER_NOT_FOUND, Email)));
		
	}

}
