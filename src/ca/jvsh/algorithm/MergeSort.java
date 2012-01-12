package ca.jvsh.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MergeSort
{
	public MergeSort()
	{
		System.out.println("Merge Sort");

		System.out.println("Enter number of elements in the array");
		int array_elements = 2;
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			array_elements = Integer.parseInt(reader.readLine());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		if (array_elements < 2)
		{
			System.out.println("Number of elements in the array should be greater or equal 2");
		}
		else
		{
			Random random = new Random();

			int[] A = new int[array_elements];
			
			for (int i = 0; i < A.length; i++)
				A[i] = random.nextInt(1000);

			System.out.println("Unsorted array");
			for (int i : A)
			{
				System.out.print(String.format("%5d", i));
			}
			System.out.println();

			mergeSort(A, 0, A.length-1);

			System.out.println("Sorted array");
			for (int i : A)
			{
				System.out.print(String.format("%5d", i));
			}
			System.out.println();
		}
	}
	
	private void mergeSort(int[] A, int p, int r)
	{
		int q;
		if( p < r)
		{
			q = (p + r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}
	
	private void merge(int[] A, int p, int q, int r)
	{
		int n1 = q - p + 1;
		int n2 = r - q ;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		int i, j, k;
		
		for(i = 0; i < n1; i++)
			L[i] = A[p + i];
		for(j = 0; j < n2; j++)
			R[j] = A[q + j + 1];
		
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		
		i = 0;
		j = 0;
		
		for( k = p; k <= r; k++)
		{
			if(L[i] <= R[j])
			{
				A[k] = L[i];
				i++;
			}
			else
			{
				A[k] = R[j];
				j++;
			}
		}
	}
}
