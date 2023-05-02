package tarea;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class ChequearParentesis {
	
	public static void main(String[] args)
	{
		System.out.println("What is the string you wan't to check the parenthesis?");
		Scanner scan = new Scanner(System.in);
		printParentheisRight(scan.next());
		scan.close();
	}
	
	public static void printParentheisRight(String word)
	{
		if (hasParenthesisRight(word))
		{
			System.out.println("The parenthesis are correct");
		}
		else
		{
			System.out.println("The parenthesis aren't correct");
		}
	}
	
	public static boolean hasParenthesisRight(String word)
	{
		int x = word.length();
		int[] parenthesisCount = {0, 0};
		char charInQuestion;
			
		Queue<Character> queue = new LinkedList<>();
		
		for (int i = 0; i < x; i++)
		{
			charInQuestion = word.charAt(i);
				
			if (charInQuestion == '(')
			{
				parenthesisCount[0]++;
				queue.add(charInQuestion);
			}
			else if (charInQuestion == ')')
			{
				parenthesisCount[1]++;
				queue.add(charInQuestion);
			}
		}

		if (parenthesisCount[0] != parenthesisCount[1])
		{
			return false;
		}

		parenthesisCount[0] = 0;
		parenthesisCount[1] = 0;
			
		while (!queue.isEmpty())
		{
			if ((charInQuestion = queue.poll().charValue()) == '(')
			{
				parenthesisCount[0]++;
			}
			else if (++parenthesisCount[1] > parenthesisCount[0])
			{
				return false;
			}
		}

		return true;
	}
}
