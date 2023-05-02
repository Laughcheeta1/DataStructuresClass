package Tarea;

public class Main {
	public static void main(String[] argc)
	{
		Empresa e = new Empresa(Semana.JUEVES);
		
		System.out.println("Es " + e.getDia());
		
		e.anadirProducto();
		e.anadirProducto();
		
		e.agregarProduccionProducto(1, 73);
		e.agregarProduccionProducto(2, 98);
		
		e.diaSiguiente();
		System.out.println("Es " + e.getDia());
		
		e.agregarProduccionProducto(1, 105);
		e.agregarProduccionProducto(2, 211);
		
		System.out.printf("Produccion del producto 1 en el dia jueves: %d\n", e.getProduccionDiaProducto(1, Semana.JUEVES));
		System.out.printf("Produccion en toda la semana del producto 2: %d\n", e.getProduccionSemanaProducto(2));
		System.out.printf("Produccion total en el dia viernes: %d\n", e.getProduccionTotalDia(Semana.VIERNES));
		System.out.printf("Produccion total semana: %d\n", e.getProduccionTotalSemana());
		
		e.diaSiguiente();
		
		System.out.println("---------------------");
		System.out.println("Ahora es " + e.getDia());
		
		System.out.printf("Produccion del producto 1 en el dia jueves: %d\n", e.getProduccionDiaProducto(1, Semana.JUEVES));
		System.out.printf("Produccion en toda la semana del producto 2: %d\n", e.getProduccionSemanaProducto(2));
		System.out.printf("Produccion total en el dia viernes: %d\n", e.getProduccionTotalDia(Semana.VIERNES));
		System.out.printf("Produccion total semana: %d\n", e.getProduccionTotalSemana());
		
	}
}
