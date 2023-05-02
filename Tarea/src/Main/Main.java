package Main;
import Empresa.*;
import Estudiante.Estudiante;
import Triangulo.Triangulo;
import Calculadora.Calculadora;

public class Main {

	public static void main(String[] args) {
		
		Empresa em1 = new Empresa();
		
		Trabajador t1 = new Trabajador("Juan", 90);
		Trabajador t2 = new Trabajador("Joe", 100);
		Trabajador t3 = new Trabajador("Santiago", 780);
		
		em1.anadirTrabajador(t1);
		em1.anadirTrabajador(t2);
		em1.anadirTrabajador(t3);
		
		em1.asignarDiasTrabajador("Santiago", 31);
		em1.asignarDiasTrabajador("Joe", 31);
		em1.asignarDiasTrabajador("Juan", 31);
		
		//System.out.println(t3.getDiasTrabajados());
		
		//System.out.println(em1.buscarTrabajador("Santiago"));
		//System.out.println(em1.getSalarioMasPequeno());
		
		for (Trabajador t : em1.getTrabajadores())
		{
			System.out.println(t.getNombre());
		}
		
		System.out.println("----------------------------------------------------------------");
		
		em1.eliminarTrabajadorPorNombre("Joe");
		
		for (Trabajador t : em1.getTrabajadores())
		{
			System.out.println(t.getNombre());
		}
		
		/*
		System.out.println(Estudiante.getNumeroEstudiantesCreados());
		
		Estudiante e1 = new Estudiante(3, 5, 2);
		Estudiante e2 = new Estudiante( 2, 2, 5);
		
		System.out.println(e1.calcularCalificacion());
		
		System.out.println(Estudiante.getNumeroEstudiantesCreados());*/
		
		/*
		Triangulo t1 = new Triangulo(3, 4, 5);
		
		System.out.printf("Area = %.2f, perimetro = %.2f y clasificacion = %c", t1.getArea(), t1.getPerimetro(), t1.getClasificacion());
		*/
		
		/*
		System.out.println(Calculadora.MCD(81, 27));
		System.out.println(Calculadora.factorial(5));*/
		
		
	}
}