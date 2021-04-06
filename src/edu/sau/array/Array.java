package edu.sau.array;

public class Array {

	public static void main(String[] args) {

		// initialization
		int[] nums = new int[5];

		// filling the array
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}

		// O(1)
		int num = nums[2];
		System.out.println(num);

		// O(N) - linear search, O(logN) - binary trees, O(1) - hash tables.
		int numToFind = 4;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == numToFind) {
				System.out.println(numToFind + " found at index: " + i);
			}
		}

		// O(1)
		nums[0] = 10;

	}

}
