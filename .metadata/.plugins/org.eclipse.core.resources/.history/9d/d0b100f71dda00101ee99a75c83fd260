package com.jpv.reservai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpv.reservai.entities.Atendente;


@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Long>{
	Atendente findByEmailIgnoreCase(String username);
}
