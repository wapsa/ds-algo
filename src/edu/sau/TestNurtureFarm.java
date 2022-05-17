package edu.sau;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * select c.name, SUM(r.fare) from CITIES c left join USERS u on c.id=u.city_id
 * left join RIDES r on u.id=r.user_id group by c.name order by SUM(r.fare) asc,
 * c.name asc;
 */
public class TestNurtureFarm {

	public static void main(String[] args) {

		System.out.println(maxEvents1(List.of(1, 3, 3, 5, 7), List.of(2, 2, 1, 2, 1)));

		System.out.println(maxEvents1(List.of(1, 3, 3, 5, 7, 6, 9), List.of(2, 2, 1, 2, 1, 10, 2)));

		System.out.println(maxEvents1(List.of(1, 3, 35, 7), List.of(2, 2, 1, 2, 1)));

		System.out.println(maxEvents1(List.of(1, 3, 5), List.of(2, 2, 2)));

		testDisjointSet();

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

	private static class DisjointSet {
		private static Map<Integer, Node> map = new HashMap<>();
		private static int max = 0;

		static class Node {
			Integer data;
			Node parent;
			int rank;
		}

		public static void makeSet(int data) {
			Node node = new Node();
			node.data = data;
			node.parent = node;
			node.rank = 1;
			map.put(data, node);
		}

		public static boolean union(int data1, int data2) {
			Node node1 = map.get(data1);
			Node node2 = map.get(data2);
			Node parent1 = findSet(node1);
			Node parent2 = findSet(node2);
			if (parent1.data == parent2.data) {
				return false;
			}
			if (parent1.rank >= parent2.rank) {
				parent1.rank = parent1.rank + parent2.rank;
				parent2.parent = parent1;
				max = Math.max(max, parent1.rank);
			} else {
				parent2.rank = parent2.rank + parent1.rank;
				parent1.parent = parent2;
				max = Math.max(max, parent2.rank);
			}
			return true;
		}

		public static Integer findSet(int data) {
			return findSet(map.get(data)).data;
		}

		private static Node findSet(Node node) {
			Node parent = node.parent;
			if (parent == node) {
				return parent;
			}
			node.parent = findSet(node.parent);
			return node.parent;
		}
	}

	private static void testDisjointSet() {
		int n = 4;
		List<String> queryType = List.of("Friend", "Friend", "Total");
		List<Integer> student1 = List.of(1, 2, 1);
		List<Integer> student2 = List.of(2, 3, 4);

		for (int i = 0; i < n; i++) {
			DisjointSet.makeSet(i + 1);
		}

		for (int i = 0; i < queryType.size(); i++) {
			if (queryType.get(i).equals("Friend")) {
				DisjointSet.union(student1.get(i), student2.get(i));
			}
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			result.add(DisjointSet.findSet(i + 1));
		}
		System.out.println(result);
	}
}
