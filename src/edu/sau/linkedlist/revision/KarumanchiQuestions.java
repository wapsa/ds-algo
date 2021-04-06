package edu.sau.linkedlist.revision;

public interface KarumanchiQuestions<T extends Comparable<T>> {

	/**
	 * Q2 - Q4. Find nth node from the end of a Linked List using size of the list
	 * which is available.
	 */
	public T findNthNodeFromEndOfListUsingSizeOfList(long n);

	/**
	 * Q5. Find nth node from the end of a Linked List in one scan without using
	 * size of the list.
	 * 
	 * Use two pointers pNthNode and pTemp. Initially, both point to head node of
	 * the list. pNthNode starts moving only after pTemp has made n moves. From
	 * there both move forward until pTemp reaches the end of the list. As a result
	 * pNthNode points to nth node from the end of the linked list.
	 * 
	 * PS: think about distance traveled by both pointers.
	 */
	public T findNthNodeFromEndOfListWithoutUsingSizeOfList(long n);

	/**
	 * Q6 - Q7 Check whether the given linked list is either NULL-terminated or ends
	 * in a cycle (cyclic).
	 */
	public Node<T> checkIfListHaveLoopUsingHashingTechnique();

	/**
	 * Q9 - Q13 Check whether the given linked list is either NULL-terminated or
	 * ends in a cycle (cyclic) using Floyd's cycle finding algorithm.
	 * 
	 * Why do slow and fast pointers meet each other when there is a loop??
	 * 
	 * <pre>
	 * Ans:
	 * 
	 * Solution assumptions for mathematical induction:
	 * 
	 * M - length from root node(head node) to start of loop node (node where the loop begins).
	 * L - length of loop
	 * K - length of start of loop node to meeting point of slow and fast pointers in the loop.
	 * 
	 * Distance travelled by slow pointer till meeting point = M + K
	 * Distance travelled by fast pointer till meeting point = M + (n)L + K, where n is the loop count for fast pointer.
	 * 
	 * Since, loop represents periodic movement, loop count (n) can be ignored as fast pointer will remain at same spot in the list 
	 * even if it loops n number of times.
	 * 
	 * So, M + (n)L + K can be written as M + L + K.
	 * 
	 * Now we know that, distance travelled by fast pointer is 2(distance travelled by slow pointer)
	 * 
	 * So, distance travelled by fast pointer = 2(M + K)
	 * 
	 * M + L + K = 2(M + K)
	 * After solving above equation we get M = L - K
	 * 
	 * <b>From the previous discussion and problems we understand that the meeting of
	 * slow pointer and fast pointer concludes the existence of the loop, but how does keeping the slow pointer at
	 * the beginning of the linked list while keeping the fast pointer at the meeting point, followed by
	 * moving both one step at a time, make them meet at the starting point of the cycle?</b>
	 * 
	 * If fast pointer starts at meeting point node and travels one step at a time it will cover L - K distance which as we 
	 * have deduced above = M.
	 * 
	 * So, both the pointers will meet at the starting of the loop as 
	 * M = length from root node(head node) to start of loop node (node where the loop begins).
	 * 
	 * </pre>
	 */
	public Node<T> checkIfListHaveLoopUsingFloydCycleFindingAlgo();

	/**
	 * Q14 - Check whether the given linked list is NULL-terminated. If there is a
	 * cycle, find the length of the loop.
	 */
	public int findLengthOfTheLoop();

	/**
	 * Q15 - Insert a node in a sorted linked list.
	 */
	public void insertNodeInSortedLinkedList(T data);

	/**
	 * Q16 - Reverse a singly linked list.
	 */
	public void reverseListUsingLoop();

	/**
	 * Q16 - Reverse a singly linked list using recursion.
	 */
	public void reverseListUsingRecursion();

	/**
	 * Q17 - Suppose there are two singly linked lists both of which intersect at
	 * some point and become a single linked list. The head or start pointers of
	 * both the lists are known, but the intersecting node is not known. Also, the
	 * number of nodes in each of the lists before they intersect is unknown and may
	 * be different in each list. List1 may have n nodes before it reaches the
	 * intersection point, and List2 might have m nodes before it reaches the
	 * intersection point where m and n may be m = n,m < n or m > n. Give an
	 * algorithm for finding the merging point.
	 * 
	 */
	/*
	 * Solution: Brute-Force Approach: One easy solution is to compare every node
	 * pointer in the first list with every other node pointer in the second list by
	 * which the matching node pointers will lead us to the intersecting node. But,
	 * the time complexity in this case will be O(mn) which will be high.
	 *
	 */
	/**
	 * Q19 - Can we solve Problem-17 using hash tables?
	 * 
	 * Solution: Yes. O(m) + O(n). Easy, so no solution. :D
	 */
	public Node<T> findIntersectingNodeOfTwoListsUsingBruteForce(List<T> inputList);

	/**
	 * Q20 - Can we use stacks for solving the Problem-17?
	 */
	public Node<T> findIntersectingNodeOfTwoListsUsingStack(List<T> inputList);

	/**
	 * Q21 - Q22 Can we improve the complexity for Problem-17 using search
	 * techniques?
	 */
	public Node<T> findIntersectingNodeOfTwoListsUsingSearch(List<T> inputList);

	/**
	 * Q23 Can we improve the complexity for Problem-17? O(max(m, n))
	 */
	public Node<T> findIntersectingNodeOfTwoListsUsingDistance(List<T> inputList);

	/**
	 * Q24 - Q27 How will you find the middle of the linked list?
	 */
	public Node<T> findMiddleNodeOfLinkedList();

	/**
	 * Q28 - How will you display a Linked List from the end?
	 */
	public void displayLinkedListFromEnd();

	/**
	 * Q29 - Check whether the given Linked List length is even or odd?
	 */
	public void checkIfListIsEvenOrOdd();

	/**
	 * Q31 - Given two sorted Linked Lists, how to merge them into the third list in
	 * sorted order?
	 */
	public List<T> mergeTwoSortedListIntoThirdList(List<T> list1, List<T> list2);

	/**
	 * Q31 - Given two sorted Linked Lists, how to merge them into the third list in
	 * sorted order?
	 */
	public List<T> mergeTwoSortedListIntoThirdListUsingRecursion(List<T> list1, List<T> list2);

	/**
	 * Q32 - Reverse the linked list in pairs. If you have a linked list that holds
	 * 
	 * 1 → 2 → 3 → 4 → X,
	 * 
	 * then after the function has been called the linked list would hold
	 * 
	 * 2 → 1 → 4 → 3 → X.
	 */
	public void reverseListInPairsUsingRecursion();

	/**
	 * Q32 - Iterative approach
	 */
	public void reverseListInPairsUsingIterativeApproach1();

	/**
	 * Q32 - Iterative approach
	 */
	public void reverseListInPairsUsingIterativeApproach2();

	/**
	 * Q35 - Split a Circular Linked List into two equal parts. If the number of
	 * nodes in the list are odd then make first list one node extra than second
	 * list.
	 */
	public void splitCircularListToTwoCircularLinkedList();

	/**
	 * Q37 - How will you check if the linked list is palindrome or not?
	 */
	public void checkIfListIsPalindrome();

	/**
	 * Q39 - For a given K value (K > 0) reverse blocks of K nodes in a list.
	 * Example: Input: 1 2 3 4 5 6 7 8 9 10.
	 * 
	 * Output for different K values:
	 * 
	 * For K = 2: 2 1 4 3 6 5 8 7 10 9
	 * 
	 * For K = 3: 3 2 1 6 5 4 9 8 7 10
	 * 
	 * For K = 4: 4 3 2 1 8 7 6 5 9 10
	 */
	public void reverseBlocksOfKNodes(int k);

	/**
	 * Q40 - Josephus Circle: N people have decided to elect a leader by arranging
	 * themselves in a circle and eliminating every Mth person around the circle,
	 * closing ranks as each person drops out. Find which person will be the last
	 * one remaining (with rank 1).
	 * 
	 * 
	 * Solution: Assume the input is a circular linked list with N nodes and each
	 * node has a number (range 1 to N) associated with it. The head node has number
	 * 1 as data.
	 */
	public Node<T> josephusCircleElimination(int m);

	/**
	 * Q41 - Given a linked list consists of data, a next pointer and also a random
	 * pointer which points to a random node of the list. Give an algorithm for
	 * cloning the list.
	 */
	public List<T> cloneListWithRandomPointer();

	/**
	 * Q43 - We are given a pointer to a node (not the tail node) in a singly linked
	 * list. Delete that node from the linked list.
	 */
	public void deleteNodeFromLinkedList(Node<T> node);

	/**
	 * Q43 - We are given a pointer to a node (not the tail node) in a singly linked
	 * list. Delete that node from the linked list without iterating.
	 */
	public void deleteNodeFromLinkedListWithoutIteration(Node<T> node);

	/**
	 * Q46 - Find modular node: Given a singly linked list, write a function to find
	 * the last element from the beginning whose n%k == 0, where n is the number of
	 * elements in the list and k is an integer constant. For example, if n = 19 and
	 * k = 3 then we should return 18th node.
	 * 
	 * For this problem the value of n is not known in advance.
	 */
	public Node<T> findLastModularNodeForConstant(int k);

	/**
	 * Q48 - Find fractional node: Given a singly linked list, write a function to
	 * find the (n/k)th element, where n is the number of elements in the list.
	 */
	public Node<T> findCeiledFractionalNode(int k);

	/**
	 * Q48 - Find fractional node: Given a singly linked list, write a function to
	 * find the (n/k)th element, where n is the number of elements in the list.
	 */
	public Node<T> findCeiledFractionalNodeUsingFastSlowPointer(int k);

	/**
	 * Q49 - Find square root of (n)th node: Given a singly linked list, write a
	 * function to find the element, where n is the number of elements in the list.
	 * Assume the value of n is not known in advance.
	 */
	public Node<T> findCeiledSqrtNode();

	/**
	 * Q53 - Given two linked lists, each list node with one integer digit, add
	 * these two linked lists. The result should be stored in the third linked list.
	 * Also note that the head node contains the most significant digit of the
	 * number.
	 */
	public List<Integer> addTwoLists(List<Integer> list1, List<Integer> list2);

	/**
	 * Q55 - Given a list, List1 = {A1, A2, . . . An–1; An) with data, reorder it
	 * to {A1, An,A2,An–1} without using any extra space.
	 * 
	 * Solution: Find the middle of the linked list. We can do it by slow and fast
	 * pointer approach. After finding the middle node, we reverse the right halfl
	 * then we do a in place merge of the two halves of the linked list.
	 */
	public List<T> listReorder();

	/**
	 * Given two sorted linked lists, given an algorithm for the printing common
	 * elements of them.
	 * 
	 * Solution: The solution is based on merge sort logic. Assume the given two
	 * linked lists are: list1 and list2. Since the elements are in sorted order, we
	 * run a loop till we reach the end of either of the list. We compare the values
	 * of list1 and list2. If the values are equal, we add it to the common list. We
	 * move list1/list2/both nodes ahead to the next pointer if the values pointed
	 * by list1 was less / more / equal to the value pointed by list2.
	 * 
	 * Time complexity O(m + n), where m is the length of list1 and n is the length
	 * of list2. Space Complexity: O(1).
	 */
	public List<T> printCommonElements(List<T> list1, List<T> list2);
}
