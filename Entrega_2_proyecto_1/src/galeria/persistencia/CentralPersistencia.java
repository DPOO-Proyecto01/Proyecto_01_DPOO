package galeria.persistencia;

public class CentralPersistencia 
{
	public static PersistenciaInventario getPersistenciaInventario()
	{
		return new PersistenciaInventario();
	}
	
	public static PersistenciaProcesos getPersistenciaProcesos()
	{
		return new PersistenciaProcesos();
	}
	
	public static PersistenciaUsuarios getPersistenciaUsuarios()
	{
		return new PersistenciaUsuarios();
	}
}
