package Calculadora;

public class Calculadora {	
	public static double MCD(float n1, float n2)
	{
		while(n1 != n2)
		{
			if (n1 > n2)
			{
				n1 -= n2;
			}
			else
			{
				n2 -= n1;
			}
		}
		return n1;
	}
	
	public static int factorial(int num)
	{
		int result = 1;
		
		for(int i = 2; i <= num; i ++)
		{
			result *= i;
		}
		
		return result;
	}
}
