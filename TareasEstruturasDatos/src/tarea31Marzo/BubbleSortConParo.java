package tarea31Marzo;

import java.util.Arrays;

public class BubbleSortConParo {

	public static void main(String[] args) {
		//int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		bubbleSortConParo(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void bubbleSortConParo(int[] arr)
	{
		boolean cambios = false;
		int j = arr.length;
		while (j >= 0)
		{
			for (int i = 1; i < j; i++)
			{
				if (arr[i - 1] > arr[i])
				{
					cambios = true;
					int safe = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = safe;
				}
			}
			
			if (!cambios)
			{
				return;
			}
			
			cambios = false;
			
			j--;
		}
	}
}
