package edu.sau.algo.recursion;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

	/**
	 * related to 0-1 max knapsack
	 * 
	 * 1. You are given a list of words, a allowed list of alphabets(might be
	 * repeating) along with its frequency and score of every alphabet from a to z.
	 * 
	 * 2. You have to find the maximum score of any valid set of words formed by
	 * using the given alphabets.
	 * 
	 * 3. A word can not be used more than one time.
	 * 
	 * 4. Each alphabet can be used only once.
	 * 
	 * 5. It is not necessary to use all the given alphabets.
	 * 
	 * 6. How many times a particular character can occur in the selected output is
	 * constrained. (allowedCharacterFrequency map)
	 * 
	 */
	int getMaxScoreFromCombination(List<String> input, Map<Character, Integer> allowedCharacterFrequency,
			Map<Character, Integer> characterScore);

	int josephusProblem(int n, int k);

	void printNumbersInLexicoGraphicOrderUptoN(int n);

	int getMaxGoldFromIslandsInGrid(int[][] grid);

	void solveCrossword(char[][] puzzle, List<String> words);

	/**
	 * 1. You are given three strings s1, s2 and s3.
	 * 
	 * 2. First two are supposed to add and form third. s1 + s2 = s3
	 * 
	 * 3. You have to map each individual character to a digit, so that the above
	 * equation holds true.
	 * 
	 * 4. Each character must be mapped with a number between 0 to 9. Each number
	 * can be used once only. For example - if 9 is mapped to 'a', then it cannot be
	 * mapped to any other letter. There will be one to one mapping.
	 * 
	 * Constraint: 1 <= length of s1,s2,s3 <= 10
	 * 
	 */
	void solveCryptArithmeticPuzzle(String s1, String s2, String s3);

	/**
	 * 1. You are given an integer n, which represents n friends numbered from 1 to
	 * n.
	 * 
	 * 2. Each one can remain single or can pair up with some other friend.
	 * 
	 * 3. You have to print all the configurations in which friends can remain
	 * single or can be paired up.
	 * 
	 * We cannot make 2 different permutations like 1-2 and 2-1. Only 1-2 is valid.
	 */
	void printFriendsPairing(int n);

	/**
	 * 1. You are given two integers n and k, where n represents number of elements
	 * and k represents number of subsets.
	 * 
	 * 2. You have to partition n elements in k subsets and print all such
	 * configurations.
	 */
	void kPartitionSubsets(int n, int k);

	void kPartitionSubsets1(int n, int k);

	/**
	 * 1. You are given a string of length n.
	 * 
	 * 2. You have to print all the palindromic permutations of the given string.
	 *
	 * 3. If no palindromic permutation exists for the given string, print "-1".
	 */
	void printPalindromicPermutations(String input);

	/**
	 * 1. You are given a string of length n.
	 * 
	 * 2. You have to partition the given string in such a way that every partition
	 * is a palindrome.
	 */
	void printPalindromicPartitions(String input);

	/**
	 * 1. You are given an array of n distinct integers.
	 * 
	 * 2. You have to divide these n integers into k non-empty subsets such that sum
	 * of integers of every subset is same.
	 * 
	 * 3. If it is not possible to divide, then print "-1".
	 */
	void printKPartitionEqualSumSubsets(int[] input, int k);

	/**
	 * 1. You are given a string and a pattern.
	 * 
	 * 2. You've to check if the string is of the same structure as pattern without
	 * using any regular expressions.
	 * 
	 * Example: input: mzaddytzaddy, pattern: abcb
	 * 
	 * Possible mappings:
	 * 
	 * 
	 */
	void printPatternMappingsForGivenString(String input, String pattern);

	/**
	 * 1. You are given n space separated strings, which represents a dictionary of
	 * words.
	 * 
	 * 2. You are given another string which represents a sentence.
	 * 
	 * 3. You have to print all possible sentences from the string, such that words
	 * of the sentence are present in dictionary.
	 */
	void printSentencesByApplyingWordBreaks1(String input, Set<String> words);

	void printSentencesByApplyingWordBreaks2(String input, Set<String> words);

	/**
	 * 1. You are given a string, which represents an expression having only opening
	 * and closing parenthesis.
	 * 
	 * 2. You have to remove minimum number of parenthesis to make the given
	 * expression valid.
	 * 
	 * 3. If there are multiple answers, you have to print all of them.
	 */
	void printExpressionByRemovingMinimumInvalidParenthesis(String input);

	/**
	 * 1. You are given a string which represents digits of a number.
	 * 
	 * 2. You have to create the maximum number by performing at-most k swap
	 * operations on its digits.
	 */
	void printLargestNumberPossibleAfterKSwaps(int num, int k);

	/**
	 * 1. You are given an array of n integers.
	 * 
	 * 2. You have to divide these n integers into 2 subsets such that the
	 * difference of sum of two subsets is as minimum as possible.
	 * 
	 * 3. If n is even, both set will contain exactly n/2 elements. If is odd, one
	 * set will contain (n-1)/2 and other set will contain (n+1)/2 elements.
	 * 
	 * 4. If it is not possible to divide, then print "-1".
	 */
	void tugOfWar(int[] numbers);

	/**
	 * 1. You are given a word (may have one character repeat more than once).
	 * 
	 * 2. You are given an integer k.
	 * 
	 * 3. You are required to generate and print all ways you can select k distinct
	 * characters out of the
	 */
	void printKDistinctSelection(String input, int k);

	/**
	 * 1. You are given a word (may have one character repeat more than once).
	 * 
	 * 2. You are given an integer k.
	 * 
	 * 3. You are required to generate and print all k length words by using
	 * distinct chars of the word.
	 */
	void printKDistinctArrangementWithoutCharRepetition(String input, int k);

	/**
	 * 1. You are given a word (may have one character repeat more than once).
	 * 
	 * 2. You are given an integer k.
	 * 
	 * 3. You are required to generate and print all k length words by using chars
	 * of the word.
	 */
	void printKDistinctArrangementWithCharRepetition(String input, int k);

	/**
	 * 1. You are given a number n, representing the count of coins.
	 * 
	 * 2. You are given n numbers, representing the denominations of n coins.
	 * 
	 * 3. You are given a number "amount".
	 * 
	 * 4. You are required to calculate and print the combinations of the n coins
	 * (non-duplicate) using which the amount "amount" can be paid.
	 * 
	 */
	void printCoinChangeCombinations1(int[] coins, int amount);

	/**
	 * 1. You are given a number n, representing the count of coins.
	 * 
	 * 2. You are given n numbers, representing the denominations of n coins.
	 * 
	 * 3. You are given a number "amount".
	 * 
	 * 4. You are required to calculate and print the combinations of the n coins
	 * (same coin can be used again any number of times) using which the amount
	 * "amount" can be paid.
	 */
	void printCoinChangeCombinations2(int[] coins, int amount);

}
