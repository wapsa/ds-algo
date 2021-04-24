package edu.sau.tree.bst;

import edu.sau.tree.Tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
	
	private Node<T> rootNode;

	@Override
	public void insert(T data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(T data) {
		// TODO Auto-generated method stub

	}

	@Override
	public T getMaxElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getMinElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void traverse() {
		// TODO Auto-generated method stub

	}

	private static class Node<T extends Comparable<T>> {

		private T data;
		private Node<T> leftChild;
		private Node<T> rightChild;

		public Node(T data) {
			super();
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public Node<T> getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(Node<T> leftChild) {
			this.leftChild = leftChild;
		}

		public Node<T> getRightChild() {
			return rightChild;
		}

		public void setRightChild(Node<T> rightChild) {
			this.rightChild = rightChild;
		}

		@Override
		public String toString() {
			return data.toString();
		}

	}

}
