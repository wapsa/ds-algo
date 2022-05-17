package edu.sau;

import java.util.stream.IntStream;

public class VisaTest {

	public static void main(String[] args) {
		System.out.println(getPairCountAboveThreshold(new int[] { 7, 20, 10, 25 }));

		System.out.println(getPairCountAboveThreshold(new int[] { 5, 25 }));
	}

	public static int getPairCountAboveThreshold(int[] marks) {
		long pairCount = IntStream.range(0, marks.length - 1).filter(i -> marks[i] + marks[i + 1] >= 30).count();
		return pairCount > 0 ? Math.toIntExact(pairCount) : -1;
	}

//	public static int findRepeatingFilter(SinglyLinkedList integerLinkedList) {
//		SinglyLinkedListNode slowPointer = integerLinkedList.head;
//		SinglyLinkedListNode fastPointer = integerLinkedList.head;
//
//		while (fastPointer != null && fastPointer.next != null) {
//			fastPointer = fastPointer.next.next;
//			slowPointer = slowPointer.next;
//
//			if (fastPointer == slowPointer) {
//				fastPointer = integerLinkedList.head;
//				while (fastPointer != slowPointer) {
//					slowPointer = slowPointer.next;
//					fastPointer = fastPointer.next;
//				}
//				return slowPointer;
//			}
//		}
//		return -1;
//	}
}
