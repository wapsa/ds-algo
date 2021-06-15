package edu.sau.ds.tree.segmenttree;

public class App {

	public static void main(String[] args) {
		testSumSegmentTree1();
		testOptimizedSumSegmentTree1();

		testSumSegmentTree2();
		testOptimizedSumSegmentTree2();
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
		SegmentTree<Integer> tree = new SumSegmentTree(elements, true);
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
}
