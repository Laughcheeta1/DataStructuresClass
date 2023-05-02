import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DecoderClase {
	public static void main(String[] args) {
		String message = "S.ALLETOS BES TRATROR AMPRO CEUGISNO CI SAE. VENTERGU";
		
		System.out.println(deCode(message));
	}
	
	public static String deCode(String messageCoded)
	{
		Queue<Character> message = invert(convertToQueue(messageCoded));
		Queue<Character> deCoded = new LinkedList<>();
		
		String vocals = "AEIOUaeiou";
		
		Stack<Character> noVocals = new Stack<>();
		
		Character x;
		while (!message.isEmpty())
		{
			x = message.poll();
			
			if (!vocals.contains(String.valueOf(x)))
			{
				noVocals.push(x);
			}
			else
			{
				Character y;
				while (!noVocals.isEmpty())
				{
					y = noVocals.pop();
					deCoded.add(y);
				}
				deCoded.add(x);
			}
		}
		
		String result = "";
		while (!deCoded.isEmpty())
		{
			x = deCoded.poll();
			result = result.concat(Character.toString(x.charValue()));
		}
		
		return result;
			
	}
	
	private static Queue<Character> convertToQueue(String word)
	{
		Queue<Character> result = new LinkedList<Character>();
		
		int x = word.length();
		for (int i = 0; i < x; i++)
		{
			result.add(word.charAt(i));
		}
		
		return result;
	}
	
	private static Queue<Character> invert(Queue<Character> word)
	{
		Stack<Character> inversion = new Stack<>();
		
		Character x;
		
		while (!word.isEmpty())
		{
			x = word.poll();
			inversion.push(x);
		}
		
		while (!inversion.isEmpty())
		{
			x = inversion.pop();
			word.add(x);
		}
		
		return word;
	}
}
