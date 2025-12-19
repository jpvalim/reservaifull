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

import com.jpv.reservai.dto.PlanoDTO;
import com.jpv.reservai.dto.PlanoNewDTO;
import com.jpv.reservai.entities.Plano;
import com.jpv.reservai.services.PlanoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/planos")
public class PlanoResource {
	
	private final PlanoService PlanoService;
	
	public PlanoResource(final PlanoService PlanoService) {
		this.PlanoService = PlanoService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Plano> find(@PathVariable Long id) {
		Plano obj = PlanoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody PlanoNewDTO objDto){
		Plano obj= PlanoService.fromDTO(objDto);
		obj = PlanoService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody PlanoDTO objDto, @PathVariable Long id){
		Plano obj= PlanoService.fromDTO(objDto);
		obj.setCodigo(id);
		obj = PlanoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		PlanoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<PlanoDTO>> findAll(){
		List<Plano> listPlano = PlanoService.findAll();
		List<PlanoDTO> listDTO = listPlano.stream().map(obj -> new PlanoDTO(obj)).collect((Collectors.toList()));
		return ResponseEntity.ok().body(listDTO);
		
	}
	
}
