<<<<<<< HEAD
package com.cbl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.SalesProduct;

@Repository 
public interface ProductRepository extends JpaRepository<SalesProduct, Integer>{
	
=======
package com.cbl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.Product;

@Repository 
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
>>>>>>> 2846202df6ab3f42c1f825654bf42426e7a3baaf
}