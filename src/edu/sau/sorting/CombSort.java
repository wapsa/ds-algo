package edu.sau.sorting;

public class CombSort implements Sort {

	@Override
	public void sort(int[] elements) {
		combSort(elements);
	}

	private void combSort(int elements[]) {
		// Initialize gap
		int gap = elements.length;

		// Initialize swapped as true to make sure that
		// loop runs
		boolean swapped = true;

		// Keep running while gap is more than 1 and last
		// iteration caused a swap
		while (gap != 1 || swapped == true) {
			// Find next gap
			gap = (gap * 10 / 13) < 1 ? 1 : (gap * 10 / 13);

			// Initialize swapped as false so that we can
			// check if swap happened or not
			swapped = false;

			// Compare all elements with current gap
			for (int i = 0; i < elements.length - gap; i++) {
				if (elements[i] > elements[i + gap]) {
					int temp = elements[i];
					elements[i] = elements[i + gap];
					elements[i + gap] = temp;
					swapped = true;
				}
			}
		}
	}

}
