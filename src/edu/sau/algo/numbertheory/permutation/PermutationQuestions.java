package edu.sau.algo.numbertheory.permutation;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationQuestions {

	public static void main(String[] args) {

		// question1A("12345");
		// question1B("12345");
		// question1C("12345");

		// System.out.println(question2("12345"));

		// question3A("1234");

		question3B("1234");

		// question4("12345", 67);
	}

	/**
	 * Generate permutations with only non repeatable adjacent swaps allowed.
	 * 
	 * Given a string on length N. You can swap only the adjacent elements and each
	 * element can be swapped at most once. Given these rules, find the no of
	 * permutations of the string that can be generated after performing the swaps
	 * as mentioned.
	 */
	private static void question1A(String input) {

		List<String> inputPairs = IntStream.range(1, input.length())
				.mapToObj(i -> "" + input.charAt(i - 1) + input.charAt(i)).collect(Collectors.toList());

		findPermutations(inputPairs, new ArrayList<>(), input);
	}

	private static void findPermutations(List<String> inputPairs, List<String> outputPairs, String originalString) {

		if (inputPairs.isEmpty()) {

			char[] inputArray = originalString.toCharArray();
			for (String swapPair : outputPairs) {
				int i = originalString.indexOf(swapPair);
				swap(inputArray, i, i + 1);
			}
			System.out.println("Input: " + originalString + ", Swapping Pairs:" + outputPairs + ", Output: "
					+ String.valueOf(inputArray));
			return;
		}

		// candidate pair
		List<String> copyOfInputPairs = new ArrayList<>(inputPairs);
		String pair = copyOfInputPairs.remove(0);

		if (!containsOverlappingPair(outputPairs, pair)) {
			List<String> copyOfOutputPairs = new ArrayList<>(outputPairs);
			copyOfOutputPairs.add(pair);
			findPermutations(copyOfInputPairs, copyOfOutputPairs, originalString);
		}

		findPermutations(copyOfInputPairs, outputPairs, originalString);
	}

	private static boolean containsOverlappingPair(List<String> outputPairs, String inputPair) {
		for (String pair : outputPairs) {
			if (pair.charAt(1) == inputPair.charAt(0))
				return true;
		}
		return false;
	}

	private static void swap(char[] input, int i, int j) {
		char c = input[i];
		input[i] = input[j];
		input[j] = c;
	}

	/**
	 * Generate permutations with only non repeatable adjacent swaps allowed.
	 * 
	 * Given a string on length N. You can swap only the adjacent elements and each
	 * element can be swapped at most once. Given these rules, find the no of
	 * permutations of the string that can be generated after performing the swaps
	 * as mentioned.
	 * 
	 * Solution:
	 * 
	 * Include Step: We will pick two non-overlapping adjacent elements at a time as
	 * swap pair.
	 * 
	 * Exclude Step: Exclude single element, In 12345 we can create swap pair 23 by
	 * excluding 1. We should not exclude in pairs.
	 * 
	 */
	private static void question1B(String input) {
		findPermutations(input.toCharArray(), 0);
	}

	private static void findPermutations(char[] input, int idx) {

		// If we are left with only single element, we cannot form a swap pair so we are
		// terminating in that scenario also.
		if (idx >= input.length || (idx + 1) >= input.length) {
			System.out.println(String.valueOf(input));
			return;
		}

		// Include Step: Swap with the next character and revert the changes.
		swap(input, idx, idx + 1);
		findPermutations(input, idx + 2);
		swap(input, idx, idx + 1);

		// Exclude Step: don't swap the current position
		findPermutations(input, idx + 1);
	}

	/**
	 * Here instead of Pascal Identity(i.e. Include-Exclude) will use Pascal
	 * Identity Expansion of Exclude terms into Include Terms.
	 * 
	 * This is more efficient than include exclude based solution. i.e. question1B
	 */
	private static void question1C(String input) {
		adjSwapPermUsingPascalIdentityExpansion(input.toCharArray(), 0);
	}

	private static void adjSwapPermUsingPascalIdentityExpansion(char[] input, int index) {
		System.out.println(String.valueOf(input));
		for (int i = index; i < input.length && (i + 1) < input.length; i++) {
			swap(input, i, i + 1);
			adjSwapPermUsingPascalIdentityExpansion(input, index + 2);
			swap(input, i, i + 1);
		}

	}

	/**
	 * Question: Get next greater number using the same digits or next lexicographic
	 * permutation
	 */
	private static String question2(String inputString) {
		char[] input = inputString.toCharArray();

		getNextLexicographicPermutation(input);

		return String.valueOf(input);
	}

	/**
	 * Question: Print all permutations in lexicographic order.
	 * 
	 * Time Complexity: n! * n
	 * 
	 * @param inputString should be sorted order.
	 */
	private static void question3A(String inputString) {
		char[] input = inputString.toCharArray();

		// largest permutation as inputString is in sorted order.
		final String LARGEST_PERMUTATION = new StringBuilder(inputString).reverse().toString();

		System.out.println(inputString);
		while (!inputString.equals(LARGEST_PERMUTATION)) {
			getNextLexicographicPermutation(input);
			inputString = String.valueOf(input);
			System.out.println(inputString);
		}
	}

	private static void question3B(String inputString) {
		List<Character> charList = inputString.chars().mapToObj(ch -> (char) ch).collect(Collectors.toList());
		int factorial = factorial(inputString.length());

		for (int i = 1; i <= factorial; i++) {
			char[] result = getKthLexicographicPermutation(new ArrayList<>(charList), i);
			System.out.println(result);
		}
	}

	private static void question4(String inputStr, int k) {
		List<Character> charList = inputStr.chars().mapToObj(ch -> (char) ch).collect(Collectors.toList());
		char[] result = getKthLexicographicPermutation(charList, k);
		System.out.println(String.valueOf(result));
	}

	/**
	 * <pre>
	 * Time Complexity : time to calculate factorial + time for output loop * time taken for input.remove
	 *                 : O(n) + O(n) * O(n)
	 *                 : O(n) + O(n^2)
	 *                 : O(n^2)
	 * </pre>
	 */
	private static char[] getKthLexicographicPermutation(List<Character> input, int k) {
		char[] output = new char[input.size()];

		int factorial = factorial(input.size());
		int blockSize = factorial / input.size();

		k = k - 1;
		for (int i = 0; i < output.length; i++) {

			int blockNumber = k / blockSize;

			output[i] = input.get(blockNumber);
			input.remove(blockNumber);
			if (input.size() == 0)
				break;

			k = k % blockSize;
			blockSize = blockSize / input.size();
		}

		return output;
	}

	private static int factorial(int num) {
		if (num == 0 || num == 1)
			return 1;
		return num * factorial(num - 1);
	}

	/**
	 * <pre>
	 * Step1 : Identify Pivot Traverse the array from right side and stop at the
	 * first element which is not in ascending order. Example : 2 is pivot in
	 * 0125330 
	 * Question: Why we are traversing in ascending order from right side? : Because of PROPERTY_1. 
	 * 
	 * Step2: Find Successor of Pivot Find the next greater
	 * digit than the Pivot among digits present in right-side of the pivot.
	 * 
	 * Note : Since right side of the pivot contains all the digits in sorted order, so we
	 * can apply binary serach.
	 * 
	 * Step 3: Swap the Pivot with Successor. Because we want just next greater
	 * element which is only possiple by replacing pivot with successor.
	 * 
	 * Step4: Now reverse sort(descending order from right side) all the elements
	 * lying in right-side of pivot position. 
	 * 
	 * Note : Since right side of the pivot position is already in sorted order, 
	 * so just need to reverse the element to get them in descending order.
	 * 
	 * Question: Why do we sort elements lying right-side of pivot position in descending order? : Because of PROPERTY_1.
	 * </pre>
	 * 
	 * <pre>
	 * TimeComplexity : STEP1 +  STEP2   + STEP3 + STEP4
	 *                : O(n)  +  O(logn) + O(1)  + O(n) 
	 *                : O(n)
	 * </pre>
	 */
	private static void getNextLexicographicPermutation(char[] input) {
		// STEP 1: Find the pivot.
		int pivotIndex = Integer.MIN_VALUE;
		for (int i = input.length - 1; i > 0; i--)
			if (input[i - 1] < input[i]) {
				pivotIndex = i - 1;
				break;
			}

		// pivot not found, means input itself is the largest element using given
		// digits.
		if (pivotIndex == Integer.MIN_VALUE)
			return;

		// STEP 2: Find the successor using binary search

		// we are increasing the targetValue by 1, because we want to find the insertion
		// position of successor value.
		char targetValue = input[pivotIndex];
		targetValue++;

		int targetInsertionIndex = bisectRightInDescendingArray(input, targetValue, pivotIndex + 1, input.length);
		int pivotSuccessorIndex = targetInsertionIndex - 1;

		// STEP 3: Swap pivot element with its successor to the right-side of the array.
		swap(input, pivotIndex, pivotSuccessorIndex);

		// STEP 4: Reverse the array elements from pivot-index (exclusive) to the end of
		// the array.

		int startIndex = pivotIndex + 1;
		int endIndex = input.length - 1;
		int diff = endIndex - startIndex;

		// (diff - 1) avoids self swap
		for (int i = 0; i <= (diff - 1) >> 1; i++) {
			char temp = input[startIndex + i];
			input[startIndex + i] = input[endIndex - i];
			input[endIndex - i] = temp;
		}

	}

	/**
	 * elements between left and right indexes in input array must be in descending
	 * order.
	 */
	private static int bisectRightInDescendingArray(char[] input, char searchElement, int left, int right) {
		while (left < right) {
			int mid = (left + right) / 2;

			if (input[mid] < searchElement)
				right = mid;
			else
				left = mid + 1;
		}

		return left;
	}

}
