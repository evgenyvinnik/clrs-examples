package ca.jvsh.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class HeapSort
{
	public HeapSort()
	{
		System.out.println("Heap Sort");

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

			//int[] A = new int[] {4,1,3,2,16,9,10,14,8,7};
			int[] A = new int[array_elements];
			
			for (int i = 0; i < A.length; i++)
				A[i] = random.nextInt(1000);

			System.out.println("Unsorted array");
			for (int i : A)
			{
				System.out.print(String.format("%5d", i));
			}
			System.out.println();

			heapsort(A);

			System.out.println("Sorted array");
			for (int i : A)
			{
				System.out.print(String.format("%5d", i));
			}
			System.out.println();
		}
	}
	
	void max_heapify(int[] A, int heap_size, int i)
	{
		int l = left(i);
		int r = right(i);
		int largest;
		if( l < heap_size && A[l] > A[i])
			largest = l;
		else 
			largest = i;
		
		if(r < heap_size && A[r] > A[largest])
			largest = r;
		

		if (largest != i)
		{
			int exchange = A[i];
			A[i] = A[largest];
			A[largest] = exchange;
			
			max_heapify(A, heap_size, largest);
		}
	}
	
	
	void build_max_heap(int[] A)
	{
		for(int i = (A.length / 2); i >= 0; i--)
		{
			max_heapify(A,  A.length, i);
		}
	}
	
	void heapsort(int[] A)
	{
		build_max_heap(A);
		
		int heap_size = A.length;
		int exchange;
		
		for(int i = A.length-1; i >= 1; i--)
		{
			exchange = A[i];
			A[i] = A[0];
			A[0] = exchange;
			
			heap_size --;
			max_heapify(A, heap_size, 0);
		}
	}
	
	int parent(int i)
	{
		return i/2;
	}
	
	int left(int i)
	{
		return 2*i ;
	}
	
	int right(int i)
	{
		return 2*i + 1;
	}
}
