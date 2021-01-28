package queue.implementation;

/**
 * LinkedQueue 링크드리스트를 이용한 Queue 구현하기
 * 
 * 특징. 배열로 구현하는 queue에 비해 쉽다! -> 일반적으로 용적(배열크기)에 제한이 없다.
 * 
 */
public class LinkedQueue<E> implements Queue<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;

	public LinkedQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public boolean offer(E value) {
		Node<E> newNode = new Node<E>(value);

		if (size == 0) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
		size++;

		return true;
	}

	@Override
	public E poll() {
		if (size == 0) {
			return null;
		}
		E element = head.data;
		head = head.next;

		return element;
	}

	@Override
	public E peek() {
		if (head == null) {
			return null;
		}
		return head.data;
	}

	@Override
	public String toString() {
		if (head == null) {
			return "[]";
		}
		Node<E> temp = head;
		String str = "[";

		while (temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}
		str += temp.data;

		return str += "]";
	}

	public int size() {
		return size;
	}

	public void clear() {
		for (Node<E> x = head; x != null;) {

			Node<E> next = x.next;
			x.data = null;
			x.next = null;
			x = next;
		}
		size = 0;
		head = tail = null;
	}

	public boolean isEmpty() {
		return size == 0;
	}

}
