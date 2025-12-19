package com.jpv.reservai.dto;

import com.jpv.reservai.entities.Fornecedor;
import com.jpv.reservai.entities.Usuario;

public class FornecedorNewDTO extends Usuario {

	
	private String razaoSocial;
	private int qtdeAgendamentos;

	private Long planoCodigo;
	
	public FornecedorNewDTO() {}
	
	public FornecedorNewDTO(String nome, String email, String endereco, String telefone, String password, 
			String razaoSocial, int qtdeAgendamentos, Long planoCodigo) {
		
		super(null, nome, email, endereco, telefone, password);
		this.razaoSocial = razaoSocial;
		this.qtdeAgendamentos = qtdeAgendamentos;
		this.planoCodigo = planoCodigo;
	}
	
	public FornecedorNewDTO(Fornecedor obj) {
		super(obj.getCodigo(), obj.getNome(),obj.getEmail(), obj.getEndereco(), obj.getTelefone(), obj.getPassword());
		this.razaoSocial = obj.getRazaoSocial();
		this.qtdeAgendamentos = obj.getQtdeAgendamentos();
		this.planoCodigo = obj.getPlano().getCodigo();
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

	public Long getPlanoCodigo() {
		return planoCodigo;
	}

	public void setPlanoCodigo(Long plano) {
		this.planoCodigo = plano;
	}
	


}
