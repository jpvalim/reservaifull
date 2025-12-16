package com.jpv.reservai.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpv.reservai.entities.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{
	
	List<Agendamento> findByAtendenteCodigoAndData(Long atendenteId, LocalDate data);
}
