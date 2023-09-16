package edu.java.journal.datastructure.binarytrees;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeBreadthFirstTraversal {

	public <T> void print(BinaryNode<T> tree) {
		System.out
				.println("Binary Tree: Breadth First Traversal - Level Order");
		Queue<BinaryNode<T>> queue = new ArrayDeque<>();
		queue.add(tree);

		while (!queue.isEmpty()) {
			BinaryNode<T> current = queue.poll();
			System.out.print(current.getElement() + "\t");
			if (current.getLeft() != null) {
				queue.add(current.getLeft());
			}
			if (current.getRight() != null) {
				queue.add(current.getRight());
			}
		}
		return;
	}

}
