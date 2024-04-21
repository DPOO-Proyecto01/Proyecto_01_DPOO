package galeria.persistencia;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

import inventario.modelo.Escultura;
import inventario.modelo.Galeria;
import inventario.modelo.Pieza;
import inventario.modelo.Pintura;
import inventario.modelo.Video;

public class PersistenciaInventario 
{
	public void guardarInventario (String archivo)
	{
		
	}
	
	public void cargarInventario (String archivo, Galeria galeria) throws IOException
	{
		String jsonCompleto = new String (Files.readAllBytes(new File(archivo).toPath( ) ));
		JSONObject root = new JSONObject(jsonCompleto);
		cargarPiezas(galeria,root.getJSONArray("Piezas"));
	}
	
	public void cargarPiezas (Galeria galeria, JSONArray jPiezas)
	{
		int numPiezas = jPiezas.length();
		
		for (int i = 0; i<numPiezas; i++)
		{
			JSONObject pieza = jPiezas.getJSONObject(i);
			String tipoPieza = pieza.getString("tipo");
			Pieza nuevaPieza = null;
			
			if (tipoPieza.equals("Escultura"))
			{
				nuevaPieza = cargarEscultura(pieza, nuevaPieza);
			}
			
			else if (tipoPieza.equals("Pintura"))
			{
				nuevaPieza = cargarPintura(pieza,nuevaPieza);
			}
			else
			{
				nuevaPieza = cargarVideo(pieza,nuevaPieza);
			}
			
			if (!galeria.existeId(nuevaPieza.getId()))
			{
				galeria.agregarPieza(nuevaPieza);
			}
		}
	}
	
	public Pieza cargarEscultura (JSONObject jPieza, Pieza nuevaPieza)
	{
		String id = jPieza.getString("id");
		String autores = jPieza.getString("autor");
		String fecha = jPieza.getString("fecha");
		String origen = jPieza.getString("origen");
		String descripcion = jPieza.getString("descripcion");
		String titulo = jPieza.getString("titulo");
		double precio = jPieza.getDouble("precio");
		double precioMin = jPieza.getDouble("precioMinimo");
		String fechaP = jPieza.getString("fechaPrestamo");
		String material = jPieza.getString("material");
		String dimensiones = jPieza.getString("dimensiones");
		double peso = jPieza.getDouble("peso");
		String instalacion = jPieza.getString("instalacion");
		boolean disponible = jPieza.getBoolean("disponible");
		boolean subastable = jPieza.getBoolean("subastable");
		String status = jPieza.getString("status");
		
		nuevaPieza = new Escultura(autores,fecha,origen,descripcion,precio,
				fechaP,titulo,precioMin,material,dimensiones,peso,instalacion);
		nuevaPieza.setId(id);
		nuevaPieza.setDisponible(disponible);
		nuevaPieza.setSubastable(subastable);
		nuevaPieza.setStatus(status);
		
		
		return nuevaPieza;
	}
	
	public Pieza cargarPintura (JSONObject jPieza, Pieza nuevaPieza)
	{
		String id = jPieza.getString("id");
		String autores = jPieza.getString("autor");
		String fecha = jPieza.getString("fecha");
		String origen = jPieza.getString("origen");
		String descripcion = jPieza.getString("descripcion");
		String titulo = jPieza.getString("titulo");
		double precio = jPieza.getDouble("precio");
		double precioMin = jPieza.getDouble("precioMinimo");
		String fechaP = jPieza.getString("fechaPrestamo");
		String tecnica = jPieza.getString("tecnica");
		String dimensiones = jPieza.getString("dimensiones");
		
		nuevaPieza = new Pintura(autores,fecha,origen,descripcion,precio,
				fechaP,titulo,precioMin,tecnica,dimensiones);
		nuevaPieza.setId(id);
		
		
		return nuevaPieza;
	}
	
	public Pieza cargarVideo(JSONObject jPieza, Pieza nuevaPieza)
	{
		String id = jPieza.getString("id");
		String autores = jPieza.getString("autor");
		String fecha = jPieza.getString("fecha");
		String origen = jPieza.getString("origen");
		String descripcion = jPieza.getString("descripcion");
		String titulo = jPieza.getString("titulo");
		double precio = jPieza.getDouble("precio");
		String fechaP = jPieza.getString("fechaPrestamo");
		double precioMin = jPieza.getDouble("precioMinimo");
		double tamanio = jPieza.getDouble("tamanio");
		double duracion = jPieza.getDouble("duracion");
		String instalacion = jPieza.getString("instalacion");
		
		nuevaPieza = new Video(autores,fecha,origen,descripcion,precio,
				fechaP,titulo,precioMin,tamanio,duracion,instalacion);
		nuevaPieza.setId(id);
		
		
		return nuevaPieza;
	}
}
