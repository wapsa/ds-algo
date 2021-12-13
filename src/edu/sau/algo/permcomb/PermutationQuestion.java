package edu.sau.algo.permcomb;

public interface PermutationQuestion {

	void printPermutationsOfStringByFixingPos(String input, String output);

	void printPermutationsOfArrayByFixingPos1(char[] input, char[] output, int outPos);

	void printPermutationsOfArrayByFixingPos2(char[] input, int position);

	void printPermutationsOfArrayByFixingPos3(char[] input, int n);

	void printPermutationOfArrayByFixingInput(char[] input);

	/**
	 * print permutation of 'r' items(input) by arranging them on 'n'
	 * positions(positionCount)
	 */
	void printPermutationUsingIncludeExcludeByFixingPos(String input, int positionCount);

	void printPermutationsOfArrayUsingSJT1(int[] n);

	void printPermutationsOfArrayUsingSJT2(int[] n);

	void printPermutationsOfArrayUsingBRHeap(int[] n);

	/**
	 * Generate permutations with only non repeatable adjacent swaps allowed.
	 * 
	 * Given a string on length N. You can swap only the adjacent elements and each
	 * element can be swapped at most once. Given these rules, find the no of
	 * permutations of the string that can be generated after performing the swaps
	 * as mentioned.
	 */
	void permutationsWithAdjacentNonRepeatableSwaps1(String input);

	/**
	 * Generate permutations with only non repeatable adjacent swaps allowed using
	 * pascal identity.
	 */
	void permutationsWithAdjacentNonRepeatableSwaps2(String input);

	/**
	 * Generate permutations with only non repeatable adjacent swaps allowed using
	 * pascal identity expansion.
	 */
	void permutationsWithAdjacentNonRepeatableSwaps3(String input);

	/**
	 * Question: Get next greater number using the same digits
	 * 
	 * or
	 * 
	 * next lexicographic permutation
	 */
	void printNextLexicographicPermutation(String input);

	/**
	 * Generate kth lexicographic permutation.
	 */
	void printKthLexicographicPermutation(String input, int k);

	/**
	 * Question: Print all permutations in lexicographic order using brute force.
	 */
	void printAllPermutationsInLexicographicOrder1(String inputString);

	/**
	 * Question: Print all permutations in lexicographic order.
	 */
	void printAllPermutationsInLexicographicOrder2(String inputString);

	/**
	 * Question: Print all permutations in lexicographic order.
	 */
	void printAllPermutationsInLexicographicOrder3(String inputString);

	/**
	 * print all the paths using which we can reach noOfSteps by using the
	 * possibleOptions given.
	 */
	void printStairsPathPermutation(int noOfStep, int[] possibleOptions);

}
