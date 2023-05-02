package Empresa2;

import java.util.Arrays;

public class Proyecto {
	private int horasTrabajadasMes[];
	
	// Constructor 1
	public Proyecto()
	{
		horasTrabajadasMes = new int[0];
	}
	
	// Adds and hour to the array
	public void anadirHoraMes(int hora)
	{
		if (hora < 0)
		{
			return;
		}
		
		horasTrabajadasMes = Arrays.copyOf(horasTrabajadasMes, horasTrabajadasMes.length + 1);
		horasTrabajadasMes[horasTrabajadasMes.length - 1] = hora;
	}
	
	// Return the total number of hours spent in this project
	public int getHorasTotales()
	{
		int horasTotales = 0;
		
		for (int i : horasTrabajadasMes)
		{
			horasTotales += i;
		}
		
		return horasTotales;
	}
	
	// Gets the month as of month 1, month 2, etc.
	public int getHorasMes(int mes)
	{
		try
		{
			return horasTrabajadasMes[mes - 1];
		}
		catch (Exception e)
		{
			return 0;
		}
	}
	
	// Return the whole array of hours
	public int[] getHoras()
	{
		return horasTrabajadasMes;
	}
}
