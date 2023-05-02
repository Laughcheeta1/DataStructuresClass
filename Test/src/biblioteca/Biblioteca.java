package biblioteca;

import java.io.IOException;
import java.util.Arrays;

import customExceptions.*;

public class Biblioteca {
	private Libro[] libros;
	private Usuario[] usuarios;
	private Prestamo[] prestamos;
	private ControladorDeFicheros c;
	
	public Biblioteca()
	{
		libros = new Libro[0];
		usuarios = new Usuario[0];
		prestamos = new Prestamo[0];
		c = new ControladorDeFicheros("C:\\Users\\santi\\OneDrive\\Desktop\\Biblioteca\\Usuarios", "C:\\Users\\santi\\OneDrive\\Desktop\\Biblioteca\\Libros", "C:\\Users\\santi\\OneDrive\\Desktop\\Biblioteca\\Prestamos");
	}
	
	public Libro[] getLibros() {
		return libros;
	}

	public Usuario[] getUsuarios() {
		return usuarios;
	}

	public Prestamo[] getPrestamos() {
		return prestamos;
	}

	public void leerLibrosDeFichero() throws IOException, ClassNotFoundException
	{
		libros = c.readLibros();
	}
	
	public void leerUsuariosDeFichero() throws IOException, ClassNotFoundException
	{
		usuarios = c.readUsuarios();
	}
	
	public void leerPrestamosDeFichero() throws IOException, ClassNotFoundException
	{
		prestamos = c.readPrestamos();
	}
	
	public void writeUsuarios() throws IOException
	{
		c.writeUsuarios(usuarios);
	}
	
	public void writeLibros() throws IOException
	{
		c.writeLibros(libros);
	}
	
	public void writePrestamos() throws IOException
	{
		c.writePrestamos(prestamos);
	}
	
	/*
	public void escribirLibros() throws IOException
	{
		c.escribirLibro(libros);
	}
	
	public void escribirUsuarios() throws IOException
	{
		c.escribirUsuarios(usuarios);
	}*/
	
	public void addLibro(String titulo, String codigo, String autores, String editorial, int edicion)
	{
		libros = Arrays.copyOf(libros, libros.length + 1);
		libros[libros.length - 1] = new Libro(titulo, codigo, autores, editorial, edicion);
	}
	
	public void addUsuario(String nombre, String cc, String telefono, String tipo)
	{
		usuarios = Arrays.copyOf(usuarios, usuarios.length + 1);
		usuarios[usuarios.length - 1] = new Usuario(nombre, cc, telefono, tipo, false);
	}

	public String addEjemplar(String titulo) throws DoesNotExist
	{	
		return libros[buscarLibro(titulo)].addEjemplar();
	}
	
	public void anadirPrestamo(String usuario, String libros[]) throws DoesNotExist, NoExemplaryAvailable, NullParameter, PrestamoActivo, ECannotMakeLending
	{
		if (usuario == null || libros == null)
		{
			throw new NullParameter();
		}
		
		Ejemplar ejemplares[] = new Ejemplar[0];
		
		for (int i = 0; i < libros.length; i++)
		{
			ejemplares = getLibroDisponible(ejemplares, buscarLibro(libros[i]));
		}
		
		if (ejemplares.length == 0)
		{
			throw new ECannotMakeLending();
		}
		
		this.prestamos = Arrays.copyOf(prestamos, prestamos.length + 1);
		this.prestamos[prestamos.length - 1] = new Prestamo(this.usuarios[buscarUsuario(usuario)], ejemplares);
	}
	
	public Ejemplar[] getLibroDisponible(Ejemplar[] ejemplares, int i)
	{		
		Ejemplar ejem = libros[i].getAlgunEjemplarDisponibleNull();
			
		
		if (ejem != null)	
		{
			ejem.setDisponibilidad(false);
			ejemplares = Arrays.copyOf(ejemplares, ejemplares.length + 1);
			ejemplares[ejemplares.length - 1] = ejem; 
		}
		
		return ejemplares;
	}
	
	public void liberarPrestamoPorUsuario(String cc, String codigoLibro) throws DoesNotExist, NullParameter
	{
		if (cc == null || codigoLibro == null)
		{
			throw new NullParameter();
		}
		
		int posicion = buscarPrestamo(cc);
		Ejemplar libros[] = prestamos[posicion].getLibros();
		
		for (int i = 0; i < libros.length; i++)
		{
			if (libros[i].getCodigo().compareTo(codigoLibro) == 0)
			{
				libros[i].setDisponibilidad(true);
				System.arraycopy(libros, i + 1, libros, i, libros.length - (i + 1));
				libros = Arrays.copyOf(libros, libros.length - 1);
			}
		}
		
		if (libros.length == 0)
		{
			prestamos[posicion].getUsuario().setPrestamoActivo(false);
			System.arraycopy(prestamos, posicion + 1, prestamos, posicion, prestamos.length - (posicion + 1));
			prestamos = Arrays.copyOf(prestamos, prestamos.length);
		}
		else
		{
			prestamos[posicion].setLibros(libros);
		}
	}
	
	public void liberarPrestamoPorCodigo(String codigoLibro) throws DoesNotExist, NullParameter, ELibroRobado
	{
		if (codigoLibro == null)
		{
			throw new NullParameter();
		}
		
		int posicion = buscarPrestamoCodigoLibro(codigoLibro);
		Ejemplar libros[] = prestamos[posicion].getLibros();
		
		int i = 0;
		int x = libros.length;
		
		while (i < x)
		{
			if (libros[i].getCodigo().compareTo(codigoLibro) == 0)
			{
				libros[i].setDisponibilidad(true);
				System.arraycopy(libros, i + 1, libros, i, libros.length - (i + 1));
				libros = Arrays.copyOf(libros, libros.length - 1);
				break;
			}
			
			i++;
		}
		
		if (i == x)
		{
			throw new ELibroRobado();
		}
		
		else if (libros.length == 0)
		{
			prestamos[posicion].getUsuario().setPrestamoActivo(false);
			System.arraycopy(prestamos, posicion + 1, prestamos, posicion, prestamos.length - (posicion + 1));
			prestamos = Arrays.copyOf(prestamos, prestamos.length);
		}
		else
		{
			prestamos[posicion].setLibros(libros);
		}
	}
	
	private int buscarPrestamoCodigoLibro(String codigo) throws DoesNotExist
	{
		int i = 0, x = prestamos.length;
		
		while (i < x)
		{
			Ejemplar ej[] = prestamos[i].getLibros();
			int j = 0;
			int z = ej.length;
			
			while (j < z)
			{
				if (ej[j].getCodigo().compareTo(codigo) == 0)
				{
					return i;
				}
				
				j++;
			}
			
			i++;
		}
		
		return -1;
	}
	
	private int buscarPrestamo(String cc) throws DoesNotExist
	{
		int i = 0, x = prestamos.length;
		
		while (i < x && prestamos[i++].getUsuario().getCc().compareTo(cc) != 0);
		
		if (--i == x)
		{
			throw new DoesNotExist();
		}
		
		return i;
	}
	
	private int buscarUsuario(String cc) throws DoesNotExist
	{
		int i = 0;
		int x = usuarios.length;
		while (i < x && usuarios[i++].getCc().compareTo(cc) != 0);
		
		if (--i == usuarios.length)
		{
			throw new DoesNotExist();
		}
		
		return i;
	}
	
	private int buscarLibro(String titulo) throws DoesNotExist
	{
		int i = 0, x = libros.length;
		
		while (i < x && libros[i++].getTitulo().compareTo(titulo) != 0);
		
		if (--i == x)
		{
			throw new DoesNotExist();
		}
		
		return i;
	}
	
}
