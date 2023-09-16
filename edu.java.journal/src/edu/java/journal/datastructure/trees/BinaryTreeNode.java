package edu.java.journal.datastructure.trees;

class BinaryTreeNode {

	BinaryTreeNode left;

	BinaryTreeNode right;

	int value;

	public BinaryTreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public int getValue() {
		return value;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
