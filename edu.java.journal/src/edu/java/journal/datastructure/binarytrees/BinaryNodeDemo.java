package edu.java.journal.datastructure.binarytrees;

public class BinaryNodeDemo {

	public static void main(String[] args) {
		//Binary tree to store integers
		BinaryNode<Integer> intTree = new BinaryNode<Integer>(40);
		System.out.println("BinaryNode<Integer>");
		System.out.println(intTree.getElement());
				
		System.out.println("\n\n");
		//Binary tree to store string
		BinaryNode<String> strTree = new BinaryNode<String>("Zero");
		System.out.println("BinaryNode<String>");
		System.out.println(strTree.getElement());
		}

}
