package edu.sau.ds.tree.segmenttree;

import java.util.Arrays;

import edu.sau.other.bitwise.BitwiseUtils;

/**
 * This segment tree is a mix of range update
 */
public class RangeUpdateAdditionRangeQueryMaxSegmentTree7 implements RangeUpdateRangeQuerySegmentTree<Integer> {

	private final int tree[];
	private final int lazy[];
	private final int root_tl = 0;
	private final int root_tr;
	private final int bfs_index_start = 0;

	public RangeUpdateAdditionRangeQueryMaxSegmentTree7(int[] elements) {
		super();
		int powerOf2InputSize = getInputArraySizeAsPowerOf2(elements.length);
		this.tree = new int[2 * powerOf2InputSize - 1];
		this.lazy = new int[2 * powerOf2InputSize - 1];
		this.root_tr = elements.length - 1;
		buildSegmentTree(elements, tree, bfs_index_start, root_tl, root_tr);
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
	 * Since the operator is subtraction, we are representing void nodes as null.
	 */
	private int buildSegmentTree(int[] elements, int[] tree, int bfsIndex, int tl, int tr) {
		if (tl == tr) {
			return tree[bfsIndex] = elements[tl];
		} else {
			int mid = (tl + tr) / 2;
			return tree[bfsIndex] = Math.max(buildSegmentTree(elements, tree, 2 * bfsIndex + 1, tl, mid),
					buildSegmentTree(elements, tree, 2 * bfsIndex + 2, mid + 1, tr));
		}
	}

	@Override
	public Integer query(int left, int right) {
		return queryWithPushDown(this.bfs_index_start, this.root_tl, this.root_tr, left, right);
	}

	/**
	 * In case 1 we must not return the actual value of the node lying outside of
	 * query range because we do not want to take it into consideration while
	 * calculating max. So returning Integer.MIN_VALUE as while calculating max it
	 * will be ignored. Opposite logic in update.
	 */
	private Integer queryWithPushDown(int bfsIndex, int tl, int tr, int ql, int qr) {
		// CASE 1 : node segment lies completely outside the query segment.
		if (tr < ql || qr <= tl) {
			return Integer.MIN_VALUE;
		}

		pushDownUpdateOperand(bfsIndex, tl, tr);

		// CASE 2 : node segment lies completely inside the query segment.
		if (ql <= tl && qr > tr) {
			return this.tree[bfsIndex];
		}
		int mid = (tl + tr) / 2;
		return Math.max(queryWithPushDown(2 * bfsIndex + 1, tl, mid, ql, qr),
				queryWithPushDown(2 * bfsIndex + 2, mid + 1, tr, ql, qr));

	}

	@Override
	public void update(Integer data, int left, int right) {
		update(data, left, right, this.root_tl, this.root_tr, this.bfs_index_start);
	}

	/**
	 * As we are doing push down in update we have to re calculate the max value in
	 * return trip.
	 * 
	 * In case 1 we have to return the actual value because in return trip for
	 * calculating max we have to take into consideration the actual value of
	 * outside node, otherwise it will have corrupt max value. Opposite logic in
	 * query.
	 */
	private int update(int data, int ul, int ur, int tl, int tr, int bfsIndex) {
		// CASE 1: when node lies completely outside the given range.
		if (tr < ul || ur <= tl) {
			return tree[bfsIndex];
		}

		pushDownUpdateOperand(bfsIndex, tl, tr);

		// Case 2: when node lies completely inside the given range.
		if (tl >= ul && tr < ur) {
			lazy[bfsIndex] += data;
			return tree[bfsIndex] += data;
		}

		// Case 3: when tree node lies partially inside the query range.
		int mid = (tl + tr) / 2;
		return tree[bfsIndex] = Math.max(update(data, ul, ur, tl, mid, 2 * bfsIndex + 1),
				update(data, ul, ur, mid + 1, tr, 2 * bfsIndex + 2));
	}

	private void pushDownUpdateOperand(int bfsIndex, int tl, int tr) {
		if (tl != tr) {
			tree[2 * bfsIndex + 1] += lazy[bfsIndex];
			tree[2 * bfsIndex + 2] += lazy[bfsIndex];

			lazy[2 * bfsIndex + 1] += lazy[bfsIndex];
			lazy[2 * bfsIndex + 2] += lazy[bfsIndex];

			// after pushdown to children reset the parent value.
			lazy[bfsIndex] = 0;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RangeUpdateAdditionRangeQueryMaxSegmentTree7 [tree=");
		builder.append(Arrays.toString(tree));
		builder.append(", lazy=");
		builder.append(Arrays.toString(lazy));
		builder.append("]");
		return builder.toString();
	}

}
