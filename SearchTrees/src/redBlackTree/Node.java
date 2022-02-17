package redBlackTree;

public class Node<Key extends Comparable<Key>, Value> {
	
	public Key key;             			// the node's key 
	public Value value;            			// the value associated with the key
	public Node<Key, Value> left, right;    // references to left and right child
	public boolean color;					// the node's color
	
	/* Node constructor */
	public Node(Key key, Value value, boolean color) {
		this.key = key;
		this.value = value;
		this.color = color;
	}
	 
}

