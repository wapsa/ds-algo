package edu.sau.algo.permcomb;

public interface PermutationQuestion {

	public static final PermutationSolution INSTANCE = new PermutationSolution();

	/**
	 * print permutations of given input.
	 */
	void printPermutationsOfStringByFixingPos(String input);

	void printPermutationsOfArrayByFixingPos(char[] input);

	void printPermutationOfArrayByFixingInput(char[] input);

	void printPermutationsOfArrayBySwappingAndFixingPos1(char[] input);

	void printPermutationsOfArrayBySwappingAndFixingPos2(char[] input);

	/**
	 * print permutation of 'r' items(input) by arranging them on 'n'
	 * positions(positionCount). r < n
	 * 
	 * @param positionCount : represents 'n' positions.
	 * @param item          : represents 'r' distinct characters
	 */
	void printPermutationOfItemInArrayByFixingPos(int positionCount, String item);

	void printPermutationOfItemInArrayByFixingInput(int positionCount, String item);

	/**
	 * <pre>
	 * print permutation of 'r' items(may have duplicates) by arranging them on 'n' positions,
	 * where r <= n.
	 * 
	 * permutation_count_for_distinct_item = nPr
	 *
	 * permutation_count_for_item_having_duplicates = n! / (n-r)! * i1! * i2!
	 * where i1 = duplicate count of item1
	 *       i2 = duplicate count of item2
	 *
	 * Example: Given, n = 9, item: "aaabbc" so here r = 6
	 * permutation_count calculation: n = 9, r = 6, i1_count=3, i2_count=2, i3_count=1
	 *
	 * nPr = n! / ((n-r)! * i1! * i2! * i3!) =  9! / ((9-6)! * 3! * 2! * 1!) = 5040
	 * 
	 * </pre>
	 * 
	 * @param item          : item String represents r chars and can contain
	 *                      duplicate like aab
	 * @param positionCount : represents 'n' positions
	 */
	void printPermutationOfItemInArrayByHandlingDuplicatesAndFixingPos(int positionCount, String item);

	void printPermutationOfItemInArrayByHandlingDuplicatesAndFixingInput(int positionCount, String item);

	/**
	 * print permutation of 'r' distinct items by arranging them in 2D-array.
	 * 
	 * r < n, where n = row * col
	 * 
	 * @param item : represents 'r' distinct characters
	 * @param row  : row count
	 * @param col  : column count
	 */
	void printPermutationOfItemIn2dArrayByFixingInput(int row, int col, String item);

	void printPermutationOfItemIn2dArrayByFixingPos(int row, int col, String item);

	/**
	 * print permutation of 'r' distinct items by arranging them in 2d-array by
	 * using 1d-positions. 2d-array should be elongated and then iterate over
	 * 1d-indexes.
	 */
	void printPermutationOfItemIn2dArrayByElongatingAndFixingInput(int row, int col, String item);

	/**
	 * print permutation of 'r' distinct items by arranging them in 2D-array, where
	 * r <= positonCount(row*col)
	 * 
	 * Note: Elongating 2D-positions in 1D-positions make sense when we want to fix
	 * the position. Because position will be passed as method parameter. And it is
	 * easy to reach the end of 1D-array recursively by incrementing the 'posToFix'
	 * method parameter than to reach the end cell of 2D-array recursively by
	 * synchronizing and incrementing the two method parameters 'rowPosToFix' &
	 * 'colPosToFix'.
	 */
	void printPermutationOfItemIn2dArrayByElongatingAndFixingPos(int row, int col, String item);

	void printNQueenPermutationsByFixingPos(int n);

	void printNQueenPermutationsByFixingInput(int n);

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
