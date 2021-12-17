package edu.sau.algo.recursion;

import java.util.List;

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
	List<String> getGroupCombination(String[] groups);

	/**
	 * Get all possible combinations that can be formed by picking one character
	 * from each group.
	 * 
	 * e.g. Input: ["abc", "def"], Then possible combinations will include ad, ae,
	 * af, bd, be, bf, cd, ce, cf
	 */
	void printGroupCombination(String[] groups);

	/**
	 * print all the paths using which we can reach noOfSteps by using the
	 * possibleOptions given.
	 */
	void printStairsPathPermutation(int noOfStep, int[] possibleOptions);

	/**
	 * print all the paths using which we can reach noOfSteps by using the
	 * possibleOptions given.
	 */
	List<String> getStairsPathPermutation(int noOfStep, int[] possibleOptions);

	/**
	 * print all possible paths from start to end using only right and down
	 * operations.
	 */
	void printMazePathsToReachDestination1(int startCol, int startRow, int endCol, int endRow);

	/**
	 * print all possible paths from start to end using only right and down
	 * operations.
	 */
	List<String> getMazePathsToReachDestination1(int startCol, int startRow, int endCol, int endRow);

	/**
	 * print all possible paths from start to end using only right, down and
	 * diagonal operations.
	 */
	void printMazePathsToReachDestination2(int startCol, int startRow, int endCol, int endRow);

	/**
	 * print all possible paths from start to end using only right, down and
	 * diagonal operations.
	 */
	List<String> getMazePathsToReachDestination2(int startCol, int startRow, int endCol, int endRow);

	/**
	 * <pre>
	 * Print all the possible maze paths between start_pos to end_pos using 
	 * 1. right move of step size  1 to (n-1) unit
	 * 2. down move of step size 1 to (m-1) unit
	 * 3. diagonal move of step size 1 to Math.max((n-1), (m-1)) size
	 * </pre>
	 */
	void printMazePathsToReachDestination3(int startCol, int startRow, int endCol, int endRow);

	/**
	 * <pre>
	 * Print all the possible maze paths between start_pos to end_pos using 
	 * 1. right move of step size  1 to (n-1) unit
	 * 2. down move of step size 1 to (m-1) unit
	 * 3. diagonal move of step size 1 to Math.max((n-1), (m-1)) size
	 * </pre>
	 */
	List<String> getMazePathsToReachDestination3(int startCol, int startRow, int endCol, int endRow);

	/**
	 * Print all the possible maze paths between start_pos to end_pos avoiding all
	 * obstacles(represented by 1's) in the maze provided. Moves allowed are left,
	 * right, top and down.
	 */
	void printMazePathsAvoidingObstaclesToReachDestination4(int[][] maze, int startCol, int startRow, int endCol,
			int endRow);

	/**
	 * A message containing letters from A-Z can be encoded into numbers using the
	 * following mapping:
	 * 
	 * 'A' -> "1" 'B' -> "2" ... 'Z' -> "26" To decode an encoded message, all the
	 * digits must be grouped then mapped back into letters using the reverse of the
	 * mapping above (there may be multiple ways). For example, "11106" can be
	 * mapped into:
	 * 
	 * "AAJF" with the grouping (1 1 10 6) "KJF" with the grouping (11 10 6) Note
	 * that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F'
	 * since "6" is different from "06".
	 * 
	 * Given a string s containing only digits, return the number of ways to decode
	 * it.
	 */
	void printEncodings(String input);

	/**
	 * Print all the possible allowed combinations of N queens on N X N Matrix such
	 * that no queen can attack the other queens.
	 */
	void printNQueenAllowedPlacements1(int n);

	/**
	 * Print all the possible allowed combinations of N queens on N X N Matrix such
	 * that no queen can attack the other queens.
	 */
	void printNQueenAllowedPlacements2(int n);

	/**
	 * Print all the possible allowed combinations of N queens on N X N Matrix such
	 * that no queen can attack the other queens.
	 */
	void printNQueenAllowedPlacements3(int n);

	/**
	 * Print all the possible allowed combinations of N queens on N X N Matrix such
	 * that no queen can attack the other queens.
	 */
	void printNQueenAllowedPlacements4(int n);

	/**
	 * Print knight(chess knight) tour such that it visits all points on the board
	 * without ever going to an already visited point.
	 */
	void printKnightTour(int n, int initRow, int initCol);

}
