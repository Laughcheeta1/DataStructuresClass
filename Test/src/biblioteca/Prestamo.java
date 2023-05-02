package biblioteca;

import customExceptions.*;

import java.io.Serializable;
import java.util.Arrays;

public class Prestamo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Ejemplar libros[];
	//private int numeroLibros;
	//private static final int maximaCantidadLibros = 3;
	
	/*public Prestamo(Usuario usuario, Date fechaPrestamo, Date fechaDevolucion) throws DateException, NullParameter
	{
		super();
		if (fechaPrestamo.after(fechaDevolucion))
		{
			throw new DateException();
		}
		else if (usuario == null|| fechaPrestamo == null || fechaDevolucion == null)
		{
			throw new NullParameter();
		}
		
		this.usuario = usuario;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		libros = new Ejemplar[maximaCantidadLibros];
		numeroLibros = 0;
	}*/
	
	public Prestamo(Usuario usuario, Ejemplar[] libros) throws NullParameter, PrestamoActivo
	{
		if (usuario.getPrestamoActivo())
		{
			throw new PrestamoActivo();
		}
		
		usuario.setPrestamoActivo(true);
		
		this.usuario = usuario;
		this.libros = libros;

	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public Ejemplar[] getLibros() {
		return libros;
	}
	
	public void setLibros(Ejemplar libros[])
	{
		this.libros = libros;
	}

	/*public void anadirEjemplar(Ejemplar ejemplar) throws ExceededMaximumNumber, NullParameter
	{
		if (ejemplar == null)
		{
			throw new NullParameter();
		}
		if (numeroLibros >= maximaCantidadLibros)
		{
			throw new ExceededMaximumNumber();
		}
		
		libros[numeroLibros] = ejemplar;
		numeroLibros ++;
	}*/

	@Override
	public String toString() {
		return "Prestamo [usuario=" + usuario + ", libros=" + Arrays.toString(libros);
	}
	
	
}
