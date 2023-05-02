package parentesis;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class ParentesisChecker {
	public static boolean checkParentesis(String expresion) throws ParentesisException
	{
		Queue<Integer> queue = new LinkedList<>();
		int[] errorPosition = new int[0];
		
		int x = expresion.length();
		for (int i = 0; i < x; i++)
		{
			char c = expresion.charAt(i);
			
			if (c == '(')
			{
				queue.add(i + 1);
			}
			else if (c == ')')
			{
				if (queue.isEmpty())
				{
					errorPosition = addErrorPosition(errorPosition, i + 1);
				}
				else
				{
					queue.poll();
				}
			}
		}
		
		while (!queue.isEmpty())
		{
			errorPosition = addErrorPosition(errorPosition, queue.poll());
		}
		
		if (errorPosition.length != 0)
		{
			throw new ParentesisException(errorPosition);
		}
		
		return true;
		
	}
	
	private static int[] addErrorPosition(int[] error, int errorPosition)
	{
		error = Arrays.copyOf(error, error.length + 1);
		error[error.length - 1] = errorPosition;
		return error;
	}
	
	
}
