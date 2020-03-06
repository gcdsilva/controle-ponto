package br.com.controle.ponto.controleponto.controller;

import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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

import br.com.controle.ponto.controller.PontoController;
import br.com.controle.ponto.entity.Ponto;
import br.com.controle.ponto.entity.Usuario;
import br.com.controle.ponto.enums.TipoMarcacaoEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PontoControllerTest {
	
	@Autowired
	public MockMvc mockMvc;

	@MockBean
	private PontoController pontoController;
	

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(pontoController).build();
	}

	@Test
	public void deveBuscarPorIdSucesso() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/ponto/{id}", "123"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void deveIncluirSucesso() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/ponto")
				.content(asJsonString(new Ponto(Long.parseLong("10"), getUsuario(), new Date(), TipoMarcacaoEnum.ENTRADA)))
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
	
	private Usuario getUsuario() {
		Usuario usuario = new Usuario();
		usuario.setId(Long.parseLong("10"));
		usuario.setCpf("93614580008");
		usuario.setNome("Guilherme");
		usuario.setEmail("ggg@gmail.com");
		usuario.setDataCadastro(new Date());

		return usuario;
	}


}
