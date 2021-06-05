package edu.sau.ds.disjointset;

/**
 * UNION by Height (also called UNION by Rank): Make the tree with less height a
 * subtree of the tree with more height
 * 
 * Set 1: {0, 1, 2} 0-->1<--2
 * 
 * Set 2: {3, 4} 3<--4
 * 
 * Set 3: {5, 6, 7, 8} 5<--6<--7<--8
 * 
 * Tree representation with rank: {1, -1, 1, -1, 3, -3, 5, 6, 7}
 * 
 * Parent node contains height of the tree as rank (-ve).
 * 
 * Time complexity for a sequence of unions and finds is : O(mlogn)
 * 
 */
public class FastUnionRankTree2 implements DisjointSet<Integer> {

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

		int rankOfA = Math.abs(arr[aRep]);
		int rankOfB = Math.abs(arr[bRep]);

		if (rankOfA == rankOfB) {
			// when height of both the tree are same, then height of representative node
			// should be increased by 1.
			arr[bRep] -= arr[bRep];
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

}
