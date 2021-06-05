package edu.sau.ds.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import edu.sau.ds.tree.bst.BST;
import edu.sau.ds.tree.bst.BinarySearchTree.BSTNode;

public class KarumanchiSolutions<T extends Comparable<T>> implements KarumanchiQuestions<T> {

	@Override
	public List<T> bottomUpLevelOrderTraverse(BST<T> tree) {
		if (tree.isEmpty())
			return List.of();

		Deque<T> stack = new ArrayDeque<>();

		Deque<BSTNode<T>> queue = new ArrayDeque<>();
		queue.offer(tree.root());

		while (!queue.isEmpty()) {
			BSTNode<T> node = queue.poll();
			stack.push(node.getData());

			if (node.getRight() != null)
				queue.offer(node.getRight());

			if (node.getLeft() != null)
				queue.offer(node.getLeft());

		}
		return stack.stream().collect(Collectors.toList());
	}

	@Override
	public int findHeightOfTreeUsingIteration(BST<T> tree) {
		if (tree.isEmpty())
			return 0;

		Deque<BSTNode<T>> queue = new ArrayDeque<>();
		queue.offer(tree.root());

		// already root element is added.
		int level = 1;
		List<BSTNode<T>> nodesAtSameLevel = new ArrayList<>();

		while (!queue.isEmpty()) {

			while (!queue.isEmpty()) {
				nodesAtSameLevel.add(queue.poll());
			}

			nodesAtSameLevel.forEach(node -> {
				if (node.getLeft() != null)
					queue.offer(node.getLeft());

				if (node.getRight() != null)
					queue.offer(node.getRight());

			});

			if (!queue.isEmpty()) {
				level++;
				nodesAtSameLevel.clear();
			}
		}
		return level - 1;
	}

	@Override
	public void printLevelsOfTreeInSeparateLines(BST<T> tree) {
		if (tree.isEmpty())
			return;

		Deque<BSTNode<T>> queue = new ArrayDeque<>();
		queue.offer(tree.root());

		int level = 0;
		List<BSTNode<T>> nodesAtSameLevel = new ArrayList<>();

		while (!queue.isEmpty()) {

			while (!queue.isEmpty()) {
				nodesAtSameLevel.add(queue.poll());
			}

			System.out.println("Level " + level + ": " + nodesAtSameLevel);

			nodesAtSameLevel.forEach(node -> {

				if (node.getLeft() != null)
					queue.offer(node.getLeft());

				if (node.getRight() != null)
					queue.offer(node.getRight());

			});

			if (!queue.isEmpty()) {
				level++;
				nodesAtSameLevel.clear();
			}
		}
	}

	@Override
	public BSTNode<T> getTheDeepestNodeInTree(BST<T> tree) {
		if (tree.isEmpty())
			return null;

		Deque<BSTNode<T>> queue = new ArrayDeque<>();
		queue.offer(tree.root());
		BSTNode<T> deepestNode = null;

		while (!queue.isEmpty()) {
			deepestNode = queue.poll();

			if (deepestNode.getLeft() != null)
				queue.offer(deepestNode.getLeft());

			if (deepestNode.getRight() != null)
				queue.offer(deepestNode.getRight());

		}
		return deepestNode;
	}

	@Override
	public List<T> getNumberOfLeafNodesUsingRecursion(BST<T> tree) {
		List<T> accumulator = new ArrayList<>();
		recursivePreOrderTraverseForLeafNodes(accumulator, tree.root());
		return accumulator;
	}

	/**
	 * Preorder traversal but we are only accumulating leaf nodes as we go.
	 */
	private void recursivePreOrderTraverseForLeafNodes(List<T> accumulator, BSTNode<T> node) {
		if (node == null)
			return;

		if (node.isLeafNode()) {
			accumulator.add(node.getData());
		}
		recursivePreOrderTraverseForLeafNodes(accumulator, node.getLeft());
		recursivePreOrderTraverseForLeafNodes(accumulator, node.getRight());
	}

	/**
	 * Preorder traversal but we are only accumulating leaf nodes as we go.
	 */
	@Override
	public List<T> getNumberOfLeafNodesUsingIteration(BST<T> tree) {
		if (tree.isEmpty())
			return List.of();

		List<T> accumulator = new ArrayList<>();
		Deque<BSTNode<T>> stack = new ArrayDeque<>();
		stack.push(tree.root());

		while (!stack.isEmpty()) {
			BSTNode<T> node = stack.pop();
			if (node.isLeafNode()) {
				accumulator.add(node.getData());
			}

			if (node.getRight() != null)
				stack.push(node.getRight());

			if (node.getLeft() != null)
				stack.push(node.getLeft());

		}
		return accumulator;
	}

	@Override
	public List<T> getNumberOfFullNodesUsingIteration(BST<T> tree) {
		if (tree.isEmpty())
			return List.of();

		List<T> accumulator = new ArrayList<>();
		Deque<BSTNode<T>> stack = new ArrayDeque<>();
		stack.push(tree.root());

		while (!stack.isEmpty()) {
			BSTNode<T> node = stack.pop();
			if (node.isFullNode()) {
				accumulator.add(node.getData());
			}

			if (node.getRight() != null)
				stack.push(node.getRight());

			if (node.getLeft() != null)
				stack.push(node.getLeft());

		}
		return accumulator;
	}

	@Override
	public List<T> getNumberOfHalfNodesUsingIteration(BST<T> tree) {

		if (tree.isEmpty())
			return List.of();

		List<T> accumulator = new ArrayList<>();
		Deque<BSTNode<T>> stack = new ArrayDeque<>();
		stack.push(tree.root());

		while (!stack.isEmpty()) {
			BSTNode<T> node = stack.pop();
			if (node.isHalfNode()) {
				accumulator.add(node.getData());
			}

			if (node.getRight() != null)
				stack.push(node.getRight());

			if (node.getLeft() != null)
				stack.push(node.getLeft());

		}
		return accumulator;

	}

	@Override
	public boolean checkIfGivenTreesAreIdentical(BST<T> tree1, BST<T> tree2) {
		return areTreesIdentical(tree1.root(), tree2.root());
	}

	private boolean areTreesIdentical(BSTNode<T> node1, BSTNode<T> node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 == null || node2 == null)
			return false;

		return node1.getData().compareTo(node2.getData()) == 0 && areTreesIdentical(node1.getLeft(), node2.getLeft())
				&& areTreesIdentical(node1.getRight(), node2.getRight());
	}

	@Override
	public boolean checkIfGivenTreesAreStructurallyIdentical(BST<T> tree1, BST<T> tree2) {
		return areTreesStructurallyIdentical(tree1.root(), tree2.root());
	}

	private boolean areTreesStructurallyIdentical(BSTNode<T> node1, BSTNode<T> node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 == null || node2 == null)
			return false;

		return areTreesStructurallyIdentical(node1.getLeft(), node2.getLeft())
				&& areTreesStructurallyIdentical(node1.getRight(), node2.getRight());
	}

	@Override
	public int findDiameterOfTreeUsingRecursion(BST<T> tree) {
		if (tree.isEmpty())
			return 0;

		int[] nodeCountOnLongestDiameterPath = new int[1];
		getNodeCountOnLongestDiameterPath(tree.root(), nodeCountOnLongestDiameterPath);
		return nodeCountOnLongestDiameterPath[0] - 1;

		// return getNodeCountOnLongestDiameterPath(tree.root()) - 1;
	}

	/**
	 * 
	 * The diameter of the binary tree is defined as the number of edges on the
	 * longest path between any two leaf nodes in the tree.
	 *
	 * <pre>
	 * CASE1 : If diameter exists in left-subtree or right-subtree
	 *         then noOfNodesOnDiameterPath = max(noOfNodesOnLeftDiameter, noOfNodesOnRightDiameter)
	 *
	 * CASE2: If diameter passes through the root i.e. spans both left-subtree and right-subtree
	 *    then  noOfNodesOnDiameterPath = noOfNodesOnLeftHeight + noOfNodesOnRightHeight + 1
	 *  
	 *     
	 *    Final noOfNodesOnDiameterPath = max(CASE1, CASE2)
	 * 
	 * </pre>
	 *
	 * Time-complexity : O(n^2) : because numberOfNodeOnHeightPath(O(n)) is getting
	 * called explicitly for each node
	 */
	private int getNodeCountOnLongestDiameterPath(BSTNode<T> node) {
		if (node == null) {
			return 0;
		}
		int noOfNodesOnLeftHeight = numberOfNodesInHeightPath(node.getLeft());
		int noOfNodesOnRightHeight = numberOfNodesInHeightPath(node.getRight());

		int noOfNodesOnLeftDiameter = getNodeCountOnLongestDiameterPath(node.getLeft());
		int noOfNodesOnRightDiameter = getNodeCountOnLongestDiameterPath(node.getRight());

		// 1 + is to count the current node.
		return Math.max(1 + noOfNodesOnLeftHeight + noOfNodesOnRightHeight,
				Math.max(noOfNodesOnLeftDiameter, noOfNodesOnRightDiameter));
	}

	private int numberOfNodesInHeightPath(BSTNode<T> node) {
		if (node == null)
			return 0;
		return 1 + Math.max(numberOfNodesInHeightPath(node.getLeft()), numberOfNodesInHeightPath(node.getRight()));
	}

	/**
	 * ALGO STRATEGY : 1. Calculate incremental diameter using incremental height
	 * calculation. Means we need to associate diameter and height to each node.
	 *
	 * <pre>
	 * ALGO:
	 *   CASE1: When diameter path enters from left-subtree to right-subtree by crossing-over the given node. This topology will give
	 *          the final nodeCountOnDiameterPath for the given node.
	 *    THEN
	 *    nodeCountOnDiameterPath_for_the_given_node  = nodeCountOnHeightPathOfLeftSubTree + nodeCountOnHeightPathOfRightSubTree + 1;
	 *  
	 *   CASE2: When diameter path enters into parent from given node and does not cross-over from left-subtree to right-subtree. This
	 *   topology will give the intermediate nodeCountOnHeightPath which will be used by parent for nodeCount calculation on heightPath.
	 *      THEN
	 *    nodeCountOnHeightPath_for_the_given_node = max(nodeCountOnHeightPathOfLeftSubTree,nodeCountOnHeightPathOfRightSubTree) + 1;
	 *
	 * </pre>
	 *
	 * nodeCountOnDiameterPathDP method name is based on method argument
	 * 'nodeCountOnDiameterPath' and is not based on return type.
	 */
	private int getNodeCountOnLongestDiameterPath(BSTNode<T> node, int[] nodeCountOnLongestDiameterPath) {
		if (node == null) {
			return 0;
		}
		int nodeCountOnHeightPathOfLeftSubtree = getNodeCountOnLongestDiameterPath(node.getLeft(),
				nodeCountOnLongestDiameterPath);
		int nodeCountOnHeightPathOfRightSubtree = getNodeCountOnLongestDiameterPath(node.getRight(),
				nodeCountOnLongestDiameterPath);

		// left + right + 1 = number of nodes in diameter path for current node. If we
		// do not add + 1 then we can directly store the diameter. Just to maintain code
		// similarity with 2nd solution we have added +1 and finally while returning
		// diameter from main method we will -1 to get edges count.
		nodeCountOnLongestDiameterPath[0] = Math.max(nodeCountOnLongestDiameterPath[0],
				nodeCountOnHeightPathOfLeftSubtree + nodeCountOnHeightPathOfRightSubtree + 1);

		// returning the node count on max height path + 1 for including current node
		// and return it on to parent node calculation.
		return Math.max(nodeCountOnHeightPathOfLeftSubtree, nodeCountOnHeightPathOfRightSubtree) + 1;
	}

	@Override
	public int findDiameterOfTreeUsingIteration(BST<T> tree) {
		if (tree.isEmpty())
			return -1;

		// return getNodeCountOnLongestDiameterPathIterative(tree.root()) - 1;
		return getNodeCountOnLongestDiameterPathIterative1(tree.root()) - 1;
	}

	private int getNodeCountOnLongestDiameterPathIterative(BSTNode<T> node) {
		int nodeCountOnDiameterPath = 0;

		Deque<BSTNode<T>> stack = new ArrayDeque<>();
		stack.push(node);

		BSTNode<T> previous = null;

		Map<BSTNode<T>, Integer> nodeCountOnHeightPathMap = new HashMap<>();

		while (!stack.isEmpty()) {

			node = stack.peek();

			// Checking if node is visited previously.
			if (node.isLeafNode()
					|| (previous != null && (node.getLeft() == previous || node.getRight() == previous))) {

				int nodeCountOnLeftHeightPath = nodeCountOnHeightPathMap.getOrDefault(node.getLeft(), 0);
				int nodeCountOnRightHeightPath = nodeCountOnHeightPathMap.getOrDefault(node.getRight(), 0);

				nodeCountOnHeightPathMap.put(node, Math.max(nodeCountOnLeftHeightPath, nodeCountOnRightHeightPath) + 1);

				int nodeCountOnDiameterPathOfCurrentNode = nodeCountOnLeftHeightPath + nodeCountOnRightHeightPath + 1;

				nodeCountOnDiameterPath = Math.max(nodeCountOnDiameterPath, nodeCountOnDiameterPathOfCurrentNode);

				previous = node;
				stack.pop();

			} else {
				if (node.getRight() != null)
					stack.push(node.getRight());
				if (node.getLeft() != null)
					stack.push(node.getLeft());
			}
		}
		return nodeCountOnDiameterPath;
	}

	private int getNodeCountOnLongestDiameterPathIterative1(BSTNode<T> node) {
		int nodeCountOnDiameterPath = 0;

		Deque<BSTNode<T>> stack = new ArrayDeque<>();
		stack.push(node);

		Map<BSTNode<T>, Integer> nodeCountOnHeightPathMap = new HashMap<>();

		while (!stack.isEmpty()) {

			node = stack.peek();

			if (node.getLeft() != null && !nodeCountOnHeightPathMap.containsKey(node.getLeft()))
				stack.push(node.getLeft());
			else if (node.getRight() != null && !nodeCountOnHeightPathMap.containsKey(node.getRight()))
				stack.push(node.getRight());
			else {

				System.out.println(node);
				int nodeCountOnLeftHeightPath = nodeCountOnHeightPathMap.getOrDefault(node.getLeft(), 0);
				int nodeCountOnRightHeightPath = nodeCountOnHeightPathMap.getOrDefault(node.getRight(), 0);

				nodeCountOnHeightPathMap.put(node, Math.max(nodeCountOnLeftHeightPath, nodeCountOnRightHeightPath) + 1);

				int nodeCountOnDiameterPathOfCurrentNode = nodeCountOnLeftHeightPath + nodeCountOnRightHeightPath + 1;

				nodeCountOnDiameterPath = Math.max(nodeCountOnDiameterPath, nodeCountOnDiameterPathOfCurrentNode);

				stack.pop();
			}
		}
		return nodeCountOnDiameterPath;
	}

	@Override
	public Entry<Integer, Integer> findLevelHavingMaximumSum(BST<Integer> tree) {
		if (tree.isEmpty())
			return null;

		Deque<BSTNode<Integer>> queue = new ArrayDeque<>();
		queue.offer(tree.root());

		int level = 0;
		int maxSum = 0;
		int maxSumLevel = 0;
		List<BSTNode<Integer>> nodesAtSameLevel = new ArrayList<>();

		while (!queue.isEmpty()) {

			while (!queue.isEmpty()) {
				nodesAtSameLevel.add(queue.poll());
			}

			int currentLevelSum = nodesAtSameLevel.stream().mapToInt(BSTNode::getData).sum();
			if (currentLevelSum > maxSum) {
				maxSum = currentLevelSum;
				maxSumLevel = level;
			}

			nodesAtSameLevel.forEach(node -> {

				if (node.getLeft() != null)
					queue.offer(node.getLeft());

				if (node.getRight() != null)
					queue.offer(node.getRight());

			});

			if (!queue.isEmpty()) {
				level++;
				nodesAtSameLevel.clear();
			}
		}
		return Map.entry(maxSumLevel, maxSum);
	}

	/**
	 * Have to use pre-order traversal as we have to go from root to leaf.
	 */
	@Override
	public void printRootToLeafPaths(BST<T> tree) {
		// printRootToLeafPathsRecursive(tree.root(), new ArrayList<>(tree.size()), 0);
		printRootToLeafPathsIterative(tree.root(), new ArrayList<>(tree.size()), 0);
	}

	private void printRootToLeafPathsIterative(BSTNode<T> node, List<T> path, int level) {
		if (node == null)
			return;

		Deque<Entry<BSTNode<T>, Integer>> stack = new ArrayDeque<>();
		Entry<BSTNode<T>, Integer> entry = Map.entry(node, level);
		stack.push(entry);

		while (!stack.isEmpty()) {
			entry = stack.pop();
			node = entry.getKey();
			level = entry.getValue();
			path.add(level, node.getData());

			if (node.isLeafNode()) {
				IntStream.rangeClosed(0, level).forEach(index -> {
					System.out.print(path.get(index) + ", ");
				});
				System.out.println();
			} else {
				// incrementing before going to next level.
				level++;

				if (node.getRight() != null)
					stack.push(Map.entry(node.getRight(), level));
				if (node.getLeft() != null)
					stack.push(Map.entry(node.getLeft(), level));
			}
		}
	}

	private void printRootToLeafPathsRecursive(BSTNode<T> node, List<T> path, int level) {
		if (node == null)
			return;

		path.add(level, node.getData());

		if (node.isLeafNode()) {
			IntStream.rangeClosed(0, level).forEach(index -> {
				System.out.print(path.get(index) + ", ");
			});
			System.out.println();

		} else {
			// incrementing before going to next level.
			level++;
			printRootToLeafPathsRecursive(node.getLeft(), path, level);
			printRootToLeafPathsRecursive(node.getRight(), path, level);
		}
	}

	@Override
	public boolean hasRootToLeafPathWhichHasSum(BST<Integer> tree, int sum) {
		return hasRootToLeafPathWhichHasSum(tree.root(), sum);
	}

	private boolean hasRootToLeafPathWhichHasSum(BSTNode<Integer> node, int sum) {
		if (node == null) {
			return sum == 0;
		}
		return hasRootToLeafPathWhichHasSum(node.getLeft(), sum - node.getData())
				|| hasRootToLeafPathWhichHasSum(node.getRight(), sum - node.getData());
	}

	@Override
	public void printRootToAnyNodePathsWhichHasSum(BST<Integer> tree, int sum) {
		printRootToAnyNodePathsWhichHasSum(tree.root(), new ArrayList<>(tree.size()), 0, sum);
	}

	private void printRootToAnyNodePathsWhichHasSum(BSTNode<Integer> node, List<Integer> path, int level, int sum) {
		if (node == null || sum < 0)
			return;

		path.add(level, node.getData());

		sum = sum - node.getData();
		if (sum < 0)
			return;

		// if we have to consider till leaf node then change to
		// (sum == 0 && node.isLeafNode())
		if (sum == 0) {
			IntStream.rangeClosed(0, level).forEach(index -> {
				System.out.print(path.get(index) + ", ");
			});
			System.out.println();

		} else {
			// incrementing before going to next level.
			level++;
			printRootToAnyNodePathsWhichHasSum(node.getLeft(), path, level, sum);
			printRootToAnyNodePathsWhichHasSum(node.getRight(), path, level, sum);
		}
	}

	/**
	 * We can use any of the tree traversals and keep adding the node data to get
	 * the sum.
	 */
	@Override
	public int sumOfAllNodes(BST<Integer> tree) {
		return addNode(tree.root());
	}

	private int addNode(BSTNode<Integer> node) {
		if (node == null)
			return 0;
		return node.getData() + addNode(node.getLeft()) + addNode(node.getRight());
	}

	/**
	 * Any tree traversal which visits each node only once will work as mirroring
	 * can be achieved by swapping left and right of each and every node in the
	 * tree. This swapping can be done in any order.
	 */
	@Override
	public void mirror(BST<T> tree) {
		getMirrorRecursive(tree.root());
		// getMirrorUsingLevelOrder(tree.root());
		// getMirrorUsingPreOrder(tree.root());
		// getMirrorUsingPostOrder(tree.root());

	}

	private BSTNode<T> getMirrorRecursive(BSTNode<T> node) {
		if (node == null)
			return null;

		BSTNode<T> mirrorOfLeftSubtree = getMirrorRecursive(node.getLeft());
		BSTNode<T> mirrorOfRightSubtree = getMirrorRecursive(node.getRight());

		node.setRight(mirrorOfLeftSubtree);
		node.setLeft(mirrorOfRightSubtree);

		return node;
	}

	private BSTNode<T> getMirrorUsingPostOrder(BSTNode<T> node) {
		if (node == null)
			return null;

		Deque<BSTNode<T>> stack = new ArrayDeque<>();
		stack.push(node);

		BSTNode<T> previous = null;

		while (!stack.isEmpty()) {
			BSTNode<T> tempNode = stack.peek();

			// Checking if node has been visited previously.
			if (tempNode.isLeafNode()
					|| (previous != null && (tempNode.getLeft() == previous || tempNode.getRight() == previous))) {
				previous = tempNode;
				System.out.println(tempNode);
				BSTNode<T> tempLeft = tempNode.getLeft();
				tempNode.setLeft(tempNode.getRight());
				tempNode.setRight(tempLeft);

				stack.pop();

			} else {
				if (tempNode.getRight() != null)
					stack.push(tempNode.getRight());
				if (tempNode.getLeft() != null)
					stack.push(tempNode.getLeft());
			}
		}
		return node;
	}

	private BSTNode<T> getMirrorUsingLevelOrder(BSTNode<T> node) {
		if (node == null)
			return null;

		Queue<BSTNode<T>> queue = new ArrayDeque<>();
		queue.offer(node);

		while (!queue.isEmpty()) {
			BSTNode<T> tempNode = queue.poll();
			System.out.println(tempNode);
			BSTNode<T> tempLeft = tempNode.getLeft();
			tempNode.setLeft(tempNode.getRight());
			tempNode.setRight(tempLeft);

			if (tempNode.getLeft() != null)
				queue.offer(tempNode.getLeft());

			if (tempNode.getRight() != null)
				queue.offer(tempNode.getRight());

		}
		return node;
	}

	private BSTNode<T> getMirrorUsingPreOrder(BSTNode<T> node) {
		if (node == null)
			return null;

		Deque<BSTNode<T>> stack = new ArrayDeque<>();
		stack.push(node);

		while (!stack.isEmpty()) {
			BSTNode<T> tempNode = stack.pop();
			System.out.println(tempNode);
			BSTNode<T> tempLeft = tempNode.getLeft();
			tempNode.setLeft(tempNode.getRight());
			tempNode.setRight(tempLeft);

			if (tempNode.getRight() != null)
				stack.push(tempNode.getRight());
			if (tempNode.getLeft() != null)
				stack.push(tempNode.getLeft());
		}

		return node;
	}

	@Override
	public boolean areGivenTreesMirrorOfEachOther(BST<T> tree1, BST<T> tree2) {
		return areGivenTreesMirrorOfEachOther(tree1.root(), tree2.root());
	}

	private boolean areGivenTreesMirrorOfEachOther(BSTNode<T> node1, BSTNode<T> node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 == null || node2 == null)
			return false;

		// If data is equal we will go deeper.
		if (node1.getData().compareTo(node2.getData()) != 0)
			return false;

		boolean isLeftMirrorOfRight = areGivenTreesMirrorOfEachOther(node1.getLeft(), node2.getRight());
		boolean isRightMirrorOfLeft = areGivenTreesMirrorOfEachOther(node1.getRight(), node2.getLeft());

		return isLeftMirrorOfRight && isRightMirrorOfLeft;
	}

	@Override
	public BSTNode<T> findLeastCommonAncestorOfTwoNodes(BSTNode<T> node1, BSTNode<T> node2) {
		return null;
	}

}
