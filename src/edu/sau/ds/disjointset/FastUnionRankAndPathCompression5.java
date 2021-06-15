package edu.sau.ds.disjointset;

import java.util.Arrays;

/**
 * UNION by Path compression
 * 
 * Set 1: {0, 1, 2} 0-->1<--2
 * 
 * Set 2: {3, 4} 3<--4
 * 
 * Set 3: {5, 6, 7, 8} 5<--6<--7<--8
 * 
 * Tree representation with size: {1, 1, 1, 3, 3, 5, 5, 6, 7}
 * 
 * 
 * <pre>
 * 
 * The precise analysis of the performance of a disjoint-set forest is somewhat
 * intricate. However, there is a much simpler analysis that proves that the
 * amortized time for any m Find or Union operations on a disjoint-set forest
 * containing n objects is O(mlog* n), where log* denotes the iterated logarithm
 * 
 * Time complexity in terms of iterative log
 * ------------------------------------------------------------
 * The time complexity required to process m UNION and FIND-SET operations using
 * union-by-rank with path-compression heuristic is O(m log*n) in the worst
 * case. -- Which may be also said as O(m), as log*n ≤ 5 practically (as
 * otherwise n is more than the number of atoms in universe!!)
 * 
 * Time complexity in terms of Inverse Ackermann Function.
 * -----------------------------------------------------------
 * 
 * Theorem. [Tarjan 1975] Link-by-size with path compression performs any
 * intermixed sequence of m ≥ n FIND and n – 1 UNION operations in O(m * α(m, n))
 * time, where α(m, n) is a functional inverse of the Ackermann function.
 * 
 * m represents number of union and find operations.
 * n represents number of nodes.
 * 
 *  - Time complexity is inversely proportional to m.
 *  - Time complexity is directly proportional to n.
 * 
 * 
 * Theorem. [Tarjan-van Leeuwen 1984] Link-by- { size, rank } combined with
 * { path compression, path splitting, path halving } performs any intermixed
 * sequence of m ≥ n find and n – 1 union operations in O(m * α(m, n)) time.
 * 
 * </pre>
 * 
 */
public class FastUnionRankAndPathCompression5 implements DisjointSet<Integer> {

	private int[] arr = null;

	@Override
	public void makeset(int size) {
		arr = new int[size];

		for (int element = 0; element < arr.length; element++)
			arr[element] = -1;
	}

	/**
	 * 
	 * FIND operation traverses a list of nodes on the way to the root. We can make
	 * later FIND operations efficient by making each of these vertices point
	 * directly to the root. This process is called path compression. For example,
	 * in the FIND(X) operation, we travel from X to the root of the tree. The
	 * effect of path compression is that every node on the path from X to the root
	 * has its parent changed to the root.
	 * 
	 * Time complexity for single find: O(logn)
	 * 
	 * Time complexity for m finds: O(m * logn)
	 */
	@Override
	public Integer find(Integer element) {
		if (arr[element] < 0) {
			return element;
		}
		arr[element] = find(arr[element]);
		return arr[element];
	}

	@Override
	public void union(Integer a, Integer b) {
		int aRep = find(a);
		int bRep = find(b);

		int rankOfA = Math.abs(arr[aRep]);
		int rankOfB = Math.abs(arr[bRep]);

		if (rankOfA == rankOfB) {
			// when height of both the tree are same, then height of representative node
			// should be increased by 1
			arr[bRep] = -(rankOfB + 1);
		} else if (rankOfB < rankOfA) {
			// swap the representative such that smaller tree will be merged to bigger tree.
			int temp = bRep;
			bRep = aRep;
			aRep = temp;
		}
		unionInternal(aRep, bRep);
	}

	/**
	 * Time Complexity: O(1)
	 */
	private void unionInternal(Integer aRep, Integer bRep) {
		arr[aRep] = bRep;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[arr=");
		builder.append(Arrays.toString(arr));
		builder.append("]");
		return builder.toString();
	}

}
