package tarea6;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	public static void main(String[] args)
	{
		int[] arr1 = createArrayLeftRight(10); 
		int[] arr2 = createArrayRightLeft(10);
		int[] arr3 = createArrayRandom(10);
		
		System.out.println("Organized array\n	Before sorting:\n" + Arrays.toString(arr1));
		
		quickSortWithRandomPivot(arr1);
		
		System.out.println("	After sorting:\n" + Arrays.toString(arr1) + "\n\n");
		
		System.out.println("Unorganized array\n	Before sorting:\n" + Arrays.toString(arr2));
		
		quickSortWithRandomPivot(arr2);
		
		System.out.println("	After sorting:\n" + Arrays.toString(arr2) + "\n\n");
		
		System.out.println("Random array\n	Before sorting:\n" + Arrays.toString(arr3));
		
		quickSortWithRandomPivot(arr3);
		
		System.out.println("	After sorting:\n" + Arrays.toString(arr3) + "\n\n");
		
		
	}
	
	/**
	 * Sorts the array from 
	 * 
	 * @param Array to be sorted
	 */
	public static void quickSortWithRandomPivot(int[] arr)
    {
        quickSortWithRandomPivot(arr, 0, arr.length - 1, new Random());
    }

    private static void quickSortWithRandomPivot(int[] arr, int start, int end, Random ran)
    {
        // Base case, if the section that we are trying to organize have a size of 1, or does not even exist.
        if (start >= end)
        {
            return;
        }
        
        // Set the pivot to a random position within the range of the array we need to sort (we need to save the position of the 
        	// pivot since we need it to change the position of the value in the pivot later)
        int pivotPosition = ran.nextInt(end - start) + start;
        int pivot = arr[pivotPosition];
        
        // Set the index traversers
        int i = start;
        int j = end;
        
        // Just the variable to be able to switch the positions (Declared it now because we are using it in the while, and after it)
        int temp;

        // Do the work
        while (i < j) {
            // i searches for a number greater than the pivot (if "end" is for example 2, and the i is 1, then its gonna execute, but then, since i is 2, 
        		// and "end" is also 2, its not gonna execute, avoiding the index of going over board)
            while (i < end && arr[i] <= pivot)
            {
            	i++;
            }
            
            // j searches for a number lesser than the pivot (same thing as i, but with "start")
            while (j > start && arr[j] >= pivot)
            {
            	j--;
            }
            
            // Switch the numbers
            if (i < j) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        /* We change the location of the pivot, only if the pivot position is greater (or the value in that position is greater), since i searches 
         * for a number greater than the pivot, if the array is sorted, but the pivot is, for example, in the middle, i is gonna be to the right of 
         * the pivot position, and if we switch them, then theres gonna be a number greater than the pivot to the left of it, and that is no bueno. 
         */
        if (i < pivotPosition || arr[i] < pivot)
        {
        	temp = arr[i];
            arr[i] = arr[pivotPosition];
            arr[pivotPosition] = temp;
            pivotPosition = i;
        }

        // We partition the array in the (actualized) pivot position, since the change in the pivot may or may not ocurr, and we want to sort the
        	// left side and the right side to the final position of the pivot
        
        // Sort the left and the right sub arrays
        quickSortWithRandomPivot(arr, start, pivotPosition - 1, ran);
        quickSortWithRandomPivot(arr, pivotPosition + 1, end, ran);
    }
    
    
    public static <T extends Comparable<T>> void quickSortWithRandomPivotComparable(T[] arr)
    {
        quickSortWithRandomPivotComparable(arr, 0, arr.length - 1, new Random());
    }

    
    private static <T extends Comparable<T>> void quickSortWithRandomPivotComparable(T[] arr, int start, int end, Random ran)
    {
        // Base case, if the section that we are trying to organize have a size of 1, or does not even exist.
        if (start >= end)
        {
            return;
        }
        
        // Set the pivot to a random position within the range of the array we need to sort (we need to save the position of the 
        	// pivot since we need it to change the position of the value in the pivot later)
        int pivotPosition = ran.nextInt(end - start) + start;
        T pivot = arr[pivotPosition];
        
        // Set the index traversers
        int i = start;
        int j = end;
        
        // Just the variable to be able to switch the positions (Declared it now because we are using it in the while, and after it)
        T temp;

        // Do the work
        while (i < j) {
            // i searches for a number greater than the pivot (if "end" is for example 2, and the i is 1, then its gonna execute, but then, since i is 2, 
        		// and "end" is also 2, its not gonna execute, avoiding the index of going over board)
            while (i < end && arr[i].compareTo(pivot) <= 0)
            {
            	i++;
            }
            
            // j searches for a number lesser than the pivot (same thing as i, but with "start")
            while (j > start && arr[j].compareTo(pivot) >= 0)
            {
            	j--;
            }
            
            // Switch the numbers
            if (i < j) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
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
