package edu.sau.ds.tree;

import java.util.List;
import java.util.Map.Entry;

import edu.sau.ds.tree.bst.BST;
import edu.sau.ds.tree.bst.BinarySearchTree.BSTNode;

public interface KarumanchiQuestions<T extends Comparable<T>> {

	/**
	 * Q8 - Give an algorithm for printing the level order data in reverse order.
	 */
	List<T> bottomUpLevelOrderTraverse(BST<T> tree);

	/**
	 * Q11 - Find height of tree using iteration.
	 */
	int findHeightOfTreeUsingIteration(BST<T> tree);

	void printLevelsOfTreeInSeparateLines(BST<T> tree);

	/**
	 * Q12 - Give an algorithm for finding the deepest node of the binary tree.
	 */
	BSTNode<T> getTheDeepestNodeInTree(BST<T> tree);

	/**
	 * Q14 - Give an algorithm for finding the number of leaves in the binary tree
	 * using recursion.
	 */
	List<T> getNumberOfLeafNodesUsingRecursion(BST<T> tree);

	/**
	 * Q14 - Give an algorithm for finding the number of leaf nodes in the binary
	 * tree using iteration.
	 */
	List<T> getNumberOfLeafNodesUsingIteration(BST<T> tree);

	/**
	 * Q15 - Give an algorithm for finding the number of full nodes in the binary
	 * tree using iteration.
	 */
	List<T> getNumberOfFullNodesUsingIteration(BST<T> tree);

	/**
	 * Q16 - Give an algorithm for finding the number of half nodes in the binary
	 * tree using iteration.
	 */
	List<T> getNumberOfHalfNodesUsingIteration(BST<T> tree);

	/**
	 * Q17 - Given two binary trees, return true if they are identical. (meaning
	 * having same data elements)
	 */
	boolean checkIfGivenTreesAreIdentical(BST<T> tree1, BST<T> tree2);

	/**
	 * Q17 - Given two binary trees, return true if they are structurally identical.
	 * (meaning elements can have different data, but tree structure must remain
	 * same)
	 */
	boolean checkIfGivenTreesAreStructurallyIdentical(BST<T> tree1, BST<T> tree2);

	/**
	 * Q18 - Give an algorithm for finding the diameter of the binary tree. The
	 * diameter of a tree (sometimes called the width) is the length of the longest
	 * path between two leaf nodes in the tree.
	 * 
	 * Solution: To find the diameter of a tree, first calculate the diameter of
	 * left subtree and right subtrees recursively. Among these two values, we need
	 * to send maximum value along with current level (+1).
	 */
	int findDiameterOfTreeUsingRecursion(BST<T> tree);

	int findDiameterOfTreeUsingIteration(BST<T> tree);

	/**
	 * Q19 - Give an algorithm for finding the level that has the maximum sum in the
	 * binary tree.
	 */
	Entry<Integer, Integer> findLevelHavingMaximumSum(BST<Integer> tree);

	/**
	 * Q20 - Given a binary tree, print out all its root-to-leaf paths.
	 */
	void printRootToLeafPaths(BST<T> tree);

	/**
	 * Q21 - Give an algorithm for checking the existence of path with given sum.
	 * That means, given a sum, check whether there exists a path from root to any
	 * of the leaf nodes.
	 */
	boolean hasRootToLeafPathWhichHasSum(BST<Integer> tree, int sum);

	/**
	 * Q21 - Give an algorithm for printing all paths with given sum. That means,
	 * given a sum, check whether there exists a path from root to any of the nodes
	 * and print such paths.
	 */
	void printRootToAnyNodePathsWhichHasSum(BST<Integer> tree, int sum);

	/**
	 * Q22 - Give an algorithm for finding the sum of all elements in binary tree.
	 */
	int sumOfAllNodes(BST<Integer> tree);

	/**
	 * Q24 - Give an algorithm for converting a tree to its mirror. Mirror of a tree
	 * is another tree with left and right children of all non-leaf nodes
	 * interchanged. The trees below are mirrors to each other.
	 */
	void mirror(BST<T> tree);

	/**
	 * Q25 - Given two trees, give an algorithm for checking whether they are
	 * mirrors of each other.
	 */
	boolean areGivenTreesMirrorOfEachOther(BST<T> tree1, BST<T> tree2);

	/**
	 * Q26 - Give an algorithm for finding LCA (Least Common Ancestor) of two nodes
	 * in a Binary Tree.
	 */
	BSTNode<T> findLeastCommonAncestorOfTwoNodes(BSTNode<T> node1, BSTNode<T> node2);
}
