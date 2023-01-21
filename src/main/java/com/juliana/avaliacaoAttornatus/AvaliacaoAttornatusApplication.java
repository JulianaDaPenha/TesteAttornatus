package com.juliana.avaliacaoAttornatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.juliana.avaliacaoAttornatus.entities.Endereco;
import com.juliana.avaliacaoAttornatus.entities.Pessoa;
import com.juliana.avaliacaoAttornatus.repositories.EnderecoRepository;
import com.juliana.avaliacaoAttornatus.repositories.PessoaRepository;

@SpringBootApplication
public class AvaliacaoAttornatusApplication implements CommandLineRunner{
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoAttornatusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pessoa p1 = new Pessoa (1L, "Juliana", "09-01-1985");
		Pessoa p2 = new Pessoa (2L, "Rodrigo", "02-06-1981");
		
		Endereco end1 = new Endereco(1L,"Rua Caliandra", "255522-000", 82, "Rio de Janeiro");
		Endereco end2 = new Endereco(2L,"Rua Antonio Salema", "25547-170", 47, "Rio de Janeiro");
		
//		p1.getEnderecos().addAll(Arrays.asList(end1));
//		p2.getEnderecos().addAll(Arrays.asList(end2));
		
		pessoaRepository.save(p1);
		pessoaRepository.save(p2);
		
		enderecoRepository.save(end1);
		enderecoRepository.save(end2);
	}

}
