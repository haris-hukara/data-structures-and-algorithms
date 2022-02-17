package main;


	public class DoublyLinkedList{
		private ListNode head;
		private ListNode tail;
		private int size;
		
		// the ListNode class is inside of DoublyLinkedList so private data could be used
		// did not use generic class here
		private class ListNode {
			private int data;
			private ListNode next;
			private ListNode previous;
			
			public ListNode(int data) {
				this.data = data;
			}
			
		}
		
		// constructor
		public DoublyLinkedList() {
			this.head = null;
			this.tail = null;
			this.size = 0;
		}

		public boolean isEmpty() {
			return head == null; // if head is null list is empty
		}

		public int size() {
			return size;
		}
		

		public void addFront(int value) {
			ListNode newNode = new ListNode(value);  // creating new node

			if(isEmpty()) {							 
				tail = newNode;
			}else {
				head.previous = newNode;			
			}
			newNode.next = head;
			head = newNode;
			size++;
		}
		

		public void addRear(int value) {
			ListNode newNode = new ListNode(value);
			if(isEmpty()) {
				head = newNode;
			}else {
				tail.next = newNode;
			}
			newNode.previous = tail;
			tail = newNode;
			size++;
		}


		public ListNode deleteFirst() {
			if(isEmpty()){
				throw new IndexOutOfBoundsException("The linked list is empty.");
			}
			ListNode temp = head;
			if(head == tail) {
				tail = null;
			}else {
				head.next.previous = null;
			}
			head = head.next;
			temp.next = null;
			size--;
			return temp;
		}

		public ListNode deleteLast() {
			if(isEmpty()){
				throw new IndexOutOfBoundsException("The linked list is empty.");
			}
			ListNode temp = tail;
			if (head == tail ) {
				head = null;
			}else {
				tail.previous.next = null;
			}
			tail = tail.previous;
			temp.previous = null;
			size--;
			return temp;
	}
	
		public static void main(String[] args) {
			DoublyLinkedList list = new DoublyLinkedList();
			
			list.addRear(0);;
			System.out.println("done");
		}
		
	}

