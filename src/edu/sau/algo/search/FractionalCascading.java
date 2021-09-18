package edu.sau.algo.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Context: Binary search on 'k' sorted lists of size 'n'
 * 
 * <pre>
 * 
 * 
 * Naive Approach(k-binary searches): Apply binary search on each list.
 * Time Complexity: k * log(n)
 * Space Complexity: k * n
 * 
 * 
 * Unified Binary Search: Merge all lists into one single list. Create a position tuple of size 'k' for each element
 * which will contain index of the element in each list.
 * Time Complexity: log(k*n) + k	| log(k*n) for binary search on unified list. 
 * 									| 'k' constant time to navigate to index of each list in the position tuple.
 * Space Complexity: k * k * n      | size of unified list k * n
 * 									| against each element we have position tuple of size 'k'
 * 
 * 
 * Fractional Cascading: 
 * /**
 * Context : Binary Search on K sorted lists each of size n.
 *
 * <pre>
 * Approach 1 : Naive, Do binary search on each list.
 * Time Complexity : k*log(n)
 * Space Complexity :k*n
 *
 * Approach 2: Unified Binary Search: Merge all lists into one single list.
 *             Bridge : Create a position tuple of size K against each element of unified list.
 *             Position tuple contains index of the given element in each list.
 *
 * Time Complexity : log(k*n) -> for binary search on unified list
 *                 : constant time to navigate to index of each list in the position tuple;
 *                   So total time to navigate  = K
 *                 : Total time complexity : K + log(k*n) = K + logK + logn = (K + logn)  
 *                
 * Space Complexity : size of unified list = (K*n), and against each element we have tuple of size K
 *                  : total space ; (K*n)*k = K^2n
 *                 
 *                                           
 * Fractional Cascading: Fractional cascading is a simple technique that allows you to improve the running time of multiple binary searches,
 * which are conducted at the same time.
 *            
 * PreProcessing and Bridge creation:
 *
 * STEP 1: The first step in pre-processing is to create 'K' merged lists from k original lists.
 * These merged lists are created in bottom-up fashion. Lets denote the merged list with M[list_number] and original list with L[list_number]
 *
 * Sorted(M[k])    = L[k]     +   {}
 * Sorted(M[k-1])  = L[k -1]  +  EVERY_ALTERNATE_ELEMENNT_OF_M[k]
 * Sorted(M[k-2])  = L[k -2]  +  EVERY_ALTERNATE_ELEMENNT_OF_M[k-1]
 *  .......
 * Sorted(M[0])   = L[0]      +  EVERY_ALTERNATE_ELEMENNT_OF_M[1]
 *   
 * STEP 2: Position tuple : Need to attach 2-index position tuple as bridge to every element of merged list.
 * First index of tuple represents position of element in L[k] list.
 * Second index of tuple represents position of element in L[k-1] list.  
 *
 * Search Algo:
 * STEP 1:  Need to perform binary search on M[0] merged list to figure-out the  position of target_value.
 * STEP 2: Bridge traversal to figure-out position of target value in original lists.
 *        position tuple of target_value in M[0] => provides the position of target_value in L[0] list and position of target_value in M[1] list
 *        position tuple of target_value in M[1] => provides the position of target_value in L[1] list and position of target_value in M[2] list
 *        .....
 *   Similarly, position of target_value in all the original list can be traversed with the help of position tuple bridge.  
 *       
 *
 *  NUMBER OF ELEMENT IN MERGED LIST
 *
 *   Lets calculate the number of elements in  M[0] list, by assuming each original list contains n elements
 *  
 *  SIZE_M[0] = all_elements_of_L[0] + 1/2(elements_of_L[1]) + 1/4(elements_of_L[2]) + 1/8(elements_of_L[3]) + ...
 *  SIZE_M[0] =  n + 1/2(n) + 1/4(n) + 1/8(n) + ...
 *            =  n +n(1/2 + 1/4 +1/8 + ..)
 *            =  n +n(1)
 *            =  2n
 *  Thus, any merged list can contain at most 2n elements.         
 *                                                    
 *                                                       
 *  
 *  Time Complexity :
 *   STEP1: binary search on M[0] =>  log(2n) = log2 + logn = logn
 *   STEP2 :bridge traversal = K
 *  
 *   total time complexity = O(K + logn)
 *  
 * Space Complexity :
 *    Since each merged list size cannot grow beyond 2n, so total size of K merged list cannot grow beyond =  K*2n
 *    Since each element of merged list is associated with 2-sized tuple bridge, so the size of tuple elements for each merged list would be at max 2 * 2n = 4n.
 *    Total size of tuple elements for k merged list cannot grow beyond = K*4n.
 *   
 * Total space complexity = 2n*k + 4n*k = 6n*k = O(nK)s
 * 
 *   Question : Why do we pick  alternate elements  while forming the merged list ? Why don't we pick the total element ?
 *   Answer : By picking every other element from lower-level lists, we fill the gaps in value ranges in the original list L[i],
 *            thus giving us a uniform spread of values across all merged lists. If we don't pick the alternate elements we may get
 *            skewed merged list and in worst case we could have time complexity of Naive approach i.e. K*log(n).
 *
 *
 * Applications : Computational Geometry, range searches, packet filtering etc.
 * 
 * 
 * Question : Why is the name fractional cascading ?
 *
 * Fractional: is because we merge 1/2th fraction of every lower M[K+1] list to L[K] list.
 * Fraction may be anything but the most optimum one is 1/2 because there would be less number of comparisons and optimum bridge traversal.
 *
 * Cascading: is because we merge the lower list to upper list in recursive fashion.
 *
 *
 * Merged-list is composed of two type of elements:
 * 1. Non-cascaded element : is the original-list element at the same level.
 * 2. Cascaded element : is the element from lower level merged-list.
 *
 * Property of MERGED-LIST in terms of bridge traversal:
 * 1. Bridge traversal via Cascaded element: it causes the control to land on the same element in lower-level-merged-list.
 * 2. Bridge traversal via Non-Cascaded element : it causes the control to land on the successor element in lower-level-merged-list.
 * </pre>
 * 
 * 
 * 
 * 
 */
public class FractionalCascading {

	private static final List<int[]> ORIGINAL_LIST = prepareOriginalList();

	private static List<int[]> prepareOriginalList() {
		List<int[]> temp = new ArrayList<>(6);
		temp.add(new int[] { Integer.MIN_VALUE, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, Integer.MAX_VALUE });
		temp.add(new int[] { Integer.MIN_VALUE, 5, 15, 25, 35, 45, 55, 65, 75, 85, 95, Integer.MAX_VALUE });
		temp.add(new int[] { Integer.MIN_VALUE, -7, -5, -3, -3, -3, -1, 0, 9, 18, 27, 36, Integer.MAX_VALUE });
		temp.add(new int[] { Integer.MIN_VALUE, -3, 0, 3, 6, 9, 12, 15, 18, 21, 24, Integer.MAX_VALUE });
		temp.add(new int[] { Integer.MIN_VALUE, -3, 6, 12, 18, 24, 30, 36, 42, 48, 54, Integer.MAX_VALUE });
		temp.add(new int[] { Integer.MIN_VALUE, -45, -36, -27, -18, -9, 0, 9, 18, 27, 36, Integer.MAX_VALUE });
		return Collections.unmodifiableList(temp);
	}

	private static final Map<Integer, Data[]> MERGED_LIST = new HashMap<>(ORIGINAL_LIST.size());

	public static void main(String[] args) {
		prepareMergedListWithBridge();

		IntStream.range(0, MERGED_LIST.size()).forEach(i -> {
			System.out.println("index: " + i + ", val: " + Arrays.toString(MERGED_LIST.get(i)));
		});
		System.out.println("--------------------------------------------");
		IntStream.range(0, ORIGINAL_LIST.size()).forEach(i -> {
			System.out.println("index: " + i + ", val: " + Arrays.toString(ORIGINAL_LIST.get(i)));
		});

		System.out.println("--------------------------------------------");
		testFind();
		System.out.println("--------------------------------------------");
		testFindPredecessor();
		System.out.println("--------------------------------------------");
		testFindSuccessor();
	}

	private static void testFind() {
		System.out.println("Finding 18: " + find(18));
		System.out.println("Finding -2: " + find(-2));
		System.out.println("Finding -3: " + find(-3));
		System.out.println("Finding 0: " + find(0));
		System.out.println("Finding -45: " + find(-45));
		System.out.println("Finding 60: " + find(60));
	}

	private static void testFindPredecessor() {
		System.out.println("Finding Predecessor 18: " + findPredecessor(18));
		System.out.println("Finding Predecessor -2: " + findPredecessor(-2));
		System.out.println("Finding Predecessor -3: " + findPredecessor(-3));
		System.out.println("Finding Predecessor 0: " + findPredecessor(0));
		System.out.println("Finding Predecessor -45: " + findPredecessor(-45));
		System.out.println("Finding Predecessor 60: " + findPredecessor(60));
	}

	private static void testFindSuccessor() {
		System.out.println("Finding Successor 18: " + findSuccessor(18));
		System.out.println("Finding Successor -2: " + findSuccessor(-2));
		System.out.println("Finding Successor -3: " + findSuccessor(-3));
		System.out.println("Finding Successor 0: " + findSuccessor(0));
		System.out.println("Finding Successor -45: " + findSuccessor(-45));
		System.out.println("Finding Successor 60: " + findSuccessor(60));
	}

	/**
	 * Finding the given element in each list : there are k sorted lists of numbers,
	 * and we must find in each list the given target_number
	 * 
	 * targetVal must lie between Integer.MIN_VALUE and Integer.MAX_VALUE
	 */
	private static Map<Integer, List<?>> find(int targetVal) {
		Map<Integer, List<?>> result = new HashMap<>(MERGED_LIST.size());

		Data[] ml0 = MERGED_LIST.get(0);
		int mergedIdx = bisectLeft(ml0, targetVal, 0, ml0.length - 1);

		for (int i = 0; i < ORIGINAL_LIST.size(); i++) {

			int[] originalList = ORIGINAL_LIST.get(i);
			Data[] mergedList = MERGED_LIST.get(i);

			int originalIdx;

			/**
			 * <pre>
			 *Property of MERGED-LIST in terms of bridge traversal:
			 * 1. Bridge traversal via Cascaded element: it causes the control to land on the same element in lower-level-merged-list.
			 * 2. Bridge traversal via Non-Cascaded element : it causes the control to land on the successor element in lower-level-merged-list.
			 *
			 * 'mergedIndex' would be either of Cascaded-element or Non-Cascaded-element.
			 * If the mergedIndex is of Cascaded-element then  'bridge.mergedListPosition' will hold the value of same-element in lower-merged-list.
			 * If the mergedIndex is of Non-Cascaded-element then 'bridge.mergedListPosition' will hold the value of successor-element/same-element in lower-merged-list.
			 *
			 * Since bridge traversal causes the control to land on the same-element or successor-element in lower-level-merged-list, so we need to search the
			 * target-value at 'mergedIndex' or 'mergedIndex - 1' in lower-level-merged-list.
			 *
			 * </pre>
			 */
			if (targetVal <= mergedList[mergedIdx - 1].value) {
				originalIdx = mergedList[mergedIdx - 1].bridge.posInOrigList;
				mergedIdx = mergedList[mergedIdx - 1].bridge.posInMergedList;
			} else {
				originalIdx = mergedList[mergedIdx].bridge.posInOrigList;
				mergedIdx = mergedList[mergedIdx].bridge.posInMergedList;
			}

			if (originalList[originalIdx] == targetVal) {
				result.put(i, List.of(true, "idx: " + originalIdx));
			} else {
				result.put(i, List.of(false, "idx: " + originalIdx));
			}
		}
		return result;
	}

	/**
	 * Finding Predecessor in each list : there are k sorted lists of numbers, and
	 * we must find in each list the first_number less than or equal to the given
	 * target_number
	 * 
	 * targetVal must lie between Integer.MIN_VALUE and Integer.MAX_VALUE
	 */
	private static Map<Integer, List<?>> findPredecessor(int targetVal) {
		Map<Integer, List<?>> result = new HashMap<>(MERGED_LIST.size());

		Data[] ml0 = MERGED_LIST.get(0);
		int mergedIdx = bisectLeft(ml0, targetVal, 0, ml0.length - 1);

		for (int i = 0; i < ORIGINAL_LIST.size(); i++) {

			int[] originalList = ORIGINAL_LIST.get(i);
			Data[] mergedList = MERGED_LIST.get(i);

			int originalIdx;

			if (targetVal <= mergedList[mergedIdx - 1].value) {
				originalIdx = mergedList[mergedIdx - 1].bridge.posInOrigList;
				mergedIdx = mergedList[mergedIdx - 1].bridge.posInMergedList;
			} else {
				originalIdx = mergedList[mergedIdx].bridge.posInOrigList;
				mergedIdx = mergedList[mergedIdx].bridge.posInMergedList;
			}
			result.put(i, List.of("idx: " + (originalIdx - 1), "val: " + originalList[originalIdx - 1]));
		}
		return result;
	}

	/**
	 * Finding Successor in each list : there are k sorted lists of numbers, and we
	 * must find in each list the first_number greater than or equal to the given
	 * target_number
	 * 
	 * targetVal must lie between Integer.MIN_VALUE and Integer.MAX_VALUE
	 */
	private static Map<Integer, List<?>> findSuccessor(int targetVal) {
		Map<Integer, List<?>> result = new HashMap<>(MERGED_LIST.size());

		Data[] ml0 = MERGED_LIST.get(0);
		int mergedIdx = bisectLeft(ml0, targetVal, 0, ml0.length - 1);

		for (int i = 0; i < ORIGINAL_LIST.size(); i++) {

			int[] originalList = ORIGINAL_LIST.get(i);
			Data[] mergedList = MERGED_LIST.get(i);

			int originalIdx;

			if (targetVal <= mergedList[mergedIdx - 1].value) {
				originalIdx = mergedList[mergedIdx - 1].bridge.posInOrigList;
				mergedIdx = mergedList[mergedIdx - 1].bridge.posInMergedList;
			} else {
				originalIdx = mergedList[mergedIdx].bridge.posInOrigList;
				mergedIdx = mergedList[mergedIdx].bridge.posInMergedList;
			}

// 			If duplicates are not allowed in list, below code is sufficient.

//			if (originalList[originalIdx] <= targetVal) {
//				result.put(i, List.of(originalIdx + 1, originalList[originalIdx + 1]));
//			} else {
//				result.put(i, List.of(originalIdx, originalList[originalIdx]));
//			}

			originalIdx = bisectRight(originalList, targetVal, originalIdx, originalList.length - 1);
			result.put(i, List.of("idx: " + originalIdx, "val: " + originalList[originalIdx]));
		}
		return result;
	}

	private static void prepareMergedListWithBridge() {
		int[] firstList = ORIGINAL_LIST.get(ORIGINAL_LIST.size() - 1);
		Data[] initialMergedList = new Data[firstList.length];
		IntStream.range(0, firstList.length).forEach(i -> {
			initialMergedList[i] = new Data(firstList[i], new Bridge(i, i));
		});
		MERGED_LIST.put(ORIGINAL_LIST.size() - 1, initialMergedList);

		for (int i = ORIGINAL_LIST.size() - 2; i >= 0; i--) {
			MERGED_LIST.put(i, merge(ORIGINAL_LIST.get(i), MERGED_LIST.get(i + 1)));
		}
	}

	private static Data[] merge(int[] originalList, Data[] mergedList) {
		Data[] resultMergedList = new Data[originalList.length + mergedList.length / 2];

		int leftIndexOriginalList = 0, leftIndexMergedList = 0;
		int rightIndexOriginalList = 0, rightIndexMergedList = 1, insIdx = 0;

		while (rightIndexOriginalList < originalList.length && rightIndexMergedList < mergedList.length) {

			if (originalList[rightIndexOriginalList] <= mergedList[rightIndexMergedList].value) {

				int posInOrigList = rightIndexOriginalList;
				int bisectPosInMergedList = bisectLeft(mergedList, originalList[rightIndexOriginalList],
						leftIndexMergedList, rightIndexMergedList);

				resultMergedList[insIdx] = new Data(originalList[rightIndexOriginalList],
						new Bridge(posInOrigList, bisectPosInMergedList));

				// if we run into consecutive duplicates, do not move the left index.
				if (originalList[leftIndexOriginalList] != originalList[rightIndexOriginalList])
					leftIndexOriginalList = rightIndexOriginalList;

				rightIndexOriginalList++;

			} else {
				int bisectPosInOrigList = bisectLeft(originalList, mergedList[rightIndexMergedList].value,
						leftIndexOriginalList, rightIndexOriginalList);
				int posInMergedList = rightIndexMergedList;

				resultMergedList[insIdx] = new Data(mergedList[rightIndexMergedList].value,
						new Bridge(bisectPosInOrigList, posInMergedList));

				// if we run into consecutive duplicates, do not move the left index.
				if (mergedList[leftIndexMergedList] != mergedList[rightIndexMergedList])
					leftIndexMergedList = rightIndexMergedList;

				rightIndexMergedList += 2;
			}
			insIdx++;
		}
		while (rightIndexOriginalList < originalList.length) {
			resultMergedList[insIdx] = new Data(originalList[rightIndexOriginalList],
					new Bridge(rightIndexOriginalList, mergedList.length));
			insIdx++;
			rightIndexOriginalList++;
		}
		while (rightIndexMergedList < mergedList.length) {
			resultMergedList[insIdx] = new Data(mergedList[rightIndexMergedList].value,
					new Bridge(originalList.length, rightIndexMergedList));
			insIdx++;
			rightIndexMergedList += 2;
		}
		return resultMergedList;
	}

	/**
	 * Locate the insertion point for targetVal in originalList to maintain sorted
	 * order. The parameters leftIndex and rightIndex should be used to specify a
	 * subset of the list which should be considered
	 * 
	 * If targetVal is already present in originalList, the insertion point will be
	 * before (to the left of) any existing entries. left-most insertion index
	 */
	private static int bisectLeft(int[] originalList, int targetVal, int leftIndex, int rightIndex) {
		while (leftIndex < rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			if (originalList[mid] < targetVal)
				leftIndex = mid + 1;
			// in case of duplicate equal element, we still need to search left part to find
			// leftmost targetVal.
			else if (originalList[mid] == targetVal)
				rightIndex = mid;
			else
				rightIndex = mid;
		}
		return leftIndex;
	}

	/**
	 * Locate the insertion point for targetVal in mergedList to maintain sorted
	 * order. The parameters leftIndex and rightIndex should be used to specify a
	 * subset of the list which should be considered
	 * 
	 * If targetVal is already present in mergedList, the insertion point will be
	 * before (to the left of) any existing entries. left-most insertion index
	 */
	private static int bisectLeft(Data[] mergedList, int targetVal, int leftIndex, int rightIndex) {
		while (leftIndex < rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			if (mergedList[mid].value < targetVal)
				leftIndex = mid + 1;
			else if (mergedList[mid].value == targetVal)
				rightIndex = mid;
			else
				rightIndex = mid;
		}
		return leftIndex;
	}

	/**
	 * Locate the insertion point for targetVal in originalList to maintain sorted
	 * order. The parameters leftIndex and rightIndex should be used to specify a
	 * subset of the list which should be considered
	 * 
	 * If targetVal is already present in originalList, the insertion point will be
	 * before (to the left of) any existing entries. left-most insertion index
	 */
	private static int bisectRight(int[] originalList, int targetVal, int leftIndex, int rightIndex) {
		while (leftIndex < rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			// in case of duplicate equal element, we still need to search right part to
			// find rightmost targetVal.
			if (originalList[mid] <= targetVal)
				leftIndex = mid + 1;
			else
				rightIndex = mid;
		}
		return leftIndex;
	}

	/**
	 * Locate the insertion point for targetVal in mergedList to maintain sorted
	 * order. The parameters leftIndex and rightIndex should be used to specify a
	 * subset of the list which should be considered
	 * 
	 * If targetVal is already present in mergedList, the insertion point will be
	 * before (to the left of) any existing entries. left-most insertion index
	 */
	private static int bisectRight(Data[] mergedList, int targetVal, int leftIndex, int rightIndex) {
		while (leftIndex < rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			if (mergedList[mid].value <= targetVal)
				leftIndex = mid + 1;
			else
				rightIndex = mid;
		}
		return leftIndex;
	}

	private static class Data {
		private final int value;
		private final Bridge bridge;

		public Data(int value, Bridge bridge) {
			super();
			this.value = value;
			this.bridge = bridge;
		}

		public int getValue() {
			return value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + value;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Data other = (Data) obj;
			if (value != other.value)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return String.valueOf(value) + "(" + bridge + ")";
		}

	}

	private static class Bridge {
		final int posInOrigList;
		final int posInMergedList;

		private Bridge(int posInOrigList, int posInMergedList) {
			super();
			this.posInOrigList = posInOrigList;
			this.posInMergedList = posInMergedList;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(posInOrigList);
			builder.append(", ");
			builder.append(posInMergedList);
			return builder.toString();
		}

	}

}
