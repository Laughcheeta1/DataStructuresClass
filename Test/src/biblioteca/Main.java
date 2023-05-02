package biblioteca;

import java.io.IOException;
import java.util.Arrays;

import customExceptions.DoesNotExist;
import customExceptions.NoExemplaryAvailable;
import customExceptions.NullParameter;
import customExceptions.PrestamoActivo;

public class Main {
	public static void main(String[] argc)
	{
		Biblioteca b = new Biblioteca();
		
		/*System.out.println(System.getProperty("user.dir"));
		
		b.addLibro("nombre del viento", "1", "Patric Rothfuss", "Penguin random house", 1);
		b.addLibro("Yes", "12", "Yes man", "New Vegas Times", 3);
		b.addUsuario("Yepes", "112389", "3122705388", "est");
		b.addUsuario("Sebastian", "34578123", "12312312346", "LGBTIQ+");
		
		try 
		{
			b.addEjemplar("nombre del viento");
			b.addEjemplar("Yes");
		} 
		catch (DoesNotExist e1) 
		{
			e1.printStackTrace();
		}
		
		String [] yes = {"nombre del viento", "Yes"};
		
		try 
		{
			b.anadirPrestamo("112389", yes);
		} 
		catch (DoesNotExist | NoExemplaryAvailable | NullParameter | PrestamoActivo e) 
		{
			System.out.println(e.getMessage());
		} 
		catch (ECannotMakeLending e) 
		{
			System.out.println(e.getMessage());
		}
		
		try
		{
			b.writeUsuarios();
			b.writeLibros();
			b.writePrestamos();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}*/
		
		try {
			b.leerLibrosDeFichero();
			b.leerUsuariosDeFichero();
			b.leerPrestamosDeFichero();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println(Arrays.toString(b.getLibros()));
		System.out.println(Arrays.toString(b.getUsuarios()));
		System.out.println(Arrays.toString(b.getPrestamos()));
		
	}
}
