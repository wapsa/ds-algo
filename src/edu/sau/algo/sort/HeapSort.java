package edu.sau.algo.sort;

public class HeapSort implements Sort {

	@Override
	public void sort(int[] elements) {
		heapSort(elements);
	}

	private static void heapSort(int elements[]) {
		int n = elements.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(elements, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			int temp = elements[0];
			elements[0] = elements[i];
			elements[i] = temp;

			// call max heapify on the reduced heap
			heapify(elements, i, 0);
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	private static void heapify(int elements[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && elements[l] > elements[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && elements[r] > elements[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = elements[i];
			elements[i] = elements[largest];
			elements[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(elements, n, largest);
		}
	}

}
