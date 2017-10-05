package br.com.academif.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.academif.http.Frequencia;
import br.com.academif.repository.FrequenciaRepository;
import br.com.academif.repository.entity.FrequenciaEntity;

//Essa classe vai expor os nossos métodos para serem acessasdos via http

//@Path - Caminho para a chamada da classe que vai representar o nosso serviço
@Path("/serviceFrequencia")
public class ServiceControllerFrequencia {

	private final FrequenciaRepository repository = new FrequenciaRepository();
	
	//@Consumes - determina o formato dos dados que vamos postar
	//@Produces - determina o formato dos dados que vamos retornar
	
	//Esse método CADASTRA uma nova frequencia
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarFrequencia")
	public String cadastrarFrequencia(Frequencia frequencia){
		
		FrequenciaEntity entity = new FrequenciaEntity();
		
		try{
			
			entity.setIdFrequencia(frequencia.getIdFrequencia());
			entity.setMarcacoes(frequencia.getMarcacoes());
			
			repository.salvarFrequencia(entity);
			
			return "Frequencia cadastrada com sucesso!";
		}catch (Exception e){
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	}
	
	
	//Esse metodo ALTERA uma frequencia existente
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/alterarFrequencia")
	public String alterarFrequencia(Frequencia frequencia){
		
		FrequenciaEntity entity = new FrequenciaEntity();
		
		try{
			
			entity.setIdFrequencia(frequencia.getIdFrequencia());
			entity.setMarcacoes(frequencia.getMarcacoes());
			
			repository.alterarFrequencia(entity);
			
			return "Frequencia atualizada com sucesso!";
			
		}catch (Exception e){
			return "Erro ao alterar o registro " + e.getMessage();
		}
	}
	
	//Esse método lista todos os eventos existentes na base de dados
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/todasFrequencias")
	public List<Frequencia> todasFrequencias(){
		
		List<Frequencia> marcacoes = new ArrayList<Frequencia>();
		
		List<FrequenciaEntity> listaEntityFrequencias = repository.todasFrequencias();
		
		for (FrequenciaEntity entity : listaEntityFrequencias){
			
			marcacoes.add(new Frequencia(entity.getIdFrequencia(), entity.getMarcacoes()));
		}
		
		return marcacoes;
		
	}
	
	//Esse método busca um evento existente na base de dados a partir do seu CPF
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/getFrequencia{cpf}")
	public Frequencia getFrequencia(@PathParam("idFrequencia")Integer idFrequencia){
		
		FrequenciaEntity entity = repository.getFrequencia(idFrequencia);
			
		if (entity != null){
			return new Frequencia(entity.getIdFrequencia(), entity.getMarcacoes());
		}else{
			return null;
		}
			
	}
	
	//Esse método EXCLUI um evento existente
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/excluirFrequencia")
	public String excluirFrequencia(@PathParam("codigo")Integer codigo){
			
		try{
			
			repository.excluirFrequencia(codigo);
			
			return "Evento excluido com sucesso!";
			
		}catch (Exception e){
			return "Erro ao excluir o registro " + e.getMessage();
		}
	}
}
