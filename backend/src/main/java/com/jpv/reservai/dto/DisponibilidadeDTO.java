package com.jpv.reservai.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record DisponibilidadeDTO(Long codigo, LocalDate data, LocalTime horaInicio, LocalTime horaFim) {

}
