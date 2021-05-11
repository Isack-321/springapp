package com.example.demo.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class RegRequest {

	private final String firstname = "";
	private final String lastname = "";
	private final String email = "";
	private final String password = "";
}
