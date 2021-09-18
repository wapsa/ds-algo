package edu.sau.ds.tree.segmenttree;

import java.util.Arrays;

import edu.sau.ds.tree.segmenttree.SegmentTree.SumST;
import edu.sau.other.bitwise.BitwiseUtils;

/**
 * 1) bfsIndex is used for locating the index of node in tree array while doing
 * the tree traversal.
 * 
 * 2) Node segment(i.e. tl and tr) is used for binary search condition check.
 */
public class SumSegmentTree1 implements SumST<Integer> {

	/**
	 * BFS indexed segment tree
	 */
	private final int tree[];
	private final int root_tl = 0;
	private final int root_tr;
	private final int bfs_index_start = 0;

	public SumSegmentTree1(int[] elements, boolean isFull) {
		super();
		int powerOf2InputSize = getInputArraySizeAsPowerOf2(elements.length);
		this.tree = new int[2 * powerOf2InputSize - 1];
		if (isFull) {
			this.root_tr = powerOf2InputSize - 1;
			buildFullSumSegmentTree(elements, powerOf2InputSize);
		} else {
			this.root_tr = elements.length - 1;
			buildSumSegmentTree(elements, this.tree, this.bfs_index_start, this.root_tl, this.root_tr);
		}

	}

	/**
	 * Since this implementation is SUM segment-tree, we can use 0 as the dummy
	 * value to extend the input-array if the size of array is not the power-of-2.
	 */
	private void buildFullSumSegmentTree(int[] input, int powerOf2InputSize) {
		int[] powerOf2Input = input;
		if (input.length < powerOf2InputSize) {
			powerOf2Input = new int[powerOf2InputSize];
			System.arraycopy(input, 0, powerOf2Input, 0, input.length);
		}
		buildSumSegmentTree(powerOf2Input, tree, bfs_index_start, root_tl, root_tr);
	}

	/**
	 * We do not save the nodes segments explicitly, rather it is getting calculated
	 * on the fly using the root node's segment.
	 * 
	 * This recursion uses the bottom-up approach.
	 * 
	 * Time complexity is O(n)
	 * 
	 * @param elements: represents input array.
	 * @param tree:     represents the temp segment tree which we are going to
	 *                  build.
	 * @param bfsIndex: represents the bfs index for the segment tree node.
	 * @param tl:       represents left index of segment range for node (bfsIndex).
	 * @param tr:       represents right index of segment range for node (bfsIndex).
	 * 
	 *                  <pre>
	 *                  
	 * Hypothesis: function buildSumSegmentTree gives sum of segment tl and tr and stored at bfsIndex.
	 * 
	 * Substitution: 
	 * int mid = (tl + tr) / 2;
	 * sum_of_left_child = buildSumSegmentTree(elements, tree, 2 * bfsIndex + 1, tl, mid)
	 * sum_of_right_child = buildSumSegmentTree(elements, tree, 2 * bfsIndex + 2, mid + 1, tr)
	 * 
	 * Induction:
	 * tree[bfsIndex] = sum_of_left_child + sum_of_right_child
	 *                  </pre>
	 */
	private int buildSumSegmentTree(int[] elements, int[] tree, int bfsIndex, int tl, int tr) {
		if (tl == tr) {
			// When tl == tr, we have reached leaf nodes and leaf node is a segment in
			// itself and sum of the segment is the node value itself.
			return tree[bfsIndex] = elements[tl];
		} else {
			int mid = (tl + tr) / 2;
			return tree[bfsIndex] = buildSumSegmentTree(elements, tree, 2 * bfsIndex + 1, tl, mid)
					+ buildSumSegmentTree(elements, tree, 2 * bfsIndex + 2, mid + 1, tr);
		}
	}

	/**
	 * <pre>
	 * If segment tree is power-of-2 then we can directly use (2n-1) as the size of segment-tree-array
	 * If segment tree is not the power-of-2, then we can extend the input-array to the power-of-2 using dummy value, 
	 * then use (2n-1). This is asymptotically equal to 4n.
	 * </pre>
	 */
	private int getInputArraySizeAsPowerOf2(int inputSize) {
		if (!BitwiseUtils.is_2_toThePowerOf_N(inputSize)) {
			inputSize = getNextPowerOf2(inputSize);
		}
		return inputSize;
	}

	private int getNextPowerOf2(int inputSize) {
		return (Integer.highestOneBit(inputSize) << 1);
	}

	@Override
	public Integer rangeQuery(int left, int right) {
		return rangeQuery(left, right, this.root_tl, this.root_tr, this.bfs_index_start);
	}

	/**
	 * Even bfsIndex represents left child. Odd bfsIndex represents right child.
	 * 
	 * If left part of the query segment i.e. ql is on the right_child then we need
	 * to include the sum of the tree node
	 * 
	 * <pre>
	 * Algorithm:
	 * 
	 *
	 * </pre>
	 * 
	 * Time complexity is O(4 * logn) = O(logn)
	 */
	private int rangeQuery(int ql, int qr, int tl, int tr, int bfsIndex) {
		// CASE 1 : node segment lies completely outside the query segment.
		if (tr < ql || qr <= tl) {
			return 0;
		}
		// CASE 2 : node segment lies completely inside the query segment.
		if (ql <= tl && qr > tr) {
			return this.tree[bfsIndex];
		}
		int mid = (tl + tr) / 2;
		return rangeQuery(ql, qr, tl, mid, 2 * bfsIndex + 1) + rangeQuery(ql, qr, mid + 1, tr, 2 * bfsIndex + 2);
	}

	/**
	 * The task is as follows: for a given value x we have to quickly find smallest
	 * index i such that the sum of the first i elements of the array a[] is greater
	 * or equal to x (assuming that the array a[] only contains non-negative
	 * values).
	 */
	@Override
	public int getRightBoundOfRange(Integer data) {
		if (data > tree[this.bfs_index_start]) {
			return Integer.MIN_VALUE;
		}
		return getRightBoundOfRangeUsingRecursion(data, this.bfs_index_start, this.root_tl, this.root_tr);
	}

	/**
	 *
	 * https://cp-algorithms.com/data_structures/segment_tree.html
	 *
	 *
	 * TimeComplexity : O(logn)
	 *
	 * Also @see: Counting the number of zeros, searching for the k-th zero. In this
	 * problem, segment tree is built on number of zeros such that rangeQuery is for
	 * the number of zeros in a given range. And its opposite is to find the right
	 * bound of range for the k-th zero.
	 *
	 */
	private int getRightBoundOfRangeUsingRecursion(Integer data, int bfsIndex, int tl, int tr) {
		if (tl == tr) {
			return tr;
		}
		int mid = (tl + tr) / 2;

		if (tree[2 * bfsIndex + 1] >= data) {
			return getRightBoundOfRangeUsingRecursion(data, 2 * bfsIndex + 1, tl, mid);
		} else {
			return getRightBoundOfRangeUsingRecursion(data - tree[2 * bfsIndex + 1], 2 * bfsIndex + 2, mid + 1, tr);
		}
	}

	/**
	 * For update we follow binary search to find out the node to be updated. Parent
	 * nodes on the binary search path get recalculated on the return trip.
	 */
	@Override
	public void update(Integer data, int index) {
		update(data, index, this.root_tl, this.root_tr, this.bfs_index_start);
	}

	private void update(int data, int updateIndex, int tl, int tr, int bfsIndex) {
		// Node to be updated is found.
		if (tl == tr) {
			this.tree[bfsIndex] = data;
		} else {
			int mid = (tl + tr) / 2;
			if (updateIndex <= mid) {
				// go left
				update(data, updateIndex, tl, mid, 2 * bfsIndex + 1);
			} else {
				// go right
				update(data, updateIndex, mid + 1, tr, 2 * bfsIndex + 2);
			}
			// re calculate sum on return trip after updating the data.
			this.tree[bfsIndex] = this.tree[2 * bfsIndex + 1] + this.tree[2 * bfsIndex + 2];
		}
	}

	/**
	 * Solution is comprised of two Algo:<br>
	 *
	 * ALGO 1: When question is constrained on range, then CASES are on the basis of
	 * position of tree-node-range with respect to query-range <br>
	 * CASE 1: when node range lies completely outside the query range <br>
	 * CASE 2: when node range lies completely inside the query range <br>
	 * CASE 3: when node range lies partially inside the query range <br>
	 *
	 * ALGO 2 : CASE 2 from ALGO 1 <br>
	 *
	 * CASE 2: When a tree node lies completely inside the query range. (ql <= tl &&
	 * tr <= qr)
	 *
	 * CASE 2A: When node-sum is less than the given-sum, then we need to adjust the
	 * given-sum and terminate the recursion for this branch.
	 *
	 * <pre>
	 * <code>
	 *      if (tree[bfsIndex] < givenSum[0]) {
	 *              givenSum[0]= givenSum[0] - tree[bfsIndex];
	 *             return INTEGER.MIN; // stops the recursion for this branch
	 *      }
	 *  </code>
	 * </pre>
	 *
	 * CASE 2B: When node-sum is greater than the given-sum, we need to branch the
	 * recursion and further check for CASE2A and CASE2B until control reaches to
	 * leaf node.
	 */
	@Override
	public int getRightBoundOfRangeInGivenQueryRange(int ql, int qr, int data) {
		if (tree[this.bfs_index_start] < data) {
			return Integer.MIN_VALUE;
		}
		return getRightBoundOfRangeInGivenQueryRange(this.bfs_index_start, this.root_tl, this.root_tr, ql, qr,
				new int[] { data });
	}

	private int getRightBoundOfRangeInGivenQueryRange(int bfsIndex, int tl, int tr, int ql, int qr, int[] givenSum) {
		if (tl > qr || tr < ql)
			return Integer.MIN_VALUE;

		if (ql <= tl && tr <= qr) {
			if (tree[bfsIndex] < givenSum[0]) {
				givenSum[0] = givenSum[0] - tree[bfsIndex];
				return Integer.MIN_VALUE;
			}
			if (tl == tr)
				return tl;
		}

		int mid = (tl + tr) / 2;
		int rs = getRightBoundOfRangeInGivenQueryRange(2 * bfsIndex + 1, tl, mid, ql, qr, givenSum);
		if (rs != Integer.MIN_VALUE)
			return rs;
		return getRightBoundOfRangeInGivenQueryRange(2 * bfsIndex + 2, mid + 1, tr, ql, qr, givenSum);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("sum segment tree=");
		builder.append(Arrays.toString(tree));
		return builder.toString();
	}

}