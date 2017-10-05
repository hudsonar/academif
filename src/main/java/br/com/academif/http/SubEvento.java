package br.com.academif.http;

import java.sql.Date;

public class SubEvento {

	//Declaração de variaveis locais
	private Integer idEvento;
	private  String nomeSubEvento;
	private Date dataSubEvento;
	private String horaInicio;
	private String horaFim;
	
	
	//Declaração de variaveis externas
	
	
	//Declaração Construtor
	public SubEvento(Integer idEvento, String nomeSubEvento, Date dataSubEvento, String horaInicio, String horaFim){
		super();
		this.idEvento = idEvento;
		this.nomeSubEvento = nomeSubEvento;
		this.dataSubEvento = dataSubEvento;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}


	//Declaração Getters and Setters
	public Integer getIdEvento() {
		return idEvento;
	}


	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}


	public String getNomeSubEvento() {
		return nomeSubEvento;
	}


	public void setNomeSubEvento(String nomeSubEvento) {
		this.nomeSubEvento = nomeSubEvento;
	}


	public Date getDataSubEvento() {
		return dataSubEvento;
	}


	public void setDataSubEvento(Date dataSubEvento) {
		this.dataSubEvento = dataSubEvento;
	}


	public String getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}


	public String getHoraFim() {
		return horaFim;
	}


	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}
	
	
}
