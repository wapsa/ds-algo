package edu.sau.ds.queue;

import edu.sau.ds.stack.Stack;

public class App {

	public static void main(String[] args) {
		// testQueue(new BoundedArrayQueue<>(5));
		// testQueue(new ArrayQueue<>());
		// testQueue(new LinkedListQueue<>());

		// testDeque(new ArrayDeque<>());
	}

	public static void testDeque(Deque<Integer> q) {
		q.offer(10);
		q.offer(20);
		q.offer(30);
		q.offer(40);
		q.offer(50);
		System.out.println("original queue: " + q);
		System.out.println("peek:" + q.peek());
		System.out.println("size: " + q.size());
		System.out.println("--polling: " + q.poll());
		System.out.println("size: " + q.size());
		System.out.println("--offer 100--");
		q.offer(100);
		System.out.println("queue post offer:" + q);

		System.out.println("--polled twice--:" + q.poll() + "," + q.poll());
		q.offer(200);
		System.out.println("--offer 200--");
		System.out.println("queue post offer:" + q);
		System.out.println("peek:" + q.peek());

		System.out.println("--polled twice--:" + q.poll() + "," + q.poll());
		System.out.println("size: " + q.size());
		System.out.println("queue post poll:" + q);
		System.out.println("peek:" + q.peek());

		System.out.println("--offer 300 and 400--");
		q.offer(300);
		q.offer(400);
		System.out.println("size: " + q.size());
		System.out.println("queue post offer:" + q);
		System.out.println("isEmpty:" + q.isEmpty());

		System.out.println("--polled 4 times:" + q.poll() + "," + q.poll() + "," + q.poll() + "," + q.poll());
		System.out.println("queue post polled:" + q);
		System.out.println("size: " + q.size());

		System.out.println("isEmpty:" + q.isEmpty());
		System.out.println("peek:" + q.peek());

		q.offerLast(10);
		q.offerLast(20);
		System.out.println("queue post offer:" + q);
		System.out.println("peekFirst:" + q.peekFirst());
		System.out.println("--pollingFirst: " + q.pollFirst());
		System.out.println("queue post pollFirst:" + q);
		System.out.println("size: " + q.size());

		q.offerFirst(100);
		q.offerFirst(200);
		System.out.println("queue post offer:" + q);
		System.out.println("peekLast:" + q.peekLast());
		System.out.println("--pollingLast: " + q.pollLast());
		System.out.println("queue post pollLast:" + q);
		System.out.println("size: " + q.size());

	}

	public static void testQueue(Queue<Integer> q) {
		q.offer(10);
		q.offer(20);
		q.offer(30);
		q.offer(40);
		q.offer(50);
		System.out.println("original queue: " + q);
		System.out.println("peek:" + q.peek());
		System.out.println("size: " + q.size());
		System.out.println("--polling: " + q.poll());
		System.out.println("size: " + q.size());
		System.out.println("--offer 100--");
		q.offer(100);
		System.out.println("queue post offer:" + q);

		System.out.println("--polled twice--:" + q.poll() + "," + q.poll());
		q.offer(200);
		System.out.println("--offer 200--");
		System.out.println("queue post offer:" + q);
		System.out.println("peek:" + q.peek());

		System.out.println("--polled twice--:" + q.poll() + "," + q.poll());
		System.out.println("size: " + q.size());
		System.out.println("queue post poll:" + q);
		System.out.println("peek:" + q.peek());

		System.out.println("--offer 300 and 400--");
		q.offer(300);
		q.offer(400);
		System.out.println("size: " + q.size());
		System.out.println("queue post offer:" + q);
		System.out.println("isEmpty:" + q.isEmpty());

		System.out.println("--polled 4 times:" + q.poll() + "," + q.poll() + "," + q.poll() + "," + q.poll());
		System.out.println("queue post polled:" + q);
		System.out.println("size: " + q.size());

		System.out.println("isEmpty:" + q.isEmpty());
		System.out.println("peek:" + q.peek());

	}
}
