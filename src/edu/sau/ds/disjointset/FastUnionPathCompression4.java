package edu.sau.ds.disjointset;

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
 * Time complexity for a sequence of unions and finds is : O(mlogn)
 * 
 */
public class FastUnionPathCompression4 implements DisjointSet<Integer> {

	private int[] arr = null;

	@Override
	public void makeset(int size) {
		arr = new int[size];

		for (int element = 0; element < arr.length; element++)
			arr[element] = element;
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
		if (arr[element] == element) {
			return element;
		}
		arr[element] = find(arr[element]);
		return arr[element];
	}

	@Override
	public void union(Integer a, Integer b) {
		unionInternal(find(a), find(b));
	}

	/**
	 * Time Complexity: O(1)
	 */
	private void unionInternal(Integer aRep, Integer bRep) {
		arr[aRep] = bRep;
	}

}
