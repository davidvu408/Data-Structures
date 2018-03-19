
/**
 * 
 * @author David Vu
 * A Stack represents a Last-In-First-Out linear data structure
 * Note: This is a Linked List implementation
 */
public class Stack<E> {
	
	private class Node {
		private E data;
		private Node next;
		private Node(E data) {this.data = data;}
		public String toString() {return "" + this.data;}
	}

	private Node head; // Represents the object at the top of the stack
	
	public Stack() {
		this.head = null;
	}
	
	/**
	 * Adds the specified element to the top of the stack
	 * @param obj - Element to be added
	 */
	public boolean push(E data) {
		Node node = new Node(data);
		node.next = head;
		this.head = node;
		return true;
	}
	
	/**
	 * Removes the topmost element (head) from the stack
	 * @return - Element that was removed
	 */
	public Node pop() {
		// If stack is empty
		if (isEmpty()) { throw new RuntimeException("Error: Stack is empty");}
		// If stack is just 1 element
		if(this.head.next == null) {
			Node head = this.head;
			this.head = null;
			return head;
		} 
		// Otherwise set head to next node
		head = head.next;
		return head;
	}
	
	/**
	 * Returns the topmost element (head) of the stack without removing it
	 * @return - Head of stack
	 */
	public E peek() { return head.data; }
	
	/**
	 * Determines if stack is empty
	 * @return - True if stack is empty, false if stack is not empty
	 */
	public boolean isEmpty() { return head == null; }

	/**
	 * Returns a String with all of the Stack's data
	 */
	public String toString() {
		if(isEmpty()) {return "Stack is empty";}
		String str = "";
		Node index = head;
		while(true) {
			str += index.data;;
			if(index.next != null) {
				str += ", ";
				index = index.next;
			} else {break;}
		}
		return str;
	}
}
