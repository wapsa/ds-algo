package edu.sau.stack;

public class StackNode<T extends Comparable<T>> {

	private T data;
	private StackNode<T> nextNode;

	public StackNode(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public StackNode<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(StackNode<T> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}

}
