package br.com.academif.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.academif.http.Certificado;
import br.com.academif.repository.CertificadoRepository;
import br.com.academif.repository.entity.CertificadoEntity;

//Essa classe vai expor os nossos métodos para serem acessasdos via http

//@Path - Caminho para a chamada da classe que vai representar o nosso serviço
@Path("/serviceCertificado")
public class ServiceControllerCertificado {

	private final CertificadoRepository repository = new CertificadoRepository();
	
	//@Consumes - determina o formato dos dados que vamos postar
	//@Produces - determina o formato dos dados que vamos retornar
	
	//Esse método CADASTRA uma novo evento
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarCertificado")
	public String cadastrarCertificado(Certificado certificado){
		
		CertificadoEntity entity = new CertificadoEntity();
		
		try{
			
			entity.setHorasComputadas(certificado.getHorasComputadas());
			
			repository.salvarCertificado(entity);
			
			return "Certificado cadastrado com sucesso!";
		}catch (Exception e){
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	}
	
	//@Consumes - determina o formato dos dados que vamos postar
	//@Produces - determina o formato dos dados que vamos retornar
		
	//Esse método CADASTRA uma novo evento
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/alterarCertificado")
	public String alterarCertificado(Certificado certificado){
		
		CertificadoEntity entity = new CertificadoEntity();
		
		try{
			
			entity.setHorasComputadas(certificado.getHorasComputadas());
			
			repository.alterarCertificado(entity);
			
			return "Certificado atualizado com sucesso!";
		}catch (Exception e){
			return "Erro ao alterar o registro " + e.getMessage();
		}
	}
	
	//@Consumes - determina o formato dos dados que vamos postar
	//@Produces - determina o formato dos dados que vamos retornar
		
	//Esse método CADASTRA uma novo evento
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/todosCertificados")
	public List<Certificado> todosCertificados(){
		
		List<Certificado> certificados = new ArrayList<Certificado>();
		
		List<CertificadoEntity> listaEntityCertificados = repository.todosCertificados();
		
		for (CertificadoEntity entity : listaEntityCertificados){
			
			certificados.add(new Certificado(entity.getIdCertificado(), entity.getHorasComputadas()));
		}
		
		return certificados;
	}
	
	//@Consumes - determina o formato dos dados que vamos postar
	//@Produces - determina o formato dos dados que vamos retornar
			
	//Esse método CADASTRA uma novo evento
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/getCertificado{idCertificado}")
	public Certificado getCertificado(@PathParam("idCertificado")Integer idCertificado){
		
		CertificadoEntity entity = repository.getCertificado(idCertificado);
		
		if(entity != null){
			return new Certificado(entity.getIdCertificado(), entity.getHorasComputadas());
		}else{
			return null;
		}
	}
	
	//@Consumes - determina o formato dos dados que vamos postar
	//@Produces - determina o formato dos dados que vamos retornar
			
	//Esse método CADASTRA uma novo evento
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/excluirCertificado")
	public String excluirCertificado(@PathParam("codigo")Integer codigo){
		
		try{
			
			repository.excluirCertificado(codigo);
			
			return "Evento excluido com sucesso!";
		}catch (Exception e){
			return "Erro ao excluir o registro " + e.getMessage();
		}
	}
}
