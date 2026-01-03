package com.jpv.reservai.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpv.reservai.entities.Atendente;
import com.jpv.reservai.entities.Disponibilidade;

@Repository
public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Long> {

    List<Disponibilidade> findByAtendenteCodigoAndData(Long atendenteId, LocalDate data);
    List<Disponibilidade> findByAtendenteCodigo (Long id_atendente);
}