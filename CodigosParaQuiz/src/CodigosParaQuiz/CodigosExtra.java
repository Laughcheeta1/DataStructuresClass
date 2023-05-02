package CodigosParaQuiz;

public class CodigosExtra {
	// Maximo Comun Divisor (Recursivo)
	public int mcm(int a, int b)
	{
		return (b == 0) ? a : mcm(b, a % b);
	}
	
	// Maximo Comun Divisor (No recursivo)
	public int mcm2(int a, int b)
	{
		while (a != b)
		{
			if (a > b)
			{
				a -= b;
			}
			else
			{
				b -= a;
			}
		}
		
		return a;
	}
	
	
	// Minimo Comun Multiplo (least common multiple, recursivo)
	public int lcm(int a, int b)
	{
		return a * (b / mcm(a, b));
	}
	
	
	// Factorial recursivo
	public int factorialRecursivo(int n)
	{
		if (n <= 1)
		{
			return 1;
		}
		
		return n * factorialRecursivo(n - 1);
	}
	
	// Factorial
	public int factorial(int n)
	{
		int f = 1;
		
		for (int i = 2; i <= n; i++)
		{
			f *= i;
		}
		
		return f;
	}
	
	
	// Recordar clases Math
	// Math.sqrt(int numero)
	// Math.pow(int base, int exponente)
	
	// Recordar string1.compareTo(String2) donde string1 es la string a comparar, y String2 es la string con la que se compara. Retorna un 0 si son iguales. El resto de valores de retorno
	//		por ahora non interesan, pero si que significan algo.
	
	
}
