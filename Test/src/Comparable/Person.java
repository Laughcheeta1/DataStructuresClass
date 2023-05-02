package Comparable;

public class Person implements Comparable <Person>{

	private String nombre;
	private int edad;
	
	public Person(String nombre, int edad)
	{
		this.nombre = nombre;
		this.edad = edad;
	}
	
	/**
	 * Returns the name
	 */
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getEdad()
	{
		return this.edad;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void setEdad(int edad)
	{
		this.edad = edad;
	}
	
	@Override
	public int compareTo(Person o) {
		int result = this.nombre.compareTo(o.getNombre());
		
		return (result == 0) ? this.edad - o.getEdad() : result;
	}
	
	public String toString()
	{
		return this.nombre + "-" + this.edad;
	}
}
