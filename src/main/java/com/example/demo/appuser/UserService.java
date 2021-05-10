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
		private final userRepo userRepo;
		
		
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		return userRepo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(String.format( USER_NOT_FOUND, email)));
		
	}

}
