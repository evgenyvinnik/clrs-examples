package ca.jvsh.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class DivideConquer
{
	public DivideConquer()
	{
		System.out.println("Divide and Conquer: maximum subarray");
		

		System.out.println("Enter number of elements in the array");
		int array_elements = 1;
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			array_elements = Integer.parseInt(reader.readLine());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		if (array_elements < 1)
		{
			System.out.println("Number of elements in the array should be greater or equal 1");
		}
		else
		{
			Random random = new Random();

			//int[] A = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
			int[] A = new int[array_elements];

			for (int i = 0; i < A.length; i++)
				A[i] = random.nextInt(1000) - 500;

			System.out.println("Original array");
			for (int i : A)
			{
				System.out.print(String.format("%5d", i));
			}
			System.out.println();

			int[] result =  find_maximum_subarray(A, 0, A.length-1);

			System.out.println("Maximum sub-array");
			System.out.println("Low " + result [0]);
			System.out.println("High " + result [1]);
			System.out.println("Sum " + result [2]);
		}
	}
	
	private int[] find_maximum_subarray(int[] A, int low, int high)
	{
		if( high == low)
		{
			return new int[] {low, high, A[low]}; //base case: only one element
		}
		else
		{
			int mid = (low + high) /2;
			
			int[] result1 = find_maximum_subarray (A, low, mid);
			int[] result2 = find_maximum_subarray (A, mid+1, high);
			int[] result3 = find_max_crossing_subarray(A, low, mid, high);
			
			if( result1[2] >= result2[2] && result1[2] >= result3[2] )
			{
				return result1;
			}
			else if (result2[2] >= result1[2] && result2[2] >= result3[2])
			{
				return result2;
			}
			else
			{
				return result3;
			}
		} 
	}
	
	private int[] find_max_crossing_subarray(int[] A, int low, int mid, int high)
	{
		int left_sum = Integer.MIN_VALUE;
		
		int sum = 0;
		
		int max_left = -1;
		int max_right = -1;
		
		for(int i = mid; i >= low; i--)
		{
			sum += A[i];
			
			if (sum > left_sum)
			{
				left_sum = sum;
				max_left = i;
			}
		}
		
		int right_sum = Integer.MIN_VALUE;
		
		sum = 0;
		
		for(int j = mid+1; j <= high; j++)
		{
			sum += A[j];
			
			if (sum > right_sum)
			{
				right_sum = sum;
				max_right = j;
			}
		}
		
		return new int[]{max_left, max_right, left_sum + right_sum};
	}
}
