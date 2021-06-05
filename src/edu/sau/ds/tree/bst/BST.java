package edu.sau.ds.tree.bst;

import java.util.List;

import edu.sau.ds.tree.Tree;
import edu.sau.ds.tree.bst.BinarySearchTree.BSTNode;

public interface BST<T extends Comparable<T>> extends Tree<T> {

	BSTNode<T> root();
	
	void setRoot(BSTNode<T> node);

	void insert(T data);

	boolean delete(T data);

	T getMaxElement();

	T getMinElement();

	int size();

	int size(T data);

	int height();

	boolean isEmpty();

	boolean contains(T data);

	List<T> preOrderTraverse();

	List<T> inOrderTraverse();

	List<T> postOrderTraverse();

	List<T> bfsTraverse();

}
