package edu.sau.algo;

import java.util.Arrays;

/**
 * 
 * https://www.geeksforgeeks.org/bloom-filter-in-java-with-examples/
 * 
 * https://llimllib.github.io/bloomfilter-tutorial/
 *
 * https://www.baeldung.com/guava-bloom-filter
 *
 * https://en.wikipedia.org/wiki/Bloom_filter
 *
 * A Bloom filter is a memory-efficient, probabilistic data structure that we
 * can use to answer the question of whether or not a given element is in a set.
 *
 * There are no false negatives with a Bloom filter, so when it returns false,
 * we can be 100% certain that the element is not in the set.
 *
 * However, a Bloom filter can return false positives, so when it returns true,
 * there is a high probability that the element is in the set, but we can not be
 * 100% sure.
 *
 */
public class MissingNumberInArray {

	public static void main(String[] args) {
		int[] input = new int[] { 11, 12, 13, 15, 16, 17, 18, 19 };
		System.out.println("Missing Number: " + findMissingNumberInSortedRange(input));

		int[] input1 = new int[] { 12, 13, 11, 15, 19, 17, 16, 18 };
		System.out.println("Missing Number: " + findMissingNumberInUnSortedRange(input1, 11, 19));

		findMissingNumberInRangeUsingXOR();

		findMissingNumberInRangeUsingXOROptimized();

	}

	/**
	 * Time complexity: O(logn)
	 */
	public static int findMissingNumberInSortedRange(int[] array) {
		final int OFFSET = array[0];
		int startIdx = 0;
		int midIdx;
		int endIdx = array.length - 1;
		while ((endIdx - startIdx) > 1) {
			midIdx = (startIdx + endIdx) / 2;
			int expectedValueAtMid = OFFSET + midIdx;
			int actualValueAtMid = array[midIdx];

			// search part is in left of midIdx
			if (actualValueAtMid == expectedValueAtMid)
				startIdx = midIdx;
			// search part is in right of midIdx
			else
				endIdx = midIdx;
		}
		if (array[startIdx + 1] == array[startIdx] + 1) {
			// no missing element.
			return Integer.MIN_VALUE;
		}
		return (array[startIdx] + 1);
	}

	/**
	 * Time Complexity: O(n)
	 */
	public static int findMissingNumberInUnSortedRange(int[] array, int start, int end) {
		int sumFrom1ToLast = (end) * (end + 1) / 2;
		int sumFrom1ToStart = (start) * (start - 1) / 2;

		int expectedSum = sumFrom1ToLast - sumFrom1ToStart;
		int actualSum = Arrays.stream(array).sum();

		if (expectedSum - actualSum == 0) {
			// no missing element.
			return Integer.MIN_VALUE;
		}
		return expectedSum - actualSum;
	}

	/**
	 * Time Complexity: O(2n) = O(n)
	 * 
	 * <pre>
	 * For simplicity of implementation we have used array range from 1 - n.
	 * expected_xor: XOR(1,n) = 1^2^3^4^.....^n 
	 * actual_xor: XOR(1,n)~2 = 1^3^4^.....^n		(if 2 is missing)
	 * 
	 * Since XOR of A with itself is 0, so if we do XOR of expected_xor and actual_xor we will get X as 2.
	 * 
	 * </pre>
	 */
	public static void findMissingNumberInRangeUsingXOR() {
		int[] input = new int[] { 1, 3, 4, 5, 6, 7, 8, 9 }; // here missing is 2

		int expected_xor = 1;
		for (int i = 2; i <= 9; i++)
			expected_xor = expected_xor ^ i;

		int actual_xor = input[0];
		for (int i = 1; i < input.length; i++)
			actual_xor = actual_xor ^ input[i];

		System.out.println("Input: " + Arrays.toString(input));
		System.out.println("Missing Element: " + (expected_xor ^ actual_xor));
	}

	/**
	 * Thanks to https://a3nm.net/blog/xor.html for this implementation
	 * 
	 * Formula 1: to calculate XOR[1...n] (faster)
	 * 
	 * 1^...^n = (n>>1)&1 ^ (((n&1)>0)?1:n)
	 * 
	 * Formula 2: to calculate XOR[1...n] (slower)
	 * 
	 * 1^...^n = (n % 4 == 0) ? n : (n % 4 == 1) ? 1 : (n % 4 == 2) ? n + 1 : 0;
	 * 
	 * we can prove by induction that 1^...^n is either n or 1 or n+1 or 0 depending
	 * on n%4
	 * 
	 */
	public static void findMissingNumberInRangeUsingXOROptimized() {
		int[] input = new int[] { 1, 3, 4, 5, 6, 7, 8, 9 }; // here missing is 2

		int n = 9;
		int expected_xor_1_to_9 = (n >> 1) & 1 ^ (((n & 1) > 0) ? 1 : n);

		int actual_xor = input[0];
		for (int i = 1; i < input.length; i++)
			actual_xor = actual_xor ^ input[i];

		System.out.println("Input: " + Arrays.toString(input));
		System.out.println("Missing Element: " + (expected_xor_1_to_9 ^ actual_xor));
	}
}
