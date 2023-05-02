package customExceptions;

public class NoExemplaryAvailable extends Exception{
	public NoExemplaryAvailable(String nombreObjeto)
	{
		super("No hay ejemplares disponibles de " + nombreObjeto);
	}
}
