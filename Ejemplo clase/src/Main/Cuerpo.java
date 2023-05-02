package Main;

public class Cuerpo {
	private double espacio;
	private double tiempo;
	
	public Cuerpo()
	{	}

	public Cuerpo(double espacio, double tiempo) {
		super();
		this.setEspacio(espacio);
		this.setTiempo(tiempo);
	}
	
	//Methods
	
	//Returns the velocity of the object
	public double velocidad()
	{
		return espacio/tiempo;
	}
	
	//Getters, Setters and toString
	
	@Override
	public String toString() {
		return "Cuerpo [espacio=" + espacio + ", tiempo=" + tiempo + "]";
	}

	public double getEspacio() {
		return espacio;
	}

	public void setEspacio(double espacio) {
		this.espacio = espacio;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	
	
}
