package procesos.modelo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import inventario.modelo.Pieza;
import usuarios.modelo.Administrador;
import usuarios.modelo.Cliente;
import usuarios.modelo.Empleado;

public class AdministradorProcesos 
{
	private List<Venta> ventas;
	
	private Map<Pieza,Subasta> subastasEnProceso;
	
	private List<Subasta> subastasFinalizadas;

	public AdministradorProcesos() 
	{
		ventas = new LinkedList<Venta>( );
		subastasFinalizadas = new LinkedList<Subasta>( );
		subastasEnProceso = new HashMap<Pieza,Subasta>();
	}
	
	
	public void iniciarSubasta(Pieza pieza, String fecha, Empleado empleado, Administrador admin) 
	{
		if (pieza.isSubastable()) 
		{
			double precio = pieza.getPrecio();	
			Subasta subasta;
			subasta = new Subasta(pieza, precio, fecha, empleado, admin);
			subastasEnProceso.put(pieza, subasta);
		}
		
	}
	
	public void finalizarSubasta(Subasta subasta) 
	{
		subasta.setTerminada();
		Pieza pieza = subasta.getPieza();
		subastasFinalizadas.add(subasta);
		
		if ((subastasEnProceso.get(pieza)).equals(subasta)) 
		{
			subastasEnProceso.remove(pieza);
		}
		
	}
	
	public void generarVenta (Cliente cliente, Pieza pieza, String medioDePago, Empleado empleado, Administrador admin) 
	{
		double precio = pieza.getPrecio();
		Venta venta = new Venta(pieza, precio, empleado, admin, medioDePago, cliente);
		ventas.add(venta);
	}
	
	
}
