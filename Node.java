package java_main;

public class Node<E> {

    private E element;            // reference to the element stored at this node
    private Node<E> next;         // reference to the subsequent node in the list
    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e) {
    	element = e;
      next = null;
    }
    
    public Node(E e, Node<E> n) {
    	element = e;
      next = n;
    }
        
    // Accessor methods
    public E getElement() { return element; }
    public Node<E> getNext() { return next; }
    // Modifier methods
    public void setNext(Node<E> n) { next = n; }
  } //----------- end of nested Node class -----------