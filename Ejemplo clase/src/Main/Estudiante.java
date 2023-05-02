package Main;

public class Estudiante {
	private static int numeroEstudiantesCreados = 0;
	
	public Estudiante()
	{
		anadirEstudiante();
	}
	
	public static int getNumeroEstudiantesCreados() {
		return numeroEstudiantesCreados;
	}
	
	private static void anadirEstudiante()
	{
		numeroEstudiantesCreados ++;
	}
}
