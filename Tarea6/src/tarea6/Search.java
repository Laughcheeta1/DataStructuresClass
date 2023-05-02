package tarea6;

public class Search {
	public static void main(String[] args)
	{
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		System.out.println("Position of 0: " + binarySearch(0, arr));
		System.out.println("Position of 2: " + binarySearch(2, arr));
		System.out.println("Position of 5: " + binarySearch(5, arr));
		System.out.println("Position of 9: " + binarySearch(9, arr));
		System.out.println("Position of 10: " + binarySearch(10, arr));
	}
	
	public static int linearSearch(int toBeSearched, int[] arr)
	{
		int i = 0;
		int x = arr.length;
		while (i < x && arr[i] != toBeSearched)
		{
			i++;
		}
		
		return (i == x) ? -1 : i;
	}
	
	public static <T extends Comparable<T>> int linearSearchComparable(T toBeSearched, T[] arr)
	{
		int i = 0;
		int x = arr.length;
		
		while (i < x && arr[i].compareTo(toBeSearched) != 0)
		{
			i++;
		}
		
		return (i == x) ? -1 : i;
	}
	
	
	public static int binarySearch(int toBeSearched, int[] arr)
	{
		return binarySearch(toBeSearched, arr, 0, arr.length - 1);
	}
	
	
	public static int binarySearch(int toBeSearched, int[] arr, int start, int end)
	{
		int middle = (start + end) / 2;
		if (toBeSearched == arr[middle])
		{
			return middle;
		}
		else if (start >= end)
		{
			return -1;
		}
		else if (toBeSearched < arr[middle])
		{
			return binarySearch(toBeSearched, arr, start, middle - 1);
		}
		else
		{
			return binarySearch(toBeSearched, arr, middle + 1, end);
		}
	}
	
	
	/**
	 * This methods recieves a object to be searched and a sorted array. Searches by using the binary search method, returns a -1 if the object is 
	 * not in the array, else, returns the position of the object in the given Array
	 * @param toBeSearched
	 * @param array
	 * @return position of the object to be searched
	 */
	public static <T extends Comparable<T>> int binarySearchComparable(T toBeSearched, T[] arr)
	{
		return binarySearchComparable(toBeSearched, arr, 0, arr.length - 1);
	}
	
	private static <T extends Comparable<T>> int binarySearchComparable(T toBeSearched, T[] arr, int start, int end)
	{
		int middle = (start + end) / 2;
		int comparisonResult = toBeSearched.compareTo(arr[middle]);
		
		if (comparisonResult == 0)
		{
			return middle;
		}
		// If the middle isn't the thing we are searching for, and the start is equals to the end we can safely say, that the object is not in the array
		else if (start >= end)
		{
			return -1;
		}
		else if (comparisonResult < 0)
		{
			return binarySearchComparable(toBeSearched, arr, start, middle - 1);
		}
		else
		{
			return binarySearchComparable(toBeSearched, arr, middle + 1, end);
		}
		
	}
}
