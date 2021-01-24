package stack.linkedlist.implementation;

interface Stack<E> {
	boolean isEmpty();
	void push(E item);
	E pop();
	void clear();
	E peek();
}

/**
 * LinkedListStack 링크드리스트로 stack을 구현해보았다!
 * 
 * 특징 : 배열 기반의 스택인 ArrayList와는 다르게 스택의 용량이나 최상위 노드의 인덱스가 없다.
 * 
 */
public class LinkedListStack<E> implements Stack<E> {
	private Node<E> top;

	@Override
	public boolean isEmpty() {
		return (top == null);
	}

	@Override
	public void push(E item) {
		Node<E> newNode = new Node<>(item);
		newNode.link = top;
		top = newNode;
	}

	@Override
	public E pop() {
		if(isEmpty()) {
			throw new NullPointerException();
		} else {
			E item = top.data;
			top = top.link;
			return item;
		}
	}

	@Override
	public void clear() {
		top = null;
	}

	@Override
	public E peek() {
		if(isEmpty()) {
			throw new NullPointerException();
		} else {
			return top.data;
		}
	}

	@Override
	public String toString() {
		if(isEmpty()) {
			return "Stack is empty";
		} else {
			Node<E> temp = top;
			String str = "[ ";
			while(temp != null) {
				str += temp.data + ", ";
				temp = temp.link;
			}
			return str +=" ]";
		}
	}
}
