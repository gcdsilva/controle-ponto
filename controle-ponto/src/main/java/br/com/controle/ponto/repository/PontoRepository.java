package br.com.controle.ponto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.ponto.entity.Ponto;

@Repository
public interface PontoRepository extends CrudRepository<Ponto, Long> {

}