package com.example.demo.registration;

import org.springframework.stereotype.Service;

import com.example.demo.appuser.UserRole;
import com.example.demo.appuser.UserService;

import com.example.demo.appuser.Appuser;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {
	
	private UserService userservice;
	private final Emailvalidator emailvalidator = new Emailvalidator();
	
	public  String register(RegistrationRequest request)
	{
		// TODO Auto-generated method stub
		
		
		boolean IsvalidEmail = emailvalidator.test(request.getEmail() );

				if(!IsvalidEmail) {
					
					throw new IllegalStateException ("not a valid email");
				}

		
					return userservice.signupuser(
							
							new Appuser (
											request.getFirstname(),
											request.getLastname(),
											request.getEmail(),
											request.getPassword(),
									UserRole.USER
									)
								
							
							);
	}

}
