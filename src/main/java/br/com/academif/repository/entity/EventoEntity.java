package br.com.academif.repository.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_evento")
public class EventoEntity {
	
	//Declaração de variáveis locais
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idEvento")
	private Integer idEvento;
	
	@Column(name="nomeEvento")
	private String nomeEvento;
	
	@Column(name="dataInicio")
	private Date dataInicio;
	
	@Column(name="dataFim")
	private Date dataFim;
	
	//Declaração de variáveis externas
	
	
	
	//Declaração de getters and setters
	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
}
