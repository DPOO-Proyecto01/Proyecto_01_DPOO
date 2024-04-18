package inventario.modelo;

import java.util.HashMap;
import java.util.Map;

public class Inventario 
{
	private Map<String,Pieza> exhibicion;
	private Map<String,Pieza> bodega;
	private Map<String,Pieza> devolucion;
	private Map<String,Pieza> enVenta;
	private Map<String,Pieza> paraSubasta;
	
	public Inventario() 
	{
		exhibicion = new HashMap<String,Pieza>();
		bodega = new HashMap<String,Pieza>();
		devolucion = new HashMap<String,Pieza>();
		enVenta = new HashMap<String,Pieza>();
		paraSubasta = new HashMap<String,Pieza>();
	}
	
	public Map<String,Pieza> piezasEnExhibicion()
	{
		return exhibicion;
	}
	
	public Map<String,Pieza> piezasEnBodega()
	{
		return bodega;
	}
	
	public Map<String,Pieza> piezasDevolucion()
	{
		return devolucion;
	}
	
	public Map<String,Pieza> piezasEnVenta()
	{
		return enVenta;
	}
	
	public Map<String,Pieza> piezasParaSubasta()
	{
		return paraSubasta;
	}
	
	public Pieza buscarPieza (String id)
	{
		boolean encontro = false;
		Pieza pieza = null;
		
		if (exhibicion.containsKey(id))
		{
			pieza = exhibicion.get(id);
			encontro = true;
		}
		
		if ((!encontro)&&(bodega.containsKey(id)))
		{
			pieza = bodega.get(id);
			encontro = true;
		}
		
		if ((!encontro)&&(enVenta.containsKey(id)))
		{
			pieza = enVenta.get(id);
			encontro = true;
		}
		
		if ((!encontro)&&(devolucion.containsKey(id)))
		{
			pieza = devolucion.get(id);
			encontro = true;
		}
		
		if ((!encontro)&&(paraSubasta.containsKey(id)))
		{
			pieza = paraSubasta.get(id);
			encontro = true;
		}
		
		return pieza;
	}
	
	public void retirarPieza(Pieza obra)
	{
		String idPieza = obra.getId();
		
		if (exhibicion.containsKey(idPieza))
		{
			exhibicion.remove(idPieza);
		}
		
		if (bodega.containsKey(idPieza))
		{
			bodega.remove(idPieza);
		}
		
		if (devolucion.containsKey(idPieza))
		{
			devolucion.remove(idPieza);
		}
		
		if (enVenta.containsKey(idPieza))
		{
			enVenta.remove(idPieza);
		}
		
		if (paraSubasta.containsKey(idPieza))
		{
			paraSubasta.remove(idPieza);
		}
	}
	
	public void moverPieza(String id, Map<String,Pieza> mapa_1, Map<String,Pieza> mapa_2)
	{
		Pieza piezaMover = null;
		if(mapa_1.containsKey(id))
		{
			piezaMover = mapa_1.get(id);
			mapa_1.remove(id);
		}
		
		if (!(piezaMover.equals(null)))
		{
			mapa_2.put(id, piezaMover);
		}
	}
}
