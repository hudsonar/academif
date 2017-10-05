package br.com.academif.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.academif.repository.entity.SubEventoEntity;

public class SubEventoRepository {

	private final EntityManagerFactory entityManagerFactory;
	
	private final EntityManager entityManager;
	
	//Criando o EntityManagerFactory com as propriedades do arquivo persistence.xml
	public SubEventoRepository(){
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db+academif");
		
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	//Cria novo registro no banco de dados
	public void salvarSubEvento(SubEventoEntity subEventoEntity){
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(subEventoEntity);
		this.entityManager.getTransaction().commit();
	}
	
	//Altera um registro da base de dados
	public void alterarEvento(SubEventoEntity subEventoEntity){
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(subEventoEntity);
		this.entityManager.getTransaction().commit();
	}
	
	//Retorna todos os subeventos cadastrados no banco de dados
	@SuppressWarnings("unchecked")
	public List<SubEventoEntity> todosSubEventos(){
		
		return this.entityManager.createQuery("SELECT p FROM SubEventoEntity p ORDER BY p.dataSubEvento").getResultList();
		
	}
	
	//Consulta um sub evento cadastrado pelo codigo
	public SubEventoEntity getSubEvento(Integer idSubEvento){
		
		return this.entityManager.find(SubEventoEntity.class, idSubEvento);
		
	}
	
	//Excluir registro pelo codigo
	public void excluirSubEvento(Integer idSubEvento){
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(idSubEvento);
		this.entityManager.getTransaction().commit();
	}
}
