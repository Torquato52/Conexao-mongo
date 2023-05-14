package mongo;

import com.mongodb.client.MongoCollection;

public class UsuarioController {
	private MongoCollection<Usuario> _users;
	
	public UsuarioController() throws Exception {
		
		_users = Connection.getDatabase().getCollection("Usuarios", Usuario.class);
		
	}
	
	public void InserirUsuario(Usuario u) {
		
		var result = _users.insertOne(u);
		
		if(result.getInsertedId() != null) 
			System.out.println("Usuario inserido com sucesso!!");
		else 
			System.out.println("Não foi possivel inserir");
			
	}
}
