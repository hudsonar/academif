package br.com.academif.controller;

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
	
	//Esse método CADASTRA uma novo usuario
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
}
