package ca.jvsh.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algorithms
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Enter algorithm demo number");
		System.out.println("1 - Insertion Sort (non icreasing)");
		System.out.println("2 - Insertion Sort (non decreasing)");
		System.out.println("3 - Merge Sort");
		
		int algorithm = 0;
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            algorithm = Integer.parseInt(reader.readLine());
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Entered " + algorithm);
		
		switch(algorithm)
		{
			case 1:
				new InsertionSortNonIncreasing();
				break;
			case 2:
				new InsertionSortNonDecreasing();
				break;
			case 3:
				new MergeSort();
				break;
			default:
				System.out.println("No such algorithm");
				break;
		}
	}

}
