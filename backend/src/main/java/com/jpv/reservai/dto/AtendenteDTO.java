package com.jpv.reservai.dto;

import com.jpv.reservai.entities.Atendente;
import com.jpv.reservai.entities.Usuario;

public class AtendenteDTO extends Usuario{
	
	public AtendenteDTO() {}
	
	public AtendenteDTO(String nome, String email, String endereco, String telefone, String password) {
		super(null, nome, email, endereco, telefone, password);
	}
	
	public AtendenteDTO(Atendente obj) {
		super(obj.getCodigo(), obj.getNome(),obj.getEmail(), obj.getEndereco(), obj.getTelefone(), obj.getPassword());
	}

}
