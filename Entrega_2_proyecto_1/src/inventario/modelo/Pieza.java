package inventario.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Pieza 
{
	private String id;
	protected String tipo;
	private List<String> autores;
	private String fecha;
	private String origen;
	private String descripcion;
	private String titulo;
	private boolean subastable;
	private boolean disponible;
	private double precio;
	private double precioMinimo;
	private String fechaDePrestamo;
	private List<String> ids = new ArrayList<String>();
	
	public Pieza(List<String> autores,String fecha,String origen,String descripcion,double precio,String fechaP,String titulo,double minPrecio) 
	{
		id = generarId();
		this.autores = autores;
		this.fecha = fecha;
		this.origen = origen;
		this.descripcion = descripcion;
		this.precio = precio;
		fechaDePrestamo = fechaP;
		this.titulo = titulo;
		subastable = false;
		disponible = false;
		precioMinimo = minPrecio;
	}
	
	public String generarId ()
	{
		Integer numAleatorio = (int) Math.random()*100000;
		String cod = numAleatorio.toString();
		while (ids.contains(cod))
		{
			numAleatorio = (int) Math.random()*100000;
			cod = numAleatorio.toString();
		}
		
		return cod;
	}

	public String getId() 
	{
		return id;
	}

	public List<String> getAutores() 
	{
		return autores;
	}

	public String getFecha() 
	{
		return fecha;
	}

	public String getOrigen() 
	{
		return origen;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public String getTitulo() 
	{
		return titulo;
	}

	public boolean isSubastable() 
	{
		return subastable;
	}

	public boolean isDisponible() 
	{
		return disponible;
	}

	public double getPrecio() 
	{
		return precio;
	}

	public String getFechaDePrestamo() 
	{
		return fechaDePrestamo;
	}
	
	public double getPrecioMinimo()
	{
		return precioMinimo;
	}
	
	public String getTipo()
	{
		return tipo;
	}
	
	public void cambiarDisponibilidad()
	{
		if (disponible)
		{
			disponible = false;
		}
		else
		{
			disponible = true;
		}
	}
	
	public void cambiarSubastable()
	{
		if (subastable)
		{
			subastable = false;
		}
		else
		{
			subastable = true;
		}
	}
	
}
