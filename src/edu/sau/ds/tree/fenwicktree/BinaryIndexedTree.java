package edu.sau.ds.tree.fenwicktree;

public interface BinaryIndexedTree<T extends Comparable<T>> {

	/**
	 * Increase the given index by delta
	 */
	void pointUpdate(int index, T delta);

	void rangeUpdate(int left, int right, T data);

	T rangeQuery(int ql, int qr);

}
