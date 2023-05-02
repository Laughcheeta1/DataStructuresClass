package Biblioteca;

import customExceptions.*;
import java.util.Arrays;
import java.util.Date;

public class Prestamo {
	private Usuario usuario;
	private Ejemplar libros[];
	private Date fechaPrestamo;
	private Date fechaDevolucion;
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
	
	public Prestamo(Usuario usuario, Ejemplar[] libros, Date fechaPrestamo, Date fechaDevolucion) throws DateException, NullParameter, PrestamoActivo
	{
		if (usuario.getPrestamoActivo())
		{
			throw new PrestamoActivo();
		}
		
		usuario.setPrestamoActivo(true);
		
		this.usuario = usuario;
		this.libros = libros;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public Ejemplar[] getLibros() {
		return libros;
	}



	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}



	public Date getFechaDevolucion() {
		return fechaDevolucion;
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
	
	//Extends the date of return for the Lending
	public void extenderFechaDevolucion(Date fechaDevolucion) throws DateException, NullParameter
	{
		if (fechaDevolucion == null)
		{
			throw new NullParameter();
		}
		else if (fechaDevolucion.before(this.fechaDevolucion))
		{
			throw new DateException();
		}
		
		this.fechaDevolucion = fechaDevolucion;
	}

	@Override
	public String toString() {
		return "Prestamo [usuario=" + usuario + ", libros=" + Arrays.toString(libros) + ", fechaPrestamo="
				+ fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + "]";
	}
	
	
}
