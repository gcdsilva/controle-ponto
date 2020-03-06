package br.com.controle.ponto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.ponto.entity.Ponto;
import br.com.controle.ponto.enums.TipoMarcacaoEnum;
import br.com.controle.ponto.repository.PontoRepository;

@Service
public class PontoService {

	@Autowired
	private PontoRepository repository;

	@Transactional
	public Ponto inserir(Ponto ponto) {
		return repository.save(ponto);
	}

	public List<Object> buscarPorUsuarioId(Long id){
		
		List<Ponto> listaPonto = new ArrayList<Ponto>();
		listaPonto.addAll(repository.buscarPorUsuarioId(id));
		
	
		long entrada = 0, saida = 0, total = 0;

		for (Ponto ponto : listaPonto) {
			if (TipoMarcacaoEnum.ENTRADA.equals(ponto.getTipoMarcacao())) {
				entrada = ponto.getDataMarcacao().getTime();
			}else {
				saida = ponto.getDataMarcacao().getTime();
				total += (saida - entrada) / 3600000;
			}
		} 
		
		List<Object> lista = new ArrayList<Object>();
		
		lista.add(listaPonto);
		lista.add("Total Horas: " + total);
		
		return lista;
	}
	
	public <E> List<E> toList(Iterable<E> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
	}


}
