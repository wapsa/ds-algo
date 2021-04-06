package edu.sau.linkedlist;

public interface List<T extends Comparable<T>> {

	public void insert(T data);

	public void insert(Node<T> node);

	public void insertAtEnd(T data);

	public void insertAtEnd(Node<T> node);

	public void remove(T data);

	public void traverseList();

	public void traverseForLoopingList();

	public long size();

	public Node<T> getRootNode();

}
