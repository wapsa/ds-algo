package edu.sau.stack;

public interface Stack<T extends Comparable<T>> {

	public void push(T data);

	public T pop();

	public T peek();

	public int size();

	public boolean isEmpty();

	public T getMinElement();
}
