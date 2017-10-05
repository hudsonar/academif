package br.com.academif.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.academif.http.SubEvento;
import br.com.academif.repository.SubEventoRepository;
import br.com.academif.repository.entity.SubEventoEntity;

//Essa classe vai expor os nossos métodos para serem acessasdos via http

//@Path - Caminho para a chamada da classe que vai representar o nosso serviço
@Path("/serviceSubEvento")
public class ServiceControllerSubEvento {

	private final SubEventoRepository repository = new SubEventoRepository();
	
	//@Consumes - determina o formato dos dados que vamos postar
	//@Produces - determina o formato dos dados que vamos retornar
		
	//Esse método CADASTRA uma novo sub evento
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarSubEvento")
	public String cadastrarSubEvento(SubEvento subEvento){
		
		SubEventoEntity entity = new SubEventoEntity();
		
		try{
			
			entity.setNomeSubEvento(subEvento.getNomeSubEvento());
			entity.setDataSubEvento(subEvento.getDataSubEvento());
			entity.setHoraInicio(subEvento.getHoraInicio());
			entity.setHoraFim(subEvento.getHoraFim());
			
			repository.salvarSubEvento(entity);
			
			return "Sub evento cadastro com suecsso!";
			
		}catch (Exception e){
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	}
	
	
	//Esse método CADASTRA uma novo sub evento
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/alterarSubEvento")
	public String alterarSubEvento(SubEvento subEvento){
		
		SubEventoEntity entity = new SubEventoEntity();
		
		try{
			
			entity.setNomeSubEvento(subEvento.getNomeSubEvento());
			entity.setDataSubEvento(subEvento.getDataSubEvento());
			entity.setHoraInicio(subEvento.getHoraInicio());
			entity.setHoraFim(subEvento.getHoraFim());
			
			repository.alterarEvento(entity);
			
			return "Sub evento atualizado com sucesso!";
			
		}catch (Exception e){
			
			return "Erro ao atualizar o registro " + e.getMessage();
			
		}
	}
	
	//Esse método lista todos os sub eventos existentes na base de dados
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/todosSubEventos")
	public List<SubEvento> todosSubEventos(){
		
		List<SubEvento> subEventos = new ArrayList<SubEvento>();
		
		List<SubEventoEntity> listaEntitySubEventos = repository.todosSubEventos();
		
		for (SubEventoEntity entity : listaEntitySubEventos){
			
			subEventos.add(new SubEvento(entity.getIdSubEvento(), entity.getNomeSubEvento(), entity.getDataSubEvento(), entity.getHoraInicio(), entity.getHoraFim()));
			
		}
		
		return subEventos;
	}
	
	//Esse método busca um sub evento existente na base de dados a partir do seu CPF
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/getUsuario{idSubEvento}")
	public SubEvento getSubEvento(@PathParam("idSubEvento")Integer idSubEvento){
		
		SubEventoEntity entity = repository.getSubEvento(idSubEvento);
		
		if (entity != null){
			return new SubEvento(entity.getIdSubEvento(), entity.getNomeSubEvento(), entity.getDataSubEvento(), entity.getHoraInicio(), entity.getHoraFim());
		}else{
			return null;
		}
	}
	
	//Esse método EXCLUI um evento existente
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/excluirSubEvento")
	public String excluirSubEvento(@PathParam("codigo")Integer codigo){
		
		try{
			
			repository.excluirSubEvento(codigo);
			
			return "Sub evento excluido com sucesso!";
					
		}catch (Exception e){
			return "Erro ao excluir o registro " + e.getMessage();
		}
	}
}
