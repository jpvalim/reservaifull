package com.jpv.reservai.services.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.jpv.reservai.dto.ClienteDTO;
import com.jpv.reservai.entities.Cliente;
import com.jpv.reservai.exceptions.FieldMessage;
import com.jpv.reservai.repositories.ClienteRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO>{
	
	//para obter o parametro que vem a URL
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteUpdate ann) {
	}
	

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		
		//Para obter o id da URI
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Long uriId = Long.parseLong(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Cliente aux = repo.findByEmailIgnoreCase(objDto.getEmail());
		if(aux != null && !aux.getCodigo().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já existente"));
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

