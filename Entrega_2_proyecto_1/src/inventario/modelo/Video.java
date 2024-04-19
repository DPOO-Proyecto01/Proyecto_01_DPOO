package inventario.modelo;

import java.util.List;

import usuarios.modelo.Usuario;

public class Video extends Pieza
{
	private double tamanio;
	private double duracion;
	private String instalacion;
	private static final String VIDEO = "Video";
	
	public Video(List<String> autores, String fecha, String origen, String descripcion, double precio, String fechaP,
			String titulo, double minPrecio,Usuario propietario, double tamanio, double duracion, String instalacion) 
	{
		super(autores, fecha, origen, descripcion, precio, fechaP, titulo, minPrecio, propietario);
		super.tipo = VIDEO;
		this.tamanio = tamanio;
		this.duracion = duracion;
		this.instalacion = instalacion;
	}

	public double getTamanio() 
	{
		return tamanio;
	}

	public double getDuracion() 
	{
		return duracion;
	}

	public String getInstalacion() 
	{
		return instalacion;
	}
	
	
}
