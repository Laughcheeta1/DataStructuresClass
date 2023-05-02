package Estudiante;
import java.lang.Math;

public class Estudiante {
	private static int numeroEstudiantesCreados = 0;
	
	private float[] notas = new float[3];
	
	public Estudiante(int n1, int n2, int n3)
	{
		anadirEstudiante();
		notas[0] = n1;
		notas[1] = n2;
		notas[2] = n3;
	}
	
	public char calcularCalificacion()
	{
		switch (promedioNotas())
		{
			case 5: 
				return 'B';
			case 4:
				return 'B';
			case 3:
				return 'R';
			case 2:
				return 'M';
			default:
				return 'M';
		}
	}
	
	private int promedioNotas()
	{
		float prom = 0;
		for(int i = 0; i < 3; i++)
		{
			prom += notas[i];
		}
		
		return Math.round(prom) / 3;
	}
	
	public static int getNumeroEstudiantesCreados() {
		return numeroEstudiantesCreados;
	}
	
	private void anadirEstudiante()
	{
		numeroEstudiantesCreados ++;
	}
}
