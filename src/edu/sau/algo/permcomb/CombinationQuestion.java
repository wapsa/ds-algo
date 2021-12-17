package edu.sau.algo.permcomb;

import java.util.List;

public interface CombinationQuestion {

	public static final CombinationSolution INSTANCE = new CombinationSolution();

	/**
	 * Get all possible combinations that can be formed by picking one character
	 * from each group.
	 * 
	 * e.g. Input: ["abc", "def"], Then possible combinations will include ad, ae,
	 * af, bd, be, bf, cd, ce, cf
	 */
	List<String> getGroupCombination(String[] groups);

	/**
	 * print all possible combinations that can be formed by picking one character
	 * from each group.
	 */
	void printGroupCombination(String[] groups);

	/**
	 * Print all possible combinations that can be formed by picking non-repeated
	 * digits of input and sum of the digits is equal to targetVal.
	 */
	void printTargetSumCombination(int[] input, int targetVal);

	/**
	 * print all the possible combinations by permutation of 'r' identical items at
	 * 'n'(positionCount) given positions.
	 */
	void printCombinationUsingPascalIdentityByFixingPos(int positionCount, int r);

	/**
	 * print all the possible combinations by permutation of 'r' identical items at
	 * 'n'(positionCount) given positions.
	 */
	void printCombinationUsingPascalIdentityExpansionByFixingPos(int positionCount, int r);

	/**
	 * print all the possible combinations by placing 'r' distinct items(input) at
	 * 'n' given positions(positionCount)
	 */
	void printCombinationUsingPermutationByFixingInput(int positionCount, String input);

	/**
	 * print all the possible combinations by placing 'r' distinct items(input) at
	 * 'n' given positions(positionCount)
	 */
	void printCombinationUsingPermutationByFixingPos(int positionCount, int r);

	/**
	 * print all the possible combinations by applying permutation/arrangement of
	 * 'r' identical items in 2D array.
	 * 
	 * @param r   : number of identical items
	 * @param row : row count
	 * @param col : column count
	 */
	void printCombinationOfItemIn2dArrayUsingPascalIdentityExpansionByFixingPos(int row, int col, int r);

	void printCombinationOfItemIn2dArrayByElongatingAndFixingPos(int row, int col, int r);

	void printNQueenCombinationsUsingPascalIdentityExpansionByFixingPos(int n);

}
