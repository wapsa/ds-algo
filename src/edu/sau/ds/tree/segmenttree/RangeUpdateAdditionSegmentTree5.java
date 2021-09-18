package edu.sau.ds.tree.segmenttree;

import java.util.Arrays;

import edu.sau.other.bitwise.BitwiseUtils;

/**
 * Here we need not to implement lazy propagation because addition operation is
 * not order dependent, so we can keep multiple range updates summation on
 * nodes.
 *
 * Effectively, we are able to combine multiple range update operations into one
 * composite addition operation as addition operation is associative. Also,
 * because of commutative property order of addition does not matter.
 *
 * -- original elements are present at leaf node
 *
 * -- intermediate nodes are void nodes
 *
 * Note: Intermediate nodes represents addition operation.
 *
 */
public class RangeUpdateAdditionSegmentTree5 implements RangeUpdateSegmentTree<Integer> {

	private final int tree[];
	private final int root_tl = 0;
	private final int root_tr;
	private final int bfs_index_start = 0;

	public RangeUpdateAdditionSegmentTree5(int[] elements) {
		super();
		int powerOf2InputSize = getInputArraySizeAsPowerOf2(elements.length);
		this.tree = new int[2 * powerOf2InputSize - 1];
		this.root_tr = elements.length - 1;
		buildSumSegmentTree(elements, tree, bfs_index_start, root_tl, root_tr);
	}

	/**
	 * Since the operator is addition, we are representing void nodes as 0.
	 */
	private void buildSumSegmentTree(int[] elements, int[] tree, int bfsIndex, int tl, int tr) {
		if (tl == tr) {
			tree[bfsIndex] = elements[tl];
		} else {
			tree[bfsIndex] = 0;

			int mid = (tl + tr) / 2;
			buildSumSegmentTree(elements, tree, 2 * bfsIndex + 1, tl, mid);
			buildSumSegmentTree(elements, tree, 2 * bfsIndex + 2, mid + 1, tr);
		}
	}

	private int getInputArraySizeAsPowerOf2(int inputSize) {
		if (!BitwiseUtils.is_2_toThePowerOf_N(inputSize)) {
			inputSize = getNextPowerOf2(inputSize);
		}
		return inputSize;
	}

	private int getNextPowerOf2(int inputSize) {
		return (Integer.highestOneBit(inputSize) << 1);
	}

	/**
	 * We need to do binary search using node range to find out the element at given
	 * input index. In return trip we will apply the addition operation.
	 */
	@Override
	public Integer query(int index) {
		return query(index, this.root_tl, this.root_tr, this.bfs_index_start);
	}

	private Integer query(int index, int tl, int tr, int bfsIndex) {
		if (tl == tr)
			return tree[bfsIndex];

		int tm = (tl + tr) / 2;
		if (index <= tm)
			return tree[bfsIndex] + query(index, tl, tm, 2 * bfsIndex + 1);
		else
			return tree[bfsIndex] + query(index, tm + 1, tr, 2 * bfsIndex + 2);
	}

	/**
	 * Since its range update, we need to evaluate all three cases: completely
	 * outside range, completely inside range and some in some out.
	 */
	@Override
	public void update(Integer data, int left, int right) {
		update(data, left, right, this.root_tl, this.root_tr, this.bfs_index_start);
	}

	private void update(int data, int ul, int ur, int tl, int tr, int bfsIndex) {
		// CASE 1: when node lies completely outside the given range.
		if (tr < ul || ur <= tl) {
			return;
		}
		// Case 2: when node lies completely inside the given range.
		if (tl >= ul && tr < ur) {
			tree[bfsIndex] = tree[bfsIndex] + data;
			return;
		}
		// Case 3: when tree node lies partially inside the query range.
		int mid = (tl + tr) / 2;
		update(data, ul, ur, tl, mid, 2 * bfsIndex + 1);
		update(data, ul, ur, mid + 1, tr, 2 * bfsIndex + 2);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RangeUpdateAdditionSegmentTree6 [tree=");
		builder.append(Arrays.toString(tree));
		builder.append("]");
		return builder.toString();
	}

}
