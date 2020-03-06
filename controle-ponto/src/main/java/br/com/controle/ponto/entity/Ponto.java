package br.com.controle.ponto.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.controle.ponto.enums.TipoMarcacaoEnum;

@Entity
public class Ponto {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional = true)
	private Usuario usuario;

	@NotNull
	private Date dataMarcacao;

	private TipoMarcacaoEnum tipoMarcacao;

	public Ponto(Long id, Usuario usuario, @NotNull Date dataMarcacao, TipoMarcacaoEnum tipoMarcacao) {
		this.id = id;
		this.usuario = usuario;
		this.dataMarcacao = dataMarcacao;
		this.tipoMarcacao = tipoMarcacao;
	}

	public Ponto() {
	}

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

	public TipoMarcacaoEnum getTipoMarcacao() {
		return tipoMarcacao;
	}

	public void setTipoMarcacao(TipoMarcacaoEnum tipoMarcacao) {
		this.tipoMarcacao = tipoMarcacao;
	}

}
