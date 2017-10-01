package br.com.academif.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;
import br.com.academif.repository.entity.UsuarioEntity;

public class UsuarioRepository {

	private final EntityManagerFactory entityManagerFactory;
	
	private final EntityManager entityManager;
	
	//CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml
	public UsuarioRepository(){
		
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_academif");
		
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	// CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	public void Salvar(UsuarioEntity usuarioEntity){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(usuarioEntity);
		this.entityManager.getTransaction().commit();
	}
	
	//ALTERA UM REGISTRO CADASTRO
	public void Alterar(UsuarioEntity usuarioentity){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(usuarioentity);
		this.entityManager.getTransaction().commit();
	}
	
	// RETORNA TODAS AS PESSOAS CADASTRADAS NO BANCO DE DADOS
	@SuppressWarnings("unchecked")
	public List<UsuarioEntity> todosUsuarios(){
		
		return this.entityManager.createQuery("SELECT p FROM UsuarioEntity p ORDER BY p.nome").getResultList();
	}
	
	//CONSULTA UMA PESSOA CADASTRADA PELO CODIGO**********
	//CONSULTA UMA PESSOA CADASTRADA PELA CPF
	public UsuarioEntity getUsuario(Integer cpf){
		
		return this.entityManager.find(UsuarioEntity.class, cpf);
	}
	
	//EXCLUINDO REGISTRO PELO CODIGO**********
	public void Excluir(Integer cpf){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(cpf);
		this.entityManager.getTransaction().commit();
	}
}
