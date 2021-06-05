package edu.sau.ds.disjointset;

/**
 * Time Complexity for a sequence of m unions and finds: O(mn)
 */
public class FastUnionNaiveTree1 implements DisjointSet<Integer> {

	private int[] arr = null;

	@Override
	public void makeset(int size) {
		arr = new int[size];

		for (int element = 0; element < arr.length; element++)
			arr[element] = element;
	}

	/**
	 * Time complexity for single find: O(n)
	 * 
	 * Time complexity for m finds: O(m * n)
	 */
	@Override
	public Integer find(Integer element) {
		return arr[element] == element ? element : find(arr[element]);
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
