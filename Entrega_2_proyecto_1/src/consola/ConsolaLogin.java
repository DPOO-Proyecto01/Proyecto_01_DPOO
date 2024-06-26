package consola;
import java.util.HashMap;
import java.util.Scanner;
import usuarios.modelo.*;
import inventario.modelo.Galeria;

public class ConsolaLogin {
	HashMap<Integer, Cliente> clientes;
	HashMap<Integer, Cajero> cajeros;
	HashMap<Integer, Operador> operadores;
	HashMap<Integer, Administrador> administradores;
	static Galeria galeria;
	
	
	public ConsolaLogin(Galeria galeria){
		clientes = new HashMap<Integer, Cliente>();
		cajeros = new HashMap<Integer, Cajero>();
		operadores = new HashMap<Integer, Operador>();
		administradores = new HashMap<Integer, Administrador>();
		
	}
	
	public static void printMenu() {
		Scanner scanner = new Scanner(System.in);
		String accion = "0";
		while (!(accion.equals("3"))) {
			System.out.println("Bienvenido a nuestra galeria!");
			System.out.println("Que desea hacer?");
			System.out.println("1. Login");
			System.out.println("2. Registrarse");
			System.out.println("3. Cerrar la aplicacion");
			accion = scanner.nextLine();
			
			if (accion.equals("1")) {
				Login();
			} else if (accion.equals("2")) {
				Registrar();
			} 
		}
		scanner.close();
	}
	
	public static void Login() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Por favor ingrese su tipo de usuario para hacer Login:");
		System.out.println("1. Soy un Cliente");
		System.out.println("2. Soy un Cajero");
		System.out.println("3. Soy un Operador");
		System.out.println("4. Soy un Administrador");
		String tipo = scanner.nextLine();
		
		System.out.println("Username:");
		String username = scanner.nextLine();
		
		System.out.println("Contraseña:");
		String contrasena = scanner.nextLine();
		
		if (galeria.getAdminUsuarios().logIn(username, contrasena, tipo)) {
			if (tipo.equals("1")) {
				ConsolaCliente.printMenu();
			} else if (tipo.equals("2")) {
				ConsolaCajero.printMenu();
			} else if (tipo.equals("3")) {
				ConsolaOperador.printMenu();
			} else if (tipo.equals("4")) {
				ConsolaAdministrador.printMenu();
			}
		}
		scanner.close();
	}
	
	public static void Registrar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Username:");
		String username = scanner.nextLine();
		
		System.out.println("Contraseña:");
		String contrasenia = scanner.nextLine();
		
		System.out.println("Ingrese el tipo de perfil que desea crear:");
		System.out.println("1. Cliente");
		System.out.println("2. Cajero");
		System.out.println("3. Operador");
		System.out.println("4. Administrador");
		String tipo = scanner.nextLine();
		
		if (tipo.equals("1")) {
			System.out.println("Numero de telefono:");
			int telefono1 = scanner.nextInt();
			Integer telefono = Integer.valueOf(telefono1);
			
			System.out.println("Ingrese su correo electronico:");
			String email = scanner.nextLine();
			
			Cliente cliente = new Cliente(username, contrasenia, "", telefono, email, null);
			galeria.getAdminUsuarios().agregarCliente(cliente);
			
		} else if (tipo.equals("2")) {
			Cajero cajero = new Cajero(username, contrasenia, "", "Cajero", null);
			galeria.getAdminUsuarios().agregarCajero(cajero);
			
		} else if (tipo.equals("3")) {
			Operador operador = new Operador(username, contrasenia, "", "Operador", null);
			galeria.getAdminUsuarios().agregarOperador(operador);
			
		} else if (tipo.equals("4")) {
			Administrador admin = new Administrador(username, contrasenia, "", null);
			galeria.getAdminUsuarios().agregarAdministrador(admin);
		}
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		ConsolaLogin consolaLogin = new ConsolaLogin(galeria);
		printMenu(); 
	}
	
	
	
}
