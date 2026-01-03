package com.jpv.reservai.config;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jpv.reservai.entities.Atendente;
import com.jpv.reservai.entities.Disponibilidade;
import com.jpv.reservai.entities.Fornecedor;
import com.jpv.reservai.entities.Plano;
import com.jpv.reservai.entities.Servico;
import com.jpv.reservai.enums.StatusPagamento;
import com.jpv.reservai.repositories.AtendenteRepository;
import com.jpv.reservai.repositories.DisponibilidadeRepository;
import com.jpv.reservai.repositories.FornecedorRepository;
import com.jpv.reservai.repositories.PlanoRepository;
import com.jpv.reservai.repositories.ServicoRepository;

@Configuration
public class TestDabase implements CommandLineRunner{
	
	DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");

	@Autowired
	private PlanoRepository planoRepo;
	
	@Autowired
	private FornecedorRepository fornecedorRepo;
	
	@Autowired
	private AtendenteRepository atendenteRepo;
	
	@Autowired
	private ServicoRepository servicoRepo;
	
	@Autowired
	private DisponibilidadeRepository dispoRepo;
	
	@Value("${spring.profiles.active}")
	String profile;

	
	@Override
	public void run(String... args) throws Exception {
		if(profile.equals("test")) {
			Plano free = new Plano(null, 15, 0.0, "FREE", StatusPagamento.FREE, null);
			planoRepo.save(free);
			
			Fornecedor fornecedor1 = new Fornecedor(null, "Jeff Valim", "jpvalim@hotmail.com", "Rua das flores, 155", "199981515", "JPV-Info", free, "jpv123");
			fornecedorRepo.save(fornecedor1);
			
			Atendente atend1 = new Atendente(null, "Zé atendente", "jose@gmail.com", "Rua dos atendentes, 134", "1999332323", "jpv123", fornecedor1);
			atendenteRepo.save(atend1);

			Servico serv1 = new Servico(null, "Corte de cabelo", 35.0, "Corte", atend1, fornecedor1, 40L);
			servicoRepo.save(serv1);
			
			Disponibilidade dispAtend1 = new Disponibilidade(null, atend1, LocalDate.parse("03/01/2026", formatterDate) , LocalTime.parse("08:00",formatterTime), LocalTime.parse("12:00",formatterTime));
			dispoRepo.save(dispAtend1);
			

		}
		
		
	}

}
