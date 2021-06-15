package edu.sau.ds.tree.segmenttree;

import java.util.Arrays;

import edu.sau.other.bitwise.BitwiseUtils;

/**
 * 1) bfsIndex is used for locating the index of node in tree array while doing
 * the tree traversal.
 * 
 * 2) Node segment(i.e. tl and tr) is used for binary search condition check.
 */
public class SumSegmentTree implements SegmentTree<Integer> {

	/**
	 * BFS indexed segment tree
	 */
	private final int tree[];
	private final int root_tl = 0;
	private final int root_tr;
	private final int bfs_index_start = 0;

	public SumSegmentTree(int[] elements, boolean isFull) {
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
		// CASE 1
		if (tr < ql || qr <= tl) {
			return 0;
		}
		// CASE 2
		if (ql <= tl && qr > tr) {
			return this.tree[bfsIndex];
		}
		int mid = (tl + tr) / 2;
		return rangeQuery(ql, qr, tl, mid, 2 * bfsIndex + 1) + rangeQuery(ql, qr, mid + 1, tr, 2 * bfsIndex + 2);
	}

	/**
	 * 
	 * */
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("sum segment tree=");
		builder.append(Arrays.toString(tree));
		return builder.toString();
	}

}
