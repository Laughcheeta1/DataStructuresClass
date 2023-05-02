package Tarea;

import java.util.Arrays;

public class Empresa {
	private Producto productos[];
	private Semana dia;
	
	//public static final int numeroProductos = 10;
	
	public Empresa(Semana dia)
	{
		productos = new Producto[0];
		this.dia = dia;
	}
	
	public Semana getDia()
	{
		return this.dia;
	}
	
	// Continues to the next day
	public void diaSiguiente()
	{
		dia = dia.siguiente();
		
		for (Producto i : productos)
		{
			i.diaSiguiente();
		}
	}
	
	// Adds a product to the array
	public void anadirProducto()
	{
		/*
		if (productos.length > numeroProductos)
			return;*/
		
		productos = Arrays.copyOf(productos, productos.length + 1);
		productos[productos.length - 1] = new Producto(this.dia);
	}
	
	// Deletes a given product from the array
	public void quitarProducto(int producto)
	{
		if (producto > productos.length)
			return;
		
		System.arraycopy(productos, producto - 1, productos, producto, productos.length - producto);
		productos = Arrays.copyOf(productos, productos.length - 1);
		
	}
	
	// Adds the production of the day for a given product
	public void agregarProduccionProducto(int producto, int produccion)
	{
		if (producto > productos.length)
			return;
		
		productos[producto - 1].anadirProduccion(produccion);
	}
	
	// Return the total production of the week
	public int getProduccionTotalSemana()
	{
		int total = 0;
		
		for (Producto i : productos)
		{
			total += i.getProduccionSemana();
		}
		
		return total;
	}
	
	// Returns the total production for a given day
	public int getProduccionTotalDia(Semana dia)
	{
		int total = 0;
		
		for (Producto i : productos)
		{
			total += i.getProduccionDia(dia);
		}
		
		return total;
	}
	
	// Return the production of the week for a given product
	public int getProduccionSemanaProducto(int producto)
	{	
		if (producto > productos.length)
			return -1;
		
		return productos[producto - 1].getProduccionSemana();
	}
	
	// Returns the production of a given product in a given day
	public int getProduccionDiaProducto(int producto, Semana dia)
	{	
		if (producto > productos.length)
			return -1;
		
		return productos[producto - 1].getProduccionDia(dia);
	}
}
