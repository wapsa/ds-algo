package edu.sau.ds.tree.bst;

import edu.sau.ds.tree.Tree;

public class App {

	public static void main(String[] args) {
		// height();

		 size();

		// contains();

		// getMinElement();

		// getMaxElement();

		// bfsTraversal();

		// dfsTraversals();

		// delete();
	}

	private static void delete() {
		Tree<Integer> tree = new BinarySearchTree<>();
		tree.insert(99);

		tree.insert(50);
		tree.insert(105);

		tree.insert(1);
		tree.insert(75);
		tree.insert(103);
		tree.insert(110);

		tree.insert(55);
		tree.insert(85);

		tree.insert(80);

		tree.insert(83);

		System.out.println(tree);
		System.out.println("Size before delete: " + tree.size());
		System.out.println("Delete: " + tree.delete(105));
		System.out.println("Size after delete: " + tree.size());
		System.out.println(tree);
	}

	private static void dfsTraversals() {
		Tree<Integer> tree = new BinarySearchTree<>();
		tree.insert(99);

		tree.insert(50);
		tree.insert(105);

		tree.insert(1);
		tree.insert(75);
		tree.insert(103);
		tree.insert(110);

		tree.insert(55);
		tree.insert(85);

		tree.insert(80);

		tree.insert(83);

		System.out.println(tree);
		System.out.println("Pre Order Traversal: " + tree.preOrderTraverse());
		System.out.println("In Order Traversal: " + tree.inOrderTraverse());
		System.out.println("Post Order Traversal: " + tree.postOrderTraverse());
	}

	private static void getMaxElement() {
		Tree<Integer> tree = new BinarySearchTree<>();
		tree.insert(99);

		tree.insert(50);
		tree.insert(105);

		tree.insert(1);
		tree.insert(75);
		tree.insert(103);
		tree.insert(110);

		tree.insert(55);
		tree.insert(85);

		tree.insert(80);

		tree.insert(83);

		System.out.println(tree);
		System.out.println("Max Element: " + tree.getMaxElement());
	}

	private static void getMinElement() {
		Tree<Integer> tree = new BinarySearchTree<>();
		tree.insert(99);

		tree.insert(50);
		tree.insert(105);

		tree.insert(1);
		tree.insert(75);
		tree.insert(103);
		tree.insert(110);

		tree.insert(55);
		tree.insert(85);

		tree.insert(80);

		tree.insert(83);

		System.out.println(tree);
		System.out.println("Min Element: " + tree.getMinElement());
	}

	private static void contains() {
		Tree<Integer> tree = new BinarySearchTree<>();
		tree.insert(99);

		tree.insert(50);
		tree.insert(105);

		tree.insert(1);
		tree.insert(75);
		tree.insert(103);
		tree.insert(110);

		tree.insert(55);
		tree.insert(85);

		tree.insert(80);

		tree.insert(83);

		System.out.println(tree);
		int find = 83;
		System.out.println("Contains " + find + ": " + tree.contains(find));
	}

	private static void height() {
		Tree<Integer> tree = new BinarySearchTree<>();
		tree.insert(99);

		tree.insert(50);
		tree.insert(105);

		tree.insert(1);
		tree.insert(75);
		tree.insert(103);
		tree.insert(110);

		tree.insert(55);
		tree.insert(85);

		tree.insert(80);

		tree.insert(83);

		System.out.println(tree);
		System.out.println("Height: " + tree.height());
	}

	private static void size() {
		Tree<Integer> tree = new BinarySearchTree<>();
		tree.insert(99);

		tree.insert(50);
		tree.insert(105);

		tree.insert(1);
		tree.insert(75);
		tree.insert(103);
		tree.insert(110);

		tree.insert(55);
		tree.insert(85);

		tree.insert(80);

		tree.insert(83);
		
		tree.insert(60);

		System.out.println(tree);
		System.out.println("Size: " + tree.size(110));
	}

	private static void bfsTraversal() {
		Tree<Integer> tree = new BinarySearchTree<>();
		tree.insert(99);

		tree.insert(50);
		tree.insert(105);

		tree.insert(1);
		tree.insert(75);
		tree.insert(103);
		tree.insert(110);

		tree.insert(55);
		tree.insert(85);

		tree.insert(80);

		tree.insert(83);

		System.out.println(tree);
		System.out.println("BFS Traversal: " + tree.bfsTraverse());
	}

}
