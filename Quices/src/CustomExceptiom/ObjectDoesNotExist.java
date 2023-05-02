package CustomExceptiom;

public class ObjectDoesNotExist extends Exception {
	public ObjectDoesNotExist()
	{
		super("El Objecto Buscado No Existe");
	}
}
