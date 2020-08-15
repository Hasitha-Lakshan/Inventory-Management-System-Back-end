package com.cbl.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.Shops;

@Repository
public interface ShopRepository extends JpaRepository<Shops, Integer>{

	List<Shops> findByShopName(String shopName);
}