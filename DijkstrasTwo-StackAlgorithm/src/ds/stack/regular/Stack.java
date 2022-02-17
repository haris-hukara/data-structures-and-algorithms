package ds.stack.regular;

public class Stack<Item> {
	private Node<Item> top;
	private int length;

	// Constructor 	
	public Stack() {
		this.top = null;
		this.length = 0;
	}
	
	/* Push an item onto the stack */
	public void push(Item item) {
		Node<Item> newNode = new Node<Item>();  // 1
		newNode.data = item; 				    // 1
		newNode.next = top; 				    // 2
		top = newNode; 						    // 3
		length++;								// 4
	}
	
	/* Check if the stack is empty */
	public boolean isEmpty() {
		return top == null;
	}
	
	/* Remove the top item from the stack, and return its data */
	public Item pop() {														
		if (isEmpty()) {													// 1
			throw new IndexOutOfBoundsException("The stack is empty.");		// 1
		}																	// 1
		Item item = top.data; 												// 2
		top = top.next; 													// 3
		length--;															// 4
		return item; 														// 5
	}
	
	/* Return the current size of the stack */
	public int size() {
		return length;
	}
}


