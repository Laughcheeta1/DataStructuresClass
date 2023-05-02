import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] i = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		quickSort(i);
		
		System.out.println(Arrays.toString(i));
		
	}
	
	public static void quickSort(int[] a)
	{
		quickSort(a, 0, a.length - 1);
	}
	
	private static void quickSort(int[] a, int inicio, int fin)
	{
		if (fin <= inicio)
		{
			return;
		}
		
		int pivote = a[fin];
		int i = inicio - 1;
		int j = fin;
		
		int temp;
		
		while (i < j)
		{
			while (a[++i] < pivote);
			
			while (j > inicio && pivote < a[--j]);
			
			if (i < j)
			{
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		temp = a[i];
		a[i] = a[fin];
		a[fin] = temp;
		
		int partition = i;
		
		quickSort(a, inicio, partition - 1);
		quickSort(a, partition + 1, fin);
	}
}
