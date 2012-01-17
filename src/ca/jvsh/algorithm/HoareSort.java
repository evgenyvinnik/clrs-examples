package ca.jvsh.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class HoareSort
{
	public HoareSort()
	{
		System.out.println("Hoare Sort");

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

			//int[] A = new int[]{13, 19, 9, 5, 12, 8, 7, 4, 11, 2, 6, 21}; 
			int[] A = new int[array_elements];

			for (int i = 0; i < A.length; i++)
				A[i] = random.nextInt(1000);

			System.out.println("Unsorted array");
			for (int i : A)
			{
				System.out.print(String.format("%5d", i));
			}
			System.out.println();

			hoaresort(A, 0, A.length - 1);

			System.out.println("Sorted array");
			for (int i : A)
			{
				System.out.print(String.format("%5d", i));
			}
			System.out.println();
		}
	}

	private void hoaresort(int[] A, int p, int r)
	{
		int q;
		if (p < r)
		{
			q = hoare_partition(A, p, r);
			hoaresort(A, p, q - 1);
			hoaresort(A, q + 1, r);
		}
	}

	private int hoare_partition(int[] A, int p, int r)
	{
		int x = A[p];
		int i = p - 1;
		int j = r + 1 ;

		int exchange;

		while (true)
		{
			do
			{
				j--;
			}
			while (A[j] > x);

			do
			{
				i++;
			}
			while (A[i] < x);

			if (i < j)
			{
				exchange = A[i];
				A[i] = A[j];
				A[j] = exchange;
			}
			else
				return j;
		}
	}
}
