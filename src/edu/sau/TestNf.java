package edu.sau;

import java.util.PriorityQueue;

public class TestNf {

	public static int KthLargestNum(int arr[][], int n, int k) {

		// Store all the intervals so that it returns the minimum element in O(1)
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

		// Insert all Intervals into the MinHeap
		for (int i = 0; i < n; i++) {
			queue.add(arr[i]);
		}
		// Stores the count of popped elements
		int count = 1;
		// Iterate over MinHeap
		while (count < k) {

			// Stores minimum element from all remaining intervals
			int[] interval = queue.poll();

			// Check if the minimum of the current interval is less than the maximum of the
			// current interval
			if (interval[0] < interval[1]) {

				// Insert new interval
				queue.add(new int[] { interval[0] + 1, interval[1] });
			}
			count++;
		}
		return queue.peek()[0];
	}

	public static void main(String args[]) {
		int arr[][] = { { 5, 11 }, { 10, 15 }, { 12, 20 } };
		int n = arr.length;
		int k = 12;
		System.out.println(KthLargestNum(arr, n, k));
	}
}
