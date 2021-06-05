package edu.sau.ds.disjointset;

/**
 * UNION by Size (also called UNION by Weight): Make the smaller tree a subtree of the larger tree.
 * 
 * Set 1: {0, 1, 2} 0-->1<--2
 * 
 * Set 2: {3, 4} 3<--4
 * 
 * Set 3: {5, 6, 7, 8} 5<--6<--7<--8
 * 
 * Tree representation with size: {1, -3, 1, -2, 3, -4, 5, 6, 7}
 * 
 * Time complexity for a sequence of unions and finds is : O(mlogn)
 * 
 */
public class FastUnionSizeTree3 implements DisjointSet<Integer> {

	private int[] arr = null;

	@Override
	public void makeset(int size) {
		arr = new int[size];

		for (int element = 0; element < arr.length; element++)
			arr[element] = -1;
	}

	/**
	 * time complexity of single find is O(logn)
	 *
	 * time complexity of m finds is O(mlogn)
	 */
	@Override
	public Integer find(Integer element) {
		return arr[element] < 0 ? element : find(arr[element]);
	}

	/**
	 * since we are always merging smaller tree with larger tree so single find
	 * operation will be O(logn)
	 */
	@Override
	public void union(Integer a, Integer b) {
		int aRep = find(a);
		int bRep = find(b);

		int sizeOfA = Math.abs(arr[aRep]);
		int sizeOfB = Math.abs(arr[bRep]);

		// increase the size of tree B by size of tree A.
		arr[bRep] = -(sizeOfB + sizeOfA);

		if (sizeOfB < sizeOfA) {
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

}
