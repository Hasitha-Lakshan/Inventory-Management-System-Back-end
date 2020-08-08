package com.cbl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.InventoryManager;
import com.cbl.backend.model.User;

@Repository
public interface InventoryManagerRepository extends JpaRepository<InventoryManager, Integer>{
	public InventoryManager findByuser(User user);
}
