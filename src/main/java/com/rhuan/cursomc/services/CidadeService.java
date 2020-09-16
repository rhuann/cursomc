package com.rhuan.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhuan.cursomc.domain.Cidade;
import com.rhuan.cursomc.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;

	public List<Cidade> findCidades(Integer id) {
		return repo.findAllByEstado_id(id);
	}

}
