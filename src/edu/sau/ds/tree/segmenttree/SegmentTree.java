package edu.sau.ds.tree.segmenttree;

/**
 * 
 * https://codeforces.com/blog/entry/15890
 * 
 * https://codeforces.com/blog/entry/18051
 * 
 */
public interface SegmentTree<T> {

	T rangeQuery(int left, int right);

	void update(T data, int index);

}
