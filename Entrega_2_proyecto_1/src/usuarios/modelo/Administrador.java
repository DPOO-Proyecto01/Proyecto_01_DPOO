package usuarios.modelo;

public class Administrador extends Usuario
{
	private static String ADMIN = "Administrador";
	
	
	Administrador(String _nombre, String _contrasenia, String _tipo, Integer _Id) {
		super(_nombre, _contrasenia, _tipo = "Administrador", _Id);
		// TODO Auto-generated constructor stub
		
	}

}
