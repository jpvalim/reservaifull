package com.jpv.reservai.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.jpv.reservai.enums.Perfil;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long codigo;
	private String nome;
	private String email;
	private String endereco;
	private String telefone;
	private String password;
	
	@ElementCollection (fetch = FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>(); 
	
	public Usuario(){}
	
	public Usuario(Long codigo, String nome, String email, String endereco, String telefone, String password) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
		this.password = password;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Perfil> getPerfis(){
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
		
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

	
	
}
