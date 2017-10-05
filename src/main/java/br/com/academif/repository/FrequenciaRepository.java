package br.com.academif.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.academif.repository.entity.FrequenciaEntity;

public class FrequenciaRepository {

	private final EntityManagerFactory entityManagerFactory;
	
	private final EntityManager entityManager;
	
	
	//Criando o EntityManageraFactory com as propriedades do arquivo persistence.xml
	public FrequenciaRepository(){
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_academif");
		
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	//Cria um novo registro no banco de dados
	public void salvarFrequencia(FrequenciaEntity frequenciaEntity){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(frequenciaEntity);
		this.entityManager.getTransaction().commit();
	}
	
	//Altera um registro existente no banco de dados
	public void alterarFrequencia(FrequenciaEntity frequenciaEntity){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(frequenciaEntity);
		this.entityManager.getTransaction().commit();
	}
	
	//Retorna todas as frequencias cadastradas no banco de dados
	@SuppressWarnings("unchecked")
	public List<FrequenciaEntity> todasFrequencias(){
		
		return this.entityManager.createQuery("SELECT p FROM FrequenciaEntity p").getResultList();
		
	}
	
	//Consulta frequencia cadastrada pelo codigo
	public FrequenciaEntity getFrequencia(Integer idFrequencia){
		
		return this.entityManager.find(FrequenciaEntity.class, idFrequencia);
		
	}
	
	//Exclui registro pelo codigo
	public void excluirFrequencia(Integer idFrequencia){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(idFrequencia);
		this.entityManager.getTransaction().commit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
