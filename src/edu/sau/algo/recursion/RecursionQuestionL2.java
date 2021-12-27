package edu.sau.algo.recursion;

public interface RecursionQuestionL2 {

	public static final RecursionQuestionL2 INSTANCE = new RecursionSolutionLevel2();

	/**
	 * Print power-set by placing 1 for characters which are absent. If 1 appears in
	 * consecutive order then need to be summed up.
	 * 
	 * Sample Input: abc
	 * 
	 * 000, 001, 010, 011, 100, 101, 110, 111
	 * 
	 * abc, ab_, a_c, a__, _bc, _b_, __c, ___
	 * 
	 * Sample Output: abc, ab1, a1c, a2, 1bc, 1b1, 2c, 3
	 */
	void printAbbreviations1(String input);
	
	void printAbbreviations2(String input);

}
