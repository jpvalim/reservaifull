package com.jpv.reservai.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpv.reservai.entities.Agendamento;
import com.jpv.reservai.entities.Disponibilidade;
import com.jpv.reservai.repositories.AgendamentoRepository;
import com.jpv.reservai.repositories.DisponibilidadeRepository;

@Service
public class DisponibilidadeService {

    @Autowired
    private DisponibilidadeRepository disponibilidadeRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public List<Disponibilidade> sugerirHorariosDisponiveis(Long atendenteCodigo, LocalDate data) {
        // Buscar todas as disponibilidades do atendente para a data
        List<Disponibilidade> disponibilidades = disponibilidadeRepository.findByAtendenteCodigoAndData(atendenteCodigo, data);

        // Buscar todos os agendamentos feitos nesse dia
        List<Agendamento> agendamentos = agendamentoRepository.findByAtendenteCodigoAndData(atendenteCodigo, data);

        // Filtrar as disponibilidades removendo aquelas que estão ocupadas
        return disponibilidades.stream()
                .filter(disponibilidade -> agendamentos.stream().noneMatch(agendamento ->
                        agendamento.getHoraInicio().isBefore(disponibilidade.getHoraFim()) &&
                        agendamento.getHoraFim().isAfter(disponibilidade.getHoraInicio())))
                .collect(Collectors.toList());
    }
}