package com.jpv.reservai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpv.reservai.entities.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
	Fornecedor findByEmailIgnoreCase(String username);
}
