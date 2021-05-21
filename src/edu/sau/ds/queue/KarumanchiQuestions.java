package edu.sau.ds.queue;

public interface KarumanchiQuestions<T extends Comparable<T>> {

	public final static String USE_QUEUE = "array";

	public default <P extends Comparable<P>> Queue<P> createEmptyQueue() {
		if (USE_QUEUE.equals("array")) {
			return new ArrayQueue<P>();
		} else {
			return new LinkedListQueue<P>();
		}
	}

	/**
	 * Q1 - Give an algorithm for reversing a queue Q. To access the queue, we are
	 * only allowed to use the methods of queue ADT.
	 */
	void reverseQueue(Queue<T> queue);

	/**
	 * Q2 - Implement a queue using two stacks
	 */
	Queue<T> implementQueueUsingTwoStacks();

}
