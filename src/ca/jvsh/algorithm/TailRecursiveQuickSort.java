package ca.jvsh.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class TailRecursiveQuickSort
{
	public TailRecursiveQuickSort()
	{
		System.out.println("Tail Recursive Quick Sort");

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

			//int[] A = new int[]{2, 8,7,1,3,5,6,4}; 
			int[] A = new int[array_elements];

			for (int i = 0; i < A.length; i++)
				A[i] = random.nextInt(1000);

			System.out.println("Unsorted array");
			for (int i : A)
			{
				System.out.print(String.format("%5d", i));
			}
			System.out.println();

			tail_recursive_quick_sort(A, 0, A.length - 1);

			System.out.println("Sorted array");
			for (int i : A)
			{
				System.out.print(String.format("%5d", i));
			}
			System.out.println();
		}
	}

	private void tail_recursive_quick_sort(int[] A, int p, int r)
	{
		int q;
		while (p < r)
		{
			//partition and sort left subarray
			q = partition(A, p, r);
			tail_recursive_quick_sort(A, p, q - 1);
			p = q + 1;
		}
	}

	private int partition(int[] A, int p, int r)
	{
		int x = A[r];
		int i = p - 1;
		int exchange;
		for (int j = p; j <= r - 1; j++)
		{
			if (A[j] <= x)
			{
				i++;
				exchange = A[i];
				A[i] = A[j];
				A[j] = exchange;
			}
		}

		exchange = A[i + 1];
		A[i + 1] = A[r];
		A[r] = exchange;

		return i + 1;

	}
}
