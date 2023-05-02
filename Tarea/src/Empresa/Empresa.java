package Empresa;

import java.util.Arrays;

public class Empresa {
	private Trabajador trabajadores[];
	
	public Empresa()
	{
		trabajadores = new Trabajador[0];
	}
	
	public void anadirTrabajador(Trabajador trabajador)
	{
		trabajadores = Arrays.copyOf(trabajadores, trabajadores.length + 1);
		trabajadores[trabajadores.length - 1] = trabajador;
	}
	
	public void anadirTrabajador(String name, int salarioBasico)
	{
		trabajadores = Arrays.copyOf(trabajadores, trabajadores.length + 1);
		trabajadores[trabajadores.length - 1] = new Trabajador(name, salarioBasico);
	}
	
	public int buscarTrabajador(String nombre)
	{	
		int i = 0;
		
		while (i < trabajadores.length && trabajadores[i++].getNombre().compareTo(nombre) != 0);
		
		//We put -- because when the i gets out of the loop after finding the name, 
		//it will be summed up by 1, so if the worker is in the space 3, and it did find
		//it, after the i++, it will be 4. making so that the condition below is not true.
		return (--i < trabajadores.length) ? i : -1;
	}
	
	public void asignarDiasTrabajador(String nombre, int dias)
	{		
		int posicion = buscarTrabajador(nombre);
		
		if (posicion  == -1)
		{
			return;
		}
		
		trabajadores[posicion].setDiasTrabajados(dias);
	}
	
	public double getSalarioMasPequeno()
	{
		double salario = Double.POSITIVE_INFINITY;
		
		for (Trabajador t : trabajadores)
		{
			double x = t.calcularSalario();
			salario = (salario > x) ? x : salario; 
		}
		
		return salario;
	}
	
	
	public int getPosicionTrabajadorMenosPago()
	{
		int x = trabajadores.length;
		
		double salarioMinimo[] = {trabajadores[0].calcularSalario(), 0};
		
		for (int i = 1; i < x; i++)
		{
			double salario = trabajadores[i].calcularSalario();
			
			if (salarioMinimo[0] > salario)
			{
				salarioMinimo[0] = salario;
				salarioMinimo[1] = i;
			}
		}
		
		return (int)salarioMinimo[1];
	}
	
	public void eliminarTrabajadorPorNombre(String nombre)
	{
		int i = buscarTrabajador(nombre);
		
		System.arraycopy(trabajadores, i + 1, trabajadores, i, trabajadores.length - (i + 1));
		trabajadores = Arrays.copyOf(trabajadores, trabajadores.length - 1);
	}
	
	public Trabajador[] getTrabajadores()
	{
		return trabajadores;
	}
}
