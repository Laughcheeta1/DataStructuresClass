package biblioteca;

public class ECannotMakeLending extends Exception{
	public ECannotMakeLending()
	{
		super("No se pudo hacer el prestamo");
	}
}
