package ca.jvsh.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class BubbleSort
{
	public BubbleSort()
	{
		System.out.println("Bubble Sort");

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

			int exchange_element;
			//main algorithm
			for (int i = 0; i < A.length; i++)
			{
				for (int j = A.length - 1; j > i; j--)
				{
					if (A[j] < A[j - 1])
					{
						exchange_element = A[j];
						A[j] = A[j - 1];
						A[j - 1] = exchange_element;
					}
				}
			}

			System.out.println("Sorted array");
			for (int i : A)
			{
				System.out.print(String.format("%5d", i));
			}
			System.out.println();
		}
	}

}
