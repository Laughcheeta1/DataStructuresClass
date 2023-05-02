package Tarea;

import java.util.Arrays;

public class Producto {
	private int produccion[];
	private Semana dia;
	
	public Producto(Semana dia)
	{
		this.dia = dia;
		produccion = new int[Semana.tamano];
		Arrays.fill(produccion, 0);
	}
	
	// Returns the production of a given day
	public int getProduccionDia(Semana dia)
	{
		return produccion[dia.ordinal()];
	}
	
	// Returns the whole production of the week
	public int getProduccionSemana()
	{
		int total = 0;
		
		for (int i : produccion)
		{
			total += i;
		}
		
		return total;
	}
	
	// Adds the production of the current day
	public void anadirProduccion(int produccion)
	{		
		this.produccion[dia.ordinal()] = produccion;
	}
	
	// Continues to the other day, and if monday, resets the production for the whole week
	public void diaSiguiente()
	{
		dia = dia.siguiente();
		
		if (dia == Semana.LUNES)
		{
			resetearSemana();
		}
	}
	
	// Resets the weekly production
	private void resetearSemana()
	{
		int x = produccion.length;
		
		for (int i = 0; i < x; i++)
		{
			produccion[i] = 0;
		}
	}
	
}