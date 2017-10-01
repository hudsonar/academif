package br.com.academif.controller;

import java.util.ArrayList;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.List;
import br.com.academif.http.Usuario;
import br.com.academif.repository.UsuarioRepository;
import br.com.academif.repository.entity.UsuarioEntity;

//Essa classe vai expor os nossos métodos para serem acessasdos via http
 
//@Path - Caminho para a chamada da classe que vai representar o nosso serviço
@Path("/service")
public class ServiceControllerUsuario {

	private final UsuarioRepository repository = new UsuarioRepository();
	
	//@Consumes - determina o formato dos dados que vamos postar
	//@Produces - determina o formato dos dados que vamos retornar
	 
	//Esse método CADASTRA uma novo usuario
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrarUsuario(Usuario usuario){
		
		UsuarioEntity entity = new UsuarioEntity();
		
		try{
			
			entity.setMatricula(usuario.getMatricula());
			entity.setNome(usuario.getNome());
			entity.setCpf(usuario.getCpf());
			entity.setDataNasc(usuario.getDataNasc());
			entity.setCurso(usuario.getCurso());
			entity.setPeriodo(usuario.getPeriodo());
			entity.setStatusMatricula(usuario.getStatusMatricula());
			
			repository.Salvar(entity);
			
			return "Usuario cadastrado com sucesso!";
			
		}catch (Exception e){
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	}
	
	
	//Esse método ALTERA um usuario existente
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/alterar")
	public String alterarUsuario(Usuario usuario){
		
		UsuarioEntity entity = new UsuarioEntity();
		
		try{
			
			entity.setMatricula(usuario.getMatricula());
			entity.setNome(usuario.getNome());
			entity.setCpf(usuario.getCpf());
			entity.setDataNasc(usuario.getDataNasc());
			entity.setCurso(usuario.getCurso());
			entity.setPeriodo(usuario.getPeriodo());
			entity.setStatusMatricula(usuario.getStatusMatricula());
			
			repository.Alterar(entity);
			
			return "Usuario atualizado com sucesso!";
			
		}catch (Exception e){
			return "Erro ao alterar o registro " + e.getMessage();
		}
	}
	
	
	//Esse método lista todos os usuarios existentes na base de dados
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/todosUsuarios")
	public List<Usuario> todosUsuarios(){
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		List<UsuarioEntity> listaEntityUsuarios = repository.todosUsuarios();
		
		for (UsuarioEntity entity : listaEntityUsuarios){
			
			usuarios.add(new Usuario(entity.getCodigo(), entity.getMatricula(), entity.getNome(), entity.getCpf(), entity.getDataNasc(), entity.getCurso(), entity.getPeriodo(), entity.getStatusMatricula()));
		}
		
		return usuarios;
		
	}
	
	//Esse método busca um usuario existente na base de dados a partir do seu CPF
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/getUsuario{cpf}")
	public Usuario getUsuario(@PathParam("cpf")Integer cpf){
		
		UsuarioEntity entity = repository.getUsuario(cpf);
			
		if (entity != null){
			return new Usuario(entity.getCodigo(), entity.getMatricula(), entity.getNome(), entity.getCpf(), entity.getDataNasc(), entity.getCurso(), entity.getPeriodo(), entity.getStatusMatricula());
		}else{
			return null;
		}
			
	}
	
	//Esse método EXCLUI um usuario existente
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/alterar")
	public String excluirUsuario(@PathParam("codigo")Integer codigo){
			
		try{
			
			repository.Excluir(codigo);
			
			return "Usuario excluido com sucesso!";
			
		}catch (Exception e){
			return "Erro ao excluir o registro " + e.getMessage();
		}
	}
}
