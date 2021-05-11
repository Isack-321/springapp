package com.example.demo.appuser;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@org.springframework.transaction.annotation.Transactional(readOnly = true)
public interface userRepo {

	Optional<Appuser> findByEmail(String email);
		
		
	
	
}
