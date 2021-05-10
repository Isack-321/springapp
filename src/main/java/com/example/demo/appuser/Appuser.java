package com.example.demo.appuser;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Appuser implements UserDetails {
	
	@Getter
	@Setter
	@NoArgsConstructor
	@EqualsAndHashCode
	private long id;
	private String username;
	private String email;
	private String password;
	private UserRole AppUserRole;
	private boolean locked;
	private boolean enabled;

	
	public Appuser(String username, String email, String password, UserRole appUserRole, boolean locked,
			boolean enabled) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		AppUserRole = appUserRole;
		this.locked = locked;
		this.enabled = enabled;}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		SimpleGrantedAuthority simpgrant= new SimpleGrantedAuthority(AppUserRole.name());
		return Collections.singletonList(simpgrant);
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

}
