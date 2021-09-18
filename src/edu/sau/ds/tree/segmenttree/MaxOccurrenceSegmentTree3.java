package edu.sau.ds.tree.segmenttree;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import edu.sau.ds.tree.segmenttree.SegmentTree.MaxST;
import edu.sau.other.bitwise.BitwiseUtils;

/**
 * 1) bfsIndex is used for locating the index of node in tree array while doing
 * the tree traversal.
 * 
 * 2) Node segment(i.e. tl and tr) is used for binary search condition check.
 */
public class MaxOccurrenceSegmentTree3 implements MaxST<Entry<Integer, Integer>> {

	/**
	 * BFS indexed segment tree
	 */
	private final Map.Entry<Integer, Integer>[] tree;
	private final int root_tl = 0;
	private final int root_tr;
	private final int bfs_index_start = 0;

	@SuppressWarnings("unchecked")
	public MaxOccurrenceSegmentTree3(int[] elements, boolean isFull) {
		super();
		int powerOf2InputSize = getInputArraySizeAsPowerOf2(elements.length);
		this.tree = new Map.Entry[2 * powerOf2InputSize - 1];
		if (isFull) {
			this.root_tr = powerOf2InputSize - 1;
			buildFullMaxOccurrenceSegmentTree(elements, powerOf2InputSize);
		} else {
			this.root_tr = elements.length - 1;
			buildMaxOccurrenceSegmentTree(elements, this.tree, this.bfs_index_start, this.root_tl, this.root_tr);
		}
	}

	private void buildFullMaxOccurrenceSegmentTree(int[] input, int powerOf2InputSize) {
		int[] powerOf2Input = input;
		if (input.length < powerOf2InputSize) {
			powerOf2Input = new int[powerOf2InputSize];
			System.arraycopy(input, 0, powerOf2Input, 0, input.length);
			Arrays.fill(powerOf2Input, input.length, powerOf2Input.length, Integer.MIN_VALUE);
		}
		buildMaxOccurrenceSegmentTree(powerOf2Input, tree, bfs_index_start, root_tl, root_tr);
	}

	private Map.Entry<Integer, Integer> buildMaxOccurrenceSegmentTree(int[] elements,
			Map.Entry<Integer, Integer>[] tree, int bfsIndex, int tl, int tr) {
		if (tl == tr) {
			// When tl == tr, we have reached leaf nodes and leaf node is a segment in
			// itself and max of the segment is the node value itself.
			return tree[bfsIndex] = Map.entry(elements[tl], 1);
		} else {
			int mid = (tl + tr) / 2;
			return tree[bfsIndex] = maxOccurrenceEntry(
					buildMaxOccurrenceSegmentTree(elements, tree, 2 * bfsIndex + 1, tl, mid),
					buildMaxOccurrenceSegmentTree(elements, tree, 2 * bfsIndex + 2, mid + 1, tr));
		}
	}

	private Map.Entry<Integer, Integer> maxOccurrenceEntry(Map.Entry<Integer, Integer> a,
			Map.Entry<Integer, Integer> b) {
		Map.Entry<Integer, Integer> temp = null;

		int comp = Integer.compare(a.getKey(), b.getKey());
		if (comp > 0)
			temp = a;
		else if (comp < 0)
			temp = b;
		else if (comp == 0)
			temp = Map.entry(a.getKey(), a.getValue() + b.getValue());

		return temp;
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
	public Entry<Integer, Integer> rangeQuery(int left, int right) {
		return rangeQuery(left, right, this.root_tl, this.root_tr, this.bfs_index_start);
	}

	private Entry<Integer, Integer> rangeQuery(int ql, int qr, int tl, int tr, int bfsIndex) {
		// CASE 1 : node segment lies completely outside the query segment.
		if (tr < ql || qr <= tl) {
			return Map.entry(Integer.MIN_VALUE, 0);
		}
		// CASE 2 : node segment lies completely inside the query segment.
		if (ql <= tl && qr > tr) {
			return this.tree[bfsIndex];
		}
		int mid = (tl + tr) / 2;
		return maxOccurrenceEntry(rangeQuery(ql, qr, tl, mid, 2 * bfsIndex + 1),
				rangeQuery(ql, qr, mid + 1, tr, 2 * bfsIndex + 2));
	}

	@Override
	public int findFirstGreaterElementInGivenQueryRange(int data, int ql, int qr) {
		if (tree[this.bfs_index_start].getKey() < data) {
			return Integer.MIN_VALUE;
		}
		return findFirstGreaterElementInGivenQueryRange(this.bfs_index_start, this.root_tl, this.root_tr, ql, qr, data);
	}

	int findFirstGreaterElementInGivenQueryRange(int bfsIndex, int tl, int tr, int ql, int qr, int data) {
		if (tl > qr || tr < ql)
			return Integer.MIN_VALUE;

		if (ql <= tl && tr <= qr) {
			if (tree[bfsIndex].getKey() < data)
				return Integer.MIN_VALUE;
			if (tl == tr)
				return tl;
		}

		int mid = (tl + tr) / 2;
		int rs = findFirstGreaterElementInGivenQueryRange(2 * bfsIndex + 1, tl, mid, ql, qr, data);
		if (rs != Integer.MIN_VALUE)
			return rs;
		return findFirstGreaterElementInGivenQueryRange(2 * bfsIndex + 2, mid + 1, tr, ql, qr, data);
	}

	/**
	 * For update we follow binary search to find out the node to be updated. Parent
	 * nodes on the binary search path get recalculated on the return trip.
	 */
	@Override
	public void update(Entry<Integer, Integer> data, int index) {
		update(data.getKey(), index, this.root_tl, this.root_tr, this.bfs_index_start);
	}

	private void update(int data, int updateIndex, int tl, int tr, int bfsIndex) {
		// Node to be updated is found.
		if (tl == tr) {
			this.tree[bfsIndex] = Map.entry(data, 1);
		} else {
			int mid = (tl + tr) / 2;
			if (updateIndex <= mid) {
				// go left
				update(data, updateIndex, tl, mid, 2 * bfsIndex + 1);
			} else {
				// go right
				update(data, updateIndex, mid + 1, tr, 2 * bfsIndex + 2);
			}
			// re calculate max on return trip after updating the data.
			this.tree[bfsIndex] = maxOccurrenceEntry(this.tree[2 * bfsIndex + 1], this.tree[2 * bfsIndex + 2]);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("max occurrence segment tree=");
		builder.append(Arrays.toString(tree));
		return builder.toString();
	}

}
