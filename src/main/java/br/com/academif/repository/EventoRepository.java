package br.com.academif.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.academif.repository.entity.EventoEntity;

public class EventoRepository {

	private final EntityManagerFactory entityManagerFactory;
	
	private final EntityManager entityManager;
	
	//CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml
	public EventoRepository(){
			
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_academif");
		
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	
	// CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	public void salvarEvento(EventoEntity eventoEntity){
			
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(eventoEntity);
		this.entityManager.getTransaction().commit();
	}
	
	//ALTERA UM REGISTRO CADASTRO
	public void alterarEvento(EventoEntity eventoEntity){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(eventoEntity);
		this.entityManager.getTransaction().commit();
	}
	
	// RETORNA TODOS OS EVENTOS CADASTRADOS NO BANCO DE DADOS
	@SuppressWarnings("unchecked")
	public List<EventoEntity> todosEventos(){
		
		return this.entityManager.createQuery("SELECT p FROM EventoEntity p ORDER BY p.dataInicio").getResultList();
	}
	
	//CONSULTA UMA PESSOA CADASTRADA PELO CODIGO**********
	//CONSULTA UMA PESSOA CADASTRADA PELA CPF
	public EventoEntity getEvento(Integer idEvento){
		
		return this.entityManager.find(EventoEntity.class, idEvento);
	}
	
	//EXCLUINDO REGISTRO PELO CODIGO**********
	public void excluirEvento(Integer idEvento){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(idEvento);
		this.entityManager.getTransaction().commit();
	}
}