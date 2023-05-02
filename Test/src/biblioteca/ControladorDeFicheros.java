package biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ControladorDeFicheros {
	private String ficheroUsuarios;
	private String ficheroLibros;
	private String ficheroPrestamos;
	
	public ControladorDeFicheros(String ficheroUsuarios, String ficheroLibros, String ficheroPrestamos) {
		this.ficheroUsuarios = ficheroUsuarios;
		this.ficheroLibros = ficheroLibros;
		this.ficheroPrestamos = ficheroPrestamos;
	}
	
	public void writeUsuarios(Usuario[] u) throws IOException
	{
		int x = u.length;
		for (int i = 0; i < x; i++)
		{
			FileOutputStream f = new FileOutputStream(ficheroUsuarios + "\\" + i + ".usuario");
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			o.writeObject(u[i]);
			
			o.close();
			f.close();
		}
	}
	
	public void writeLibros(Libro[] l) throws IOException
	{
		int x = l.length;
		for (int i = 0; i < x; i++)
		{
			FileOutputStream f = new FileOutputStream(ficheroLibros + "\\" + i + ".libroEjercicio");
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			o.writeObject(l[i]);
			
			o.close();
			f.close();
		}
	}
	
	public void writePrestamos(Prestamo[] p) throws IOException
	{
		int x = p.length;
		for (int i = 0; i < x; i++)
		{
			FileOutputStream f = new FileOutputStream(ficheroPrestamos + "\\" + i + ".prestamo");
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			o.writeObject(p[i]);
			
			o.close();
			f.close();
		}
	}
	
	public Usuario[] readUsuarios() throws IOException, ClassNotFoundException
	{
		File f = new File(ficheroUsuarios);
		File[] listF = f.listFiles(new Filtro(".usuario"));
		
		Usuario[] usuarios = new Usuario[listF.length];
		
		int x = listF.length;
		
		for (int i = 0; i < x; i++)
		{
			FileInputStream in = new FileInputStream(listF[i]);
			ObjectInputStream o = new ObjectInputStream(in);
			
			usuarios[i] = (Usuario)o.readObject();
			o.close();
			in.close();
		}
		
		return usuarios;
	}
	
	public Libro[] readLibros() throws IOException, ClassNotFoundException
	{
		File f = new File(ficheroLibros);
		File[] listF = f.listFiles(new Filtro(".libroEjercicio"));
		
		Libro[] libros = new Libro[listF.length];
		
		int x = libros.length;
		for (int i = 0; i < x; i++)
		{
			FileInputStream in = new FileInputStream(listF[i]);
			ObjectInputStream o = new ObjectInputStream(in);
			
			libros[i] = (Libro)o.readObject();
			
			o.close();
			in.close();
		}
		
		return libros;
	}
	
	public Prestamo[] readPrestamos() throws IOException, ClassNotFoundException
	{
		File f = new File(ficheroPrestamos);
		File[] listF = f.listFiles(new Filtro(".prestamo"));
		
		Prestamo[] prestamos = new Prestamo[listF.length];
		
		int x = listF.length;
		
		for (int i = 0; i < x; i++)
		{
			FileInputStream in = new FileInputStream(listF[i]);
			ObjectInputStream o = new ObjectInputStream(in);
			
			prestamos[i] = (Prestamo)o.readObject();
			
			o.close();
			in.close();
		}
		
		return prestamos;
	}

	public Usuario[] leerUsuarios() throws IOException
	{
		Usuario[] usuarios = new Usuario[0];
		
		File f = new File(ficheroUsuarios);
		FileReader fr = new FileReader(f);
		BufferedReader b = new BufferedReader(fr);
		String linea;
		String [] valores;
		
		while ((linea = b.readLine()) != null)
		{	
			valores = linea.split("    ");
			
			Usuario u = new Usuario(valores[0], valores[1], valores[2], valores[3], (valores[3].equals("true") ? true : false));
			
			usuarios = ampliarUsuario(usuarios, u);
		}
		
		b.close();
		fr.close();
		
		return usuarios;
	}
	
	public void escribirUsuarios(Usuario[] usuarios) throws IOException
	{
		File f = new File(ficheroUsuarios);
		FileWriter fr = new FileWriter(f);
		BufferedWriter b = new BufferedWriter(fr);
		
		for (Usuario u : usuarios)
		{
			b.write(u.getNombre() + "    ");
			b.write(u.getCc() + "    ");
			b.write(u.getTelefono() + "    ");
			b.write(u.getTipo() + "    ");
			b.write((u.getPrestamoActivo()) ? "true" : "false");
			b.newLine();
		}
		
		b.close();
		fr.close();
	}
	
	private Usuario[] ampliarUsuario(Usuario[] usuarios, Usuario usuario)
	{
		usuarios = Arrays.copyOf(usuarios, usuarios.length + 1);
		usuarios[usuarios.length - 1] = usuario;
		
		return usuarios;
	}
	
	
	public Libro[] leerLibros() throws IOException
	{
		Libro[] libros = new Libro[0];
		
		File f = new File(ficheroLibros);
		FileReader fr = new FileReader(f);
		BufferedReader b = new BufferedReader(fr);
		
		String s;
		String[] infoLibro;
		
		while ((s = b.readLine()) != null)
		{
			infoLibro = s.split("    ");
			
			Ejemplar[] ejem;
			
			Libro l;
			
			try
			{
				ejem = getEjemplares(infoLibro[5]);
				l = new Libro(infoLibro[0], infoLibro[1], infoLibro[2], infoLibro[3], Integer.parseInt(infoLibro[4]), ejem);
			}
			catch (IndexOutOfBoundsException e)
			{
				l = new Libro(infoLibro[0], infoLibro[1], infoLibro[2], infoLibro[3], Integer.parseInt(infoLibro[4]));
			}
			
			
			libros = ampliarLibro(libros, l);
		}
		
		b.close();
		fr.close();
		
		return libros;
	}
	
	public void escribirLibro(Libro[] libros) throws IOException
	{
		File f = new File(ficheroLibros);
		FileWriter fr = new FileWriter(f);
		BufferedWriter b = new BufferedWriter(fr);
		
		for (Libro l : libros)
		{
			b.write(l.getTitulo() + "    ");
			b.write(l.getCodigo() + "    ");
			b.write(l.getAutores() + "    ");
			b.write(l.getEditorial() + "    ");
			b.write(Integer.toString(l.getEdicion()) + "    ");
			try
			{
				b.write(ejemplaresToText(l.getEjemplares()));
			}
			catch (NullPointerException e)
			{
				
			}
			b.newLine();
		}
		
		b.close();
		fr.close();
	}
	
	private Libro[] ampliarLibro(Libro[] libros, Libro libro)
	{
		libros = Arrays.copyOf(libros, libros.length + 1);
		libros[libros.length - 1] = libro;
		
		return libros;
	}
	
	private Ejemplar[] getEjemplares(String s)
	{
		String [] infoEjemplares = s.split("   ");
		
		int x = infoEjemplares.length;
	
		Ejemplar[] ejemplares = new Ejemplar[x];
		for (int i = 0; i < x; i++)
		{
			ejemplares[i] = new Ejemplar(infoEjemplares[0], (infoEjemplares[1].equals("true")) ? true : false, (infoEjemplares[2].equals("true")) ? true : false);
		}
		
		return ejemplares;
	}
	
	private String ejemplaresToText(Ejemplar[] ejemplares)
	{
		String texto = "";
		
		for (Ejemplar e : ejemplares)
		{
			texto = texto.concat(e.getCodigo()).concat("  ").concat((e.getDispobilidad()) ? "true" : "false").concat("  ").concat((e.getEstaActivo()) ? "true" : "false").concat("   ");
		}
		
		return texto;
	}
}
