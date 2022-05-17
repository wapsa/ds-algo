package edu.sau;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindNextPalindrome {

	static void generateNextSmallestLargerPalindrome(int[] numDigits) {
		int n = numDigits.length;

		int mid = n / 2;

		int i = mid - 1;

		int j = (n % 2 == 0) ? mid : mid + 1;

		boolean left = false;

		while (i >= 0 && numDigits[i] == numDigits[j]) {
			i--;
			j++;
		}

		if (i < 0 || numDigits[i] < numDigits[j]) {
			left = true;
		}

		while (i >= 0) {
			numDigits[j++] = numDigits[i--];
		}

		if (left) {
			int carry = 1;

			if (n % 2 == 1) {
				numDigits[mid] += 1;
				carry = numDigits[mid] / 10;
				numDigits[mid] %= 10;
			}
			i = mid - 1;
			j = (n % 2 == 0 ? mid : mid + 1);

			while (i >= 0 && carry > 0) {
				numDigits[i] = numDigits[i] + carry;
				carry = numDigits[i] / 10;
				numDigits[i] %= 10;
				numDigits[j] = numDigits[i];
				i--;
				j++;
			}
		}
	}

	static int findSmallestLargerPalindrome(int k) {
		int[] numDigits = Integer.toString(k).chars().map(c -> c - '0').toArray();

		StringBuilder builder = new StringBuilder();

		if (!isMaxNumber(numDigits)) {
			generateNextSmallestLargerPalindrome(numDigits);
			for (int digit : numDigits) {
				builder.append(digit);
			}
		} else {
			builder.append("1");
			for (int i = 0; i < numDigits.length - 1; i++) {
				builder.append("0");
			}
			builder.append("1");
		}
		return Integer.parseInt(builder.toString());
	}

	static boolean isMaxNumber(int numDigits[]) {
		for (int i = 0; i < numDigits.length; i++)
			if (numDigits[i] != 9)
				return false;
		return true;
	}

	public static void main(String[] args) {
		int x = findSmallestLargerPalindrome(123320);
		System.out.println(x);

		Map<String, Integer> map = new HashMap<>();

		map.put("key", map.get("key") - 1);

	}
}
