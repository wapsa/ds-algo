package edu.sau.queue;

public interface Deque<T extends Comparable<T>> extends Queue<T> {

	void offerFirst(T data);

	void offerLast(T data);

	T pollFirst();

	T pollLast();

	T peekFirst();

	T peekLast();

	public int size();

	public boolean isEmpty();

}
