package edu.sau.algo.sort;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		int[] elements = new int[] { 1, 2, 3, 4, 7, 5, 1, 2, 3, 8, 9, 10 };

		// bubbleSort(elements);

		// selectionSort(elements);

		// insertionSort(elements);

		// shellSort(elements);

		// mergeSort(elements);

		// heapSort(elements);

		// quickSort(elements);

		// treeSort(elements);

		// countingSort(elements);

		// bucketSort(elements);

		// radixSort(elements);

		// combSort(elements);

	}

	private static void bubbleSort(int elements[]) {
		BubbleSort sort = new BubbleSort();

		int[] a1 = Arrays.copyOf(elements, elements.length);
		System.out.println("Unsorted Array: " + Arrays.toString(a1));
		sort.classicBubbleSort(a1);
		System.out.println("Bubble Sort: " + Arrays.toString(a1));
		System.out.println("Confirm: " + Sort.isAscendingSorted(a1));
		System.out.println("---------------------------------------------");

		int[] a2 = Arrays.copyOf(elements, elements.length);
		System.out.println("Unsorted Array: " + Arrays.toString(a2));
		sort.optimizedBubbleSortSkipNeedlessPasses(a2);
		System.out.println("Optimized Bubble Sort: " + Arrays.toString(a2));
		System.out.println("Confirm: " + Sort.isAscendingSorted(a2));
		System.out.println("---------------------------------------------");

		int[] a3 = Arrays.copyOf(elements, elements.length);
		System.out.println("Unsorted Array: " + Arrays.toString(a3));
		sort.optimizedBubbleSortSkipNeedlessPassesAndTrailingSorted(a3);
		System.out.println("Even more optimized Bubble Sort: " + Arrays.toString(a3));
		System.out.println("Confirm: " + Sort.isAscendingSorted(a3));
		System.out.println("---------------------------------------------");
	}

	public static void selectionSort(int elements[]) {
		Sort sort = new SelectionSort();

		int[] a1 = Arrays.copyOf(elements, elements.length);
		System.out.println("Unsorted Array: " + Arrays.toString(a1));
		sort.sort(a1);
		System.out.println("Selection Sort: " + Arrays.toString(a1));
		System.out.println("Confirm: " + Sort.isAscendingSorted(a1));
		System.out.println("---------------------------------------------");

	}

	public static void insertionSort(int elements[]) {
		InsertionSort sort = new InsertionSort();

		int[] a1 = Arrays.copyOf(elements, elements.length);
		System.out.println("Unsorted Array: " + Arrays.toString(a1));
		sort.sort(a1);
		System.out.println("Insertion Sort: " + Arrays.toString(a1));
		System.out.println("Confirm: " + Sort.isAscendingSorted(a1));
		System.out.println("---------------------------------------------");

		int[] a2 = Arrays.copyOf(elements, elements.length);
		System.out.println("Unsorted Array: " + Arrays.toString(a2));
		sort.recursiveInsertionSort(a2);
		System.out.println("Recursive Insertion Sort: " + Arrays.toString(a2));
		System.out.println("Confirm: " + Sort.isAscendingSorted(a2));
		System.out.println("---------------------------------------------");

	}

	public static void shellSort(int elements[]) {
		Sort sort = new ShellSort();

		int[] a1 = Arrays.copyOf(elements, elements.length);
		System.out.println("Unsorted Array: " + Arrays.toString(a1));
		sort.sort(a1);
		System.out.println("Shell Sort: " + Arrays.toString(a1));
		System.out.println("Confirm: " + Sort.isAscendingSorted(a1));
		System.out.println("---------------------------------------------");

	}

	public static void mergeSort(int elements[]) {
		Sort sort = new MergeSort();

		int[] a1 = Arrays.copyOf(elements, elements.length);
		System.out.println("Unsorted Array: " + Arrays.toString(a1));
		sort.sort(a1);
		System.out.println("Merge Sort: " + Arrays.toString(a1));
		System.out.println("Confirm: " + Sort.isAscendingSorted(a1));
		System.out.println("---------------------------------------------");

	}

	public static void heapSort(int elements[]) {
		Sort sort = new HeapSort();

		int[] a1 = Arrays.copyOf(elements, elements.length);
		System.out.println("Unsorted Array: " + Arrays.toString(a1));
		sort.sort(a1);
		System.out.println("Heap Sort: " + Arrays.toString(a1));
		System.out.println("Confirm: " + Sort.isAscendingSorted(a1));
		System.out.println("---------------------------------------------");

	}

	public static void quickSort(int elements[]) {
		Sort sort = new QuickSort();

		int[] a1 = Arrays.copyOf(elements, elements.length);
		System.out.println("Unsorted Array: " + Arrays.toString(a1));
		sort.sort(a1);
		System.out.println("Quick Sort: " + Arrays.toString(a1));
		System.out.println("Confirm: " + Sort.isAscendingSorted(a1));
		System.out.println("---------------------------------------------");

	}

	public static void treeSort(int elements[]) {
		Sort sort = new TreeSort();

		int[] a1 = Arrays.copyOf(elements, elements.length);
		System.out.println("Unsorted Array: " + Arrays.toString(a1));
		sort.sort(a1);
		System.out.println("Tree Sort: " + Arrays.toString(a1));
		System.out.println("Confirm: " + Sort.isAscendingSorted(a1));
		System.out.println("---------------------------------------------");

	}

	public static void countingSort(int elements[]) {
		Sort sort = new CountingSort();

		int[] a1 = Arrays.copyOf(elements, elements.length);
		System.out.println("Unsorted Array: " + Arrays.toString(a1));
		sort.sort(a1);
		System.out.println("Counting Sort: " + Arrays.toString(a1));
		System.out.println("Confirm: " + Sort.isAscendingSorted(a1));
		System.out.println("---------------------------------------------");

	}

	private static void bucketSort(int elements[]) {
		Sort sort = new BucketSort();

		int[] a1 = Arrays.copyOf(elements, elements.length);
		System.out.println("Unsorted Array: " + Arrays.toString(a1));
		sort.sort(a1);
		System.out.println("Bucket Sort: " + Arrays.toString(a1));
		System.out.println("Confirm: " + Sort.isAscendingSorted(a1));
		System.out.println("---------------------------------------------");
	}

	public static void radixSort(int elements[]) {
		Sort sort = new RadixSort();

		int[] a1 = Arrays.copyOf(elements, elements.length);
		System.out.println("Unsorted Array: " + Arrays.toString(a1));
		sort.sort(a1);
		System.out.println("Radix Sort: " + Arrays.toString(a1));
		System.out.println("Confirm: " + Sort.isAscendingSorted(a1));
		System.out.println("---------------------------------------------");

	}

	public static void combSort(int elements[]) {
		Sort sort = new CombSort();

		int[] a1 = Arrays.copyOf(elements, elements.length);
		System.out.println("Unsorted Array: " + Arrays.toString(a1));
		sort.sort(a1);
		System.out.println("Comb Sort: " + Arrays.toString(a1));
		System.out.println("Confirm: " + Sort.isAscendingSorted(a1));
		System.out.println("---------------------------------------------");

	}

}
