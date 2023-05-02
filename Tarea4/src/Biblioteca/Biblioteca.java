package Biblioteca;

import java.util.Arrays;
import java.util.Date;

import customExceptions.*;

public class Biblioteca {
	private Libro libros[];
	private Usuario usuarios[];
	private Prestamo prestamos[];
	
	// Constructor
	public Biblioteca()
	{
		libros = new Libro[0];
		usuarios = new Usuario[0];
		prestamos = new Prestamo[0];
	}
	
	// Adds a book
	public void anadirLibro(String titulo, String codigo, String autores, String editorial, int edicion) throws NullParameter
	{
		if (titulo == null || codigo == null || autores == null || editorial == null)
		{
			throw new NullParameter();
		}
		libros = Arrays.copyOf(libros, libros.length + 1);
		libros[libros.length - 1] = new Libro(titulo, codigo, autores, editorial, edicion);
	}
	
	// Adds a user
	public void anadirUsuario(String nombre, String cc, String telefono, String tipo) throws NullParameter
	{
		if (nombre == null || cc == null || telefono == null || tipo == null)
		{
			throw new NullParameter();
		}
		usuarios = Arrays.copyOf(usuarios, usuarios.length + 1);
		usuarios[usuarios.length - 1] = new Usuario(nombre, cc, telefono, tipo);
	}
	
	// Adds a loan
	public void anadirPrestamo(String usuario, String libros[], Date fechaPrestamo, Date fechaDevolucion) throws DoesNotExist, NoExemplaryAvailable, NullParameter, DateException, PrestamoActivo
	{
		if (usuario == null || fechaPrestamo == null || fechaDevolucion == null)
		{
			throw new NullParameter();
		}
		
		Ejemplar ejemplares[] = new Ejemplar[libros.length];
		
		for (int i = 0; i < libros.length; i++)
		{
			ejemplares[i] = this.libros[buscarPosicionLibro(libros[i])].getAlgunEjemplarDisponible();
			ejemplares[i].setDisponibilidad(false);
		}
		
		prestamos = Arrays.copyOf(prestamos, prestamos.length + 1);
		prestamos[prestamos.length - 1] = new Prestamo(this.usuarios[buscarPosicionUsuario(usuario)], ejemplares, fechaPrestamo, fechaDevolucion);
	}

	// Deletes an exemplary
	public void eliminarEjemplar(String libro, String ejemplar) throws DoesNotExist, NullParameter
	{
		if (libro == null || ejemplar == null)
		{
			throw new NullParameter();
		}
		
		this.libros[buscarPosicionLibro(libro)].eliminarEjemplar(ejemplar);

	}
	
	// Searches for a book given its name
	public Libro buscarLibro(String nombre) throws DoesNotExist, NullParameter
	{
		if (nombre == null)
		{
			throw new NullParameter();
		}
		
		return libros[buscarPosicionLibro(nombre)];
	}
	
	// Searches for a lending given the user Id
	public Prestamo buscarPrestamoPorUsuario(String cc) throws DoesNotExist, NullParameter
	{
		if (cc == null)
		{
			throw new NullParameter();
		}
		
		return prestamos[buscarPosicionPrestamo(cc)];
	}
	
	// Deletes a book
	public void eliminarLibro(String nombre) throws DoesNotExist, NullParameter
	{
		if (nombre == null)
		{
			throw new NullParameter();
		}
		
		int i = buscarPosicionLibro(nombre);
		
		System.arraycopy(libros, i + 1, libros, i, libros.length - (i + 1));
		libros = Arrays.copyOf(libros, libros.length - 1);
	}
	
	// Deletes a lending, and restores the exemplaries to available, and the user to not having a lending active
	public void liberarPrestamo(String cc) throws DoesNotExist, NullParameter
	{
		if (cc == null)
		{
			throw new NullParameter();
		}
		
		int posicion = buscarPosicionPrestamo(cc);
		Ejemplar libros[] = this.prestamos[posicion].getLibros();
		
		this.prestamos[posicion].getUsuario().setPrestamoActivo(false);		
		for (int i = 0; i < libros.length; i++)
		{
			libros[i].setDisponibilidad(true);
		}
		
		System.arraycopy(prestamos, posicion + 1, prestamos, posicion, prestamos.length - (posicion + 1));
		prestamos = Arrays.copyOf(prestamos, prestamos.length);
	}
	
	//Returns a user given its Id
	public Usuario buscarUsuario(String cc) throws DoesNotExist, NullParameter
	{
		if (cc == null)
		{
			throw new NullParameter();
		}
		
		return this.usuarios[buscarPosicionUsuario(cc)];
	}
	
	public void modificarLibro(String libro, String titulo, String codigo, String autores, String editorial, int edicion) throws DoesNotExist, NullParameter
	{
		if (libro == null || titulo == null || codigo == null || autores == null || editorial == null)
		{
			throw new NullParameter();
		}
		
		int posicion = buscarPosicionLibro(libro);
		
		libros[posicion].setTitulo(titulo);
		libros[posicion].setCodigo(codigo);
		libros[posicion].setAutores(autores);
		libros[posicion].setEditorial(editorial);
		libros[posicion].setEdicion(edicion);
	}
	
	public void modificarUsuario(String usuario, String nombre, String cc, String telefono, String tipo) throws DoesNotExist, NullParameter
	{
		if (usuario == null || nombre == null || cc == null || telefono == null || tipo == null)
		{
			throw new NullParameter();
		}
		
		int posicion = buscarPosicionUsuario(usuario);
		
		usuarios[posicion].setNombre(nombre);
		usuarios[posicion].setCc(cc);
		usuarios[posicion].setTelefono(telefono);
		usuarios[posicion].setTipo(tipo);
	}
	
	// Returns the book position in the array given its name
	private int buscarPosicionLibro(String nombre) throws DoesNotExist
	{
		int i = 0;
		int x = libros.length;
		while (i < x)
		{
			if (nombre.compareTo(libros[i].getTitulo()) == 0)
			{
				return i;
			}
			i++;
		}
		
		throw new DoesNotExist();
	}
	
	// Returns the user position in the array given its Id
	private int buscarPosicionUsuario(String cc) throws DoesNotExist
	{
		int i = 0;
		int x = usuarios.length;
		
		while (i < x)
		{
			if (usuarios[i].getCc().compareTo(cc) == 0)
			{
				return i;
			}
			i++;
		}
		
		throw new DoesNotExist();
	}
	
	// Searches for the position of a lending in the array given the users Id
	private int buscarPosicionPrestamo(String cc) throws DoesNotExist
	{
		int i = 0;
		int x = prestamos.length;
		
		while (i < x)
		{
			if (prestamos[i].getUsuario().getCc().compareTo(cc) == 0)
			{
				return i;
			}
			i++;
		}
		
		throw new DoesNotExist();
	}
}