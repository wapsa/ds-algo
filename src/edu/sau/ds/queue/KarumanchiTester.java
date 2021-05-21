package edu.sau.ds.queue;

public class KarumanchiTester {

	KarumanchiQuestions<String> questions = new KarumanchiSolutions<>();

	public static void main(String[] args) {

		// reverseQueue();

		implementQueueUsingTwoStacks();

	}

	private static void implementQueueUsingTwoStacks() {
		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

		Queue<Integer> q = questions.implementQueueUsingTwoStacks();

		App.testQueue(q);

	}

	private static void reverseQueue() {
		KarumanchiQuestions<Integer> questions = new KarumanchiSolutions<>();

		Queue<Integer> q = questions.createEmptyQueue();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);

		System.out.println(q);

		questions.reverseQueue(q);

		System.out.println(q);
		System.out.println(q.peek());
	}

}
