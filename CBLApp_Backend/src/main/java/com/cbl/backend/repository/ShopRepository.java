package com.cbl.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.Shops;
import com.cbl.backend.model.User;

@Repository
public interface ShopRepository extends JpaRepository<Shops, Integer>{

	Optional<User> findByShopname(String shopName);
}