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

import com.jpv.reservai.dto.AtendenteDTO;
import com.jpv.reservai.dto.AtendenteNewDTO;
import com.jpv.reservai.entities.Atendente;
import com.jpv.reservai.services.AtendenteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/atendentes")
public class AtendenteResource {
	
	private final AtendenteService atendenteService;
	
	public AtendenteResource(final AtendenteService atendenteService) {
		this.atendenteService = atendenteService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Atendente> find(@PathVariable Long id) {
		Atendente obj = atendenteService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody AtendenteNewDTO objDto){
		Atendente obj= atendenteService.fromDTO(objDto);
		obj = atendenteService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody AtendenteDTO objDto, @PathVariable Long id){
		Atendente obj= atendenteService.fromDTO(objDto);
		obj.setCodigo(id);
		obj = atendenteService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		atendenteService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<AtendenteDTO>> findAll(){
		List<Atendente> listatendente = atendenteService.findAll();
		List<AtendenteDTO> listDTO = listatendente.stream().map(obj -> new AtendenteDTO(obj)).collect((Collectors.toList()));
		return ResponseEntity.ok().body(listDTO);
		
	}
	
}
