package com.juliana.avaliacaoAttornatus.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.juliana.avaliacaoAttornatus.entities.Endereco;
import com.juliana.avaliacaoAttornatus.entities.Pessoa;
import com.juliana.avaliacaoAttornatus.repositories.EnderecoRepository;
import com.juliana.avaliacaoAttornatus.repositories.PessoaRepository;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> list = pessoaRepository.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
		Pessoa pessoa = pessoaRepository.findById(id);
		return ResponseEntity.ok(pessoa);

	}

	@PostMapping(value = "/cadastrar")
	public ResponseEntity<Pessoa> criarCadastro(@RequestBody Pessoa pessoa) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		pessoaRepository.save(pessoa);
		return ResponseEntity.created(uri).body(pessoa);
	}

	@PostMapping(value = "/criarEndereco/{id}")
	public Endereco criarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
		Pessoa pessoa = pessoaRepository.findById(id);
		if (endereco.getTipo().toUpperCase().equals("RESIDENCIAL")) {
			pessoa.setEnderecoResidencial(endereco);
		} else {
			pessoa.setEnderecoComercial(endereco);
		}

		pessoaRepository.save(pessoa);
		return enderecoRepository.save(endereco);
	}

	@PutMapping("/atualizarCadastro/{id}")
	public Pessoa atualizarCadastro(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@PutMapping("/atualizarEndereco/{id}")
	public Endereco atualizarEnd(@PathVariable Long id, @RequestBody Endereco endereco) {
		Pessoa pessoa = pessoaRepository.findById(id);
		if (endereco.getTipo().toUpperCase().equals("RESIDENCIAL")) {
			pessoa.setEnderecoResidencial(endereco);
		} else {
			pessoa.setEnderecoComercial(endereco);
		}

		pessoaRepository.save(pessoa);
		return enderecoRepository.save(endereco);

	}

}
