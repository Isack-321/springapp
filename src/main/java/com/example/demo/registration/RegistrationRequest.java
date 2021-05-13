package com.example.demo.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;



@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

	private final String firstname ="";
	private final String lastname = "";
	private final String email = "";
	private final String password = "";
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