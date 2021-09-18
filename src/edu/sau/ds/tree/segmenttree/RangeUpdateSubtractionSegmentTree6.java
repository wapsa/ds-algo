package edu.sau.ds.tree.segmenttree;

import java.util.Arrays;

import edu.sau.other.bitwise.BitwiseUtils;

/**
 * <pre>
 * Lazy propagation : https://cp-algorithms.com/data_structures/segment_tree.html : Section "Assignment on segments"
 *
 * Context :
 * In general, query operation happens in bottom up approach, means if operator is ordered then we
 * need to apply the operands in there occurrence order.
 * We keep the actual data on leaf node and other range-update-operands on intermediate nodes.
 * In case of range-update-operands order collision, we need to push-down(propagate) the old operand to left and right child so that operand occurrence order remain intact.
 *
 * To keep the complexity of update and query to log(n), we apply lazy propagation i.e. lazy push-down of operands.
 *
 * This push-down operation is piggy-backed on implicit branching steps of update and query, we don't explicitly push-down the operands.
 * This is why the name is Lazy Propagation.
 *
 * Summarizing we get: for any queries (a modification or reading query) during the descent along the tree we should always
 * push information from the current vertex into both of its children.
 * We can understand this in such a way, that when we descent the tree we apply delayed modifications, but exactly as much as necessary
 * so not to degrade the complexity of O(logn).
 *
 *
 * Lazy propagation in case of subtraction:
 *
 * Here we need to implement lazy propagation because subtraction operation is
 * order dependent i.e  a - b - c  NOT_EQUQL_TO  b -a - c
 * e.g a = 10, b=5, c=2
 * a - b - c = 3
 * b - a - c = -7
 *
 *
 * --original elements are present at leaf node
 *
 * --intermediate nodes are void
 *
 * Note : Intermediate nodes represents subtraction operation.
 *
 * </pre>
 *
 */
public class RangeUpdateSubtractionSegmentTree6 implements RangeUpdateSegmentTree<Integer> {

	private final Integer tree[];
	private final int root_tl = 0;
	private final int root_tr;
	private final int bfs_index_start = 0;

	public RangeUpdateSubtractionSegmentTree6(int[] elements) {
		super();
		int powerOf2InputSize = getInputArraySizeAsPowerOf2(elements.length);
		this.tree = new Integer[2 * powerOf2InputSize - 1];
		this.root_tr = elements.length - 1;
		buildSumSegmentTree(elements, tree, bfs_index_start, root_tl, root_tr);
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
	private void buildSumSegmentTree(int[] elements, Integer[] tree, int bfsIndex, int tl, int tr) {
		if (tl == tr) {
			tree[bfsIndex] = elements[tl];
		} else {
			tree[bfsIndex] = null;
			int mid = (tl + tr) / 2;
			buildSumSegmentTree(elements, tree, 2 * bfsIndex + 1, tl, mid);
			buildSumSegmentTree(elements, tree, 2 * bfsIndex + 2, mid + 1, tr);
		}
	}

	/**
	 * We need to do binary search using node range to find out the element at given
	 * input index.
	 */
	@Override
	public Integer query(int index) {
		// return queryWithoutPushDown(index, this.root_tl, this.root_tr,
		// this.bfs_index_start);
		return queryWithPushDown(index, this.root_tl, this.root_tr, this.bfs_index_start);
	}

	private Integer queryWithoutPushDown(int index, int tl, int tr, int bfsIndex) {
		if (tl == tr)
			return tree[bfsIndex];

		int result;
		int tm = (tl + tr) / 2;
		if (index <= tm)
			result = queryWithoutPushDown(index, tl, tm, 2 * bfsIndex + 1);
		else
			result = queryWithoutPushDown(index, tm + 1, tr, 2 * bfsIndex + 2);

		if (tree[bfsIndex] != null)
			result -= tree[bfsIndex];

		return result;
	}

	private Integer queryWithPushDown(int index, int tl, int tr, int bfsIndex) {
		if (tl == tr)
			return tree[bfsIndex];

		pushDownUpdateOperand(bfsIndex, tl, tr);

		int tm = (tl + tr) / 2;
		if (index <= tm)
			return queryWithPushDown(index, tl, tm, 2 * bfsIndex + 1);
		else
			return queryWithPushDown(index, tm + 1, tr, 2 * bfsIndex + 2);
	}

	/**
	 * 
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

		pushDownUpdateOperand(bfsIndex, tl, tr);

		// Case 2: when node lies completely inside the given range.
		if (tl >= ul && tr < ur) {
			if (tl == tr) {
				tree[bfsIndex] -= data;
			} else {
				tree[bfsIndex] = data;
			}
			return;
		}
		// Case 3: when tree node lies partially inside the query range.
		int mid = (tl + tr) / 2;
		update(data, ul, ur, tl, mid, 2 * bfsIndex + 1);
		update(data, ul, ur, mid + 1, tr, 2 * bfsIndex + 2);
	}

	private void pushDownUpdateOperand(int bfsIndex, int tl, int tr) {

		// no pushdown if node is leaf node.
		if (this.tree[bfsIndex] != null && tl != tr) {

			int mid = (tl + tr) / 2;

			int leftChildIndex = 2 * bfsIndex + 1;
			int rightChildIndex = 2 * bfsIndex + 2;

			// node is an intermediate void node.
			if (this.tree[leftChildIndex] == null)
				tree[leftChildIndex] = tree[bfsIndex];
			else {
				// left child is leaf node.
				if (tl == mid)
					tree[leftChildIndex] -= tree[bfsIndex];
				else
					// if left child is intermediate node but is not a void node.
					tree[leftChildIndex] = createCompositeOperand(tree[leftChildIndex], tree[bfsIndex]);
			}

			// node is an intermediate void node.
			if (this.tree[rightChildIndex] == null)
				tree[rightChildIndex] = tree[bfsIndex];
			else {
				// right child is leaf node.
				if (tr == mid + 1)
					tree[rightChildIndex] -= tree[bfsIndex];
				else
					// if right child is intermediate node but is not a void node.
					tree[rightChildIndex] = createCompositeOperand(tree[rightChildIndex], tree[bfsIndex]);
			}
			// post push-down un-mark the parent node.
			tree[bfsIndex] = null;
		}

	}

	private int createCompositeOperand(int oldOperand, int newOperand) {
		return oldOperand + newOperand;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RangeUpdateSubtractionSegmentTree6 [tree=");
		builder.append(Arrays.toString(tree));
		builder.append("]");
		return builder.toString();
	}

}
