package edu.java.journal.datastructure.trees;

public class BinaryTreeOpereationsDemo {

	public static void main(String[] args) {
		BinaryTreeOpereationsDemo demo = new BinaryTreeOpereationsDemo();
		BinaryTreeNode btn = demo.createBinaryTree();
		demo.printBinaryTree(btn);
	}

	void addNodeInBinaryTree() {
		return;
	}

	BinaryTreeNode createBinaryTree() {
		BinaryTreeNode btn = new BinaryTreeNode(0);
		BinaryTreeNode left = new BinaryTreeNode(1);
		BinaryTreeNode right = new BinaryTreeNode(2);
		btn.setLeft(left);
		btn.setRight(right);

		left.setLeft(new BinaryTreeNode(3));
		left.setRight(new BinaryTreeNode(4));

		right.setLeft(new BinaryTreeNode(5));
		right.setRight(new BinaryTreeNode(6));

		return btn;
	}

	void deleteNodeInBinaryTree() {
		return;
	}

	// In-order traversal
	void printBinaryTree(BinaryTreeNode btn) {
		if (null == btn) {
			return;
		}
		printBinaryTree(btn.left);
		System.out.print("\t" + btn.value);
		printBinaryTree(btn.right);

	}

}
