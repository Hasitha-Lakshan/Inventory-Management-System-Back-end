package com.cbl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.Admin;
import com.cbl.backend.model.User;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	public Admin findByuser(User user);
	public void deleteByuser(User user);
}
