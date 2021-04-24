package edu.sau.queue;

import java.util.Arrays;

/**
 * Queue implementation based on circular array. All operations take amortized
 * O(1) time.
 * 
 */
public class ArrayQueue<T extends Comparable<T>> implements Queue<T> {

	private T[] elements;

	private int head = 0;
	// tail will always point to empty index, if queue is full means tail points to
	// head and head !=null. If tail points to head and head ==null, it means that
	// the queue is empty.
	private int tail = 0;

	/**
	 * The maximum size of array to allocate. Some VMs reserve some header words in
	 * an array. Attempts to allocate larger arrays may result in OutOfMemoryError:
	 * Requested array size exceeds VM limit
	 */
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	private static final int INITIAL_CAPACITY = 10;

	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		elements = (T[]) new Comparable[INITIAL_CAPACITY];
	}

	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		elements = (T[]) new Comparable[capacity > 0 ? capacity : INITIAL_CAPACITY];
	}

	// O(1)
	@Override
	public void offer(T data) {
		elements[tail] = data;
		// basically incrementally cycling through the indexes in array and then
		// repeating from 0 again. [0,1,2,3,0,1,2,3,0,1,2,3,......]
		tail = ++tail % elements.length;

		if (isFull()) {
			grow();
		}
	}

	/**
	 * Post offer, if queue becomes full, then we need to grow the size of the
	 * array. There are two strategies in circular array implementation to realign
	 * the head and tail pointers after growing the array.
	 * 
	 * i) Tail re-alignment: copy the elements from index 0 to tail, to oldCapacity
	 * and ahead.
	 * 
	 * Why should we avoid using tail realignment when growth is less than double ?
	 *
	 * Since tail window moves in backward direction calculation becomes tricky.
	 *
	 * ii) Head re-alignment: copy the elements from head to oldCapacity, to the end
	 * of grown array.
	 * 
	 * Calculations:
	 * 
	 * newFreeSpace = newCapacity - oldCapacity
	 * 
	 * 
	 */
	private void grow() {
		int oldCapacity = elements.length;
		int newCapacity = newCapacity(oldCapacity);

		elements = Arrays.copyOf(elements, newCapacity);

		realignHeadElements(oldCapacity, newCapacity);
	}

	/**
	 * Slide the window of elements from head - oldCapacity to the end of the new
	 * array.
	 * 
	 * move each element in between head and oldCapacity freeSpaceUnits ahead.
	 */
	private void realignHeadElements(int oldCapacity, int newCapacity) {

		int freeSpaceUnits = newCapacity - oldCapacity;
		System.arraycopy(elements, head, elements, head + freeSpaceUnits, oldCapacity - head);

		// clear the elements as we have copied them to the correct position after
		// growing the array.
		for (int i = head; i < head + freeSpaceUnits - head; i++)
			elements[i] = null;

		head += freeSpaceUnits;
	}

	/**
	 * Integer size = 32 bits<br>
	 * So possible values = 2^32. Since integer is signed so it is having two equal
	 * parts 2^31 each. <br>
	 * parts calculation 2^32 = 2*2^31 = 2^31 + 2^31
	 *
	 * -2^31<--------------------------0----------------------------->+(2^31 - 1)
	 *
	 * -ve range : -1 to -2^31
	 *
	 * +ve range :0 to 2^31 -1
	 *
	 * Integer.MAX_VALUE = 2^31 -1
	 *
	 * MAX_ARRAY_SIZE = (Integer.MAX_VALUE - 8) = 2^31 -1 -8 = (2^31 -9)
	 *
	 * CONDITION : (x - MAX_ARRAY_SIZE > 0 ) can be true in following two cases :
	 *
	 * CASE 1: NON OVERFLOW CASE <br>
	 * In this case x is +ve. <br>
	 * MAX_ARRAY_SIZE < x < Integer.MAX_VALUE OR 2^31 -9 < x < 2^31 -1
	 *
	 *
	 * CASE2: OVERFLOW CASE : when x is near to Integer.MIN_VALUE <br>
	 * In this case x is -ve. <br>
	 *
	 * Means x was intended to be greater than Integer.MAX_VALUE, but has
	 * over-flowed to -ve. <br>
	 * Overflow mathematics : x = Integer.MAX_VALUE + 1 = Integer.MIN_VALUE
	 *
	 * e.g. Lets add 500 to Integer.MAX_VALUE <br>
	 * int x = Integer.MAX_VALUE + 500 = 2^31 - 1 + 500 <br>
	 * => x = Integer.MIN_VALUE + 499 = -2^31 + 499 <br>
	 *
	 * Now substitute the value of x in CONDITION (x - MAX_ARRAY_SIZE > 0 )
	 *
	 * x - MAX_ARRAY_SIZE = -2^31 + 499 - MAX_ARRAY_SIZE = -2^31 + 499 - (2^31 -9) =
	 * +508 <br>
	 * This implies that if the value of x lies near to Integer.MIN_VALUE then
	 * condition may come true.
	 *
	 * Double the capacity if small i.e less than 64; else grow by 50%
	 */
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
			size = elements.length + tail - head;
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
