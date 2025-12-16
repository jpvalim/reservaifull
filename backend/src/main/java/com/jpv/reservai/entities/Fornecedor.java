package com.jpv.reservai.entities;

import java.util.HashSet;
import java.util.Set;

import com.jpv.reservai.enums.Perfil;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Fornecedor extends Usuario {

	private String razaoSocial;
	private int qtdeAgendamentos;

	@OneToOne
	private Plano plano;
	
	@ManyToMany(mappedBy = "fornecedores")
    private Set<Cliente> clientes = new HashSet<>();
	
	@OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Servico> servicos = new HashSet<>();
	
	@OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Atendente> atendentes = new HashSet<>();
		
	public Fornecedor() {
		super();
		addPerfil(Perfil.FORNECEDOR);
	}
	
	public Fornecedor(Long codigo, String nome, String email, String endereco, String telefone, String razaoSocial, Plano plano, String password) {
		
		super(codigo, nome, email, endereco, telefone,password);
		this.razaoSocial = razaoSocial;
		this.plano = plano;
		this.qtdeAgendamentos = plano.getQtdeAgendamentoMensal();
		addPerfil(Perfil.FORNECEDOR);
	}

	
	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public int getQtdeAgendamentos() {
		return qtdeAgendamentos;
	}

	public void setQtdeAgendamentos(int qtdeAgendamentos) {
		this.qtdeAgendamentos = qtdeAgendamentos;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public Set<Cliente> getClientes(){
		return this.clientes;
	}


	public Set<Servico> getServico() {
		return servicos;
	}
	
	public void addCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public void addServico (Servico servico) {
		this.servicos.add(servico);
	}
	
}
