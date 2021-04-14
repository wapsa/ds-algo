package edu.sau.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MinElementStackUsingExtraSpace<T extends Comparable<T>> implements Stack<T> {

	private T[] stack;
	private int size;
	private final Stack<T> minOperationSupportingStack = new ArrayBackedStack<>();

	@SuppressWarnings("unchecked")
	public MinElementStackUsingExtraSpace() {
		this.stack = (T[]) new Comparable[1];
	}

	@SuppressWarnings("unchecked")
	public MinElementStackUsingExtraSpace(int initialCapacity) {
		this.stack = (T[]) new Comparable[initialCapacity];
	}

	// O(1) if no resize otherwise O(n)
	// amortized time of a push operation is the average time taken by a push over
	// the series of operations, that is, T(n)/n.
	public void push(T data) {

		if (minOperationSupportingStack.isEmpty() || minOperationSupportingStack.peek().compareTo(data) >= 0) {
			minOperationSupportingStack.push(data);
		}

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

		if (itemToPop.compareTo(minOperationSupportingStack.peek()) == 0) {
			minOperationSupportingStack.pop();
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
		return minOperationSupportingStack.peek();
	}

}
