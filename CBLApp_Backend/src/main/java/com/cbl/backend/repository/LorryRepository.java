package com.cbl.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.Lorry;

@Repository
public interface LorryRepository extends JpaRepository<Lorry, Integer>{

	Optional<Lorry> findByLorryID(int lorryID);
}

