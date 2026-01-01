package com.jpv.reservai.resources;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jpv.reservai.dto.ServicoDTO;
import com.jpv.reservai.entities.Atendente;
import com.jpv.reservai.entities.Fornecedor;
import com.jpv.reservai.entities.Servico;
import com.jpv.reservai.services.AtendenteService;
import com.jpv.reservai.services.FornecedorService;
import com.jpv.reservai.services.ServicoService;

@RestController
@RequestMapping(value="/servicos")
public class ServicoResource {
	
	private final ServicoService servicoService;
	private final FornecedorService fornecedorService;
	private final AtendenteService atendenteService;
	
	public ServicoResource(final ServicoService servicoService, final FornecedorService fornecedorService, final AtendenteService atendenteService) {
		this.servicoService = servicoService;
		this.fornecedorService = fornecedorService;
		this.atendenteService = atendenteService;
	}
	
	@PostMapping
	public ResponseEntity<Void> insertServico(@RequestBody ServicoDTO servico){
		Fornecedor objFornecedor= fornecedorService.findById(servico.getCodFornecedor());
		System.out.println(objFornecedor.getNome());
		Atendente objAtendente = atendenteService.findById(servico.getCodAtendente());
		System.out.println(objAtendente.getNome());
		Servico objServico = servicoService.fromDTO(servico, objFornecedor, objAtendente);
		servicoService.save(objServico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objFornecedor.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
}
