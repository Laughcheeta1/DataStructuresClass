
public class Main {
	public static void main(String[] args)
	{
		SimpleLinkedList<Persona> l = new SimpleLinkedList<>();
		
		Persona p1 = new Persona("Jefrey", 18);
		Persona p2 = new Persona("Adones", 23);
		
		l.add(p1);
		// System.out.println(l.getIndexOf(p1));
		l.addAtStart(p2);
		// System.out.println(l.getIndexOf(p1));
		//System.out.println(l.getInfoAt(1));
		
		l.printList();
		l.addAt(1, new Persona("Elliot", 18));
		l.printList();
		l.eliminate(p2);
		l.printList();
	}
}
