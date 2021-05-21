package edu.sau.ds.tree.bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

import edu.sau.ds.tree.Tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;
	private int size;

	private static final class Node<T extends Comparable<T>> {

		private T data;
		private Node<T> left;
		private Node<T> right;

		public Node(T data) {
			super();
			this.data = data;
		}

		@Override
		public String toString() {
			return data.toString();
		}

	}

	@Override
	public void insert(T data) {
		if (isEmpty()) {
			root = new Node<>(data);
			size++;
			return;
		}
		boolean inserted = insert(data, root);
		if (inserted) {
			size++;
		}
	}

	private boolean insert(T data, Node<T> node) {
		int cmp = data.compareTo(node.data);

		if (cmp == 0)
			return false;

		if (cmp < 0) {

			if (node.left != null) {
				insert(data, node.left);
			} else {
				node.left = new Node<>(data);
			}

		} else {

			if (node.right != null) {
				insert(data, node.right);
			} else {
				node.right = new Node<>(data);
			}

		}
		return true;
	}

	@Override
	public boolean delete(T data) {
		if (isEmpty())
			return false;
		int sizeBeforeDelete = this.size;
		root = delete(data, root);
		// root = iterativeDelete(data, root);
		int sizeAfterDelete = this.size;
		return sizeAfterDelete == sizeBeforeDelete - 1;
	}

	private Node<T> delete(T data, Node<T> node) {
		if (node == null)
			return node;

		int cmp = data.compareTo(node.data);

		// data to be deleted is found in the tree.
		if (cmp == 0) {

			/**
			 * CASE 1: node to be deleted is a leaf node.
			 */

			if (isLeafNode(node)) {
				size--;
				node = null;
				return null;
			}

			/**
			 * CASE 2: node to be deleted has only left or right subtree.
			 */

			if (node.left == null) {
				// node to be deleted has right subtree.
				Node<T> rightSubTree = node.right;
				// garbage collect node.
				node = null;
				size--;
				return rightSubTree;
			}
			if (node.right == null) {
				// node to be deleted has left subtree.
				Node<T> leftSubTree = node.left;
				// garbage collect node.
				node = null;
				size--;
				return leftSubTree;
			}

			/**
			 * CASE 3: node to be deleted has left and right subtree.
			 * 
			 * Case 3 will be converted into either Case 1 or 2, by overwriting data to be
			 * deleted with either successor or predecessor.
			 */

			// Approach # 1 - Using predecessor
			// Node<T> predecessorNode = getPredecessor(node);
			// discard value to be deleted and replace with predecessor node data.
			// node.data = predecessorNode.data;
			// Find predecessor data in left subtree and delete the node.
			// node.left = delete(predecessorNode.data, node.left);

			// Approach # 2 - Using successor
			Node<T> successorNode = getSuccessor(node);
			// discard value to be deleted and replace with successor node data.
			node.data = successorNode.data;
			// Find successor data in right subtree and delete the node.
			node.right = delete(successorNode.data, node.right);

		} else if (cmp < 0) {
			// data to be deleted is lesser than node, so going left.
			node.left = delete(data, node.left);
		} else if (cmp > 0) {
			// data to be deleted is greater than node, so going right.
			node.right = delete(data, node.right);
		}
		return node;
	}

	private Node<T> iterativeDelete(T data, Node<T> node) {
		Node<T> parent = null;

		boolean isDeleteRootNode = data.compareTo(node.data) == 0;

		while (node != null) {

			final int cmp = data.compareTo(node.data);
			if (cmp == 0) {
				// data to be deleted found.

				/**
				 * CASE 1: node to be deleted is a leaf node.
				 */
				if (isLeafNode(node)) {
					size--;

					if (isDeleteRootNode) {
						return null;
					}

					if (parent.left == node)
						parent.left = null;
					if (parent.right == node)
						parent.right = null;
					node = null;
				}
				/**
				 * CASE 2: node to be deleted has only left or right subtree.
				 */
				else if (node.left == null) {

					if (isDeleteRootNode) {
						return node.right;
					}

					if (parent.left == node)
						parent.left = node.right;

					if (parent.right == node)
						parent.right = node.right;
					size--;
					node = null;
				} else if (node.right == null) {

					if (isDeleteRootNode) {
						return node.left;
					}

					if (parent.left == node)
						parent.left = node.left;

					if (parent.right == node)
						parent.right = node.left;
					size--;
					node = null;
				} else {
					/**
					 * CASE 3: node to be deleted has left and right subtree.
					 */
					// Approach # 1 - Using predecessor
					// Populate predecessor in node.
					Node<T> predecessorNode = node.left;
					parent = node;
					while (predecessorNode.right != null) {
						parent = predecessorNode;
						predecessorNode = predecessorNode.right;
					}
					// discard value to be deleted and replace with predecessor node data.
					node.data = predecessorNode.data;

					// Now, update delete node to predecessor data in left subtree and delete the
					// node.
					node = predecessorNode;
					data = predecessorNode.data;

					// As we have updated the data in root and need to delete the predecessor node
					// instead.
					if (isDeleteRootNode) {
						isDeleteRootNode = false;
					}
					continue;
				}

			} else if (cmp < 0) {
				// data to be deleted is lesser than node, so going left.
				parent = node;
				node = node.left;
			} else {
				// data to be deleted is greater than node, so going right.
				parent = node;
				node = node.right;
			}
		}
		return this.root;
	}

	/**
	 * Predecessor: Max element in left subtree of node.
	 * 
	 * Predecessor node cannot have right child as max is found by going all right.
	 * It may or may not have left child.
	 */
	private Node<T> getPredecessor(Node<T> node) {
		return getMaxElement(node.left);
	}

	/**
	 * Successor: Min element in right subtree of node.
	 * 
	 * Successor node cannot have left child as min is found by going all left. It
	 * may or may not have right child.
	 */
	private Node<T> getSuccessor(Node<T> node) {
		return getMinElement(node.right);
	}

	/**
	 * Go all right till leaf node.
	 */
	@Override
	public T getMaxElement() {
		return isEmpty() ? null : getMaxElement(root).data;
	}

	private Node<T> getMaxElement(Node<T> node) {
		return node.right == null ? node : getMaxElement(node.right);
	}

	/**
	 * Go all left till leaf node.
	 */
	@Override
	public T getMinElement() {
		return isEmpty() ? null : getMinElement(root).data;
	}

	private Node<T> getMinElement(Node<T> node) {
		return node.left == null ? node : getMinElement(node.left);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int size(T data) {
		List<T> accumulator = new ArrayList<>();
		recursiveInOrder(accumulator, searchNodeRecursive(data, root));
		return accumulator.size();
	}

	private Node<T> searchNodeRecursive(T data, Node<T> node) {
		if (node == null)
			return null;

		int cmp = data.compareTo(node.data);
		if (cmp == 0)
			return node;
		else if (cmp < 0)
			return searchNodeRecursive(data, node.left);
		else
			return searchNodeRecursive(data, node.right);
	}

	@Override
	public boolean isEmpty() {
		return this.root == null;
	}

	/**
	 * Binary Search Tree may or may not be balanced, so going down all left path
	 * will not give the correct height for unbalanced trees.
	 */
	@Override
	public int height() {
		return isEmpty() ? 0 : height(root);
	}

	private int height(Node<T> node) {
		if (node == null)
			return -1;
		return 1 + Math.max(height(node.left), height(node.right));
	}

	private boolean isLeafNode(Node<T> node) {
		return node.left == null && node.right == null;
	}

	@Override
	public boolean contains(T data) {
		if (isEmpty())
			return false;
		// return searchRecursive(data, root);
		return searchIterative(data, root);
	}

	private boolean searchRecursive(T data, Node<T> node) {
		if (node == null)
			return false;

		int cmp = data.compareTo(node.data);
		if (cmp == 0)
			return true;
		else if (cmp < 0)
			return searchRecursive(data, node.left);
		else
			return searchRecursive(data, node.right);
	}

	private boolean searchIterative(T data, Node<T> node) {
		while (node != null) {
			int cmp = data.compareTo(node.data);

			if (cmp == 0)
				return true;
			else if (cmp < 0)
				node = node.left;
			else
				node = node.right;
		}
		return false;
	}

	@Override
	public String toString() {
		System.out.println();
		print(root);
		return "";
	}

	/**
	 * Print a tree
	 *
	 * @param root tree root node
	 */
	public void print(Node<T> root) {
		List<List<String>> lines = new ArrayList<List<String>>();

		List<Node<T>> level = new ArrayList<>();
		List<Node<T>> next = new ArrayList<>();

		level.add(root);
		int nn = 1;

		int widest = 0;

		while (nn != 0) {
			List<String> line = new ArrayList<String>();

			nn = 0;

			for (Node<T> n : level) {
				if (n == null) {
					line.add(null);
					next.add(null);
					next.add(null);
				} else {
					String aa = n.data.toString();
					line.add(aa);
					if (aa.length() > widest)
						widest = aa.length();

					next.add(n.left);
					next.add(n.right);

					if (n.left != null)
						nn++;
					if (n.right != null)
						nn++;
				}
			}

			if (widest % 2 == 1)
				widest++;

			lines.add(line);

			List<Node<T>> tmp = level;
			level = next;
			next = tmp;
			next.clear();
		}

		int perpiece = lines.get(lines.size() - 1).size() * (widest);
		for (int i = 0; i < lines.size(); i++) {
			List<String> line = lines.get(i);
			int hpw = (int) Math.floor(perpiece / 2f) - 1;

			if (i > 0) {
				for (int j = 0; j < line.size(); j++) {

					// split node
					char c = ' ';
					if (j % 2 == 1) {
						if (line.get(j - 1) != null) {
							c = (line.get(j) != null) ? '┴' : '┘';
						} else {
							if (j < line.size() && line.get(j) != null)
								c = '└';
						}
					}
					System.out.print(c);

					// lines and spaces
					if (line.get(j) == null) {
						for (int k = 0; k < perpiece - 1; k++) {
							System.out.print(" ");
						}
					} else {

						for (int k = 0; k < hpw; k++) {
							System.out.print(j % 2 == 0 ? " " : "─");
						}
						System.out.print(j % 2 == 0 ? "┌" : "┐");
						for (int k = 0; k < hpw; k++) {
							System.out.print(j % 2 == 0 ? "─" : " ");
						}
					}
				}
				System.out.println();
			}

			// print line of numbers
			for (int j = 0; j < line.size(); j++) {

				String f = line.get(j);
				if (f == null)
					f = "";
				int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
				int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

				// a number
				for (int k = 0; k < gap1; k++) {
					System.out.print(" ");
				}
				System.out.print(f);
				for (int k = 0; k < gap2; k++) {
					System.out.print(" ");
				}
			}
			System.out.println();

			perpiece /= 2;
		}
	}

	@Override
	public List<T> preOrderTraverse() {
		List<T> accumulator = new ArrayList<>();
		// recursivePreOrder(accumulator, root);
		iterativePreOrder(accumulator, root);
		return accumulator;
	}

	private void recursivePreOrder(List<T> accumulator, Node<T> node) {
		if (node == null)
			return;
		accumulator.add(node.data);
		recursivePreOrder(accumulator, node.left);
		recursivePreOrder(accumulator, node.right);
	}

	/**
	 * Pre order traversal is NLR so stack insertion order is RLN
	 */
	private void iterativePreOrder(List<T> accumulator, Node<T> node) {
		if (node == null)
			return;
		Deque<Node<T>> stack = new ArrayDeque<>();
		stack.push(node);

		while (!stack.isEmpty()) {
			node = stack.pop();
			accumulator.add(node.data);

			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
	}

	@Override
	public List<T> inOrderTraverse() {
		List<T> accumulator = new ArrayList<>();
		// recursiveInOrder(accumulator, root);
		iterativeInOrderGoAllLeft(accumulator, root);
		return accumulator;
	}

	private void recursiveInOrder(List<T> accumulator, Node<T> node) {
		if (node == null)
			return;
		recursiveInOrder(accumulator, node.left);
		accumulator.add(node.data);
		recursiveInOrder(accumulator, node.right);
	}

	private void iterativeInOrderGoAllLeft(List<T> accumulator, Node<T> node) {
		if (node == null)
			return;
		Deque<Node<T>> stack = new ArrayDeque<>();

		while (node != null || !stack.isEmpty()) {

			// STEP 1: Push the entire left branch of the node into the stack.
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			// STEP 2: Pop and print left-most node and backtrack to parent node in next
			// iteration and do the same.
			node = stack.pop();
			accumulator.add(node.data);

			// STEP 3: Repeat step 1 and 2 for right subtree.
			node = node.right;
		}
	}

	@Override
	public List<T> postOrderTraverse() {
		List<T> accumulator = new ArrayList<>();
		// recursivePostOrder(accumulator, root);
		// iterativePostOrderAllLeft(accumulator, root);
		iterativePostOrderNodeRightLeft(accumulator, root);
		return accumulator;
	}

	private void recursivePostOrder(List<T> accumulator, Node<T> node) {
		if (node == null)
			return;
		recursivePostOrder(accumulator, node.left);
		recursivePostOrder(accumulator, node.right);
		accumulator.add(node.data);
	}

	/**
	 * POSTORDER : L-R-N
	 *
	 * <pre>
	 * High level algo :
	 * STEP1: Go all left
	 * STEP2: print the leftmost node(L)
	 * STEP3: Backtrack to parent using stack.peek()
	 *  STEP3A: IF there is no right-child or right-child is already visited
	 *          then pop and print the node.
	 *  STEP3B: ELSE parent has un-visited right-child
	 *          then repeat STEP1 to STEP3 for right(R) child of parent.
	 *
	 * Low level algo:
	 * We need to push the nodes on stack while going all left because we are backtracking to
	 * parent in next step.
	 * </pre>
	 */
	private void iterativePostOrderAllLeft(List<T> accumulator, Node<T> node) {

		if (node == null)
			return;
		Deque<Node<T>> stack = new ArrayDeque<>();
		Node<T> previous = null;

		while (node != null || !stack.isEmpty()) {

			// STEP 1: Push the entire left branch of the node into the stack.
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			node = stack.peek();

			// Either there is no right child or right child has already been visited.
			if (node.right == null || node.right == previous) {
				accumulator.add(node.data);
				previous = node;
				node = null;

				// discard stack top as we have already processed it.
				stack.pop();
			} else {
				// Go right only if it has not been visited.
				node = node.right;
			}
		}
	}

	/**
	 * Post Order Traversal is LRN so stack insertion order is NRL.
	 * 
	 * STEP 1: push root node in stack. <br>
	 * STEP 2: FOR EACH: [ backtrack using stack.peek() ] <br>
	 * 
	 * STEP 3:
	 * 
	 * <pre>
	 * 	
	 * 			IF
	 * 
	 * 				stack.peek() is leaf node or previously visited parent, then
	 * 				print and pop the element. <br>
	 * 		
	 * 			ELSE
	 * 
	 * 				Push left and right of stack.peek() on stack.
	 * </pre>
	 * 
	 * 
	 */
	private void iterativePostOrderNodeRightLeft(List<T> accumulator, Node<T> node) {
		if (node == null)
			return;

		Deque<Node<T>> stack = new ArrayDeque<>();
		stack.push(node);

		Node<T> previous = null;

		while (!stack.isEmpty()) {

			node = stack.peek();

			if (isLeafNode(node) || node.left == previous || node.right == previous) {
				accumulator.add(node.data);
				previous = node;
				stack.pop();

			} else {
				if (node.right != null)
					stack.push(node.right);
				if (node.left != null)
					stack.push(node.left);
			}
		}
	}

	@Override
	public List<T> bfsTraverse() {
		List<T> traversal = new ArrayList<>();
		Queue<Node<T>> queue = new ArrayDeque<>();

		if (!isEmpty()) {
			queue.offer(root);
		}

		while (!queue.isEmpty()) {
			Node<T> node = queue.poll();

			if (node.left != null)
				queue.offer(node.left);

			if (node.right != null)
				queue.offer(node.right);

			traversal.add(node.data);
		}
		return traversal;
	}

}
