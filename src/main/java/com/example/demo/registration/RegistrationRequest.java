package com.example.demo.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;



@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

	private final String firstname=null;
	private final String lastname=null;
	private final String email=null;
	private final String password=null;
	
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	
	
	
	
	
	
}
