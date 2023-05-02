package priorityQueue;
import java.util.Comparator;
import java.util.PriorityQueue;

class Comp implements Comparator<Persona>
{
	
	@Override
	public int compare(Persona p1, Persona p2)
	{
		int puntajeP1 = 0;
		int puntajeP2 = 0;
		
		if (p1.isDisabled())
		{
			puntajeP1 += 2;
		}
		if (p1.isPregnant())
		{
			puntajeP1 += 1;
		}
		
		if (p2.isDisabled())
		{
			puntajeP2 += 2;
		}
		if (p2.isPregnant())
		{
			puntajeP2 += 1;
		}
		
		return puntajeP2 - puntajeP1;
	}
}

public class PracticaPriorityQueue {
	public static void main(String[] args)
	{
		// Priority queue prioriza los numeros que comparados dan un numero mas pequenos (es decir, por como tenemos
		// el Comparator, el priority queue va a dar primero las Personas con los nombre mas pequenos, si pusieramos en vez
		// "p2.getEdad() - p1.getEdad()", el priority queue mostrara primero los de mayor edad)
		PriorityQueue<Persona> pq = new PriorityQueue<>(new Comp());
		
		pq.add(new Persona("Jeffry", 18, true, true));
		pq.add(new Persona("Adonis", 36, true, false));
		pq.add(new Persona("Andrew", 36, false, false));
		pq.add(new Persona("Tristan", 34, false, true));
		pq.add(new Persona("Julio", 19, false, true));
		pq.add(new Persona("Sebastian", 18, false, false));
		
		while (!pq.isEmpty())
		{
			System.out.println(pq.poll());
		}
	}
}
