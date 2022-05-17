package edu.sau;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Anagram (k anagram)
 * 1. https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 * 
 * 2. Number Line Maximum events
 * 
 * 3. Unioun find
 * 
 * 
 * 
 * */

/**
 * SQL:
 * 
 * select c.name, SUM(r.fare) from CITIES c left join USERS u on c.id=u.city_id
 * left join RIDES r on u.id=r.user_id group by c.name order by SUM(r.fare) asc,
 * c.name asc;
 */
public class NurtureFarm {

	public static void main(String[] args) {

		System.out.println(maxEvents1(List.of(1, 3, 3, 5, 7), List.of(2, 2, 1, 2, 1)));

		System.out.println(maxEvents1(List.of(1, 3, 3, 5, 7, 6, 9), List.of(2, 2, 1, 2, 1, 10, 2)));

		System.out.println(maxEvents1(List.of(1, 3, 35, 7), List.of(2, 2, 1, 2, 1)));

		System.out.println(maxEvents1(List.of(1, 3, 5), List.of(2, 2, 2)));

	}

	public static int maxEvents1(List<Integer> arrival, List<Integer> duration) {
		int drop = 0;
		int[][] eventInterval = new int[arrival.size()][2];

		for (int i = 0; i < arrival.size(); i++) {
			eventInterval[i] = new int[] { arrival.get(i), arrival.get(i) + duration.get(i) };
		}

		Arrays.sort(eventInterval, (a, b) -> a[1] - b[1]);

		int curTime = eventInterval[0][1];

		for (int i = 1; i < arrival.size(); i++) {
			int[] toSchedule = eventInterval[i];
			if (toSchedule[0] < curTime)
				drop++;
			else {
				curTime = toSchedule[1];
			}
		}
		return arrival.size() - drop;
	}

	private static int maxEvents(List<Integer> arrival, List<Integer> duration) {
		int[][] events = new int[arrival.size()][2];
		for (int i = 0; i < arrival.size(); i++) {
			events[i] = new int[] { arrival.get(i), arrival.get(i) + duration.get(i) };
		}
		Arrays.sort(events, (a, b) -> (a[1] - b[1]));
		Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		int[] first = events[0];
		for (int i = 1; i < events.length; i++) {
			int[] cur = events[i];
			if (cur[0] < first[1])
				minHeap.offer(cur);
			else {
				first[1] = events[i][1];
			}
		}
		return arrival.size() - minHeap.size();
	}

}
