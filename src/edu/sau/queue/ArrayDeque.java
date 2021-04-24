package edu.sau.queue;

import java.util.Arrays;

/**
 * Queue implementation based on circular array. All operations take amortized
 * O(1) time.
 * 
 */
public class ArrayDeque<T extends Comparable<T>> implements Deque<T> {

	private T[] elements;

	// head will always point to the head element.
	private int head = 0;
	// tail will always point to empty index which is one ahead of tail element, if
	// queue is full means tail points to head and head !=null. If tail points to
	// head and head ==null, it means that the queue is empty.
	private int tail = 0;

	/**
	 * The maximum size of array to allocate. Some VMs reserve some header words in
	 * an array. Attempts to allocate larger arrays may result in OutOfMemoryError:
	 * Requested array size exceeds VM limit
	 */
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	private static final int INITIAL_CAPACITY = 10;

	@SuppressWarnings("unchecked")
	public ArrayDeque() {
		elements = (T[]) new Comparable[INITIAL_CAPACITY];
	}

	@SuppressWarnings("unchecked")
	public ArrayDeque(int capacity) {
		elements = (T[]) new Comparable[capacity > 0 ? capacity : INITIAL_CAPACITY];
	}

	// head direction: 0,n,n-1,n-2,...4,3,2,1,0,n,n-1,....
	@Override
	public void offerFirst(T data) {
		head = head == 0 ? elements.length - 1 : head - 1;

		elements[head] = data;

		if (isFull()) {
			grow();
		}

	}

	@Override
	public void offer(T data) {
		offerLast(data);
	}

	// tail direction: 0,1,2,3,4,...n,0,1,2,3,4....n
	@Override
	public void offerLast(T data) {
		elements[tail] = data;

		tail = tail == elements.length - 1 ? 0 : tail + 1;

		if (isFull()) {
			grow();
		}
	}

	private void grow() {
		int oldCapacity = elements.length;
		int newCapacity = newCapacity(oldCapacity);

		elements = Arrays.copyOf(elements, newCapacity);

		realignHeadElements(oldCapacity, newCapacity);
	}

	private void realignHeadElements(int oldCapacity, int newCapacity) {

		int freeSpaceUnits = newCapacity - oldCapacity;
		System.arraycopy(elements, head, elements, head + freeSpaceUnits, oldCapacity - head);

		// clear the elements as we have copied them to the correct position after
		// growing the array.
		for (int i = head; i < head + freeSpaceUnits - head; i++)
			elements[i] = null;

		head += freeSpaceUnits;
	}

	private int newCapacity(int oldCapacity) {
		// oldCapacity >> 1 is same as oldCapacity/2, oldCapacity >> 2 is same as
		// oldCapacity/4
		// oldCapacity << 1 will be same as oldCapacity * 2, oldCapacity << 2 will be
		// same as oldCapacity * 4;
		int jump = oldCapacity < 64 ? oldCapacity + 2 : oldCapacity >> 1;
		int newCapacity = oldCapacity + jump;

		// newCapacity if over-flown can be close to Integer.MIN_VALUE
		if (newCapacity - MAX_ARRAY_SIZE > 0) {
			if (newCapacity < 0) {
				throw new IllegalStateException("Sorry, queue too big");
			}
			newCapacity = Integer.MAX_VALUE;
		}
		return newCapacity;
	}

	// head direction: 0,1,2,3,4,....n, 0,1,2,3,4,...n,0,1,2
	@Override
	public T pollFirst() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty !!");
		}
		T toPollElement = elements[head];
		elements[head] = null;

		head = head == elements.length - 1 ? 0 : head + 1;

		return toPollElement;
	}

	@Override
	public T poll() {
		return pollFirst();
	}

	// tail direction: 0,n,n-1,n-2,.....4,3,2,1,0,n,n-1,....
	@Override
	public T pollLast() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty !!");
		}
		tail = tail == 0 ? elements.length - 1 : tail - 1;

		T toPollElement = elements[tail];

		elements[tail] = null;

		return toPollElement;
	}

	@Override
	public T peekFirst() {
		if (isEmpty()) {
			return null;
		}
		return elements[head];
	}

	@Override
	public T peek() {
		return peekFirst();
	}

	@Override
	public T peekLast() {
		if (isEmpty()) {
			return null;
		}
		return elements[tail == 0 ? elements.length - 1 : tail - 1];
	}

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
			size = elements.length + tail - head;
		}
		return size;
	}

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
