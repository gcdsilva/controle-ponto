package br.com.controle.ponto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.ponto.entity.Ponto;
import br.com.controle.ponto.repository.PontoRepository;

@Service
public class PontoService {

	@Autowired
	private PontoRepository repository;

	@Transactional
	public Ponto inserir(Ponto ponto) {
		return repository.save(ponto);
	}

	public List<Ponto> buscarPorId(String nome) {
		Iterable<Ponto> todos = repository.findAll();
		return toList(todos);
	}
	
	public <E> List<E> toList(Iterable<E> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
	}


}
