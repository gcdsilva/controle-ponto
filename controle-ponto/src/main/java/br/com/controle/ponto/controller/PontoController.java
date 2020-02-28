package br.com.controle.ponto.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.controle.ponto.entity.Ponto;
import br.com.controle.ponto.service.PontoService;

public class PontoController {
	
	@Autowired
	private PontoService service;
	
	/*
	 * @GetMapping("/{id}") public List<Ponto> buscarPorId(@PathVariable("nome")
	 * String nome) { return service.buscarPorId(nome); }
	 */

	public <E> List<E> toList(Iterable<E> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
	}
	
	@PostMapping()
	public ResponseEntity<Ponto> criar(@RequestBody Ponto ponto) {
		return new ResponseEntity<Ponto>(service.inserir(ponto), new HttpHeaders(), HttpStatus.CREATED);
	}
	
	


}
