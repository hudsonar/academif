package br.com.academif.http;

import java.sql.Date;
import java.util.List;

import br.com.academif.repository.entity.SubEventoEntity;

public class Evento {

	//Declaração variaveis locais
	private Integer idEvento;
	private String nomeEvento;
	private Date dataInicio;
	private Date dataFim;
	
	//Declaração variaveis externas
	private List<SubEventoEntity> subEventosConfirmados;
	
	//Declaração Construtor
	public Evento(Integer idEvento, String nomeEvento, Date dataInicio, Date dataFim){
		super();
		this.idEvento = idEvento;
		this.nomeEvento = nomeEvento;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
	
	
	//Declaração Getters and Setters
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
