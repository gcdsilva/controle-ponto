package br.com.controle.ponto.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.ponto.entity.Usuario;
import br.com.controle.ponto.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> buscarTodos() {
		Iterable<Usuario> todos = repository.findAll();
		return toList(todos);
	}

	public <E> List<E> toList(Iterable<E> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
	}

	@Transactional
	public Usuario inserir(Usuario usuario) {
		return repository.save(usuario);
	}

	public Usuario atualizar(Usuario usuario) {
		Optional<Usuario> usu = repository.findById(usuario.getId());

		if (usu.isPresent()) {
			Usuario newEntity = usu.get();
			newEntity.setNome(usuario.getNome());
			newEntity.setCpf(usuario.getCpf());
			newEntity.setEmail(usuario.getEmail());
			newEntity.setDataCadastro(usuario.getDataCadastro());
			
			return newEntity = repository.save(newEntity);
		}
		return usuario;
	}

	public Usuario buscarPorId(Long id) {
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.get();
	}

}
