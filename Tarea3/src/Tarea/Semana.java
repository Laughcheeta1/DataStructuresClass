package Tarea;

public enum Semana {
	LUNES,
	MARTES,
	MIERCOLES,
	JUEVES,
	VIERNES;
	
	// Code from @Jim Garrison (Stack overflow). Question: "What's the best way to implement 'next' and 'previous' on an enum type?"
		private static final Semana vals[] = values();
		
		public static final int tamano = vals.length;
		
		// Code from @Jim Garrison (Stack overflow). Question: "What's the best way to implement 'next' and 'previous' on an enum type?"
		public Semana siguiente()
		{
			return vals[(this.ordinal() + 1) % vals.length];
		}
		
		// Code from @kruk (Stack overflow). Question: "What's the best way to implement 'next' and 'previous' on an enum type?"
		public Semana anterior()
		{
			return vals[(this.ordinal() - 1 + vals.length) % vals.length];
		}
}
