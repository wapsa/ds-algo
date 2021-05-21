package edu.sau.ds.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 
 * 1) 2x - x = x
 * 
 * 2) 2y - x <= x
 * 
 * Statement 2 is true for all values of y where y <= x
 * 
 * Strategy:
 * 
 * A) Push: <br>
 * i) If stack is empty then directly assign minElement = dataToBePushed.
 * 
 * ii) If dataToBePushed is less than or equal to current minElement, then
 * update the minElement. Instead of pushing dataToBePushed to stack we push 2 *
 * dataToBePushed - previousMinElement.
 * 
 * B: Pop: <br>
 * i) If stack size becomes 1 due to popping, then we set the element in stack
 * to minElement.
 * 
 * ii) If poppedItem is less than or equal to minElement then update minElement
 * = previousMin = 2 * minElement - itemToPop. Also update the returnable
 * poppedItem with the minElement.
 * 
 * C: Peek:<br>
 * i) If stack top is less than or equal to minElement, then return minElement
 * otherwise return stack top.
 * 
 */
public class MinElementStackUsingO1Space implements Stack<Long> {

	private Long[] stack;
	private int size;
	private Long minElement;

	public MinElementStackUsingO1Space() {
		this.stack = (Long[]) new Long[1];
	}

	public MinElementStackUsingO1Space(int initialCapacity) {
		this.stack = (Long[]) new Long[initialCapacity];
	}

	// O(1) if no resize otherwise O(n)
	// amortized time of a push operation is the average time taken by a push over
	// the series of operations, that is, T(n)/n.
	public void push(Long data) {

		if (minElement == null) {
			// 2x - x = x
			minElement = data;
		} else if (data.compareTo(minElement) <= 0) {
			Long stackElement = 2 * data - minElement;
			minElement = data;
			data = stackElement;
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
	private void resize(int newSize) {
		Long[] stackCopy = (Long[]) new Long[newSize];

		System.arraycopy(stack, 0, stackCopy, 0, size);

		this.stack = stackCopy;
	}

	// O(1) if no resize otherwise O(n)
	public Long pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		Long itemToPop = this.stack[--size];

		// will send the referenced object to garbage collection.
		stack[size] = null;

		// When size(no of elements in the stack managed by this class) is equal to 25%
		// of the array size(stack.length) we will resize the
		if (this.size > 0 && this.size == this.stack.length / 4) {
			resize(this.stack.length / 2);
		}

		if (itemToPop.compareTo(minElement) <= 0) {
			Long previousMin = 2 * minElement - itemToPop;
			itemToPop = minElement;
			minElement = size != 0 ? previousMin : null;
		}

		// if stack[size] = null; is commented, it is not removed from the stack array,
		// but we are managing the array using size which is getting decremented.
		// Eventually when resize is called popped items will get removed.
		return itemToPop;
	}

	@Override
	public Long peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		Long top = stack[size - 1];

		if (top.compareTo(minElement) <= 0) {
			return minElement;
		} else {
			return top;
		}
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
	public Long getMinElement() {
		return minElement;
	}

}
