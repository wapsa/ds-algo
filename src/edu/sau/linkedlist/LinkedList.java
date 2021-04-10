package edu.sau.linkedlist;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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

		Node<T> slowPointer = this.rootNode;
		Node<T> fastPointer = this.rootNode;

		while (fastPointer != null && fastPointer.getNextNode() != null) {
			slowPointer = slowPointer.getNextNode();
			fastPointer = fastPointer.getNextNode().getNextNode();

			if (slowPointer == fastPointer) {
				slowPointer = this.rootNode;

				while (slowPointer != fastPointer) {
					slowPointer = slowPointer.getNextNode();
					fastPointer = fastPointer.getNextNode();
				}
				return fastPointer;
			}
		}
		return null;
	}

	@Override
	public int findLengthOfTheLoop() {

		Node<T> slowPointer = this.rootNode;
		Node<T> fastPointer = this.rootNode;

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
			fastPointer = fastPointer.getNextNode();
			int counter = 1;
			while (slowPointer != fastPointer) {
				counter++;
				fastPointer = fastPointer.getNextNode();
			}
			return counter;
		}

		return Integer.MIN_VALUE;
	}

	@Override
	public void insertNodeInSortedLinkedList(T data) {
		if (this.rootNode == null || this.rootNode.getData().compareTo(data) >= 0) {
			insert(data);
			return;
		}

		Node<T> current = this.rootNode;
		Node<T> previousNode = null;
		while (current != null && current.getData().compareTo(data) <= 0) {
			previousNode = current;
			current = current.getNextNode();
		}

		Node<T> newNode = new Node<>(data);
		previousNode.setNextNode(newNode);
		newNode.setNextNode(current);
	}

//	 previous	current		next
//	 ------------------------------------------------------------------- 
//	  null		1			2			3	4	5	null
//	  
//	  1			2			3			4	5	null
//	  
//	  2			3			4			5	null
//	  
//	  3			4			5			null
//	  
//	  4			5			null
//	  
//	  5			null
//	  
//	  breaks loop as current is null now.
	@Override
	public void reverseListUsingLoop() {

		Node<T> previous = null;
		Node<T> current = this.rootNode;

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

		if (this.rootNode == null || this.rootNode.getNextNode() == null) {
			return;
		}
		Node<T> reversedRootNode = recursiveReverse(this.rootNode);

		this.rootNode = reversedRootNode;
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
//	â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ â†’ 
//																									â†“
//							Node<T> nextNode = current.getNextNode();								â†“
//							current.setNextNode(null);												â†“
//	 _____		   _____		 _____		    _____		   _____		  _____					â†“
//	|     |		  |     |	    |     |		   |     |		  |     |		 |     |				â†“
//	|  1  | --->  |  2  |  ---> |  3  |	 --->  |  4  |  --->  |  5  |  --->  |  6  |  ---> NULL		â†“
//	|_____|		  |_____|	    |_____|		   |_____|		  |_____|		 |_____|				â†“
//	|			 /|			   /|			  /|		     /|				/|						â†“
//	|           / | 		  /	|			 / |  			/ |			   / |						â†“
//	|		   /  |			 /	|			/  |		   /  |		      /	 |						â†“
//	|         /   |         /   |          /   |          /   |          /   |						â†“
//	cur, next	  cur, next		cur, next	   cur, next	  cur, next	 	cur						â†“
//																									â†“
//							nextNode.setNextNode(current);											â†“
//																									â†“
//	â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� â†� 
	// Divide and Conquer way of solving solution.
	private Node<T> recursiveReverse(Node<T> currentNode) {

		// reverse of null is null
		if (currentNode == null) {
			return null;
		}
		// reverse of single element is the element itself.
		// helps in U turn
		if (currentNode.getNextNode() == null) {
			return currentNode;
		}

		// divide the list into two parts, currentNode and restOfList from next
		// element.
		Node<T> restOfList = currentNode.getNextNode();
		currentNode.setNextNode(null);

		// call recursiveReverse method for the restOfList and in return keep the
		// reference to reversed list.
		Node<T> reversedList = recursiveReverse(restOfList);

		// conquer part where we re-compose the solution.
		// link the restOfList to the currentNode in the call stack.
		restOfList.setNextNode(currentNode);

		return reversedList;
	}

	@Override
	public void reverseListUsingRecursionAlternate() {
		recursiveReverseAlternate(this.getRootNode());
	}

	private void recursiveReverseAlternate(Node<T> current) {
		if (current == null || current.getNextNode() == null) {
			this.rootNode = current;
			return;
		}

		recursiveReverseAlternate(current.getNextNode());

		current.getNextNode().setNextNode(current);
		current.setNextNode(null);
	}

	@Override
	public Node<T> findIntersectingNodeOfTwoListsUsingBruteForce(List<T> inputList) {

		Node<T> startA = this.getRootNode();

		outerLoop: while (startA != null) {
			Node<T> startB = inputList.getRootNode();

			while (startB != null) {
				if (startA == startB) {
					break outerLoop;
				}
				startB = startB.getNextNode();
			}
			startA = startA.getNextNode();
		}
		return startA;
	}

	@Override
	public Node<T> findIntersectingNodeOfTwoListsUsingStack(List<T> inputList) {
		Deque<Node<T>> stack1 = new java.util.LinkedList<>();
		Deque<Node<T>> stack2 = new java.util.LinkedList<>();

		Node<T> startA = this.getRootNode();
		while (startA != null) {
			stack1.push(startA);
			startA = startA.getNextNode();
		}
		Node<T> startB = inputList.getRootNode();
		while (startB != null) {
			stack2.push(startB);
			startB = startB.getNextNode();
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
		long L1 = this.size();
		long L2 = inputList.size();

		long difference = Math.abs((L1 - L2));

		List<T> longerList = this;
		List<T> shorterList = inputList;
		if (L2 > L1) {
			longerList = inputList;
			shorterList = this;
		}

		Node<T> shorterListStartNode = shorterList.getRootNode();
		Node<T> longerListStartNode = longerList.getRootNode();

		while (difference > 0) {
			longerListStartNode = longerListStartNode.getNextNode();
			difference--;
		}

		while (longerListStartNode != shorterListStartNode) {
			shorterListStartNode = shorterListStartNode.getNextNode();
			longerListStartNode = longerListStartNode.getNextNode();
		}

		return longerListStartNode;
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
		printInReverse(this.getRootNode());
	}

	private void printInReverse(Node<T> current) {

		if (current == null) {
			return;
		}

		printInReverse(current.getNextNode());

		System.out.print(current + " <--- ");
	}

	// check out find middle element code, same logic is used here.
	@Override
	public void checkIfListIsEvenOrOdd() {
		Node<T> temp = this.getRootNode();

		while (temp != null && temp.getNextNode() != null) {
			temp = temp.getNextNode().getNextNode();
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

		while ((nodeA != null && nodeB != null) || nodeA != null || nodeB != null) {
			if (nodeA == null) {
				listC.insertAtEnd(new Node<T>(nodeB.getData()));
				nodeB = nodeB.getNextNode();
			} else if (nodeB == null) {
				listC.insertAtEnd(new Node<T>(nodeA.getData()));
				nodeA = nodeA.getNextNode();
			} else if (nodeB == null || nodeA.getData().compareTo(nodeB.getData()) <= 0) {
				listC.insertAtEnd(new Node<T>(nodeA.getData()));
				nodeA = nodeA.getNextNode();
			} else {
				listC.insertAtEnd(new Node<T>(nodeB.getData()));
				nodeB = nodeB.getNextNode();
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
			mergedList.insertAtEnd(new Node<T>(nodeB.getData()));
			mergeListRecursive1(nodeA, nodeB.getNextNode(), mergedList);
		} else if (nodeB == null || nodeA.getData().compareTo(nodeB.getData()) <= 0) {
			mergedList.insertAtEnd(new Node<T>(nodeA.getData()));
			mergeListRecursive1(nodeA.getNextNode(), nodeB, mergedList);
		} else {
			mergedList.insertAtEnd(new Node<T>(nodeB.getData()));
			mergeListRecursive1(nodeA, nodeB.getNextNode(), mergedList);
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

		if (node1.getData().compareTo(node2.getData()) <= 0) {
			temp = new Node<>(node1.getData());
			mergedNodes = mergeListRecursive3(node1.getNextNode(), node2);
		} else {
			temp = new Node<>(node2.getData());
			mergedNodes = mergeListRecursive3(node1, node2.getNextNode());
		}

		temp.setNextNode(mergedNodes);
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

		if (nodeA.getData().compareTo(nodeB.getData()) <= 0) {
			result = new Node<T>(nodeA.getData());
			result.setNextNode(mergeListRecursive2(nodeA.getNextNode(), nodeB));
		} else {
			result = new Node<T>(nodeB.getData());
			result.setNextNode(mergeListRecursive2(nodeA, nodeB.getNextNode()));
		}
		return result;
	}

	@Override
	public void reverseListInPairsUsingRecursion() {
		this.rootNode = reverseListInPairs(this.rootNode);
		// this.rootNode = reverseListInPairs2(this.rootNode);
	}

	private Node<T> reverseListInPairs(Node<T> currentNode) {

		if (currentNode == null || currentNode.getNextNode() == null) {
			return currentNode;
		}

		Node<T> nextNode = currentNode.getNextNode();
		Node<T> nextToNextNode = currentNode.getNextNode().getNextNode();
		nextNode.setNextNode(currentNode);
		currentNode.setNextNode(reverseListInPairs(nextToNextNode));

		return nextNode;
	}

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
		Node<T> temp1 = null;
		Node<T> temp2 = null;
		Node<T> current = this.getRootNode();

		while (current != null && current.getNextNode() != null) {
			if (temp1 != null) {
				temp1.getNextNode().setNextNode(current.getNextNode());
			}
			temp1 = current.getNextNode();
			current.setNextNode(current.getNextNode().getNextNode());
			temp1.setNextNode(current);

			if (temp2 == null) {
				temp2 = temp1;
			}
			current = current.getNextNode();
		}
		this.rootNode = temp2;
	}

	@Override
	public void splitCircularListToTwoCircularLinkedList() {
		if (this.getRootNode() == null) {
			return;
		}
		Node<T> slowPointer = this.getRootNode();
		Node<T> fastPointer = this.getRootNode();

		// below while loop will get the slowPointer at middle of list. Check question
		// 24-27
		while (fastPointer.getNextNode() != this.getRootNode()
				&& fastPointer.getNextNode().getNextNode() != this.getRootNode()) {
			slowPointer = slowPointer.getNextNode();
			fastPointer = fastPointer.getNextNode().getNextNode();
		}

		// For even number of nodes in list we have to move fast pointer 1x ahead to
		// reach last node.
		if (fastPointer.getNextNode().getNextNode() == this.getRootNode()) {
			fastPointer = fastPointer.getNextNode();
		}

		// keeping hold of middle next for list 2
		Node<T> middleNext = slowPointer.getNextNode();

		// from middle to start
		slowPointer.setNextNode(this.getRootNode());

		// from end to middle next
		fastPointer.setNextNode(middleNext);

		List<T> list1 = new LinkedList<>();
		list1.insert(this.getRootNode());
		List<T> list2 = new LinkedList<>();
		list2.insert(middleNext);

		list1.traverseForLoopingList();
		list2.traverseForLoopingList();

	}

	@Override
	public void checkIfListIsPalindrome() {

		Node<T> slowPointer = this.getRootNode();
		Node<T> fastPointer = this.getRootNode();

		while (fastPointer != null && fastPointer.getNextNode() != null
				&& fastPointer.getNextNode().getNextNode() != null) {
			slowPointer = slowPointer.getNextNode();
			fastPointer = fastPointer.getNextNode().getNextNode();
		}

		Node<T> secondPart = slowPointer.getNextNode();
		// slowPointer.setNextNode(null);
		Node<T> reverseOfSecondPartOfList = recursiveReverse(secondPart);
		Node<T> firstPart = this.getRootNode();

		boolean isPalindrome = false;
		while (reverseOfSecondPartOfList != null) {
			if (reverseOfSecondPartOfList.getData().compareTo(firstPart.getData()) != 0) {
				isPalindrome = false;
				break;
			}
			isPalindrome = true;
			firstPart = firstPart.getNextNode();
			reverseOfSecondPartOfList = reverseOfSecondPartOfList.getNextNode();
		}

		System.out.println("isPalindrome: " + isPalindrome);
	}

	@Override
	public void reverseBlocksOfKNodes(int k) {
		if (k <= 1 || k > this.sizeOfList)
			return;
		Node<T> current = this.getRootNode();
		Node<T> tempRoot = null;
		Node<T> previous = null;

		while (current != null) {
			Node<T> start = current;

			int i = 1;
			Node<T> last = current;
			forLoop: for (; i < k; i++) {
				last = last.getNextNode();
				if (last == null) {
					i = 1;
					break forLoop;
				}
			}
			if (i == k) {
				if (tempRoot == null) {
					tempRoot = last;
				}
				current = last.getNextNode();
				last.setNextNode(null);

				Node<T> reversedPart = recursiveReverse(start);
				if (previous != null) {
					previous.setNextNode(reversedPart);
				}
				previous = start;
				start.setNextNode(null);
			} else {
				previous.setNextNode(start);
				current = null;
			}
		}
		this.rootNode = tempRoot;
	}

	// m = 1, is not taken care of.
	// If after removing node we need not move on next node we can comment line #1
	@Override
	public Node<T> josephusCircleElimination(int m) {
		Node<T> current = this.getRootNode();

		while (current.getNextNode() != current) {
			for (int i = 1; i < m - 1; i++) {
				current = current.getNextNode();
			}
			System.out.println("Dropping: " + current.getNextNode());
			current.setNextNode(current.getNextNode().getNextNode());
			current = current.getNextNode(); // #1
		}
		return current;
	}

	@Override
	public List<T> cloneListWithRandomPointer() {

		Map<Node<T>, Node<T>> mapping = new HashMap<>();
		List<T> clonedList = new LinkedList<>();

		Node<T> head = this.getRootNode();
		Node<T> previousNode = null;

		while (head != null) {
			Node<T> clonedNode = new Node<>(head.getData());
			mapping.put(head, clonedNode);
			if (previousNode != null) {
				previousNode.setNextNode(clonedNode);
			}
			previousNode = clonedNode;
			head = head.getNextNode();
		}

		mapping.forEach((origNode, clonedNode) -> {
			clonedNode.setRandomNode(mapping.get(origNode.getRandomNode()));
		});

		clonedList.insert(mapping.get(this.getRootNode()));

		return clonedList;
	}

	@Override
	public void deleteNodeFromLinkedList(Node<T> deleteNode) {

		Node<T> head = this.getRootNode();

		if (deleteNode == head) {
			this.rootNode = head.getNextNode();
			return;
		}

		while (head != null) {
			if (deleteNode == head.getNextNode()) {
				head.setNextNode(head.getNextNode().getNextNode());
			}
			head = head.getNextNode();
		}
	}

	@Override
	public void deleteNodeFromLinkedListWithoutIteration(Node<T> deleteNode) {
		Node<T> nextNode = deleteNode.getNextNode();

		if (nextNode == null) {
			throw new UnsupportedOperationException(
					"Deleting last node is not possible using this data shifting approach.");
		}

		deleteNode.setData(nextNode.getData());
		deleteNode.setNextNode(nextNode.getNextNode());
	}

	@Override
	public Node<T> findLastModularNodeForConstant(int k) {

		Node<T> head = this.getRootNode();
		Node<T> modularNode = null;

		for (int n = 1; head != null; head = head.getNextNode(), n++) {
			if (n % k == 0) {
				modularNode = head;
			}
		}
		return modularNode;
	}

	@Override
	public Node<T> findCeiledFractionalNode(int k) {
		Node<T> head = this.getRootNode();
		Node<T> modularNode = this.getRootNode();

		for (int n = 1; head.getNextNode() != null; head = head.getNextNode(), n++) {
			if (n % k == 0) {
				modularNode = modularNode.getNextNode();
			}
		}
		return modularNode;
	}

	@Override
	public Node<T> findCeiledFractionalNodeUsingFastSlowPointer(int k) {
		Node<T> fastPointer = this.getRootNode();
		Node<T> slowPointer = this.getRootNode();

		int i = k;
		while (fastPointer != null) {
			if (i > 0) {
				fastPointer = fastPointer.getNextNode();
			} else {
				slowPointer = slowPointer.getNextNode();
				i = k;
				continue;
			}
			i--;
		}
		return slowPointer;
	}

	@Override
	public Node<T> findCeiledSqrtNode() {
		Node<T> node = this.getRootNode();
		Node<T> squareRootNode = null;

		for (int length = 1, squareRoot = 1; node != null; node = node.getNextNode()) {
			if (length == squareRoot * squareRoot) {
				squareRootNode = squareRootNode == null ? this.getRootNode() : squareRootNode.getNextNode();
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

		int carry = addNode(node1.getNextNode(), node2.getNextNode(), summationList);

		int addition = Integer.valueOf(node1.getData() + node2.getData() + carry);

		System.out.print("\n Adding digits " + node1.getData() + ", " + node2.getData() + " and carry: " + carry + " = "
				+ addition);

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
		Node<T> middleNextNode = middleNode.getNextNode();
		middleNode.setNextNode(null);

		Node<T> reversedListNode = recursiveReverse(middleNextNode);

		List<T> reorderedList = new LinkedList<>();

		Node<T> head = this.getRootNode();
		while (head != null) {
			reorderedList.insertAtEnd(new Node<T>(head.getData()));
			head = head.getNextNode();
			if (reversedListNode != null) {
				reorderedList.insertAtEnd(new Node<T>(reversedListNode.getData()));
				reversedListNode = reversedListNode.getNextNode();
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

			if (node1.getData().compareTo(node2.getData()) == 0) {
				commonElementsList.insertAtEnd(node1.getData());
				node1 = node1.getNextNode();
				node2 = node2.getNextNode();
			} else if (node1.getData().compareTo(node2.getData()) > 0) {
				node2 = node2.getNextNode();
			} else {
				node1 = node1.getNextNode();
			}
		}
		return commonElementsList;
	}

}
