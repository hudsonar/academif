package br.com.academif.repository.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_certificado")
public class CertificadoEntity {

	//Declaração de variaveis locais
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCertificado")
	private Integer idCertificado;
	
	@Column(name="horasComputadas")
	private Integer horasComputadas;
	
	
	//Declaração de variaveis externas
	@OneToMany(mappedBy="usuario")
	private List<EventoEntity> eventosConfirmados;
	
	//Declaração de Getters and Setters
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
