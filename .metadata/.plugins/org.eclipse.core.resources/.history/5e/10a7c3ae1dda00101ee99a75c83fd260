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
public class Agendamento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "atendente_id", nullable = false)
    private Atendente atendente;

    private LocalDate data;

    private LocalTime horaInicio;

    private LocalTime horaFim;
    
   
    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;
    
    public Agendamento() {}

	public Agendamento(Long id, Cliente cliente, Atendente atendente, LocalDate data, LocalTime horaInicio,
			Servico servico) {
		super();
		
		this.id = id;
		this.cliente = cliente;
		this.atendente = atendente;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFim = horaInicio.plusHours(servico.getTempoMinutos());
		this.servico = servico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	    

}
