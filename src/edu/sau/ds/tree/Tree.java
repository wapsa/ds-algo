package edu.sau.ds.tree;

import java.util.List;

import edu.sau.ds.tree.bst.BinarySearchTree.BSTNode;

/**
 * Tree is a variant of graph where there exists only one way from root to any
 * other node.
 *
 * If there are several ways to get to a given node: it's not a tree rather a
 * typical graph.
 *
 * Time complexity of operations on tree are quite predictable in most case
 * O(logn).
 *
 * Height of the tree, h: the length of the path from the root to the deepest
 * node in the tree.
 *
 * We should keep the height of the tree at a minimum which is h=logn
 *
 * <pre>
 * Following are the some of the applications where binary trees play an
 * important role:
 * - Expression trees are used in compilers.
 * - Huffman coding trees that are used in data compression algorithms.
 * - Binary Search Tree (BST), which supports search, insertion and deletion on a collection of items
 *  in O(logn) (average).
 * - Priority Queue (PQ), which supports search and deletion of minimum (or maximum) on a collection
 *  of items in logarithmic time (in worst case).
 * </pre>
 */
public interface Tree<T extends Comparable<T>> {

	Node<T> root();

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
