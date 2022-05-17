package edu.sau;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestJPM {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 6, 9 } };
		int[] newInterval = { 2, 5 };
		int[][] x = insert(intervals, newInterval);

		for (int[] y : x) {
			System.out.println(Arrays.toString(y));
		}
	}
	
	public int[][] insert1(int[][] intervals, int[] newInterval) {

		List<int[]> result = new ArrayList<>();

		// Iterate through all slots
		for (int[] interval : intervals) {

			// if newInterval before slot insert newInterval & update slot as new interval
			if (newInterval[1] < interval[0]) {
				result.add(newInterval);
				newInterval = interval;
			}

			// if slot is lesser than new Interval insert slot
			else if (interval[1] < newInterval[0]) {
				result.add(interval);
			}

			// if above conditions fail its an overlap since possibility of new interval
			// existing in left & right of slot is checked
			// update lowest of start & highest of end & not insert
			else {
				newInterval[0] = Math.min(newInterval[0], interval[0]);
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			}
		}

		// insert the last newInterval
		result.add(newInterval);

		// convert to int[][] array
		return result.toArray(new int[result.size()][]);
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();
		int[] candidate = newInterval;

		for (int[] interval : intervals) {
			/*
			 * 1. No overlap and candidate appears before current interval, add candidate to
			 * result.
			 */
			if (interval[0] > candidate[1]) {
				result.add(candidate);
				// save the previous interval to toAdd for next loop use
				candidate = interval;
			}
			/*
			 * 2. No overlap and candidate appears after current interval, add current
			 * interval to result.
			 */
			else if (interval[1] < candidate[0])
				result.add(interval);

			/* 3. Has overlap, update the candidate to the merged interval. */
			else
				candidate = new int[] { Math.min(interval[0], candidate[0]), Math.max(interval[1], candidate[1]) };
		}

		result.add(candidate);

		return result.toArray(new int[result.size()][2]);
	}

}
