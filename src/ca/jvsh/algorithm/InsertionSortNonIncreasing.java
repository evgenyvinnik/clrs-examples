package ca.jvsh.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class InsertionSortNonIncreasing
{
	public InsertionSortNonIncreasing()
	{
		System.out.println("Insertion Sort (non increasing)");

		System.out.println("Enter number of elements in the array");
		int array_elements = 2;
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			array_elements = Integer.parseInt(reader.readLine());
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (array_elements < 2)
		{
			System.out.println("Number of elements in the array should be greater or equal 2");
		}
		else
		{
			Random random = new Random();

			int[] array = new int[array_elements];

			for (int i = 0; i < array.length; i++)
				array[i] = random.nextInt(1000);

			System.out.println("Unsorted array");
			for (int i : array)
			{
				System.out.print(String.format("%5d", i));
			}
			System.out.println();

			//main part
			for (int j = 1; j < array.length; j++)
			{
				int key = array[j];

				//insert array[j] into the sorted sequence array[1 .. j-1]
				int i = j - 1;
				while (i >= 0 && array[i] > key)
				{
					array[i + 1] = array[i];
					i--;
				}
				array[i + 1] = key;
			}

			System.out.println("Sorted array");
			for (int i : array)
			{
				System.out.print(String.format("%5d", i));
			}
			System.out.println();
		}
	}
}
