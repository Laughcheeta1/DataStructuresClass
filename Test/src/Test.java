import java.util.Arrays;
import java.util.Random;
import java.util.Random;

public class Test {
	public static void main(String[] argc)
	{
		Random r = new Random();
		for (int i = 0; i < 100; i++)
		{
			System.out.println(r.nextInt(5));
		}
	}
	
	public static int[] quickSort(int[] a)
	{
		return quickSort(a, 0, a.length - 1);
	}
	
	private static int[] quickSort(int[] a, int inicio, int fin)
	{
		if (fin <= inicio)
		{
			return a;
		}
		
		int pivote = a[fin];
		int i = inicio - 1;
		int j = fin;
		
		int temp;
		
		while (i < j)
		{
			while (a[++i] < pivote);
			
			while (j > inicio && pivote < a[--j]);
			
			if (i < j)
			{
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		temp = a[i];
		a[i] = a[fin];
		a[fin] = temp;
		
		int partition = i;
		
		quickSort(a, inicio, partition - 1);
		quickSort(a, partition + 1, fin);
		
		return a;
	}
	
	public static int[] bubbleSortConParo(int[] arr)
	{
		boolean cambios = false;
		int j = arr.length;
		while (j >= 0)
		{
			for (int i = 1; i < j; i++)
			{
				if (arr[i - 1] > arr[i])
				{
					cambios = true;
					int safe = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = safe;
				}
			}
			
			if (!cambios)
			{
				return arr;
			}
			
			cambios = false;
			
			j--;
		}
		
		return arr;
	}
	
	public static int[] insertionSort(int[] arr)
	{
		for (int i = 1; i < arr.length; i++)
		{
			int temp = arr[i];
			
			int j = i;
			
			while (j > 0 && temp < arr[j - 1])
			{
				arr[j] = arr[j - 1];
				j--;
			}
			
			
			arr[j] = temp;
		}
		
		return arr;
	}
	
	// No me esta funcionando
	public static int[] selectionSort(int[] arr)
	{
		for (int i = 0; i < arr.length - 1; i++)
		{
			int im = i;
			for (int j = i + 1; j < arr.length; j++)
			{
				if (arr[j] < arr[im])
				{
					im = j;
				}
				
				int temp = arr[i];
				arr[i] = arr[im];
				arr[im] = temp;
			}
		}
		
		return arr;
	}
	
	public static int[] bubbleSort(int[] arr)
	{
		for (int i = 0; i < arr.length - 1; i++)
		{
			for (int j = 0; j < arr.length - 1 - i; j++)
			{
				if (arr[j + 1] < arr[j])
				{
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		
		return arr;
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
	
	public static int sumaMatriz(int matriz[][])
	{
		return sumaMatriz(matriz.length - 1, matriz[0].length - 1, matriz);
	}
	
	public static int sumaMatriz(int columna, int fila, int matriz[][])
	{
		if (columna == 0)
		{
			if (fila == 0)
			{
				return matriz[0][0];
			}
			
			return matriz[columna][fila] + sumaMatriz(matriz.length - 1, fila - 1, matriz);
		}
		
		return matriz[columna][fila] + sumaMatriz(columna - 1, fila, matriz);
	}
	
	
	public static void hanoi(int n)
	{
	//	hanoi(n, 'a', 'b', 'c');
	}
	
	//public static void hanoi(int n, char inicio)
	
	
	public static int numeroMayorDivideVenceras(int[] arr)
	{
		return numeroMayorDivideVenceras(arr, 0, arr.length - 1);
	}
	
	public static int numeroMayorDivideVenceras(int[] arr, int izquierda, int derecha)
	{
		if (izquierda == derecha)
		{
			return arr[derecha];
		}
		
		int mitad = (derecha + izquierda) / 2;
		return Math.max(numeroMayorDivideVenceras(arr, izquierda, mitad), numeroMayorDivideVenceras(arr, mitad + 1, derecha));
	}
	
	public static int sumaDivideVenceras(int[] arr)
	{
		return sumaDivideVenceras(arr, 0, arr.length - 1);
	}
	
	public static int sumaDivideVenceras(int[] arr, int izquierda, int derecha)
	{
		if (izquierda == derecha)
		{
			return arr[derecha];
		}
		
		int mitad = (derecha + izquierda) / 2;
		
		return sumaDivideVenceras(arr, izquierda, mitad) + sumaDivideVenceras(arr, mitad + 1, derecha);
	}
	
	public static boolean palindrome(String string)
	{
		return palindrome(string, 0, string.length() - 1);
	}
	
	public static boolean palindrome(String string, int izquierda, int derecha)
	{
		if (izquierda >= derecha)
		{
			return true;
		}
		else if (string.charAt(izquierda) != string.charAt(derecha))
		{
			return false;
		}
		
		return palindrome(string, izquierda + 1, derecha - 1);
	}

	public static String invertirString(String string)
	{
		return invertirString(string, string.length() - 1);
	}
	
	public static String invertirString(String string, int posicion)
	{
		if (posicion == 0)
		{
			return Character.toString(string.charAt(posicion));
		}
		
		return Character.toString(string.charAt(posicion)).concat(invertirString(string, posicion - 1));
	}
	
	public static int sumaSubsecuenciaMasLarga(int[] arr)
	{
		int subMasLarga = 0;
		int x = arr.length;
		for (int i = 1; i < x; i++) 
		{
			subMasLarga = Math.max(subMasLarga(arr, i - 1, x - 1), subMasLarga(arr, i, x - 1));
		}
		return subMasLarga;
	}
	
	private static int subMasLarga(int[] arr, int inicio, int fin)
	{
		if (inicio == fin)
		{
			return arr[inicio];
		}
		
		int subSecuenciaEncontrada = subMasLarga(arr, inicio, fin - 1);
		
		return Math.max(subSecuenciaEncontrada, subSecuenciaEncontrada + arr[fin]); 
	}
	
	public static int encontrarMaximoRecursivo(int[] arr) throws CustomException
	{
		if (arr == null)
		{
			throw new CustomException("Array is null");
		}
		
		return encontrarMaximoRecursivo(arr, arr.length - 1);
	}
	
	public static int encontrarMaximoRecursivo(int[] arr, int posicion)
	{
		if (posicion == 0)
		{
			return arr[0];
		}
		
		int maximoAnterior = encontrarMaximoRecursivo(arr, posicion - 1);
		
		if (arr[posicion] > maximoAnterior)
		{
			return arr[posicion];
		}
		else
		{
			return maximoAnterior;
		}
	}
	
	public static long sumaRecursiva(long n)
	{
		if (n <= 0)
		{
			return 0;
		}
		
		return n + sumaRecursiva(n - 1);
	}
	
	public static long sumaRecursivaArreglo(long[] arr)
	{
		return sumaRecursivaArreglo(arr, arr.length - 1);
	}
	
	public static long sumaRecursivaArreglo(long[] arr, int pos)
	{
		if (pos == 0)
		{
			return arr[0];
		}
		
		return arr[pos] + sumaRecursivaArreglo(arr, pos - 1);
	}
	
	public static long factorialRecursivo(long n)
	{
		if (n < 0)
		{
			return -1;
		}
		else if (n == 1 || n == 0)
		{
			return 1;
		}
		
		return n * factorialRecursivo(n - 1);
	}
	
	public static long factorialIterativo(long n)
	{
		long f = 1;
		for (int i = 1; i <= n; i++)
		{
			f *= i;
		}
		
		return f;
	}
}