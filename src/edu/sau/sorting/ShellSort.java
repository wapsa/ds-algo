package edu.sau.sorting;

public class ShellSort implements Sort {

	public void sort(int elements[]) {
		shellSort(elements);
	}

	private void shellSort(int elements[]) {
		int comparisonCount = 0;
		int swapCount = 0;

		for (int gap = elements.length / 2; gap > 0; gap /= 2) {

			for (int i = gap; i < elements.length; i++) {
				int curr = elements[i];
				int j = i;

				comparisonCount++;
				while (j >= gap && curr < (elements[j - gap])) {
					elements[j] = elements[j - gap];
					j -= gap;
					swapCount++;
				}
				elements[j] = curr;
			}

		}

		System.out.println("Comparison Count: " + comparisonCount);
		System.out.println("Swap Count: " + swapCount);
	}

}
