package edu.sau.algo.permcomb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <pre>
 * https://introcs.cs.princeton.edu/java/23recursion/
 * 
 *Efficient Algorithm:
 * BR HEAPS ALGO : 
 * https://en.wikipedia.org/wiki/Heap%27s_algorithm
 * https://www.baeldung.com/java-array-permutations
 * </pre>
 * 
 */
public class PermutationSolution implements PermutationQuestion {

	private static final PermutationSolution INSTANCE = new PermutationSolution();

	public static void main(String[] args) {

		// INSTANCE.printPermutationsOfString("abc", "");

		// INSTANCE.printPermutationsOfArray1("abc".toCharArray(), new char[3], 0);
		// INSTANCE.printPermutationsOfArray2("abc".toCharArray(), 0);
		// INSTANCE.printPermutationsOfArray3("abc".toCharArray(), 3);

		// INSTANCE.printPermutationsOfArrayUsingSJT1(new int[] { 1, 2, 3 });

		// INSTANCE.permutationsWithAdjacentNonRepeatableSwaps1("12345");
		// INSTANCE.permutationsWithAdjacentNonRepeatableSwaps2("12345");
		// INSTANCE.permutationsWithAdjacentNonRepeatableSwaps3("12345");

		// INSTANCE.printNextLexicographicPermutation("12345");
		// INSTANCE.printNextLexicographicPermutation("12354");
		// INSTANCE.printNextLexicographicPermutation("54321");

		// INSTANCE.printKthLexicographicPermutation("12345", 67);
		// INSTANCE.printKthLexicographicPermutation("12345", 1);

		// INSTANCE.printAllPermutationsInLexicographicOrder1("12345");
		// INSTANCE.printAllPermutationsInLexicographicOrder2("12345");
		INSTANCE.printAllPermutationsInLexicographicOrder3("12345");
	}

	private void swap(char[] input, int i, int j) {
		char c = input[i];
		input[i] = input[j];
		input[j] = c;
	}

	/**
	 * print n! permutation of the characters of the string (in order)
	 * 
	 * Time Complexity : @See "printPermutationsOfArray2"
	 * 
	 * Space Complexity : At each node of tree we are creating one output string. In
	 * a single path we have n nodes. Total paths = n! Space complexity of
	 * output-string = (n string)* (n! path) = O(n*n!) Similarly, Space complexity
	 * of input-string = O(n*n!)
	 * 
	 * Total Space Complexity = O(n*n!)
	 */
	@Override
	public void printPermutationsOfString(String input, String output) {

		if (input.isEmpty()) {
			System.out.println(output);
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			printPermutationsOfString(input.substring(0, i) + input.substring(i + 1), output + input.charAt(i));

		}
	}

	/**
	 * print n! permutation of the characters of array (in order)
	 * 
	 * Time Complexity : @See "printPermutationsOfArray2"
	 * 
	 * Space Complexity : extra space for output array O(n)
	 * 
	 */
	@Override
	public void printPermutationsOfArray1(char[] input, char[] output, int outPos) {

		if (outPos == output.length) {
			System.out.println(String.valueOf(output));
			return;
		}

		for (int i = 0; i < input.length; i++) {
			if (input[i] == Character.MIN_VALUE) {
				continue;
			}

			char ch = input[i];
			output[outPos] = ch;
			input[i] = Character.MIN_VALUE;

			printPermutationsOfArray1(input, output, outPos + 1);

			input[i] = ch;
		}
	}

	/**
	 * Strategy: permutation generation by swapping the first-element with other
	 * elements(left to right)
	 * 
	 * 
	 * Approximate Time Complexity calculation : O(n*n!) Depth of the tree is n, so
	 * to reach any of the leaf node we need to traverse n steps. And there are n!
	 * leaf nodes.
	 * 
	 * Space Complexity : O(1)
	 * 
	 * Accurate Time Complexity calculation : Let's assume each recursive method
	 * invocation represents 1 unit of task. Then total number of method invocation
	 * represents the time-complexity.
	 * 
	 * Total number of leaf-nodes = n! = n!/1; Total number of nodes at 1 level
	 * below leaf-nodes = n!/2 = n!/1*2 Total number of nodes at 2 level below
	 * leaf-nodes = (n!/2)/3 = n!/1*2*3 Total number of nodes at 3 level below
	 * leaf-nodes = ((n!/2)/3)4 = n!/1*2*3*4
	 * 
	 * So, total number of nodes in the tree = n! + n!/1*2 + n!/1*2*3 + n!/1*2*3*4 +
	 * .. + n!/n! = n!(1 + 1/1*2 + 1/1*2*3 + 1/1*2*3*4 + .. +1/n!) =~ n!(1+1) = 2n!
	 * 
	 */
	@Override
	public void printPermutationsOfArray2(char[] input, int position) {
		// Single element at last position is fixed in itself, so we can avoid self-swap
		// at last position by checking (position == input.length - 1) instead of
		// (position == input.length)
		if (position == input.length - 1) {
			System.out.println(String.valueOf(input));
			return;
		}

		for (int i = position; i < input.length; i++) {
			swap(input, position, i);
			printPermutationsOfArray2(input, position + 1);
			swap(input, position, i);
		}
	}

	/**
	 * Strategy: permutation generation by swapping the last-element with other
	 * elements(right to left)
	 * 
	 * print n! permutation of the characters of array (not in order)
	 * 
	 * @param n is length of the input
	 * 
	 *          Time Complexity : O(n*n!) Depth of the tree is n, so to reach any of
	 *          the leaf node we need to traverse n steps. And there are n! leaf
	 *          nodes.
	 * 
	 *          Space Complexity : O(1)
	 * 
	 *          <pre>
	 * 
	 * Strategy: permutation generation by swapping the last-element with other elements(right to left)         
	 *          
	 *  input : [a,b,c]
	 *  
	 *    At p3 : we can place all 3 chars at p3
	 *    At p2 : we can place remaining 2 chars at p2
	 *    At p1 : we can place last remaining char at p1.
	 *    
	 *    
	 *  Swap-operation fixes the char at any given position. 
	 *  
	 *  Example fixing the position P3 in [a,b,c]
	 *   
	 *    --swap c with c
	 *    --swap c with b
	 *    --swap c with a
	 *  
	 * 
	 * Same strategy need to be called for fixing the position P1 and P2.
	 *          </pre>
	 */
	public void printPermutationsOfArray3(char[] input, int n) {

		// when n reaches to 0th index of input array
		if (n == 1) {
			System.out.println(String.valueOf(input));
			return;
		}

		/**
		 * Here to fix any position say P3 in [a, b, c]: order of swap operation is
		 * 
		 * --swap c with a
		 * 
		 * --swap c with b
		 * 
		 * --swap c with c
		 * 
		 */
		for (int i = 0; i < n; i++) {

			swap(input, i, n - 1);
			printPermutationsOfArray3(input, n - 1);

			// We are reverse swapping so that we can explore the other branch of the same
			// input, i.e. back-tracing

			swap(input, i, n - 1);
		}
	}

	/**
	 * Even-Odd permutation: <br/>
	 * -------------------------
	 * 
	 * <pre>
	 * 		1 2 3 4 5   		Original 
	 *
	 * 		3 4 2 1 5  			A Permutation
	 * 
	 * Cycle: 1-->3-->2-->4-->1 
	 * Cycle: 5
	 * 
	 * Cyclical Notation: (1 3 2 4) (5) 
	 * 
	 * Cyclical Notation using Transposition: (1 3) (3 2) (2 4)
	 * 
	 * Explanation: We get (1 3) (3 2) (2 4) (5), but we can omit 5 as it is at same position.
	 *
	 * If cyclical notation using transposition contains even groups then it 
	 * is called even permutation otherwise odd permutation.
	 * 
	 * Johnson trotter algorithm can be used to generate even-odd permutation. For more details
	 * refer {@link https://en.wikipedia.org/wiki/Steinhaus%E2%80%93Johnson%E2%80%93Trotter_algorithm}
	 * 
	 * </pre>
	 * 
	 * SJT Algorithm: <br/>
	 * -----------------
	 * 
	 * It is a minimal change algorithm wherein any two successive permutations are
	 * obtained from each other by a single adjacent transposition (adjacent swaps).
	 * 
	 * Time Complexity: It can be implemented to run in O(n!)
	 * 
	 * Jargons in SJT Algorithm: <br/>
	 * -------------------------------
	 * 
	 * Directed Integer: Each element has associated direction, left or right.
	 * 
	 * Mobile: A directed integer is said to be mobile if it is greater than its
	 * immediate neighbor in the direction it is pointing to
	 * 
	 * Pseudo Code: <br/>
	 * -----------------
	 * 
	 * <pre>
	 * While permutation p has a mobile element:
	 * --- 1) Find the largest mobile element 'k'
	 * --- 2) Swap 'k' with the adjacent element it is pointing to.
	 * --- 3) Reverse direction of all elements greater than 'k'
	 * --- 4) Post reverse the input array represents a new permutation.
	 * </pre>
	 * 
	 */
	@Override
	public void printPermutationsOfArrayUsingSJT1(int[] permutation) {

		int[] direction = new int[permutation.length];
		// Assuming that permutation array has elements in increasing order.
		Arrays.fill(direction, -1);

		int largestMobileIdx = findLargestMobileElement(permutation, direction);

		System.out.println(Arrays.toString(permutation));
		while (largestMobileIdx != Integer.MIN_VALUE) {
			int largestMobileElement = permutation[largestMobileIdx];
			int directedNeighbourIdx = largestMobileIdx + direction[largestMobileIdx];
			swap(permutation, direction, largestMobileIdx, directedNeighbourIdx);
			reverseDirection(permutation, direction, largestMobileElement);
			System.out.println(Arrays.toString(permutation));
			largestMobileIdx = findLargestMobileElement(permutation, direction);
		}
	}

	@Override
	public void printPermutationsOfArrayUsingSJT2(int[] n) {
		// TODO: first need to understand inverse permutation,(google, youtube)
		// https://introcs.cs.princeton.edu/java/23recursion/JohnsonTrotter.java.html
	}

	private int findLargestMobileElement(int[] permutation, int[] direction) {
		int largestMobileIdx = Integer.MIN_VALUE;

		for (int i = 0; i < permutation.length; i++) {
			int directedNeighbourIdx = i + direction[i];

			if (directedNeighbourIdx < 0 || directedNeighbourIdx >= permutation.length)
				continue;

			// mobile element
			if (permutation[i] > permutation[directedNeighbourIdx]) {
				// largest mobile element
				if (largestMobileIdx == Integer.MIN_VALUE || permutation[i] > permutation[largestMobileIdx])
					largestMobileIdx = i;
			}
		}
		return largestMobileIdx;
	}

	// swap the characters at indices i and j
	private void swap(int[] permutation, int[] direction, int i, int j) {
		int temp = permutation[i];
		permutation[i] = permutation[j];
		permutation[j] = temp;

		temp = direction[i];
		direction[i] = direction[j];
		direction[j] = temp;
	}

	private void reverseDirection(int[] permutation, int[] direction, int largestMobileElement) {
		for (int i = 0; i < permutation.length; i++) {
			if (permutation[i] > largestMobileElement)
				direction[i] = -direction[i];
		}
	}

	/**
	 * <pre>
	 * BR HEAPS ALGO
	 * 
	 * https://en.wikipedia.org/wiki/Heap%27s_algorithm
	 * https://www.baeldung.com/java-array-permutations
	 * 
	 * </pre>
	 */
	@Override
	public void printPermutationsOfArrayUsingBRHeap(int[] n) {
		// TODO Auto-generated method stub
	}

	@Override
	public void permutationsWithAdjacentNonRepeatableSwaps1(String input) {
		List<String> inputPairs = IntStream.range(1, input.length())
				.mapToObj(i -> "" + input.charAt(i - 1) + input.charAt(i)).collect(Collectors.toList());

		findPermutations(inputPairs, new ArrayList<>(), input);

	}

	private void findPermutations(List<String> inputPairs, List<String> outputPairs, String originalString) {

		if (inputPairs.isEmpty()) {

			char[] inputArray = originalString.toCharArray();
			for (String swapPair : outputPairs) {
				int i = originalString.indexOf(swapPair);
				swap(inputArray, i, i + 1);
			}
			System.out.println("Input: " + originalString + ", Swapping Pairs:" + outputPairs + ", Output: "
					+ String.valueOf(inputArray));
			return;
		}

		// candidate pair
		List<String> copyOfInputPairs = new ArrayList<>(inputPairs);
		String pair = copyOfInputPairs.remove(0);

		if (!containsOverlappingPair(outputPairs, pair)) {
			List<String> copyOfOutputPairs = new ArrayList<>(outputPairs);
			copyOfOutputPairs.add(pair);
			findPermutations(copyOfInputPairs, copyOfOutputPairs, originalString);
		}

		findPermutations(copyOfInputPairs, outputPairs, originalString);
	}

	private boolean containsOverlappingPair(List<String> outputPairs, String inputPair) {
		for (String pair : outputPairs) {
			if (pair.charAt(1) == inputPair.charAt(0))
				return true;
		}
		return false;
	}

	/**
	 * Generate permutations with only non repeatable adjacent swaps allowed.
	 * 
	 * Given a string on length N. You can swap only the adjacent elements and each
	 * element can be swapped at most once. Given these rules, find the no of
	 * permutations of the string that can be generated after performing the swaps
	 * as mentioned.
	 * 
	 * Solution:
	 * 
	 * Include Step: We will pick two non-overlapping adjacent elements at a time as
	 * swap pair.
	 * 
	 * Exclude Step: Exclude single element, In 12345 we can create swap pair 23 by
	 * excluding 1. We should not exclude in pairs.
	 * 
	 */
	@Override
	public void permutationsWithAdjacentNonRepeatableSwaps2(String input) {
		findPermutations(input.toCharArray(), 0);

	}

	private void findPermutations(char[] input, int idx) {

		// If we are left with only single element, we cannot form a swap pair so we are
		// terminating in that scenario also.
		if (idx >= input.length || (idx + 1) >= input.length) {
			System.out.println(String.valueOf(input));
			return;
		}

		// Include Step: Swap with the next character and revert the changes.
		swap(input, idx, idx + 1);
		findPermutations(input, idx + 2);
		swap(input, idx, idx + 1);

		// Exclude Step: don't swap the current position
		findPermutations(input, idx + 1);
	}

	/**
	 * Here instead of Pascal Identity(i.e. Include-Exclude) will use Pascal
	 * Identity Expansion of Exclude terms into Include Terms.
	 * 
	 * This is more efficient than include exclude based solution. i.e. question1B
	 */
	@Override
	public void permutationsWithAdjacentNonRepeatableSwaps3(String input) {
		adjSwapPermUsingPascalIdentityExpansion(input.toCharArray(), 0);

	}

	private void adjSwapPermUsingPascalIdentityExpansion(char[] input, int index) {
		System.out.println(String.valueOf(input));
		for (int i = index; i < input.length && (i + 1) < input.length; i++) {
			swap(input, i, i + 1);
			adjSwapPermUsingPascalIdentityExpansion(input, index + 2);
			swap(input, i, i + 1);
		}

	}

	@Override
	public void printNextLexicographicPermutation(String inputString) {
		char[] input = inputString.toCharArray();

		getNextLexicographicPermutation(input);

		System.out.println(String.valueOf(input));
	}

	/**
	 * <pre>
	 * Step1 : Identify Pivot Traverse the array from right side and stop at the
	 * first element which is not in ascending order. Example : 2 is pivot in
	 * 0125330 
	 * Question: Why we are traversing in ascending order from right side? : Because of PROPERTY_1. 
	 * 
	 * Step2: Find Successor of Pivot Find the next greater
	 * digit than the Pivot among digits present in right-side of the pivot.
	 * 
	 * Note : Since right side of the pivot contains all the digits in sorted order, so we
	 * can apply binary search.
	 * 
	 * Step 3: Swap the Pivot with Successor. Because we want just next greater
	 * element which is only possible by replacing pivot with successor.
	 * 
	 * Step4: Now reverse sort(descending order from right side) all the elements
	 * lying in right-side of pivot position. 
	 * 
	 * Note : Since right side of the pivot position is already in sorted order, 
	 * so just need to reverse the element to get them in descending order.
	 * 
	 * Question: Why do we sort elements lying right-side of pivot position in descending order? : Because of PROPERTY_1.
	 * </pre>
	 * 
	 * <pre>
	 * TimeComplexity : STEP1 +  STEP2   + STEP3 + STEP4
	 *                : O(n)  +  O(logn) + O(1)  + O(n) 
	 *                : O(n)
	 * </pre>
	 */
	private void getNextLexicographicPermutation(char[] input) {
		// STEP 1: Find the pivot.
		int pivotIndex = Integer.MIN_VALUE;
		for (int i = input.length - 1; i > 0; i--)
			if (input[i - 1] < input[i]) {
				pivotIndex = i - 1;
				break;
			}

		// pivot not found, means input itself is the largest element using given
		// digits.
		if (pivotIndex == Integer.MIN_VALUE)
			return;

		// STEP 2: Find the successor using binary search

		// we are increasing the targetValue by 1, because we want to find the insertion
		// position of successor value.
		char targetValue = input[pivotIndex];
		targetValue++;

		int targetInsertionIndex = bisectRightInDescendingArray(input, targetValue, pivotIndex + 1, input.length);
		int pivotSuccessorIndex = targetInsertionIndex - 1;

		// STEP 3: Swap pivot element with its successor to the right-side of the array.
		swap(input, pivotIndex, pivotSuccessorIndex);

		// STEP 4: Reverse the array elements from pivot-index (exclusive) to the end of
		// the array.

		int startIndex = pivotIndex + 1;
		int endIndex = input.length - 1;
		int diff = endIndex - startIndex;

		// (diff - 1) avoids self swap
		for (int i = 0; i <= (diff - 1) >> 1; i++) {
			char temp = input[startIndex + i];
			input[startIndex + i] = input[endIndex - i];
			input[endIndex - i] = temp;
		}
	}

	/**
	 * elements between left and right indexes in input array must be in descending
	 * order.
	 */
	private int bisectRightInDescendingArray(char[] input, char searchElement, int left, int right) {
		while (left < right) {
			int mid = (left + right) / 2;

			if (input[mid] < searchElement)
				right = mid;
			else
				left = mid + 1;
		}
		return left;
	}

	/**
	 * Generate kth lexicographic permutation.
	 */
	@Override
	public void printKthLexicographicPermutation(String inputStr, int k) {
		List<Character> charList = inputStr.chars().mapToObj(ch -> (char) ch).collect(Collectors.toList());
		char[] result = getKthLexicographicPermutation(charList, k);
		System.out.println(String.valueOf(result));
	}

	/**
	 * <pre>
	 * Time Complexity : time to calculate factorial + time for output loop * time taken for input.remove
	 *                 : O(n) + O(n) * O(n)
	 *                 : O(n) + O(n^2)
	 *                 : O(n^2)
	 * </pre>
	 */
	private char[] getKthLexicographicPermutation(List<Character> input, int k) {
		char[] output = new char[input.size()];

		int factorial = factorial(input.size());
		int blockSize = factorial / input.size();

		k = k - 1;
		for (int i = 0; i < output.length; i++) {

			int blockNumber = k / blockSize;

			output[i] = input.get(blockNumber);
			input.remove(blockNumber);
			if (input.size() == 0)
				break;

			k = k % blockSize;
			blockSize = blockSize / input.size();
		}

		return output;
	}

	private int factorial(int num) {
		if (num == 0 || num == 1)
			return 1;
		return num * factorial(num - 1);
	}

	/**
	 * Time Complexity: O(n! * n^2)
	 */
	@Override
	public void printAllPermutationsInLexicographicOrder1(String inputString) {
		printPermutationsOfString(inputString, "");
	}

	/**
	 * Question: Print all permutations in lexicographic order. Time Complexity:
	 * 
	 * O(n*n!)
	 */
	@Override
	public void printAllPermutationsInLexicographicOrder2(String inputString) {
		List<Character> charList = inputString.chars().mapToObj(ch -> (char) ch).collect(Collectors.toList());
		int factorial = factorial(inputString.length());

		for (int i = 1; i <= factorial; i++) {
			char[] result = getKthLexicographicPermutation(new ArrayList<>(charList), i);
			System.out.println(result);
		}
	}

	/**
	 * Question: Print all permutations in lexicographic order.
	 * 
	 * Time Complexity: n! * n
	 * 
	 * @param inputString should be sorted order.
	 */
	@Override
	public void printAllPermutationsInLexicographicOrder3(String inputString) {
		char[] input = inputString.toCharArray();

		// largest permutation as inputString is in sorted order.
		final String LARGEST_PERMUTATION = new StringBuilder(inputString).reverse().toString();

		System.out.println(inputString);
		while (!inputString.equals(LARGEST_PERMUTATION)) {
			getNextLexicographicPermutation(input);
			inputString = String.valueOf(input);
			System.out.println(inputString);
		}
	}

}
