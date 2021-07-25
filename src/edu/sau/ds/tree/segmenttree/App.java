package edu.sau.ds.tree.segmenttree;

import java.util.Map;

import edu.sau.ds.tree.segmenttree.MaxSubSegmentSumTree.Data;
import edu.sau.ds.tree.segmenttree.SegmentTree.MaxST;
import edu.sau.ds.tree.segmenttree.SegmentTree.SumST;

public class App {

	public static void main(String[] args) {
		// testSumSegmentTree1();
		// testOptimizedSumSegmentTree1();

		// testSumSegmentTree2();
		// testOptimizedSumSegmentTree2();

		// testMaxOccurrenceSegmentTree1();
		// testMaxOccurrenceSegmentTree2();

		// getRightBoundOfRangeInGivenQueryRange();

		testMaxSubSegmentSumTree();
	}

	private static void testMaxSubSegmentSumTree() {
		int[] elements = new int[] { 10, -7, 8, -5, 5, -5, 7, -15 };
		SegmentTree<Data> tree = new MaxSubSegmentSumTree(elements, false);
		System.out.println(tree);

		int ql = 0;
		int qr = 5;
		System.out.println("Sum in range " + ql + " - " + qr + " is: " + tree.rangeQuery(ql, qr).sum);
		System.out.println("Max Sum in range " + ql + " - " + qr + " is: " + tree.rangeQuery(ql, qr).maxSum);
	}

	private static void getRightBoundOfRangeInGivenQueryRange() {
		int[] elements = new int[] { 10, 5, 15, 4, 9, 7, 6, 2 };
		SumST<Integer> tree = new SumSegmentTree(elements, true);
		System.out.println(tree);

		int sum = 27;
		System.out.println("Sum " + sum + " can be done till index: " + tree.getRightBoundOfRange(sum));

		int ql = 2;
		int qr = 6;
		System.out.println("Sum " + sum + " can be done till index: "
				+ tree.getRightBoundOfRangeInGivenQueryRange(ql, qr, sum) + " in range " + ql + " - " + qr);
	}

	private static void testSumSegmentTree1() {
		int[] elements = new int[] { 2, 3, 5, 8, 9, 1, 4, 7 };
		SegmentTree<Integer> tree = new SumSegmentTree(elements, true);
		System.out.println(tree);
		System.out.println("Sum Query (3,7): " + tree.rangeQuery(3, 7));
		System.out.println("Sum Query (0,8): " + tree.rangeQuery(0, 8));

		System.out.println("Updating data 6 and index 5");
		tree.update(6, 5);

		System.out.println(tree);
		System.out.println("Sum Query (3,7): " + tree.rangeQuery(3, 7));
		System.out.println("Sum Query (0,8): " + tree.rangeQuery(0, 8));

	}

	private static void testSumSegmentTree2() {
		int[] elements = new int[] { 5, 8, 9, 1, 4, 7 };
		SegmentTree<Integer> tree = new SumSegmentTree(elements, false);
		System.out.println(tree);
		System.out.println("Sum Query (0,4): " + tree.rangeQuery(0, 4));
		System.out.println("Sum Query (0,6): " + tree.rangeQuery(0, 6));

		System.out.println("Updating data 6 and index 5");
		tree.update(6, 5);

		System.out.println(tree);
		System.out.println("Sum Query (0,4): " + tree.rangeQuery(0, 4));
		System.out.println("Sum Query (0,6): " + tree.rangeQuery(0, 6));
	}

	private static void testOptimizedSumSegmentTree1() {
		int[] elements = new int[] { 2, 3, 5, 8, 9, 1, 4, 7 };
		SegmentTree<Integer> tree = new OptimizedSumSegmentTree(elements, true);
		System.out.println(tree);
		System.out.println("Sum Query (3,7): " + tree.rangeQuery(3, 7));
		System.out.println("Sum Query (0,8): " + tree.rangeQuery(0, 8));

		System.out.println("Updating data 6 and index 5");
		tree.update(6, 5);

		System.out.println(tree);
		System.out.println("Sum Query (3,7): " + tree.rangeQuery(3, 7));
		System.out.println("Sum Query (0,8): " + tree.rangeQuery(0, 8));
	}

	private static void testOptimizedSumSegmentTree2() {
		int[] elements = new int[] { 5, 8, 9, 1, 4, 7 };
		SegmentTree<Integer> tree = new OptimizedSumSegmentTree(elements, true);
		System.out.println(tree);
		System.out.println("Sum Query (0,4): " + tree.rangeQuery(0, 4));
		System.out.println("Sum Query (0,6): " + tree.rangeQuery(0, 6));

		System.out.println("Updating data 6 and index 5");
		tree.update(6, 5);

		System.out.println(tree);
		System.out.println("Sum Query (0,4): " + tree.rangeQuery(0, 4));
		System.out.println("Sum Query (0,6): " + tree.rangeQuery(0, 6));

	}

	private static void testMaxOccurrenceSegmentTree1() {
		int[] elements = new int[] { 3, 1, 4, 2, 4, 4, 4, 2 };
		MaxST<Map.Entry<Integer, Integer>> tree = new MaxOccurrenceSegmentTree(elements, true);
		System.out.println(tree);
		System.out.println("Max Query (3,7): " + tree.rangeQuery(3, 7));
		System.out.println("Max Query (0,8): " + tree.rangeQuery(0, 8));

		System.out.println("Updating data 6 and index 5");
		tree.update(Map.entry(10, 1), 5);

		System.out.println(tree);
		System.out.println("Max Query (3,7): " + tree.rangeQuery(3, 7));
		System.out.println("Max Query (0,8): " + tree.rangeQuery(0, 8));

		int ql = 1;
		int qr = 7;
		int data = 20;
		System.out.println("Element >= " + data + " found at index: "
				+ tree.findFirstGreaterElementInGivenQueryRange(data, ql, qr) + " in range " + ql + " - " + qr);
	}

	private static void testMaxOccurrenceSegmentTree2() {
		int[] elements = new int[] { 3, 1, 4, 2, 4, 4 };
		MaxST<Map.Entry<Integer, Integer>> tree = new MaxOccurrenceSegmentTree(elements, true);
		System.out.println(tree);
		System.out.println("Max Query (0,4): " + tree.rangeQuery(0, 4));
		System.out.println("Max Query (0,6): " + tree.rangeQuery(0, 6));

		System.out.println("Updating data 6 and index 5");
		tree.update(Map.entry(10, 1), 5);

		System.out.println(tree);
		System.out.println("Max Query (0,4): " + tree.rangeQuery(0, 4));
		System.out.println("Max Query (0,6): " + tree.rangeQuery(0, 6));
	}
}
