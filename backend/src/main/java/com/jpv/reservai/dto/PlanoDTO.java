package com.jpv.reservai.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jpv.reservai.entities.Plano;
import com.jpv.reservai.enums.StatusPagamento;

public class PlanoDTO {
	
	private Long codigo;
	private int qtdeAgendamentoMensal;
	private Double preco;
	private String descricao;
	private StatusPagamento statusPagamento;
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date dataPagamento;
	

	public PlanoDTO() {}
	
	public PlanoDTO(Long codigo, int qtdeAgendamentoMensal, Double preco, String descricao, StatusPagamento statusPagamento,
			Date dataPagamento) {
		
		this.codigo = codigo;
		this.qtdeAgendamentoMensal = qtdeAgendamentoMensal;
		this.preco = preco;
		this.descricao = descricao;
		this.statusPagamento = statusPagamento;
		this.dataPagamento = dataPagamento;
	}
	
	public PlanoDTO(Plano obj) {
		this.codigo = obj.getCodigo();
		this.qtdeAgendamentoMensal = obj.getQtdeAgendamentoMensal();
		this.preco = obj.getPreco();
		this.descricao = obj.getDescricao();
		this.statusPagamento = StatusPagamento.valueOf(obj.getStatusPagamento());
		this.dataPagamento = obj.getDataPagamento();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public int getQtdeAgendamentoMensal() {
		return qtdeAgendamentoMensal;
	}

	public void setQtdeAgendamentoMensal(int qtdeAgendamentoMensal) {
		this.qtdeAgendamentoMensal = qtdeAgendamentoMensal;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	
	
	
	
}
