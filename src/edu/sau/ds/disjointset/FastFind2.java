package edu.sau.ds.disjointset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity for a sequence of m unions and finds using optimized union:
 * O(m logn)
 */
public class FastFind2 implements DisjointSet<Integer> {

	private int[] arr = null;

	private Map<Integer, List<Integer>> intermediateUnionSetsMap = new HashMap<>();

	@Override
	public void makeset(int size) {
		arr = new int[size];
		for (int element = 0; element < arr.length; element++) {
			arr[element] = element;
			intermediateUnionSetsMap.put(element, List.of(element));
		}
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
		// naiveUnion(a, b);
		optimizedUnion(a, b);
	}

	/**
	 * <pre>
	 * If we do union as follows: union(0)-->union(1)-->union(2)-->union(3)-->union(4)
	 * Time Complexity: 				1		   2		  3			 4        n-1
	 * 
	 * 1+2+3+4...n = n(n+1)/2 = n^2
	 * 
	 * </pre>
	 */
	private void naiveUnion(Integer a, Integer b) {
		int aRep = find(a);
		int bRep = find(b);

		List<Integer> aRepSet = intermediateUnionSetsMap.get(aRep);
		List<Integer> bRepSet = intermediateUnionSetsMap.get(bRep);

		for (Integer element : aRepSet) {
			arr[element] = bRep;
			bRepSet.add(element);
		}
		aRepSet.clear();

	}

	/**
	 * Whenever we merge the smaller set to larger set, merge time complexity is
	 * log(n)
	 * 
	 * Since we have total union operation n, total time complexity is O(n * logn)
	 */
	private void optimizedUnion(Integer a, Integer b) {
		int aRep = find(a);
		int bRep = find(b);

		List<Integer> aRepSet = intermediateUnionSetsMap.get(aRep);
		List<Integer> bRepSet = intermediateUnionSetsMap.get(bRep);

		if (aRepSet.size() > bRepSet.size()) {
			// swap the sets, so that we will always iterate the smaller one
			List<Integer> temp = aRepSet;
			aRepSet = bRepSet;
			bRepSet = temp;
		}

		for (Integer element : aRepSet) {
			arr[element] = bRep;
			bRepSet.add(element);
		}
		aRepSet.clear();

	}

}
