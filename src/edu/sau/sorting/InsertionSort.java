package edu.sau.sorting;

public class InsertionSort implements Sort {

	@Override
	public void sort(int elements[]) {
		insertionSort(elements);
	}

	private void insertionSort(int elements[]) {
		int comparisonCount = 0;
		int swapCount = 0;

		for (int i = 1; i < elements.length; i++) {
			int curr = elements[i];
			int j = i;

			comparisonCount++;
			while (j >= 1 && curr < elements[j - 1]) {
				elements[j] = elements[j - 1]; // Moving element ahead till key's position.
				j--;
				swapCount++;
			}
			elements[j] = curr;
		}

		System.out.println("Comparison Count: " + comparisonCount);
		System.out.println("Swap Count: " + swapCount);
	}

	public void recursiveInsertionSort(int elements[]) {
		sortRecursively(elements, elements.length - 1);
	}

	private static void sortRecursively(int elements[], int n) {
		if (n > 0) {
			sortRecursively(elements, n - 1);
			int curr = elements[n];
			int j = n;
			while (j >= 1 && curr < elements[j - 1]) {
				elements[j] = elements[j - 1];
				j--;
			}
			elements[j] = curr;
		}
	}

}
