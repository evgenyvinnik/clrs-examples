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
		System.out.println("4 - Bubble Sort");
		System.out.println("5 - Divide and Conquer");
		System.out.println("6 - Square Matrix Multiplication");
		System.out.println("7 - Square Matrix Multiplication (recursive version)");
		System.out.println("8 - Heap Sort");
		System.out.println("9 - Priority Queue");
		System.out.println("10 - Quick Sort");
		System.out.println("11 - Randomized Partition Quick Sort");
		System.out.println("12 - Hoare Sort");
		System.out.println("13 - Tail Recursive Quick Sort");
		
		int algorithm = 0;
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            algorithm = Integer.parseInt(reader.readLine());
		}
		catch (IOException e)
		{
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
			case 4:
				new BubbleSort();
				break;
			case 5:
				new DivideConquer();
				break;
			case 6:
				new SquareMatrixMultiplication();
				break;
			case 7:
				System.out.println("Would be implemented in future.");
				break;
			case 8:
				new HeapSort();
				break;
			case 9:
				new PriorityQueue();
				break;
			case 10:
				new QuickSort();
				break;
			case 11:
				new RandomizedPartitionQuickSort();
				break;
			case 12:
				new HoareSort();
				break;
			case 13:
				new TailRecursiveQuickSort();
				break;
			default:
				System.out.println("No such algorithm");
				break;
		}
	}

}
