package Trabajador;

public abstract class Trabajador {
	protected String nombre;
	protected float sb;
	protected float dt;
	
	public Trabajador(String nombre, float sb, float dt)
	{
		this.nombre = nombre;
		this.sb = sb;
		this.dt = dt;
	}
	
	public float salario()
	{
		return sb * dt / 24;
	}
}
