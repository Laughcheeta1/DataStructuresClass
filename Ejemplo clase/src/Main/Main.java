package Main;

public class Main {

	public static void main(String[] args) {
		System.out.println(Estudiante.getNumeroEstudiantesCreados());
		Estudiante e1 = new Estudiante();
		Estudiante e2 = new Estudiante();
		System.out.println(Estudiante.getNumeroEstudiantesCreados());
	}
}
