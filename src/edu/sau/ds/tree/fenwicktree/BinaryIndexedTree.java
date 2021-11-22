package edu.sau.ds.tree.fenwicktree;

/**
 * 
 * link: https://www.topcoder.com/thrive/articles/Binary%20Indexed%20Trees
 * 
 * https://cp-algorithms.com/data_structures/fenwick.html
 * 
 * <pre>
 * For "INSANE" 
 * 
 * 1. rangeUpdate and pointQuery 
 * 
 * 2. rangeUpdate and rangeQuery
 * 
 * Please refer CP algorithm Fenwick tree
 * 
 * </pre>
 * 
 */
public interface BinaryIndexedTree<T extends Comparable<T>> {

	/**
	 * Increase the given index by delta
	 */
	void pointAdd(int index, T delta);

	T rangeQuery(int ql, int qr);

	T pointQuery(int idx);

}
