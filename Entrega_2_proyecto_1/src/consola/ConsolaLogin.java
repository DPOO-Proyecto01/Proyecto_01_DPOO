package consola;
import java.util.HashMap;
import usuarios.modelo.*;

public class ConsolaLogin {
	HashMap<Integer, Cliente> clientes;
	HashMap<Integer, Cajero> cajeros;
	HashMap<Integer, Operador> operadores;
	HashMap<Integer, Administrador> administradores;
	
	
	ConsolaLogin(){
		clientes = new HashMap<Integer, Cliente>();
		cajeros = new HashMap<Integer, Cajero>();
		operadores = new HashMap<Integer, Operador>();
		administradores = new HashMap<Integer, Administrador>();
		printMenu(); 
	}
	
	public void printMenu() {
		System.out.println("Bienvenido a nuestra galeria!");
		System.out.println("Por favor ingrese su tipoo de usuario para hacer Login:");
		System.out.println("1. Soy un Cliente \n2. Soy un empleado \n3. Soy un Administrador");
	}
	
	public static void main(String[] args) {
		ConsolaLogin consolaLogin = new ConsolaLogin();
	}
	
	
	
}
