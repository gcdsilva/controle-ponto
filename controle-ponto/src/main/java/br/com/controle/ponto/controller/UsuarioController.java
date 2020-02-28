package br.com.controle.ponto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.ponto.entity.Usuario;
import br.com.controle.ponto.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public List<Usuario> buscarTodos() {
		return service.buscarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable("id") Long id) {
		return new ResponseEntity<Usuario>(service.buscarPorId(id), new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(service.inserir(usuario), new HttpHeaders(), HttpStatus.CREATED);
	}

	@PatchMapping
	public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(service.atualizar(usuario), new HttpHeaders(), HttpStatus.OK);
	}

}
