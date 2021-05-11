package com.example.demo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.appuser.UserService;

import lombok.AllArgsConstructor;


@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class Websecurityconfig extends WebSecurityConfigurerAdapter {

	
	private final UserService userservice = new UserService();
	private final BCryptPasswordEncoder bcryptpassencod = new BCryptPasswordEncoder();
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/Api/v*/registration/**")
				.permitAll()
				.anyRequest()
				.authenticated().and()
				.formLogin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(DaoAuthenticationProvider());
	}

	
	@Bean
	DaoAuthenticationProvider DaoAuthenticationProvider() {
		DaoAuthenticationProvider daop= new org.springframework.security.authentication.dao.DaoAuthenticationProvider();
		daop.setPasswordEncoder(bcryptpassencod);
		daop.setUserDetailsService(userservice);
		
		return daop;
		
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
