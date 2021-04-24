package edu.sau.queue;

public class LinkedListQueue<T extends Comparable<T>> implements Queue<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	@Override
	public void offer(T data) {
		Node<T> oldLastNode = tail;
		tail = new Node<>(data);

		if (isEmpty()) {
			head = tail;
		} else {
			oldLastNode.setNextNode(tail);
		}
		size++;
	}

	@Override
	public T poll() {
		T dataToPoll = head.getData();
		head = head.getNextNode();

		if (isEmpty()) {
			tail = null;
		}
		size--;
		return dataToPoll;
	}

	@Override
	public T peek() {
		return isEmpty() ? null : head.getData();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public String toString() {
		StringBuilder ss = new StringBuilder("[");
		Node<T> temp = head;
		while (temp != null) {
			ss.append(temp);
			if (temp.getNextNode() != null) {
				ss.append(", ");
			}
			temp = temp.getNextNode();
		}
		ss.append("]");
		return ss.toString();
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
			return data.toString();
		}

	}

}
