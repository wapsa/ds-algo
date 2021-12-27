package edu.sau.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import edu.sau.algebra.BinaryExponentiation;
import edu.sau.algo.permcomb.CombinationQuestion;
import edu.sau.algo.permcomb.DoubleCountingQuestion;
import edu.sau.algo.permcomb.PermutationQuestion;
import edu.sau.algo.permcomb.PermutationSolution;

public class RecursionSolutionLevel1 implements RecursionQuestionL1 {

	public static void main(String[] args) {
		// INSTANCE.printDecreasingIncreasing(5);

		// INSTANCE.factorial(5);

		// INSTANCE.eulerTourOfRecursion(5);

		// INSTANCE.printAToThePowerOfP(2, 5);

		// INSTANCE.printTowerOfHanoiSteps(3);

		// INSTANCE.printElementsOfArray(new int[] { 1, 2, 3, 4, 5 });

		// INSTANCE.printElementsOfArrayInReverse(new int[] { 1, 2, 3, 4, 5 });

		// INSTANCE.printMaxElementOfArray(new int[] { 1, 7, 3, 4, 5 });

		// INSTANCE.printFirstIndexOfOccurrence(new int[] { 1, 7, 7, 3, 4, 5, 7, 3 },
		// 7);

		// INSTANCE.printLastIndexOfOccurrence(new int[] { 1, 7, 7, 3, 4, 5, 7, 3 }, 7);

		// INSTANCE.printAllIndexOfOccurrence(new int[] { 1, 7, 7, 3, 4, 5, 7, 3 }, 7);

		// INSTANCE.printSubsequences("abc");

		// System.out.println(INSTANCE.getGroupCombination(new String[] { "abc", "def"
		// }));

		// INSTANCE.printGroupCombination(new String[] { "abc", "def" });

		// INSTANCE.printStairsPathPermutation(7, new int[] { 1, 2, 3 });
		// System.out.println(INSTANCE.getStairsPathPermutation(7, new int[] { 1, 2, 3
		// }));

		// INSTANCE.printMazePathsToReachDestination1(0, 0, 2, 2);
		// System.out.println(INSTANCE.getMazePathsToReachDestination1(0, 0, 2, 2));

		// INSTANCE.printMazePathsToReachDestination2(0, 0, 2, 2);
		// System.out.println(INSTANCE.getMazePathsToReachDestination2(0, 0, 2, 2));

		// INSTANCE.printMazePathsToReachDestination3(0, 0, 2, 2);
		// System.out.println(INSTANCE.getMazePathsToReachDestination3(0, 0, 2, 2));

		// INSTANCE.printEncodings("1211");

		// int[][] maze1 = new int[][] { { 0, 1, 1 }, { 0, 1, 1 }, { 0, 0, 0 } };
		// int[][] maze2 = new int[][] { { 0, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1 }, { 0, 0,
		// 0, 0, 0 }, { 0, 1, 1, 1, 0 },
		// { 0, 0, 0, 0, 0 } };
		// INSTANCE.printMazePathsAvoidingObstaclesToReachDestination4(maze2, 0, 0, 4,
		// 4);

		// INSTANCE.printNQueenAllowedPlacements(5);

		INSTANCE.printNQueenAllowedPlacements5(5);

		// INSTANCE.printKnightTour(6, 2, 2);

	}

	/**
	 * <pre>
	 * Print decreasing sequence then increasing sequence for a given number n
	 * 
	 * e.g. n=4 ; 4 3 2 1 1 2 3 4
	 * 
	 * Hypothesis   : 	printDecreasingIncreasing(n=4)  : 4 3 2 1 1 2 3 4
	 * 
	 * Substitution : 	printDecreasingIncreasing(n=3)   : 3 2 1 1 2 3
	 * 
	 * Induction    :   4  printDecreasingIncreasing(3)  4
	 *              :   n  printDecreasingIncreasing(n-1)  n
	 * </pre>
	 * 
	 */
	@Override
	public void printDecreasingIncreasing(int n) {
		if (n == 0)
			return;
		System.out.print(n + " ");
		printDecreasingIncreasing(n - 1);
		System.out.print(n + " ");
	}

	@Override
	public int factorial(int n) {
		if (n < 1)
			return 1;
		else {
			int factorial = n * factorial(n - 1);
			System.out.println(n + "! = " + factorial);
			return factorial;
		}
	}

	@Override
	public void eulerTourOfRecursion(int n) {
		if (n == 0)
			return;

		System.out.println("Before br1:" + n);
		// this invocation represents branch 1 in recursion tree
		eulerTourOfRecursion(n - 1);
		System.out.println("Betw br1&2:" + n);
		// this invocation represents branch 2 in recursion tree
		eulerTourOfRecursion(n - 1);
		System.out.println(" After br2:" + n);

	}

	@Override
	public void printAToThePowerOfP(int a, int p) {
		System.out.println(BinaryExponentiation.binaryPowerRecursive(a, p));
	}

	@Override
	public void printTowerOfHanoiSteps(int n) {
		toh(n, "TWR_1", "TWR_2", "TWR_3");
	}

	/**
	 * <pre>
	 *
	 * Recursion branch algorithm is based on converting the problem into TWO_DISK_PROCESS
	 * 
	 * How to convert the problem in two disk process ?
	 * Disk_2 : bottom most disk on src_tower can be assumed as disk_2
	 * Disk_1:  All other remaing disks on src_tower can be assumed as  disk_1.
	 * 
	 * Base : we can have two choices for Base Case :
	 *  CHOICE 1 : when n==0; just return
	 *           or
	 * CHOICE 2 : when we have n==1 i.e. single disk, we can directly move the disk from src to des tower.
	 *
	 *
	 * Hypothesis : toh(4,S,D,H) => can move 4 disks from src_tower to des_tower
	 * using helper_tower
	 * INPUT_STATE : src_tower{DSK4, DSK3, DSK2, DSK1}; des_tower{}; helper_tower{} 
	 * OUTPUT_STATE : src_tower{}; des_tower{DSK4, DSK3, DSK2, DSK1}; helper_tower{}
	 *
	 * Substitution : toh(3,S,H,D) => can move 3 disks(DSK3, DSK2, DSK1) from 
	 * src_tower to helper_tower using des_tower as auxillary tower
	 * INPUT_STATE  :  src_tower{DSK4, DSK3, DSK2, DSK1}; des_tower{}; helper_tower{} 
	 * OUTPUT_STATE :  src_tower{DSK4}; des_tower{}; helper_tower{DSK3, DSK2, DSK1}
	 * 
	 * Induction :
	 * 1. move DSK4 from src_tower to  des_tower
	 * STATE : src_tower{}; des_tower{DSK4}; helper_tower{DSK3, DSK2, DSK1}
	 * 2. call the toh(3,H,D,S) : to move 3 disks from helper_tower to des_tower using
	 *  src_tower as auxillary tower.
	 * STATE : src_tower{}; des_tower{DSK4, DSK3, DSK2, DSK1}; helper_tower{}
	 * </pre>
	 */
	private static void toh(int discNum, String srcTwr, String destTwr, String helperTwr) {

		if (discNum == 0)
			return;

		toh(discNum - 1, srcTwr, helperTwr, destTwr);
		System.out.println(srcTwr + " --> " + " DISC " + discNum + " --> " + destTwr);
		toh(discNum - 1, helperTwr, destTwr, srcTwr);

	}

	@Override
	public void printElementsOfArray(int[] array) {
		printElementsOfArray(array, 0);
	}

	private void printElementsOfArray(int[] array, int idx) {
		if (idx == array.length)
			return;
		System.out.println(array[idx]);
		printElementsOfArray(array, idx + 1);
	}

	@Override
	public void printElementsOfArrayInReverse(int[] array) {
		printElementsOfArrayInReverse(array, array.length - 1);
	}

	private void printElementsOfArrayInReverse(int[] array, int idx) {
		if (idx == -1)
			return;
		System.out.println(array[idx]);
		printElementsOfArrayInReverse(array, idx - 1);
	}

	@Override
	public void printMaxElementOfArray(int[] array) {
		System.out.println(getMaxElementInArray(array, 0));
	}

	/**
	 * <pre>
	 * 
	 * Assumption: Since 'max' operation needs two operands, so
	 * 1st operand :0th index element
	 * 2nd opreand :we will collate all remaining elements as 2nd operand
	 * 
	 * Hypothesis : getMaxElementOfArray([2,6,4,7,8,9,1,2]) ; gives max among all 8 elements
	 * 
	 * Substitution : getMaxElementOfArray([6,4,7,8,9,1,2]) ; gives max among remaiang 7 elements
	 *              : substituition represents collated operand 
	 *
	 * Induction :   Math.max(2,getMaxElementOfArray([6,4,7,8,9,1,2]))
	 * 
	 * </pre>
	 */
	private int getMaxElementInArray(int[] array, int idx) {
		if (idx == array.length - 1)
			return array[idx];

		return Math.max(array[idx], getMaxElementInArray(array, idx + 1));
	}

	@Override
	public void printFirstIndexOfOccurrence(int[] array, int data) {
		System.out.println(getFirstIndexOfOccurrence(array, data, 0));
	}

	/**
	 * <pre>
	 *  1st operand :0th index element
	 *  2nd opreand :we will collate all remaining elements as 2nd operand
	 *
	 *  Element to be serached : data
	 *
	 *  Comparisons required to test the first occurrence
	 *
	 *  1.  IF data is eqaul to 1st_operand
	 *
	 *  2.  ELSE data is not equal to 1st_operand
	 *        2A: check if index presented by 2nd_operand is +Ve
	 *        2B: or index presented by 2nd_operand is -ve
	 * </pre>
	 * 
	 */
	private int getFirstIndexOfOccurrence(int[] array, int data, int idx) {
		if (idx == array.length)
			return -1;

		if (data == array[idx])
			return idx;

		return getFirstIndexOfOccurrence(array, data, idx + 1);
	}

	@Override
	public void printLastIndexOfOccurrence(int[] array, int data) {
		System.out.println(getLastIndexOfOccurrence(array, data, array.length - 1));
	}

	/**
	 * <pre>
	 *  1st operand :last element of array
	 *  2nd opreand :we will collate all remaining from 0th-index to 2nd-last-index as 2nd operand
	 *
	 *  Element to be serached : data
	 *
	 *  Comparisons required to test the first occurrence
	 *
	 *  1.  IF data is eqaul to 1st_operand
	 *
	 *  2.  ELSE data is not equal to 1st_operand
	 *        2A: check if index presented by 2nd_operand is +Ve
	 *        2B: or index presented by 2nd_operand is -ve
	 * </pre>
	 * 
	 */
	private int getLastIndexOfOccurrence(int[] array, int data, int idx) {
		if (idx == -1)
			return -1;

		if (data == array[idx])
			return idx;

		return getLastIndexOfOccurrence(array, data, idx - 1);
	}

	@Override
	public void printAllIndexOfOccurrence(int[] array, int data) {
		System.out.println(Arrays.toString(getOccurrences(array, data, 0, 0)));
	}

	/**
	 * <pre>
	 * Strategy : Count the occurrence of given data in forward trip, 
	 *            create the solution array in base-case 
	 *            and fill the solution aray in return trip.
	 *
	 * Hypothesis: getOccurrenceArray(array, idx=0) : returns solution-array containing occurrence index
	 * Substitution : getOccurrenceArray(array, idx=1) : returns solution-array filled from right-to-left,
	 *                when first_operand is equal to data then solution array will have vacant space 
	 *                towrads left.
	 *
	 * Induction: if data is equal to first_operand, place the index of first_operand in solution array
	 *            at (occrrenceCount -1)th index 
	 *            else return the same solution arrray.
	 * 
	 * </pre>
	 * 
	 */
	private int[] getOccurrences(int[] array, int data, int idx, int occurrenceCount) {
		if (idx == array.length)
			return new int[occurrenceCount];

		if (data == array[idx]) {
			int[] occurrenceArray = getOccurrences(array, data, idx + 1, occurrenceCount + 1);
			occurrenceArray[occurrenceCount] = idx;
			return occurrenceArray;
		} else {
			return getOccurrences(array, data, idx + 1, occurrenceCount);
		}
	}

	@Override
	public void printSubsequences(String input) {
		DoubleCountingQuestion.INSTANCE.printPowerSetUsingSubSequence(input);
	}

	@Override
	public List<String> getGroupCombination(String[] groups) {
		return CombinationQuestion.INSTANCE.getGroupCombination(groups);
	}

	@Override
	public void printGroupCombination(String[] groups) {
		CombinationQuestion.INSTANCE.printGroupCombination(groups);
	}

	@Override
	public void printStairsPathPermutation(int noOfStep, int[] allowedSteps) {
		printStairsPathPermutation(noOfStep, allowedSteps, "");
		// printStairsPathPermutation(noOfStep, allowedSteps, new ArrayList<>());
	}

	private void printStairsPathPermutation(int noOfStep, int[] allowedSteps, List<Integer> paths) {
		if (noOfStep < 0)
			return;
		if (noOfStep == 0) {
			System.out.println(paths);
			return;
		}
		for (int i = 0; i < allowedSteps.length; i++) {
			List<Integer> pathList = new ArrayList<>(paths);
			pathList.add(allowedSteps[i]);
			printStairsPathPermutation(noOfStep - allowedSteps[i], allowedSteps, pathList);
		}
	}

	/**
	 * <pre>
	 * HYPOTHEISIS : getStairPathPermutation2(7,[1,2,3], "") : provide all the
	 * allowed paths
	 * 
	 * SUBSTITUTION: getStairPathPermutation2(6,[1,2,3], "1") : add the remaining
	 * paths to 1 getStairPathPermutation2(5,[1,2,3], "2") : add the remaining paths
	 * to 2 getStairPathPermutation2(4,[1,2,3], "3") : add the remaining paths to 3
	 * 
	 * INDUCTION: 1st part of any path is provided by main code and remaining part
	 * is expected from substitution step.
	 */
	private void printStairsPathPermutation(int noOfStep, int[] allowedSteps, String path) {
		if (noOfStep < 0)
			return;
		if (noOfStep == 0) {
			System.out.println(path);
			return;
		}
		for (int i = 0; i < allowedSteps.length; i++) {
			printStairsPathPermutation(noOfStep - allowedSteps[i], allowedSteps, path + allowedSteps[i]);
		}
	}

	/**
	 * Find Permutation of given numbers whose sum is equal to a target_value.
	 * 
	 * Example problem statement : Find all the possible stair paths with given
	 * total number of stairs step and allowed step size. e.g. Total number of setps
	 * = 7 and at a time we can take step of size 1 or 2 or 3.
	 * 
	 * <pre>
	 * HYPOTHEISIS : printStairPathPermutation(7, [1,2,3]) => print total paths 'n'
	 * 
	 * SUBSTITUTION: 
	 * printStairPathPermutation(6, [1,2,3]) => provide all the subPaths that starts
	 * with 1
	 * 
	 * printStairPathPermutation(5, [1,2,3]) => provide all the subPaths that starts
	 * with 2
	 * 
	 * printStairPathPermutation(4, [1,2,3]) => provide all the subPaths that starts
	 * with 3
	 * 
	 * INDUCTION STRATEGY : prepend 1, 2, 3 to  paths returned by respective substitution methods.
	 * 
	 * 
	 * </pre>
	 */
	@Override
	public List<String> getStairsPathPermutation(int noOfSteps, int[] allowedSteps) {
		// targetValue becomes negative for invalid path
		if (noOfSteps < 0) {
			return List.of();

		}
		// targetValue becomes 0 for valid end of path
		if (noOfSteps == 0) {
			return List.of("");
		}

		List<String> paths = new ArrayList<>();
		for (int i = 0; i < allowedSteps.length; i++) {
			List<String> ipaths = getStairsPathPermutation(noOfSteps - allowedSteps[i], allowedSteps);

			for (String path : ipaths) {
				paths.add(allowedSteps[i] + path);
			}
		}
		return paths;
	}

	@Override
	public void printMazePathsToReachDestination1(int startCol, int startRow, int endCol, int endRow) {
		printMazePathsToReachDestination1(startCol, startRow, endCol, endRow, "");
	}

	/**
	 * <pre>
	 * Print all the possible maze paths between start_pos to end_pos using right
	 * and down move
	 * 
	 * STRATEGY : same as printStairPathPermutation. 
	 * 
	 * Time Complexity: T(n) = T(n-1) + T(n-1) 
	 *                       = 2T(n-1) + 1
	 *                       = O(2^n)
	 * </pre>
	 * 
	 * @see RecursionSolutionLevel1#getStairsPathPermutation(int, int...)
	 */
	private void printMazePathsToReachDestination1(int startCol, int startRow, int endCol, int endRow, String path) {
		if (startCol > endCol || startRow > endRow)
			return;
		if (startCol == endCol && startRow == endRow) {
			System.out.println(path + endRow + endCol);
			return;
		}
		printMazePathsToReachDestination1(startCol + 1, startRow, endCol, endRow, (path + startRow + startCol + "h->"));
		printMazePathsToReachDestination1(startCol, startRow + 1, endCol, endRow, (path + startRow + startCol + "v->"));
	}

	@Override
	public List<String> getMazePathsToReachDestination1(int startCol, int startRow, int endCol, int endRow) {

		if (startCol > endCol || startRow > endRow)
			return List.of();

		if (startCol == endCol && startRow == endRow) {
			return List.of("" + endRow + endCol);
		}
		List<String> paths = new ArrayList<>();

		List<String> horizontalPathMoves = getMazePathsToReachDestination1(startCol + 1, startRow, endCol, endRow);
		List<String> verticalPathMoves = getMazePathsToReachDestination1(startCol, startRow + 1, endCol, endRow);

		for (String move : horizontalPathMoves)
			paths.add(startRow + "" + startCol + "h->" + move);
		for (String move : verticalPathMoves)
			paths.add(startRow + "" + startCol + "v->" + move);

		return paths;
	}

	@Override
	public void printMazePathsToReachDestination2(int startCol, int startRow, int endCol, int endRow) {
		printMazePathsToReachDestination2(startCol, startRow, endCol, endRow, "");
	}

	private void printMazePathsToReachDestination2(int startCol, int startRow, int endCol, int endRow, String path) {
		if (startCol > endCol || startRow > endRow)
			return;
		if (startCol == endCol && startRow == endRow) {
			System.out.println(path + endRow + endCol);
			return;
		}
		printMazePathsToReachDestination2(startCol + 1, startRow, endCol, endRow, (path + startRow + startCol + "h->"));
		printMazePathsToReachDestination2(startCol, startRow + 1, endCol, endRow, (path + startRow + startCol + "v->"));
		printMazePathsToReachDestination2(startCol + 1, startRow + 1, endCol, endRow,
				(path + startRow + startCol + "d->"));
	}

	@Override
	public List<String> getMazePathsToReachDestination2(int startCol, int startRow, int endCol, int endRow) {

		if (startCol > endCol || startRow > endRow)
			return List.of();

		if (startCol == endCol && startRow == endRow) {
			return List.of("" + endRow + endCol);
		}
		List<String> paths = new ArrayList<>();

		List<String> horizontalPathMoves = getMazePathsToReachDestination2(startCol + 1, startRow, endCol, endRow);
		List<String> verticalPathMoves = getMazePathsToReachDestination2(startCol, startRow + 1, endCol, endRow);
		List<String> diagonalPathMoves = getMazePathsToReachDestination2(startCol + 1, startRow + 1, endCol, endRow);

		for (String move : horizontalPathMoves)
			paths.add(startRow + "" + startCol + "h->" + move);
		for (String move : verticalPathMoves)
			paths.add(startRow + "" + startCol + "v->" + move);
		for (String move : diagonalPathMoves)
			paths.add(startRow + "" + startCol + "d->" + move);

		return paths;
	}

	@Override
	public void printMazePathsToReachDestination3(int startCol, int startRow, int endCol, int endRow) {
		printMazePathsToReachDestination3(startCol, startRow, endCol, endRow, "");
	}

	/**
	 * <pre>
	 * Print all the possible maze paths between start_pos to end_pos using 
	 * 1. right move of step size  1 to (n-1) uint
	 * 2. down move of step size 1 to (m-1) unit
	 * 3. diagonal move of step size 1 to Math.max((n-1), (m-1)) size
	 * 
	 * Total recursive method invocations : n(for col) + n(for rows) + n(for diagonal)
	 *                                    :3n internal recursive calls; so at 0 level recursion tree
	 *                                     will have 3n branches. thus at leaf level recursion tree will 
	 *                                     have (3n)^(n) branches
	 *                                    : O((3n)^n )
	 * </pre>
	 */
	private void printMazePathsToReachDestination3(int startCol, int startRow, int endCol, int endRow, String path) {
		if (startCol > endCol || startRow > endRow)
			return;
		if (startCol == endCol && startRow == endRow) {
			System.out.println(path + endRow + endCol);
			return;
		}
		for (int stepSize = 1; stepSize <= endCol - startCol; stepSize++) {
			printMazePathsToReachDestination3(startCol + stepSize, startRow, endCol, endRow,
					(path + startRow + startCol + "h->"));
		}
		for (int stepSize = 1; stepSize <= endRow - startRow; stepSize++) {
			printMazePathsToReachDestination3(startCol, startRow + stepSize, endCol, endRow,
					(path + startRow + startCol + "v->"));
		}
		for (int stepSize = 1; stepSize <= Math.max(endRow, endCol); stepSize++) {
			printMazePathsToReachDestination3(startCol + stepSize, startRow + stepSize, endCol, endRow,
					(path + startRow + startCol + "d->"));
		}
	}

	@Override
	public List<String> getMazePathsToReachDestination3(int startCol, int startRow, int endCol, int endRow) {
		if (startCol > endCol || startRow > endRow)
			return List.of();

		if (startCol == endCol && startRow == endRow) {
			return List.of("" + endRow + endCol);
		}
		List<String> paths = new ArrayList<>();

		for (int stepSize = 1; stepSize <= endCol - startCol; stepSize++) {
			List<String> horizontalPathMoves = getMazePathsToReachDestination3(startCol + stepSize, startRow, endCol,
					endRow);
			for (String move : horizontalPathMoves)
				paths.add(startRow + "" + startCol + "h->" + move);
		}

		for (int stepSize = 1; stepSize <= endRow - startRow; stepSize++) {
			List<String> verticalPathMoves = getMazePathsToReachDestination3(startCol, startRow + stepSize, endCol,
					endRow);
			for (String move : verticalPathMoves)
				paths.add(startRow + "" + startCol + "v->" + move);
		}

		for (int stepSize = 1; stepSize <= Math.max(endRow, endCol); stepSize++) {
			List<String> diagonalPathMoves = getMazePathsToReachDestination3(startCol + stepSize, startRow + stepSize,
					endCol, endRow);
			for (String move : diagonalPathMoves)
				paths.add(startRow + "" + startCol + "d->" + move);
		}

		return paths;
	}

	@Override
	public void printEncodings(String input) {
		printEncodings1(input, "");
		System.out.println("-----");
		printEncodings2(input, "");
	}

	private void printEncodings1(String input, String encoding) {
		if (input.length() == 0) {
			System.out.println(encoding);
			return;
		}
		char firstDigit = input.charAt(0);

		if (firstDigit == '0')
			return;

		// converting char to int, 6 = '6' - '0';
		int firstDigitVal = firstDigit - '0';
		// c = 'a' + 2
		char encodedVal = (char) ('a' + firstDigitVal - 1);
		printEncodings1(input.substring(1), encoding + encodedVal);

		if (input.length() < 2)
			return;

		String firstTwoDigits = input.substring(0, 2);
		int firstTwoDigitVal = Integer.valueOf(firstTwoDigits);
		if (firstTwoDigitVal <= 26) {
			encodedVal = (char) ('a' + firstTwoDigitVal - 1);
			printEncodings1(input.substring(2), encoding + encodedVal);
		}

	}

	private static final Map<String, String> ENCODING_MAP = Map.ofEntries(Map.entry("1", "a"), Map.entry("2", "b"),
			Map.entry("3", "c"), Map.entry("4", "d"), Map.entry("5", "e"), Map.entry("6", "f"), Map.entry("7", "g"),
			Map.entry("8", "h"), Map.entry("9", "i"), Map.entry("10", "j"), Map.entry("11", "k"), Map.entry("12", "l"),
			Map.entry("13", "m"), Map.entry("14", "n"), Map.entry("15", "o"), Map.entry("16", "p"),
			Map.entry("17", "q"), Map.entry("18", "r"), Map.entry("19", "s"), Map.entry("20", "t"),
			Map.entry("21", "u"), Map.entry("22", "v"), Map.entry("23", "w"), Map.entry("24", "x"),
			Map.entry("25", "y"), Map.entry("26", "z"));

	private void printEncodings2(String input, String encoding) {
		if (input.length() == 0) {
			System.out.println(encoding);
			return;
		}

		// encoding of one digit
		String firstDigit = input.substring(0, 1);
		if (ENCODING_MAP.containsKey(firstDigit))
			printEncodings2(input.substring(1), encoding + ENCODING_MAP.get(firstDigit));

		if (input.length() < 2)
			return;

		// encoding of two digits
		String firstTwoDigits = input.substring(0, 2);
		if (ENCODING_MAP.containsKey(firstTwoDigits))
			printEncodings2(input.substring(2), encoding + ENCODING_MAP.get(firstTwoDigits));
	}

	@Override
	public void printMazePathsAvoidingObstaclesToReachDestination4(int[][] maze, int startCol, int startRow, int endCol,
			int endRow) {
		printMazePathsAvoidingObstaclesToReachDestination4(maze, startCol, startRow, endCol, endRow,
				new boolean[maze.length][maze[0].length], "");
	}

	/**
	 * <pre>
	 * moves order : l,r,t,d
	 * moves represent the options of recursion tree .i.e nothing but branch of the recursion tree.
	 * Level of tree will be represented by row or col reached post recursion invocation.
	 * 
	 * Solution  Notes:
	 * 
	 * NOTE_1. left_move & right_move ; top_move & down_move are opposite
	 * moves. Because of their opposite directions path exploration can go in
	 * infinite loop, so to avoid infinite loop we need to track the visited cells
	 * of maze.
	 * 
	 * NOTE_2. We need to mark the visited-cells to unvisited in return trip of an
	 * exploration, so that the previous exploration would not impact the next
	 * exploration path.
	 * 
	 * Hypothesis: printObstacledMazePath3(startRow, startCol) : prints all the possible path
	 * 
	 * Substitution:
	 * using option_left : printObstacledMazePath3(startRow, startCol - 1,  "l") : append remaining path to "l" 
	 * using option_right: printObstacledMazePath3(startRow, startCol + 1 , "r") : append remaining path to "r" 
	 * using option_top: printObstacledMazePath3(startRow - 1, startCol, "t") : append remaining path to "t" 
	 * using option_down: printObstacledMazePath3(startRow - 1, startCol, "d") : append remaining path to "d" 
	 * 
	 * Induction: main code appends options l,r,t,d to path and remaining path is appended by substitution step.
	 * </pre>
	 */
	private void printMazePathsAvoidingObstaclesToReachDestination4(int[][] maze, int startCol, int startRow,
			int endCol, int endRow, boolean[][] visited, String path) {

		if (startRow < 0 || startCol < 0 || startRow >= maze.length || startCol >= maze[0].length
				|| maze[startRow][startCol] == 1 || visited[startRow][startCol])
			return;

		if (startCol == endCol && startRow == endRow) {
			System.out.println(path + endRow + endCol);
			return;
		}

		visited[startRow][startCol] = true;
		// left move
		printMazePathsAvoidingObstaclesToReachDestination4(maze, startCol - 1, startRow, endCol, endRow, visited,
				path + startRow + startCol + "left->");
		// right move
		printMazePathsAvoidingObstaclesToReachDestination4(maze, startCol + 1, startRow, endCol, endRow, visited,
				path + startRow + startCol + "right->");
		// up move
		printMazePathsAvoidingObstaclesToReachDestination4(maze, startCol, startRow - 1, endCol, endRow, visited,
				path + startRow + startCol + "top->");
		// down move
		printMazePathsAvoidingObstaclesToReachDestination4(maze, startCol, startRow + 1, endCol, endRow, visited,
				path + startRow + startCol + "down->");
		visited[startRow][startCol] = false;
	}

	@Override
	public void printNQueenAllowedPlacements1(int n) {
		CombinationQuestion.INSTANCE.printNQueenCombinationsUsingPascalIdentityExpansionByFixingPos(n);
	}

	@Override
	public void printNQueenAllowedPlacements2(int n) {
		PermutationQuestion.INSTANCE.printNQueenPermutationsByFixingPos(n);
	}

	@Override
	public void printNQueenAllowedPlacements3(int n) {
		PermutationQuestion.INSTANCE.printNQueenPermutationsByFixingInput(n);
	}

	@Override
	public void printNQueenAllowedPlacements4(int n) {
		printNQueenCombinationsByFixingRowsAndTryingColumnsAsOptions(new int[n][n], 0);
	}

	/**
	 * <pre>
	 * 
	 * "In a single row we can place at-most one queen.
	 * Means, a queen can be placed at any column position in a row."
	 * 
	 * Thus recursion tree formation Strategy will be: 
	 * i.  we can fix the rows at each level and 
	 * ii. try the columns as options.
	 * 
	 * Note: we can reverse the strategy like column can be fixed and we can try rows as options.
	 * 
	 * Tree Node :  represented by Row as we have fixed the row
	 * Tree Branch : represented by Columns as we are taking columns as options 
	 * 
	 * Levels of tree: for each row there will be one level in tree.
	 * 
	 * Since we are fixing the rows one by one at each level, and since we can go to next level via recursion call, 
	 * so need to pass row as method parameter.
	 * </pre>
	 */
	private void printNQueenCombinationsByFixingRowsAndTryingColumnsAsOptions(int[][] board, int row) {
		if (row == board.length) {
			for (int[] x : board) {
				System.out.println(Arrays.toString(x));
			}
			System.out.println("---------------");
			return;
		}

		for (int col = 0; col < board.length; col++) {
			if (isValidQueenPlacementPosition(board, row, col)) {
				board[row][col] = 1;
				printNQueenCombinationsByFixingRowsAndTryingColumnsAsOptions(board, row + 1);
				// removing queen from this col so we can try at next column
				board[row][col] = 0;
			}
		}
	}

	/**
	 * 1) No need to validate in next rows because they are empty.
	 * 
	 * 2) No need to validate current row because we are making sure current row
	 * will have no queen because we are doing "board[row][col] = 0;" after each
	 * trial while backtracking.
	 * 
	 * Validation Parts for queen moves
	 * 
	 * 1) all points above [row][col] point. in same column.
	 * 
	 * 2) all points to the left diagonal of [row][col] point.
	 * 
	 * 3) all points to the right diagonal of [row][col] point.
	 * 
	 * Time complexity: O(n)
	 */
	private boolean isValidQueenPlacementPosition(int[][] board, int row, int col) {
		// Checking above
		for (int i = row - 1; i >= 0; i--)
			if (board[i][col] == 1)
				return false;

		// checking left-up diagonal
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		// checking right-up diagonal
		for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	/**
	 * Time complexity: total number of leaf-node in the tree. (n * n-1 * n-2 *...)
	 * = n!
	 * 
	 * total number of node = 2*n! -1
	 * 
	 * Some of the branches are getting truncated by isValidQueenPlacement.
	 * 
	 * total time complexity : n! - time complexity of truncating the branches
	 */
	@Override
	public void printNQueenAllowedPlacements5(int n) {
		boolean[] colTracker = new boolean[n];
		boolean[] aboveLeftDiagTracker = new boolean[n + n - 1];
		boolean[] aboveRightDiagTracker = new boolean[n + n - 1];
		printNQueenCombinationsByFixingRowsAndTryingColumnsAsOptions(new int[n][n], 0, colTracker, aboveLeftDiagTracker,
				aboveRightDiagTracker);
	}

	private void printNQueenCombinationsByFixingRowsAndTryingColumnsAsOptions(int[][] board, int rowIdx, boolean[] col,
			boolean[] aboveLeftDiag, boolean[] aboveRightDiag) {
		if (rowIdx == board.length) {
			for (int[] x : board) {
				System.out.println(Arrays.toString(x));
			}
			System.out.println("---------------");
			return;
		}

		for (int colIdx = 0; colIdx < board[0].length; colIdx++) {

			if (isValidQueenPlacementPosition(board, rowIdx, colIdx, col, aboveLeftDiag, aboveRightDiag)) {
				board[rowIdx][colIdx] = 1;
				col[colIdx] = true;
				aboveLeftDiag[rowIdx - colIdx + board.length - 1] = true;
				aboveRightDiag[rowIdx + colIdx] = true;
				printNQueenCombinationsByFixingRowsAndTryingColumnsAsOptions(board, rowIdx + 1, col, aboveLeftDiag,
						aboveRightDiag);
				board[rowIdx][colIdx] = 0;
				col[colIdx] = false;
				aboveLeftDiag[rowIdx - colIdx + board.length - 1] = false;
				aboveRightDiag[rowIdx + colIdx] = false;
			}

		}

	}

	/**
	 * <pre>
	 * 1. We will not validate queen placement in next rows because next rows are
	 * still empty.
	 * 
	 * 2. We will not validate queen placement in current row because we are making
	 * sure that current row will place at-max one queen through backtracking.
	 * 
	 * Remaining validation part on board:
	 * 1. above vertical columns
	 * 2. above left-diagonal rows-cols 
	 * 3. above right-diagonal rows-cols
	 * 
	 * above_vertical_column numbering : column numbering can be done with col_index.
	 * 
	 * above_left_diagonal numbering:
	 * 
	 * 1. columns are decreasing along the direction of a diagonal.
	 * 
	 * 2. left_diagonal_count = row_count + col_count - 1
	 * 
	 * 3. When we do (row - col), will give us a fixed number for all the boxes representing the 
	 * given diagonal.
	 * 
	 * 4.Since (row - col) will have -ve values for some diagonals, so we need to rescale the
	 * diagonal numbering so that it can start with 0-index. The max -ve value will be equal 
	 * to col.length -1;
	 * 
	 * above_right_diagonal numbering: 
	 * 
	 * 1. columns are increasing along the direction of a diagonal.
	 *
	 * 2. right_diagonal_count = row_count + col_count - 1
	 * 
	 * 2. When we do (row + col), will give us a +ve fixed number for all the boxes representing the
	 * given diagonal.
	 * 
	 * 
	 * Time Complexity : O(1)
	 * 
	 * </pre>
	 */
	private boolean isValidQueenPlacementPosition(int[][] board, int rowIdx, int colIdx, boolean[] col,
			boolean[] aboveLeftDiag, boolean[] aboveRightDiag) {
		if (col[colIdx] == true)
			return false;
		if (aboveLeftDiag[rowIdx - colIdx + board.length - 1] == true)
			return false;
		if (aboveRightDiag[rowIdx + colIdx] == true)
			return false;

		return true;
	}

	@Override
	public void printKnightTour(int n, int initRow, int initCol) {
		printKnightTour(new int[n][n], initRow, initCol, 1);
	}

	private void printKnightTour(int[][] board, int row, int col, int move) {

		if (row < 0 || col < 0 || row >= board.length || col >= board.length || board[row][col] > 0)
			return;

		board[row][col] = move;

		if (move == board.length * board.length) {
			for (int[] x : board)
				System.out.println(Arrays.toString(x));
			System.out.println("---------------");
		}

		printKnightTour(board, row - 2, col + 1, move + 1);
		printKnightTour(board, row - 1, col + 2, move + 1);
		printKnightTour(board, row + 1, col + 2, move + 1);
		printKnightTour(board, row + 2, col + 1, move + 1);
		printKnightTour(board, row + 2, col - 1, move + 1);
		printKnightTour(board, row + 1, col - 2, move + 1);
		printKnightTour(board, row - 1, col - 2, move + 1);
		printKnightTour(board, row - 2, col - 1, move + 1);
		board[row][col] = 0;
	}

}
