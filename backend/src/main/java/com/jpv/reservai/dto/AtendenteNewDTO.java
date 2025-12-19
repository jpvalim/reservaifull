package com.jpv.reservai.dto;

import com.jpv.reservai.entities.Atendente;
import com.jpv.reservai.entities.Usuario;


public class AtendenteNewDTO extends Usuario {

	private Long fornecedorId;
	
	public AtendenteNewDTO() {}
	
	public AtendenteNewDTO(String nome, String email, String endereco, String telefone, String password, Long fornecedorId) {
		super(null, nome, email, endereco, telefone, password);
		this.fornecedorId = fornecedorId;
	}
	
	public AtendenteNewDTO(Atendente obj) {
		super(obj.getCodigo(), obj.getNome(),obj.getEmail(), obj.getEndereco(), obj.getTelefone(), obj.getPassword());
		this.fornecedorId = obj.getFornecedor().getCodigo();
	}

	public Long getFornecedorId() {
		return fornecedorId;
	}

	public void setFornecedorId(Long fornecedorId) {
		this.fornecedorId = fornecedorId;
	}
	
	
}
