package Empresa2;

public class Empresa {
	private Proyecto proyectos[];
	private static final int numeroProyectos = 20;
	
	public Empresa()
	{
		proyectos = new Proyecto[numeroProyectos];
		
		for (int i = 0; i < numeroProyectos; i++) 
		{
			proyectos[i] = new Proyecto();
		}
	}
	
	public void anadirHorasProyecto(int horas, int proyecto)
	{
		if (proyecto > numeroProyectos || proyecto < 1) 
		{
			return;
		}
		
		proyectos[proyecto - 1].anadirHoraMes(horas);
	}
	
	// Give the project as of project 1, project 2, etc.
	// Returns the total hours of a project
 	public int getHorasTotalesProyecto(int proyecto)
	{
		return this.proyectos[proyecto - 1].getHorasTotales();
	}
	
	// Returns the hours spent on a given month
	public int getHorasMesProyecto(int proyecto, int mes)
	{
		return this.proyectos[proyecto - 1].getHorasMes(mes);
	}
	
	// Returns the array containing the hours per month
	public int[] getHorasProyecto(int proyecto)
	{
		return this.proyectos[proyecto - 1].getHoras();
	}
	
	// Returns the total hours spent in all the projects
	public int getHorasTotales()
	{
		int horasTotales = 0;
		
		for(Proyecto p : proyectos)
		{
			horasTotales += p.getHorasTotales();
		}
		
		return horasTotales;
	}
	
	// Returns the total hours spent in the projects for a given month
	public int getHorasTotalesMes(int mes)
	{
		int horasTotales = 0;
		
		for (Proyecto p : proyectos)
		{
			horasTotales += p.getHorasMes(mes);
		}
		
		return horasTotales;
	}
}
