package list.doublylinkedlist.implemetation;

/**
 * DoublyLinkedList
 * 
 * 특징 : 한마디로 표현하자면 양방향!(LinkedList(단순연결리스트)를 기반으로 약간의 변형이다.)
 * 
 * 장점 : 단순연결리스트에 비해 탐색의 효율이 높다. 단점 : 더 많은 메모리를 사용한다.
 * 
 */
public class DoublyLinkedList {
	private Node head;
	private Node tail;
	private int size;

	private class Node {
		private Object data;
		private Node next;
		private Node prev;

		public Node(Object input) {
			this.data = input;
			this.next = null;
			this.prev = null;
		}

		@Override
		public String toString() {
			return String.valueOf(this.data);
		}
	}

	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;
		size++;
		if (head.next == null) {
			tail = head;
		}
	}

	public void addLast(Object input) {
		Node newNode = new Node(input);
		if (size == 0) {
			addFirst(input);
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			size++;
		}
	}

	public void add(int k, Object input) {
		if (k == 0) {
			addFirst(input);
		} else {
			Node temp1 = node(k - 1);
			Node temp2 = temp1.next;
			Node newNode = new Node(input);
			temp1.next = newNode;
			newNode.next = temp2;
			if (temp2 != null) {
				temp2.prev = newNode;
			}
			newNode.prev = temp1;
			size++;
			if (newNode.next == null) {
				tail = newNode;
			}
		}
	}

	private Node node(int index) {
		if (index < size / 2) {
			Node x = head;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			return x;
		} else {
			Node x = tail;
			for (int i = size - 1; i > index; i--) {
				x = x.prev;
			}
			return x;
		}
	}

	@Override
	public String toString() {
		if (head == null) {
			return "[]";
		}
		Node temp = head;
		String str = "[";
		while (temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}
		str += temp.data;

		return str + "]";
	}

	public Object removeFirst() {
		// 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경
		Node temp = head;
		head = head.next;
		Object returnData = temp.data;
		temp = null;
		if (head != null) {
			head.prev = null;
		}
		size--;
		return returnData;
	}

	public Object remove(int k) {
		if (k == 0) {
			return removeFirst();
		} else {
			Node temp = node(k - 1);
			Node todoDeleted = temp.next;
			Object returnData = todoDeleted.data;
			temp.next = todoDeleted.next;
			if (temp.next != null) {
				temp.next.prev = temp;
			}
			if (todoDeleted == tail) {
				tail = temp;
			}
			todoDeleted = null;
			size--;
			return returnData;
		}
	}

	public Object removeLast() {
		return remove(size - 1);
	}

	public int size() {
		return size;
	}

	public Object get(int k) {
		Node temp = node(k);
		return temp.data;
	}

	public int indexOf(Object data) {
		Node temp = head;
		// 탐색 대상이 몇번째 엘리먼트에 있는지 의미하는 변수 index
		int index = 0;
		while (temp.data != data) {
			temp = temp.next;
			index++;
			// 탐색 대상이 없을 경우 -1 반환
			if (temp == null) {
				return -1;
			}
		}
		return index;
	}

	public ListIterator listIterator() {
		return new ListIterator();
	}

	public class ListIterator {
		private Node next;
		private Node lastReturned;
		private int nextIndex;

		public ListIterator() {
			next = head;
		}

		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}

		public Object prev() {
			if (next == null) {
				lastReturned = next = tail;
			} else {
				lastReturned = next = next.prev;
			}
			nextIndex--;
			return lastReturned.data;
		}

		public boolean hasNext() {
			return nextIndex < size();
		}

		public boolean hasPrev() {
			return nextIndex > 0;
		}

		public void add(Object input) {
			Node newNode = new Node(input);

			if (lastReturned == null) {
				head = newNode;
				newNode.next = next;
			} else {
				lastReturned.next = newNode;
				newNode.prev = lastReturned;
				if (next != null) {
					newNode.next = next;
					next.prev = newNode;
				} else {
					Node temp = tail;
					tail = newNode;
					tail.prev = temp;
					lastReturned.next = newNode;
				}
			}
			lastReturned = newNode;
			nextIndex++;
			size++;
		}

		public void remove() {
			if (nextIndex == 0) {
				throw new IllegalStateException();
			}
			Node n = lastReturned.next;
			Node p = lastReturned.prev;

			if (p == null) {
				head = n;
				head.prev = null;
				lastReturned = null;
			} else {
				p.next = n;
				lastReturned.prev = null;
			}
			
			if (n == null) {
				tail = p;
				tail.next = null;
			} else {
				n.prev = p;
			}
			
			if(next == null) {
				lastReturned = tail;
			} else {
				lastReturned = next.prev;
			}

			size--;
			nextIndex--;

		}
	}
}
