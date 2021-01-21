package list.circulardoublylinkedlist.implementation;

public interface ICircleDoublyLinkedList<E> {
	public boolean search(E data);
	public void insertAfter(E target, E data);
	public void insertPrevious(E target, E data);
	public void insertFront(E data);
	public void insertLast(E data);
	public void removeAfter(E target);
	public void removePrevious(E target);
	public void printAll();
}
