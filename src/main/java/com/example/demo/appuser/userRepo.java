package com.example.demo.appuser;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface userRepo {

	Optional<Appuser> findByEmail(String email);
		
		
	
	
}
