package edu.sau.algo.recursion;

public interface RecursionQuestionL1 {

	public static final RecursionSolutionLevel1 INSTANCE = new RecursionSolutionLevel1();

	/**
	 * Print numbers in decreasing order from n till 1 and then in increasing order
	 * till n.
	 */
	void printDecreasingIncreasing(int n);

	/**
	 * Print factorial of numbers till n
	 */
	int factorial(int n);

	/**
	 * Print output following the euler tour.
	 */
	void eulerTourOfRecursion(int n);

	/**
	 * Calculate a to the power of p
	 */
	void printAToThePowerOfP(int a, int p);

	/**
	 * Print the steps to solve tower of hanoi problem given 'n' discs
	 */
	void printTowerOfHanoiSteps(int n);

	/**
	 * Print elements of array.
	 */
	void printElementsOfArray(int[] array);

	/**
	 * Print elements of array in reverse order.
	 */
	void printElementsOfArrayInReverse(int[] array);

	/**
	 * print max element of array.
	 */
	void printMaxElementOfArray(int[] array);

	/**
	 * print index of the first occurrence of given data in array.
	 */
	void printFirstIndexOfOccurrence(int[] array, int data);

	/**
	 * print index of the last occurrence of given data in array.
	 */
	void printLastIndexOfOccurrence(int[] array, int data);

	/**
	 * print all indexes of occurrence of given data in array.
	 */
	void printAllIndexOfOccurrence(int[] array, int data);

	/**
	 * print all subsequences of given string. Example: given abc, subsequences will
	 * be a,b,c,ab,bc,ac,abc, ""
	 */
	void printSubsequences(String input);

	/**
	 * Get all possible combinations that can be formed by picking one character
	 * from each group.
	 * 
	 * e.g. Input: ["abc", "def"], Then possible combinations will include ad, ae,
	 * af, bd, be, bf, cd, ce, cf
	 */
	void printGroupCombination(String[] groups);

}
