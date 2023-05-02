package Main;
import java.util.HashMap;

public class Calculadora {
	HashMap <Integer, Integer> hash = new HashMap<>();
	
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
	
	public int factorial(int num)
	{
		if (num <= 1)
		{
			return 1;
		}
		else if(hash.containsKey(num))
		{
			return hash.get(num);
		}
		else
		{
			hash.put(num, num * factorial(num - 1));
			return hash.get(num);
		}
	}
}
