package com.saurabh.stack;

import java.util.EmptyStackException;

import com.saurabh.linkedlist.Node;

public class LinkedListStack<T extends Comparable<T>> implements Stack<T> {

	private StackNode<T> rootNode;
	private int size;

	// O(1)
	public void push(T data) {
		if (isEmpty()) {
			this.rootNode = new StackNode<>(data);
		} else {
			StackNode<T> oldRoot = this.rootNode;
			this.rootNode = new StackNode<>(data);
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

	public StackNode<T> getRootNode() {
		return this.rootNode;
	}

	public boolean isEmpty() {
		return this.rootNode == null;
	}

	private void traverseList() {

		if (this.rootNode == null) {
			return;
		}

		StackNode<T> actualNode = this.rootNode;

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

}
