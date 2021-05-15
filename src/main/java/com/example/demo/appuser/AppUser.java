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
public class AppUser implements UserDetails {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SequenceGenerator(
			name= "student_sequence",
			sequenceName= "student_sequence",
			allocationSize = 1
			)
					@Id	
					@GeneratedValue(
							strategy = GenerationType.SEQUENCE,
							generator = "student_sequence"
							)
					private long id;
					private String firstname;
					private String lastname;
					private String Email;
					private String password;
					@Enumerated(EnumType.STRING)
					private UserRole AppUserRole;
					private boolean IsLocked = false;
					private boolean enabled= false;
					@Column(name = "local_date_time", columnDefinition = "TIMESTAMP") private LocalDateTime localDateTime;

					public AppUser() {}
	
		public AppUser(String firstname, String lastname, String Email, String password, UserRole appUserRole) {
			super();
			this.firstname = firstname;
			this.lastname = lastname;
			this.Email = Email;
			this.password = password;
			AppUserRole = appUserRole;
			
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



	public String getEmail() {
		// TODO Auto-generated method stub
		return Email;
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
		return true;
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
		return enabled;
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password=password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return Email;
	}

	

	

	

	

}

	
	
