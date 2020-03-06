package br.com.controle.ponto.controleponto.controller;

import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.controle.ponto.controller.UsuarioController;
import br.com.controle.ponto.entity.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UsuarioControllerTest {

	@Autowired
	public MockMvc mockMvc;

	@MockBean
	private UsuarioController usuarioController;
	

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(UsuarioController.class).build();
	}

	@Test
	public void deveBuscarPorIdSucesso() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/{id}", "123"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deveBuscarTodosSucesso() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/usuarios")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deveInserirSucesso() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/usuarios/")
				.content(asJsonString(new Usuario(Long.parseLong("10"), "G", "12345678910", "G@t.com", new Date())))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void deveIncluirSucesso() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/usuarios")
				.content(asJsonString(new Usuario(Long.parseLong("10"), "G", "12345678910", "G@t.com", new Date())))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void deveAtualizarSucesso() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.patch("/usuarios/")
				.content(asJsonString(new Usuario(Long.parseLong("10"), "G", "12345678910", "G@t.com", new Date())))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}


	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
