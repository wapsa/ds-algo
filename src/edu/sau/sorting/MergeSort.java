package edu.sau.sorting;

public class MergeSort implements Sort {

	@Override
	public void sort(int elements[]) {
		mergeSort(0, elements.length - 1, elements, new int[elements.length]);
	}

	private void mergeSort(int low, int high, int elements[], int helper[]) {
		// if high is not greater than low then the array is sorted
		if (high > low) {
			// Get the index of the element which is in the middle
			int middle = (high + low) / 2;
			// Sort the left side of the array
			mergeSort(low, middle, elements, helper);
			// Sort the right side of the array
			mergeSort(middle + 1, high, elements, helper);
			// Combine them both
			merge(low, middle, high, elements, helper);
		}
	}

	private void merge(int low, int middle, int high, int[] elements, int[] helper) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = elements[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				elements[k] = helper[i];
				i++;
			} else {
				elements[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			elements[k] = helper[i];
			k++;
			i++;
		}
		// Since we are sorting in-place any leftover elements from the right side
		// are already at the right position.
	}

}
