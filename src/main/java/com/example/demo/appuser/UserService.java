package com.example.demo.appuser;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.registration.Token.ConfirmationToken;
import com.example.demo.registration.Token.ConfirmationTokenService;

import lombok.AllArgsConstructor;


	@Service
	@AllArgsConstructor
public class UserService implements UserDetailsService {

		private static final String USER_NOT_FOUND ="user with email %s not found";
		private final userRepo userRepo = null;
		private final BCryptPasswordEncoder bcryptpassencod = new BCryptPasswordEncoder();
		 private final ConfirmationTokenService confirmationTokenService = new ConfirmationTokenService();
		
	@Override
	public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException{
		// TODO Auto-generated method stub
		
		return userRepo.findByEmail(Email).orElseThrow(()-> new UsernameNotFoundException(String.format( USER_NOT_FOUND, Email)));
		
	}

	
	public String signupuser(AppUser appuser) {
		
		   boolean userExists = userRepo.findByEmail(appuser.getEmail()).isPresent();
		
					if(userExists) {throw new IllegalStateException("email already in use!");}
		
			String encodedpass=	bcryptpassencod.encode(appuser.getPassword());
	
	
						appuser.setPassword(encodedpass);
						userRepo.save(appuser);
						
		 String token = UUID.randomUUID().toString();

	        ConfirmationToken confirmationToken = new ConfirmationToken(
	                token,
	                LocalDateTime.now(),
	                LocalDateTime.now().plusMinutes(15),
	                appuser
	        );

	        confirmationTokenService.saveConfirmationToken(confirmationToken);
	        return token;
	}
	        public int enableAppUser(String email)
	        {
		        return userRepo.enableAppUser(email);
		    }
	        				
	    }

	  
	    
		
		
		
	

