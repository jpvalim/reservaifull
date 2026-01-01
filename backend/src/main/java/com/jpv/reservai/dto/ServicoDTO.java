package com.jpv.reservai.dto;

import com.jpv.reservai.entities.Servico;


public class ServicoDTO{
	
	private Long codigo;
	private String descricao;
	private Double preco;
	private String descricaoUnidade;
	private Long tempoMinutos;
	private AtendenteDTO atendenteDTO;
	
	
			
	public ServicoDTO() {}
			
	public ServicoDTO(Long codigo, String descricao, Double preco, String descricaoUnidade, Long tempoMinutos, AtendenteDTO atendenteDTO) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.descricaoUnidade = descricaoUnidade;
		this.tempoMinutos = tempoMinutos;
		this.atendenteDTO = atendenteDTO;
		
	}


	public ServicoDTO(Servico obj) {
		this.codigo = obj.getCodigo();
		this.descricao = obj.getDescricao();
		this.preco = obj.getPreco();
		this.descricaoUnidade = obj.getDescricaoUnidade();
		this.tempoMinutos = obj.getTempoMinutos();
		this.atendenteDTO = new AtendenteDTO(obj.getAtendente());
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

	public AtendenteDTO getAtendenteDTO() {
		return atendenteDTO;
	}

	public void setAtendenteDTO(AtendenteDTO atendenteDTO) {
		this.atendenteDTO = atendenteDTO;
	}

	
	
		
}
