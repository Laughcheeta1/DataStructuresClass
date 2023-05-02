package tarea6;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr1 = createArrayLeftRight(10); 
		int[] arr2 = createArrayRightLeft(10);
		int[] arr3 = createArrayRandom(10);
		
		System.out.println("Organized array\n	Before sorting:\n" + Arrays.toString(arr1));
		
		arr1 = mergeSort(arr1);
		
		System.out.println("	After sorting:\n" + Arrays.toString(arr1) + "\n\n");
		
		System.out.println("Unorganized array\n	Before sorting:\n" + Arrays.toString(arr2));
		
		arr2 = mergeSort(arr2);
		
		System.out.println("	After sorting:\n" + Arrays.toString(arr2) + "\n\n");
		
		System.out.println("Random array\n	Before sorting:\n" + Arrays.toString(arr3));
		
		arr3 = mergeSort(arr3);
		
		System.out.println("	After sorting:\n" + Arrays.toString(arr3) + "\n\n");
	}
	
	public static int[] mergeSort(int[] arr)
	{
		int x = arr.length;
		
		// Base case
		if (x <= 1) 
		{
			return arr;
		}
		
		// Sort the left side and the right side (we always put 0 and x/2 since when we call we give it a smaller copy of the array, therefore, there's 
			// no need to put those number dinamically)
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, x / 2));
		int[] right = mergeSort(Arrays.copyOfRange(arr, x / 2, x));
		
		// Get the final array
		return merge(left, right);
	}
	
	// arr1 is the left array, and arr2 is the right array
	private static int[] merge(int[] arr1, int[] arr2)
	{
		int i = 0, j = 0;
		int arr1Length = arr1.length;
		int arr2Length = arr2.length;
		
		int[] result = new int[arr1Length + arr2Length];
		
		// This repeats while the indexes still exist in the arrays
		while (i < arr1Length || j < arr2Length)
		{
			// If the right array has finished or the current left number is lesser/equal to the current number in the right (we also
				// check if the left array has not gone overboard)
			if (j == arr2.length || (i < arr1Length && arr1[i] <= arr2[j]))
			{
				result[i + j] = arr1[i];
				i++;
			}
			else
			{
				result[i + j] = arr2[j];
				j++;
			}
		}
		
		return result;
	}
	
	
	public static <T extends Comparable<T>> T[] mergeSortComparable(T[] arr)
	{
		int x = arr.length;
		
		// Base case
		if (x <= 1) 
		{
			return arr;
		}
		
		// Sort the left side and the right side (we always put 0 and x/2 since when we call we give it a smaller copy of the array, therefore, there's 
			// no need to put those number dinamically)
		T[] left = mergeSortComparable(Arrays.copyOfRange(arr, 0, x / 2));
		T[] right = mergeSortComparable(Arrays.copyOfRange(arr, x / 2, x));
		
		// Get the final array
		return mergeComparable(left, right);
	}
	
	// arr1 is the left array, and arr2 is the right array
	private static <T extends Comparable<T>> T[] mergeComparable(T[] arr1, T[] arr2)
	{
		int i = 0, j = 0;
		int arr1Length = arr1.length;
		int arr2Length = arr2.length;
		
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[arr1Length + arr2Length];
		
		// This repeats while the indexes still exist in the arrays
		while (i < arr1Length || j < arr2Length)
		{
			// If the right array has finished or the current left number is lesser/equal to the current number in the right (we also
				// check if the left array has not gone overboard)
			if (j == arr2.length || (i < arr1Length && arr1[i].compareTo(arr2[j]) <= 0))
			{
				result[i + j] = arr1[i];
				i++;
			}
			else
			{
				result[i + j] = arr2[j];
				j++;
			}
		}
		
		return result;
	}
	
	public static int[] createArrayRandom(int n)
    {
    	int[] result = new int[n];
    	Random ran = new Random();
    	
    	for (int i = 0; i < n; i++)
    	{
    		result[i] = ran.nextInt(n);
    	}
    	
    	return result;
    }
    
    public static int[] createArrayLeftRight(int n)
    {
    	int[] result = new int[n];
    	
        for (int i = 0; i < n; i++)
        {
            result[i] = i + 1;
        }
        
        return result;
    }

    public static int[] createArrayRightLeft(int n)
    {
        int x = n;
        int[] result = new int[n];
        for (int i = 0; i < x; i++)
        {
        	result[i] = n;
        	n--;
        }
        
        return result;
    }

}
