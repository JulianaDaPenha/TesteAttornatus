package com.juliana.avaliacaoAttornatus.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.juliana.avaliacaoAttornatus.entities.Endereco;

@Component
public class EnderecoRepository {

	private Map<Long, Endereco> map = new HashMap<>();

	public Endereco save(Endereco obj) {
		return map.put(obj.getId(), obj);

	}

	public Endereco findById(Long id) {
		return map.get(id);
	}

	public List<Endereco> findAll() {
		return new ArrayList<Endereco>(map.values());
	}

}
