package br.com.controle.ponto.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ponto {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 1, max = 120)
	private Usuario usuario;

	@NotNull
	private Date dataMarcacao;

	private String tipoMarcacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataMarcacao() {
		return dataMarcacao;
	}

	public void setDataMarcacao(Date dataMarcacao) {
		this.dataMarcacao = dataMarcacao;
	}

	public String getTipoMarcacao() {
		return tipoMarcacao;
	}

	public void setTipoMarcacao(String tipoMarcacao) {
		this.tipoMarcacao = tipoMarcacao;
	}
	
}
