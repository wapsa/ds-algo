package edu.sau.algo.numbertheory.permutation;

public class Permutation {

	public static void main(String[] args) {
		String input = "abc";

		// permuteString(input, "");

		// permuteArray(input.toCharArray(), new char[input.length()], 0);

		// permuteArray1(input.toCharArray(), 0);

		permuteArray2(input.toCharArray(), input.length());

	}

	/**
	 * Time Complexity: O(n*n!) Depth of the tree is n, so to reach any of the leaf
	 * node we need to traverse n steps. And there are n! leaf nodes.
	 * 
	 * Space Complexity : At each node of tree we are creating one output string. In
	 * a single path we have n nodes. Total paths = n! Space complexity of
	 * output-string = (n string)* (n! path) = O(n*n!) Similarly, Space complexity
	 * of input-string = O(n*n!)
	 *
	 * Total Space Complexity = O(n*n!)
	 */
	private static void permuteString(String input, String output) {
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			// Simply removing the character being selected from the input to append to the
			// output and passing sliced input to recursive method.
			permuteString(input.substring(0, i) + input.substring(i + 1), output + input.charAt(i));
		}
	}

	/**
	 * Time Complexity: O(n*n!)
	 * 
	 * Space Complexity: O(n) extra space for output array.
	 */
	private static void permuteArray(char[] input, char[] output, int outputPos) {
		if (outputPos == input.length) {
			System.out.println(String.valueOf(output));
			return;
		}
		for (int i = 0; i < input.length; i++) {
			if (input[i] == Character.MIN_VALUE)
				continue;

			char ch = input[i];
			input[i] = Character.MIN_VALUE;

			output[outputPos] = ch;
			permuteArray(input, output, outputPos + 1);
			input[i] = ch;
		}
	}

	/**
	 * 
	 * */
	private static void permuteArray1(char[] input, int pos) {
		// To avoid last swap which is with itself we do input.length-1
		if (pos == input.length - 1) {
			System.out.println(String.valueOf(input));
		}
		for (int i = pos; i < input.length; i++) {
			swap(input, pos, i);
			permuteArray1(input, pos + 1);
			swap(input, pos, i);
		}
	}

	/**
	 * print n! permutation of the characters of array (not in order)
	 *
	 * @param pos is length of the input
	 *
	 *            Time Complexity : O(n*n!) Depth of the tree is n, so to reach any
	 *            of the leaf node we need to traverse n steps. And there are n!
	 *            leaf nodes.
	 * 
	 *
	 *
	 *            <pre>
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
	 *
	 *
	 * Space Complexity: O(1), as we are using input array only.
	 *            </pre>
	 *
	 */
	private static void permuteArray2(char[] input, int pos) {
		if (pos == 1) {
			System.out.println(String.valueOf(input));
			return;
		}
		for (int i = 0; i < pos; i++) {
			swap(input, i, pos - 1);
			permuteArray2(input, pos - 1);
			swap(input, i, pos - 1);
		}
	}

	// swap the characters at indices i and j
	private static void swap(char[] input, int i, int j) {
		char c = input[i];
		input[i] = input[j];
		input[j] = c;
	}

}
