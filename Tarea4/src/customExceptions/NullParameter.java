package customExceptions;

public class NullParameter extends Exception{
	public NullParameter()
	{
		super("Ningun parametro puede ser nulo");
	}
}
