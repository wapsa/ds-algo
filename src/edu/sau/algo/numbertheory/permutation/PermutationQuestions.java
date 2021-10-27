package edu.sau.algo.numbertheory.permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationQuestions {

	public static void main(String[] args) {

		question1A("12345");

		question1B("12345");
	}

	/**
	 * Generate permutations with only non repeatable adjacent swaps allowed.
	 * 
	 * Given a string on length N. You can swap only the adjacent elements and each
	 * element can be swapped at most once. Given these rules, find the no of
	 * permutations of the string that can be generated after performing the swaps
	 * as mentioned.
	 * 
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

}
