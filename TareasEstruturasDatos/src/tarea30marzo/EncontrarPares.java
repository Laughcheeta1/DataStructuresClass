package tarea30marzo;

import java.util.Arrays;

public class EncontrarPares {
	public static void main(String[] argc)
	{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 78, 69, 144, 23, 48, 54, 12};
		
		System.out.println(Arrays.toString(paresEnArreglo(arr)));
	}
	
	public static int[] paresEnArreglo(int[] arr)
	{
		int[] resultado = new int[0];
		
		return paresEnArreglo(arr.length - 1, arr, resultado);
	}
	
	public static int[] paresEnArreglo(int pos, int[] arr, int[] resultado)
	{
		if (pos == -1)
		{
			return resultado;
		}
		
		resultado = paresEnArreglo(pos - 1, arr, resultado);
		
		if (arr[pos] % 2 == 0)
		{
			resultado = Arrays.copyOf(resultado, resultado.length + 1);
			resultado[resultado.length - 1] = arr[pos];
		}
		
		return resultado;
	}
}
