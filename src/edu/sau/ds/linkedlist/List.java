package edu.sau.ds.linkedlist;

import edu.sau.ds.linkedlist.LinkedList.Node;

public interface List<T extends Comparable<T>> {

	public void insert(T data);

	public void insert(Node<T> node);

	public void insertAtEnd(T data);

	public void insertAtEnd(Node<T> node);

	public void remove(T data);

	public void traverseList();

	public void traverseForLoopingList();

	public int size();

	public Node<T> getRootNode();

}
