package edu.sau.linkedlist.revision;

import java.util.HashSet;

public class LinkedList<T extends Comparable<T>> implements List<T>, KarumanchiQuestions<T> {

	private Node<T> rootNode;
	private long sizeOfList;

	@Override
	public void insert(T data) {
		if (rootNode == null) {
			this.rootNode = new Node<>(data);
		} else {
			insertDataAtBeginning(data);
		}
		++this.sizeOfList;
	}

	// O(1)
	private void insertDataAtBeginning(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.setNextNode(rootNode);
		this.rootNode = newNode;
	}

	@Override
	public void insert(Node<T> node) {
		if (rootNode == null) {
			this.rootNode = node;
		} else {
			insertDataAtBeginning(node);
		}
		++this.sizeOfList;

	}

	private void insertDataAtBeginning(Node<T> node) {
		node.setNextNode(rootNode);
		this.rootNode = node;
	}

	@Override
	public void insertAtEnd(T data) {
		if (rootNode == null) {
			this.rootNode = new Node<>(data);
		} else {
			insertDataAtEnd(data, this.rootNode);
		}
		++this.sizeOfList;
	}

	// O(N)
	private void insertDataAtEnd(T data, Node<T> node) {
		if (node.getNextNode() != null) {
			insertDataAtEnd(data, node.getNextNode());
		} else {
			Node<T> newNode = new Node<>(data);
			node.setNextNode(newNode);
		}
	}

	@Override
	public void insertAtEnd(Node<T> node) {
		if (rootNode == null) {
			this.rootNode = node;
		} else {
			insertDataAtEnd(node, this.rootNode);
		}
		++this.sizeOfList;
	}

	private void insertDataAtEnd(Node<T> newNode, Node<T> node) {
		if (node.getNextNode() != null) {
			insertDataAtEnd(newNode, node.getNextNode());
		} else {
			node.setNextNode(newNode);
		}
	}

	@Override
	public void remove(T data) {

		if (this.rootNode == null) {
			return;
		}

		if (this.rootNode.getData().compareTo(data) == 0) {
			this.rootNode = this.rootNode.getNextNode();
		} else {
			remove(data, rootNode, rootNode.getNextNode());
		}

		--this.sizeOfList;

	}

	private void remove(T dataToRemove, Node<T> previousNode, Node<T> actualNode) {

		while (actualNode != null) {
			if (actualNode.getData().compareTo(dataToRemove) == 0) {
				previousNode.setNextNode(actualNode.getNextNode());
				actualNode = null;
				return;
			}

			previousNode = actualNode;
			actualNode = actualNode.getNextNode();
		}

	}

	@Override
	public void traverseList() {

		if (this.rootNode == null) {
			return;
		}

		Node<T> actualNode = this.rootNode;

		while (actualNode != null) {
			System.out.print(actualNode + " ---> ");
			if (actualNode.getNextNode() == null) {
				System.out.print("NULL");
			}

			actualNode = actualNode.getNextNode();
		}
		System.out.println();
	}

	@Override
	public void traverseForLoopingList() {

		if (this.rootNode == null) {
			return;
		}

		Node<T> currentNode = this.rootNode;

		Node<T> loopingNode = this.checkIfListHaveLoopUsingHashingTechnique();

		String nodeSeparator = "---";
		int printDistanceBetween2Nodes = nodeSeparator.length();

		int loopNodeOccurance = 0;

		int startNodeToloopingNodeDistance = 0;
		int loopingNodeToEndNodeDistance = 0;

		while (currentNode != null) {

			if (currentNode == loopingNode) {

				if (loopNodeOccurance >= 1) {
					System.out.println();

					String path = " ".repeat((startNodeToloopingNodeDistance * printDistanceBetween2Nodes)
							+ startNodeToloopingNodeDistance);
					System.out.print(path);
					System.out.print("|");

					path = "-".repeat(((loopingNodeToEndNodeDistance - 1) * printDistanceBetween2Nodes)
							+ (loopingNodeToEndNodeDistance - 2));
					System.out.print(path);
					System.out.print("|");
					break;
				}
				loopNodeOccurance++;
			}

			System.out.print(currentNode);
			if (loopNodeOccurance == 1) {
				if (currentNode.getNextNode() != loopingNode) {
					System.out.print(nodeSeparator);
				}
			} else {
				System.out.print(nodeSeparator);
			}

			currentNode = currentNode.getNextNode();

			if (loopNodeOccurance == 0) {
				startNodeToloopingNodeDistance++;
			} else {
				loopingNodeToEndNodeDistance++;
			}
		}
		System.out.println();
	}

	@Override
	public long size() {
		return this.sizeOfList;
	}

	@Override
	public Node<T> getRootNode() {
		return this.rootNode;
	}

	@Override
	public T findNthNodeFromEndOfListWithoutUsingSizeOfList(long n) {

		if (rootNode != null) {

			Node<T> pNthNode = rootNode;
			Node<T> pTemp = rootNode;

			for (int i = 0; i < n; i++, pTemp = pTemp.getNextNode()) {
				if (pTemp == null) {
					throw new IllegalArgumentException("n is longer than the size of the list.");
				}
				// pTemp = pTemp.getNextNode();
			}

			while (pTemp != null) {
				pTemp = pTemp.getNextNode();
				pNthNode = pNthNode.getNextNode();
			}

			return pNthNode.getData();
		}

		return null;
	}

	@Override
	public T findNthNodeFromEndOfListUsingSizeOfList(long n) {
		if (rootNode != null) {

			if (sizeOfList < n) {
				throw new IllegalArgumentException("n is longer than the size of the list.");
			}

			long idx = sizeOfList - n;

			Node<T> temp = rootNode;

			for (int i = 0; i < idx; i++) {
				temp = temp.getNextNode();
			}

			return temp.getData();
		}
		return null;
	}

	@Override
	public Node<T> checkIfListHaveLoopUsingHashingTechnique() {

		HashSet<Node<T>> temp = new HashSet<>();

		Node<T> tempNode = rootNode;

		while (tempNode != null) {
			if (temp.contains(tempNode)) {
				break;
			}
			temp.add(tempNode);
			tempNode = tempNode.getNextNode();
		}
		return tempNode;
	}

	@Override
	public Node<T> checkIfListHaveLoopUsingFloydCycleFindingAlgo() {

		Node<T> slowPointer = this.getRootNode();
		Node<T> fastPointer = this.getRootNode();

		boolean hasLoop = false;
		while (fastPointer != null && fastPointer.getNextNode() != null) {
			slowPointer = slowPointer.getNextNode();
			fastPointer = fastPointer.getNextNode().getNextNode();

			if (slowPointer == fastPointer) {
				hasLoop = true;
				break;
			}
		}

		if (hasLoop) {
			slowPointer = this.getRootNode();

			while (slowPointer != fastPointer) {
				slowPointer = slowPointer.getNextNode();
				fastPointer = fastPointer.getNextNode();
			}
			return fastPointer;
		}

		return null;
	}

	@Override
	public int findLengthOfTheLoop() {

		Node<T> slowPointer = this.getRootNode();
		Node<T> fastPointer = this.getRootNode();

		boolean hasLoop = false;
		while (fastPointer != null && fastPointer.getNextNode() != null) {
			slowPointer = slowPointer.getNextNode();
			fastPointer = fastPointer.getNextNode().getNextNode();

			if (slowPointer == fastPointer) {
				hasLoop = true;
				break;
			}
		}

		if (hasLoop) {
			slowPointer = slowPointer.getNextNode();
			int counter = 1;

			while (slowPointer != fastPointer) {
				slowPointer = slowPointer.getNextNode();
				counter++;
			}
			return counter;
		}

		return Integer.MIN_VALUE;
	}

	@Override
	public void insertNodeInSortedLinkedList(T data) {

		Node<T> head = this.getRootNode();

		Node<T> previous = null;

		while (head != null && head.getData().compareTo(data) <= 0) {
			previous = head;
			head = head.getNextNode();
		}

		Node<T> newNode = new Node<>(data);
		if (previous != null) {
			previous.setNextNode(newNode);
		} else {
			this.rootNode = newNode;
		}
		newNode.setNextNode(head);

	}

	@Override
	public void reverseListUsingLoop() {

		if (this.getRootNode() == null || this.getRootNode().getNextNode() == null) {
			return;
		}

		Node<T> current = this.getRootNode();
		Node<T> previous = null;

		while (current != null) {
			Node<T> next = current.getNextNode();
			current.setNextNode(previous);

			previous = current;
			current = next;
		}
		this.rootNode = previous;
	}

	@Override
	public void reverseListUsingRecursion() {

		Node<T> reversed = recursiveReverse(this.getRootNode());
		this.rootNode = reversed;
	}

	private Node<T> recursiveReverse(Node<T> current) {
		if (current.getNextNode() == null) {
			return current;
		}

		Node<T> nextNode = current.getNextNode();

		current.setNextNode(null);

		Node<T> remainingList = recursiveReverse(nextNode);

		nextNode.setNextNode(current);

		return remainingList;
	}

	@Override
	public Node<T> findIntersectingNodeOfTwoListsUsingBruteForce(List<T> inputList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<T> findIntersectingNodeOfTwoListsUsingStack(List<T> inputList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<T> findIntersectingNodeOfTwoListsUsingSearch(List<T> inputList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<T> findIntersectingNodeOfTwoListsUsingDistance(List<T> inputList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<T> findMiddleNodeOfLinkedList() {

		Node<T> slowPointer = this.getRootNode();
		Node<T> fastPointer = this.getRootNode();

		while (fastPointer != null && fastPointer.getNextNode() != null
				&& fastPointer.getNextNode().getNextNode() != null) {

			slowPointer = slowPointer.getNextNode();
			fastPointer = fastPointer.getNextNode().getNextNode();
		}
		return slowPointer;
	}

	@Override
	public void displayLinkedListFromEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkIfListIsEvenOrOdd() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<T> mergeTwoSortedListIntoThirdList(List<T> list1, List<T> list2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> mergeTwoSortedListIntoThirdListUsingRecursion(List<T> list1, List<T> list2) {
		this.rootNode = mergeRecursively(list1.getRootNode(), list2.getRootNode());
		return this;
	}

	private Node<T> mergeRecursively(Node<T> node1, Node<T> node2) {
		Node<T> mergedNodes = null;
		Node<T> temp = null;

		if (node1 == null) {
			return node2;
		}
		if (node2 == null) {
			return node1;
		}

		if (node1.getData().compareTo(node2.getData()) <= 0) {
			mergedNodes = new Node<>(node1.getData());
			temp = mergeRecursively(node1.getNextNode(), node2);
		} else {
			mergedNodes = new Node<>(node2.getData());
			temp = mergeRecursively(node1, node2.getNextNode());
		}

		mergedNodes.setNextNode(temp);
		return mergedNodes;
	}

	@Override
	public void reverseListInPairsUsingRecursion() {
		this.rootNode = reversePairs(this.getRootNode());
	}

	private Node<T> reversePairs(Node<T> current) {

		if (current == null || current.getNextNode() == null) {
			return current;
		}

		Node<T> next = current.getNextNode();
		Node<T> next2Next = next.getNextNode();
		next.setNextNode(current);

		Node<T> reversedPair = reversePairs(next2Next);

		current.setNextNode(reversedPair);

		return next;

	}

	// 1 2 3 4 5 6 7 8 9
	// 2 1 4 3 6 5 8 7 9

	// p=null, c=1, n=2 | 1>3, 2>1,
	// p=1, c=2, n=3 | 2>4, 3>2, 1>3
	@Override
	public void reverseListInPairsUsingIterativeApproach1() {
		Node<T> previous = null;
		Node<T> current = this.getRootNode();
		Node<T> next = current.getNextNode();

		this.rootNode = next;

		while (current != null && next != null) {

			current.setNextNode(next.getNextNode());
			next.setNextNode(current);

			if (previous != null) {
				previous.setNextNode(next);
			}

			previous = current;
			current = current.getNextNode();
			next = current.getNextNode();

		}

	}

	@Override
	public void reverseListInPairsUsingIterativeApproach2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void splitCircularListToTwoCircularLinkedList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkIfListIsPalindrome() {
		// TODO Auto-generated method stub

	}

	@Override
	public void reverseBlocksOfKNodes(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public Node<T> josephusCircleElimination(int m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> cloneListWithRandomPointer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteNodeFromLinkedList(Node<T> node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteNodeFromLinkedListWithoutIteration(Node<T> node) {
		// TODO Auto-generated method stub

	}

	@Override
	public Node<T> findLastModularNodeForConstant(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<T> findCeiledFractionalNode(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<T> findCeiledFractionalNodeUsingFastSlowPointer(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<T> findCeiledSqrtNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> addTwoLists(List<Integer> list1, List<Integer> list2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> listReorder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> printCommonElements(List<T> list1, List<T> list2) {
		// TODO Auto-generated method stub
		return null;
	}

}
