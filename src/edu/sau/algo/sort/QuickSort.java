package edu.sau.algo.sort;

public class QuickSort implements Sort {

	@Override
	public void sort(int[] elements) {
		quickSort(0, elements.length - 1, elements);
	}

	private void quickSort(int low, int high, int elements[]) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = elements[(low + high) / 2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (elements[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (elements[j] > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			if (i <= j) {
				int temp = elements[i];
				elements[i] = elements[j];
				elements[j] = temp;
				i++;
				j--;
			}
		}
		if (low < j)
			quickSort(low, j, elements);
		if (i < high)
			quickSort(i, high, elements);
	}

}
