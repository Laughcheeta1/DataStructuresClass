package Empresa2;

public class Main {
	public static void main(String[] argc)
	{
		Empresa e1 = new Empresa();
		
		e1.anadirHorasProyecto(4, 1);
		e1.anadirHorasProyecto(5, 2);
		e1.anadirHorasProyecto(8, 1);
		
		System.out.printf("El numero de horas del proyecto 1 en el mes 2 es: %d\n", e1.getHorasMesProyecto(1, 2));
		System.out.printf("El numero total de horas del proyecto 1: %d\n", e1.getHorasTotalesProyecto(1));
		System.out.printf("El numero de horas totales de los proyectos es: %d\n", e1.getHorasTotales());
	}
}
