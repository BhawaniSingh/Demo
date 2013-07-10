package org.bhawanisingh.java.demo;

/**
 * 
 * @author Bhawani Singh
 */
class ArrayDemo
{
	static int max(int ar[])
	{
		int max = ar[0];
		System.out.print("Array Is :\t");
		for (int i = 1; i < ar.length; i++)
		{
			System.out.print(ar[i] + " ");
			if (max < ar[i])
			{
				max = ar[i];
			}
		}
		System.out.println();
		return max;
	}

	static int max1(int ar[][])
	{
		int max = ar[0][0];
		System.out.print("Array Is :\n");
		for (int[] element : ar) {
			System.out.println();
			for (int element2 : element) {
				System.out.print(element2 + " ");
				if (max < element2)
				{
					max = element2;
				}
			}
		}
		System.out.println();
		return max;
	}

	static int min(int ar[])
	{
		int min = ar[0];
		System.out.print("Array Is :\t");
		for (int i = 1; i < ar.length; i++)
		{
			System.out.print(ar[i] + " ");
			if (min > ar[i])
			{
				min = ar[i];
			}
		}
		System.out.print("\n");
		return min;
	}

	static int min1(int ar[][])
	{
		int min = ar[0][0];
		System.out.print("Array Is :\n");
		for (int[] element : ar) {
			System.out.print("\n");
			for (int element2 : element) {
				System.out.print(element2 + " ");
				if (min > element2)
				{
					min = element2;
				}
			}
		}
		System.out.print("\n");
		return min;
	}

	static void sort(int ar[])
	{
		int temp;
		System.out.print("Array Before Sorting :\t");
		for (int element : ar) {
			System.out.print(element + " ");
		}
		// logic for increasng order
		for (int i = 0; i < ar.length; i++)
		{
			for (int j = i; j < ar.length; j++)
			{
				if (ar[i] > ar[j])
				{
					temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}
		// output for increasing order
		System.out.println("\nArray in increasing order:\t");
		for (int element : ar) {
			System.out.print(element + "  ");
		}
		System.out.println("\n");

		// logic for decreasing order
		for (int i = 0; i < ar.length; i++)
		{
			for (int j = i; j < ar.length; j++)
			{
				if (ar[i] < ar[j])
				{
					temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}
		// output for decreasing order
		System.out.println("Array in decreasing order:\t");
		for (int element : ar) {
			System.out.print(element + "  ");
		}
		System.out.println("\n");
	}

	static void sort1(int ar[][])
	{
		int temp;
		int temp_ar[][] = ar;
		System.out.print("Array Before Sorting :\t");
		for (int[] element : ar) {
			System.out.print("\n");
			for (int element2 : element) {
				System.out.print(element2 + " ");
			}
		}
		System.out.print("\n");
		// logic for increasng order
		for (int i = 0; i < ar.length; i++)
		{
			// System.out.println("Inside I Loop");
			for (int j = 0; j < ar[i].length; j++)
			{
				// System.out.println("Inside J Loop");
				for (int k = 0; k < ar.length; k++)
				{
					// System.out.println("Inside K Loop");
					for (int l = 0; l < ar[k].length; l++)
					{
						// System.out.println("Inside L Loop");
						if (ar[i][j] < ar[k][l])
						{
							// System.out.println("Inside If Condition");
							temp = ar[i][j];
							ar[i][j] = ar[k][l];
							ar[k][l] = temp;
						}
					}
				}
			}
		}
		// output for increasing order
		System.out.println("Array in increasing order:\t");
		for (int[] element : ar) {
			for (int element2 : element) {
				System.out.print(element2 + "  ");
			}
		}
		System.out.println("\n");

		// logic for decreasing order
		for (int i = 0; i < ar.length; i++)
		{
			for (int j = 0; j < ar[i].length; j++)
			{
				for (int k = 0; k < ar.length; k++)
				{
					for (int l = 0; l < ar[k].length; l++)
					{
						if (ar[i][j] > ar[k][l])
						{
							temp = ar[i][j];
							ar[i][j] = ar[k][l];
							ar[k][l] = temp;
						}
					}
				}
			}
		}
		// output for decreasing order
		System.out.println("Array in decreasing order:\t");
		for (int i = 0; i < ar.length; ++i)
		{
			for (int j = 0; j < temp_ar[i].length; j++) {
				System.out.print(ar[i][j] + "  ");
			}
		}
		System.out.println("\n");
	}

	static void mergesort(int x[], int y[])
	{
		int z[] = new int[x.length + y.length];
		System.out.print("First Array :\t");
		for (int i = 0; i < x.length; i++)
		{
			System.out.print(x[i] + " ");
			z[i] = x[i];
		}
		System.out.print("\nSecond Array :\t");
		for (int i = x.length, j = 0; i < z.length; i++, j++)
		{
			System.out.print(y[j] + " ");
			z[i] = y[j];
		}
		System.out.print("\n");
		ArrayDemo.sort(z);
	}

	static void union(int x[], int y[])
	{
		boolean chk;
		int len = 0;
		System.out.print("First Array :\t");
		for (int element : x) {
			System.out.print(element + " ");
		}
		System.out.print("\nSecond Array :\t");
		for (int element : y) {
			System.out.print(element + " ");
		}
		System.out.print("\n");
		for (int i = 0; i < x.length; i++)
		{
			loop: for (int j = 0; j < y.length; j++)
			{
				if (x[i] == y[j])
				{
					len++;
					break loop;
				}
			}
		}
		int z[] = new int[(x.length + y.length) - len];
		for (int i = 0; i < x.length; i++)
		{
			z[i] = x[i];
		}
		for (int i = x.length, j = 0; j < y.length; j++)
		{
			chk = true;
			loop: for (int k = 0; k < x.length; k++)
			{
				if (y[j] == x[k])
				{
					chk = false;
					break loop;
				}
			}
			if (chk == true)
			{
				z[i] = y[j];
				++i;
			}
		}
		System.out.print("Union of the Arrays:\t");
		for (int element : z) {
			System.out.print(element + "  ");
		}
		System.out.println("\n");
	}

	static void intersection(int x[], int y[])
	{
		System.out.print("First Array :\t");
		for (int element : x) {
			System.out.print(element + " ");
		}
		System.out.print("\nSecond Array :\t");
		for (int element : y) {
			System.out.print(element + " ");
		}
		System.out.print("\n");
		int len = 0;
		for (int i = 0; i < x.length; i++)
		{
			loop: for (int j = 0; j < y.length; j++)
			{
				if (x[i] == y[j])
				{
					len++;
					break loop;
				}
			}
		}
		int z[] = new int[len];
		for (int i = 0, j = 0; j < y.length; j++)
		{
			loop: for (int k = 0; k < x.length; k++)
			{
				if (y[j] == x[k])
				{
					z[i] = y[j];
					++i;
					break loop;
				}
			}
		}
		System.out.print("Intersection of the Arrays:\t");
		for (int element : z) {
			System.out.print(element + "  ");
		}
		System.out.println("\n");
	}

	static void matrixadd(int x[][], int y[][])
	{
		if (x.length != y.length)
		{
			System.out.println("Addition Not Possible");
		}
		else
		{
			int z[][] = new int[x.length][x[0].length];
			for (int i = 0, k = 0; k < y.length; i++, k++)
			{
				System.out.print("\n");
				for (int j = 0; j < x[i].length; j++)
				{
					System.out.print(x[i][j] + "  ");
				}

				System.out.print("    ");
				for (int j = 0; j < y[k].length; j++)
				{
					System.out.print(y[i][j] + "  ");
				}
			}

			for (int i = 0; i < x.length; i++)
			{
				System.out.print("\n\t");
				for (int j = 0; j < x[i].length; j++)
				{
					z[i][j] = x[i][j] + y[i][j];
					System.out.print(z[i][j] + "  ");
				}

			}
		}
	}

	static void matrixsum(int x[][])
	{
		int sumr = 0, sumc[], sumd1 = 0, sumd2 = 0;
		sumc = new int[x[0].length];
		for (int i = 0; i < x.length; i++)
		{
			sumr = 0;
			System.out.print("\n   ");
			for (int j = 0; j < x[i].length; j++)
			{
				System.out.print(x[i][j] + " ");
				sumc[j] = sumc[j] + x[i][j];
				sumr = sumr + x[i][j];
				if (i == j)
				{
					sumd1 = sumd1 + x[i][j];
				}
				if (j == (x[0].length - (i + 1)))
				{
					sumd2 = sumd2 + x[i][j];
				}
			}
			System.out.print(sumr);
		}
		System.out.print("\n" + sumd2 + " ");
		for (int i = 0; i < x[0].length; i++)
		{
			System.out.print(sumc[i] + " ");
		}
		System.out.print(sumd1);
		// System.out.println(sumd1 + "\n" + sumd2 + "\n");
	}

	static void matrixm(int x[][], int y[][])
	{
		int z[][] = new int[x.length][x[0].length];
		if (x[0].length != y.length)
		{
			System.out.println("Sorry Matrices Can't Be Multiplied");
		}
		for (int i = 0; i < x.length; i++)
		{
			System.out.print("\n");
			for (int j = 0; j < x[i].length; j++)
			{
				System.out.print(x[i][j] + "  ");
			}
			System.out.print("\t");
			for (int j = 0; j < y[i].length; j++)
			{
				System.out.print(y[i][j] + "  ");
			}
		}
		for (int i = 0; i < x.length; i++)
		{
			for (int j = 0; j < x[i].length; j++)
			{
				z[i][j] = 0;
				for (int[] element : y) {
					z[i][j] = z[i][j] + (x[i][j] * element[i]);
				}
			}
		}

		for (int[] element : z) {
			System.out.print("\n\t");
			for (int element2 : element) {
				System.out.print(element2 + "  ");
			}
		}
	}

	static int triangleAmax(int x[][])
	{
		int max = x[0][0];
		System.out.print("Triangle Is:\n");
		for (int i = 0; i < x.length; i++)
		{
			System.out.print("\n");
			for (int j = 0; j < x[i].length; j++)
			{
				if (i <= j)
				{
					System.out.print(x[i][j] + " ");
					if (max < x[i][j])
					{
						max = x[i][j];
					}
				}
				else
				{
					System.out.print("  ");
				}
			}
		}
		System.out.print("\n");
		return max;
	}

	static int triangleAmin(int x[][])
	{
		int min = x[0][0];
		System.out.print("Triangle Is:\n");
		for (int i = 0; i < x.length; i++)
		{
			System.out.print("\n");
			for (int j = 0; j < x[i].length; j++)
			{
				if (i <= j)
				{
					System.out.print(x[i][j] + " ");
					if (min > x[i][j])
					{
						min = x[i][j];
					}
				}
				else
				{
					System.out.print("  ");
				}
			}
		}
		System.out.println();
		return min;
	}

	static void triangleAsum(int x[][])
	{
		int sumr = 0, sumc[], sumd1 = 0, sumd2 = 0;
		sumc = new int[x[0].length];
		for (int i = 0; i < x.length; i++)
		{
			sumr = 0;
			System.out.print("\n   ");
			for (int j = 0; j < x[i].length; j++)
			{
				if (i <= j)
				{
					System.out.print(x[i][j] + " ");
					sumc[j] = sumc[j] + x[i][j];
					sumr = sumr + x[i][j];
					if (i == j)
					{
						sumd1 = sumd1 + x[i][j];
					}
					if (j == (x[0].length - (i + 1)))
					{
						sumd2 = sumd2 + x[i][j];
					}
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.print(sumr);
		}
		System.out.print("\n\n" + sumd2 + " ");
		for (int i = 0; i < x[0].length; i++)
		{
			System.out.print(sumc[i] + " ");
		}
		System.out.print(sumd1);
	}

	static int triangleAsum1(int x[][])
	{
		int sum = 0;
		for (int i = 0; i < x.length; i++)
		{
			System.out.println();
			for (int j = 0; j < x[i].length; j++)
			{
				if (i <= j)
				{
					System.out.print(x[i][j] + " ");
					sum = sum + x[i][j];
				}
				else
				{
					System.out.print("  ");
				}
			}
		}
		System.out.println();
		return sum;
	}

	static int triangleBmax(int x[][])
	{
		int max = x[0][0];
		for (int i = 0; i < x.length; i++)
		{
			System.out.print("\n");
			for (int j = 0; j < x[i].length; j++)
			{
				if (i >= j)
				{
					System.out.print(x[i][j] + " ");
					if (max < x[i][j])
					{
						max = x[i][j];
					}
				}
			}
		}
		System.out.println();
		return max;
	}

	static int triangleBmin(int x[][])
	{
		int min = x[0][0];
		for (int i = 0; i < x.length; i++)
		{
			System.out.print("\n");
			for (int j = 0; j < x[i].length; j++)
			{
				if (i >= j)
				{
					System.out.print(x[i][j] + " ");
					if (min > x[i][j])
					{
						min = x[i][j];
					}
				}
			}
		}
		System.out.println();
		return min;
	}

	static void triangleBsum(int x[][])
	{
		int sumr = 0, sumc[], sumd1 = 0, sumd2 = 0;
		sumc = new int[x[0].length];
		for (int i = 0; i < x.length; i++)
		{
			sumr = 0;
			System.out.print("\n   ");
			for (int j = 0; j < x[i].length; j++)
			{
				if (i >= j)
				{
					System.out.print(x[i][j] + " ");
					sumc[j] = sumc[j] + x[i][j];
					sumr = sumr + x[i][j];
					if (i == j)
					{
						sumd1 = sumd1 + x[i][j];
					}
					if (j == (x[0].length - (i + 1)))
					{
						sumd2 = sumd2 + x[i][j];
					}
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.print(sumr);
		}
		System.out.print("\n\n" + sumd2 + " ");
		for (int i = 0; i < x[0].length; i++)
		{
			System.out.print(sumc[i] + " ");
		}
		System.out.print(sumd1);
	}

	static int triangleBsum1(int x[][])
	{
		int sum = 0;
		for (int i = 0; i < x.length; i++)
		{
			System.out.println();
			for (int j = 0; j < x[i].length; j++)
			{
				if (i >= j)
				{
					System.out.print(x[i][j] + " ");
					sum = sum + x[i][j];
				}
			}
		}
		System.out.println();
		return sum;
	}

	public static void main(String... s)
	{
		// For maximum val
		System.out.println("Max Value Is:\t" + ArrayDemo.max(new int[] { 10, 100, 200, 23, 34, 3434, 546, 6, 5, 6, 7, 8, 9, 0, 2, 3, 4, 5, 6, 7, 10, 100, 209 }) + "\n");

		// For maximum val (Array of Arrays)
		System.out.println("Max Value Is (For Array Of Arrays):\t" + ArrayDemo.max1(new int[][] {
				{ 10, 100, 200, 23 },
				{ 34, 3434, 546, 6, 5 },
				{ 6, 7, 8, 9, 0, 2, 3, 4, 5 },
				{ 6, 7 },
				{ 10, 100, 209 }
		}) + "\n");

		// For minimun val
		System.out.println("Min Value Is:\t" + ArrayDemo.min(new int[] { 10, 100, 200, 23, 34, 3434, 546, 6, 5, 6, 7, 8, 9, 0, 2, 3, 4, 5, 6, 7, 10, 100, 209 }) + "\n");

		// For miniimum val (Array of Arrays)
		System.out.println("Min Value Is (For Array Of Arrays):\t" + ArrayDemo.min1(new int[][] {
				{ 10, 100, 200, 23 },
				{ 34, 3434, 546, 6, 5 },
				{ 6, 7, 8, 9, 0, 2, 3, 4, 5 },
				{ 6, 7 },
				{ 10, 100, 209 }
		}) + "\n");

		// For sort
		System.out.println("Sorting:");
		ArrayDemo.sort(new int[] { 10, 100, 200, 23, 34, 3434, 546, 6, 5, 6, 7, 8, 9, 0, 2, 3, 4, 5, 6, 7, 10, 100, 209 });

		// For sort (Array of Arrays)
		System.out.println("Sorting (For Array of Arrays):");
		ArrayDemo.sort1(new int[][] {
				{ 10, 100, 200, 23 },
				{ 34, 3434, 546, 6, 5 },
				{ 6, 7, 8, 9, 0, 2, 3, 4, 5 },
				{ 6, 7 },
				{ 10, 100, 209 }
		});

		// For Merge Sort
		System.out.println("Merge Sort:");
		ArrayDemo.mergesort(new int[] { 10, 100, 200, 23, 34, 3434, 546 }, new int[] { 6, 5, 6, 7, 8, 9, 0, 2, 3, 4, 5, 6, 7, 10, 100, 209 });

		// For Union
		System.out.println("Union:");
		ArrayDemo.union(new int[] { 10, 100, 200, 23, 34, 3434, 6, 546 }, new int[] { 6, 5, 200, 8, 9, 2, 3, 4, 10, 7, 34, 100, 209 });

		// For Intersection
		System.out.println("Intersection:");
		ArrayDemo.intersection(new int[] { 10, 100, 200, 23, 34, 3434, 6, 546 }, new int[] { 6, 5, 200, 8, 9, 2, 3, 4, 0, 7, 34, 10, 100, 209 });

		// For Matrix Addition
		System.out.print("Matrix Addition:");
		ArrayDemo.matrixadd(new int[][] { { 10, 20, 30 }, { 40, 50, 55 }, { 15, 25, 50 } }, new int[][] { { 34, 12, 42 }, { 11, 43, 64 }, { 5, 25, 10 } });

		// For Matrix Sum
		System.out.print("\n\nMatrix Sum:");
		ArrayDemo.matrixsum(new int[][] { { 10, 20, 30 }, { 40, 50, 55 }, { 15, 25, 50 } });

		// For Matrix Multiplication
		System.out.print("\n\nMatrix Multiplication:");
		ArrayDemo.matrixm(new int[][] { { 10, 20, 30 }, { 40, 50, 55 }, { 15, 25, 50 } }, new int[][] { { 34, 12, 42 }, { 11, 43, 64 }, { 5, 25, 10 } });

		// For Triangle A Max
		System.out.print("\n\nTriangle A Max:\t" + ArrayDemo.triangleAmax(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));

		// For Triangle A Min
		System.out.print("\n\nTriangle A Min:\t" + ArrayDemo.triangleAmin(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));

		// For Triangle A Sum
		System.out.print("\n\nTriangle A Sum:");
		ArrayDemo.triangleAsum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });

		// For Triangle A Sum1
		System.out.print("\n\nTriangle A Sum:\t" + ArrayDemo.triangleAsum1(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));

		// For Triangle B Max
		System.out.print("\n\nTriangle B Max:\t" + ArrayDemo.triangleBmax(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));

		// For Triangle B Min
		System.out.print("\n\nTriangle B Min:\t" + ArrayDemo.triangleBmin(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));

		// For Triangle B Sum
		System.out.print("\n\nTriangle B Sum:");
		ArrayDemo.triangleBsum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });

		// For Triangle B Sum1
		System.out.print("\n\nTriangle B Sum:\t" + ArrayDemo.triangleBsum1(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
	}
}
