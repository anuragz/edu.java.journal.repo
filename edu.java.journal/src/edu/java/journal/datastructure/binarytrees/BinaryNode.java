package edu.java.journal.datastructure.binarytrees;

public class BinaryNode<T> {

	private final T element;

	private BinaryNode<T> left;

	private BinaryNode<T> right;

	public BinaryNode(BinaryNode<T> left, BinaryNode<T> right, T element) {
		this.element = element;
		this.left = left;
		this.right = right;
	}

	public BinaryNode(T element) {
		this.element = element;
		this.left = null;
		this.right = null;
	}

	public T getElement() {
		return element;
	}

	public BinaryNode<T> getLeft() {
		return left;
	}

	public BinaryNode<T> getRight() {
		return right;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}

}
