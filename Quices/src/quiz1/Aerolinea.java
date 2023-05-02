package quiz1;

import java.util.Arrays;

import CustomExceptiom.ObjectDoesNotExist;

public class Aerolinea {
	private Avion[] aviones;
	private Vuelo[] vuelos;
	private Aeropuerto[] aeropuertos;
	private Cliente[] clientes;
	
	public Aerolinea(Avion[] aviones, Vuelo[] vuelos, Aeropuerto[] aeropuertos, Cliente[] clientes) {
		super();
		this.aviones = aviones;
		this.vuelos = vuelos;
		this.aeropuertos = aeropuertos;
		this.clientes = clientes;
	}

	public Aerolinea() {
		super();
	}

	public Avion[] getAviones() {
		return aviones;
	}

	public void setAviones(Avion[] aviones) {
		this.aviones = aviones;
	}

	public Vuelo[] getVuelos() {
		return vuelos;
	}

	public void setVuelos(Vuelo[] vuelos) {
		this.vuelos = vuelos;
	}

	public Aeropuerto[] getAeropuertos() {
		return aeropuertos;
	}

	public void setAeropuertos(Aeropuerto[] aeropuertos) {
		this.aeropuertos = aeropuertos;
	}

	public Cliente[] getClientes() {
		return clientes;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}	
	
	
	
	public void anadirAvion(Avion avion)
	{
		aviones = Arrays.copyOf(aviones, aviones.length + 1);
		aviones[aviones.length - 1] = avion;
	}
	
	public void quitarAvion(String codigo) throws ObjectDoesNotExist
	{
		int posicion = getPosicionAvion(codigo);
		
		if (posicion == -1)
		{
			throw new ObjectDoesNotExist();
		}
		
		System.arraycopy(aviones, posicion + 1, aviones, posicion, aviones.length - posicion);
		aviones = Arrays.copyOf(aviones, aviones.length - 1);
	}
	
	public int getPosicionAvion(String codigo)
	{
		int i = 0;
		int x = aviones.length;
		while (i < x && aviones[i++].getCodigo().compareTo(codigo) != 0);
		
		--i;
		
		return (i == x) ? -1 : i;
	}
	
	
	
	public void anadirVuelo(Vuelo vuelo)
	{
		vuelos = Arrays.copyOf(vuelos, vuelos.length + 1);
		vuelos[vuelos.length - 1] = vuelo;
	}
	
	public void quitarVuelo(String codigo) throws ObjectDoesNotExist
	{
		int posicion = getPosicionVuelo(codigo);
		
		if (posicion == -1)
		{
			throw new ObjectDoesNotExist();
		}
		
		System.arraycopy(vuelos, posicion + 1, vuelos, posicion, vuelos.length - (posicion + 1));
		vuelos = Arrays.copyOf(vuelos, vuelos.length - 1);
	}
	
	private int getPosicionVuelo(String codigo) 
	{
		int i = 0;
		int x = vuelos.length;
		while (i < x && vuelos[i++].getCodigo().compareTo(codigo) != 0);
		
		--i;
		
		return (i == x) ? -1 : i;
	}
	
	
	
	public void anadirAeropuerto(Aeropuerto aeropuerto)
	{
		aeropuertos = Arrays.copyOf(aeropuertos, aeropuertos.length + 1);
		aeropuertos[aeropuertos.length - 1] = aeropuerto;
	}
	
	public void quitarAeropuerto(String nombre) throws ObjectDoesNotExist
	{
		int posicion = getPosicionAeropuerto(nombre);
		
		if (posicion == -1)
		{
			throw new ObjectDoesNotExist();
		}
		
		System.arraycopy(aeropuertos, posicion + 1, aeropuertos, posicion, aeropuertos.length - (posicion + 1));
		aeropuertos = Arrays.copyOf(aeropuertos, aeropuertos.length - 1);
	}
	
	private int getPosicionAeropuerto(String nombre) 
	{
		int i = 0;
		int x = aeropuertos.length;
		while (i < x && aeropuertos[i++].getNombre().compareTo(nombre) != 0);
		
		--i;
		
		return (i == x) ? -1 : i;
	}
	
	
	
	public void anadirCliente(Cliente cliente)
	{
		clientes = Arrays.copyOf(clientes, clientes.length + 1);
		clientes[clientes.length - 1] = cliente;
	}
	
	public void quitarCliente(String identificacion) throws ObjectDoesNotExist
	{
		int posicion = getPosicionCliente(identificacion);
		
		if (posicion == -1)
		{
			throw new ObjectDoesNotExist();
		}
		
		System.arraycopy(clientes, posicion + 1, clientes, posicion, clientes.length - (posicion + 1));
		clientes = Arrays.copyOf(clientes, clientes.length - 1);
	}
	
	private int getPosicionCliente(String identificacion) 
	{
		int i = 0;
		int x = clientes.length;
		while (i < x && clientes[i++].getIdentificacion().compareTo(identificacion) != 0);
		
		--i;
		
		return (i == x) ? -1 : i;
	}
}
