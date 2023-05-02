package customExceptions;

public class PrestamoActivo extends Exception{
	public PrestamoActivo()
	{
		super("Ya se tiene un prestamo activo");
	}

}
