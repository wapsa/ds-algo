package edu.sau.queue;

public interface Queue<T extends Comparable<T>> {

	public void offer(T data);

	public T poll();

	public T peek();

	public int size();

	public boolean isEmpty();

}
