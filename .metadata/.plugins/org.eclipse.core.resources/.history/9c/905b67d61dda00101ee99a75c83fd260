package com.jpv.reservai.enums;

public enum Perfil {
	CLIENTE(1, "ROLE_CLIENTE"),
	ATENDENTE(2, "ROLE_ATENDENTE"),
	FORNECEDOR(3, "ROLE_FORNECEDOR");	
	
	private Integer cod;
	private String descricao;
	
	private Perfil(int cod, String descricao) {
		this.cod=cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for(Perfil x : Perfil.values()) {
			if(x.getCod() == cod) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id Inválido: " + cod);
	}

}
