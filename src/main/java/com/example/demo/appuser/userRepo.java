package com.example.demo.appuser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface userRepo extends JpaRepository<Appuser, Long> {

	Optional<Appuser> findByEmail(String email);
		
		
	
	
}
