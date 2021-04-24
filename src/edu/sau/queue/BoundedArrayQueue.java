package edu.sau.queue;

import java.util.Arrays;

/**
 * Queue implementation based on bounded circular array. All operations take
 * O(1) time.
 */
public class BoundedArrayQueue<T extends Comparable<T>> implements Queue<T> {

	private final T[] elements;

	private int head = 0;
	// tail will always point to empty index, if queue is full means tail points to
	// head and head !=null. If tail points to head and head ==null, it means that
	// the queue is empty.
	private int tail = 0;

	@SuppressWarnings("unchecked")
	public BoundedArrayQueue(int capacity) {
		elements = (T[]) new Comparable[capacity];
	}

	// O(1)
	@Override
	public void offer(T data) {
		if (isFull()) {
			throw new RuntimeException("Queue is full !!");
		}
		elements[tail] = data;
		// basically incrementally cycling through the indexes in array and then
		// repeating from 0 again. [0,1,2,3,0,1,2,3,0,1,2,3,......]
		tail = ++tail % elements.length;
	}

	// O(1)
	@Override
	public T poll() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty !!");
		}
		T toPollElement = elements[head];
		elements[head] = null;
		// basically incrementally cycling through the indexes in array and then
		// repeating from 0 again. [0,1,2,3,0,1,2,3,0,1,2,3,......]
		head = ++head % elements.length;
		return toPollElement;
	}

	// O(1)
	@Override
	public T peek() {
		if (isEmpty()) {
			return null;
		}
		return elements[head];
	}

	// O(1)
	@Override
	public int size() {
		// if head and tail are both in the same circle.
		int size = tail - head;

		if (isEmpty()) {
			size = 0;
		}
		// if tail has entered the next circle and head is still in previous circle,
		// then tail - head < 0
		// tail - head can be 0 in two cases, when it is empty and when it is full. If
		// it is full then size is basically equal to elements.length
		else if (tail - head <= 0) {
			size = elements.length + (tail - head);
		}
		return size;
	}

	// O(1)
	@Override
	public boolean isEmpty() {
		return tail == head && elements[head] == null;
	}

	private boolean isFull() {
		return tail == head && elements[head] != null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[elements=");
		builder.append(Arrays.toString(elements));
		builder.append("]");
		return builder.toString();
	}

}
