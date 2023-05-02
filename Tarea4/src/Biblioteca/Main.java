package Biblioteca;

import java.util.Date;
import customExceptions.*;

public class Main {
	public static void main(String[] argc)
	{
		Biblioteca b1 = new Biblioteca();
		
		Date date1 = new Date();
		Date date2 = new Date();
		
		try 
		{
			b1.anadirUsuario("Santiago", "1031420947", "3122705388", "Estudiante");
			b1.anadirUsuario("Juan", "879989887","3116068301", "Estudiante");
			b1.anadirUsuario("Isis", "1256346562", "586595412", "profesor");
		}
		catch (NullParameter e)
		{
			System.out.println(e.getMessage());
		}
		
		try
		{
			b1.anadirLibro("nombre del viento", "543", "Pathric Rothfuss", "Penguin Random House", 1);
		}
		catch (NullParameter e)
		{
			System.out.println(e.getMessage());
		}
		
		try
		{
			b1.buscarLibro("nombre del viento").addEjemplar();
			b1.buscarLibro("nombre del viento").addEjemplar();
		}
		catch (NullParameter e)
		{
			System.out.println(e.getMessage());
		}
		catch (DoesNotExist e)
		{
			System.out.println(e.getMessage());
		}
		
		
		try
		{
			String libros[] = {"nombre del viento"};
			b1.anadirPrestamo("1031420947", libros, date1, date2);
		}
		catch (DateException e)
		{
			System.out.println(e.getMessage());
		}
		catch (NullParameter e)
		{
			System.out.println(e.getMessage());
		}
		catch (DoesNotExist e)
		{
			System.out.println(e.getMessage());
		}
		catch (NoExemplaryAvailable e)
		{
			System.out.println(e.getMessage());
		}
		catch (PrestamoActivo e)
		{
			System.out.println(e.getMessage());
		}
		
		try
		{
			String libros[] = {"nombre del viento"};
			b1.anadirPrestamo("879989887", libros, date1, date2);
		}
		catch (DateException e)
		{
			System.out.println(e.getMessage());
		}
		catch (NullParameter e)
		{
			System.out.println(e.getMessage());
		}
		catch (DoesNotExist e)
		{
			System.out.println(e.getMessage());
		}
		catch (NoExemplaryAvailable e)
		{
			System.out.println(e.getMessage());
		}
		catch (PrestamoActivo e)
		{
			System.out.println(e.getMessage());
		}
		
		try
		{
			String libros[] = {"nombre del viento"};
			b1.anadirPrestamo("1256346562", libros, date1, date2);
		}
		catch (DateException e)
		{
			System.out.println(e.getMessage());
		}
		catch (NullParameter e)
		{
			System.out.println(e.getMessage());
		}
		catch (DoesNotExist e)
		{
			System.out.println(e.getMessage());
		}
		catch (NoExemplaryAvailable e)
		{
			System.out.println(e.getMessage());
		}
		catch (PrestamoActivo e)
		{
			System.out.println(e.getMessage());
		}
		
		try 
		{
			System.out.println("Se busca el prestamo registrado con la cedula 1256346562: ");
			b1.buscarPrestamoPorUsuario("1256346562").toString();
		} 
		catch (DoesNotExist | NullParameter e) 
		{
			System.out.println("El prestamo solicitado no existe\n");
		}
		
		try 
		{
			System.out.println("Se busca el prestamo registrado con la cedula 1031420947: ");
			System.out.println(b1.buscarPrestamoPorUsuario("1031420947").toString());
		} 
		catch (DoesNotExist | NullParameter e) 
		{
			System.out.println("El prestamo solicitado no existe\n");
		}
		
		try 
		{
			System.out.println("Se busca el ejemplar del nombre del viento, con codigo 543-2");
			System.out.println(b1.buscarLibro("nombre del viento").buscarEjemplar("543-2").toString());		
		} 
		catch (DoesNotExist | NullParameter e) 
		{
			System.out.println(e.getMessage());
		}
		
		try
		{
			b1.liberarPrestamo("1031420947");
		}
		catch (DoesNotExist e)
		{
			System.out.println(e.getMessage());
		}
		catch (NullParameter e)
		{
			System.out.println(e.getMessage());
		}
		
		try
		{
			System.out.println(b1.buscarUsuario("1031420947").getPrestamoActivo());
		}
		catch (DoesNotExist e)
		{
			System.out.println(e.getMessage());
		}
		catch (NullParameter e)
		{
			System.out.println(e.getMessage());
		}
	}
}
