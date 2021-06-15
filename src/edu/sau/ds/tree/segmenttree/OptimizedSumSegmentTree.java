package edu.sau.ds.tree.segmenttree;

import java.util.Arrays;

import edu.sau.other.bitwise.BitwiseUtils;

/**
 * https://codeforces.com/blog/entry/18051
 * 
 * 1) Segment tree uses exactly 2 * n memory, not 4 * n like some other
 * implementations offer.
 * 
 * 2) Array elements are stored in continuous manner starting with index n.
 */
public class OptimizedSumSegmentTree implements SegmentTree<Integer> {

	/**
	 * BFS indexed segment tree
	 */
	private final int tree[];
	private final int root_tr;

	public OptimizedSumSegmentTree(int[] elements, boolean isFull) {
		super();
		if (isFull) {
			int powerOf2InputSize = getInputArraySizeAsPowerOf2(elements.length);
			this.root_tr = powerOf2InputSize - 1;
			this.tree = new int[2 * powerOf2InputSize - 1];
			buildFullSumSegmentTree(elements, powerOf2InputSize);
		} else {
			this.root_tr = elements.length - 1;
			this.tree = new int[2 * elements.length - 1];
			buildSumSegmentTree(elements, this.tree);
		}
	}

	/**
	 * We do not save the nodes segments explicitly, rather it is getting calculated
	 * on the fly using the root node's segment.
	 * 
	 * input array will be present in tree array at the end.
	 * 
	 * translation of input_array_index to tree_array_index:
	 * 
	 * tree_array_index = input_array_index + (input.length - 1)
	 * 
	 * OR
	 * 
	 * tree_array_index = input_array_index + root_tr
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
	private void buildSumSegmentTree(int[] elements, int[] tree) {
		// Copy the input array at the end of tree array.
		for (int i = 0; i < elements.length; i++) {
			tree[i + elements.length - 1] = elements[i];
		}
		// Build the sum nodes.
		int lastEmptyPosition = tree.length - elements.length - 1;
		for (int parentIndex = lastEmptyPosition; parentIndex >= 0; parentIndex--) {
			tree[parentIndex] = tree[2 * parentIndex + 1] + tree[2 * parentIndex + 2];
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
		buildSumSegmentTree(powerOf2Input, tree);
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

	/**
	 *
	 * <pre>
	 *
	 * WHEN 'tl' is even then we should include the tl-node value in query-sum and
	 * go to the parent of (tl+1)th node.
	 * Since tl is even so next node is odd, so parent of tl+1 node => parent = (tl+1-1)/2 = tl/2
	 * For odd child formula => 2*parent + 1 = child  i.e; parent =(child -1)/2; now substitute child with tl+1.
	 *
	 * WHEN 'tl' is odd then no need to include the value of tl-node in query-sum, and go to the parent of 'tl' node.
	 *
	 * WHEN 'tr' is even:
	 * Since tr is exclusive in query range, so if tr is even  then we should include the (tr-1)th node value in query-sum and go to the
	 * parent node of (tr-1).
	 * WHEN 'tr' is odd : then no need to include the value of (tr-1)th node in query-sum, and go to the parent of 'tr' node.
	 *
	 * </pre>
	 *
	 * tree_array_index = input_array_index + (input.length - 1)
	 *
	 * or tree_array_index = input_array_index + root_tr
	 *
	 * Time Complexity = O(logn)
	 *
	 */
	@Override
	public Integer rangeQuery(int ql, int qr) {
		int result = 0;
		for (int tl = ql + root_tr, tr = qr + root_tr; tl < tr; tl = BitwiseUtils.divideBy2(tl), tr = BitwiseUtils
				.divideBy2(tr)) {
			if (BitwiseUtils.isEvenNumber(tl))
				result += tree[tl];
			if (BitwiseUtils.isEvenNumber(tr))
				result += tree[--tr];
		}
		return result;
	}

	/**
	 * translation of input_array_index to tree_array_index:
	 * 
	 * tree_array_index = input_array_index + (input.length - 1)
	 * 
	 * OR
	 * 
	 * tree_array_index = input_array_index + root_tr
	 * 
	 * time complexity: O(logn)
	 */
	@Override
	public void update(Integer data, int index) {
		int treeArrayIndex = index + root_tr;
		tree[treeArrayIndex] = data;
		while (treeArrayIndex > 0) {
			int parentIndex = BitwiseUtils.isEvenNumber(treeArrayIndex) ? BitwiseUtils.divideBy2(treeArrayIndex - 2)
					: BitwiseUtils.divideBy2(treeArrayIndex - 1);

			tree[parentIndex] = tree[2 * parentIndex + 1] + tree[2 * parentIndex + 2];

			treeArrayIndex = parentIndex;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("optimized sum segment tree=");
		builder.append(Arrays.toString(tree));
		return builder.toString();
	}

}
