package edu.sau.sorting;

public class BubbleSort implements Sort {

	@Override
	public void sort(int elements[]) {
		optimizedBubbleSortSkipNeedlessPassesAndTrailingSorted(elements);
	}

	public void classicBubbleSort(int elements[]) {
		int comparisonCount = 0;
		int swapCount = 0;

		for (int pass = elements.length - 1; pass >= 0; pass--) {
			for (int i = 0; i < pass; i++) {

				if (elements[i] > elements[i + 1]) {
					int temp = elements[i];
					elements[i] = elements[i + 1];
					elements[i + 1] = temp;
					swapCount++;
				}
				comparisonCount++;
			}
		}

		System.out.println("Comparison Count: " + comparisonCount);
		System.out.println("Swap Count: " + swapCount);
	}

	public void optimizedBubbleSortSkipNeedlessPasses(int[] elements) {
		int swapCount = 0;
		int comparisonCount = 0;

		boolean swapped;
		for (int pass = elements.length - 1; pass >= 0; pass--) {
			swapped = false;
			for (int i = 0; i < pass; i++) {
				if (elements[i] > elements[i + 1]) {
					int temp = elements[i];
					elements[i] = elements[i + 1];
					elements[i + 1] = temp;
					swapped = true;
					swapCount++;
				}
				comparisonCount++;
			}
			// IF no two elements were swapped by inner loop in entire pass then break as
			// array is already sorted.
			if (swapped == false)
				break;
		}

		System.out.println("Comparison Count: " + comparisonCount);
		System.out.println("Swap Count: " + swapCount);
	}

	/**
	 * In Bubble sort, you know that after k passes, the largest k elements are
	 * sorted at the k last entries of the array.
	 * 
	 * Now, that would still do a lot of unnecessary iterations when the array has a
	 * long sorted tail of largest elements, say you have k,k-1,...,1 as the first k
	 * elements and k+1 to 100000000 in order after that. The standard Bubble sort
	 * will pass k times through (almost) the entire array.
	 * 
	 * But if you remember where you made your last swap, you know that after that
	 * index, there are the largest elements in order.
	 */
	public void optimizedBubbleSortSkipNeedlessPassesAndTrailingSorted(int[] elements) {
		int comparisonCount = 0;
		int swapCount = 0;

		int lastSwap = elements.length - 1;
		for (int pass = elements.length - 1; pass >= 0; pass--) {
			boolean isSorted = true;
			int currentSwap = -1;
			for (int i = 0; i < lastSwap; i++) {
				if (elements[i] > elements[i + 1]) {
					int temp = elements[i];
					elements[i] = elements[i + 1];
					elements[i + 1] = temp;
					isSorted = false;
					currentSwap = i;
					swapCount++;
				}
				comparisonCount++;
			}
			if (isSorted)
				break;
			lastSwap = currentSwap;
		}

		System.out.println("Comparison Count: " + comparisonCount);
		System.out.println("Swap Count: " + swapCount);
	}

}
