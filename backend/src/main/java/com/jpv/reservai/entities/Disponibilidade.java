package com.jpv.reservai.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Disponibilidade {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "atendente_id", nullable = false)
	    private Atendente atendente;

	    private LocalDate data;

	    private LocalTime horaInicio;

	    private LocalTime horaFim;

	    public Disponibilidade() {}

		public Disponibilidade(Long id, Atendente atendente, LocalDate data, LocalTime horaInicio, LocalTime horaFim) {
			super();
			this.id = id;
			this.atendente = atendente;
			this.data = data;
			this.horaInicio = horaInicio;
			this.horaFim = horaFim;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Atendente getAtendente() {
			return atendente;
		}

		public void setAtendente(Atendente atendente) {
			this.atendente = atendente;
		}

		public LocalDate getData() {
			return data;
		}

		public void setData(LocalDate data) {
			this.data = data;
		}

		public LocalTime getHoraInicio() {
			return horaInicio;
		}

		public void setHoraInicio(LocalTime horaInicio) {
			this.horaInicio = horaInicio;
		}

		public LocalTime getHoraFim() {
			return horaFim;
		}

		public void setHoraFim(LocalTime horaFim) {
			this.horaFim = horaFim;
		}
		
		
		@Override
		public String toString() {
			return "Disponibilidade [id=" + id + ", atendente=" + atendente + ", data=" + data + ", horaInicio="
					+ horaInicio + ", horaFim=" + horaFim + "]";
		}
	    
	    
	
}
