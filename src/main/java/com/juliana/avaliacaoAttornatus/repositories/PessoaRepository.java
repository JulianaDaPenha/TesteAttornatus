package com.juliana.avaliacaoAttornatus.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.juliana.avaliacaoAttornatus.entities.Pessoa;

@Component
public class PessoaRepository {

	private Map<Long, Pessoa> map = new HashMap<>();

	public void save(Pessoa obj) {
		map.put(obj.getId(), obj);

	}

	public Pessoa findById(Long id) {
		return map.get(id);
	}

	public List<Pessoa> findAll() {
		return new ArrayList<Pessoa>(map.values());
	}
}
