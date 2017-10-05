package br.com.academif.repository.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_frequencia")
public class FrequenciaEntity {

	//Declaração de variaveis locais
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFrequencia")
	private Integer idFrequencia;
	
	@Column(name="marcacoes")
	private List<String> marcacoes;

		
	//Declaração de variaveis externas
	
	
	//Declaração de getters and setters
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
