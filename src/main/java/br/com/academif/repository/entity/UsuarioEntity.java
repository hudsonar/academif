package br.com.academif.repository.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_usuario")
public class UsuarioEntity {
	
	//Declaração variaveis locais
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idUsuario")
	private Integer idUsuario;
	
	@Column(name="matricula")
	private String matricula;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private Integer cpf;
	
	@Column(name="dataNasc")
	private Date dataNasc;
	
	@Column(name="curso")
	private String curso;
	
	@Column(name="periodo")
	private Integer periodo;
	
	@Column(name="statusMatricula")
	private String statusMatricula;

	
	//Declaração variaveis externas
	@OneToMany(mappedBy="usuario")
	private List<SubEventoEntity> subEventosConfirmados;
	

	//Declaração Getters and Setters
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public String getStatusMatricula() {
		return statusMatricula;
	}

	public void setStatusMatricula(String statusMatricula) {
		this.statusMatricula = statusMatricula;
	}
	
	
	public List<SubEventoEntity> getSubEventosConfirmados() {
		return subEventosConfirmados;
	}

	
	public void setSubEventosConfirmados(List<SubEventoEntity> subEventosConfirmados) {
		this.subEventosConfirmados = subEventosConfirmados;
	}
}
