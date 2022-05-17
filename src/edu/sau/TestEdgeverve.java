package edu.sau;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestEdgeverve {

	public static void main(String[] args) {
		System.out.println(prefixSumSort(new ArrayList<>(List.of(-6, 3, 4, -10))));
		System.out.println(prefixSumSort(new ArrayList<>(List.of(-6, 3, 4, 2, 1, 5, 7, -8, -4, -10))));

		System.out.println(prefixSumSort(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7))));
	}

	public static int prefixSumSort(List<Integer> input) {
		int n = input.size();
		Collections.sort(input);

		int[] newInput = new int[n];
		int positiveStartIdx = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (input.get(n - i - 1) > 0) {
				positiveStartIdx = n - i - 1;
				break;
			}
			newInput[i] = input.get(n - i - 1);
		}

		for (int i = 0; i < n - positiveStartIdx; i++)
			newInput[i] = input.get(i + positiveStartIdx);

		int[] prefixSumArray = new int[input.size()];
		prefixSumArray[0] = newInput[0];
		for (int i = 1; i < prefixSumArray.length; ++i)
			prefixSumArray[i] = prefixSumArray[i - 1] + newInput[i];

		int positiveIntegerCount = 0;
		for (int i = 0; i < prefixSumArray.length; i++) {
			if (prefixSumArray[i] <= 0) {
				positiveIntegerCount = i;
				break;
			}
		}
		return positiveIntegerCount;
	}

	public static int firstUniqChar(String s) {
		int freq[] = new int[26];
		for (int i = 0; i < s.length(); i++)
			freq[s.charAt(i) - 'a']++;

		for (int i = 0; i < s.length(); i++)
			if (freq[s.charAt(i) - 'a'] == 1)
				return i;

		return -1;
	}

}
