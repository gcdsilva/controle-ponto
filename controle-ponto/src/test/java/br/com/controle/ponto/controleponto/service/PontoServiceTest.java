package br.com.controle.ponto.controleponto.service;

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

import br.com.controle.ponto.entity.Ponto;
import br.com.controle.ponto.entity.Usuario;
import br.com.controle.ponto.enums.TipoMarcacaoEnum;
import br.com.controle.ponto.repository.PontoRepository;
import br.com.controle.ponto.service.PontoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class PontoServiceTest {

	@Autowired
	private PontoService service;

	@MockBean
	PontoRepository pontoRepository;
	
	@Test
	public void deveInserirSucesso() {
		
		when(pontoRepository.save(any())).thenReturn(getPontoEntrada());
		
		Ponto ponto = service.inserir(getPontoEntrada());
		assertEquals(TipoMarcacaoEnum.ENTRADA, ponto.getTipoMarcacao());
	}
	
	@Test
	public void deveBuscarPorIdSucesso() {
		
		when(pontoRepository.findById(anyLong())).thenReturn(getPontoOptional());
		List<Object> listaPontoUsuario = service.buscarPorUsuarioId(Long.parseLong("10"));
		assertNotNull(listaPontoUsuario);
	}

	private Optional<Ponto> getPontoOptional() {
		return getListaPonto().stream().findFirst();
	}

	private List<Ponto> getListaPonto() {
		List<Ponto> ponto = new ArrayList<Ponto>();
		ponto.add(getPontoEntrada());
		ponto.add(getPontoSaida());
		
		return ponto;
	}

	private Ponto getPontoEntrada() {
		
		Ponto ponto = new Ponto();
		ponto.setId(Long.parseLong("55"));
		ponto.setTipoMarcacao(TipoMarcacaoEnum.ENTRADA);
		ponto.setDataMarcacao(new Date());
		ponto.setUsuario(getUsuario());
		return ponto;
	}
	
	private Ponto getPontoSaida() {
		
		Ponto ponto = new Ponto();
		ponto.setId(Long.parseLong("55"));
		ponto.setTipoMarcacao(TipoMarcacaoEnum.SAIDA);
		ponto.setDataMarcacao(new Date());
		ponto.setUsuario(getUsuario());
		return ponto;
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
