package parentesis;

import java.util.Arrays;

public class ParentesisException extends Exception{
	public ParentesisException(int[] errores)
	{
		super("Error en de parentesis en las posiciones: " + Arrays.toString(errores));
	}
}
