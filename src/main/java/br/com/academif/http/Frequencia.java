package br.com.academif.http;

import java.util.List;

public class Frequencia {

	//Declaração variaveis locais
	private Integer idFrequencia;
	private List<String> marcacoes;
	
	
	//Declaração variaveis externas
	
	
	//Declaração Construtor
	public Frequencia(Integer idFrequencia, List<String> marcacoes){
		super();
		this.idFrequencia = idFrequencia;
		this.marcacoes = marcacoes;
	}
	
	//Declaração Getters and Setters
	public Integer getIdFrequencia() {
		return idFrequencia;
	}


	public void setIdFrequencia(Integer idFrequencia) {
		this.idFrequencia = idFrequencia;
	}


	public List<String> getMarcacoes() {
		return marcacoes;
	}


	public void setMarcacoes(List<String> marcacoes) {
		this.marcacoes = marcacoes;
	}
}
