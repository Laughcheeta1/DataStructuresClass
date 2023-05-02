package trabajo;

public class PracticaBacktracking {
	
	public static void main(String[] args)
	{
		showPermutations(3);
	}
	
	/**
	 * Shows all the posible permutations of the n given numbers
	 * @param number of numbers to show permutations
	 */
	public static void showPermutations(int n)
	{
		int[] numbers = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			numbers[i] = 9;
		}
		
		showPermutation(numbers);
	}
	
	private static void showPermutation(int[] arr)
	{
		// Final case
		if (arr[0] == -1)
		{
			return;
		}
		
		int x = arr.length;
		
		// Searches for a number that is less 
		int i = 1;
		while (i < x && arr[i] != -1)
		{
			i++;
		}
		
		// If a number is -1 then lower the number to the left of it, and reset the -1 number to 9
		if (i != x)
		{
			arr[i] = 9;
			arr[i - 1] --;
		}
		else
		{
			// Print the current permutation
			for (i = 0; i < x; i++)
			{
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			
			//Lower the units digit
			arr[x - 1] --;
		}
		
		// Print the next permutation
		showPermutation(arr);
		
	}
}
