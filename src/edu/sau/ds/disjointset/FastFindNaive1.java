package edu.sau.ds.disjointset;

public class FastFindNaive1 implements DisjointSet<Integer> {

	private int[] arr = null;

	/**
	 * If we have complex data: Map<ComplexData, Index> : value represents the index
	 * of the array.
	 * 
	 * arr: [0, 1, 2, 3, 4, 5]
	 * 
	 * array index: represents individual element or node.
	 * 
	 * array value: contains representative of set.
	 */
	@Override
	public void makeset(int size) {
		arr = new int[size];

		for (int element = 0; element < arr.length; element++)
			arr[element] = element;
	}

	@Override
	public Integer find(Integer element) {
		return arr[element];
	}

	/**
	 * Set the representative of a to b.
	 * 
	 * For each union we time complexity is O(n)
	 * 
	 * Since we have n elements so maximum possible unions is n-1
	 * 
	 * Time complexity for n-1 unions is O(n* (n-1)) = O(n^2)
	 */
	@Override
	public void union(Integer a, Integer b) {
		int aRep = find(a);
		int bRep = find(b);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == aRep) {
				arr[i] = bRep;
			}
		}
	}

}
