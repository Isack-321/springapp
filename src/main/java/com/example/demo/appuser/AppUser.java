package com.example.demo.appuser;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.tool.schema.extract.internal.SequenceNameExtractorImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Appuser implements UserDetails {
	
					@Id
					@SequenceGenerator(
							name= "student_sequence",
							sequenceName= "student_sequence",
							allocationSize = 1
							)
					@GeneratedValue(
							strategy = GenerationType.SEQUENCE,
							generator = "student_sequence"
							)
					private long id;
					private String firstname;
					private String lastname;
					private String email;
					private String password;
					@Enumerated(EnumType.STRING)
					private UserRole AppUserRole;
					private boolean locked = false;
					private boolean enabled= false;
					@Column(name = "local_date_time", columnDefinition = "TIMESTAMP") private LocalDateTime localDateTime;

					public Appuser() {}
	
		public Appuser(String firstname, String lastname, String email, String password, UserRole appUserRole) {
			super();
			this.firstname = firstname;
			this.lastname = lastname;
			this.email = email;
			this.password = password;
			AppUserRole = appUserRole;
			this.locked = locked;
			this.enabled = enabled;
		}

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
		return email;
	}

	
	public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}

	
	
