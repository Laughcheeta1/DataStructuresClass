package Comparable;

import java.util.Arrays;

public class Main {
	public static void main(String[] argc)
	{
		Person p1 = new Person("Marcela", 24);
		Person p2 = new Person("Oscar", 21);
		Person p3 = new Person("Marcela", 20);
		Person p4 = new Person("Andres", 26);
		Person p5 = new Person("Oscar", 30);
		Person p6 = new Person("Nadia", 21);
		
		Person[] listP = {p1, p2, p3, p4, p5, p6};
		printLista(listP);
		
		System.out.println();
		
		Person[] listTempP = Arrays.copyOf(listP, listP.length);
		bubbleSort(listTempP);
		printLista(listTempP);
	}
	
	public static void printLista(Person[] list)
	{
		if (list == null)
		{
			return;
		}
		
		for (Person p : list)
		{
			System.out.println(p);
		}
	}
	
	public static void bubbleSort(Person[] list)
	{
		for (int j = list.length; j >= 0; j--)
		{
			for (int i = 1; i < j; i++)
			{
				if (list[i - 1].compareTo(list[i]) > 0)
				{
					Person safe = list[i];
					list[i] = list[i - 1];
					list[i - 1] = safe;
				}
			}
		}
	}
}
