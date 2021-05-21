package edu.sau.ds.linkedlist;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LinkedList<T extends Comparable<T>> implements List<T>, KarumanchiQuestions<T> {

	private Node<T> root;
	private int size;

	static class Node<T extends Comparable<T>> {

		private T data;
		private Node<T> next;
		private Node<T> random;

		public Node(T data) {
			super();
			this.data = data;
		}

		public void setRandom(Node<T> random) {
			this.random = random;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return data.toString();
		}

	}

	@Override
	public void insert(T data) {
		insert(new Node<>(data));
	}

	@Override
	public void insert(Node<T> node) {
		if (root == null) {
			root = node;
		} else {
			node.next = root;
			root = node;
		}
		++size;
	}

	@Override
	public void insertAtEnd(T data) {
		insertAtEnd(new Node<>(data));
	}

	@Override
	public void insertAtEnd(Node<T> node) {
		if (root == null) {
			root = node;
		} else {
			insertDataAtEnd(node, root);
		}
		++size;
	}

	private void insertDataAtEnd(Node<T> newNode, Node<T> node) {
		if (node.next == null) {
			node.next = newNode;
		} else {
			insertDataAtEnd(newNode, node.next);
		}
	}

	@Override
	public void remove(T data) {
		if (root == null)
			return;
		if (root.data.compareTo(data) == 0) {
			root = root.next;
			return;
		}
		boolean isRemoved = remove(root, data);
		if (isRemoved)
			size--;
	}

	private boolean remove(Node<T> current, T data) {
		if (current == null)
			return false;
		Node<T> next = current.next;
		if (next != null && next.data.compareTo(data) == 0) {
			current.next = next.next;
			return true;
		}
		return remove(next, data);
	}

	@Override
	public void traverseList() {

		if (root == null) {
			return;
		}

		Node<T> actualNode = root;

		while (actualNode != null) {
			System.out.print(actualNode + " ---> ");
			if (actualNode.next == null) {
				System.out.print("NULL");
			}

			actualNode = actualNode.next;
		}
		System.out.println();
	}

	@Override
	public void traverseForLoopingList() {

		if (root == null) {
			return;
		}

		Node<T> currentNode = root;

		Node<T> loopingNode = checkIfListHaveLoopUsingHashingTechnique();

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
				if (currentNode.next != loopingNode) {
					System.out.print(nodeSeparator);
				}
			} else {
				System.out.print(nodeSeparator);
			}

			currentNode = currentNode.next;

			if (loopNodeOccurance == 0) {
				startNodeToloopingNodeDistance++;
			} else {
				loopingNodeToEndNodeDistance++;
			}
		}
		System.out.println();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Node<T> getRootNode() {
		return root;
	}

	@Override
	public T findNthNodeFromEndOfListWithoutUsingSizeOfList(int n) {
		Node<T> p1 = root;
		Node<T> p2 = root;

		while (n > 0) {
			p1 = p1.next;
			n--;
		}
		while (p1 != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		return p2 != null ? p2.data : null;
	}

	@Override
	public T findNthNodeFromEndOfListUsingSizeOfList(int n) {
		if (size < n) {
			throw new IllegalArgumentException("n is longer than the size of the list.");
		}

		Node<T> p1 = root;
		for (int i = size - n; i > 0; i--) {
			p1 = p1.next;
		}
		return p1 != null ? p1.data : null;
	}

	@Override
	public Node<T> checkIfListHaveLoopUsingHashingTechnique() {

		HashSet<Node<T>> temp = new HashSet<>();

		Node<T> tempNode = root;

		while (tempNode != null) {
			if (temp.contains(tempNode)) {
				break;
			}
			temp.add(tempNode);
			tempNode = tempNode.next;
		}
		return tempNode;
	}

	@Override
	public Node<T> checkIfListHaveLoopUsingFloydCycleFindingAlgo() {
		Node<T> slowPointer = root;
		Node<T> fastPointer = root;

		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;

			if (slowPointer == fastPointer) {
				slowPointer = root;
				while (slowPointer != fastPointer) {
					slowPointer = slowPointer.next;
					fastPointer = fastPointer.next;
				}
				return fastPointer;
			}
		}
		return null;
	}

	@Override
	public int findLengthOfTheLoop() {

		Node<T> slowPointer = root;
		Node<T> fastPointer = root;

		boolean hasLoop = false;

		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;

			if (slowPointer == fastPointer) {
				hasLoop = true;
				break;
			}
		}

		if (hasLoop) {
			fastPointer = fastPointer.next;
			int counter = 1;
			while (slowPointer != fastPointer) {
				counter++;
				fastPointer = fastPointer.next;
			}
			return counter;
		}

		return Integer.MIN_VALUE;
	}

	@Override
	public void insertNodeInSortedLinkedList(T data) {
		if (root == null || root.data.compareTo(data) >= 0) {
			insert(data);
			return;
		}

		Node<T> current = root;
		Node<T> previousNode = null;
		while (current != null && current.data.compareTo(data) <= 0) {
			previousNode = current;
			current = current.next;
		}

		Node<T> newNode = new Node<>(data);
		previousNode.next = newNode;
		newNode.next = current;
	}

	// 1,2,3,4,5
	// 1>null
	// 2>1
	// 3>2
	// 4>3
	// 5>4
	@Override
	public void reverseListUsingLoop() {

		Node<T> previous = null;
		Node<T> current = root;

		while (current != null) {
			Node<T> next = current.next;
			current.next = previous;

			previous = current;
			current = next;
		}
		root = previous;
	}

	@Override
	public void reverseListUsingRecursion() {

		if (root == null || root.next == null) {
			return;
		}
		Node<T> reversedRootNode = recursiveReverse(root);

		root = reversedRootNode;
	}

//	Original Input List:	1	2	3	4	5	6
//
//	recursiveReverse(1-->2-->3-->4-->5-->6)		Keep '1' and pass remaining list to recursive method.
//	recursiveReverse(2-->3-->4-->5-->6) 		Keep '2' and pass remaining list to recursive method.
//	recursiveReverse(3-->4-->5-->6) 			Keep '3' and pass remaining list to recursive method.
//	recursiveReverse(4-->5-->6) 				Keep '4' and pass remaining list to recursive method.
//	recursiveReverse(5-->6) 					Keep '5' and pass remaining list to recursive method.
//	recursiveReverse(6) 						Base condition reached, next is null so return as is.
//	6-->5 										Set currentNode in next element and start preparing reverse chain.
//  6-->5-->4
//	6-->5-->4-->3
//	6-->5-->4-->3-->2
//	6-->5-->4-->3-->2-->1
//
//	 ---> ---> ---> ---> ---> ---> ---> ---> ---> ---> ---> ---> ---> ---> ---> ---> ---> ---> ----> 
//																									|
//							Node<T> nextNode = current.nextNode;									|
//							current.next = null);													v
//	 _____		   _____		 _____		    _____		   _____		  _____					|
//	|     |		  |     |	    |     |		   |     |		  |     |		 |     |				|
//	|  1  | --->  |  2  |  ---> |  3  |	 --->  |  4  |  --->  |  5  |  --->  |  6  |  ---> NULL		v
//	|_____|		  |_____|	    |_____|		   |_____|		  |_____|		 |_____|				|
//	|			 /|			   /|			  /|		     /|				/|						|
//	|           / | 		  /	|			 / |  			/ |			   / |						v
//	|		   /  |			 /	|			/  |		   /  |		      /	 |						|
//	|         /   |         /   |          /   |          /   |          /   |						|
//	cur, next	  cur, next		cur, next	   cur, next	  cur, next	 	cur						v
//																									|
//							nextNode.next = current);												|
//																									v
//	<--- <--- <--- <--- <--- <--- <--- <--- <--- <--- <--- <--- <--- <--- <--- <--- <--- <--- <---- 
	// Divide and Conquer way of solving solution.
	private Node<T> recursiveReverse(Node<T> currentNode) {

		// reverse of null is null
		if (currentNode == null) {
			return null;
		}
		// reverse of single element is the element itself.
		// helps in U turn
		if (currentNode.next == null) {
			return currentNode;
		}

		// divide the list into two parts, currentNode and restOfList from next
		// element.
		Node<T> restOfList = currentNode.next;
		currentNode.next = null;

		// call recursiveReverse method for the restOfList and in return keep the
		// reference to reversed list.
		Node<T> reversedList = recursiveReverse(restOfList);

		// conquer part where we re-compose the solution.
		// link the restOfList to the currentNode in the call stack.
		restOfList.next = currentNode;

		return reversedList;
	}

	@Override
	public void reverseListUsingRecursionAlternate() {
		recursiveReverseAlternate(getRootNode());
	}

	private void recursiveReverseAlternate(Node<T> current) {
		if (current == null || current.next == null) {
			root = current;
			return;
		}

		recursiveReverseAlternate(current.next);

		current.next.next = current;
		current.next = null;
	}

	@Override
	public Node<T> findIntersectingNodeOfTwoListsUsingBruteForce(List<T> inputList) {

		Node<T> startA = this.root;

		outerLoop: while (startA != null) {
			Node<T> startB = inputList.getRootNode();

			while (startB != null) {
				if (startA == startB) {
					break outerLoop;
				}
				startB = startB.next;
			}
			startA = startA.next;
		}
		return startA;
	}

	@Override
	public Node<T> findIntersectingNodeOfTwoListsUsingStack(List<T> inputList) {
		Deque<Node<T>> stack1 = new java.util.LinkedList<>();
		Deque<Node<T>> stack2 = new java.util.LinkedList<>();

		Node<T> startA = getRootNode();
		while (startA != null) {
			stack1.push(startA);
			startA = startA.next;
		}
		Node<T> startB = inputList.getRootNode();
		while (startB != null) {
			stack2.push(startB);
			startB = startB.next;
		}

		Node<T> temp = null;

		while (stack1.peek() == stack2.peek() && !stack1.isEmpty() && !stack2.isEmpty()) {
			temp = stack1.pop();
			stack2.pop();
		}
		return temp;
	}

	@Override
	public Node<T> findIntersectingNodeOfTwoListsUsingSearch(List<T> inputList) {
		// TODO:
		return null;
	}

	@Override
	public Node<T> findIntersectingNodeOfTwoListsUsingDistance(List<T> inputList) {
		int L1 = size();
		int L2 = inputList.size();

		int difference = Math.abs((L1 - L2));

		List<T> longerList = this;
		List<T> shorterList = inputList;
		if (L2 > L1) {
			longerList = inputList;
			shorterList = this;
		}

		Node<T> shorterListStartNode = shorterList.getRootNode();
		Node<T> longerListStartNode = longerList.getRootNode();

		while (difference > 0) {
			longerListStartNode = longerListStartNode.next;
			difference--;
		}

		while (longerListStartNode != shorterListStartNode) {
			shorterListStartNode = shorterListStartNode.next;
			longerListStartNode = longerListStartNode.next;
		}

		return longerListStartNode;
	}

	@Override
	public Node<T> findMiddleNodeOfLinkedList() {

		Node<T> slowPointer = getRootNode();
		Node<T> fastPointer = getRootNode();

		while (fastPointer != null && fastPointer.next != null && fastPointer.next.next != null) {

			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		return slowPointer;
	}

	@Override
	public void displayLinkedListFromEnd() {
		printInReverse(getRootNode());
	}

	private void printInReverse(Node<T> current) {

		if (current == null) {
			return;
		}

		printInReverse(current.next);

		System.out.print(current + " <--- ");
	}

	// check out find middle element code, same logic is used here.
	@Override
	public void checkIfListIsEvenOrOdd() {
		Node<T> temp = getRootNode();

		while (temp != null && temp.next != null) {
			temp = temp.next.next;
		}

		if (temp == null) {
			System.out.println("EVEN");
		} else {
			System.out.println("ODD");
		}
	}

	@Override
	public List<T> mergeTwoSortedListIntoThirdList(List<T> listA, List<T> listB) {

		List<T> listC = new LinkedList<>();

		Node<T> nodeA = listA.getRootNode();
		Node<T> nodeB = listB.getRootNode();

		while (nodeA != null || nodeB != null) {
			if (nodeA == null) {
				listC.insertAtEnd(new Node<T>(nodeB.data));
				nodeB = nodeB.next;
			} else if (nodeB == null) {
				listC.insertAtEnd(new Node<T>(nodeA.data));
				nodeA = nodeA.next;
			} else if (nodeB == null || nodeA.data.compareTo(nodeB.data) <= 0) {
				listC.insertAtEnd(new Node<T>(nodeA.data));
				nodeA = nodeA.next;
			} else {
				listC.insertAtEnd(new Node<T>(nodeB.data));
				nodeB = nodeB.next;
			}
		}
		return listC;
	}

	@Override
	public List<T> mergeTwoSortedListIntoThirdListUsingRecursion(List<T> listA, List<T> listB) {
		List<T> mergedList = new LinkedList<>();

		// mergeListRecursive1(listA.getRootNode(), listB.getRootNode(), mergedList);

		Node<T> node = mergeListRecursive2(listA.getRootNode(), listB.getRootNode());
		mergedList.insert(node);

		return mergedList;
	}

	private void mergeListRecursive1(Node<T> nodeA, Node<T> nodeB, List<T> mergedList) {

		if (nodeA == null && nodeB == null) {
			return;
		}

		if (nodeA == null) {
			mergedList.insertAtEnd(new Node<T>(nodeB.data));
			mergeListRecursive1(nodeA, nodeB.next, mergedList);
		} else if (nodeB == null || nodeA.data.compareTo(nodeB.data) <= 0) {
			mergedList.insertAtEnd(new Node<T>(nodeA.data));
			mergeListRecursive1(nodeA.next, nodeB, mergedList);
		} else {
			mergedList.insertAtEnd(new Node<T>(nodeB.data));
			mergeListRecursive1(nodeA, nodeB.next, mergedList);
		}
	}

	private Node<T> mergeListRecursive2(Node<T> node1, Node<T> node2) {

		Node<T> temp = null;
		Node<T> mergedNodes = null;

		if (node1 == null) {
			return node2;
		}
		if (node2 == null) {
			return node1;
		}

		if (node1.data.compareTo(node2.data) <= 0) {
			temp = new Node<>(node1.data);
			mergedNodes = mergeListRecursive3(node1.next, node2);
		} else {
			temp = new Node<>(node2.data);
			mergedNodes = mergeListRecursive3(node1, node2.next);
		}

		temp.next = mergedNodes;
		return temp;

	}

	private Node<T> mergeListRecursive3(Node<T> nodeA, Node<T> nodeB) {
		Node<T> result = null;
		if (nodeA == null) {
			return nodeB;
		}
		if (nodeB == null) {
			return nodeA;
		}

		if (nodeA.data.compareTo(nodeB.data) <= 0) {
			result = new Node<T>(nodeA.data);
			result.next = mergeListRecursive2(nodeA.next, nodeB);
		} else {
			result = new Node<T>(nodeB.data);
			result.next = mergeListRecursive2(nodeA, nodeB.next);
		}
		return result;
	}

	@Override
	public void reverseListInPairsUsingRecursion() {
		root = reverseListInPairs(root);
		// rootNode = reverseListInPairs2(rootNode);
	}

	private Node<T> reverseListInPairs(Node<T> currentNode) {

		if (currentNode == null || currentNode.next == null) {
			return currentNode;
		}

		Node<T> nextNode = currentNode.next;
		Node<T> nextToNextNode = currentNode.next.next;
		nextNode.next = currentNode;
		currentNode.next = reverseListInPairs(nextToNextNode);

		return nextNode;
	}

	// 1 2 3 4 5 6 7
	// 1>3, 2>1 | prev=1, curr=3, next=4
	// 3>5, 4>3, 1>4 | prev=3, curr=5, next=6
	// 5>7, 6>5, 3>6 | prev=5, curr=7, next=null
	// result: 2>1>4>3>6>5>7
	@Override
	public void reverseListInPairsUsingIterativeApproach1() {
		Node<T> previous = null;
		Node<T> current = getRootNode();
		Node<T> next = current.next;

		root = next;

		while (current != null && next != null) {

			current.next = next.next;
			next.next = current;
			if (previous != null) {
				previous.next = next;
			}

			previous = current;
			current = current.next;
			next = current != null ? current.next : null;
		}

	}

	@Override
	public void reverseListInPairsUsingIterativeApproach2() {
		Node<T> temp1 = null;
		Node<T> temp2 = null;
		Node<T> current = getRootNode();

		while (current != null && current.next != null) {
			if (temp1 != null) {
				temp1.next.next = current.next;
			}
			temp1 = current.next;
			current.next = current.next.next;
			temp1.next = current;

			if (temp2 == null) {
				temp2 = temp1;
			}
			current = current.next;
		}
		root = temp2;
	}

	@Override
	public void splitCircularListToTwoCircularLinkedList() {
		if (getRootNode() == null) {
			return;
		}
		Node<T> slowPointer = getRootNode();
		Node<T> fastPointer = getRootNode();

		// below while loop will get the slowPointer at middle of list. Check question
		// 24-27
		while (fastPointer.next != getRootNode() && fastPointer.next.next != getRootNode()) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		// For even number of nodes in list we have to move fast pointer 1x ahead to
		// reach last node.
		if (fastPointer.next.next == getRootNode()) {
			fastPointer = fastPointer.next;
		}

		// keeping hold of middle next for list 2
		Node<T> middleNext = slowPointer.next;

		// from middle to start
		slowPointer.next = getRootNode();

		// from end to middle next
		fastPointer.next = middleNext;

		List<T> list1 = new LinkedList<>();
		list1.insert(getRootNode());
		List<T> list2 = new LinkedList<>();
		list2.insert(middleNext);

		list1.traverseForLoopingList();
		list2.traverseForLoopingList();

	}

	@Override
	public void checkIfListIsPalindrome() {

		Node<T> slowPointer = getRootNode();
		Node<T> fastPointer = getRootNode();

		while (fastPointer != null && fastPointer.next != null && fastPointer.next.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		Node<T> secondPart = slowPointer.next;
		// slowPointer.next = null);
		Node<T> reverseOfSecondPartOfList = recursiveReverse(secondPart);
		Node<T> firstPart = getRootNode();

		boolean isPalindrome = false;
		while (reverseOfSecondPartOfList != null) {
			if (reverseOfSecondPartOfList.data.compareTo(firstPart.data) != 0) {
				isPalindrome = false;
				break;
			}
			isPalindrome = true;
			firstPart = firstPart.next;
			reverseOfSecondPartOfList = reverseOfSecondPartOfList.next;
		}

		System.out.println("isPalindrome: " + isPalindrome);
	}

	@Override
	public void reverseBlocksOfKNodes(int k) {

		if (k <= 1 || k > size()) {
			return;
		}
		Node<T> head = getRootNode();
		long totalBlocks = size() / k;
		int blockNodeCounter = 1;
		int blockCounter = 1;
		Node<T> previousBlockStart = null;
		Node<T> currentBlockStart = head;
		Node<T> reversedNode = null;

		while (head != null && blockCounter <= totalBlocks) {

			Node<T> temp = head;
			head = head.next;

			temp.next = reversedNode;
			reversedNode = temp;

			if (blockNodeCounter == k) {
				if (previousBlockStart == null) {
					root = reversedNode;
				} else {
					previousBlockStart.next = reversedNode;
				}
				previousBlockStart = currentBlockStart;
				currentBlockStart = head;
				reversedNode = null;
				blockNodeCounter = 1;
				blockCounter++;
			} else {
				blockNodeCounter++;
			}
		}

		if (size() % k != 0) {
			previousBlockStart.next = head;
		}

	}

	@Override
	public void reverseBlocksOfKNodes1(int k) {
		if (k <= 1 || k > size)
			return;
		Node<T> current = getRootNode();
		Node<T> tempRoot = null;
		Node<T> previous = null;

		while (current != null) {
			Node<T> start = current;

			int i = 1;
			Node<T> last = current;
			forLoop: for (; i < k; i++) {
				last = last.next;
				if (last == null) {
					i = 1;
					break forLoop;
				}
			}
			if (i == k) {
				if (tempRoot == null) {
					tempRoot = last;
				}
				current = last.next;
				last.next = null;

				Node<T> reversedPart = recursiveReverse(start);
				if (previous != null) {
					previous.next = reversedPart;
				}
				previous = start;
				start.next = null;
			} else {
				previous.next = start;
				current = null;
			}
		}
		root = tempRoot;
	}

	// m = 1, is not taken care of.
	// If after removing node we need not move on next node we can comment line #1
	@Override
	public Node<T> josephusCircleElimination(int k) {
		Node<T> current = getRootNode();

		while (current.next != current) {
			for (int i = 1; i < k - 1; i++) {
				current = current.next;
			}
			System.out.println("Dropping: " + current.next);
			current.next = current.next.next;
			current = current.next; // #1
		}
		return current;
	}

	private int recursiveJosephus(int n, int k) {
		return n > 1 ? (recursiveJosephus(n - 1, k) + k - 1) % n + 1 : 1;
	}

	@Override
	public List<T> cloneListWithRandomPointer() {

		Map<Node<T>, Node<T>> mapping = new HashMap<>();
		List<T> clonedList = new LinkedList<>();

		Node<T> head = getRootNode();
		Node<T> previousNode = null;

		while (head != null) {
			Node<T> clonedNode = new Node<>(head.data);
			mapping.put(head, clonedNode);
			if (previousNode != null) {
				previousNode.next = clonedNode;
			}
			previousNode = clonedNode;
			head = head.next;
		}

		mapping.forEach((origNode, clonedNode) -> {
			clonedNode.random = mapping.get(origNode.random);
		});

		clonedList.insert(mapping.get(getRootNode()));

		return clonedList;
	}

	@Override
	public void deleteNodeFromLinkedList(Node<T> deleteNode) {

		Node<T> head = getRootNode();

		if (deleteNode == head) {
			root = head.next;
			return;
		}

		while (head != null) {
			if (deleteNode == head.next) {
				head.next = head.next.next;
			}
			head = head.next;
		}
	}

	@Override
	public void deleteNodeFromLinkedListWithoutIteration(Node<T> deleteNode) {
		Node<T> nextNode = deleteNode.next;

		if (nextNode == null) {
			throw new UnsupportedOperationException(
					"Deleting last node is not possible using this data shifting approach.");
		}

		deleteNode.data = nextNode.data;
		deleteNode.next = nextNode.next;
	}

	@Override
	public Node<T> findLastModularNodeForConstant(int k) {

		Node<T> head = getRootNode();
		Node<T> modularNode = null;

		for (int n = 1; head != null; head = head.next, n++) {
			if (n % k == 0) {
				modularNode = head;
			}
		}
		return modularNode;
	}

	@Override
	public Node<T> findCeiledFractionalNode(int k) {
		Node<T> head = getRootNode();
		Node<T> modularNode = getRootNode();

		for (int n = 1; head.next != null; head = head.next, n++) {
			if (n % k == 0) {
				modularNode = modularNode.next;
			}
		}
		return modularNode;
	}

	@Override
	public Node<T> findCeiledFractionalNodeUsingFastSlowPointer(int k) {
		Node<T> fastPointer = getRootNode();
		Node<T> slowPointer = getRootNode();

		int i = k;
		while (fastPointer != null) {
			if (i > 0) {
				fastPointer = fastPointer.next;
			} else {
				slowPointer = slowPointer.next;
				i = k;
				continue;
			}
			i--;
		}
		return slowPointer;
	}

	@Override
	public Node<T> findCeiledSqrtNode() {
		Node<T> node = getRootNode();
		Node<T> squareRootNode = null;

		for (int length = 1, squareRoot = 1; node != null; node = node.next) {
			if (length == squareRoot * squareRoot) {
				squareRootNode = squareRootNode == null ? getRootNode() : squareRootNode.next;
				squareRoot++;
			}
			length++;
		}
		return squareRootNode;
	}

	@Override
	public List<Integer> addTwoLists(List<Integer> list1, List<Integer> list2) {

		// Adding zeroes in shorter list to make both the list equal sized.
		List<Integer> shorterLengthList = list1.size() > list2.size() ? list2 : list1;

		long diff = Math.abs((list1.size() - list2.size()));
		for (long i = 0; i < diff; i++) {
			shorterLengthList.insert(0);
		}

		List<Integer> summationList = new LinkedList<>();
		int carry = addNode(list1.getRootNode(), list2.getRootNode(), summationList);
		if (carry != 0) {
			summationList.insert(carry);
		}
		return summationList;
	}

	private int addNode(Node<Integer> node1, Node<Integer> node2, List<Integer> summationList) {

		if (node1 == null && node2 == null) {
			return 0;
		}

		int carry = addNode(node1.next, node2.next, summationList);

		int addition = node1.data + node2.data + carry;

		System.out.print(
				"\n Adding digits " + node1.data + ", " + node2.data + " and carry: " + carry + " = " + addition);

		int resultDigit = 0;
		if (addition > 9) {
			resultDigit = addition - 10;
			carry = 1;
		} else {
			resultDigit = addition;
			carry = 0;
		}
		System.out.print("| Result digit " + resultDigit + ", carry: " + carry + "\n");

		summationList.insert(resultDigit);
		return carry;
	}

	@Override
	public List<T> listReorder() {
		Node<T> middleNode = findMiddleNodeOfLinkedList();
		Node<T> middleNextNode = middleNode.next;
		middleNode.next = null;

		Node<T> reversedListNode = recursiveReverse(middleNextNode);

		List<T> reorderedList = new LinkedList<>();

		Node<T> head = getRootNode();
		while (head != null) {
			reorderedList.insertAtEnd(new Node<T>(head.data));
			head = head.next;
			if (reversedListNode != null) {
				reorderedList.insertAtEnd(new Node<>(reversedListNode.data));
				reversedListNode = reversedListNode.next;
			}
		}
		return reorderedList;
	}

	@Override
	public List<T> printCommonElements(List<T> list1, List<T> list2) {

		List<T> commonElementsList = new LinkedList<>();

		Node<T> node1 = list1.getRootNode();
		Node<T> node2 = list2.getRootNode();

		while (node1 != null && node2 != null) {

			if (node1.data.compareTo(node2.data) == 0) {
				commonElementsList.insertAtEnd(node1.data);
				node1 = node1.next;
				node2 = node2.next;
			} else if (node1.data.compareTo(node2.data) > 0) {
				node2 = node2.next;
			} else {
				node1 = node1.next;
			}
		}
		return commonElementsList;
	}

}
