/**
 * 
 * @author David Vu 
 * A Linked List represents a contiguous, dynamic and linear type of data structure 
 * Advantages: Dynamic size, easy insertion/deletion 
 * Disadvantages: Linear search is required to access any node,
 * 				  extra memory required for pointer of each node
 * 
 *  ** UNFINISHED **
 */
public class LinkedList<E> {

	private class Node {
		private Node next;
		private E data;
		private Node(E data) {
			this.data = data;
		}
		public String toString() {return "" + this.data;}
	}
	
	private Node head;
	private Node tail;
	
	/**
	 * Adds an element to end (tail) of Linked List
	 * @param data - Data of element to be added
	 */
	public void append(E data) {
		Node node = new Node(data);
		// If Linked List is empty then set it as the head and tail
		if(isEmpty()) {
			head = node;
			tail = node;
			return;
		}
		// If Linked List has one or more elements then set it as the new tail
		tail.next = node;
		tail = node;
	}
	
	/**
	 * Adds an element to beginning of Linked List 
	 * @param data - Data of element to be added
	 */
	public void prepend(E data) {
		Node node = new Node(data);
		// If Linked List is empty then set it as the head and tail
				if(isEmpty()) {
					head = node;
					tail = node;
					return;
		}
		// If Linked List has one or more elements then set it as the new head
		node.next = head;
		head = node;
	}
	
	/**
	 * Delete first instance of Node with the same data as the argument 
	 * @param data - Data of Node to be removed from the Linked List
	 * @return - Node that was removed, null if Linked List is empty
	 */
	public Node deleteFirstInstance(E data) {
		if(isEmpty()) {return null;}
		Node index = head;
		do {
			if(index.data == data) {
				Node removedNode = index.next;
				index.next = index.next.next;
				return removedNode;
			}
			index = index.next;
		} while (index != null);
		return null;
	}
	
	public boolean isEmpty() { return this.head == null; }
	
	
}
