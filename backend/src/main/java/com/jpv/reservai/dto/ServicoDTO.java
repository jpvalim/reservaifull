package com.jpv.reservai.dto;

import com.jpv.reservai.entities.Servico;


public class ServicoDTO{
	
	private Long codigo;
	private String descricao;
	private Double preco;
	private String descricaoUnidade;
	private Long tempoMinutos;
	private Long codAtendente;
	private Long codFornecedor;
	
			
	public ServicoDTO() {}
			
	public ServicoDTO(Long codigo, String descricao, Double preco, String descricaoUnidade, Long tempoMinutos, Long codAtendente, Long codFornecedor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.descricaoUnidade = descricaoUnidade;
		this.tempoMinutos = tempoMinutos;
		this.codAtendente = codAtendente;
		this.codFornecedor = codFornecedor;
		
	}


	public ServicoDTO(Servico obj) {
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

	public Long getCodAtendente() {
		return codAtendente;
	}

	public void setCodAtendente(Long codAtendente) {
		this.codAtendente = codAtendente;
	}

	public Long getCodFornecedor() {
		return codFornecedor;
	}

	public void setCodFornecedor(Long codFornecedor) {
		this.codFornecedor = codFornecedor;
	}

	
		
}
