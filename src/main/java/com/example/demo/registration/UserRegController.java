package com.example.demo.registration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path= "api/v1/Registration")
@AllArgsConstructor
public class UserRegController {
	
	private final RegistrationService registrationService = new RegistrationService();
	 
	@PostMapping
	public String Regcontrola(@RequestBody RegistrationRequest request ) {
	
	return registrationService.register(request);
}
	
	
}
