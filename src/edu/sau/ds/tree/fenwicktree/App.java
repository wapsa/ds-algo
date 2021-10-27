package edu.sau.ds.tree.fenwicktree;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		int[] input = { 5, 7, 3, 2, 4, 6 };
		BinaryIndexedTree<Integer> tree = new FenwickTree1(input);
		System.out.println(Arrays.toString(input));
		System.out.println(tree);
		
		int ql=0;
		int qr = 3;
		System.out.println("query range(" + ql + "" + ", " + qr + "): " + tree.rangeQuery(ql, qr));
		
		ql = 2;
		qr = 5;
		System.out.println("query range(" + ql + "" + ", " + qr + "): " + tree.rangeQuery(ql, qr));
		
		ql = 2;
		qr = 6;
		System.out.println("query range(" + ql + "" + ", " + qr + "): " + tree.rangeQuery(ql, qr));
		
		ql = 0;
		qr = 6;
		System.out.println("query range(" + ql + "" + ", " + qr + "): " + tree.rangeQuery(ql, qr));
		
		ql = 3;
		qr = 4;
		System.out.println("query range(" + ql + "" + ", " + qr + "): " + tree.rangeQuery(ql, qr));
	}
}
