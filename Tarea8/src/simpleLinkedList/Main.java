package simpleLinkedList;

public class Main {
	public static void main(String[] args)
	{
		SimpleLinkedList<Persona> l = new SimpleLinkedList<>();
		
		Persona p1 = new Persona("Jefrey", 18);
		Persona p2 = new Persona("Adones", 23);
		Persona p3 = new Persona("Catsimus Prime", 47);
		
		l.add(p1);
		// System.out.println(l.getIndexOf(p1));
		l.addAtStart(p2);
		// System.out.println(l.getIndexOf(p1));
		//System.out.println(l.getInfoAt(1));
		l.add(p3);
		
		System.out.println("The current size of the list is: " + l.length());
		
		l.printList();
		
		try 
		{
			l.addAt(1, new Persona("Elliot", 18));
		} 
		catch (CustomException e) 
		{
			e.printStackTrace();
		}
		
		l.printList();
		
		try 
		{
			l.eliminate(p2);
		} 
		catch (CustomException e) 
		{
			e.printStackTrace();
		}
		
		try
		{
			l.eliminate(2);
		}
		catch (CustomException e)
		{
			e.printStackTrace();
		}
		
		l.printList();
		
		System.out.println("The current size of the list is: " + l.length());
	}
}
