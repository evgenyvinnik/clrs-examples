package ca.jvsh.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class SquareMatrixMultiplication
{

	public SquareMatrixMultiplication()
	{
		System.out.println("Square matrix multiplication");

		System.out.println("Enter matrix order");
		int matrix_order = 1;
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			matrix_order = Integer.parseInt(reader.readLine());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		if (matrix_order < 1)
		{
			System.out.println("Number of elements in the array should be greater or equal 1");
		}
		else
		{
			Random random = new Random();

			int[][] A = new int[matrix_order][matrix_order];
			int[][] B = new int[matrix_order][matrix_order];
			int[][] C = new int[matrix_order][matrix_order];

			System.out.println("Original matrix A");
			for (int i = 0; i < matrix_order; i++)
			{
				for(int j = 0; j < matrix_order; j++)
				{
					A[i][j] = random.nextInt(100);
					System.out.print(String.format("%5d", A[i][j]));
				}
				System.out.println();
			}
			
			System.out.println("Original matrix B");
			for (int i = 0; i < matrix_order; i++)
			{
				for(int j = 0; j < matrix_order; j++)
				{
					B[i][j] = random.nextInt(100);
					System.out.print(String.format("%5d", B[i][j]));
				}
				System.out.println();
			}
			
	
			//main algorithm
			for (int i = 0; i < matrix_order; i++)
			{
				for (int j = 0; j < matrix_order; j++)
				{
					C[i][j] = 0;
					for(int k = 0; k < matrix_order; k++)
					{
						C[i][j] += A[i][k] * B[k][j];
					}
				}
			}

			System.out.println("Multiplication result C");
			for (int i = 0; i < matrix_order; i++)
			{
				for(int j = 0; j < matrix_order; j++)
				{
					B[i][j] = random.nextInt(100);
					System.out.print(String.format("%5d", C[i][j]));
				}
				System.out.println();
			}
		}
	}
}
