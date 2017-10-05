package br.com.academif.repository.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_subevento")
public class SubEventoEntity {

	//Declaração de variaveis locais
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idSubEvento")
	private Integer idSubEvento;

	@Column(name="nomeSubEvento")
	private String nomeSubEvento;
	
	@Column(name="dataSubEvento")
	private Date dataSubEvento;
	
	@Column(name="horaInicio")
	private String horaInicio;
	
	@Column(name="horaFim")
	private String horaFim;
	
	
	//Declaração de variaveis externas
	
	
	
	//Declaração de getters and setters
	public Integer getIdSubEvento() {
		return idSubEvento;
	}

	public void setIdSubEvento(Integer idSubEvento) {
		this.idSubEvento = idSubEvento;
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
