package Main;

import java.io.IOException;
import java.util.Arrays;

import Clases.*;
import ControladorDeFicheros.ControladorDeFicheros;

public class Cine {
	// Hora en formato 24h, sin minutos
	private int hora;
	// La primera dimension es el turno, la segunda es cada pelicula segun la sala
	private Pelicula[][] horario;
	
	private ClienteRegistrado[] clientes;
	private Trabajador[] trabajadores;
	private Pelicula[] peliculas;
	private SalaCine[] salas;
	private Dato datos;
	private ControladorDeFicheros ficheros;
	
	/*
	 * anadir un boton en la pag principal para anadir una sala. Esto sera solo un boton
	 * el cual se presiona y se anade automaticamente una sala extra.
	 */
	
	
	// Cada turno son 2 horas
	public static final byte numeroTurnos = 4;
	
	public Cine()
	{
		ficheros = new ControladorDeFicheros();
		try
		{
			clientes = ficheros.readClientes();
			peliculas = ficheros.readPeliculas();
			salas = ficheros.readSalas();
			datos = ficheros.readDatos();
			horario = ficheros.readHorario();
			hora = ficheros.readHora();
			//salas = Arrays.copyOf(salas, 2);
			
		}
		catch (IOException | ClassNotFoundException e)
		{		
			inicializarDesdeCero();
		}
		
		//inicializarDesdeCero();
		
		try 
		{
			trabajadores = ficheros.readTrabajadores();
		} 
		catch (ClassNotFoundException | IOException e) 
		{		}
	}

	
	public ClienteRegistrado[] getClientes() {
		return clientes;
	}

	public Trabajador[] getTrabajadores() {
		return trabajadores;
	}

	public Pelicula[] getPeliculas() {
		return peliculas;
	}

	public SalaCine[] getSalas() {
		return salas;
	}

	public Dato getDatos() {
		return datos;
	}
	
	public int getHora() {
		return hora;
	}

	public Pelicula[][] getHorario() {
		return horario;
	}
	
	public void setHorario(Pelicula[][] horario)
	{
		this.horario = horario;
	}

	// Devuelve un objeto cliente dado el documento
	public ClienteRegistrado getCliente(String cc)
	{
		int i = 0;
		int x = clientes.length;
		
		while (i < x && clientes[i].getCc().compareTo(cc) != 0)
		{
			i++;
		}
		
		return (i == x) ? null : clientes[i];
	}
	
	// Anade una pelicula a la lista de peliculas
	public void anadirPelicula(Pelicula p)
	{
		peliculas = Arrays.copyOf(peliculas, peliculas.length + 1);
		peliculas[peliculas.length - 1] = p;
	}
	
	// Anade un cliente a la lista de clientes
	public void anadirCliente(ClienteRegistrado c)
	{
		clientes = Arrays.copyOf(clientes, clientes.length + 1);
		clientes[clientes.length - 1] = c;
	}
	
	// Anade una sala a la lista de salas
	public void anadirSala(SalaCine s)
	{
		salas = Arrays.copyOf(salas, salas.length + 1);
		ampliarHorario();
		salas[salas.length - 1] = s;
	}
	
	// Retorna verdadero si el cliente con la cedula dada, existe, de lo contrario 
		// retorna falso
	public boolean existeCliente(String cc)
	{
		int i = 0;
		int x = clientes.length;
		
		while (i < x && clientes[i].getCc().compareTo(cc) != 0)
		{
			i++;
		}
		
		return (i == x) ? false : true;
	}
	
	// Escribe toda la info en los ficheros
	public void terminarEjecucion() throws IOException
	{
		ficheros.escribirClientes(clientes);
		ficheros.escribirHorario(horario);
		ficheros.escribirHora(hora); 
		ficheros.escribirPeliculas(peliculas);
		ficheros.escribirSalas(salas);
		ficheros.escribirDatos(datos);
	}
	
	// Cambia a la siguiente hora (en cambios de 2 horas, 
	// 0 es las 8am, 1 es las 10am, 2 es las 12pm, asi hasta 8 siendo 10pm.
	public void turnoSiguiente()
	{
		if (hora == numeroTurnos)
		{
			hora = 0;
		}
		else
		{
			hora ++;
		}
	}
	
	private void inicializarDesdeCero()
	{
		inicializarHorario();
		this.clientes = new ClienteRegistrado[0];
		this.peliculas = new Pelicula[0];
		this.salas = new SalaCine[0];
		this.datos = new Dato();
	}
	
	private void inicializarHorario()
	{
		this.horario = new Pelicula[numeroTurnos][0];
		
	}
	
	private void ampliarHorario()
	{
		for (int i = 0; i < numeroTurnos; i++)
		{
			this.horario[i] = Arrays.copyOf(this.horario[i], this.horario[i].length + 1);
		}
	}
}