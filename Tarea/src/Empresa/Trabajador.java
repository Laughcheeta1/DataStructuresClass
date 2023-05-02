package Empresa;

public class Trabajador {
	private double salarioBasico;
	private int diasTrabajados;
	private String nombre;
	public static final int cantidadDias = 24;
	
	public Trabajador(String nombre, double salarioBasico)
	{
		this.nombre = nombre;
		this.salarioBasico = salarioBasico;
		this.diasTrabajados = 0;
	}

	public double getSalarioBasico() {
		return salarioBasico;
	}

	public void setSalarioBasico(double salarioBasico) {
		this.salarioBasico = salarioBasico;
	}

	public int getDiasTrabajados() {
		return diasTrabajados;
	}

	public void setDiasTrabajados(int diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double calcularSalario()
	{
		return salarioBasico * diasTrabajados / cantidadDias;
	
	}
	

}
