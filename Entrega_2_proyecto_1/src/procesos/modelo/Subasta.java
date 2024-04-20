package procesos.modelo;

import java.util.LinkedList;
import java.util.List;

import inventario.modelo.Pieza;
import usuarios.modelo.Administrador;
import usuarios.modelo.Empleado;

public class Subasta 
{
	private Pieza pieza;
	
	private double precioFinal;
	
	private List<String> ofertas;
	
	private boolean terminada;
	
	private String fecha;
	
	private Empleado empleado;
	
	private Administrador admin;
	
	
	public Subasta(Pieza pieza, double precioFinal, String fecha, Empleado empleado, Administrador admin) 
	{
		this.pieza = pieza;
		this.precioFinal = precioFinal;
		ofertas = new LinkedList<String>();
		terminada = false;
		this.fecha = fecha;
		this.empleado = empleado;
		this.admin = admin;
	}
	
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}


	/**
	 * @return the pieza
	 */
	public Pieza getPieza() {
		return pieza;
	}



	/**
	 * @return the terminada
	 */
	public boolean isTerminada() {
		return terminada;
	}



	public void setTerminada() 
	{
		terminada = true;
	}
	
	
}
