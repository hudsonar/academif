package br.com.academif.http;

import java.util.List;

import br.com.academif.repository.entity.SubEventoEntity;

public class Certificado {

	//Declaração de variaveis locais
	private Integer idCertificado;
	private Integer horasComputadas;
		
	
	//Declaração de variaveis externas
	private List<EventoEntity> eventosConfirmados;
	
	//Declaração Construtor
	public Certificado(Integer idCertificado, Integer horasComputadas){
		super();
		this.idCertificado = idCertificado;
		this.horasComputadas = horasComputadas;
	}
	
	//Declaração metodos Getters and Setters
	public Integer getIdCertificado() {
		return idCertificado;
	}
	public void setIdCertificado(Integer idCertificado) {
		this.idCertificado = idCertificado;
	}
	public Integer getHorasComputadas() {
		return horasComputadas;
	}
	public void setHorasComputadas(Integer horasComputadas) {
		this.horasComputadas = horasComputadas;
	}
}
