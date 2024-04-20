package inventario.modelo;

import galeria.persistencia.CentralPersistencia;
import galeria.persistencia.PersistenciaInventario;
import galeria.persistencia.PersistenciaProcesos;
import galeria.persistencia.PersistenciaUsuarios;
import procesos.modelo.AdministradorProcesos;
import usuarios.modelo.AdministradorUsuarios;

public class Galeria 
{
	private Inventario inventario;
	private AdministradorProcesos adminProcesos;
	private AdministradorUsuarios adminUsuarios;
	
	public Galeria(Inventario inventario, AdministradorProcesos adminProcesos, AdministradorUsuarios adminUsuarios) 
	{
		this.inventario = inventario;
		this.adminProcesos = adminProcesos;
		this.adminUsuarios = adminUsuarios;
	}
	
	public void cargarInventario (String archivo)
	{
		PersistenciaInventario cargador = CentralPersistencia.getPersistenciaInventario();
		cargador.cargarInventario(archivo);
	}
	
	public void guardarInventario (String archivo)
	{
		PersistenciaInventario cargador = CentralPersistencia.getPersistenciaInventario();
		cargador.guardarInventario(archivo);
	}
	
	public void cargarProcesos (String archivo)
	{
		PersistenciaProcesos cargador = CentralPersistencia.getPersistenciaProcesos();
		cargador.cargarProcesos(archivo);
	}
	
	public void guardarProcesos (String archivo)
	{
		PersistenciaProcesos cargador = CentralPersistencia.getPersistenciaProcesos();
		cargador.guardarProcesos(archivo);
	}
	
	public void cargarUsuarios (String archivo)
	{
		PersistenciaUsuarios cargador = CentralPersistencia.getPersistenciaUsuarios();
		cargador.cargarUsuarios(archivo);
	}
	
	public void guardarUsuarios (String archivo)
	{
		PersistenciaUsuarios cargador = CentralPersistencia.getPersistenciaUsuarios();
		cargador.guardarUsuarios(archivo);
	}
}
