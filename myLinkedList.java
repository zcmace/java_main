package java_main;



public class myLinkedList<E> {
	// instance variables of the SinglyLinkedList
	private Node<E> head; // refers to the first node of the list (or null if empty)
	private Node<E> tail; // refers to the last node of the list (or null if empty)

	public myLinkedList() { // constructs an initially empty list

	}

	public boolean isEmpty() { // Tests whether the linked list is empty.
		return this.head==(null);

	}

	public void addFront(E e) { // adds element e to the front of the list

		Node<E> temp = head; // stores head in temp node
		head = new Node<E>(e); // adds node with new element
		head.setNext(temp); // replaces original head to next
		if (head.getNext()==(null)) {// check to initialize tail if starting empty list
			tail = head;

		}
	}

	public void addEnd(E e) { // adds element e to the end of the list

		if ((isEmpty())) {
			Node<E> temp = new Node<E>(e);
			head = temp;
			return;

		}
		Node<E> temp = head;
		while(temp.getNext()!= null){
			temp = temp.getNext();
			
		}
		Node<E> newNode = new Node<E>(e);
		temp.setNext(newNode);
		tail = newNode;
		
		
	}

	public E removeFront() { // removes and returns the first element if exist
		Node<E> temp = head; // saves data in head
		head = head.getNext();//head is moved forward
		
		return temp.getElement();// returns element of node removed
		
	}

	public E removeEnd() { // removes and returns the last element if exist

		
		Node<E> secondLast = head;
		while(secondLast.getNext()!= tail) {
			secondLast = secondLast.getNext();
			
		}
		E temp;
		temp = tail.getElement();
		
		tail = secondLast;
		tail.setNext(null);
		return temp;
	}

	public boolean search(E target) {// test if a target element can be found on the list, return ture for yes and
										// false for no
		if (isEmpty()) return false;
		Node<E> temp = head;
		
		while (temp.getNext()!= null) {
			if (temp.getElement() == target) return true;
			temp = temp.getNext();
		}
		return false;
		
	}

	public E findMax() {// find and return the maximum element stored on the list
		if (isEmpty()) return null;
		Node<E> temp = head;
		E max = head.getElement();
		while (temp.getNext()!= null) {
			if ((int)temp.getNext().getElement() > (int)max) {
				max = temp.getNext().getElement();
				
			}
			temp = temp.getNext();
		}
		return max;
		
		
	
		
	}

	public void concatenateList(myLinkedList<E> M) {// attach another linkedList referred by M to the end of this
		if (isEmpty()) {
			return;
		}else { 
			Node<E> temp = tail;
			temp.setNext(M.head);
			tail = M.tail;
			
		}
					
	}

	public E middleElement() {// find and return the element that stored at the middle node of a linkedList
		if (isEmpty()) {
			return null;
		}
		int counter = 1;
		Node<E> count = head;
		while (count.getNext()!= null) {
			counter++;
			count= count.getNext();
			
		}
		int halfIndex = counter/2;
		Node<E> temp = head;
		for( int i =1; i <= halfIndex; i++) {
			temp = temp.getNext();
			
		}
		return temp.getElement();
		
	}

	/**
	 * Produces a string representation of the contents of the list. This exists for
	 * debugging purposes only.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		Node<E> walk = head;
		while (walk != null) {
			sb.append(walk.getElement());
			if (walk != tail)
				sb.append(", ");
			walk = walk.getNext();
		}
		sb.append(")");
		return sb.toString();
	}
}
