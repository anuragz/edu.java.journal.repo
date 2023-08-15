package edu.java.journal.datastructure.binarytrees;

public class BinaryTreeTraversalDemo {

	public static void main(String[] args) {
		//Binary tree to store integers
		BinaryNode<Integer> intTree = new BinaryNode<Integer>(40);
		//fill the array
		BinaryNode<Integer> left1 = new BinaryNode<Integer>(47);
		BinaryNode<Integer> left1leftchild = new BinaryNode<Integer>(11);
		BinaryNode<Integer> left1rightchild = new BinaryNode<Integer>(3);
		BinaryNode<Integer> right1 = new BinaryNode<Integer>(45);
		BinaryNode<Integer> right1leftchild = new BinaryNode<Integer>(44);
		
		left1.setLeft(left1leftchild);
		left1.setRight(left1rightchild);
		
		right1.setLeft(right1leftchild);
		
		intTree.setLeft(left1);
		intTree.setRight(right1);
		
		//traversal
		BinaryTreeBreadthFirstTraversal traverasl = new BinaryTreeBreadthFirstTraversal();
		traverasl.print(intTree);
		System.out.println("\n\n\n");
		BinaryTreeDepthFirstTraversal dfsTraverasl = new BinaryTreeDepthFirstTraversal();
		dfsTraverasl.printDFSPreOrder(intTree);
		System.out.println("\n\n\n");
		dfsTraverasl.printDFSInOrder(intTree);
		System.out.println("\n\n\n");
		dfsTraverasl.printDFSPostOrder(intTree);
		
		}

}
