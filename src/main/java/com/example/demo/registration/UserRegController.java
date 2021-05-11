package com.example.demo.registration;

import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties.Registration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path= "api/v1/Registration")
@AllArgsConstructor
public class UserRegController {
	
	
public String Regcontrola(@RequestBody Registration request ) {
	
	return registrationService.regRequest(request);
}
	
	
}
