package customExceptions;

public class DoesNotExist extends Exception{
	public DoesNotExist()
	{
		super("No existe este objeto");
	}
}
