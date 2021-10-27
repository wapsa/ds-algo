package edu.sau.ds.tree.fenwicktree;

import java.util.Arrays;

import edu.sau.other.bitwise.BitwiseUtils;

/**
 * Binary Indexed tree implementation using one-based indexing.
 * 
 * <pre>
 * 
 * index + BitwiseUtils.lowestOneBit(index)  --->> i + (i & -i) - calculates the next upper index which is also responsible 
 * to include the current element 'i' in it's sum calculation. Applying this recursively we can keep finding the next upper index which 
 * is also responsible for 'i' which is like climbing the stairs.
 * 
 * index - BitwiseUtils.lowestOneBit(index) --->> i - (i & -1) - calculates the next lower index till which the current 
 * element 'i' is responsible for to hold the sum.
 * 
 * 
 * Properties of 1-based fenwick tree
 * 
 * 1) odd-index is responsible for only itself. It means at odd index in fenwick tree(bit) we will find the 
 * original element itself taking one-based transformation into consideration.
 * 
 * 2) all index of type 2^n, are responsible for all the indexes upto this point. Will contain prefix
 * sum of input-array including this index.
 * 
 * 3) all even indexes are responsible for upto (lower_index + 1) which is calculated by dropping the last set bit of this index.
 * 
 * </pre>
 */
public class FenwickTree1 implements BinaryIndexedTree<Integer> {

	private int[] bit;

	public FenwickTree1(int[] input) {
		super();
		// +1 because we are going to use one-based indexing.
		this.bit = new int[input.length + 1];
		// buildTreeInN(input);
		buildTreeInNlogN(input);
	}

	private void buildTreeInN(int[] input) {
		int[] prefixSum = new int[input.length + 1];
		for (int i = 1; i <= input.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + input[i - 1];

			int nextLowerIdx = i - BitwiseUtils.lowestOneBit(i);
			this.bit[i] = prefixSum[i] - prefixSum[nextLowerIdx];
		}
	}

	/**
	 * Time complexity: n * log(n), as pointUpdate function takes log(n).
	 */
	private void buildTreeInNlogN(int[] input) {
		for (int i = 0; i < input.length; i++) {
			pointUpdate(i, input[i]);
		}
	}

	/**
	 * Time complexity: log(n)
	 */
	@Override
	public void pointUpdate(int zeroBasedIndex, Integer delta) {

		// since this implementation we are using one-based index.
		int i = zeroBasedIndex + 1;

		while (i < this.bit.length) {
			bit[i] = bit[i] + delta;
			// moving upward on bit tree stair elements. This helps traverse up the indexes
			// who are responsible for given index.
			i = i + BitwiseUtils.lowestOneBit(i);
		}

	}

	@Override
	public void rangeUpdate(int left, int right, Integer data) {

	}

	@Override
	public Integer rangeQuery(int ql, int qr) {
		// since qr being passed is exclusive so passing qr - 1

		// why ql-1 ? because bitSum(ql) gives prefixSum upto ql index, so if we do
		// "bitSum(qr-1) - bitSum(ql)", ql will not be included in this range
		// calculation.
		return bitSum(qr - 1) - bitSum(ql - 1);
	}

	/**
	 * input index is inclusive.
	 * 
	 * moving upward on bit tree stair elements. This helps traverse up the indexes
	 * who are responsible for given index.
	 * 
	 * Time Complexity: log(n)
	 */
	private int bitSum(int zeroBasedIndex) {
		int sum = 0;

		// transform zerobasedindex to one based as fenwick tree is one based.
		int i = zeroBasedIndex + 1;
		while (i > 0) {
			sum = sum + this.bit[i];
			i = i - BitwiseUtils.lowestOneBit(i);
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FenwickTree1 [bit=");
		builder.append(Arrays.toString(bit));
		builder.append("]");
		return builder.toString();
	}

}
