package edu.sau.ds.tree.bst;

import java.util.List;

import edu.sau.ds.tree.bst.BinarySearchTree.BSTNode;

public class BinarySearchTreeRev<T extends Comparable<T>> implements BST<T> {

	private BSTNode<T> root;
	private int size;

	@Override
	public BSTNode<T> root() {
		return this.root;
	}

	@Override
	public void setRoot(BSTNode<T> node) {
		this.root = node;
	}

	@Override
	public void insert(T data) {
		BSTNode<T> nodeToInsert = new BSTNode<>(data);
		if (isEmpty()) {
			this.root = nodeToInsert;
			size++;
			return;
		}

		boolean inserted = insert(this.root, nodeToInsert);
		if (inserted)
			size++;
	}

	private boolean insert(BSTNode<T> root, BSTNode<T> nodeToInsert) {
		int cmp = nodeToInsert.getData().compareTo(root.getData());
		if (cmp > 0) {
			if (root.getRight() == null) {
				root.setRight(nodeToInsert);
				return true;
			} else {
				insert(root.getRight(), nodeToInsert);
			}
		} else if (cmp < 0) {
			if (root.getLeft() == null) {
				root.setLeft(nodeToInsert);
				return true;
			} else {
				insert(root.getLeft(), nodeToInsert);
			}
		}
		return false;
	}

	@Override
	public boolean delete(T data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T getMaxElement() {
		return isEmpty() ? null : getMaxElement(this.root).getData();
	}

	private BSTNode<T> getMaxElement(BSTNode<T> node) {
		return node.getRight() != null ? getMaxElement(node.getRight()) : node;
	}

	@Override
	public T getMinElement() {
		return isEmpty() ? null : getMinElement(this.root).getData();
	}

	private BSTNode<T> getMinElement(BSTNode<T> node) {
		return node.getLeft() != null ? getMinElement(node.getLeft()) : node;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int size(T data) {
		BSTNode<T> node = searchNode(data);
		return size(node);
	}

	private BSTNode<T> searchNode(T data) {
		return searchNode(this.root, data);
	}

	private BSTNode<T> searchNode(BSTNode<T> root, T data) {
		if (root == null)
			return null;
		int cmp = data.compareTo(root.getData());
		if (cmp > 0)
			root = searchNode(root.getRight(), data);
		else if (cmp < 0)
			root = searchNode(root.getLeft(), data);
		return root;
	}

	private int size(BSTNode<T> node) {
		if (node == null)
			return 0;
		return 1 + size(node.getLeft()) + size(node.getRight());
	}

	@Override
	public int height() {
		return isEmpty() ? 0 : height(this.root);
	}

	private int height(BSTNode<T> node) {
		if (node == null)
			return -1;
		return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
	}

	@Override
	public boolean isEmpty() {
		return this.root == null;
	}

	@Override
	public boolean contains(T data) {
		BSTNode<T> node = searchNode(data);
		return node == null;
	}

	@Override
	public List<T> preOrderTraverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> inOrderTraverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> postOrderTraverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> bfsTraverse() {
		// TODO Auto-generated method stub
		return null;
	}

}
