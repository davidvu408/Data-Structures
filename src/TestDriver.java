
public class TestDriver {

	public static void main(String[] args) {
		//testStack();
		//testQueue();
		testBinarySearchTree();
	}
	
	// Tests methods and functionality of Stack.java
	private static void testStack() {
		Stack<String> stack = new Stack<String>();
		System.out.println("Stack created. Current stack: " + stack);
		stack.push("David");
		System.out.println("Added 'David' to stack");
		stack.push("Jouie");
		System.out.println("Added 'Jouie' to stack");
		stack.push("Josh");
		System.out.println("Added 'Josh' to stack");
		System.out.println("Current stack: " + stack);
		System.out.println("Peek stack: " + stack.peek());
		System.out.println("Popped stack, element removed: " + stack.pop() + ". Current stack: " + stack);
		System.out.println("Popped stack, element removed: " + stack.pop() + ". Current stack: " + stack);
		System.out.println("Popped stack, element removed: " + stack.pop() + ". Current stack: " + stack);
	}
	
	// Tests methods and functionality of Queue.java
	private static void testQueue() {
		Queue<String> queue = new Queue<String>();
		System.out.println("Queue created. Current queue: " + queue);
		queue.enqueue("Customer 1");
		System.out.println("Added 'Customer 1' to queue");
		System.out.println("Current queue: " + queue);
		queue.enqueue("Customer 2");
		System.out.println("Added 'Customer 2' to queue");
		System.out.println("Current queue: " + queue);
		queue.enqueue("Customer 3");
		System.out.println("Added 'Customer 3' to queue");
		System.out.println("Current queue: " + queue);
		System.out.println("Peek stack: " + queue.peek());
		System.out.println("Dequeued queue, element removed: " + queue.dequeue() + ". Current queue: " + queue);
		System.out.println("Dequeued queue, element removed: " + queue.dequeue() + ". Current queue: " + queue);
		System.out.println("Dequeued queue, element removed: " + queue.dequeue() + ". Current queue: " + queue);
	}

	private static void testBinarySearchTree() {
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		BST.insert(new Integer(0));
		BST.insert(new Integer(-5));
		BST.insert(new Integer(7));
		BST.insert(new Integer(3));
		BST.insert(new Integer(2));
		BST.insert(new Integer(1));
		BST.insert(new Integer(9));
		System.out.println(BST.contains(new Integer(3)));
	}
	
	private static void testLinkedList() {
		LinkedList linkedList = new LinkedList();
	}
}
