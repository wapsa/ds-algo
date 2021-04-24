package edu.sau.linkedlist;

import edu.sau.utils.Utils;

public class KarumanchiTester {

	public static void main(String[] args) {

		// findNthNodeFromEndOfListUsingSizeOfList(3);

		// findNthNodeFromEndOfListWithoutUsingSizeOfList(5);

		// doesListHaveLoopUsingHashingTechnique();

		// doesListHaveLoopUsingFloydsTechnique();

		// findLengthOfTheLoop();

		// insertNodeInSortedLinkedList();

		// reverseListUsingLoop();

		// reverseListUsingRecursion();

		// recursiveReverseAlternate();

		// findIntersectingNodeOfTwoListsUsingBruteForce();

		// findIntersectingNodeOfTwoListsUsingStack();

		// findIntersectingNodeOfTwoListsUsingDistance();

		// findMiddleNodeOfLinkedList();

		// displayLinkedListFromEnd();

		// checkIfListIsEvenOrOdd();

		// mergeTwoSortedListIntoThirdList();

		// mergeTwoSortedListIntoThirdListUsingRecursion();

		// reverseListInPairsUsingRecursion();

		// reverseListInPairsUsingIterativeApproach();

		// splitCircularListToTwoCircularLinkedList();

		// checkIfListIsPalindrome();

		// reverseBlocksOfKNodes();

		josephusCircleElimination();

		// cloneListWithRandomPointer();

		// deleteNodeFromLinkedList();

		// deleteNodeFromLinkedListWithoutIteration();

		// findLastModularNodeForConstant();

		// findCeiledFractionalNode();

		// findCeiledFractionalNodeUsingFastSlowPointer();

		// findCeiledSqrtNode();

		// addTwoLists();

		// listReorder();

		// printCommonElements();
	}

	private static void printCommonElements() {

		LinkedList<Integer> linkedList1 = new LinkedList<>();
		linkedList1.insert(1);
		linkedList1.insertAtEnd(2);
		linkedList1.insertAtEnd(3);
		linkedList1.insertAtEnd(4);
		linkedList1.insertAtEnd(5);

		linkedList1.traverseList();

		LinkedList<Integer> linkedList2 = new LinkedList<>();
		linkedList2.insertAtEnd(2);
		linkedList2.insertAtEnd(4);
		linkedList2.insertAtEnd(5);
		linkedList2.insertAtEnd(6);
		linkedList2.insertAtEnd(7);

		linkedList2.traverseList();

		List<Integer> linkedList3 = linkedList1.printCommonElements(linkedList1, linkedList2);

		System.out.println();
		linkedList3.traverseList();

		System.out.println();
	}

	private static void listReorder() {

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);
		linkedList.insertAtEnd(7);
		linkedList.insertAtEnd(8);
		linkedList.insertAtEnd(9);
		linkedList.insertAtEnd(10);
		linkedList.insertAtEnd(11);
		linkedList.insertAtEnd(12);
		linkedList.insertAtEnd(13);
		linkedList.insertAtEnd(14);
		linkedList.insertAtEnd(15);

		linkedList.traverseList();

		List<Integer> reorderedList = linkedList.listReorder();

		reorderedList.traverseList();
		System.out.println();
	}

	private static void addTwoLists() {

		LinkedList<Integer> linkedList1 = new LinkedList<>();
		linkedList1.insert(5);
		linkedList1.insertAtEnd(9);
		linkedList1.insertAtEnd(3);
		linkedList1.insertAtEnd(2);
		linkedList1.insertAtEnd(1);

		linkedList1.traverseList();

		LinkedList<Integer> linkedList2 = new LinkedList<>();
		linkedList2.insertAtEnd(9);
		linkedList2.insertAtEnd(9);
		// linkedList2.insertAtEnd(9);
		// linkedList2.insertAtEnd(9);
		// linkedList2.insertAtEnd(9);

		linkedList2.traverseList();

		List<Integer> linkedList3 = linkedList1.addTwoLists(linkedList1, linkedList2);

		System.out.println();
		linkedList3.traverseList();

		System.out.println();
	}

	private static void findCeiledSqrtNode() {

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);
		linkedList.insertAtEnd(7);
		linkedList.insertAtEnd(8);
		linkedList.insertAtEnd(9);
		linkedList.insertAtEnd(10);
		linkedList.insertAtEnd(11);
		linkedList.insertAtEnd(12);
		linkedList.insertAtEnd(13);
		linkedList.insertAtEnd(14);
		linkedList.insertAtEnd(15);
		linkedList.insertAtEnd(16);
		linkedList.insertAtEnd(17);

		linkedList.traverseList();

		Node<Integer> ceiledSquareRootNode = linkedList.findCeiledSqrtNode();

		System.out.println("ceiledSquareRootNode: " + ceiledSquareRootNode);

		System.out.println();
	}

	private static void findCeiledFractionalNodeUsingFastSlowPointer() {

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);
		linkedList.insertAtEnd(7);
		linkedList.insertAtEnd(8);
		linkedList.insertAtEnd(9);
		linkedList.insertAtEnd(10);
		linkedList.insertAtEnd(11);
		linkedList.insertAtEnd(12);
		linkedList.insertAtEnd(13);
		linkedList.insertAtEnd(14);

		linkedList.traverseList();

		Node<Integer> ceiledFractionalNode = linkedList.findCeiledFractionalNodeUsingFastSlowPointer(1);

		System.out.println("findCeiledFractionalNode: " + ceiledFractionalNode);

		System.out.println();
	}

	private static void findCeiledFractionalNode() {

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);
		linkedList.insertAtEnd(7);
		linkedList.insertAtEnd(8);
		linkedList.insertAtEnd(9);
		linkedList.insertAtEnd(10);
		linkedList.insertAtEnd(11);
		linkedList.insertAtEnd(12);
		linkedList.insertAtEnd(13);
		linkedList.insertAtEnd(14);

		linkedList.traverseList();

		Node<Integer> ceiledFractionalNode = linkedList.findCeiledFractionalNode(1);

		System.out.println("findCeiledFractionalNode: " + ceiledFractionalNode);

		System.out.println();
	}

	private static void findLastModularNodeForConstant() {

		Node<String> node1 = new Node<>("1");
		Node<String> node2 = new Node<>("2");
		Node<String> node3 = new Node<>("3");
		Node<String> node4 = new Node<>("4");
		Node<String> node5 = new Node<>("5");
		Node<String> node6 = new Node<>("6");
		Node<String> node7 = new Node<>("7");

		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.insert(node1);
		linkedList.insertAtEnd(node2);
		linkedList.insertAtEnd(node3);
		linkedList.insertAtEnd(node4);
		linkedList.insertAtEnd(node5);
		linkedList.insertAtEnd(node6);
		linkedList.insertAtEnd(node7);

		linkedList.traverseList();

		Node<String> lastModularNode = linkedList.findLastModularNodeForConstant(5);

		System.out.println("lastModularNode: " + lastModularNode);

		System.out.println();
	}

	private static void deleteNodeFromLinkedListWithoutIteration() {

		Node<String> node1 = new Node<>("1");
		Node<String> node2 = new Node<>("2");
		Node<String> node3 = new Node<>("3");
		Node<String> node4 = new Node<>("4");
		Node<String> node5 = new Node<>("5");
		Node<String> node6 = new Node<>("6");
		Node<String> node7 = new Node<>("7");

		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.insert(node1);
		linkedList.insertAtEnd(node2);
		linkedList.insertAtEnd(node3);
		linkedList.insertAtEnd(node4);
		linkedList.insertAtEnd(node5);
		linkedList.insertAtEnd(node6);
		linkedList.insertAtEnd(node7);

		linkedList.traverseList();

		linkedList.deleteNodeFromLinkedListWithoutIteration(node2);

		linkedList.traverseList();

		System.out.println();
	}

	private static void deleteNodeFromLinkedList() {

		Node<String> node1 = new Node<>("1");
		Node<String> node2 = new Node<>("2");
		Node<String> node3 = new Node<>("3");
		Node<String> node4 = new Node<>("4");
		Node<String> node5 = new Node<>("5");
		Node<String> node6 = new Node<>("6");
		Node<String> node7 = new Node<>("7");

		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.insert(node1);
		linkedList.insertAtEnd(node2);
		linkedList.insertAtEnd(node3);
		linkedList.insertAtEnd(node4);
		linkedList.insertAtEnd(node5);
		linkedList.insertAtEnd(node6);
		linkedList.insertAtEnd(node7);

		linkedList.traverseList();

		linkedList.deleteNodeFromLinkedList(node7);

		linkedList.traverseList();

		System.out.println();
	}

	private static void cloneListWithRandomPointer() {

		Node<String> node1 = new Node<>("1");
		Node<String> node2 = new Node<>("2");
		Node<String> node3 = new Node<>("3");
		Node<String> node4 = new Node<>("4");
		Node<String> node5 = new Node<>("5");
		Node<String> node6 = new Node<>("6");
		Node<String> node7 = new Node<>("7");
		node1.setRandomNode(node6);
		node2.setRandomNode(node5);
		node3.setRandomNode(node2);
		node4.setRandomNode(node3);
		node5.setRandomNode(node5);
		node6.setRandomNode(node4);
		node7.setRandomNode(node1);

		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.insert(node1);
		linkedList.insertAtEnd(node2);
		linkedList.insertAtEnd(node3);
		linkedList.insertAtEnd(node4);
		linkedList.insertAtEnd(node5);
		linkedList.insertAtEnd(node6);
		linkedList.insertAtEnd(node7);

		linkedList.traverseList();

		List<String> clonedList = linkedList.cloneListWithRandomPointer();

		System.out.println("clonedList: " + clonedList);
		System.out.println(linkedList == clonedList);
		System.out.println(linkedList.getRootNode() == clonedList.getRootNode());

		clonedList.traverseList();

		System.out.println();
	}

	private static void josephusCircleElimination() {

		Node<String> nodeA = new Node<>("1");
		Node<String> nodeH = new Node<>("7");

		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.insert(nodeA);
		linkedList.insertAtEnd("2");
		linkedList.insertAtEnd("3");
		linkedList.insertAtEnd("4");
		linkedList.insertAtEnd("5");
		linkedList.insertAtEnd("6");
		linkedList.insertAtEnd(nodeH);
		// linkedList.insertAtEnd(nodeH);

		nodeH.setNextNode(nodeA);

		linkedList.traverseForLoopingList();

		Node<String> chosenOne = linkedList.josephusCircleElimination(3);
		Node<String> chosenOne1 = linkedList.josephusCircleElimination1(3);
		Node<String> chosenOne2 = linkedList.josephusCircleElimination2(3);

		System.out.println("ChosenOne: " + chosenOne);
		System.out.println("ChosenOne: " + chosenOne1);
		System.out.println("ChosenOne: " + chosenOne2);

		System.out.println();
	}

	private static void reverseBlocksOfKNodes() {

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);
		linkedList.insertAtEnd(7);
		linkedList.insertAtEnd(8);

		linkedList.traverseList();

		linkedList.reverseBlocksOfKNodes(9);

		linkedList.traverseList();

		System.out.println();
	}

	private static void checkIfListIsPalindrome() {

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		// linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(1);

		linkedList.traverseList();

		linkedList.checkIfListIsPalindrome();

		System.out.println();
	}

	private static void splitCircularListToTwoCircularLinkedList() {

		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node8 = new Node<>(8);
		Node<Integer> node9 = new Node<>(9);

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(node1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);
		linkedList.insertAtEnd(7);

		linkedList.insertAtEnd(node8);
		node8.setNextNode(node1);

		// linkedList.insertAtEnd(node9);
		// node9.setNextNode(node1);

		linkedList.traverseForLoopingList();

		linkedList.splitCircularListToTwoCircularLinkedList();

		System.out.println();
	}

	private static void reverseListInPairsUsingIterativeApproach() {

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);
		linkedList.insertAtEnd(7);
		linkedList.insertAtEnd(8);
		linkedList.insertAtEnd(9);

		linkedList.traverseList();

		linkedList.reverseListInPairsUsingIterativeApproach1();

		linkedList.traverseList();
		System.out.println();
	}

	private static void reverseListInPairsUsingRecursion() {

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		// linkedList.insertAtEnd(6);

		linkedList.traverseList();

		linkedList.reverseListInPairsUsingRecursion();

		linkedList.traverseList();
		System.out.println();
	}

	private static void mergeTwoSortedListIntoThirdListUsingRecursion() {

		LinkedList<Integer> listA = new LinkedList<>();
		listA.insert(1);
		listA.insertAtEnd(3);
		listA.insertAtEnd(5);
		listA.insertAtEnd(7);
		listA.insertAtEnd(7);
		listA.insertAtEnd(7);
		listA.insertAtEnd(9);

		listA.traverseList();

		LinkedList<Integer> listB = new LinkedList<>();
		listB.insert(2);
		listB.insertAtEnd(4);
		listB.insertAtEnd(6);
		listB.insertAtEnd(8);
		listB.insertAtEnd(10);
		listB.insertAtEnd(11);
		listB.insertAtEnd(12);
		listB.insertAtEnd(13);
		listB.insertAtEnd(14);

		listB.traverseList();

		List<Integer> listC = listA.mergeTwoSortedListIntoThirdListUsingRecursion(listA, listB);

		listC.traverseList();

		System.out.println();
	}

	private static void mergeTwoSortedListIntoThirdList() {

		LinkedList<Integer> listA = new LinkedList<>();
		listA.insert(1);
		listA.insertAtEnd(3);
		listA.insertAtEnd(5);
		listA.insertAtEnd(7);
		listA.insertAtEnd(7);
		listA.insertAtEnd(7);
		listA.insertAtEnd(9);

		listA.traverseList();

		LinkedList<Integer> listB = new LinkedList<>();
		listB.insert(2);
		listB.insertAtEnd(4);
		listB.insertAtEnd(6);
		listB.insertAtEnd(8);
		listB.insertAtEnd(10);
		listB.insertAtEnd(11);
		listB.insertAtEnd(12);
		listB.insertAtEnd(13);
		listB.insertAtEnd(14);

		listB.traverseList();

		List<Integer> listC = listA.mergeTwoSortedListIntoThirdList(listA, listB);

		listC.traverseList();

		System.out.println();
	}

	private static void checkIfListIsEvenOrOdd() {

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);
		// linkedList.insertAtEnd(7);

		linkedList.traverseList();

		linkedList.checkIfListIsEvenOrOdd();

		System.out.println();
	}

	private static void displayLinkedListFromEnd() {

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);

		linkedList.traverseList();

		linkedList.displayLinkedListFromEnd();

		System.out.println();
	}

	private static void findMiddleNodeOfLinkedList() {

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);
		// linkedList.insertAtEnd(7);

		linkedList.traverseList();

		Node<Integer> middleNode = linkedList.findMiddleNodeOfLinkedList();

		System.out.println("middleNode: " + middleNode);
		System.out.println();
	}

	private static void findIntersectingNodeOfTwoListsUsingDistance() {
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node4 = new Node<>(4);
		Node<Integer> node5 = new Node<>(5);
		Node<Integer> node6 = new Node<>(6);

		LinkedList<Integer> linkedList1 = new LinkedList<>();
		linkedList1.insert(node6);
		linkedList1.insert(node5);
		linkedList1.insert(node4);
		linkedList1.insert(node3);
		linkedList1.insert(node2);
		linkedList1.insert(node1);

		linkedList1.traverseList();

		LinkedList<Integer> linkedList2 = new LinkedList<>();
		linkedList2.insert(node6);
		linkedList2.insert(node5);
		linkedList2.insert(node4);
		linkedList2.insert(node3);
		linkedList2.insert(node2);
		linkedList2.insert(1);
		linkedList2.insert(0);

		linkedList2.traverseList();

		Node<Integer> intersectingNode = linkedList1.findIntersectingNodeOfTwoListsUsingDistance(linkedList2);
		System.out.println("Intersecting node found at: " + intersectingNode);
		System.out.println();
	}

	private static void findIntersectingNodeOfTwoListsUsingStack() {
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node4 = new Node<>(4);
		Node<Integer> node5 = new Node<>(5);
		Node<Integer> node6 = new Node<>(6);

		LinkedList<Integer> linkedList1 = new LinkedList<>();
		linkedList1.insert(node1);
		linkedList1.insertAtEnd(node2);
		linkedList1.insertAtEnd(node3);
		linkedList1.insertAtEnd(node4);
		linkedList1.insertAtEnd(node5);
		linkedList1.insertAtEnd(node6);

		linkedList1.traverseList();

		LinkedList<Integer> linkedList2 = new LinkedList<>();
		linkedList2.insert(10);
		linkedList2.insertAtEnd(9);
		linkedList2.insertAtEnd(8);
		linkedList2.insertAtEnd(7);
		linkedList2.insertAtEnd(node6);

		linkedList2.traverseList();

		Node<Integer> intersectingNode = linkedList1.findIntersectingNodeOfTwoListsUsingStack(linkedList2);
		System.out.println("Intersecting node found at: " + intersectingNode);
		System.out.println();
	}

	private static void findIntersectingNodeOfTwoListsUsingBruteForce() {
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node4 = new Node<>(4);
		Node<Integer> node5 = new Node<>(5);
		Node<Integer> node6 = new Node<>(6);

		LinkedList<Integer> linkedList1 = new LinkedList<>();
		linkedList1.insert(node1);
		linkedList1.insertAtEnd(node2);
		linkedList1.insertAtEnd(node3);
		linkedList1.insertAtEnd(node4);
		linkedList1.insertAtEnd(node5);
		linkedList1.insertAtEnd(node6);

		linkedList1.traverseList();

		LinkedList<Integer> linkedList2 = new LinkedList<>();
		linkedList2.insert(10);
		linkedList2.insertAtEnd(9);
		linkedList2.insertAtEnd(8);
		linkedList2.insertAtEnd(7);
		linkedList2.insertAtEnd(node3);

		linkedList2.traverseList();

		Node<Integer> intersectingNode = linkedList1.findIntersectingNodeOfTwoListsUsingBruteForce(linkedList2);
		System.out.println("Intersecting node found at: " + intersectingNode);
		System.out.println();
	}

	private static void recursiveReverseAlternate() {

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);

		linkedList.traverseList();

		linkedList.reverseListUsingRecursionAlternate();

		linkedList.traverseList();
		System.out.println();
	}

	private static void reverseListUsingRecursion() {

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);

		linkedList.traverseList();

		linkedList.reverseListUsingRecursion();

		linkedList.traverseList();
		System.out.println();
	}

	private static void reverseListUsingLoop() {

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);

		linkedList.traverseList();

		linkedList.reverseListUsingLoop();

		linkedList.traverseList();
		System.out.println();
	}

	private static void insertNodeInSortedLinkedList() {

		int data = 100;

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(6);
		linkedList.insertAtEnd(7);
		linkedList.insertAtEnd(8);

		linkedList.traverseForLoopingList();

		linkedList.insertNodeInSortedLinkedList(data);

		linkedList.traverseForLoopingList();
		System.out.println();
	}

	private static void findLengthOfTheLoop() {
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node4 = new Node<>(4);
		Node<Integer> node6 = new Node<>(6);

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(node3);
		linkedList.insertAtEnd(node4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(node6);

		// looping from 6 back to...
		node6.setNextNode(node3);

		linkedList.traverseForLoopingList();

		int loopLength = linkedList.findLengthOfTheLoop();
		System.out.println("Length of the loop: " + loopLength);
		System.out.println();
	}

	private static void doesListHaveLoopUsingFloydsTechnique() {
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node4 = new Node<>(4);
		Node<Integer> node5 = new Node<>(5);
		Node<Integer> node6 = new Node<>(6);

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(node1);
		linkedList.insertAtEnd(node2);
		linkedList.insertAtEnd(node3);
		linkedList.insertAtEnd(node4);
		linkedList.insertAtEnd(node5);
		linkedList.insertAtEnd(node6);

		// looping from 6 back to 4.
		node6.setNextNode(node2);

		// node6.setNextNode(node3);

		linkedList.traverseForLoopingList();

		Node<Integer> loopingNode = linkedList.checkIfListHaveLoopUsingFloydCycleFindingAlgo();
		System.out.println("Loop found at node: " + loopingNode);
		System.out.println();
	}

	private static void doesListHaveLoopUsingHashingTechnique() {
		Node<Integer> node4 = new Node<>(4);
		Node<Integer> node6 = new Node<>(6);

		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(node4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(node6);

		// looping from 6 back to 4.
		node6.setNextNode(node4);

		linkedList.traverseForLoopingList();

		Node<Integer> loopingNode = linkedList.checkIfListHaveLoopUsingHashingTechnique();
		System.out.println("Loop found at node: " + loopingNode);
		System.out.println();
	}

	private static void findNthNodeFromEndOfListUsingSizeOfList(long n) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insert(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.traverseList();
		System.out.println(Utils.ordinalSuffixOf(n) + " element from end of list is: "
				+ linkedList.findNthNodeFromEndOfListUsingSizeOfList(n));
		System.out.println();
	}

	private static void findNthNodeFromEndOfListWithoutUsingSizeOfList(long n) {
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.insert("a");
		linkedList.insertAtEnd("b");
		linkedList.insertAtEnd("c");
		linkedList.insertAtEnd("d");
		linkedList.insertAtEnd("e");
		linkedList.insertAtEnd("f");
		linkedList.insertAtEnd("g");
		linkedList.insertAtEnd("h");
		linkedList.insertAtEnd("i");
		linkedList.insertAtEnd("j");
		linkedList.traverseList();
		System.out.println(Utils.ordinalSuffixOf(n) + " element from end of list is: "
				+ linkedList.findNthNodeFromEndOfListWithoutUsingSizeOfList(n));
		System.out.println();
	}

}
