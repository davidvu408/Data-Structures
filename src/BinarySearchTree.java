/**
 * 
 * @author David Vu
 * Binary Search Tree is a tree data structure with the following properties:
 * 1) Each node has at most 2 child nodes and 1 parent node (except the root node)
 * 2) Left subtree of a select node has nodes with values that are "less than or equal to" the select node
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
	
	
	// Checks if BST contains data given
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
	
	// Checks if BST is empty
	public boolean isEmpty() {return root == null;}
	
	/**
	 * Finds minimum value in Binary Search Tree
	 * @return - Node with minimum value in BST, null if BST is empty
	 */
	public Node findMin() {
		if(isEmpty()) { return null; }
		Node current = root;
		// Continuously traverse left subtree until current node has no left child
		while(current.left != null) { current = current.left; } 
		return current;
	}
	
	/**
	 * Finds maximum value in Binary Search Tree
	 * @return - Node with maximum value in BST, null if BST is empty
	 */
	public Node findMax() {
		if(isEmpty()) { return null; }
		Node current = root;
		// Continuously traverse right subtree until current node has no right child
		while(current.right != null) { current = current.right; } 
		return current;
	}
	
	/**
	 * (UNFINISHED)
	 * Finds the successor of Node with given data. The successor is the Node
	 * who's value immediately follows the value in consideration.
	 * @param data - Value to be considered
	 * @return - Returns null if no successor exists. Otherwise, returns the
	 *           successor Node with given data.
	 */
	public Node findSuccessor(T data) {
		return null;
	}
	
	
	// Prints BST using post-order traversal: The root is printed between the values in its left and right subtrees
	public void printInOrderTraversal() {
		if(isEmpty()) { System.out.println("BST is empty"); }
		printInOrderTraversalHelper(root);
	}
	
	// Helper method for printInOrderTraversal()
	private void printInOrderTraversalHelper(Node current) {
		if(current.left != null) {
			printInOrderTraversalHelper(current.left);
		}
		
		System.out.println(current.data);
		
		if(current.right != null) {
			printInOrderTraversalHelper(current.right);
		}
	}
	
	// Prints BST using post-order traversal: The root is printed before the values in its subtrees
	public void printPreOrderTraversal() {
		if(isEmpty()) { System.out.println("BST is empty"); }
		printPreOrderTraversalHelper(root);
	}
	
	// Helper method for printPreOrderTraversalHelper()
	private void printPreOrderTraversalHelper(Node current) {
		System.out.println(current.data);
		if(current.left != null) {
			printPreOrderTraversalHelper(current.left);
		}
		
		if(current.right != null) {
			printPreOrderTraversalHelper(current.right);
		}
	}
	
	// Prints BST using post-order traversal: The root is printed after the values in its subtrees
	public void printPostOrderTraversal() {
		if(isEmpty()) { System.out.println("BST is empty"); }
		printPostOrderTraversalHelper(root);
	}
	
	// Helper method for printPostOrderTraversal()
	private void printPostOrderTraversalHelper(Node current) {
		if(current.left != null) {
			printPreOrderTraversalHelper(current.left);
		}
		
		if(current.right != null) {
			printPreOrderTraversalHelper(current.right);
		}
		
		System.out.println(current.data);
	}
	
	private class Node {
		private T data;
		private Node left;
		private Node right;
		private Node parent;
		private Node(T data) {
			this.data = data;
			left = null;
			right = null;
			parent = null;
		}
	}
}
