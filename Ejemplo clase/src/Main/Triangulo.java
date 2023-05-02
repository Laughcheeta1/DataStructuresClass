package Main;

public class Triangulo {
	private float l1;
	private float l2;
	private float l3;
	
	private float anglel1l2;
	private float anglel1l3;
	private float anglel2l3;
	
	private char clasificacion()
	{
		return (l1 == l2 && l2 == l3) ? 'q' : (l1 == l2 || l1 == l3 || l2 == l3) ? 'i' : 'e';
	}
	
	/*private float getAngle(float angle1, float side1, float side2)
	{
		
	}*/
}
