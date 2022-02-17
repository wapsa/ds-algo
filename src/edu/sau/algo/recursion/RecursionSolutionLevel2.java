package edu.sau.algo.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import edu.sau.algo.JosephusProblem;
import edu.sau.algo.permcomb.CombinationQuestion;
import edu.sau.algo.permcomb.PermutationQuestion;
import edu.sau.other.bitwise.BitwiseUtils;

public class RecursionSolutionLevel2 implements RecursionQuestionL2 {

	public static void main(String[] args) {
		// INSTANCE.printAbbreviations1("abc");
		// INSTANCE.printAbbreviations2("abc");

//		Map<Character, Integer> characterFreq = new HashMap<>(
//				Map.ofEntries(Map.entry('a', 2), Map.entry('b', 2), Map.entry('c', 2), Map.entry('z', 1)));
//		Map<Character, Integer> characterScore = Map.ofEntries(Map.entry('a', 1), Map.entry('b', 2), Map.entry('c', 3),
//				Map.entry('z', 26));
//		System.out.println(
//				INSTANCE.getMaxScoreFromCombination(List.of("abb", "aaz", "acc"), characterFreq, characterScore));

		// INSTANCE.printNumbersInLexicoGraphicOrderUptoN(100);

		int[][] grid = { //
				{ 1, 0, 0, 0, 1, 1, 1, 0 }, //
				{ 1, 0, 0, 0, 0, 1, 0, 0 }, //
				{ 1, 0, 0, 0, 1, 1, 1, 0 }, //
				{ 1, 0, 0, 0, 1, 0, 1, 0 }, //
				{ 0, 0, 0, 0, 1, 0, 1, 0 }, //
				{ 0, 1, 0, 0, 1, 1, 1, 0 }, //
				{ 0, 1, 0, 0, 0, 1, 0, 0 }, //
				{ 0, 0, 0, 0, 1, 1, 1, 0 } //
		};//
			// System.out.println(INSTANCE.getMaxGoldFromIslandsInGrid(grid));

		// INSTANCE.solveCryptArithmeticPuzzle("send", "more", "money");

		// INSTANCE.printFriendsPairing(3);

		// INSTANCE.kPartitionSubsets(4, 3);
		// System.out.println("---------");
		// INSTANCE.kPartitionSubsets1(4, 3);

		// INSTANCE.printPalindromicPartitions("abccba");

		// INSTANCE.printKPartitionEqualSumSubsets(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9
		// }, 3);

		// INSTANCE.printPatternMappingsForGivenString("mzaddytzaddy", "abcb");

//		INSTANCE.printSentencesByApplyingWordBreaks1("ilikepeppereatingmangoinpepcoding",
//				Set.of("i", "like", "pep", "coding", "pepper", "eating", "mango", "man", "go", "in", "pepcoding"));
//		System.out.println("---------");
//		INSTANCE.printSentencesByApplyingWordBreaks1("ilikepeppereatingmangoinpepcoding",
//				Set.of("i", "like", "pep", "coding", "pepper", "eating", "mango", "man", "go", "in", "pepcoding"));

		// INSTANCE.printExpressionByRemovingMinimumInvalidParenthesis("()())()");

		// INSTANCE.printLargestNumberPossibleAfterKSwaps(38164, 2);

		// INSTANCE.tugOfWar(new int[] { 1, 2, 3, 4, 5, 6 });

		// INSTANCE.printKDistinctSelection("aabbbccdde", 3);

		// INSTANCE.printCoinChangeCombinations1(new int[] { 1, 2, 3, 4, 5, 6 }, 10);

		INSTANCE.printCoinChangeCombinations2(new int[] { 1, 2, 3 }, 5);

	}

	@Override
	public void printAbbreviations1(String input) {
		char[] output = new char[input.length()];
		Arrays.fill(output, '_');
		printAbbreviationsUsingPascalIdentityExpansion1(input.toCharArray(), 0, output);
	}

	/**
	 * 
	 * STEP1 :Need to create powerset with emptyplaceholder ''.
	 *
	 * STEP2: While printing we need to count the empty_placeholder.
	 */
	private void printAbbreviationsUsingPascalIdentityExpansion1(char[] input, int posToFix, char[] output) {
		String print = "";
		int emptyCounter = 0;
		for (char ch : output) {
			if (ch == '_') {
				emptyCounter++;
			} else {
				print = emptyCounter == 0 ? print + ch : print + emptyCounter + ch;
				emptyCounter = 0;
			}
		}
		print = emptyCounter == 0 ? print : print + emptyCounter;
		System.out.println(print);

		while (posToFix < input.length) {
			int currentPos = posToFix;
			output[currentPos] = input[currentPos];
			posToFix = posToFix + 1;
			printAbbreviationsUsingPascalIdentityExpansion1(input, posToFix, output);
			output[currentPos] = '_';
		}
	}

	@Override
	public void printAbbreviations2(String input) {
		printAbbreviationsUsingPascalIdentityExpansion2(input.toCharArray(), 0, "");
	}

	private void printAbbreviationsUsingPascalIdentityExpansion2(char[] input, int posToFix, String output) {
		// adding end_empty_count to print string.
		System.out.println((input.length - posToFix) == 0 ? output : output + (input.length - posToFix));

		int currentPosToFix = posToFix;
		while (posToFix < input.length) {
			// we are adding before_empty_count to output for next level.
			String newOutput = output;
			if (posToFix - currentPosToFix != 0)
				newOutput = newOutput + (posToFix - currentPosToFix);
			newOutput = newOutput + input[posToFix];

			posToFix = posToFix + 1;
			printAbbreviationsUsingPascalIdentityExpansion2(input, posToFix, newOutput);
		}
	}

	@Override
	public int getMaxScoreFromCombination(List<String> input, Map<Character, Integer> allowedCharacterFrequency,
			Map<Character, Integer> characterScore) {
		return getMaxScoreFromCombination(input, allowedCharacterFrequency, characterScore, 0, new ArrayList<>());
		// return getMaxScoreFromCombination1(input, allowedCharacterFrequency,
		// characterScore, 0, new HashMap<>());
	}

	private int getMaxScoreFromCombination(List<String> input, Map<Character, Integer> allowedCharacterFrequency,
			Map<Character, Integer> characterScore, int posToFix, List<String> output) {

		int outputScore = calculateComboScore(output, characterScore);
		System.out.println(output + ": " + outputScore);
		while (posToFix < input.size()) {
			String inputStr = input.get(posToFix);
			posToFix = posToFix + 1;
			if (isValidInsertForCombo(inputStr, output, new HashMap<>(allowedCharacterFrequency))) {
				output.add(inputStr);

				outputScore = Math.max(outputScore, getMaxScoreFromCombination(input, allowedCharacterFrequency,
						characterScore, posToFix, new ArrayList<>(output)));

				// backtrack
				output.remove(inputStr);
			}
		}
		return outputScore;
	}

	private boolean isValidInsertForCombo(String input, List<String> combo,
			Map<Character, Integer> allowedCharacterFrequency) {
		for (String str : combo) {
			for (char ch : str.toCharArray()) {
				if (allowedCharacterFrequency.get(ch) == 0)
					return false;
				allowedCharacterFrequency.put(ch, allowedCharacterFrequency.get(ch) - 1);
			}
		}
		for (char ch : input.toCharArray()) {
			if (allowedCharacterFrequency.get(ch) == 0)
				return false;
			allowedCharacterFrequency.put(ch, allowedCharacterFrequency.get(ch) - 1);
		}
		return true;

	}

	private int calculateComboScore(List<String> output, Map<Character, Integer> characterScore) {
		int score = 0;
		for (String str : output) {
			for (char ch : str.toCharArray()) {
				score = score + characterScore.get(ch);
			}
		}
		return score;
	}

	private int getMaxScoreFromCombination1(List<String> input, Map<Character, Integer> allowedCharacterFrequency,
			Map<Character, Integer> characterScore, int posToFix, Map<String, Integer> output) {

		int outputScore = output.values().stream().reduce(0, Integer::sum);
		System.out.println(output + ": " + outputScore);
		while (posToFix < input.size()) {
			String inputStr = input.get(posToFix);
			posToFix = posToFix + 1;

			int backtrackIdx = isValidInsertForCombo1(inputStr, allowedCharacterFrequency);
			if (backtrackIdx == inputStr.length()) {
				output.put(inputStr, calculateComboScore1(inputStr, characterScore));
				outputScore = Math.max(outputScore, getMaxScoreFromCombination1(input, allowedCharacterFrequency,
						characterScore, posToFix, output));
				// backtrack the output
				output.remove(inputStr);
			}
			// backtrack the allowedCharacterFrequency map
			backtrackCharacterFreqMap(inputStr, backtrackIdx, allowedCharacterFrequency);
		}
		return outputScore;
	}

	private int isValidInsertForCombo1(String inputStr, Map<Character, Integer> allowedCharacterFrequency) {
		for (int i = 0; i < inputStr.length(); i++) {
			char ch = inputStr.charAt(i);

			if (allowedCharacterFrequency.get(ch) == 0)
				return i;

			allowedCharacterFrequency.put(ch, allowedCharacterFrequency.get(ch) - 1);
		}
		return inputStr.length();
	}

	private void backtrackCharacterFreqMap(String inputStr, int backtrackIdx,
			Map<Character, Integer> allowedCharacterFrequency) {
		for (int i = 0; i < backtrackIdx; i++) {
			char ch = inputStr.charAt(i);
			allowedCharacterFrequency.put(ch, allowedCharacterFrequency.get(ch) + 1);
		}
	}

	private int calculateComboScore1(String str, Map<Character, Integer> characterScore) {
		int score = 0;
		for (char ch : str.toCharArray()) {
			score = score + characterScore.get(ch);
		}
		return score;
	}

	@Override
	public int josephusProblem(int n, int k) {
		return JosephusProblem.recursiveJosephus(n, k);
	}

	@Override
	public void printNumbersInLexicoGraphicOrderUptoN(int n) {
		for (int i = 1; i <= 9; i++)
			printNumbersInDFS(i, n);
	}

	private void printNumbersInDFS(int num, int max) {
		if (num > max)
			return;
		System.out.println(num);
		for (int i = 0; i < 10; i++)
			printNumbersInDFS(10 * num + i, max);
	}

	@Override
	public int getMaxGoldFromIslandsInGrid(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int gold = 0;

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (visited[row][col] == false) {
					gold = Math.max(gold, countGoldOnIsland(grid, visited, row, col));
				}
			}
		}
		return gold;
	}

	/**
	 * moves order : l,r,t,d
	 * 
	 * How does Backtracking happens for exploreConnectedComponents ?
	 * 
	 * When all the options are exhausted for a given cell then the recursion falls
	 * back to the cell which has invoked it.
	 * 
	 */
	private int countGoldOnIsland(int[][] grid, boolean[][] visited, int row, int col) {
		if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || visited[row][col] == true
				|| grid[row][col] == 0)
			return 0;

		visited[row][col] = true;
		int gold = grid[row][col];

		// left move
		gold += countGoldOnIsland(grid, visited, row, col - 1);
		// right move
		gold += countGoldOnIsland(grid, visited, row, col + 1);
		// up move
		gold += countGoldOnIsland(grid, visited, row - 1, col);
		// down move
		gold += countGoldOnIsland(grid, visited, row + 1, col);

		return gold;
	}

	@Override
	public void solveCrossword(char[][] puzzle, List<String> words) {
		Crossword.FIXING_INPUT.solve(puzzle, words);
	}

	@Override
	public void solveCryptArithmeticPuzzle(String s1, String s2, String s3) {
		List<Integer> digitOptions = new ArrayList<Integer>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		Map<Character, Integer> charDigitMap = new TreeMap<>();

		for (char ch : s1.toLowerCase().toCharArray())
			charDigitMap.put(ch, -1);

		for (char ch : s2.toLowerCase().toCharArray())
			charDigitMap.put(ch, -1);

		for (char ch : s3.toLowerCase().toCharArray())
			charDigitMap.put(ch, -1);

		char[] uniqueChars = charDigitMap.keySet().stream().map(String::valueOf).collect(Collectors.joining())
				.toCharArray();
		solveCryptArithmeticPuzzleByFixingInputAndDigitAsOption(s1, s2, s3, uniqueChars, 0, charDigitMap, digitOptions);
	}

	private void solveCryptArithmeticPuzzleByFixingInputAndDigitAsOption(String s1, String s2, String s3,
			char[] uniqueChars, int idx, Map<Character, Integer> charDigitMap, List<Integer> digitOptions) {

		if (idx == uniqueChars.length) {
			int s1Num = stringToNumber(s1, charDigitMap);
			int s2Num = stringToNumber(s2, charDigitMap);
			int s3Num = stringToNumber(s3, charDigitMap);
			if (s1Num + s2Num == s3Num) {
				System.out.println(charDigitMap);
			}
			return;
		}
		for (int i = 0; i < digitOptions.size(); i++) {

			Integer option = digitOptions.get(i);

			charDigitMap.put(uniqueChars[idx], option);
			digitOptions.remove(i);

			solveCryptArithmeticPuzzleByFixingInputAndDigitAsOption(s1, s2, s3, uniqueChars, idx + 1, charDigitMap,
					digitOptions);

			// backtrack
			digitOptions.add(i, option);
			charDigitMap.put(uniqueChars[idx], -1);
		}
	}

	private int stringToNumber(String s1, Map<Character, Integer> charDigitMap) {
		int value = 0;
		int multiplier = 1;
		for (int i = s1.length() - 1; i >= 0; i--) {
			value += multiplier * charDigitMap.get(s1.charAt(i));
			multiplier = multiplier * 10;
		}
		return value;
	}

	@Override
	public void printFriendsPairing(int n) {
		printFriendsPairing(IntStream.range(1, n + 1).boxed().collect(Collectors.toList()), new ArrayList<>());
	}

	/**
	 * <pre>
	 * Note : we are need to generate the combination not permutation
	 * 
	 * Recursion Strategy: Here input is fixed and also taken as options.
	 * 
	 * 1. 1st input is taken out and considered to be fixed at level. By fixing the 1st input
	 *    means at next level(recursion invocation) we will pass remaining input.
	 * 
	 * 2. We are creating options of remaing input using the 1st input.
	 *     OPTION : pairing up 1st input with remaining inputs.
	 *     SPECIAL_OPTION : first input is getting paired up with empty.
	 * 
	 * </pre>
	 */
	private void printFriendsPairing(List<Integer> friends, List<String> output) {
		if (friends.isEmpty()) {
			System.out.println(output);
			return;
		}
		int frndA = friends.remove(0);
		output.add(String.valueOf(frndA));
		printFriendsPairing(friends, output);
		output.remove(output.size() - 1);

		for (int i = 0; i < friends.size(); i++) {
			int frndB = friends.remove(i);
			String pair = frndA + "" + frndB;
			output.add(pair);
			printFriendsPairing(friends, output);
			output.remove(output.size() - 1);
			friends.add(i, frndB);
		}
		friends.add(0, frndA);
	}

	@Override
	public void kPartitionSubsets(int n, int k) {
		printKPartitionSubsetsUsingPIE(n, k, prepareListOfSubsetsUptoSizeK(n, k), 0, "", 0);
	}

	private void printKPartitionSubsetsUsingPIE(int n, int k, List<String> input, int inputIdx, String output,
			int outputCharCount) {
		if (k == 0) {
			if (outputCharCount == n)
				System.out.println(output);
			return;
		}
		while (inputIdx < input.size()) {
			String currInput = input.get(inputIdx);
			inputIdx = inputIdx + 1;
			if (!isAlreadyPresentInOutput(currInput, output))
				printKPartitionSubsetsUsingPIE(n, k - 1, input, inputIdx, output + currInput + "|",
						outputCharCount + currInput.length());
		}
	}

	private boolean isAlreadyPresentInOutput(String input, String output) {
		for (char ch : input.toCharArray())
			if (output.indexOf(ch) != -1)
				return true;
		return false;
	}

	private List<String> prepareListOfSubsetsUptoSizeK(int n, int k) {
		List<String> accumulator = new ArrayList<>();
		createPowerSetUsingPIE(n, k, "", accumulator, 1);
		return accumulator;
	}

	private void createPowerSetUsingPIE(int n, int k, String currOutput, List<String> accumulator, int posToFix) {
		if (!currOutput.isEmpty() && currOutput.length() <= k)
			accumulator.add(currOutput);

		while (posToFix <= n)
			createPowerSetUsingPIE(n, k, currOutput + posToFix, accumulator, ++posToFix);

	}

	@Override
	public void kPartitionSubsets1(int n, int k) {
		String[] output = new String[k];
		Arrays.fill(output, "_");
		printKPartitionSubsetsByFixingInput(n, output);
	}

	/**
	 * <pre>
	 * RECURSION STRATEGY: 
	 * 1. Input is getting fixed at each level of tree.
	 * 2. Partitions are tried as option at each level.
	 * 
	 * Note: While fixing a given_input we should treat all the empty partitions 
	 * as same partition to avoid the permutation generation. So we should not
	 * spawn new branch for each empty partition rather just spawn single branch 
	 * against first empty partition.
	 * 
	 * If we wish to generate the permutations then we should spawn separate branch for 
	 * each empty space.
	 * 
	 * &#64;see KPartitionSubsetsByFixingInput.pdf
	 * </pre>
	 * 
	 */
	private void printKPartitionSubsetsByFixingInput(int inputToFix, String[] output) {
		if (inputToFix == 0) {
			for (String str : output)
				if (str.equals("_"))
					return;
			System.out.println(Arrays.toString(output));
			return;
		}
		for (int i = 0; i < output.length; i++) {
			if (output[i].equals("_")) {
				output[i] = "" + inputToFix;
				printKPartitionSubsetsByFixingInput(inputToFix - 1, output);
				output[i] = "_";
				break;
			} else {
				String prevOutput = output[i];
				output[i] = output[i] + inputToFix;
				printKPartitionSubsetsByFixingInput(inputToFix - 1, output);
				output[i] = prevOutput;
			}
		}
	}

	@Override
	public void printPalindromicPermutations(String input) {
		PermutationQuestion.INSTANCE.printPalindromicPermutations(input);
	}

	@Override
	public void printPalindromicPartitions(String input) {
		printPalindromicPartitions(input, "");
	}

	/**
	 * <pre>
	 * 
	 * RECURSION_STRATEGY:
	 * 
	 * 1. input_palindromic_prefix is getting fixed at each level of tree
	 *      --> so BASE CASE : the tree level where input_palindromic_prefix get exhausted.
	 *
	 * 2.input_palindromic_prefix is tried as option at each level of tree
	 * 
	 * </pre>
	 * 
	 */
	private void printPalindromicPartitions(String input, String output) {
		if (input.isEmpty()) {
			System.out.println(output);
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			String prefix = input.substring(0, i + 1);
			if (isPalindrome(prefix))
				printPalindromicPartitions(input.substring(i + 1), output + "[" + prefix + "]");
		}
	}

	private static boolean isPalindrome(String str) {
		int endIndex = str.length() - 1;
		for (int i = 0; i <= BitwiseUtils.divideBy2(endIndex - 1); i++)
			if (str.charAt(i) != str.charAt(endIndex - i))
				return false;
		return true;
	}

	@Override
	public void printKPartitionEqualSumSubsets(int[] input, int k) {
		if (k >= input.length)
			return;

		int totalSum = IntStream.of(input).sum();
		if (totalSum % k != 0)
			return;

		String[] output = new String[k];
		Arrays.fill(output, "_");
		printKPartitionEqualSumSubsets(input, 0, output, new int[k], totalSum / k);

	}

	private void printKPartitionEqualSumSubsets(int[] input, int inputIdx, String[] output,
			int[] partitionSumAccumulator, int partitionSum) {
		if (inputIdx == input.length) {
			for (String str : output)
				if (str.equals("_"))
					return;
			System.out.println(Arrays.toString(output));
			return;
		}
		for (int i = 0; i < output.length; i++) {
			if (output[i].equals("_")) {
				output[i] = "" + input[inputIdx];
				partitionSumAccumulator[i] = input[inputIdx];
				printKPartitionEqualSumSubsets(input, inputIdx + 1, output, partitionSumAccumulator, partitionSum);
				partitionSumAccumulator[i] = 0;
				output[i] = "_";
				break;
			} else if (partitionSumAccumulator[i] + input[inputIdx] <= partitionSum) {
				String prevOutput = output[i];
				output[i] = output[i] + input[inputIdx];
				partitionSumAccumulator[i] = partitionSumAccumulator[i] + input[inputIdx];
				printKPartitionEqualSumSubsets(input, inputIdx + 1, output, partitionSumAccumulator, partitionSum);
				partitionSumAccumulator[i] = partitionSumAccumulator[i] - input[inputIdx];
				output[i] = prevOutput;
			}
		}

	}

	@Override
	public void printPatternMappingsForGivenString(String input, String pattern) {
		printPatternMappingsForGivenString(input, pattern.toCharArray(), 0, new HashMap<>());
	}

	private void printPatternMappingsForGivenString(String input, char[] pattern, int patternIdxToFix,
			Map<Character, String> patternMap) {

		if (patternIdxToFix == pattern.length) {
			if (input.isEmpty())
				System.out.println(patternMap);
			return;
		}

		char charToFix = pattern[patternIdxToFix];
		if (patternMap.containsKey(charToFix)) {
			String alreadyMappedString = patternMap.get(charToFix);
			if (input.startsWith(alreadyMappedString)) {
				String remainingInput = input.substring(alreadyMappedString.length());
				printPatternMappingsForGivenString(remainingInput, pattern, patternIdxToFix + 1, patternMap);
			}
		} else {
			for (int i = 0; i < input.length(); i++) {
				String currInput = input.substring(0, i + 1);
				String remainingInput = input.substring(i + 1);
				patternMap.put(charToFix, currInput);
				printPatternMappingsForGivenString(remainingInput, pattern, patternIdxToFix + 1, patternMap);
				patternMap.remove(charToFix);
			}
		}
	}

	@Override
	public void printSentencesByApplyingWordBreaks1(String input, Set<String> words) {
		printSentencesByApplyingWordBreaks1(input, words, "");
	}

	private void printSentencesByApplyingWordBreaks1(String input, Set<String> words, String output) {
		if (input.isEmpty()) {
			System.out.println(output);
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			String currInput = input.substring(0, i + 1);
			if (words.contains(currInput)) {
				String remainingInput = input.substring(i + 1);
				printSentencesByApplyingWordBreaks1(remainingInput, words, output + currInput + " ");
			}
		}
	}

	@Override
	public void printSentencesByApplyingWordBreaks2(String input, Set<String> words) {
		Map<Character, Set<String>> wordsMap = new HashMap<>();
		for (String word : words) {
			char startCh = word.charAt(0);
			if (wordsMap.containsKey(startCh))
				wordsMap.get(startCh).add(word);
			else
				wordsMap.put(startCh, new HashSet<>(Set.of(word)));
		}
		printSentencesByApplyingWordBreaks2(input, wordsMap, "");
	}

	private void printSentencesByApplyingWordBreaks2(String input, Map<Character, Set<String>> wordsMap,
			String output) {
		if (input.isEmpty()) {
			System.out.println(output);
			return;
		}
		char charToFix = input.charAt(0);
		if (wordsMap.containsKey(charToFix)) {
			for (String word : wordsMap.get(charToFix))
				if (input.startsWith(word))
					printSentencesByApplyingWordBreaks2(input.substring(word.length()), wordsMap, output + word + " ");
		}
	}

	@Override
	public void printExpressionByRemovingMinimumInvalidParenthesis(String input) {
		printExpressionByRemovingMinimumInvalidParenthesis(input, getMinimumInvalidParenthesis(input), 0,
				new HashSet<>());
	}

	private void printExpressionByRemovingMinimumInvalidParenthesis(String input, char[] invalidParenthesis,
			int invalidParenthesisIdx, Set<String> duplicateCache) {
		if (invalidParenthesisIdx == invalidParenthesis.length) {
			if (!duplicateCache.contains(input) && isValidExpression(input)) {
				System.out.println(input);
				duplicateCache.add(input);
			}
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			char currentParenthesis = input.charAt(i);
			if (currentParenthesis == invalidParenthesis[invalidParenthesisIdx]) {
				String remainingInput = input.substring(0, i) + input.substring(i + 1);
				printExpressionByRemovingMinimumInvalidParenthesis(remainingInput, invalidParenthesis,
						invalidParenthesisIdx + 1, duplicateCache);
			}
		}
	}

	private char[] getMinimumInvalidParenthesis(String expression) {
		Deque<Character> stack = new ArrayDeque<>();
		for (char ch : expression.toCharArray()) {
			if (ch == '(' || stack.isEmpty())
				stack.push(ch);
			else if (ch == ')')
				if (stack.peek() == '(')
					stack.pop();
				else
					stack.push(ch);
		}
		return stack.stream().map(String::valueOf).collect(Collectors.joining()).toCharArray();
	}

	private boolean isValidExpression(String input) {
		return getMinimumInvalidParenthesis(input).length == 0;
	}

	@Override
	public void printLargestNumberPossibleAfterKSwaps(int num, int k) {
		int[] maxHolder = new int[] { num };
		printLargestNumberPossibleAfterKSwaps(String.valueOf(num), k, maxHolder);
		System.out.println(maxHolder[0]);
	}

	private void printLargestNumberPossibleAfterKSwaps(String num, int k, int[] max) {
		if (Integer.valueOf(num) > max[0])
			max[0] = Integer.valueOf(num);
		if (k == 0)
			return;
		for (int i = 0; i < num.length() - 1; i++)
			for (int j = i + 1; j < num.length(); j++)
				if (num.charAt(i) < num.charAt(j))
					printLargestNumberPossibleAfterKSwaps(swap(num.toCharArray(), i, j), k - 1, max);
	}

	private String swap(char[] num, int i, int j) {
		char temp = num[i];
		num[i] = num[j];
		num[j] = temp;
		return String.valueOf(num);
	}

	@Override
	public void tugOfWar(int[] numbers) {
		String input = "";
		for (int num : numbers) {
			input = input.concat("" + num);
		}
		String[] output = new String[1];
		tugOfWar(numbers, 0, new ArrayList<>(), new ArrayList<>(), new int[] { Integer.MAX_VALUE }, output);
		System.out.println(output[0]);
	}

	private void tugOfWar(int[] numbers, int index, List<Integer> s1, List<Integer> s2, int[] minDiff,
			String[] output) {
		if (index == numbers.length) {
			int diff = Math.abs(s1.stream().reduce(0, Integer::sum) - s2.stream().reduce(0, Integer::sum));
			if (diff < minDiff[0]) {
				minDiff[0] = diff;
				output[0] = s1 + " |||| " + s2;
			}
			return;
		}
		int numToFix = numbers[index];

		if (s1.size() < (numbers.length + 1) / 2) {
			s1.add(numToFix);
			tugOfWar(numbers, index + 1, s1, s2, minDiff, output);
			s1.remove(s1.size() - 1);
		}
		if (s2.size() < (numbers.length + 1) / 2) {
			s2.add(numToFix);
			tugOfWar(numbers, index + 1, s1, s2, minDiff, output);
			s2.remove(s2.size() - 1);
		}
	}

	@Override
	public void printKDistinctSelection(String input, int k) {
		CombinationQuestion.INSTANCE.printCombinationByUsingPIEAndHandlingDuplicates(input, k);
	}

	@Override
	public void printKDistinctArrangementWithoutCharRepetition(String input, int k) {
		String distinctChars = input.chars().distinct().mapToObj(c -> String.valueOf((char) c))
				.collect(Collectors.joining());
		PermutationQuestion.INSTANCE.printPermutationOfItemInArrayByFixingPos(k, distinctChars);
	}

	@Override
	public void printKDistinctArrangementWithCharRepetition(String input, int k) {
		PermutationQuestion.INSTANCE.printPermutationOfItemInArrayByHandlingDuplicatesAndFixingPos(k, input);
	}

	@Override
	public void printCoinChangeCombinations1(int[] coins, int amount) {
		printCoinChangeCombinationsUsingPIE1(coins, 0, amount, "", 0);
	}

	private void printCoinChangeCombinationsUsingPIE1(int[] coins, int posToFix, int amount, String output,
			int coinSum) {
		if (coinSum > amount)
			return;
		else if (coinSum == amount) {
			System.out.println(output);
			return;
		}
		while (posToFix < coins.length) {
			int currCoin = coins[posToFix];
			posToFix = posToFix + 1;
			printCoinChangeCombinationsUsingPIE1(coins, posToFix, amount, output + currCoin + ", ", coinSum + currCoin);
		}

	}

	@Override
	public void printCoinChangeCombinations2(int[] coins, int amount) {
		// printCoinChangeCombinationsUsingPIE2(coins, 0, amount, "", 0);

		printCoinChangeCombinationsUsingIncludeExclude2(coins, 0, amount, "", 0);
	}

	private void printCoinChangeCombinationsUsingPIE2(int[] coins, int coinIdx, int amount, String output,
			int sumTillNow) {
		if (sumTillNow > amount)
			return;
		else if (sumTillNow == amount) {
			System.out.println(output);
			return;
		}
		for (int i = coinIdx; i < coins.length; i++) {
			int currCoin = coins[i];
			printCoinChangeCombinationsUsingPIE2(coins, i, amount, output + currCoin + ",", sumTillNow + currCoin);
		}
	}

	private void printCoinChangeCombinationsUsingIncludeExclude2(int[] coins, int posToFix, int amount, String output,
			int sumTillNow) {
		if (sumTillNow == amount) {
			System.out.println(output);
			return;
		} else if (posToFix == coins.length || sumTillNow > amount)
			return;

		// Exclude, exclude will have to remain here because in include we are changing
		// sumTillNow and output
		printCoinChangeCombinationsUsingIncludeExclude2(coins, posToFix + 1, amount, output, sumTillNow);

		// Include
		while (sumTillNow <= amount) {
			output = output + coins[posToFix] + ",";
			sumTillNow = sumTillNow + coins[posToFix];
			printCoinChangeCombinationsUsingIncludeExclude2(coins, posToFix + 1, amount, output, sumTillNow);
		}

	}

}
