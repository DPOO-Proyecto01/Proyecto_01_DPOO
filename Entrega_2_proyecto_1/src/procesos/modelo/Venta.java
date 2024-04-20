package procesos.modelo;

import inventario.modelo.Pieza;
import usuarios.modelo.Administrador;
import usuarios.modelo.Cliente;
import usuarios.modelo.Empleado;

public class Venta 
{

	private Pieza pieza;
	
	private double precio;
	
	private Empleado empleado;
	
	private Administrador admin;
	
	private String medioDePago;
	
	private Cliente comprador;
	
	
	public Venta(Pieza pieza, double precio, Empleado empleado, Administrador admin, String medioDePago, Cliente comprador) 
	{
		this.pieza = pieza;
		this.precio = precio;
		this.empleado = empleado;
		this.admin = admin;
		this.medioDePago = medioDePago;	
		this.comprador = comprador;
	}
	
	
	
}
