package com.jpv.reservai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpv.reservai.entities.Servico;


@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{
	
}
