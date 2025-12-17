package com.jpv.reservai.services;



import org.springframework.stereotype.Service;

import com.jpv.reservai.dto.ClienteDTO;
import com.jpv.reservai.dto.ClienteNewDTO;
import com.jpv.reservai.entities.Cliente;
import com.jpv.reservai.exceptions.ObjectNotFoundException;
import com.jpv.reservai.repositories.ClienteRepository;

@Service
public class ClienteService {

	
	private final ClienteRepository clienteRepo;
	
	
	
	
	
	public ClienteService(final ClienteRepository userRepository) {
		this.clienteRepo = userRepository;
	
	}
	
	
	public Cliente findById(Long codigoCliente) {
		return clienteRepo.findById(codigoCliente).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado!" + " ID: " + codigoCliente));
		
	}
	
	public Cliente save(Cliente objCliente) {
		return clienteRepo.save(objCliente);
	}
	
	public Cliente fromDTO(ClienteDTO objDTO) {
		Cliente obj = new Cliente(objDTO.getCodigo(),objDTO.getNome(),objDTO.getEmail(),objDTO.getEndereco(),objDTO.getTelefone(), objDTO.getPassword());
		return obj;
	}
	
	public Cliente fromDTO(ClienteNewDTO objDTO) {
		Cliente cli  =  new Cliente(null, objDTO.getNome(),objDTO.getEmail(),objDTO.getEndereco(),objDTO.getTelefone(),objDTO.getPassword());
		return cli;
		
	}


	public Cliente update(Cliente obj) {
		Cliente newObj = findById(obj.getCodigo());
		updateData(newObj, obj);
		return clienteRepo.save(newObj);
	}


	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setEndereco(obj.getEndereco());
		newObj.setNome(obj.getNome());
		newObj.setPassword(obj.getPassword());
		newObj.setTelefone(obj.getTelefone());
		
	}
	
	
		
	
}
