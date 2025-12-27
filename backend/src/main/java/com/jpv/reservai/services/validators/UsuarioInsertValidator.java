package com.jpv.reservai.services.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jpv.reservai.dto.AtendenteNewDTO;
import com.jpv.reservai.dto.ClienteNewDTO;
import com.jpv.reservai.dto.FornecedorNewDTO;
import com.jpv.reservai.entities.Atendente;
import com.jpv.reservai.entities.Cliente;
import com.jpv.reservai.entities.Fornecedor;
import com.jpv.reservai.entities.Usuario;
import com.jpv.reservai.exceptions.FieldMessage;
import com.jpv.reservai.repositories.AtendenteRepository;
import com.jpv.reservai.repositories.ClienteRepository;
import com.jpv.reservai.repositories.FornecedorRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsuarioInsertValidator implements ConstraintValidator<UsuarioInsert, Usuario>{
	
	@Autowired
	private ClienteRepository repoCli;
	
	@Autowired
	private AtendenteRepository repoAtend;
	
	@Autowired
	private FornecedorRepository repoFornec;
	
	@Override
	public void initialize(UsuarioInsert ann) {
	}
	
	@Override
	public boolean isValid(Usuario objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		// inclua os testes aqui, inserindo erros na lista
		
		
		if (objDto instanceof ClienteNewDTO) {
			Cliente aux = repoCli.findByEmailIgnoreCase(objDto.getEmail());
			if(aux != null) {
				list.add(new FieldMessage("email", "Email já existente"));
			}
		}
		else if(objDto instanceof AtendenteNewDTO) {
			Atendente aux = repoAtend.findByEmailIgnoreCase(objDto.getEmail());
			if(aux != null) {
				list.add(new FieldMessage("email", "Email já existente"));
			}
		}
		else if(objDto instanceof FornecedorNewDTO) {
			Fornecedor aux = repoFornec.findByEmailIgnoreCase(objDto.getEmail());
			if(aux != null) {
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
