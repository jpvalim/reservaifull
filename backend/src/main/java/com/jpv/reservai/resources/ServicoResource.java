package com.jpv.reservai.resources;

import com.jpv.reservai.services.AtendenteService;
import com.jpv.reservai.services.FornecedorService;
import com.jpv.reservai.services.ServicoService;

//@RestController
//@RequestMapping(value="/servicos")
public class ServicoResource {
	
	private final ServicoService servicoService;
	private final FornecedorService fornecedorService;
	private final AtendenteService atendenteService;
	
	public ServicoResource(final ServicoService servicoService, final FornecedorService fornecedorService, final AtendenteService atendenteService) {
		this.servicoService = servicoService;
		this.fornecedorService = fornecedorService;
		this.atendenteService = atendenteService;
	}
	
	
	
}
