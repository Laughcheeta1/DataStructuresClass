package customExceptions;

public class ExceededMaximumNumber extends Exception{
	public ExceededMaximumNumber()
	{
		super("No se pueden anadir mas ejemplares");
	}
}
