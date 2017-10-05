package br.com.academif.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.academif.http.Evento;
import br.com.academif.repository.EventoRepository;
import br.com.academif.repository.entity.EventoEntity;



//Essa classe vai expor os nossos métodos para serem acessasdos via http

//@Path - Caminho para a chamada da classe que vai representar o nosso serviço
@Path("/serviceEvento")
public class ServiceControllerEvento {

	private final EventoRepository repository = new EventoRepository();
	
	//@Consumes - determina o formato dos dados que vamos postar
	//@Produces - determina o formato dos dados que vamos retornar
	
	//Esse método CADASTRA uma novo evento
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarEvento")
	public String cadastrarEvento(Evento evento){
		
		EventoEntity entity = new EventoEntity();
		
		try{
			
			entity.setNomeEvento(evento.getNomeEvento());
			entity.setDataInicio(evento.getDataInicio());
			entity.setDataFim(evento.getDataFim());
			
			repository.salvarEvento(entity);
			
			return "Evento cadastrado com sucesso!";
			
		}catch (Exception e){
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	}
	
	//Esse método ALTERA um evento existente
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/alterarEvento")
	public String alterarEvento(Evento evento){
		
		EventoEntity entity = new EventoEntity();
		
		try{
			
			entity.setNomeEvento(evento.getNomeEvento());
			entity.setDataInicio(evento.getDataInicio());
			entity.setDataFim(evento.getDataFim());
			
			repository.alterarEvento(entity);
			
			return "Usuario atualizado com sucesso!";
			
		}catch (Exception e){
			return "Erro ao alterar o registro " + e.getMessage();
		}
	}
	
	//Esse método lista todos os eventos existentes na base de dados
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/todosEventos")
	public List<Evento> todosEventos(){
		
		List<Evento> eventos = new ArrayList<Evento>();
		
		List<EventoEntity> listaEntityEventos = repository.todosEventos();
		
		for (EventoEntity entity : listaEntityEventos){
			
			eventos.add(new Evento(entity.getIdEvento(), entity.getNomeEvento(), entity.getDataInicio(), entity.getDataFim()));
		}
		
		return eventos;
		
	}
	
	//Esse método busca um evento existente na base de dados a partir do seu CPF
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/getEvento{idEvento}")
	public Evento getEvento(@PathParam("idEvento")Integer idEvento){
		
		EventoEntity entity = repository.getEvento(idEvento);
			
		if (entity != null){
			return new Evento(entity.getIdEvento(), entity.getNomeEvento(), entity.getDataInicio(), entity.getDataFim());
		}else{
			return null;
		}
			
	}
	
	//Esse método EXCLUI um evento existente
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/excluirEvento")
	public String excluirEvento(@PathParam("codigo")Integer codigo){
			
		try{
			
			repository.excluirEvento(codigo);
			
			return "Evento excluido com sucesso!";
			
		}catch (Exception e){
			return "Erro ao excluir o registro " + e.getMessage();
		}
	}
}
