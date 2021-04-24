package edu.sau.tree;

public interface Tree<T extends Comparable<T>> {

	void insert(T data);

	void delete(T data);

	T getMaxElement();

	T getMinElement();

	int size();

	int treeHeight();

	boolean isEmpty();

	void traverse();

}
