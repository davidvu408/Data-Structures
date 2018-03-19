/**
 * 
 * @author David Vu
 * Binary Search Tree is a tree data structure with the following properties:
 * 1) Each node has at most 2 child nodes
 * 2) Left subtree of a select node has nodes with values that are "less than" the select node
 * 3) Right subtree of a select node has nodes with values that are "greater than" the select node
 * 
 * Balanced vs. unbalanced
 */

public class BinarySearchTree<T extends Comparable<T>>  {

	//Inorder, preorder, post order traversal
	// Inorder traversal: Left then current node then right now (printed in order)
	// Preorder traversal: current, left, right
	// Postorder traversal: left, right, current
	
	Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	/**
	 * Inserts new element with given data to binary search tree
	 * @param data - Data of element to be added
	 */
	public void insert(T data) {
		Node node = new Node(data);
		// If BST is empty make the node the root element
		if(isEmpty()) {  root = node; }
		else {
			// If BST has 1 or more elements
			insertHelper(root, data);
		}
		
	}
	
	// Helper function for insert(E data)
	private void insertHelper(Node current, T data) {
		if(data.compareTo(current.data) <= 0) {
			if(current.left == null) {
				current.left = new Node(data);
				return;
			} else {
				insertHelper(current.left, data);
			}
		} else {
			// data > current.data
			if(current.right == null) {
				current.right = new Node(data);
			} else {
				insertHelper(current.right, data);
			}
		}
	}
	
	public boolean contains(T data) {
		if(isEmpty()) {return false;}
		if(root.data == data) {return true;}
		return containsHelper(this.root, data);
	}
	
	// Helper function for insert(E data)
	private boolean containsHelper(Node current, T data) {
		if(data.compareTo(current.data) == 0) {return true;}
		else if(data.compareTo(current.data) < 0) {
			if(current.left == null) {return false;}
			else {containsHelper(current.left, data);}
		} else {
			// data.compareTo(current.data) > 0
			if(current.right == null) {return false;} 
			else {containsHelper(current.right, data);}
		}
		return false;
	}
	
	public boolean isEmpty() {return root == null;}
	
	private class Node {
		private T data;
		private Node left;
		private Node right;
		private Node(T data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
}
