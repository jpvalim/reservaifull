package com.jpv.reservai.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpv.reservai.dto.DisponibilidadeDTO;
import com.jpv.reservai.services.DisponibilidadeService;

@RestController
@RequestMapping (value = "/disponibilidades")
public class DisponibilidadeResource {
	
	@Autowired
	private DisponibilidadeService dispoService;
	
	@GetMapping(value="/{id_atendente}")
	public ResponseEntity<List<DisponibilidadeDTO>> findMyDisponibilidades(@PathVariable Long id_atendente){
		List<DisponibilidadeDTO> disponibilidades = dispoService.findAll(id_atendente);
		
		return ResponseEntity.ok().body(disponibilidades);
		
	}
	
	
}
