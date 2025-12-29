package com.jpv.reservai.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jpv.reservai.dto.ServicoDTO;
import com.jpv.reservai.dto.ServicoNewDTO;
import com.jpv.reservai.entities.Servico;
import com.jpv.reservai.services.ServicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/servicos")
public class ServicoResource {
	
	private final ServicoService servicoService;
	
	public ServicoResource(final ServicoService servicoService) {
		this.servicoService = servicoService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Servico> find(@PathVariable Long id) {
		Servico obj = servicoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody ServicoNewDTO objDto){
		Servico obj= servicoService.fromDTO(objDto);
		obj = servicoService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody ServicoDTO objDto, @PathVariable Long id){
		Servico obj= servicoService.fromDTO(objDto);
		obj.setCodigo(id);
		obj = servicoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		servicoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<ServicoDTO>> findAll(){
		List<Servico> listServico = servicoService.findAll();
		List<ServicoDTO> listDTO = listServico.stream().map(obj -> new ServicoDTO(obj)).collect((Collectors.toList()));
		return ResponseEntity.ok().body(listDTO);
		
	}
	
}
