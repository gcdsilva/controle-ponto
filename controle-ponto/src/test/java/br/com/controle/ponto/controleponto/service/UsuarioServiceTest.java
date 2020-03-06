package br.com.controle.ponto.controleponto.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.controle.ponto.entity.Usuario;
import br.com.controle.ponto.repository.UsuarioRepository;
import br.com.controle.ponto.service.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class UsuarioServiceTest {

	@Autowired
	private UsuarioService service;

	@MockBean
	UsuarioRepository usuarioRepository;
	
	@Test
	public void deveBuscarTodosSucesso() {
		
		when(usuarioRepository.findAll()).thenReturn(getListaUsuarios());
		List<Usuario> listaUsuario = service.buscarTodos();

		assertNotNull(listaUsuario);
		assertFalse(listaUsuario.isEmpty());
	}

	@Test
	public void deveBuscarPorIdSucesso() {
		
		when(usuarioRepository.findById(anyLong())).thenReturn(getUsuarioOptional());
		Usuario usu = service.buscarPorId(Long.parseLong("10"));

		assertNotNull(usu);
		assertEquals("10", usu.getId().toString());
	}

	private Optional<Usuario> getUsuarioOptional() {
		
		return getListaUsuarios().stream().findFirst();
	}

	@Test
	public void deveInserirSucesso() {
		
		when(usuarioRepository.save(any())).thenReturn(getUsuario());
		
		Usuario usu = service.inserir(any());
		assertEquals("93614580008", usu.getCpf());
	}

	@Test
	public void deveAtualizarSucesso() {
	
		Usuario usu = service.atualizar(getUsuarioAtualizado());
		assertEquals("93614580003", usu.getCpf());
	}


	private Usuario getUsuario() {
		Usuario usuario = new Usuario();
		usuario.setId(Long.parseLong("10"));
		usuario.setCpf("93614580008");
		usuario.setNome("Guilherme");
		usuario.setEmail("ggg@gmail.com");
		usuario.setDataCadastro(new Date());

		return usuario;
	}
	
	private Usuario getUsuarioAtualizado() {
		Usuario usuario = new Usuario();
		usuario.setId(Long.parseLong("10"));
		usuario.setCpf("93614580003");
		usuario.setNome("Teste");
		usuario.setEmail("ggg@gmail.com");
		usuario.setDataCadastro(new Date());

		return usuario;
	}
	
	

	private List<Usuario> getListaUsuarios() {

		List<Usuario> listaUsuario = new ArrayList<Usuario>();

		listaUsuario.add(getUsuario());
		return listaUsuario;
	}

}
