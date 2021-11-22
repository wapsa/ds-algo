package edu.sau.algo.sort;

public interface Sort {

	void sort(int elements[]);

	public static boolean isAscendingSorted(int[] elements) {
		boolean ascending = true;
		for (int i = 1; i < elements.length && (ascending); i++)
			ascending = ascending && elements[i] >= elements[i - 1];
		return ascending;
	}

	public static boolean isDescendingSorted(int[] elements) {
		boolean descending = true;
		for (int i = 1; i < elements.length && (descending); i++)
			descending = descending && elements[i] <= elements[i - 1];
		return descending;
	}

}
