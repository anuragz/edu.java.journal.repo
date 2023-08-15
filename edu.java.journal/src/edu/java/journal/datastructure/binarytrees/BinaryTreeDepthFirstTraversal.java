package edu.java.journal.datastructure.binarytrees;

public class BinaryTreeDepthFirstTraversal {
	
	public <T> void printDFSPreOrder(BinaryNode<T> tree) {
		System.out.println("Binary Tree: Depth First Traversal - Pre Order");
		dftPreOrder(tree);
		return;
	}
	
	public <T> void dftPreOrder(BinaryNode<T> tree) {
		if(tree!=null) {
			System.out.print(tree.getElement()+"\t");
			dftPreOrder(tree.getLeft());
			dftPreOrder(tree.getRight());
		}
		return;
	}

	
	public <T> void printDFSInOrder(BinaryNode<T> tree) {
		System.out.println("Binary Tree: Depth First Traversal - In Order");
		dftInOrder(tree);
		return;
	}
	
	public <T> void dftInOrder(BinaryNode<T> tree) {
		if(tree!=null) {			
			dftInOrder(tree.getLeft());
			System.out.print(tree.getElement()+"\t");
			dftInOrder(tree.getRight());
		}
		return;
	}
	
	public <T> void printDFSPostOrder(BinaryNode<T> tree) {
		System.out.println("Binary Tree: Depth First Traversal - Post Order");
		dftPostOrder(tree);
		return;
	}
	
	public <T> void dftPostOrder(BinaryNode<T> tree) {
		if(tree!=null) {			
			dftPostOrder(tree.getLeft());			
			dftPostOrder(tree.getRight());
			System.out.print(tree.getElement()+"\t");
		}
		return;
	}
}
