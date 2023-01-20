package com.juliana.avaliacaoAttornatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.juliana.avaliacaoAttornatus.entities.Pessoa;
import com.juliana.avaliacaoAttornatus.repositories.PessoaRepository;

@SpringBootApplication
public class AvaliacaoAttornatusApplication implements CommandLineRunner{
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoAttornatusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pessoa p1 = new Pessoa (1L, "Juliana", "09-01-1985");
		Pessoa p2 = new Pessoa (2L, "Rodrigo", "02-06-1981");
		
		pessoaRepository.save(p1);
		pessoaRepository.save(p2);
	}

}
