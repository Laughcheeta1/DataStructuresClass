package tarea30marzo;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HanoiEnArray {
	public static void main(String[] argc)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("De cuantos discos desea la torre de hanoi? (Tenga en cuenta que mientras mayor el numero, mas tiempo se demorara)");
		
		int n;
		
		try
		{
			n = scan.nextInt();
		} 
		catch (InputMismatchException e)
		{
			System.out.println("Incompetente");
			scan.close();
			return;
		}
			
		scan.close();
		
		System.out.println("\n");
		
		String[] movimientos = hanoi(n);
		
		mostrarMovimientos(movimientos);
		
		System.out.println("\nListo");
		
		
	}
	
	public static String[] hanoi(int n)
	{
		// The number of discs need to be in the natural numbers
		if (n < 1)
		{
			return null;
		}
		
		// Create the towers
		int[] a = new int[n + 1];
		int[] b = new int[n + 1];
		int[] c = new int[n + 1];
		
		// populate the towers
		int counter = n;
		for (int i = 0; i < n; i++)
		{
			a[i] = counter;
			b[i] = 0;
			c[i] = 0;
			--counter;
		}
		
		// Asign the number to each tower
		a[n] = 1;
		b[n] = 2;
		c[n] = 3;
		
		mostrarHanoi(a, b, c);
		
		String[] movimientos = new String[0];
		
		return hanoi(n, a, b, c, movimientos);
	}
	
	public static String[] hanoi(int n, int[] inicio, int[] medio, int[] fin, String[] movimientos)
	{
		// Base case
		if (n == 1)
		{
			pasarDeA(inicio, fin);
			mostrarHanoi(inicio, medio, fin);
			// We return the actualizated version of the String "movimientos"
			return ampliarString(movimientos, "movemos de torre " + inicio[inicio.length - 1] + " a la torre " + fin[fin.length - 1]);
		}
		
		movimientos = hanoi(n - 1, inicio, fin, medio, movimientos);
		
		pasarDeA(inicio, fin);
		// Update the String of movements
		movimientos = ampliarString(movimientos, "movemos de torre " + inicio[inicio.length - 1] + " a la torre " + fin[fin.length - 1]);
		mostrarHanoi(inicio, medio, fin);
		
		return hanoi(n - 1, medio, inicio, fin, movimientos);
	}
	
	
	public static String[] ampliarString(String[] str, String palabra)
	{
		str = Arrays.copyOf(str, str.length + 1);
		str[str.length - 1] = palabra;
		return str;
	}
	
	public static void pasarDeA(int[] inicio, int[] fin)
	{
		int container;
		// Minus 1 since the last number in the array is the number of the tower
		int x = inicio.length - 1;
		int i = 0;
		
		// Search for the position of the first cero, and subsequently substract 1 as to get the position of the number at the top of the array
		while (i < x && inicio[i] != 0)
		{
			i++;
		}
		
		container = inicio[--i];
		inicio[i] = 0;
		
		// Minus 1 since the last number in the array is the number of the tower
		x = fin.length - 1;
		i = 0;
		
		// Search for the position of the first cero in the array, as to replace it for 
		while (i < x && fin[i] != 0)
		{
			i++;
		}
		
		fin[i] = container;
	}
	
	public static void mostrarHanoi(int[] torre1, int[] torre2, int[] torre3)
	{
		int[][] torres = ordenarTorres(torre1, torre2, torre3);
		
		// Minus 2 because the first number is the number of the tower
		for (int i = torre1.length - 2; i >= 0; i--)
		{
			System.out.println(torres[0][i] + "     " + torres[1][i] + "     " + torres[2][i]);
		}
		
		System.out.println("-     -     -\n\n");
	}
	
	public static int[][] ordenarTorres(int[] torre1, int[] torre2, int[] torre3)
	{
		int x = torre1.length - 1;
		int[][] torres = new int[3][x + 1];
		
		// Ordenar
		if (torre1[x] == 1)
		{
			torres[0] = torre1;
		}
		else if (torre1[x] == 2)
		{
			torres[1] = torre1;
		}
		else
		{
			torres[2] = torre1;
		}
		
		if (torre2[x] == 1)
		{
			torres[0] = torre2;
		}
		else if (torre2[x] == 2)
		{
			torres[1] = torre2;
		}
		else
		{
			torres[2] = torre2;
		}
		
		if (torre3[x] == 1)
		{
			torres[0] = torre3;
		}
		else if (torre3[x] == 2)
		{
			torres[1] = torre3;
		}
		else
		{
			torres[2] = torre3;
		}
		
		return torres;
	}
	
	public static void mostrarMovimientos(String[] movimientos)
	{
		System.out.println("-----------------------------------\nMovimientos:\n");
		
		int x = movimientos.length;
		
		for (int i = 0; i < x; i++)
		{
			System.out.println(movimientos[i]);
		}
	}
}
