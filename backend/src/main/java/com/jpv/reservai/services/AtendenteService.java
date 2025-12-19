package com.jpv.reservai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jpv.reservai.dto.AtendenteDTO;
import com.jpv.reservai.dto.AtendenteNewDTO;
import com.jpv.reservai.entities.Atendente;
import com.jpv.reservai.exceptions.ObjectNotFoundException;
import com.jpv.reservai.repositories.AtendenteRepository;

@Service
public class AtendenteService {

	
	private final AtendenteRepository atendenteRepo;
	private final FornecedorService fornecedorService;
	
	public AtendenteService(final AtendenteRepository userRepository, FornecedorService fornecedorService) {
		this.atendenteRepo = userRepository;
		this.fornecedorService = fornecedorService;
	
	}
	
	
	public Atendente findById(Long codigoAtendente) {
		return atendenteRepo.findById(codigoAtendente).orElseThrow(() -> new ObjectNotFoundException("Atendente não encontrado!" + " ID: " + codigoAtendente));
		
	}
	
	public Atendente save(Atendente objAtendente) {
		return atendenteRepo.save(objAtendente);
	}
	
	public Atendente fromDTO(AtendenteDTO objDTO) {
		Atendente obj = new Atendente(objDTO.getCodigo(),objDTO.getNome(),objDTO.getEmail(),objDTO.getEndereco(),objDTO.getTelefone(), objDTO.getPassword(), fornecedorService.findById(objDTO.getFornecedorId()));
		return obj;
	}
	
	public Atendente fromDTO(AtendenteNewDTO objDTO) {
		Atendente cli  =  new Atendente(null, objDTO.getNome(),objDTO.getEmail(),objDTO.getEndereco(),objDTO.getTelefone(),objDTO.getPassword(), fornecedorService.findById(objDTO.getFornecedorId()));
		return cli;
		
	}


	public Atendente update(Atendente obj) {
		Atendente newObj = findById(obj.getCodigo());
		updateData(newObj, obj);
		return atendenteRepo.save(newObj);
	}

	public void delete(Long id) {
		atendenteRepo.deleteById(id);
	}
	
	
	private void updateData(Atendente newObj, Atendente obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setEndereco(obj.getEndereco());
		newObj.setNome(obj.getNome());
		newObj.setPassword(obj.getPassword());
		newObj.setTelefone(obj.getTelefone());
		
	}


	public List<Atendente> findAll() {
		
		return atendenteRepo.findAll();
	}
	
	
	
		
	
}
