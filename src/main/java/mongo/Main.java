package mongo;

public class Main {
	public static void main(String[] args) throws Exception {
		var controller = new UsuarioController();
		
		var user = new Usuario();
		user.setUsername("as");
		user.setPassword("1234");
		
		controller.InserirUsuario(user);
	}
	
}