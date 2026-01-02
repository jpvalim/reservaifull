package com.jpv.reservai.resources;

import java.net.URI;
import java.util.List;
import java.util.Set;
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

import com.jpv.reservai.dto.FornecedorDTO;
import com.jpv.reservai.dto.FornecedorNewDTO;
import com.jpv.reservai.dto.ServicoDTO;
import com.jpv.reservai.dto.ServicoNewDTO;
import com.jpv.reservai.entities.Atendente;
import com.jpv.reservai.entities.Fornecedor;
import com.jpv.reservai.entities.Servico;
import com.jpv.reservai.services.AtendenteService;
import com.jpv.reservai.services.FornecedorService;
import com.jpv.reservai.services.ServicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorResource {
	
	private final FornecedorService fornecedorService;
	private final AtendenteService atendenteService;
	private final ServicoService servicoService;
	
	
	public FornecedorResource(final FornecedorService fornecedorService, final ServicoService servicoService, final AtendenteService atendenteService) {
		this.fornecedorService = fornecedorService;
		this.atendenteService = atendenteService;
		this.servicoService = servicoService;
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Fornecedor> find(@PathVariable Long id) {
		Fornecedor obj = fornecedorService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody FornecedorNewDTO objDto){
		Fornecedor obj= fornecedorService.fromDTO(objDto);
		obj = fornecedorService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody FornecedorDTO objDto, @PathVariable Long id){
		Fornecedor obj= fornecedorService.fromDTO(objDto);
		obj.setCodigo(id);
		obj = fornecedorService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		fornecedorService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<FornecedorDTO>> findAll(){
		List<Fornecedor> listFornecedor = fornecedorService.findAll();
		List<FornecedorDTO> listDTO = listFornecedor.stream().map(obj -> new FornecedorDTO(obj)).collect((Collectors.toList()));
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	//Servicos
	
	@PostMapping(value = "/{id}/servicos")
	public ResponseEntity<Void> insertServico(@PathVariable Long id , @RequestBody ServicoNewDTO servico){
		Fornecedor objFornecedor= fornecedorService.findById(id);
		Atendente objAtendente = atendenteService.findById(servico.getCodAtendente());
		Servico objServico = servicoService.fromDTO(servico, objFornecedor, objAtendente);
		servicoService.save(objServico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objFornecedor.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value="/{id}/servicos")
	public ResponseEntity<List<ServicoDTO>> findAllServicos (@PathVariable Long id){
		Set<Servico> meusServicos =  fornecedorService.findById(id).getServico();
		List<ServicoDTO> listDTO = meusServicos.stream().map(obj -> new ServicoDTO(obj)).collect((Collectors.toList()));
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@GetMapping (value = "/{id}/servicos/{cod_servico}")
	public ResponseEntity<ServicoDTO> findServicoById(@PathVariable Long cod_servico){
		Servico servico = servicoService.findById(cod_servico);
		ServicoDTO obj = new ServicoDTO(servico);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PutMapping(value = "/{id}/servicos/{cod_servico}")
	public ResponseEntity<Void> updateServico (@PathVariable Long id,@PathVariable Long cod_servico ,@RequestBody ServicoNewDTO obj){
		Fornecedor objFornecedor= fornecedorService.findById(id);
		Atendente objAtendente = atendenteService.findById(obj.getCodAtendente());
		Servico objServico = servicoService.fromDTO(obj, objFornecedor, objAtendente);
		objServico.setCodigo(cod_servico);
		servicoService.update(objServico);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}/servicos/{cod_servico}")
	public ResponseEntity<Void> deleteServico(@PathVariable Long id, @PathVariable Long cod_servico){
		Fornecedor objFornecedor= fornecedorService.findById(id);
		for (Servico obj : objFornecedor.getServico()) {
			if(obj.getCodigo() == cod_servico) {
				objFornecedor.getServico().remove(obj);
				break;
			}
		}
		
		fornecedorService.save(objFornecedor);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
}
