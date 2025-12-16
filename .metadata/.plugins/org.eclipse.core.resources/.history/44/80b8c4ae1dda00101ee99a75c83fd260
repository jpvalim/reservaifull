package com.jpv.reservai.entities;

import java.util.HashSet;
import java.util.Set;

import com.jpv.reservai.enums.Perfil;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Atendente extends Usuario {
	
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")  // Chave estrangeira que referencia o fornecedor
	private Fornecedor fornecedor;
	
	@OneToMany(mappedBy = "atendente", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Disponibilidade> disponibilidades = new HashSet<>();
	
	@OneToMany(mappedBy = "atendente", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Agendamento> agendamentos = new HashSet<>();
	
	public Atendente() {
		super();
		addPerfil(Perfil.ATENDENTE);
	}
	
	public Atendente(Long codigo, String nome, String email, String endereco, String telefone, String hash) {
		super(codigo, nome, email, endereco, telefone, hash);
		addPerfil(Perfil.ATENDENTE);
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Set<Disponibilidade> getDisponibilidades() {
		return disponibilidades;
	}
	
	public Set<Agendamento> getAgendamentos() {
		return agendamentos;
	}
	
	public void addDisponibilidade(Disponibilidade disp) {
		this.disponibilidades.add(disp);
	}
	
	public void addAgendamento(Agendamento ag) {
		this.agendamentos.add(ag);
	}

	
	
}
