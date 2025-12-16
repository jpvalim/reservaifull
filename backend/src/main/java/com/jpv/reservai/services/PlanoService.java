package com.jpv.reservai.services;



import java.util.List;

import org.springframework.stereotype.Service;

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
	
	/*
	 * public Fornecedor fromDTO(FornecedorDTO objDTO) { Fornecedor obj = new
	 * Fornecedor(objDTO.getCodigo(),objDTO.getNome(),objDTO.getEmail(),objDTO.
	 * getEndereco(),objDTO.getTelefone(),
	 * objDTO.getPassword(),objDTO.getPlano(),objDTO.getRazaoSocial()); return obj;
	 * }
	 */
	
		
	
}
