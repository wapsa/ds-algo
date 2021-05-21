package edu.sau.sorting;

public class SelectionSort implements Sort {

	public void sort(int elements[]) {
		selectionSort(elements);
	}

	private void selectionSort(int elements[]) {
		int comparisonCount = 0;
		int swapCount = 0;

		for (int i = 0; i < elements.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < elements.length; j++) {
				if (elements[j] < elements[minIdx]) {
					minIdx = j;
				}
				comparisonCount++;
			}

			int temp = elements[i];
			elements[i] = elements[minIdx];
			elements[minIdx] = temp;
			swapCount++;
		}

		System.out.println("Comparison Count: " + comparisonCount);
		System.out.println("Swap Count: " + swapCount);
	}

}
