package tarea;

import java.util.Stack;

public class InfixToPostfix {
	public static void main(String[] args)
	{
		System.out.println(converInfixToPrefix("A*b+c"));
	}
	
	public static String converInfixToPrefix(String infix)
	{
		String operations = "+-*/^()";
		Stack<Character> operands = new Stack<>();
		String result = "";
		
		Character c;
		int x = infix.length();
		for (int i = 0; i < x; i++)
		{
			char charInquestion = infix.charAt(i);
			if (operations.contains(Character.toString(charInquestion)))
			{
				while (!operands.isEmpty() && (c = operands.pop()).charValue() != '(' && isLesserOperation(charInquestion, c))
				{
					result = result.concat("  " + c.toString());
				}
				operands.push(charInquestion);
			}
			else
			{
				result = result.concat(Character.toString(charInquestion));
			}
		}
		
		// Add the operands that are left in the stack
		while (!operands.isEmpty() && (c = operands.pop()).charValue() != '(')
		{
			result = result.concat("  " + c.toString());
		}
		
		return result;
			
	}
	
	
	
	/**
	 * Returns true if operation 1 is lesser operation than operation 2, else, it returns false 
	 * 
	 * @param operation1: intended to know result
	 * @param operation2: to compare
	 * @return
	 */
	private static boolean isLesserOperation(char operation1, int operation2)
	{
		String operations = "+-*/^()";
		
		if (operations.indexOf(operation1) < operations.indexOf(operation2))
		{
			return true;
		}
		
		return false;
	}
}
