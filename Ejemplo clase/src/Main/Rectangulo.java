package Main;

public class Rectangulo {
	private float alto;
	private float ancho;
	
	
	public Rectangulo(float alto, float ancho) {
		super();
		this.alto = alto;
		this.ancho = ancho;
	}
	
	public float getAlto() {
		return alto;
	}
	public void setAlto(float alto) {
		this.alto = alto;
	}
	public float getAncho() {
		return ancho;
	}
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}
	
	//Methods
	
	//Return the perimeter
	public double perimetro()
	{
		return 2*alto + 2*ancho;
	}
	
	//Returns the area
	public double area()
	{
		return alto*ancho;
	}
}
