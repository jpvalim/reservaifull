package com.jpv.reservai.services;



import java.util.List;

import org.springframework.stereotype.Service;

import com.jpv.reservai.dto.PlanoDTO;
import com.jpv.reservai.dto.PlanoNewDTO;
import com.jpv.reservai.entities.Plano;
import com.jpv.reservai.exceptions.ObjectNotFoundException;
import com.jpv.reservai.repositories.PlanoRepository;

@Service
public class PlanoService {

	
	private final PlanoRepository planoRepo;
		
	
	public PlanoService(final PlanoRepository planoRepo) {
		this.planoRepo = planoRepo;
		
	}
	
	
	public Plano findById(Long codigoPlano) {
		return planoRepo.findById(codigoPlano).orElseThrow(() -> new ObjectNotFoundException("Plano não encontrado!" + " ID: " + codigoPlano));
		
	}
	
	public List<Plano> findAll(){
		return planoRepo.findAll();
	}
	
	public Plano save(Plano obj) {
		return planoRepo.save(obj);
	}
	
	public Plano update(Plano obj) {
		Plano newObj = findById(obj.getCodigo());
		updateData(newObj, obj);
		return planoRepo.save(newObj);
	}
	
	public void delete(Long id) {
		planoRepo.deleteById(id);;
	}


	private void updateData(Plano newObj, Plano obj) {
		newObj.setDataPagamento(obj.getDataPagamento());
		newObj.setDescricao(obj.getDescricao());
		newObj.setPreco(obj.getPreco());
		newObj.setQtdeAgendamentoMensal(obj.getQtdeAgendamentoMensal());
		newObj.setStatusPagamento(obj.getStatusPagamento());
	}


	public Plano fromDTO(PlanoNewDTO objDto) {
		Plano plan = new Plano(objDto.getCodigo(),objDto.getQtdeAgendamentoMensal(),objDto.getPreco(),objDto.getDescricao(),objDto.getStatusPagamento(), objDto.getDataPagamento());
		return plan;
	}
	
	public Plano fromDTO(PlanoDTO objDto) {
		Plano plan = new Plano(objDto.getCodigo(),objDto.getQtdeAgendamentoMensal(),objDto.getPreco(),objDto.getDescricao(),objDto.getStatusPagamento(), objDto.getDataPagamento());
		return plan;
	}
	
	
	/*
	 * public Fornecedor fromDTO(FornecedorDTO objDTO) { Fornecedor obj = new
	 * Fornecedor(objDTO.getCodigo(),objDTO.getNome(),objDTO.getEmail(),objDTO.
	 * getEndereco(),objDTO.getTelefone(),
	 * objDTO.getPassword(),objDTO.getPlano(),objDTO.getRazaoSocial()); return obj;
	 * }
	 */
	
		
	
}
