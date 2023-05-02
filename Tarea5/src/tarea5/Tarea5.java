package tarea5;

import java.util.Arrays;

public class Tarea5 {
	public static void main(String[] args)
	{
		int[] arr1 = new int[9999];
        int[] arr2 = new int[9999];

        createArrayLeftRight(arr1);
        createArrayRightLeft(arr2);

        System.out.println("Organized");
        long start = System.currentTimeMillis();
        quickSortWithStop(arr1);
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);

        System.out.println("Unorganized");
        System.out.println(Arrays.toString(arr2));
        start = System.currentTimeMillis();
        quickSortWithStop(arr2);
        finish = System.currentTimeMillis();
        System.out.println(finish - start);
        System.out.println(Arrays.toString(arr2));
	}
	
	public static void quickSortWithStop(int[] arr)
    {
        quickSortWithStop(arr, 0, arr.length - 1);
    }

    public static void quickSortWithStop(int[] arr, int start, int end)
    {
        // If the section that we are trying to organize have a size of 1, or does not even exist.
        if (start >= end || isSorted(arr))
        {
            return;
        }
        // Set the pivot to the end of the array
        int pivot = arr[end];
        // Start i minus 1, and j plus 1 (one position more than it should be,) because of how the
        // whiles bellow work
        int i = start - 1;
        int j = end;
        // Just the variable to be able to switch the positions
        int temp;

        // Do the work
        while (i < j) {
            // i searches for a number greater than the pivot
            while (arr[++i] < pivot) ;
            // j searches for a number lesser than the pivot
            while (j > start && arr[--j] > pivot) ;

            // Switch the numbers
            if (i < j) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // Place the pivot in the middle of the array, (it is done with i because it will have the
        // position of the first greater number than the pivot, making that if we switch them,
        // we ensure that all the numbers to the left of the new pivot's position are lesser than
        // the pivot, and all the numbers in the right are greater than the pivot.
        temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        // Because of the things explained before, the place where we are going to partition the array
        // is in the location that i is pointing to
        int partition = i;
        // Sort the left and the right sub arrays
        quickSortWithStop(arr, start, partition - 1);
        quickSortWithStop(arr, partition + 1, end);
    }

    public static boolean isSorted(int[] arr)
    {
        int i = 1;
        int x = arr.length;

        if (x == 1)
        {
            return true;
        }

        while (i < x && arr[i - 1] < arr[i])
        {
            i++;
        }

        return (i == x) ? true : false;
    }
    
    
    public static void createArrayLeftRight(int[] arr)
    {
        int x = arr.length;
        for (int i = 0; i < x; i++)
        {
            arr[i] = i + 1;
        }
    }

    public static void createArrayRightLeft(int[] arr)
    {
        int x = 0;
        for (int i = arr.length - 1; i >= 0; i--)
        {
            arr[x++] = i + 1;
        }
    }
}
