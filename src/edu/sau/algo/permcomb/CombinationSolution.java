package edu.sau.algo.permcomb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombinationSolution implements CombinationQuestion {

	public static void main(String[] args) {
		// System.out.println(INSTANCE.getGroupCombination(new String[] { "abc", "def",
		// "ghi" }));

		// INSTANCE.printGroupCombination(new String[] { "abc", "def", "ghi" });

		// INSTANCE.printTargetSumCombination(new int[] { 1, 2, 3, 4, 5 }, 10);

		// INSTANCE.printCombinationUsingIncludeExcludeByFixingPosition(4, 3);

		// INSTANCE.printCombinationUsingPermutationByFixingInput(4, "ab");

		// INSTANCE.printCombinationUsingPascalIdentityExpansionByFixingPosition(4, 2);

		// INSTANCE.printCombinationUsingPermutationByFixingPos(4, 2);

		// INSTANCE.printCombinationOfItemIn2dArrayUsingPascalIdentityExpansionByFixingPos(3,
		// 2, 4);

		// INSTANCE.printCombinationOfItemIn2dArrayByElongatingAndFixingPos(3, 2, 4);

		// INSTANCE.printNQueenCombinationsUsingPascalIdentityExpansionByFixingPos(4);

		INSTANCE.printCombinationByUsingPIEAndHandlingDuplicates("aabbbccdde", 3);
	}

	@Override
	public List<String> getGroupCombination(String[] groups) {
		return getGroupCombination(groups, 0);
	}

	/**
	 * <pre>
	 * Get all possible combinations that can be formed by picking atmost one char
	 * from each group.
	 * 
	 * Example ['abc' 'fg', 'hijk']; a single combination contains 3 char one from
	 * each group. e.g. afh, afi
	 * 
	 * Total number of combinations : It is repersented by cartesian product of each
	 * group.
	 * 
	 * Total number of combinations : g1 * g2 * g3 * .. *gn; g represents element
	 * count in the respective group.
	 * 
	 * Example ['abc' 'fg', 'hijk'] : total combinations : 3 * 2 * 4 = 24
	 * 
	 * Tree Structure:
	 * 
	 * At 0th level we will have 3 branches a, b, c
	 * At 1st level, each branch will spawn 2 branches f, g
	 * At 2nd level each branch will spawn 4 branches h, i, j, k
	 * 
	 *
	 * HYPOTHESIS : getGroupCombination([g1, g2, g3]) => total  g1g2g3 combinations
	 * 
	 * SUBSTITUTION: collate the group g2, g3; getGroupCombination([g2, g3]) => total  g2*g3 combinations
	 * 
	 * INDUCTION strategy: need to map each element of g1 group, with each element returned
	 * by SUBSTITUTION step.  Means solution is prepared in  post-recursion step.
	 * 
	 * </pre>
	 * 
	 * TimeComplexity : O(g1g2g3..gn)
	 * 
	 */
	private List<String> getGroupCombination(String[] groups, int idx) {
		if (idx == groups.length)
			return List.of("");

		List<String> combinations = getGroupCombination(groups, idx + 1);
		List<String> result = new ArrayList<>();

		char[] chars = groups[idx].toCharArray();
		for (char ch : chars) {
			for (String s : combinations) {
				result.add(ch + s);
			}
		}
		return result;
	}

	@Override
	public void printGroupCombination(String[] groups) {
		printGroupCombination(groups, 0, "");
	}

	/**
	 * <pre>
	 * Example ['abc' 'fg', 'hijk'] : total combinations : 3 * 2 * 4 = 24
	 * 
	 * Tree Structure:
	 * At 0th level we will have 3 branches a, b, c
	 * At 1st level, each branch will spawn 2 branches f, g
	 * At 2nd level each branch will spawn 4 branches h, i, j, k
	 *
	 * Strategy: We will maintain two variables:
	 * 1. solution_so_far : at every level we will append the options to solution_so_far
	 * 2.  idx : tree level will be maintained by index of groups array.
	 * 
	 * HYPOTHESIS: printGroupCombination(['abc' 'fg'],  "") --> prints all the possible combinations
	 * 
	 * SUBSTITUTION: 
	 * printGroupCombination(['abc', 'fg', 'hijk'],  "a") : appends remaining path to "a"
	 * printGroupCombination(['abc', 'fg', 'hijk'],  "b") : appends remaining path to "b"
	 * printGroupCombination(['abc', 'fg', 'hijk'],  "c") : appends remaining path to "b"
	 * 
	 * INDUCTION: main code will append options of first_group i.e. 'abc' to solution_so_far, 
	 * and remaining path will be append by substitution step. Means solution is prepared in 
	 * pre-recursion step.
	 * 
	 * </pre>
	 * 
	 */
	private void printGroupCombination(String[] groups, int idx, String ans) {
		if (idx == groups.length) {
			System.out.println(ans);
			return;
		}
		char[] chars = groups[idx].toCharArray();

		for (char ch : chars)
			printGroupCombination(groups, idx + 1, ans + ch);
	}

	@Override
	public void printTargetSumCombination(int[] input, int targetVal) {
		// printTargetSumCombinationUsingPascalIdentityExpansion(
		// Arrays.stream(input).mapToObj(String::valueOf).collect(Collectors.joining()),
		// targetVal, "", 0);

		printTargetSumCombinationUsingPascalIdentityExpansion1(input, 0, targetVal, "", 0);
	}

	private void printTargetSumCombinationUsingPascalIdentityExpansion(String input, int targetVal, String combination,
			int sumSoFarOfCombination) {
		if (sumSoFarOfCombination == targetVal)
			System.out.println(combination);

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			printTargetSumCombinationUsingPascalIdentityExpansion(input.substring(i + 1), targetVal, combination + ch,
					sumSoFarOfCombination + (ch - '0'));
		}
	}

	private void printTargetSumCombinationUsingPascalIdentityExpansion1(int[] input, int idx, int targetVal,
			String combination, int sumSoFarOfCombination) {
		if (sumSoFarOfCombination == targetVal)
			System.out.println(combination);

		while (idx < input.length) {
			int cur = input[idx];
			idx = idx + 1;
			printTargetSumCombinationUsingPascalIdentityExpansion1(input, idx, targetVal, combination + cur,
					sumSoFarOfCombination + cur);
		}
	}

	@Override
	public void printCombinationUsingPascalIdentityByFixingPos(int positionCount, int r) {
		printCombinationUsingIncludeExcludeByFixingPosition(positionCount, r, 0, "");

	}

	private void printCombinationUsingIncludeExcludeByFixingPosition(int positionCount, int r, int posToFix,
			String output) {
		if (posToFix == positionCount) {
			if (r == 0)
				System.out.println(output);
			return;
		}
		// Exclude
		printCombinationUsingIncludeExcludeByFixingPosition(positionCount, r, posToFix + 1, output + "_");
		// Include
		printCombinationUsingIncludeExcludeByFixingPosition(positionCount, r - 1, posToFix + 1, output + "i");
	}

	@Override
	public void printCombinationUsingPascalIdentityExpansionByFixingPos(int positionCount, int r) {
		char[] output = new char[positionCount];
		Arrays.fill(output, '_');
		printCombinationUsingPascalIdentityExpansionByFixingPosition(output, r, 0);
	}

	private void printCombinationUsingPascalIdentityExpansionByFixingPosition(char[] output, int r, int posToFix) {
		if (r == 0)
			System.out.println(String.valueOf(output));
		while (posToFix < output.length) {
			int currentPos = posToFix;
			output[currentPos] = 'i';
			printCombinationUsingPascalIdentityExpansionByFixingPosition(output, r - 1, ++posToFix);
			output[currentPos] = '_';
		}
	}

	@Override
	public void printCombinationUsingPermutationByFixingInput(int positionCount, String input) {
		char[] output = new char[positionCount];
		Arrays.fill(output, '_');
		printCombinationUsingPermutationByFixingInput(input.toCharArray(), 0, output, -1);
	}

	private void printCombinationUsingPermutationByFixingInput(char[] input, int inputIdx, char[] output,
			int occupiedPos) {
		if (inputIdx == input.length) {
			System.out.println(String.valueOf(output));
			return;
		}
		for (int pos = 0; pos < output.length; pos++) {
			if (pos > occupiedPos) {
				output[pos] = input[inputIdx];
				printCombinationUsingPermutationByFixingInput(input, inputIdx + 1, output, pos);
				output[pos] = '_';
			}
		}
	}

	@Override
	public void printCombinationUsingPermutationByFixingPos(int positionCount, int r) {
		String item = "";
		for (int i = 0; i < r; i++)
			item += "i";

		PermutationQuestion.INSTANCE.printPermutationOfItemInArrayByHandlingDuplicatesAndFixingPos(positionCount, item);
	}

	@Override
	public void printCombinationOfItemIn2dArrayUsingPascalIdentityExpansionByFixingPos(int row, int col, int r) {
		char[][] output = new char[row][col];
		for (char[] x : output) {
			Arrays.fill(x, '_');
		}
		printCombinationOfItemIn2dArrayUsingPascalIdentityExpansionByFixingPosition(output, r, 0, 0);
	}

	private void printCombinationOfItemIn2dArrayUsingPascalIdentityExpansionByFixingPosition(char[][] output, int r,
			int rowPosToFix, int colPosToFix) {
		if (r == 0) {
			for (int i = 0; i < output.length; i++)
				System.out.println(Arrays.toString(output[i]));
			System.out.println("--------------");
		}

		while (rowPosToFix < output.length) {
			int currRow = rowPosToFix;

			while (colPosToFix < output[0].length) {
				int currCol = colPosToFix;
				output[currRow][currCol] = 'i';
				++colPosToFix;
				printCombinationOfItemIn2dArrayUsingPascalIdentityExpansionByFixingPosition(output, r - 1, rowPosToFix,
						colPosToFix);
				output[currRow][currCol] = '_';
			}
			colPosToFix = 0;
			++rowPosToFix;
		}
	}

	@Override
	public void printCombinationOfItemIn2dArrayByElongatingAndFixingPos(int row, int col, int r) {
		char[][] output = new char[row][col];
		for (char[] x : output)
			Arrays.fill(x, '_');
		printCombinationOfItemIn2dArrayByElongatingAndFixingPosUsingPascalIdentityExpansion(r, output, 0);
	}

	private void printCombinationOfItemIn2dArrayByElongatingAndFixingPosUsingPascalIdentityExpansion(int r,
			char[][] output, int posToFix) {
		if (r == 0) {
			for (int i = 0; i < output.length; i++)
				System.out.println(Arrays.toString(output[i]));
			System.out.println("--------------");
		}
		while (posToFix < output.length * output[0].length) {
			int row = posToFix / output[0].length;
			int col = posToFix % output[0].length;
			output[row][col] = 'i';
			printCombinationOfItemIn2dArrayByElongatingAndFixingPosUsingPascalIdentityExpansion(r - 1, output,
					++posToFix);
			output[row][col] = '_';
		}
	}

	@Override
	public void printNQueenCombinationsUsingPascalIdentityExpansionByFixingPos(int n) {
		char[][] output = new char[n][n];
		for (char[] x : output)
			Arrays.fill(x, '_');
		printNQueenCombinationsUsingPascalIdentityExpansionByFixingPos(output, n, 0);
	}

	private void printNQueenCombinationsUsingPascalIdentityExpansionByFixingPos(char[][] output, int n, int posToFix) {
		if (n == 0) {
			for (int i = 0; i < output.length; i++)
				System.out.println(Arrays.toString(output[i]));
			System.out.println("--------------");
		}
		while (posToFix < output.length * output[0].length) {
			int row = posToFix / output[0].length;
			int col = posToFix % output[0].length;
			posToFix++;
			if (isValidQueenPlacementByFixingPos(output, row, col)) {
				output[row][col] = 'q';
				printNQueenCombinationsUsingPascalIdentityExpansionByFixingPos(output, n - 1, posToFix);
				output[row][col] = '_';
			}
		}
	}

	/**
	 * <pre>
	 * 1. We will not validate queen placement on next positions because we are 
	 * fixings positions, so next positions will be empty till leaf node 
	 * on the path of euler_tour.
	 * 
	 * 
	 * Remaining validation part on board:
	 * 1. above-vertical columns
	 * 2. above-left-diagonal rows-cols 
	 * 3. above-right-diagonal rows-cols
	 * 4. horizontal-left columns
	 * 
	 * </pre>
	 */
	public static boolean isValidQueenPlacementByFixingPos(char[][] board, int row, int col) {
		// Checking above
		for (int i = row - 1; i >= 0; i--)
			if (board[i][col] != '_')
				return false;

		// Checking to the left
		for (int i = col - 1; i >= 0; i--)
			if (board[row][i] != '_')
				return false;

		// checking left-up diagonal
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] != '_')
				return false;

		// checking right-up diagonal
		for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
			if (board[i][j] != '_')
				return false;

		return true;
	}

	@Override
	public void printCombinationByUsingPIEAndHandlingDuplicates(String input, int r) {
		String distinctChars = input.chars().distinct().mapToObj(c -> String.valueOf((char) c))
				.collect(Collectors.joining());

		printCombinationByUsingPIEAndHandlingDuplicates(distinctChars, 0, r, "");
	}

	private void printCombinationByUsingPIEAndHandlingDuplicates(String input, int idx, int r, String output) {
		if (r == 0) {
			System.out.println(output);
			return;
		}
		for (int i = idx; i < input.length(); i++)
			printCombinationByUsingPIEAndHandlingDuplicates(input, i + 1, r - 1, output + input.charAt(i));
	}

}
