package edu.java.journal.datastructure.binarytrees;

public class BinaryNode<T> {

	private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	private final T element;
	
	public BinaryNode(T element) {
		this.element = element;
		this.left = null;
		this.right = null;
	}
	
	public BinaryNode(BinaryNode<T> left, BinaryNode<T> right, T element) {
		this.element = element;
		this.left = left;
		this.right = right;
	}

	public BinaryNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}

	public BinaryNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}

	public T getElement() {
		return element;
	}
	
}
