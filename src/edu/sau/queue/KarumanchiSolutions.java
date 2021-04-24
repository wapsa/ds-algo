package edu.sau.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class KarumanchiSolutions<T extends Comparable<T>> implements KarumanchiQuestions<T> {

	@Override
	public void reverseQueue(Queue<T> queue) {

		Deque<T> stack = new ArrayDeque<>();

		while (!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
	}

	/**
	 *
	 * Alogo:
	 *
	 * 1. offer : <br>
	 * push the incoming element in offerStack
	 *
	 * 2. poll : <br>
	 * if pollStack is empty: pop all the elements from offerStack and push into
	 * pollStack, and then return the top element of pollStack<br>
	 *
	 * if pollStack is not empty : pop and return the element
	 *
	 */
	@Override
	public Queue<T> implementQueueUsingTwoStacks() {
		return new Queue<T>() {

			private Deque<T> offerStack = new ArrayDeque<>();
			private Deque<T> pollStack = new ArrayDeque<>();

			@Override
			public void offer(T data) {
				offerStack.push(data);
			}

			@Override
			public T poll() {
				if (isEmpty())
					throw new RuntimeException("Queue is empty !!");

				if (pollStack.isEmpty())
					while (!offerStack.isEmpty())
						pollStack.push(offerStack.pop());

				return pollStack.pop();
			}

			@Override
			public T peek() {
				if (isEmpty())
					return null;

				if (pollStack.isEmpty())
					while (!offerStack.isEmpty())
						pollStack.push(offerStack.pop());

				return pollStack.peek();

			}

			@Override
			public int size() {
				return offerStack.size() + pollStack.size();
			}

			@Override
			public boolean isEmpty() {
				return offerStack.isEmpty() && pollStack.isEmpty();
			}

			@Override
			public String toString() {
				return "offerStack: " + offerStack + ", pollStack: " + pollStack;
			}
		};
	}

}
