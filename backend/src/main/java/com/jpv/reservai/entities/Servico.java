package com.jpv.reservai.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Servico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long Codigo;
	private String descricao;
	private Double preco;
	private String descricaoUnidade;
	private Long tempoMinutos;
	
	@OneToOne
	private Atendente atendente;
	
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")  // Chave estrangeira que referencia o fornecedor
	private Fornecedor fornecedor;
	
	@OneToMany(mappedBy = "servico", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Agendamento> agendamentos = new HashSet<>();	
	
	public Servico() {}
	
	public Servico(Long codigo, String descricao, Double preco, String descricaoUnidade, Atendente atendente, Fornecedor fornecedor, Long tempoMinutos) {
		super();
		Codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.descricaoUnidade = descricaoUnidade;
		this.atendente = atendente;
		this.fornecedor = fornecedor;
		this.tempoMinutos = tempoMinutos;
	}

	public Long getCodigo() {
		return Codigo;
	}

	public void setCodigo(Long codigo) {
		Codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricaoUnidade() {
		return descricaoUnidade;
	}

	public void setDescricaoUnidade(String descricaoUnidade) {
		this.descricaoUnidade = descricaoUnidade;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}
	
	public Set<Agendamento> getAgendamentos(){
		return this.agendamentos;
	}

	public Long getTempoMinutos() {
		return tempoMinutos;
	}

	public void setTempoMinutos(Long tempoMinutos) {
		this.tempoMinutos = tempoMinutos;
	}
	
	
	
	
	
}
