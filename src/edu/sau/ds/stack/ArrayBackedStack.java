package edu.sau.ds.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayBackedStack<T extends Comparable<T>> implements Stack<T> {

	private T[] stack;
	private int size;

	@SuppressWarnings("unchecked")
	public ArrayBackedStack() {
		this.stack = (T[]) new Comparable[1];
	}

	@SuppressWarnings("unchecked")
	public ArrayBackedStack(int initialCapacity) {
		this.stack = (T[]) new Comparable[initialCapacity];
	}

	// O(1) if no resize otherwise O(n)
	// amortized time of a push operation is the average time taken by a push over
	// the series of operations, that is, T(n)/n.
	public void push(T data) {

		if (size == this.stack.length) {
			resize(2 * this.stack.length);
		}
		this.stack[size++] = data;
	}

	/**
	 * For simplicity, let us assume that initially we started with n = 1 and moved
	 * up to n = 32. That means, we do the doubling at 1,2,4,8,16. The other way of
	 * analyzing the same approach is: at n = 1, if we want to add (push) an
	 * element, double the current size of the array and copy all the elements of
	 * the old array to the new array.
	 * 
	 * At n = 1, we do 1 copy operation, at n = 2, we do 2 copy operations, and at n
	 * = 4, we do 4 copy operations and so on. By the time we reach n = 32, the
	 * total number of copy operations is 1+2 + 4 + 8+16 = 31 which is approximately
	 * equal to 2n value (32). If we observe carefully, we are doing the doubling
	 * operation logn times. Now, let us generalize the discussion. For n push
	 * operations we double the array size logn times.
	 */
	/**
	 * O(n) resize operation occurs by doubling so : 2^(resize operations count) =
	 * capacity of array
	 *
	 * How many copy operations are there if capacity is n and if we take initial
	 * capacity as 1:
	 *
	 * n+ n/2 + n/4 + n/8 + ... + 4 + 2 + 1; now take the n as common :
	 *
	 * n+ n/2 + n/4 + n/8 + ... + 4 + 2 + 1 = n(1 + 1/2 + 1/4 + +1/8 +...+4/n +2/n
	 * +1/n ) = n(1+ (1)) since : 1/2 + 1/4 + +1/8 +...+4/n +2/n +1/n = 1 approx =
	 * 2n
	 *
	 *
	 * So, resize operation is O(n)
	 *
	 * Book Section : 4.5 and 4.6 =============================================== We
	 * call amortized time of a push operation is the average time taken by a push
	 * over the series of operations, that is, T(n)/n. Incremental Strategy: The
	 * amortized time (average time per operation) of a push operation is O(n)
	 * [O(2n)/n] =O(1). Doubling Strategy: In this method, the amortized time of a
	 * push operation is O(1) [O(n)/n].
	 *
	 * @see https://stackoverflow.com/questions/1100311/what-is-the-ideal-growth-rate-for-a-dynamically-allocated-array
	 */
	// O(n), depends on System.arraycopy
	// https://stackoverflow.com/questions/2772152/why-is-system-arraycopy-native-in-java
	// https://docs.oracle.com/javase/6/docs/api/java/lang/System.html#arraycopy(java.lang.Object,%20int,%20java.lang.Object,%20int,%20int)
	@SuppressWarnings("unchecked")
	private void resize(int newSize) {
		T[] stackCopy = (T[]) new Comparable[newSize];

		System.arraycopy(stack, 0, stackCopy, 0, size);

		this.stack = stackCopy;
	}

	// O(1) if no resize otherwise O(n)
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		T itemToPop = this.stack[--size];

		// will send the referenced object to garbage collection.
		stack[size] = null;

		// When size(no of elements in the stack managed by this class) is equal to 25%
		// of the array size(stack.length) we will resize the
		if (this.size > 0 && this.size == this.stack.length / 4) {
			resize(this.stack.length / 2);
		}

		// if stack[size] = null; is commented, it is not removed from the stack array,
		// but we are managing the array using size which is getting decremented.
		// Eventually when resize is called popped items will get removed.
		return itemToPop;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return stack[size - 1];
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stack [stack=");
		builder.append(Arrays.toString(stack));
		builder.append("]");
		return builder.toString();
	}

	@Override
	public T getMinElement() {
		throw new UnsupportedOperationException();
	}

}
