package edu.sau.ds.tree.segmenttree;

/**
 * 
 * https://codeforces.com/blog/entry/15890
 * 
 * https://codeforces.com/blog/entry/18051
 * 
 * 
 * Possible Questions:
 * 
 * Q1 : Given is range [l,r) and to find is : sum/min/max/lcm/gcd/.., etc
 * 
 * Q2 : Given is sum/min/max/lcm/gcd/.. and to find is upper bound of range or
 * both of the bound.
 * 
 */
public interface SegmentTree<T> {

	T rangeQuery(int left, int right);

	void update(T data, int index);

	public interface SumST<T> extends SegmentTree<T> {

		int getRightBoundOfRange(T data);

		int getRightBoundOfRangeInGivenQueryRange(int ql, int qr, int data);

	}

	public interface MaxST<T> extends SegmentTree<T> {

		int findFirstGreaterElementInGivenQueryRange(int data, int ql, int qr);

	}

}
