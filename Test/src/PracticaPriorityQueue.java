import java.util.Comparator;
import java.util.PriorityQueue;

class Comp implements Comparator<Persona>
{
	private String tipo;
	
	public Comp(String tipo)
	{
		this.tipo = tipo;
	}
	
	@Override
	public int compare(Persona p1, Persona p2)
	{
		return (tipo.compareTo("nombre") == 0) ? p1.getNombre().compareTo(p2.getNombre()) : p1.getEdad() - p2.getEdad();
	}
}

public class PracticaPriorityQueue {
	public static void main(String[] args)
	{
		// Priority queue prioriza los numeros que comparados dan un numero mas pequenos (es decir, por como tenemos
		// el Comparator, el priority queue va a dar primero las Personas con los nombre mas pequenos, si pusieramos en vez
		// "p2.getEdad() - p1.getEdad()", el priority queue mostrara primero los de mayor edad)
		PriorityQueue<Persona> pq = new PriorityQueue<>(new Comp("nombre"));
		
		pq.add(new Persona("Jeffry", 18));
		pq.add(new Persona("Adonis", 36));
		pq.add(new Persona("Andrew", 36));
		pq.add(new Persona("Tristan", 34));
		pq.add(new Persona("Julio", 19));
		pq.add(new Persona("Sebastian", 18));
		
		while (!pq.isEmpty())
		{
			System.out.println(pq.poll());
		}
	}
}
