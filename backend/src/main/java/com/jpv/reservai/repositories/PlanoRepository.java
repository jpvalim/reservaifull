package com.jpv.reservai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpv.reservai.entities.Plano;


@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long>{
	
}
