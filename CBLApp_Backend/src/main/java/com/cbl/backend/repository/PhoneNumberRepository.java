package com.cbl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cbl.backend.model.PhoneNumber;
import com.cbl.backend.model.User;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Integer> {

	public PhoneNumber[] findByuser(User user);
	public int deleteByuser(User user);
	public void deleteAllByuser(User user);
	
	
}
