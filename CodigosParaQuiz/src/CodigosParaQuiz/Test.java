package CodigosParaQuiz;
import java.util.Arrays;

public class Test {
	public static void main(String[] argc)
	{
		//int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 78, 69, 144, 23, 48, 54, 12};
		
		//System.out.println(Arrays.toString(paresEnArreglo(arr)));
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
		hanoi(n, 1, 2, 3);
	}
	
	public static void hanoi(int n, int origen, int auxiliar, int destino)
	{
		if (n == 1)
		{
			System.out.println("Mueve el disco de la torre " + origen + "--->" + destino);
		}
		else
		{
			hanoi(n - 1, origen, destino, auxiliar);
			System.out.println("Mueve el disco de la torre " + origen + "--->" + destino);
			hanoi(n - 1, auxiliar, origen, destino);
		}
	}
	
	
	
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
	
	
	
	public static int encontrarMaximoRecursivo(int[] arr) throws ExceptionCustom
	{
		if (arr == null)
		{
			throw new ExceptionCustom("Array is null");
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