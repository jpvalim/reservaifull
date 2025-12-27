package com.jpv.reservai.services.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.jpv.reservai.dto.AtendenteDTO;
import com.jpv.reservai.dto.ClienteDTO;
import com.jpv.reservai.dto.FornecedorDTO;
import com.jpv.reservai.entities.Atendente;
import com.jpv.reservai.entities.Cliente;
import com.jpv.reservai.entities.Fornecedor;
import com.jpv.reservai.entities.Usuario;
import com.jpv.reservai.exceptions.FieldMessage;
import com.jpv.reservai.repositories.AtendenteRepository;
import com.jpv.reservai.repositories.ClienteRepository;
import com.jpv.reservai.repositories.FornecedorRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsuarioUpdateValidator implements ConstraintValidator<UsuarioUpdate, Usuario>{
	
	//para obter o parametro que vem a URL
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClienteRepository repoCli;
	
	@Autowired
	private FornecedorRepository repoFornec;
	
	@Autowired
	private AtendenteRepository repoAtend;
	
	@Override
	public void initialize(UsuarioUpdate ann) {
	}
	

	@Override
	public boolean isValid(Usuario objDto, ConstraintValidatorContext context) {
		
		//Para obter o id da URI
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Long uriId = Long.parseLong(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		if(objDto instanceof ClienteDTO) {
			Cliente aux = repoCli.findByEmailIgnoreCase(objDto.getEmail());
			if(aux != null && !aux.getCodigo().equals(uriId)) {
				list.add(new FieldMessage("email", "Email já existente"));
			}
		}
		else if(objDto instanceof FornecedorDTO) {
			Fornecedor aux = repoFornec.findByEmailIgnoreCase(objDto.getEmail());
			if(aux != null && !aux.getCodigo().equals(uriId)) {
				list.add(new FieldMessage("email", "Email já existente"));
			}
		}
		else if(objDto instanceof AtendenteDTO) {
			Atendente aux = repoAtend.findByEmailIgnoreCase(objDto.getEmail());
			if(aux != null && !aux.getCodigo().equals(uriId)) {
				list.add(new FieldMessage("email", "Email já existente"));
			}
		}
		
		
		
		//Como não existe a lista de fieldMessage no framework, esse for adiciona os erros na lista de erros do framework que vai ser tratado no exceptionHandler
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}

