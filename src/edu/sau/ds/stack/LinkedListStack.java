package edu.sau.ds.stack;

import java.util.EmptyStackException;

public class LinkedListStack<T extends Comparable<T>> implements Stack<T> {

	private Node<T> rootNode;
	private int size;

	// O(1)
	public void push(T data) {
		if (isEmpty()) {
			this.rootNode = new Node<>(data);
		} else {
			Node<T> oldRoot = this.rootNode;
			this.rootNode = new Node<>(data);
			this.rootNode.setNextNode(oldRoot);
		}
		this.size++;
	}

	// O(1)
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		T itemToPop = this.getRootNode().getData();
		this.rootNode = this.rootNode.getNextNode();
		this.size--;
		return itemToPop;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return this.rootNode.getData();
	}

	public int size() {
		return this.size;
	}

	public Node<T> getRootNode() {
		return this.rootNode;
	}

	public boolean isEmpty() {
		return this.rootNode == null;
	}

	private void traverseList() {

		if (this.rootNode == null) {
			return;
		}

		Node<T> actualNode = this.rootNode;

		while (actualNode != null) {
			System.out.print(actualNode + " ---> ");
			if (actualNode.getNextNode() == null) {
				System.out.print("NULL");
			}

			actualNode = actualNode.getNextNode();
		}
		System.out.println();
	}

	@Override
	public String toString() {
		traverseList();
		return "";
	}

	@Override
	public T getMinElement() {
		throw new UnsupportedOperationException();
	}

	private static class Node<T extends Comparable<T>> {

		private final T data;
		private Node<T> nextNode;

		public Node(T data) {
			super();
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public Node<T> getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node<T> nextNode) {
			this.nextNode = nextNode;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [data=");
			builder.append(data);
			builder.append("]");
			return builder.toString();
		}

	}

}
