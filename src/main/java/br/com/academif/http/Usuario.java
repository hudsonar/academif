package br.com.academif.http;

import java.sql.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.academif.repository.entity.SubEventoEntity;

@XmlRootElement
public class Usuario {
	
	//Declaração variaveis locais
	private int idUsuario;
	private String matricula;
	private String nome;
	private Integer cpf;
	private Date dataNasc;
	private String curso;
	private Integer periodo;
	private String statusMatricula;
	
	//Declaração variaveis externas
	private List<SubEventoEntity> subEventosConfirmados;


	//Declaração Construtor
	//public Usuario(int idUsuario, String matricula, String nome, Integer cpf, Date dataNasc, String curso, Integer periodo, String statusMatricula, List<SubEvento> subEventosConfirmados){
	public Usuario(int idUsuario, String matricula, String nome, Integer cpf, Date dataNasc, String curso, Integer periodo, String statusMatricula, List<SubEventoEntity> subEventosConfirmados){
		super();
		this.setIdUsuario(idUsuario);
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.curso = curso;
		this.periodo = periodo;
		this.statusMatricula = statusMatricula;
		this.subEventosConfirmados = subEventosConfirmados;
	}

	
	//Declaração Getters and Setters	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
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
