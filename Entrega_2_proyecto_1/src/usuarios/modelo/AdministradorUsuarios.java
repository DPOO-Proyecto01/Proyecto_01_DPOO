package usuarios.modelo;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AdministradorUsuarios 
{	
	private HashMap<Integer, Administrador> administradores = new HashMap<>();
	private HashMap<Integer, Cajero> cajeros = new HashMap<>();
	private HashMap<Integer, Operador> operadores = new HashMap<>();
	private HashMap<Integer, Cliente> clientes = new HashMap<>();
	private Integer ultimoID = 0;
	
	public AdministradorUsuarios() {
		
	}
	
	public Usuario buscarAdmin(String nombre) 
	{
		//En esta funcion vamos a buscar un Administrador de acuerdo a su nombre
		
		//retorna null si no lo encuentra
		for (Entry<Integer, Administrador> entry : administradores.entrySet()) {
			
			String nombreAdmin = entry.getValue().getNombre();
			
			if (nombreAdmin == nombre) 
			{
				return entry.getValue();
			} 
			
		}
		return null;
	}
	
	public Usuario buscarCajero(String nombre) 
	{
		//En esta funcion buscamos un Cajero de acuerdo a su nombre 
		// retorna null si no lo encuentra
		for (Entry<Integer, Cajero> entry : cajeros.entrySet())
		{
			
			String nombreCajero = entry.getValue().getNombre();
			
			if (nombreCajero == nombre)
			{
				return entry.getValue();
			}
		}
		return null;
	}
	
	public Usuario buscarOperador(String nombre)
	{
		//En esta funcion busvcamos un Operador por su nombre
		//retorna null si no se encuentra
		for (Entry<Integer, Operador> entry : operadores.entrySet()) 
		{
			
			String nombreOperador = entry.getValue().getNombre();
			
			if (nombreOperador == nombre)
			{
				return entry.getValue();
			}
		}
		return null;
	}
	
	public Usuario buscarCliente(String nombre)
	{
		//En esta funcion buscamos un cliente de acuerdo a su nombre
		// retorna null si no lo encuentra
		for (Entry<Integer, Cliente> entry : clientes.entrySet())
		{
			
			String nombreCliente = entry.getValue().getNombre();
			
			if (nombreCliente == nombre)
			{
				return entry.getValue();
			}
		}
		return null;
	}
	
	public void agregarAdministrador(Administrador user)
	{
		administradores.put(user.getID(), user);
	}
	
	public void agregarCajero(Cajero user) 
	{
		cajeros.put(user.getID(), user);
	}
	
	public void agregarOperador(Operador user)
	{
		operadores.put(user.getID(), user);
	}
	
	public void agregarCliente(Cliente user)
	{
		clientes.put(user.getID(), user);
	}
	
	public void eliminarUsuario(Usuario user) 
	{
		String tipo = user.getTipo();
		if (tipo == "Cliente") {
			clientes.remove(user.getID());
		} else if (tipo == "Cajero") {
			cajeros.remove(user.getID());
		} else if (tipo == "Operador") {
			operadores.remove(user.getID());
		} else {
			administradores.remove(user.getID());
		}
	}

	
	public boolean logIn(String username, String password, String tipo) {
		HashMap<Integer, ? extends Usuario> mapa;
		
		if (tipo=="Cliente") 
		{
			mapa = clientes;
		} else if (tipo == "Cajero")
		{
			mapa = cajeros;
		} else if (tipo == "Operador")
		{
			mapa = operadores;
		} else 
		{
			mapa = administradores;
		}
		
		for (Map.Entry<Integer, ? extends Usuario> entry : mapa.entrySet()) {
			if (username == entry.getValue().getNombre())
			{
				if (password == entry.getValue().getContrasenia()) 
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public Integer crearID() {
	 ultimoID = ultimoID + 1;
	 return ultimoID;
 }
	
}

