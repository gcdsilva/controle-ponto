package br.com.controle.ponto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.controle.ponto.entity.Ponto;

@Repository
public interface PontoRepository extends CrudRepository<Ponto, Long> {
	
	@Query("from Ponto p WHERE p.usuario.id = :usuarioID")
	public List<Ponto> buscarPorUsuarioId(@Param("usuarioID") Long usuarioID);

}