package edu.sau.algo.recursion;

import java.util.Arrays;

import edu.sau.algebra.BinaryExponentiation;
import edu.sau.algo.permcomb.CombinationQuestion;
import edu.sau.algo.permcomb.DoubleCountingQuestion;

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

		INSTANCE.printGroupCombination(new String[] { "abc", "def" });
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
	public void printGroupCombination(String[] groups) {
		CombinationQuestion.INSTANCE.printGroupCombination(groups);
	}

}
