package com.saurabh.linkedlist;

public class Node<T extends Comparable<T>> {

	private T data;
	private Node<T> nextNode;
	private Node<T> randomNode;

	public Node<T> getRandomNode() {
		return randomNode;
	}

	public void setRandomNode(Node<T> randomNode) {
		this.randomNode = randomNode;
	}

	public Node(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}

}
