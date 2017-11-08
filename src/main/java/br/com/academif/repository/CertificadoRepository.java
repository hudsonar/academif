package br.com.academif.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.academif.repository.entity.CertificadoEntity;

public class CertificadoRepository {

	private final EntityManagerFactory entityManagerFactory;
	
	private final EntityManager entityManager;
	
	
	//Criando o EntityManagerFactory com as propriedades do arquivo persistence.xml
	public CertificadoRepository(){
		
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_academif");
		
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	//Cria novo registro no banco de dados
	public void salvarCertificado(CertificadoEntity certificadoEntity){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(certificadoEntity);
		this.entityManager.getTransaction().commit();
	}
	
	//Altera um registro cadastrado
	public void alterarCertificado(CertificadoEntity certificadoEntity){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(certificadoEntity);
		this.entityManager.getTransaction().commit();
	}
	
	//Retorna todos os eventos cadastrados no banco de dados
	@SuppressWarnings("unchecked")
	public List<CertificadoEntity> todosCertificados(){
		
		return this.entityManager.createQuery("SELECT p FROM CertificadoEntity p ORDER BY p.idCertificado").getResultList();
	}
	
	//Consulta um certificado cadastrado pelo codigo
	public CertificadoEntity getCertificado(Integer idCertificado){
		
		return this.entityManager.find(CertificadoEntity.class, idCertificado);
	}
	
	//Excluindo registro pelo codigo
	public void excluirCertificado(Integer idCertificado){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(idCertificado);
		this.entityManager.getTransaction().commit();
	}
}
