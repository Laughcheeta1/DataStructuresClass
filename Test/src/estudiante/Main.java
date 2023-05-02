package estudiante;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	public static void main(String[] argc)
	{
		Estudiante e1 = new Estudiante("Yepes", "12390", 23);
		Estudiante e2 = new Estudiante("Sebas", "1298765430", 23);
		Estudiante e3 = new Estudiante("Juan", "123945670", 23);
		
		Estudiante[] lista = {e1, e2, e3};
		FicheroEstudiante listaEst1 = new FicheroEstudiante(lista);
		
		String fichero = "C:\\Users\\santi\\OneDrive\\Desktop\\Estudiantes";
		
		try
		{
			listaEst1.escribirEstudiantesObjeto(fichero);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("No se encontro el fichero");
		}
		catch (IOException e)
		{
			System.out.println("Datos incompletos IOExceptions");
		}
		catch (Exception e)
		{
			System.out.println("Datos incompletos");
		}
		
		FicheroEstudiante listaEst2 = new FicheroEstudiante();
		
		try
		{
			listaEst2.leerTodosEstudiantesObjeto(fichero);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("No se encontro el fichero");
		}
		catch (IOException e)
		{
			System.out.println("Datos incompletos IOExceptions");
		}
		catch (Exception e)
		{
			System.out.println("Datos incompletos");
		}
		
		System.out.println("___Lectura___");
		for (Estudiante e : listaEst2.getListaEstudiantes())
		{
			System.out.println(e);
		}
	}
}
