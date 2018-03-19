/**
 * 
 * @author David Vu
 * A Queue represents a First-In-First-Out linear data structure
 * Note: This is a Linked List implementation
 */
public class Queue<E> {

	private class Node {
		E data;
		Node next;
		private Node(E data) {  this.data = data; }
		public String toString() {return "" + this.data;} 
	}
	
	private Node head; // Remove element from head of Queue
	private Node tail; // Add element to end (tail) of Queue
	
	public Queue() {
		head = null;
		tail = null;
	}
	
	/**
	 * Adds element to end (tail) of queue
	 * @param data - Data of element to be added
	 */
	public void enqueue(E data) {
		Node node = new Node(data);
		if(isEmpty()) {
			head = node;
			tail = node;
			return;
		} 
		tail.next = node;
		tail = node;
	}
	
	/**
	 * Removes head element from queue
	 * @return - Element that was removed
	 */
	public Node dequeue() {
		// If Queue is empty
		if(isEmpty()) {throw new RuntimeException("Error: Queue is empty");}
		// If Queue has 1 element
		if(head.next == null) {
			Node head = this.head;
			this.head = null;
			this.tail = null;
			return head;
		}
		// Otherwise change head to next node, effectively removing the previous head element from the queue
		Node head = this.head;
		this.head = this.head.next;
		return head;
	}
	
	/**
	 * Returns the head element of the queue without removing it 
	 * @return - Head element of queue
	 */
	public Node peek() {return head;}
	
	/**
	 * Tests if queue is empty
	 * @return - True if queue is empty, false otherwise
	 */
	public boolean isEmpty() {return head == null;}
	
	public String toString() {
		if(isEmpty()) {return "Queue is empty";}
		String str = "";
		Node index = head;
		while(true) {
			str += index.toString();
			if(index.next != null) {
				str += ", ";
				index = index.next;
			} else {break;}
		}
		return str;
	}
}
