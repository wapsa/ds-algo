package edu.sau.ds.tree.segmenttree;

import java.util.Arrays;

import edu.sau.ds.tree.segmenttree.MaxSubSegmentSumTree4.Data;

/**
 * 1) bfsIndex is used for locating the index of node in tree array while doing
 * the tree traversal.
 * 
 * 2) Node segment(i.e. tl and tr) is used for binary search condition check.
 */
public class MaxSubSegmentSumTree4 implements SegmentTree<Data> {

	/**
	 * BFS indexed segment tree
	 */
	private final Data tree[];
	private final int root_tl = 0;
	private final int root_tr;
	private final int bfs_index_start = 0;

	private final boolean flatInitialization;

	public MaxSubSegmentSumTree4(int[] elements, boolean flatInitialization) {
		super();
		this.flatInitialization = flatInitialization;
		this.tree = new Data[2 * elements.length - 1];
		this.root_tr = elements.length - 1;
		build(elements, this.bfs_index_start, this.root_tl, this.root_tr);
	}

	class Data {
		int sum, maxPrefSum, maxSuffSum, maxSum;

		public Data() {
			super();
		}

		public Data(int sum) {
			super();
			this.sum = sum;
			if (flatInitialization) {
				this.maxPrefSum = this.maxSuffSum = this.maxSum = sum;
			} else {
				this.maxPrefSum = this.maxSuffSum = this.maxSum = Math.max(sum, 0);
			}

		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[sum=");
			builder.append(sum);
			builder.append(", maxPrefSum=");
			builder.append(maxPrefSum);
			builder.append(", maxSuffSum=");
			builder.append(maxSuffSum);
			builder.append(", maxSum=");
			builder.append(maxSum);
			builder.append("]");
			return builder.toString();
		}

	}

	private Data build(int elements[], int bfsIndex, int tl, int tr) {
		if (tl == tr) {
			// When tl == tr, we have reached leaf nodes and leaf node is a segment in
			// itself and sum of the segment is the node value itself.
			return tree[bfsIndex] = new Data(elements[tl]);
		} else {
			int mid = (tl + tr) / 2;
			return tree[bfsIndex] = combine(build(elements, bfsIndex * 2 + 1, tl, mid),
					build(elements, bfsIndex * 2 + 2, mid + 1, tr));
		}
	}

	private Data combine(Data l, Data r) {
		Data res = new Data();

		res.sum = l.sum + r.sum;

		res.maxPrefSum = Math.max(l.maxPrefSum, l.sum + r.maxPrefSum);

		res.maxSuffSum = Math.max(r.maxSuffSum, r.sum + l.maxSuffSum);

		res.maxSum = Math.max(Math.max(l.maxSum, r.maxSum), l.maxSuffSum + r.maxPrefSum);
		return res;
	}

	@Override
	public Data rangeQuery(int left, int right) {
		return rangeQuery(left, right, this.root_tl, this.root_tr, this.bfs_index_start);
	}

	private Data rangeQuery(int ql, int qr, int tl, int tr, int bfsIndex) {
		// CASE 1 : node segment lies completely outside the query segment.
		if (tr < ql || qr <= tl) {
			return null;
		}
		// CASE 2 : node segment lies completely inside the query segment.
		if (ql <= tl && qr > tr) {
			return this.tree[bfsIndex];
		}
		int mid = (tl + tr) / 2;
		Data left = rangeQuery(ql, qr, tl, mid, 2 * bfsIndex + 1);
		Data right = rangeQuery(ql, qr, mid + 1, tr, 2 * bfsIndex + 2);
		if (left == null && right == null)
			throw new IllegalStateException("Both should never be null, something wrong with code.");
		if (left == null)
			return right;
		if (right == null)
			return left;
		return combine(left, right);

	}

	/**
	 * For update we follow binary search to find out the node to be updated. Parent
	 * nodes on the binary search path get recalculated on the return trip.
	 */
	@Override
	public void update(Data data, int index) {
		update(data.sum, index, this.root_tl, this.root_tr, this.bfs_index_start);
	}

	private void update(int data, int updateIndex, int tl, int tr, int bfsIndex) {
		// Node to be updated is found.
		if (tl == tr) {
			this.tree[bfsIndex] = new Data(data);
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
			this.tree[bfsIndex] = combine(tree[bfsIndex * 2 + 1], tree[bfsIndex * 2 + 2]);
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