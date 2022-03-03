package edu.sau.ds.arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import edu.sau.algo.permcomb.CombinationQuestion;
import edu.sau.algo.sort.inversion.InversionCount;
import edu.sau.ds.stack.KarumanchiQuestions;
import edu.sau.other.bitwise.BitwiseUtils;

public class ArrayAndStringSolutions implements ArrayAndStringQuestions {

	public static void main(String[] args) {
		// System.out.println(INSTANCE.isWordCorrectlyTypedOnFaultyKeyboard("sshhrreee",
		// "shree"));

		// System.out.println(Arrays.toString(INSTANCE.rangeAddition(new int[10],
		// new int[][] { { 0, 5, 1 }, { 2, 3, 2 }, { 2, 10, 5 }, { 9, 10, -2 } })));

		// System.out.println(INSTANCE.calculateMaxAreaBetweenLines(new int[] { 1, 8, 6,
		// 2, 5, 4, 8, 3, 7 }));

		// System.out.println(Arrays.toString(INSTANCE.squaresOfSortedArray(new int[] {
		// -4, -1, 0, 1, 2, 3, 10 })));

		// INSTANCE.findNBy2MajorityElementUsingBoyerMooreVotingAlgo(new int[] { 2, 2,
		// 1, 1, 1, 2, 2 });

		// INSTANCE.findNBy3MajorityElementUsingBoyerMooreVotingAlgo(new int[] { 2, 2,
		// 1, 1, 1, 2, 2 });

//		System.out
//				.println(Arrays.toString(INSTANCE.productOfElementsExceptSelfUsingDivision(new int[] { 1, 2, 3, 4 })));
//		System.out.println(
//				Arrays.toString(INSTANCE.productOfElementsExceptSelfUsingDivision(new int[] { 1, 2, 0, 3, 4 })));
//		System.out.println(
//				Arrays.toString(INSTANCE.productOfElementsExceptSelfUsingDivision(new int[] { 1, 2, 0, 3, 4, 0 })));
//		System.out.println("---------------------");
//		System.out.println(
//				Arrays.toString(INSTANCE.productOfElementsExceptSelfWithoutUsingDivision(new int[] { 1, 2, 3, 4 })));
//		System.out.println(
//				Arrays.toString(INSTANCE.productOfElementsExceptSelfWithoutUsingDivision(new int[] { 1, 2, 0, 3, 4 })));
//		System.out.println(Arrays
//				.toString(INSTANCE.productOfElementsExceptSelfWithoutUsingDivision(new int[] { 1, 2, 0, 3, 4, 0 })));

		// System.out.println(INSTANCE.getPartitionLabels("ababcbacadefegdehijhklij"));

//		INSTANCE.getMaxSortablePartitionsOn0ToNMinus1Elements(List.of(2, 0, 1, 3, 5, 4));
//		System.out.println("-------------------");
//		INSTANCE.getMaxSortablePartitionsBruteForce(List.of(2, 0, 1, 3, 5, 4));
//		INSTANCE.getMaxSortablePartitionsBruteForce(List.of(30, 10, 20, 40, 60, 40, 50, 75, 70));
//		System.out.println("-------------------");
//		INSTANCE.getMaxSortablePartitions(List.of(2, 0, 1, 3, 5, 4));
//		INSTANCE.getMaxSortablePartitions(List.of(30, 10, 20, 40, 60, 40, 50, 75, 70));
//		INSTANCE.getMaxSortablePartitions(List.of(2, 1, 6, 4, 8, 9, 10, 15));
//		INSTANCE.getMaxSortablePartitions(List.of(2, 1, 6, 4, 8, 10, 9, 15));

		// System.out.println(INSTANCE.getFirstSortablePartitionIntervalIndex(new int[]
		// { 2, 0, 1, 3, 5, 4 }));

		// INSTANCE.wiggleSort_1(new int[] { 3, 5, 2, 1, 6, 4 });
		// INSTANCE.wiggleSort_1(new int[] { 1, 5, 1, 1, 6, 4 });

		// INSTANCE.maxProductOfAnyThreeNumbers(new int[] { 6, 5, 3, 7, 4, 1, 2 });
		// INSTANCE.maxProductOfAnyThreeNumbers(new int[] { -6, -5, -3, -7, -4, -1, -2
		// });
		// INSTANCE.maxProductOfAnyThreeNumbers(new int[] { -9, -8, 7, 1, 2, 6, 3, 4, 5,
		// 7 });
//
//		int point = 17;
//		System.out.println(INSTANCE.getMinJumpsToReachAPointOnXAxis_1(point));
//		System.out.println(INSTANCE.getMinJumpsToReachAPointOnXAxis_2(point));

//		System.out.println(INSTANCE.countOfSubArraysWithBoundedMax(new int[] { 2, 1, 1, 4 }, 2, 3));
//		System.out.println(INSTANCE.countOfSubArraysWithBoundedMax(new int[] { 2, 1, 1, 4, 3 }, 2, 3));
//		System.out.println(INSTANCE.countOfSubArraysWithBoundedMax(new int[] { 7, 1, 1, 4, 3 }, 2, 3));

		// int[][] matrix = { { 11, 12, 13 }, { 21, 22, 23 }, { 31, 32, 33 } };
		// INSTANCE.transposeMatrix(matrix);
		// INSTANCE.transposeMatrixInPlaceNxN(matrix);

//		INSTANCE.shortestUnsortedContinousSubArray2(new int[] { 1, 2, 3, 6, 5, 4, 8, 11, 12, 15 });
//		INSTANCE.shortestUnsortedContinousSubArray2(new int[] { 2, 4, 6, 4, 8, 10, 9, 10, 15 });
//
//		INSTANCE.shortestUnsortedContinousSubArray3(new int[] { 1, 2, 3, 6, 5, 4, 8, 11, 12, 15 });
//		INSTANCE.shortestUnsortedContinousSubArray3(new int[] { 2, 4, 6, 4, 8, 10, 9, 10, 15 });

//		int[][] matrix = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 }, { 41, 42, 43, 44 } };
//		int[][] matrix2 = { { 41, 31, 21, 11 }, { 42, 32, 22, 12 }, { 43, 33, 23, 13 }, { 44, 34, 24, 14 } };
//		INSTANCE.rotateMatrixBy90DegreeClockwise(matrix2);

//		System.out.println("Result: " + INSTANCE.reverseVowelsOfAString("Suddenly"));
//		System.out.println("Result: " + INSTANCE.reverseVowelsOfAString("appropriate"));

//		int[][] friends = { //
//				{ 1, 0, 0, 0, 1 }, //
//				{ 0, 0, 0, 0, 0 }, //
//				{ 0, 0, 1, 0, 0 }//
//		};
//		System.out.println(
//				"TOTAL DISTANCE TRAVELLED: " + INSTANCE.getTotalDistanceTravelledToReachBestMeetingPoint(friends));

//		System.out.println(INSTANCE.getSummationOfTwoStrings("9234", "897"));

//		System.out.println(INSTANCE.getProductOfTwoStrings("5", "100"));
//		System.out.println(INSTANCE.getProductOfTwoStrings("777689", "23"));
//		System.out.println(INSTANCE.getProductOfTwoStrings("23", "777689"));

//		INSTANCE.sortArrayByParity(new int[] { 9, 3, 8, 7, 6, 2, 3 });
//		INSTANCE.sortArrayByParity(new int[] { 8, 6, 2, 7, 3, 9, 3 });
//		INSTANCE.sortArrayByParity(new int[] { 7, 3, 9, 3, 8, 6, 2, });

		// INSTANCE.mergeIntervals(new int[][] { { 1, 3 }, { 2, 4 }, { 6, 8 }, { 10, 14
		// }, { 7, 9 } });

		// System.out.println(Arrays.toString(INSTANCE.getSieveOfEratosthenes(37)));

//		System.out.println(Arrays.toString(INSTANCE.printSieveOfEratosthenesInRange(2, 37)));
//		System.out.println(Arrays.toString(INSTANCE.printSieveOfEratosthenesInRange(22, 51)));

//		INSTANCE.printProductOfTwoComplexNumbers("1+1i", "1+1i");
//		INSTANCE.printProductOfTwoComplexNumbers("2 + 3i", "2 + 4i");

//		INSTANCE.printIsPalindromeRemovingAtmost1Char("abca");
//		INSTANCE.printIsPalindromeRemovingAtmost1Char("abc");
//		INSTANCE.printIsPalindromeRemovingAtmost1Char("aba");

//		INSTANCE.carFleetProblem(new int[] { 10, 8, 0, 5, 3 }, new int[] { 2, 4, 1, 1, 3 }, 12);
//		INSTANCE.carFleetProblem(new int[] { 3 }, new int[] { 3 }, 10);
//		INSTANCE.carFleetProblem(new int[] { 0, 2, 4 }, new int[] { 4, 2, 1 }, 100);

//		INSTANCE.maxNumberFromOneSwap1("2736");
//		INSTANCE.maxNumberFromOneSwap1("1234");
//		INSTANCE.maxNumberFromOneSwap1("54321");
//		INSTANCE.maxNumberFromOneSwap1("4312");
//		INSTANCE.maxNumberFromOneSwap1("9984123594");
//		INSTANCE.maxNumberFromOneSwap1("998877665544337772");
//
//		System.out.println("----------------");

//		INSTANCE.maxNumberFromOneSwap2("2736");
//		INSTANCE.maxNumberFromOneSwap2("1234");
//		INSTANCE.maxNumberFromOneSwap2("54321");
//		INSTANCE.maxNumberFromOneSwap2("4312");
//		INSTANCE.maxNumberFromOneSwap2("9984123594");
//		INSTANCE.maxNumberFromOneSwap2("998877665544337772");

//		INSTANCE.smallestRangeCoveringElementsFromKLists1(
//				List.of(List.of(4, 10, 15, 24, 26), List.of(0, 9, 12, 20), List.of(5, 18, 22, 30)));
//		INSTANCE.smallestRangeCoveringElementsFromKLists1(
//				List.of(List.of(1, 2, 3), List.of(1, 2, 3), List.of(1, 2, 3)));
//
//		INSTANCE.smallestRangeCoveringElementsFromKLists2(
//				List.of(List.of(4, 10, 15, 24, 26), List.of(0, 9, 12, 20), List.of(5, 18, 22, 30)));
//		INSTANCE.smallestRangeCoveringElementsFromKLists2(
//				List.of(List.of(1, 2, 3), List.of(1, 2, 3), List.of(1, 2, 3)));

//		INSTANCE.minDominoRotations(new int[] { 2, 1, 2, 4, 2, 2 }, new int[] { 5, 2, 6, 2, 3, 2 });
//		INSTANCE.minDominoRotations(new int[] { 3, 5, 1, 2, 3 }, new int[] { 3, 6, 3, 3, 4 });
//
//		INSTANCE.minDominoRotations1(new int[] { 2, 1, 2, 4, 2, 2 }, new int[] { 5, 2, 6, 2, 3, 2 });
//		INSTANCE.minDominoRotations1(new int[] { 3, 5, 1, 2, 3 }, new int[] { 3, 6, 3, 3, 4 });

//		INSTANCE.print2SumSinglePair(new int[] { 2, 7, 11, 15 }, 9);
//		INSTANCE.print2SumSinglePair(new int[] { 3, 2, 4 }, 6);
//		INSTANCE.print2SumSinglePair(new int[] { 3, 3 }, 6);
//		INSTANCE.print2SumSinglePair(new int[] { 1, 2, 11, 15, 9, 7, 8, 25 }, 9);

//		INSTANCE.print2SumAllPairs(new int[] { 2, 7, 11, 15 }, 9);
//		INSTANCE.print2SumAllPairs(new int[] { 1, 1, 1, 2, 11, 15, 9, 7, 8, 8, 25 }, 9);
//		INSTANCE.print2SumAllPairs(new int[] { -4, 0, 1, 2, 11, 13, 15, 9, 7, 8 }, 9);
//
//		INSTANCE.print2SumAllUniquePairs(new int[] { 2, 7, 11, 15 }, 9);
//		INSTANCE.print2SumAllUniquePairs(new int[] { 1, 1, 1, 2, 11, 15, 9, 7, 8, 8, 25 }, 9);
//		INSTANCE.print2SumAllUniquePairs(new int[] { -4, 0, 1, 2, 11, 13, 15, 9, 7, 8 }, 9);

//		INSTANCE.minRescueBoats(new int[] { 3, 5, 3, 4 }, 5);
//		INSTANCE.minRescueBoats(new int[] { 3, 2, 2, 1 }, 3);
//		INSTANCE.minRescueBoats(new int[] { 1, 1, 2, 2 }, 3);

		// INSTANCE.print3SumAllUniquePairs(new int[] { -1, 0, 1, 2, -1, -4 }, 0);
		// System.out.println("----------");
		// INSTANCE.printKSumAllUniquePairs1(new int[] { -1, 0, 1, 2, -1, -4 }, 0, 3);

		// INSTANCE.printKSumAllUniquePairs2(new int[] { -1, 0, 1, 2, -1, -4 }, 0, 3);

//		INSTANCE.printFirstMissingPositiveInteger(new int[] { 1 });
//		INSTANCE.printFirstMissingPositiveInteger(new int[] { 0 });
//		INSTANCE.printFirstMissingPositiveInteger(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 });
//		INSTANCE.printFirstMissingPositiveInteger(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
//		INSTANCE.printFirstMissingPositiveInteger(new int[] { 1, 1 });
//		INSTANCE.printFirstMissingPositiveInteger(new int[] { 0, 0, 0, 0 });
//		INSTANCE.printFirstMissingPositiveInteger(new int[] { 1, 2, 0 });
//		INSTANCE.printFirstMissingPositiveInteger(new int[] { 3, 4, -1, 1 });
//		INSTANCE.printFirstMissingPositiveInteger(new int[] { 7, 8, 9, 11, 12 });
//		INSTANCE.printFirstMissingPositiveInteger(new int[] { -2, -5, 0, 5, 9, 8, 1, 2 });
//		System.out.println("--------");
//		INSTANCE.printFirstMissingPositiveInteger1(new int[] { 1 });
//		INSTANCE.printFirstMissingPositiveInteger1(new int[] { 0 });
//		INSTANCE.printFirstMissingPositiveInteger1(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 });
//		INSTANCE.printFirstMissingPositiveInteger1(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
//		INSTANCE.printFirstMissingPositiveInteger1(new int[] { 1, 1 });
//		INSTANCE.printFirstMissingPositiveInteger1(new int[] { 0, 0, 0, 0 });
//		INSTANCE.printFirstMissingPositiveInteger1(new int[] { 1, 2, 0 });
//		INSTANCE.printFirstMissingPositiveInteger1(new int[] { 3, 4, -1, 1 });
//		INSTANCE.printFirstMissingPositiveInteger1(new int[] { 7, 8, 9, 11, 12 });
//		INSTANCE.printFirstMissingPositiveInteger1(new int[] { -2, -5, 0, 5, 9, 8, 1, 2 });

		// INSTANCE.printPascalTriangleRow(4);

		INSTANCE.findAllDuplicatesInAnArray(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 });
		INSTANCE.findAllDuplicatesInAnArray(new int[] { 1, 1, 2 });
		INSTANCE.findAllDuplicatesInAnArray(new int[] { 1, 1, 2, 1, 1, 2, 1, 1 });
		INSTANCE.findAllDuplicatesInAnArray(new int[] { 1 });
	}

	@Override
	public void reverseArrayInPLace(int[] array) {
		int diff = array.length - 1;
		for (int i = 0; i <= (diff - 1) >> 1; i++) {
			int temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
	}

	@Override
	public int getMidValueUsingSingleIntegerDivision(int number) {
		return number + 1 / 2;
	}

	@Override
	public boolean isWordCorrectlyTypedOnFaultyKeyboard(String typedWord, String actualWord) {
		if (typedWord.length() < actualWord.length())
			return false;

		char previousActualWordChar = Character.MIN_VALUE;

		for (int i = 0, j = 0; i < typedWord.length(); i++) {
			char typedWordChar = typedWord.charAt(i);

			if (j < actualWord.length() && typedWordChar == actualWord.charAt(j)) {
				previousActualWordChar = actualWord.charAt(j);
				j++;
				continue;
			} else if (typedWordChar != previousActualWordChar) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <pre>
	 * Observation: prefix-sum propagate the value of a given-index in array to 
	 * all the next indices.
	 * 
	 * Strategy: 
	 * STEP1 : While performing the range update we mark the addition 'inc' to the startIndex, and mark the 
	 * subtraction 'inc' to endIndex+1. so that while calculating prefix-sum 'inc' will 
	 * get applied in the given range and post-range because of subtraction with 'inc'
	 * will negate the impact.
	 * 
	 * STEP2: post all range updates we will calculate the prefix-sum.
	 * 
	 * 
	 * Time-Complexity: 
	 * 1. each query takes 2-unit to perform the mark step
	 * 2. n time to calculate the prefix-sum
	 * 
	 * Total time-complexity: (2q+n) i.e. O(q+n)
	 * </pre>
	 * 
	 */
	@Override
	public int[] rangeAddition(int[] input, int[][] updateQueries) {
		for (int[] query : updateQueries)
			rangeUpdateUsingMarker(input, query[0], query[1], query[2]);
		calculatePrefixSum(input);
		return input;
	}

	private void calculatePrefixSum(int[] input) {
		for (int i = 0; i < input.length - 1; i++)
			input[i + 1] = input[i + 1] + input[i];
	}

	private void rangeUpdateUsingMarker(int[] input, int start, int end, int value) {
		input[start] += value;
		if (end + 1 < input.length)
			input[end + 1] -= value;
	}

	@Override
	public int calculateMaxAreaBetweenLines(int[] lines) {
		int area = 0;

		int leftIdx = 0;
		int rightIdx = lines.length - 1;

		while (leftIdx <= rightIdx) {
			int leftLine = lines[leftIdx];
			int rightLine = lines[rightIdx];

			if (leftLine <= rightLine) {
				area = Math.max(area, leftLine * (rightIdx - leftIdx));
				leftIdx++;
			} else {
				area = Math.max(area, rightLine * (rightIdx - leftIdx));
				rightIdx--;
			}
		}
		return area;
	}

	/**
	 * Time Complexity: O(n)
	 */
	@Override
	public int[] squaresOfSortedArray(int[] nums) {
		int[] result = new int[nums.length];

		if (nums[0] < 0) {
			int p1Idx = 0;
			int p2Idx = nums.length - 1;
			int p1Square = nums[p1Idx] * nums[p1Idx];
			int p2Square = nums[p2Idx] * nums[p2Idx];

			int i = nums.length - 1;
			while (p1Idx <= p2Idx) {
				if (p1Square >= p2Square) {
					result[i] = p1Square;
					++p1Idx;
					p1Square = nums[p1Idx] * nums[p1Idx];
				} else {
					result[i] = p2Square;
					--p2Idx;
					p2Square = nums[p2Idx] * nums[p2Idx];
				}
				--i;
			}
		} else {
			for (int i = 0; i < nums.length; i++) {
				nums[i] = nums[i] * nums[i];
			}
		}
		return result;
	}

	@Override
	public void findNBy2MajorityElementUsingBoyerMooreVotingAlgo(int[] input) {

		int candidate = findNBy2MajorityCandidate(input);

		if (Integer.MIN_VALUE != candidate) {
			if (Arrays.stream(input).filter(num -> num == candidate).count() > input.length / 2) {
				System.out.println("N/2 Majority Element: " + candidate);
				return;
			}
		}
		System.out.println("N/2 Majority Element Not Found.");
	}

	private static int findNBy2MajorityCandidate(int[] input) {
		int candidate = input[0];
		int count = 1;
		for (int i = 1; i < input.length; i++) {
			if (input[i] == candidate)
				count++;
			else if (count == 0) {
				candidate = input[i];
				count++;
			} else
				count--;

		}
		return count > 0 ? candidate : Integer.MIN_VALUE;
	}

	@Override
	public void findNBy3MajorityElementUsingBoyerMooreVotingAlgo(int[] input) {
		List<Integer> candidates = findNBy3MajorityCandidate(input);

		Iterator<Integer> iterator = candidates.iterator();
		while (iterator.hasNext()) {
			Integer candidate = iterator.next();
			if (Arrays.stream(input).filter(num -> num == candidate).count() > input.length / 3) {
				System.out.println("N/3 Majority Element: " + candidate);
			} else {
				iterator.remove();
			}
		}
		if (candidates.isEmpty())
			System.out.println("N/3 Majority Element Not Found.");
	}

	private static List<Integer> findNBy3MajorityCandidate(int[] input) {
		int candidate1 = 0;
		int count1 = 0;

		// Setting to input[0] but this is only to avoid any actual value passed as
		// input.
		int candidate2 = 0;
		int count2 = 0;

		for (int i = 1; i < input.length; i++) {
			if (input[i] == candidate1)
				count1++;
			else if (input[i] == candidate2)
				count2++;
			else {
				if (count1 == 0) {
					candidate1 = input[i];
					count1++;
				} else if (count2 == 0) {
					candidate2 = input[i];
					count2++;
				} else {
					count1--;
					count2--;
				}
			}
		}

		List<Integer> candidates = new ArrayList<>();
		if (count1 > 0)
			candidates.add(candidate1);
		if (count2 > 0)
			candidates.add(candidate2);
		return candidates;
	}

	/**
	 * Time complexity: O(n)
	 * 
	 * Space complexity: O(1)
	 */
	@Override
	public int[] productOfElementsExceptSelfUsingDivision(int[] input) {
		int zeroCount = 0;
		int multiplicationTillNow = 1;
		int zeroElementIndex = -1;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 0) {
				zeroCount++;
				zeroElementIndex = i;
				if (zeroCount == 2)
					break;
			} else {
				multiplicationTillNow = multiplicationTillNow * input[i];
			}
		}

		if (zeroCount == 2) {
			Arrays.fill(input, 0);
		} else if (zeroCount == 1) {
			Arrays.fill(input, 0);
			input[zeroElementIndex] = multiplicationTillNow;
		} else {
			for (int i = 0; i < input.length; i++)
				input[i] = multiplicationTillNow / input[i];
		}

		return input;
	}

	/**
	 * Time complexity: O(n)
	 * 
	 * Space complexity: O(n)
	 */
	@Override
	public int[] productOfElementsExceptSelfWithoutUsingDivision(int[] input) {
		int[] suffixMultiplication = new int[input.length];
		suffixMultiplication[input.length - 1] = input[input.length - 1];
		for (int i = input.length - 2; i >= 0; i--)
			suffixMultiplication[i] = suffixMultiplication[i + 1] * input[i];

		int prefixMultiplication = 1;
		for (int i = 0; i < input.length - 1; i++) {
			int currentInput = input[i];
			input[i] = prefixMultiplication * suffixMultiplication[i + 1];
			prefixMultiplication = prefixMultiplication * currentInput;
		}
		input[input.length - 1] = prefixMultiplication;
		return input;
	}

	@Override
	public List<String> getPartitionLabels(String input) {
		Map<Character, Integer> lastIndexMap = new HashMap<>();
		for (int i = 0; i < input.length(); i++)
			lastIndexMap.put(input.charAt(i), i);

		List<String> result = new ArrayList<>();

		int partitionStartIndex = 0;
		int partitionEndIndex = -1;
		for (int i = 0; i < input.length(); i++) {
			if (i == partitionEndIndex) {
				result.add(input.substring(partitionStartIndex, partitionEndIndex + 1));
				partitionStartIndex = partitionEndIndex + 1;
			} else {
				int currentChLastIndex = lastIndexMap.get(input.charAt(i));
				if (currentChLastIndex > partitionEndIndex)
					partitionEndIndex = currentChLastIndex;
			}
		}
		return result;
	}

	/**
	 * <pre>
	 * Input property: we have shuffled 0 to n-1 elements.
	 * 
	 * Algo Strategy: we will use pre-computed 'leftMax' and 'rightMin' to decide the partition
	 * position. Partition condition  'leftMax' <= 'rightMin'
	 * 
	 * 1. rightMin:
	 * Note: Index of array can be treated as 'rightMin' because all the indices ahead
	 * of given index is always greater than it.
	 * 
	 * 2.leftMax: we will calculate the leftMax on-the-fly.
	 * 
	 * 
	 * </pre>
	 * 
	 */
	@Override
	public List<String> getMaxSortablePartitionsOn0ToNMinus1Elements(List<Integer> input) {
		System.out.println("INPUT: " + input);

		List<String> partitions = new ArrayList<>();
		int leftMax = Integer.MIN_VALUE;
		int startOfPartitionIdx = 0;
		for (int i = 0; i < input.size(); i++) {
			int ci = input.get(i);
			if (ci > leftMax)
				leftMax = ci;
			// i is acting as rightMin as we have elements from 0 to n in input.
			if (i == leftMax) {
				partitions.add(input.subList(startOfPartitionIdx, i + 1).toString());
				startOfPartitionIdx = i + 1;
			}
		}
		System.out.println("Result: " + partitions);
		return partitions;
	}

	/**
	 * <pre>
	 * Observation:
	 * Example {30,10,20,40,60,50,75,70}; first partition position is 2nd index(20)
	 * For this partition to be sortable maxElement of this partition should be smaller than
	 * the minElement of the next partition.
	 * 
	 * Partition Condition: 
	 * A given candidate-index is considered for partitioning where 'leftMax' including candidate-index 
	 * is smaller than the 'rightMin' excluding the candidate-index.
	 * 
	 *   'leftMax' < 'rightMin'
	 * 
	 * </pre>
	 */
	@Override
	public List<String> getMaxSortablePartitionsBruteForce(List<Integer> input) {
		System.out.println("INPUT: " + input);
		List<String> partitions = new ArrayList<>();

		int startOfPartitionIdx = 0;
		for (int i = 0; i <= input.size() - 2; i++) {
			int leftMax = getLeftMax(startOfPartitionIdx, i, input);
			int rightMin = getRightMin(i + 1, input);

			if (leftMax < rightMin) {
				partitions.add(input.subList(startOfPartitionIdx, i + 1).toString());
				startOfPartitionIdx = i + 1;
			}
		}

		partitions.add(input.subList(startOfPartitionIdx, input.size()).toString());
		System.out.println("Result: " + partitions);
		return partitions;
	}

	private int getLeftMax(int l, int r, List<Integer> input) {
		int leftMax = Integer.MIN_VALUE;
		while (l <= r) {
			leftMax = Math.max(leftMax, input.get(l));
			l++;
		}
		return leftMax;
	}

	private int getRightMin(int l, List<Integer> input) {
		int rightMin = Integer.MAX_VALUE;
		for (int i = input.size() - 1; i >= l; i--) {
			rightMin = Math.min(rightMin, input.get(i));
		}
		return rightMin;
	}

	@Override
	public List<String> getMaxSortablePartitions(List<Integer> input) {
		System.out.println("INPUT: " + input);
		List<String> partitions = new ArrayList<>();

		// calculate the right min array.
		int[] rightMinArray = new int[input.size()];
		rightMinArray[input.size() - 1] = input.get(input.size() - 1);
		for (int i = input.size() - 2; i >= 0; i--) {
			rightMinArray[i] = Math.min(rightMinArray[i + 1], input.get(i));
		}

		int leftMax = Integer.MIN_VALUE;
		int startOfPartitionIdx = 0;
		for (int i = 0; i <= input.size() - 2; i++) {
			leftMax = Math.max(leftMax, input.get(i));
			int rightMin = rightMinArray[i + 1];

			if (leftMax < rightMin) {
				partitions.add(input.subList(startOfPartitionIdx, i + 1).toString());
				startOfPartitionIdx = i + 1;
			}
		}

		partitions.add(input.subList(startOfPartitionIdx, input.size()).toString());

		System.out.println("Result: " + partitions);
		return partitions;
	}

	@Override
	public int getFirstSortablePartitionIntervalIndex(int[] input) {
		int leftMax = Integer.MIN_VALUE;
		int partitionIdx = -1;
		int candidatePartitionLeftMax = Integer.MAX_VALUE;
		for (int i = 0; i < input.length - 2; i++) {
			leftMax = Math.max(leftMax, input[i]);
			int tempRightMax = input[i + 1];

			// if candidatePartitionLeftMax is smaller than all the right elements it means
			// current partitionIdx is valid till now.
			if (candidatePartitionLeftMax < tempRightMax)
				continue;

			if (leftMax < tempRightMax) {
				candidatePartitionLeftMax = leftMax;
				partitionIdx = i;
			}
		}
		return partitionIdx == -1 ? input.length - 1 : partitionIdx;
	}

	@Override
	public void wiggleSort_1(int[] arr) {
		System.out.println("INPUT: " + Arrays.toString(arr));

		for (int i = 0; i < arr.length - 1; i++) {
			// even index
			if (i % 2 == 0) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
			// odd index
			else if (i % 2 == 1) {
				if (arr[i] < arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}

		System.out.println("RESULT: " + Arrays.toString(arr));
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * <pre>
	 * Note: we can have -ve number.	
	 * 
	 * OBSERVATIONS:
	 * 
	 *     1. If all +ves : MAX_PRODUCT = max1 * max2 * max3
	 * 
	 *  2. If all -ves : MAX_PRODUCT = max1 * max2 * max3
	 *
	 *  3. If both +ves and -ves:
	 *   Sured to have:  max1 as +ve and min1 as -ve.
	 *
	 *  --> There is a fight between  min1min2  and  max2max3 for following cases:
	 *
	 *     CASE1: if both the products min1min2 and max2max3 are -ve
	 *     CASE2: if both the products min1min2 and max2max3 are +ve
	 *     CASE2: if any one of the products is -ve between min1min2 and  max2max3 
	 *
	 *  --> winner of this fight will get multiplied with max1 to have the max product.
	 *  It means 'max1' is getting multiplied with either min1min2 or max2max3 
	 *
	 * So, final condition of MAX_PRODUCT
	 * 
	 *  MAX_PRODUCT = Math.max(min1min2max1,  max1 * max2 * max3)
	 * 
	 * </pre>
	 */
	@Override
	public void maxProductOfAnyThreeNumbers(int[] arr) {

		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;

		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {

			int val = arr[i];

			if (val > max1) {
				max3 = max2;
				max2 = max1;
				max1 = val;
			} else if (val > max2) {
				max3 = max2;
				max2 = val;
			} else if (val > max3) {
				max3 = val;
			}

			if (val < min1) {
				min2 = min1;
				min1 = val;
			} else if (val < min2) {
				min2 = val;
			}
		}

		int prod1 = min1 * min2 * max1;
		int prod2 = max1 * max2 * max3;
		if (prod1 > prod2) {
			System.out.println(min1 + " * " + min2 + " * " + max1 + " = " + prod1);
		} else {
			System.out.println(max1 + " * " + max2 + " * " + max3 + " = " + prod2);
		}
	}

	/**
	 * k = (n*(n+1))/2
	 * 
	 * roughly, k ~= n^2, means n = sqrt(k)
	 * 
	 * Time Complexity: O(sqrt(k))
	 */
	@Override
	public int getMinJumpsToReachAPointOnXAxis_1(int p) {
		int n = 0;
		int k = 0;

		// stop when the difference of k - p becomes even.
		while (k < p || !BitwiseUtils.isEvenNumber(k - p)) {
			k = calculate1ToNThSum(++n);
		}
		return n;
	}

	private int calculate1ToNThSum(int n) {
		return (n * (n + 1)) / 2;
	}

	@Override
	public int getMinJumpsToReachAPointOnXAxis_2(int p) {
		int sumOf1ToN = 0;

		int n = 0;
		while (sumOf1ToN < p || !BitwiseUtils.isEvenNumber(sumOf1ToN - p)) {
			++n;
			sumOf1ToN = sumOf1ToN + n;
		}
		return n;
	}

	/**
	 * <pre>
	 * array :[a,b,c,d] 
	 * sub-arrays: [a], [a,b], [a,b,c], [a,b,c,d], [b], [b,c],[b,c,d] ,[c] ,[c,d], [d] 
	 * 
	 * count of sub-arrays: n*(n+1)/2
	 * 
	 * Count of sub-arrays using a particular element in [a,b,c,d]:
	 * 1. sub-array using 1st  element i.e. a' :  [a]                         ==>count & window-size : 1 
	 * 2. sub-array using 2nd  element i.e. 'b' : [a,b] [b]                   ==>count & window-size : 2 
	 * 2. sub-array using 3rd  element i.e. 'c' : [a,b,c] [b,c] [c]           ==>count & window-size : 3
	 * 2. sub-array using 4th  element i.e. 'd' : [a,b,c,d] [b,c,d] [c,d] [d] ==>count & window-size : 4
	 * 
	 * total count : 1+2+3+4 = 10 ==> summation_of_window-size
	 * 
	 * Algorithm Strategy :
	 * 
	 * 1. A sub-array calculation  window is bounded by two break-points. Break-point is any
	 * value which is greater than 'right' range.
	 * 
	 * 2. Since, sub-arrays are contiguous so, we should always count sub-arrays afresh
	 *  when we found a new window bounded by two break-points. 
	 *
	 * 3. Counting sub-arrays within a window: 
	 *    CASE A: when the window element lies in the range[left, right] both inclusive:
	 *     --The count of sub-arrays including the element will be equal to current-window-size.
	 *    CASE B: when the window element is smaller than the window's left-range: 
	 *     --The count of sub-arrays including the element will be equal to the  previous-window-size.
	 *     
	 * Example1: nums = [2,1,1,4,3], left = 2, right = 3 
	 * Here: count of sub-array for window [2,1,1] 
	 * At element '2'     : as it is in range[2,3] so count-of-sub-arrays = 1 (current-window-size)
	 *
	 * At element 1st '1' : count-of-sub-arrays = 1 as previous window-size is 1.
	 *    Since '1' cannot be used to start a new sub-array, so we can use '1' only to extend the
	 *    previous-sub-arrays here we have only [2] so we get it to [2,1].
	 *
	 * At element 2nd '1'  : count-of-sub-arrays = 1 as previous window-size is 1.
	 *    Since '1' cannot be used to start a new sub-array, so we can use '1' only to extend the
	 *    previous-sub-arrays here we have only [2,1] so we get it to [2,1,1]
	 *
	 *
	 * Example2: nums = [7,1,1,4,3], left = 2, right = 3 
	 * Here: count of sub-array for window [1,1] 
	 * At element 1st '1' : 0 , as it is starting of window itself, and is less than left-range
	 * At element 2nd '1' : 0, as previous window-size is 0.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * </pre>
	 * 
	 * @see Stack
	 *      {@link KarumanchiQuestions#printAllPossibleSubGridBlocksInMatrix(String[][])}
	 */
	@Override
	public int countOfSubArraysWithBoundedMax(int[] nums, int left, int right) {

		int windowStart = -1;

		int totalSubArrayCount = 0;
		int windowSize = 0;

		for (int i = 0; i < nums.length; i++) {
			// new sub array started.
			if (nums[i] > right) {
				windowStart = i;
				continue;
			}

			if (nums[i] >= left) {
				windowSize = (i - windowStart);
			}
			totalSubArrayCount = totalSubArrayCount + windowSize;
		}
		return totalSubArrayCount;
	}

	/**
	 * Time Complexity: O(n^2)
	 */
	@Override
	public void transposeMatrix(int[][] input) {
		int[][] output = new int[input[0].length][input.length];
		for (int row = 0; row < input.length; row++)
			for (int col = 0; col < input[0].length; col++)
				output[col][row] = input[row][col];

		for (int[] x : output)
			System.out.println(Arrays.toString(x));
		System.out.println("---------------");
	}

	/**
	 * Time Complexity: O(n^2/2)
	 */
	@Override
	public void transposeMatrixInPlaceNxN(int[][] input) {
		// N x N matrix
		for (int row = 0; row < input.length; row++) {
			for (int col = row + 1; col < input.length; col++) {
				// swap
				int temp = input[row][col];
				input[row][col] = input[col][row];
				input[col][row] = temp;
			}
		}

		for (int[] x : input)
			System.out.println(Arrays.toString(x));
		System.out.println("---------------");
	}

	/**
	 * <pre>
	 *
	 * Algorithm approach:
	 *
	 * STEP1: smallest_inversion and its insertion_position both are calculated
	 * simultaneously in single scan.
	 * 
	 * Le't assume smallest_inversion = last_element and try to form the valid inversion pair with
	 * other elements while scanning the input from right end.
	 *
	 * IF (current_element, smallest_inversion) is a valid inversion :
	 *  then insertion_position of  smallest_inversion is the current index
	 * 
	 * IF (current_element, smallest_inversion) is  not valid inversion : 
	 * means our previously assumed  smallest_inversion was wrong and current_element is
	 * smaller, so let's consider the the current_element as new smallest_inversion
	 * 
	
	 * 
	 * STEP2: largest_inversion and its insertion_position both are calculated
	 * simultaneously in single scan.
	 * 
	 *  Le't assume largest_inversion = first_element and try to form the valid inversion pair with
	 * other elements while scanning the input from left end.
	 *
	 *IF (largest_inversion, current_element) is a valid inversion :
	 *  then insertion_position of  largest_inversion is the current index
	 * 
	 * IF (largest_inversion, current_element) is not a valid inversion :
	 * means our previously assumed  largest_inversion was wrong and current_element is
	 * greater, so let's consider the the current_element as new largest_inversion
	 * </pre>
	 * 
	 * Time-Complexity : O(n)
	 */
	@Override
	public int shortestUnsortedContinousSubArray2(int[] input) {
		System.out.println("INPUT: " + Arrays.toString(input));

		int end = 0;
		int max = input[0];
		for (int i = 1; i < input.length; i++) {
			if (input[i] >= max)
				max = input[i];
			else
				end = i;
		}

		int start = 0;
		int min = input[input.length - 1];
		for (int i = input.length - 2; i >= 0; i--) {
			if (input[i] <= min)
				min = input[i];
			else
				start = i;
		}
		System.out.print("SORTABLE SUB ARRAY: ");
		for (int i = start; i <= end; i++) {
			System.out.print(input[i] + ", ");
		}
		System.out.println();
		return end - start;
	}

	/**
	 * <pre>
	 * Inversion: two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j 
	 * 
	 * Algorithm: 
	 * input              :[2,6,4,8,10,9,15]
	 * solution sub-array :[6, 4, 8, 10, 9]
	 * 
	 * How to get StartIndex  and endIndex of solution sub-array ?
	 * 
	 * STEP1: find out the smallest inversion element in input array while scanning the
	 * array from left the right
	 * Example :Inversions in input array [2,6,4,8,10,9,15] while scanning from left to right are
	 *  (6,4)-> 4 and (10,9)-> 9. So the smallest_inversion is 4. 
	 * 
	 *STEP2: get the first insertion position of smallest_inversion in input array from left side. 
	 *  This insertion position represents the startIndex. Insertion position of 4 is index 1.
	 *
	 *STEP3: find out the largest inversion element in input array while scanning the
	 * array from right to left
	 * Example :Inversions in input array [2,6,4,8,10,9,15] while scanning from right to left are
	 *  (9,10) ->10 and (4,6)-> 6. So the largest inversion is 10. 
	 *
	 *STEP2: get the first insertion position of largest_invserion in input array from right side. 
	 *  This insertion position represents the endIndex.  Insertion position of 10 is index 5.
	 * 
	 *NOTE: We can get the smallest_inversion and largest_inversion in single scan as the elements 
	 *of inversion pairs are same.
	 * </pre>
	 * 
	 * @see InversionCount
	 */
	@Override
	public int shortestUnsortedContinousSubArray3(int[] input) {
		System.out.println("INPUT: " + Arrays.toString(input));

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 1; i < input.length; i++) {
			if (input[i] < input[i - 1]) {
				min = Math.min(min, input[i]);
				max = Math.max(max, input[i - 1]);
			}
		}

		int start = 0, end = input.length - 1;
		while (input[start] <= min || input[end] >= max) {
			if (input[start] <= min)
				++start;
			if (input[end] >= max)
				end--;
		}

		System.out.print("SORTABLE SUB ARRAY: ");
		for (int i = start; i <= end; i++) {
			System.out.print(input[i] + ", ");
		}
		System.out.println();
		return end - start;
	}

	@Override
	public void rotateMatrixBy90DegreeClockwise(int[][] matrix) {
		System.out.println("INPUT MATRIX");
		for (int[] x : matrix)
			System.out.println(Arrays.toString(x));
		System.out.println("---------------------");

		System.out.println("TRANSPOSE MATRIX");
		transposeMatrixInPlaceNxN(matrix);
		for (int i = 0; i < matrix.length; i++)
			reverseArrayInPLace(matrix[i]);

		System.out.println("90 Degree rotated OUTPUT MATRIX");
		for (int[] x : matrix)
			System.out.println(Arrays.toString(x));
		System.out.println("---------------------");
	}

	@Override
	public String reverseVowelsOfAString(String input) {
		System.out.println("Input: " + input);
		Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

		char[] chars = input.toCharArray();

		int left = 0, right = chars.length - 1;
		while (left < right) {

			boolean isLeftVowel = vowels.contains(chars[left]);
			boolean isRightVowel = vowels.contains(chars[right]);

			if (isLeftVowel && isRightVowel) {
				swap(chars, left, right);
				++left;
				--right;
				continue;
			}
			if (!isLeftVowel)
				++left;
			if (!isRightVowel)
				--right;
		}
		return String.valueOf(chars);
	}

	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * 'Manhattan Distance', where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
	 * 
	 * Note : For any point in matrix row value represents X coordinate and column
	 * value represents y coordinate.
	 * 
	 * @see BestMeetingPoint.pdf
	 */
	@Override
	public int getTotalDistanceTravelledToReachBestMeetingPoint(int[][] friends) {

		List<Integer> xCoordinateList = new ArrayList<>();
		for (int row = 0; row < friends.length; row++)
			for (int col = 0; col < friends[0].length; col++)
				if (friends[row][col] == 1)
					xCoordinateList.add(row);

		List<Integer> yCoordinateList = new ArrayList<>();
		for (int col = 0; col < friends[0].length; col++)
			for (int row = 0; row < friends.length; row++)
				if (friends[row][col] == 1)
					yCoordinateList.add(col);

		int medianXCoordinate = xCoordinateList.get(xCoordinateList.size() / 2);
		int medianYCoordinate = yCoordinateList.get(yCoordinateList.size() / 2);

		System.out.println("BEST MEETING POINT: (" + medianXCoordinate + ", " + medianYCoordinate + ")");

		// Manhattan Distance
		int totalDistance = 0;
		for (int x : xCoordinateList)
			totalDistance += Math.abs(x - medianXCoordinate);
		for (int y : yCoordinateList)
			totalDistance += Math.abs(y - medianYCoordinate);

		return totalDistance;
	}

	@Override
	public String getSummationOfTwoStrings(String s1, String s2) {

		String result = "";

		int s1Idx = s1.length() - 1;
		int s2Idx = s2.length() - 1;
		int carry = 0;
		while (s1Idx >= 0 || s2Idx >= 0 || carry != 0) {
			int num1 = s1Idx >= 0 ? s1.charAt(s1Idx) - '0' : 0;
			int num2 = s2Idx >= 0 ? s2.charAt(s2Idx) - '0' : 0;

			--s1Idx;
			--s2Idx;

			int sum = num1 + num2 + carry;
			result = sum % 10 + result;
			carry = sum / 10;
		}
		return result;
	}

	@Override
	public String getProductOfTwoStrings(String s1, String s2) {
		int[] result = new int[s1.length() + s2.length()];

		int s1Idx = s1.length() - 1;
		int pf = 0;

		while (s1Idx >= 0) {

			int s2Idx = s2.length() - 1;
			int resultIdx = result.length - 1 - pf;

			int carry = 0;
			int num1 = s1.charAt(s1Idx) - '0';

			while (s2Idx >= 0 || carry != 0) {
				int num2 = s2Idx >= 0 ? s2.charAt(s2Idx) - '0' : 0;

				// adding the results along with multiplication of operands.
				int prod = num1 * num2 + carry + result[resultIdx];
				result[resultIdx] = prod % 10;
				carry = prod / 10;

				--resultIdx;
				--s2Idx;
			}
			++pf;
			--s1Idx;
		}
		return Arrays.stream(result).dropWhile(val -> val == 0).mapToObj(String::valueOf).collect(Collectors.joining());
	}

	/***
	 * <pre>
	 * To partition the array by even odd, we need to pick some partitioning algorithm.
	 * 
	 * Algorithm Strategy: 
	 * - we need to maintain odd elements window.
	 * CASE A: while moving the window ahead if next element is odd, 
	 *   then we will increase the size of odd-window by 1.
	 * CASE B: while moving the window ahead if the next element is even,
	 *   then we will swap the first element of odd-window with the 'even-element'.
	 *   This swap operation will not affect the size of window. Just the odd-window
	 *   will move one position ahead.
	 *
	 * </pre>
	 */
	@Override
	public void sortArrayByParity(int[] arr) {

		int oddWindowStartIdx = 0;
		int oddWindowEndIdx = 0;

		while (oddWindowEndIdx < arr.length) {

			if (BitwiseUtils.isEvenNumber(arr[oddWindowEndIdx])) {
				if (oddWindowStartIdx < oddWindowEndIdx) {
					swap(arr, oddWindowStartIdx, oddWindowEndIdx);
				}
				++oddWindowStartIdx;
				++oddWindowEndIdx;
			} else {
				++oddWindowEndIdx;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	@Override
	public void mergeIntervals(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

		List<int[]> mergedIntervals = new ArrayList<>();
		mergedIntervals.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {

			int[] prevInterval = mergedIntervals.get(mergedIntervals.size() - 1);
			int[] nextInterval = intervals[i];

			// nextInterval's start is overlapping previous interval's end
			if (nextInterval[0] < prevInterval[1]) {
				prevInterval[1] = Math.max(prevInterval[1], nextInterval[1]);
			} else {
				mergedIntervals.add(nextInterval);
			}
		}

		System.out.print("Input: ");
		for (int[] x : intervals) {
			System.out.print(Arrays.toString(x) + ", ");
		}
		System.out.println();

		System.out.print("Result: ");
		for (int[] x : mergedIntervals) {
			System.out.print(Arrays.toString(x) + ", ");
		}
		System.out.println("\n-------------");
	}

	/**
	 * 
	 * To find all the prime numbers less than or equal to a given integer n by
	 * Eratosthenes' method:
	 * 
	 * 1. Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
	 * 
	 * 2. Initially, let p equal 2, the smallest prime number.
	 *
	 * 3.Enumerate the multiples of p by counting in increments of p from 2p to n,
	 * and mark them in the list (these will be 2p, 3p, 4p, ...; the p itself should
	 * not be marked).
	 * 
	 * 4.Find the smallest number in the list greater than p that is not marked. If
	 * there was no such number, stop. Otherwise, let p now equal this new number
	 * (which is the next prime), and repeat from step 3.
	 * 
	 * 5.When the algorithm terminates, the numbers remaining not marked in the list
	 * are all the primes below n.
	 * 
	 * Note: As a refinement, it is sufficient to mark the numbers in step 3
	 * starting from p^2, as all the smaller multiples of p will have already been
	 * marked at that point.
	 * 
	 * <pre>
	 * How to find if a number is prime or not ?
	 * --If a number is completely divisible by any other number (except of 1 and self),
	 *  then such a number is composite-number not a prime.
	 * 
	 * Why do we need to just iterate till root(n)?
	 * 
	 * Since any composite number can be represented by p*q = composite_number, 
	 * Let's assume p >= root(number);
	 *    then q must be  <= root(number) and the number will be completely divisible by 'q'. 
	 *
	 * So we just need to iterate the loop from 2 till q(which is <= root(number)) for primality test.
	 * 
	 * 
	 * 
	 * Time Complexity: outer for loop iterates 2 to root(n); inner loop only iterates for prime number.
	 * inner loop  for  2 = n/2 (number of multiples of 2)
	 * 					3 = n/3
	 * 					5 = n/5
	 * 					7 = n/7
	 * 					--------
	 * 					n = n/root(n)
	 * 
	 * Total time complexity: n/2 + n/3 + n/5 + n/7 + ... n/root(n) = n * loglogn
	 * 
	 * 
	 * summation of inverse of prime number = loglogn
	 * 
	 * CONCLUSION STATEMENT: If we have given any number n. Now if we start placing
	 * multiple of all the prime numbers from 2 to root(n); on number line till n,
	 * then we will have only space left for un-discovered prime numbers.
	 * 
	 * In other words,multiples of consecutive prime numbers forms the natural
	 * number sequence.
	 * 
	 * Implementation Strategy:
	 * 
	 * Step1: we will generate all the prime numbers between 2 to root(n)
	 * implicitly.
	 * 
	 * Step2: we will mark all the multiples of prime number as non-prime in given
	 * range.
	 * 
	 * </pre>
	 * 
	 */
	@Override
	public int[] getSieveOfEratosthenes(int n) {
		// create the sieve of eratosthenes
		n = n + 1; // to handle index.
		BitSet sieve = new BitSet(n);
		// mark all numbers as prime. 0, 1 are not primes so starting from 2.
		// can be optimzed if we consider prime as false and non-prime as true by which
		// below step will not be needed.
		sieve.set(2, n, true);

		// loop iterates till root(n)
		for (int i = 2; i * i < n; i++) {
			if (sieve.get(i) == true) {
				// mark the multiple of i as non prime number. For i*i read note.
				for (int j = i * i; j < n; j += i) {
					sieve.clear(j);
				}
			}
		}
		// System.out.println(sieve);
		return sieve.stream().toArray();
	}

	/**
	 * 
	 * Algorithm strategy will be based on following statement:
	 * 
	 * CONCLUSION STATEMENT: If we have given any number n. Now if we start placing
	 * multiple of all the prime numbers from 2 to root(n); on number line till n,
	 * then we will have only space left for un-discovered prime numbers.
	 *
	 * Implementation Strategy:
	 *
	 * Step1: we will generate all the prime numbers between 2 to root(n)
	 * explicitly.
	 * 
	 * Step2: we will mark all the multiples of prime number as non-prime in given
	 * range.
	 * 
	 */
	@Override
	public int[] printSieveOfEratosthenesInRange(int start, int end) {
		int[] primesTillRootOfEnd = getSieveOfEratosthenes((int) Math.sqrt(end));

		int range = end - start + 1;
		// in this sieve false means prime number and true means non prime number.
		BitSet sieve = new BitSet(range);

		for (int prime : primesTillRootOfEnd) {

			int kthFactor = start / prime;
			if (start % prime != 0)
				kthFactor += 1;

			int firstMultiple = kthFactor * prime;
			int idx = firstMultiple - start;

			// if first multiple itself is prime then skip it and go to next multiple of
			// prime.
			if (firstMultiple == prime)
				idx += prime;

			while (idx < range) {
				sieve.set(idx);
				idx = idx + prime;
			}
		}

		// in this sieve false means prime number and true means non prime number so
		// flipping it to get prime numbers.
		sieve.flip(0, range);
		return sieve.stream().map(i -> start + i).toArray();
	}

	/**
	 * <pre>
	 * num1 = a + b*i
	 * num2 = c + d*i
	 * 
	 * num1* num2 = (a + bi) + (c + di)  = ac +adi + bic + bidi
	 *            = (ac + bdii) + (ad + bc)*i 
	 *
	 *  num1* num2 = (ac - bd) + (ad + bc)*i
	 * </pre>
	 */
	@Override
	public void printProductOfTwoComplexNumbers(String num1, String num2) {
		String[] num1Tokens = null;
		if (num1.contains("+"))
			num1Tokens = num1.split(Pattern.quote("+"));
		else if (num1.contains("-"))
			num1Tokens = num1.split(Pattern.quote("-"));
		else
			throw new IllegalArgumentException("Invalid input");

		String[] num2Tokens = null;
		if (num2.contains("+"))
			num2Tokens = num2.split(Pattern.quote("+"));
		else if (num1.contains("-"))
			num2Tokens = num2.split(Pattern.quote("-"));
		else
			throw new IllegalArgumentException("Invalid input");

		int a = Integer.valueOf(num1Tokens[0].trim());
		int c = Integer.valueOf(num2Tokens[0].trim());

		int b = Integer.valueOf(num1Tokens[1].replace("i", "").trim());
		int d = Integer.valueOf(num2Tokens[1].replace("i", "").trim());

		int realPart = (a * c - b * d);
		int imaginaryPart = (a * d + b * c);

		System.out.println(realPart + " + " + imaginaryPart + "i");

	}

	@Override
	public void printIsPalindromeRemovingAtmost1Char(String input) {
		int start = 0;
		int end = input.length() - 1;

		boolean isPalindromeAfterSkipping = false;
		while (start < end) {
			if (input.charAt(start) != input.charAt(end)) {
				System.out.println("Is " + input + " a palindrome after skipping " + input.charAt(start) + " at index "
						+ start + "?? " + isPalindrome(input, start + 1, end));
				System.out.println("Is " + input + " a palindrome after skipping " + input.charAt(start) + " at index "
						+ end + "?? " + isPalindrome(input, start, end - 1));
				isPalindromeAfterSkipping = true;
				break;
			} else {
				++start;
				--end;
			}
		}
		if (!isPalindromeAfterSkipping && start == end) {
			System.out.println(input + " is a palindrome without removing any character.");
		}
	}

	private static boolean isPalindrome(String str, int start, int end) {
		while (start < end) {
			if (str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

	@Override
	public void carFleetProblem(int[] position, int[] speed, int target) {
		record Car(int position, int timeToTarget) {
		}

		Car[] cars = new Car[position.length];
		for (int i = 0; i < position.length; i++)
			cars[i] = new Car(position[i], (target - position[i]) / speed[i]);

		Arrays.sort(cars, Comparator.comparingInt(Car::position));

		// considering last car as a fleet.
		int fleetCount = 1;
		for (int i = cars.length - 2; i >= 0; i--) {

			if (cars[i].timeToTarget <= cars[i + 1].timeToTarget) {
				// as cars[i] is the faster car but it is joining the fleet of cars[i+1]
				cars[i] = cars[i + 1];
			} else {
				fleetCount++;
			}
		}
		System.out.println(fleetCount);
	}

	// 998877665544337772
	@Override
	public void maxNumberFromOneSwap1(String number) {
		System.out.println("Input: " + number);

		char[] chars = number.toCharArray();
		int[] idxOfMaxFromRight = new int[chars.length];
		idxOfMaxFromRight[chars.length - 1] = chars.length - 1;
		int runningMax = chars[chars.length - 1] - '0';
		int runningMaxIdx = chars.length - 1;

		for (int i = chars.length - 2; i >= 0; i--) {
			int curr = chars[i] - '0';
			if (curr > runningMax) {
				runningMax = curr;
				runningMaxIdx = i;
			}
			idxOfMaxFromRight[i] = runningMaxIdx;
		}
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != chars[idxOfMaxFromRight[i]]) {
				swap(chars, i, idxOfMaxFromRight[i]);
				break;
			}
		}
		System.out.println("Result: " + String.valueOf(chars));
	}

	/**
	 * example "889977665544337772"
	 * 
	 * <pre>
	 * Algo strategy: 
	 * 
	 * nonSwappableWindow : contiguous elements greater than the max-element 
	 * seen so far. 
	 * 
	 * swappableWindow : contiguous elements smaller than the max-element 
	 * seen so far. 
	 * 
	 * max candidate element =  maximum element from the previous nonSwappableWindow
	 * 
	 * 
	 * We will scan the elements from end of array:
	 * 
	 * CASE A: If we encounter nonSwappableWindow: 
	 *    --keep on updating the nonSwappableWindowMax and  nonSwappableWindowMaxIdx.
	 * CASE B: If we encounter  swappableWindow :
	 *    -- mark the swappable window start with current position.
	 *    -- mark the  maxCandidateIdx with previous  nonSwappableWindowMaxIdx.
	 * 
	 * </pre>
	 * 
	 */
	@Override
	public void maxNumberFromOneSwap2(String number) {
		System.out.println("Input: " + number);
		char[] chars = number.toCharArray();

		int nonSwappableWindowMax = -1;
		int nonSwappableWindowMaxIdx = -1;
		int swappableWindowStartIdx = -1;
		int maxSwappableElementIdx = -1;
		for (int i = chars.length - 1; i >= 0; i--) {
			int current = chars[i] - '0';
			if (current > nonSwappableWindowMax) {
				nonSwappableWindowMax = current;
				nonSwappableWindowMaxIdx = i;
			} else if (current < nonSwappableWindowMax) {
				swappableWindowStartIdx = i;
				maxSwappableElementIdx = nonSwappableWindowMaxIdx;
			}
		}
		if (swappableWindowStartIdx != -1 && maxSwappableElementIdx != -1)
			swap(chars, swappableWindowStartIdx, maxSwappableElementIdx);

		System.out.println("Result: " + String.valueOf(chars));
	}

	/**
	 * <pre>
	 * Algo strategy: 
	 * 
	 * 
	 * Step1: Create a Pointer record to hold the list-index, num-index and num.
	 * Step2: Create the list of size k to hold the pointers to prepare the range.
	 * 
	 * Step3: Initialize the rangePointers for comparison:
	 * ---pick first elements from each k list.
	 * ---find max and min element and create the maxPointer and minPointer
	 * ---calculate the range gap = (max - min).
	 *
	 * Step4: pick the next element from minPointer list and repeat the Step3 to compare with 
	 * previously calculated gap.
	 * 
	 * Time Complexity: 
	 * 
	 * -- Time taken to calculate the minPointer and maxPointer is
	 *    K as length of rangePointerList is K. 
	 * 
	 * -- Lets assume total count of elements
	 *    are n(including all the lists) Since we are calculating the minPointer and
	 *    maxPointer for almost all the elements, so:
	 * 
	 * Time Complexity : n * k
	 * 
	 * </pre>
	 */
	@Override
	public void smallestRangeCoveringElementsFromKLists1(List<List<Integer>> kLists) {

		int minlowerBound = 0;
		int minUpperBound = 0;
		int gap = Integer.MAX_VALUE;

		final record Pointer(int listIdx, int numIdx, int num) {
		}
		List<Pointer> elements = new ArrayList<>();

		for (int i = 0; i < kLists.size(); i++)
			elements.add(new Pointer(i, 0, kLists.get(i).get(0)));

		// This loop iterates for almost all elements (k*n times)
		while (true) {

			// takes k time
			Pointer min = Collections.min(elements, Comparator.comparing(Pointer::num));
			Pointer max = Collections.max(elements, Comparator.comparing(Pointer::num));

			int currentGap = max.num - min.num;

			if (currentGap < gap) {
				minlowerBound = min.num;
				minUpperBound = max.num;
				gap = currentGap;
			}

			// move ahead list
			List<Integer> minList = kLists.get(min.listIdx);
			if (min.numIdx + 1 == minList.size()) {
				break;
			}

			elements.set(min.listIdx, new Pointer(min.listIdx, min.numIdx + 1, minList.get(min.numIdx + 1)));
		}

		System.out.println("lower: " + minlowerBound + ", upper: " + minUpperBound + ", gap: " + gap);
	}

	@Override
	public void smallestRangeCoveringElementsFromKLists2(List<List<Integer>> kLists) {
		int minlowerBound = 0;
		int minUpperBound = 0;
		int gap = Integer.MAX_VALUE;

		final record Pointer(int listIdx, int numIdx, int num) {
		}
		Queue<Pointer> elements = new PriorityQueue<>(Comparator.comparing(Pointer::num));

		Pointer max = null;

		for (int i = 0; i < kLists.size(); i++) {
			Pointer elementPointer = new Pointer(i, 0, kLists.get(i).get(0));
			elements.offer(elementPointer);
			if (max == null || elementPointer.num > max.num)
				max = elementPointer;
		}

		// This loop iterates for almost all elements (k*n times)
		while (true) {
			// O(1)
			Pointer min = elements.poll();

			int currentGap = max.num - min.num;

			if (currentGap < gap) {
				minlowerBound = min.num;
				minUpperBound = max.num;
				gap = currentGap;
			}

			// move ahead list
			List<Integer> minList = kLists.get(min.listIdx);
			if (min.numIdx + 1 == minList.size()) {
				break;
			}

			Pointer nextPointer = new Pointer(min.listIdx, min.numIdx + 1, minList.get(min.numIdx + 1));
			if (nextPointer.num > max.num) {
				max = nextPointer;
			}

			// O(logk)
			elements.offer(nextPointer);
		}

		System.out.println("lower: " + minlowerBound + ", upper: " + minUpperBound + ", gap: " + gap);
	}

	/**
	 * <pre>
	 * Algo Strategy:
	 * 
	 * Which all elements should be consider for equal row ?
	 * 
	 * Any domino top-bottom pair can be consider for equal row.
	 * 
	 * Total possibilities for equal row :
	 * 
	 * On top 2 possibilities: 
	 *       -- domino-top itself
	 *       -- domino bottom
	 * 
	 *On bottom 2 possibilities: 
	 *       -- domino-bottom itself
	 *       -- domino top
	 * </pre>
	 * 
	 * Time Complexity: O(n)
	 * 
	 */
	@Override
	public void minDominoRotations(int[] tops, int[] bottoms) {
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
		int num1 = tops[0];
		int num2 = bottoms[0];

		for (int i = 0; i < tops.length; i++) {

			// CASE 1: num1 should be at top, swap will occur only if num1 not at top but at
			// bottom.
			if (count1 != -1)
				if (tops[i] != num1 && num1 == bottoms[i])
					count1++;
				else if (tops[i] != num1 && bottoms[i] != num1)
					count1 = -1;

			// CASE 2: num1 should be at bottom, swap will occur only if num1 not at bottom
			// but at top.
			if (count2 != -1)
				if (bottoms[i] != num1 && num1 == tops[i])
					count2++;
				else if (tops[i] != num1 && bottoms[i] != num1)
					count2 = -1;

			// CASE 3: num2 should be at bottom, swap will occur only if num2 not at bottom
			// but at top.
			if (count3 != -1)
				if (num2 != bottoms[i] && tops[i] == num2)
					count3++;
				else if (tops[i] != num2 && bottoms[i] != num2)
					count3 = -1;

			// CASE 4: num2 should be at top.
			if (count4 != -1)
				if (num2 != tops[i] && bottoms[i] == num2)
					count4++;
				else if (tops[i] != num2 && bottoms[i] != num2)
					count4 = -1;

		}
		int minSwaps = IntStream.of(count1, count2, count3, count4).filter(i -> i != -1).min().orElseGet(() -> -1);
		System.out.println(minSwaps);
	}

	/**
	 * <pre>
	 * 
	 * 
	 * OBSERVATION_1: At max 2 element domino can exits because any one of the element
	 *  of top-bottom pair has to be in domino formation.
	 * 
	 * OBSERVATION_2 : If both tops and  bottoms are already domino(means equal row) 
	 *  then there will be 0 swaps and two domino solutions.
	 *       Example: tops = [2,2,2,2,2,2]  bottoms = [1,1,1,1,1,1]
	 *
	 *OBSERVATION_3 : In all other cases there can only be two possibilities:
	 *  -- ZERO solution exists
	 *
	 *      Example: tops = [2,3,4,2,2,2]  bottoms = [1,1,5,1,1,1]
	 *
	 *  -- or  SINGLE element domino/TWO element domino can exist.
	 *
	 *      Example of Single element domino: tops = [2,1,2,4,2,2]  bottoms =[5,2,6,2,3,2]
	 *       domino1: tops[2,2,2,2,2,2]  bottoms[5,1,6,4,3,2]  : total swaps = 2
	 *       domino2: tops[5,1,6,4,3,2]  bottoms[2,2,2,2,2,2]  : total swaps = 3
	 *
	 *      Example of two element domino: tops = [3,4,3,4,3,4]  bottoms =[4,3,4,3,4,3] 
	 *       domino1: tops[3,3,3,3,3,3]  bottoms[4,4,4,4,4,4]  : total swaps = 3
	 *       domino2: tops[4,4,4,4,4,4]  bottoms[3,3,3,3,3,3]  : total swaps = 3
	 *
	 * 
	 * Alog strategy: 
	 * 
	 * STEP1: We need to find out which element is forming domino ?
	 * 
	 *  IF(top_count(i)  + bottom_count(i) - sameTopBottomCount(i) == array_size)
	 *     ==> means ith element can form domino
	 *
	 *   NOTE: When 2 distinct elements are forming domino then swap counts are same 
	 *   for both the elements. Since we need minimum swap domino so we can pick either of the solution element.
	 *
	 *
	 *STEP2: need to count minimum swaps
	 *
	 *       array_size -  Math.Max(top_count(i) - bottom_count(i))
	 *
	 * </pre>
	 * 
	 * Time Complexity: O(n)
	 */
	@Override
	public void minDominoRotations1(int[] tops, int[] bottoms) {
		// length 7 because dice has only numbers 1,2,3,4,5,6. 0th space in array not
		// being used.
		int[] countTops = new int[7];
		int[] countBottoms = new int[7];
		int[] same = new int[7];

		//
		for (int i = 0; i < tops.length; ++i) {
			++countTops[tops[i]];
			++countBottoms[bottoms[i]];

			if (tops[i] == bottoms[i])
				++same[tops[i]];
		}
		int minSwaps = -1;

		// Only numbers 1 to 6 can be domino candidates.
		for (int i = 1; i <= 6; ++i)
			// If 'i' is available throughout the row (tops.length) either at top or bottom,
			// then domino can be created by swapping operation.
			if (countTops[i] + countBottoms[i] - same[i] == tops.length)

				/**
				 * Math.max(countTops[i], countBottoms[i])
				 * 
				 * Determining which count is lesser, swapping tops to bottoms OR swapping
				 * bottoms to tops.
				 * 
				 * if 'i' is present more times at tops, then bottoms 'i' will be swapped to
				 * tops.
				 * 
				 * if 'i' is present more times at bottoms, then tops 'i' will be swapped to
				 * bottoms.
				 * 
				 * Once, that is determined we just get difference of length of row and the
				 * number of 'i' already present in row, so we can get how many swaps needed to
				 * get 'i' in remaining slots of the row.
				 */
				minSwaps = tops.length - Math.max(countTops[i], countBottoms[i]);

		System.out.println(minSwaps);
	}

	static final record Pair(int num1, int num2) {
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[").append(num1).append(", ").append(num2).append("]");
			return builder.toString();
		}
	}

	@Override
	public Pair print2SumSinglePair(int[] nums, int target) {
		// key: difference, value: index
		Map<Integer, Integer> diffs = new HashMap<>();
		Pair sumPair = null;
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (diffs.containsKey(nums[i])) {
				sumPair = new Pair(diffs.get(nums[i]), i);
				break;
			}
			diffs.put(diff, i);
		}
		System.out.println(sumPair);
		return sumPair;
	}

	@Override
	public List<Pair> print2SumAllPairs(int[] nums, int target) {
		Arrays.sort(nums);

		List<Pair> pairs = new ArrayList<>();

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int sum = nums[left] + nums[right];

			if (sum == target) {
				pairs.add(new Pair(nums[left], nums[right]));
				++left;
				--right;
			} else if (sum > target) {
				--right;
			} else if (sum < target) {
				++left;
			}
		}
		System.out.println(pairs);
		return pairs;
	}

	@Override
	public List<Pair> print2SumAllUniquePairs(int[] nums, int target) {
		Arrays.sort(nums);

		List<Pair> pairs = new ArrayList<>();

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			if (left != 0 && nums[left] == nums[left - 1]) {
				++left;
				continue;
			}

			int sum = nums[left] + nums[right];

			if (sum == target) {
				pairs.add(new Pair(nums[left], nums[right]));
				++left;
				--right;
			} else if (sum > target) {
				--right;
			} else if (sum < target) {
				++left;
			}
		}
		System.out.println(pairs);
		return pairs;
	}

	/**
	 * 
	 * */
	@Override
	public void minRescueBoats(int[] people, int limit) {
		Arrays.sort(people);

		int start = 0;
		int end = people.length - 1;
		int rescueBoatCount = 0;

		while (start <= end) {
			if (people[end] + people[start] <= limit) {
				--end;
				++start;
			} else {
				--end;
			}
			++rescueBoatCount;
		}
		System.out.println(rescueBoatCount + " boats will be required to rescue the people.");
	}

	@Override
	public void print3SumAllUniquePairs(int[] nums, int target) {
		Arrays.sort(nums);

		List<int[]> threeSumPairs = new ArrayList<>();

		for (int i = 0; i <= nums.length - 3; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;

			int fixedElement = nums[i];

			List<Pair> twoSumPairs = print2SumAllUniquePairs(Arrays.copyOfRange(nums, i + 1, nums.length),
					target - fixedElement);

			twoSumPairs.forEach((pair) -> {
				threeSumPairs.add(new int[] { fixedElement, pair.num1, pair.num2 });
			});
		}

		System.out.println("print3SumAllUniquePairs ANSWER:");
		for (int[] pair : threeSumPairs)
			System.out.println(Arrays.toString(pair));

	}

	@Override
	public void printKSumAllUniquePairs1(int[] nums, int target, int k) {
		Arrays.sort(nums);
		printKSumAllUniquePairs1(nums, target, k, 0, 0, new ArrayList<>(), new HashSet<>());
	}

	/**
	 * @see CombinationQuestion#printTargetSumCombination
	 */
	private void printKSumAllUniquePairs1(int[] nums, int target, int k, int idx, int sumTillNow,
			List<Integer> pairElements, Set<String> duplicateSet) {
		if (sumTillNow > target && k == 0)
			return;

		if (sumTillNow == target && k == 0) {
			String pairString = pairElements.stream().map(String::valueOf).collect(Collectors.joining());
			if (!duplicateSet.contains(pairString))
				System.out.println(pairElements);
			duplicateSet.add(pairString);
			return;
		}

		for (int i = idx; i < nums.length; i++) {
			Integer current = nums[i];
			pairElements = new ArrayList<>(pairElements);
			pairElements.add(current);
			printKSumAllUniquePairs1(nums, target, k - 1, i + 1, sumTillNow + current, pairElements, duplicateSet);
			pairElements.remove(current);
		}

	}

	@Override
	public void printKSumAllUniquePairs2(int[] nums, int target, int k) {
		Arrays.sort(nums);
		List<List<Integer>> result = getKSumAllUniquePairs2(nums, target, k, 0);
		System.out.println("printKSumAllUniquePairs2 ANSWER" + result);
	}

	private List<List<Integer>> getKSumAllUniquePairs2(int[] nums, int target, int k, int idx) {
		List<List<Integer>> result = new ArrayList<>();

		if (k == 2) {
			List<Pair> twoPairs = print2SumAllUniquePairs(Arrays.copyOfRange(nums, idx, nums.length), target);
			twoPairs.forEach(pair -> {
				result.add(new ArrayList<>(List.of(pair.num1, pair.num2)));
			});
			return result;
		}

		if (nums.length - idx < k) {
			return result;
		}

		for (int i = idx; i < nums.length - k; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;

			int fixedElement = nums[i];
			List<List<Integer>> subList = getKSumAllUniquePairs2(nums, target - fixedElement, k - 1, idx + 1);

			subList.forEach((pair) -> {
				pair.add(fixedElement);
				result.add(pair);
			});
		}
		return result;
	}

	/**
	 * <pre>
	 * Algorithm strategy:
	 * STEP_1: Place each number lying in range [1..n] at its bucket location.
	 * For example: When we find 5; its bucket location is 4 in zero based indexing. 
	 * So we swap 5 with nums[4].
	 * 
	 * STEP_2:Find the first place where its number is not at its right bucket, return the bucket_index + 1.
	 * 
	 * 
	 * 
	 * Time Complexity: O(3n) = O(n)
	 * 
	 * Time taken by STEP_1:
	 *  In worst case while-loop can traverse to n, If while-loop traverses to n then 
	 * outer-for will not enter inside the while-loop as all the elements will at its bucket location
	 * So, the time taken will be at max 2n: n-> used by inner-while-loop and n-> used by outer-for-loop
	 * 
	 * Time taken by STEP_2: n
	 * 
	 * </pre>
	 */
	@Override
	public void printFirstMissingPositiveInteger(int[] nums) {
		System.out.print("Input: " + Arrays.toString(nums) + ", ");

		int n = nums.length;
		// Say if 1,2,4 are elements in nums array, then 1 is being brought to 0th
		// index, 2 to 1st index and 4 to 3rd index. and so on. This is being done only
		// for elements between 1 and n as missing number can only be between 1 and n
		// So, nums[nums[i] - 1] is 0 based location for nums[i]
		for (int i = 0; i < n; ++i)
			while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1])
				swap(nums, i, nums[i] - 1);

		int missingNumber = n + 1;

		// Now, we loop from 1 to n and the first place where index+1 != num will be our
		// answer.
		for (int i = 0; i < n; ++i)
			if (nums[i] != i + 1) {
				missingNumber = i + 1;
				break;
			}

		System.out.println("missingNumber: " + missingNumber);
	}

	/**
	 * <pre>
	 * 
	 * The basic idea is that we have an array with n cells (n is the length of the array). 
	 * If an integer is missing it must be in the range [1..n]. 
	 * This is the crucial observation we use to deduce the algorithm. 
	 * This means that the range of possible answers is [1..n] if an integer is missing, 
	 * and if an integer is not missing then the answer is n+1.
	 *
	 * Let's picture the only two possibilities:
	 *
	 * - there is no missing integer in the array
	 * - there is a missing integer in the array.
	 * 
	 * If there is no missing integer, this means that the array has all number from 1 to n. This must mean that the array is full. 
	 * Why, because in the range [1..n] there are exactly n numbers, and if you place n numbers in an array of length n, 
	 * the array is by definition full. (in this case solution is to return n+1 which is the first smallest integer).
	 *	
	 * Once you understand the first case above understanding the second is easy. 
	 * If there is a missing integer (or more than one), the missing integer(s), 
	 * let's call it X, must be in the range 1..n. Why, because if the missing integer X is not in the range [1..n] 
	 * that would imply that all integers [1..n] are in the array, which would mean that the array is full, 
	 * leaving no space where to place X (since X is not in the range [1..n]).
	 *	
	 * Then the algorithm becomes:
	 *	
	 *	1- 	Ignore all numbers <= 0 and > n since they are outside the range of possible answers (which we proved was [1..n]). 
	 *		We do this by replacing them with the value n+1.
	 *
	 *	2- 	For all other integers <n+1, mark their bucket (cell) to indicate the integer exists. (*see below)
	 *
	 *	3- 	Find the first cell not marked, that is the first missing integer. If you did not find an unmarked cell, 
	 *		there was no missing integer, so return n+1.
	 *
	 * Time Complexity : 3 loops for 3 steps
	 *                 : O(3n) == O(n)
	 * 
	 * </pre>
	 */
	@Override
	public void printFirstMissingPositiveInteger1(int[] nums) {
		System.out.print("Input: " + Arrays.toString(nums) + ", ");

		int n = nums.length;

		// 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
		// we can ignore those because if all number are > n then well simply return 1
		for (int i = 0; i < n; i++) {
			if (nums[i] < 1 || nums[i] > n) {
				nums[i] = n + 1;
			}
		}

		// note: all number in the array are now positive, and on the range 1..n+1
		// 2. mark each cell appearing in the array, by converting the index for that
		// number to negative
		for (int i = 0; i < n; i++) {
			int current = Math.abs(nums[i]);
			if (current > n)
				continue;

			current--; // -1 for zero index based array (so the number 1 will be at pos 0)
			if (nums[current] > 0) // prevents double negative operations
				nums[current] = -1 * nums[current];
		}

		// if no positive numbers are found, it means the array contains all numbers
		// 1..n, so missing number will be n + 1;
		int missingNumber = n + 1;

		// 3. find the first cell which isn't negative (doesn't appear in the array)
		for (int i = 0; i < n; i++) {
			if (nums[i] >= 0) {
				missingNumber = i + 1;
				break;
			}
		}
		System.out.println("missingNumber: " + missingNumber);
	}

	/**
	 * <pre>
	 * 
	 * 0-row-> 0C0
	 * 1-row-> 1C0,1C1
	 * 2-row-> 2C0,2C1,2C2
	 * 3-row-> 3C0,3C1,3C2,3C3
	 * 4-row-> 4C0,4C1,4C2,4C3,4C4
	 *
	 * How to derive  next term using previous term i.e nCr+1 from nCr ?
	 * 
	 * Let's assume nCr is multiplied by a factor F to get nCr+1;
	 * i.e    nCr*F = nCr+1
	 * post solving the above equation by expanding the factorials: F = (n-r)/(r+1)
	 * 
	 * As a rule of thumb in counting theory we have all non-fractional entities.
	 * 
	 * So: previousTerm F will always be non-fractional even when F is fractional.
	 * 
	 * </pre>
	 */
	@Override
	public void printPascalTriangleRow(int row) {

		int term = 1;
		int n = row;

		System.out.print(term + " ,");
		for (int r = 0; r < row; r++) {
			term = (term * (n - r)) / (r + 1);
			System.out.print(term + " ,");
		}
	}

	@Override
	public void findAllDuplicatesInAnArray(int[] nums) {
		Set<Integer> duplicates = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			// -1 for 0 based indexing
			int index = Math.abs(nums[i]) - 1;

			if (nums[index] < 0)
				duplicates.add(Math.abs(nums[i]));
			else
				nums[index] = -1 * nums[index];
		}
		System.out.println(duplicates);
	}

	@Override
	public List<String> findAndReplacePattern(String[] words, String pattern) {

		List<String> matchingStrings = new ArrayList<>();

		for (String word : words) {

		}

		return matchingStrings;
	}

}
