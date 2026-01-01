package com.jpv.reservai.dto;

import org.hibernate.validator.constraints.Length;

import com.jpv.reservai.entities.Servico;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public class ServicoNewDTO {

	private Long codigo;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 120, message= "O tamanho deve ser entre 5 e 120 caracteres")
	private String descricao;
	@NotNull(message = "O preço é obrigatório")
	private Double preco;
	private String descricaoUnidade;
	private Long tempoMinutos;
			
	public ServicoNewDTO() {}
				
	public ServicoNewDTO(Long codigo, String descricao, Double preco, String descricaoUnidade, Long tempoMinutos) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.descricaoUnidade = descricaoUnidade;
		this.tempoMinutos = tempoMinutos;
	}


	public ServicoNewDTO(Servico obj) {
		this.codigo = obj.getCodigo();
		this.descricao = obj.getDescricao();
		this.preco = obj.getPreco();
		this.descricaoUnidade = obj.getDescricaoUnidade();
		this.tempoMinutos = obj.getTempoMinutos();
	}


	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public Long getTempoMinutos() {
		return tempoMinutos;
	}

	public void setTempoMinutos(Long tempoMinutos) {
		this.tempoMinutos = tempoMinutos;
	}
	
}
