package stack.linkedlist.implementation;

public class Node<E> {
	public E data;
	public Node<E> link;
	
	public Node(E data) {
		this.data = data;
		this.link = null;
	}
	
}
