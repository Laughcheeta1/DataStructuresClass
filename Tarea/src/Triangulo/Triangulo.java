package Triangulo;
import java.lang.Math;

public class Triangulo {
	private float l1;
	private float l2;
	private float l3;
	private char clasificacion;
	private double area;
	private double perimetro;
	
	
	//Constructor, getters and setters
	
	public Triangulo(float l1, float l2, float l3) {
		super();
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		clasificacion();
		calcularArea();
		calcularPerimetro();
	}

	public float getL1() {
		return l1;
	}

	public void setL1(float l1) {
		this.l1 = l1;
		clasificacion();
		calcularArea();
		calcularPerimetro();
	}

	public float getL2() {
		return l2;
	}

	public void setL2(float l2) {
		this.l2 = l2;
		clasificacion();
		calcularArea();
		calcularPerimetro();
	}

	public float getL3() {
		return l3;
	}

	public void setL3(float l3) {
		this.l3 = l3;
		clasificacion();
		calcularArea();
		calcularPerimetro();
	}

	public char getClasificacion() {
		return clasificacion;
	}

	public double getArea() {
		return area;
	}

	public double getPerimetro() {
		return perimetro;
	}
	
	
	//Methods
	
	private void clasificacion()
	{
		clasificacion = (l1 == l2 && l2 == l3) ? 'q' : (l1 == l2 || l1 == l3 || l2 == l3) ? 'i' : 'e';
	}
	
	private void calcularArea()
	{
		//Heron formula
		area = 0.25 * Math.sqrt((l1 + l2 + l3) * (- l1 + l2 + l3) * (l1 - l2 + l3) * (l1 + l2 - l3));
	}
	
	private void calcularPerimetro()
	{
		perimetro = l1 + l2 + l3;
	}
	
}
