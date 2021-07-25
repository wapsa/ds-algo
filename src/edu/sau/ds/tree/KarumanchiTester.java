package edu.sau.ds.tree;

import java.util.List;

import edu.sau.ds.tree.bst.BST;
import edu.sau.ds.tree.bst.BinarySearchTree;
import edu.sau.ds.tree.bst.BinarySearchTree.BSTNode;

public class KarumanchiTester {

	private static final KarumanchiQuestions<Integer> KQ = new KarumanchiSolutions<>();

	public static void main(String[] args) {
		bottomUpLevelOrderTraverse();

		// findHeightOfTreeUsingIteration();

		// printLevelsOfTreeInSeparateLines();

		// getTheDeepestNodeInTree();

		// getNumberOfLeafNodesUsingRecursion();

		// getNumberOfLeafNodesUsingIteration();

		// getNumberOfFullNodesUsingIteration();

		// getNumberOfHalfNodesUsingIteration();

		// checkIfGivenTreesAreIdentical();

		// checkIfGivenTreesAreStructurallyIdentical();

		// findDiameterOfTreeUsingRecursion();

		// findDiameterOfTreeUsingIteration();

		// findLevelHavingMaximumSum();

		// printRootToLeafPaths();

		// hasRootToLeafPathWhichHasSum();

		// printRootToAnyNodePathsWhichHasSum();

		// sumOfAllNodes();

		// getMirror();

		// areGivenTreesMirrorOfEachOther();
	}

	private static BST<Integer> bst() {
		BST<Integer> tree = new BinarySearchTree<>();
		tree.insert(99);

		tree.insert(50);
		tree.insert(105);

		tree.insert(1);

		tree.insert(75);
		tree.insert(103);
		tree.insert(110);

		tree.insert(55);
		tree.insert(85);

		tree.insert(80);

		tree.insert(83);

		return tree;
	}

	private static BST<Integer> leftSkewedTree() {

		BST<Integer> tree = new BinarySearchTree<>();
		tree.insert(99);

		tree.insert(50);
		tree.insert(105);

		tree.insert(20);
		tree.insert(21);
		tree.insert(22);
		tree.insert(23);
		tree.insert(24);

		tree.insert(75);
		tree.insert(103);
		tree.insert(110);

		tree.insert(55);
		tree.insert(85);

		tree.insert(80);

		tree.insert(83);

		return tree;
	}

	private static BST<Integer> sumSampleTree() {
		BST<Integer> tree = new BinarySearchTree<>();
		tree.insert(200);

		tree.insert(190);
		tree.insert(205);

		tree.insert(195);
		tree.insert(203);
		tree.insert(15);
		tree.insert(400);

		return tree;
	}

	private static void bottomUpLevelOrderTraverse() {
		BST<Integer> tree = bst();
		System.out.println(tree);
		System.out.println("Bottom Up Level Order Traverse:" + KQ.bottomUpLevelOrderTraverse(tree));
	}

	private static void findHeightOfTreeUsingIteration() {
		BST<Integer> tree = bst();
		System.out.println(tree);
		System.out.println("Height of Tree:" + KQ.findHeightOfTreeUsingIteration(tree));
	}

	private static void printLevelsOfTreeInSeparateLines() {
		BST<Integer> tree = bst();
		System.out.println(tree);
		KQ.printLevelsOfTreeInSeparateLines(tree);
	}

	private static void getTheDeepestNodeInTree() {
		BST<Integer> tree = bst();
		System.out.println(tree);
		System.out.println("Deepest Node: " + KQ.getTheDeepestNodeInTree(tree));
	}

	private static void getNumberOfLeafNodesUsingRecursion() {
		BST<Integer> tree = bst();
		System.out.println(tree);
		List<Integer> leafNodes = KQ.getNumberOfLeafNodesUsingRecursion(tree);
		System.out.println("Leaf Nodes: " + leafNodes);
		System.out.println("No. of Leaf Nodes: " + leafNodes.size());
	}

	private static void getNumberOfLeafNodesUsingIteration() {
		BST<Integer> tree = bst();
		System.out.println(tree);
		List<Integer> leafNodes = KQ.getNumberOfLeafNodesUsingIteration(tree);
		System.out.println("Leaf Nodes: " + leafNodes);
		System.out.println("No. of Leaf Nodes: " + leafNodes.size());
	}

	private static void getNumberOfFullNodesUsingIteration() {
		BST<Integer> tree = bst();
		System.out.println(tree);
		List<Integer> fullNodes = KQ.getNumberOfFullNodesUsingIteration(tree);
		System.out.println("Full Nodes: " + fullNodes);
		System.out.println("No. of Leaf Nodes: " + fullNodes.size());
	}

	private static void getNumberOfHalfNodesUsingIteration() {
		BST<Integer> tree = bst();
		System.out.println(tree);
		List<Integer> fullNodes = KQ.getNumberOfHalfNodesUsingIteration(tree);
		System.out.println("Half Nodes: " + fullNodes);
		System.out.println("No. of Half Nodes: " + fullNodes.size());
	}

	private static void checkIfGivenTreesAreIdentical() {
		BST<Integer> tree1 = bst();
		BST<Integer> tree2 = bst();
		tree2.insert(60);

		System.out.println(tree1);
		System.out.println(tree2);
		System.out.println("Are Trees Identical: " + KQ.checkIfGivenTreesAreIdentical(tree1, tree2));
	}

	private static void checkIfGivenTreesAreStructurallyIdentical() {
		BST<Integer> tree1 = bst();
		BST<Integer> tree2 = bst();
		tree2.delete(83);
		tree2.insert(82);
		tree1.delete(1);
		tree1.insert(20);
		System.out.println(tree1);
		System.out.println(tree2);
		System.out.println(
				"Are Trees Structurally Identical: " + KQ.checkIfGivenTreesAreStructurallyIdentical(tree1, tree2));
	}

	private static void findDiameterOfTreeUsingRecursion() {
		// BST<Integer> tree = bst();
		BST<Integer> tree = leftSkewedTree();
		System.out.println(tree);
		System.out.println("Diameter: " + KQ.findDiameterOfTreeUsingRecursion(tree));
	}

	private static void findDiameterOfTreeUsingIteration() {
		// BST<Integer> tree = bst();
		BST<Integer> tree = leftSkewedTree();
		System.out.println(tree);
		System.out.println("Diameter: " + KQ.findDiameterOfTreeUsingIteration(tree));
	}

	private static void findLevelHavingMaximumSum() {
		BST<Integer> tree = bst();
		System.out.println(tree);
		System.out.println("Level with Max Sum:: " + KQ.findLevelHavingMaximumSum(tree));
	}

	private static void printRootToLeafPaths() {
		BST<Integer> tree = bst();
		System.out.println(tree);
		KQ.printRootToLeafPaths(tree);
	}

	private static void hasRootToLeafPathWhichHasSum() {
		BST<Integer> tree = bst();
		System.out.println(tree);
		System.out.println(KQ.hasRootToLeafPathWhichHasSum(tree, 99));
	}

	private static void printRootToAnyNodePathsWhichHasSum() {
		// BST<Integer> tree = bst();
		BST<Integer> tree = sumSampleTree();
		System.out.println(tree);
		KQ.printRootToAnyNodePathsWhichHasSum(tree, 405);
	}

	private static void sumOfAllNodes() {
		// BST<Integer> tree = bst();
		BST<Integer> tree = sumSampleTree();
		System.out.println(tree);
		System.out.println("Sum of all nodes: " + KQ.sumOfAllNodes(tree));
	}

	private static void getMirror() {
		BST<Integer> tree = bst();
		// BST<Integer> tree = sumSampleTree();
		System.out.println(tree);

		KQ.mirror(tree);

		System.out.println("Mirror: " + tree);
	}

	private static void areGivenTreesMirrorOfEachOther() {

		BST<Integer> tree1 = bst();
		System.out.println(tree1);

		BST<Integer> tree2 = bst();
		KQ.mirror(tree2);
		System.out.println(tree2);

		System.out.println("Are Given Trees Mirror: " + KQ.areGivenTreesMirrorOfEachOther(tree1, tree2));

	}

}
