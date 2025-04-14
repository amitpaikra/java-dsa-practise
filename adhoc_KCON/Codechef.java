import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{


	/**
	 * Kadane's Algoritm to find best maximum subarray
	 * @param N
	 * @param array
	 * @return
	 */
	private static long kadane (int N, int[] array) {

		long sum_so_far = 0;
		long max_sub_array = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; ++i)  {
			sum_so_far += array[i];
			if (max_sub_array < sum_so_far) {
				max_sub_array = sum_so_far;
			}
			if (sum_so_far < 0) {
				sum_so_far = 0;
			}
		}
		return max_sub_array;

	}

	
	private static long maxSubArray (int N, int K, int[] array) {
		long kadaneResult = kadane(N, array);
		if (K == 1)
			return kadaneResult;
		
		long currPrefixSum = 0;
		long maxPrefixSum = Integer.MIN_VALUE;
		long currSuffixSum = 0;
		long maxSuffixSum = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; ++i) {
			currPrefixSum += array[i];
			maxPrefixSum = Math.max(currPrefixSum, maxPrefixSum);
		}
		for (int i = array.length-1; i >= 0; --i) {
			currSuffixSum += array[i];
			maxSuffixSum = Math.max(currSuffixSum, maxSuffixSum);
		}
		long totalSum = currPrefixSum;

		if (totalSum < 0) {
			return Math.max(kadaneResult, maxSuffixSum + maxPrefixSum);
		}
		return Math.max (kadaneResult, maxSuffixSum + totalSum*(K-2) + maxPrefixSum);

	}



	private static boolean platform = false;

	public static void main (String[] args) throws java.lang.Exception
	{
		
		try {
			Scanner sc = null;
			if (!platform) {
				sc = new Scanner(new File ("testcases/1.txt"));
			}
			else {
				sc = new Scanner(System.in);
			}
			int numberOfTestCase = sc.nextInt();
			while (numberOfTestCase-- > 0) {
				int N = sc.nextInt();
				int K = sc.nextInt();
				int[] array = new int[N];
				if (!platform) {
					System.out.println("N="+N+", K"+K);
				}
				for (int i = 0; i < N; ++i) {
					array[i] = sc.nextInt();
					if (!platform) {
						System.out.print(array[i] + " ");
					}
				}
				if (!platform) {
					System.out.println("Output : " + maxSubArray(N, K, array));
				}
				else {
					System.out.println(maxSubArray(N, K, array));
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File Not exist : " + e);	
		}
		

	}
}
