package list.linkedlist.implemetation;

/**
 * LinkedList
 * 
 * 특징 : 각각의 엘리먼트들이 흩어져 있으며 연결되어 있다. 각각의 노드들은 데이터와 다음노드를 가르키는 참조값으로 이뤄져있다.
 * 
 * 장점 : 추가(삭제) 시 node의 위치의 이전, 이후 노드의 참조값만 변경하면 되기에 속도가 빠르다. 단점 : 데이터 조회 시, 모든
 * 요소를 탐색해야 한다.
 * 
 */
public class LinkedList {
	// 첫번째 노드 head , 마지막 노드 tail
	private Node head;
	private Node tail;
	private int size;

	private class Node {
		// 데이터가 저장될 변수
		private Object data;
		// 다음 노드를 가리키는 변수
		private Node next;

		public Node(Object input) {
			this.data = input;
			this.next = null;
		}

		// 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
		@Override
		public String toString() {
			return String.valueOf(this.data);
		}
	}

	public void addFirst(Object input) {
		Node newNode = new Node(input);
		// 새로운 노드의 다음 노드로 헤드 지정
		newNode.next = head;
		// 헤드를 새로운 노드로 지정
		head = newNode;
		size++;
		if (head.next == null) {
			tail = head;
		}
	}

	public void addLast(Object input) {
		Node newNode = new Node(input);
		// 리스트의 노드가 없을 시 첫번째 노드를 추가하는 메소드를 사용
		if (size == 0) {
			addFirst(input);
		} else {
			// 마지막 노드의 다음 노드로 생성한 노드를 지정
			tail.next = newNode;
			// 마지막 노드를 생성한 노드로 지정(갱신)
			tail = newNode;
			size++;
		}
	}

	public void add(int k, Object input) {
		// 리스트의 노드가 없을 시 첫번쨰 노드를 추가하는 메소드를 사용
		if (k == 0) {
			addFirst(input);
		} else {
			Node temp1 = node(k - 1);
			// k번째 노드를 temp2로 지정
			Node temp2 = temp1.next;
			Node newNode = new Node(input);
			// temp1의 다음 노드로 새로운 노드를 지정
			temp1.next = newNode;
			// 새로운 노드의 다음 노드로 temp2를 지정
			newNode.next = temp2;
			size++;
			// 새로운 노드의 다음 노드가 없다면 마지막 노드이므로 tail로 지정
			if (newNode.next == null) {
				tail = newNode;
			}
		}
	}

	// Test를 위해 public으로 사용.
//	public 
	private Node node(int index) {
		Node x = head;

		for (int i = 0; i < index; i++) {
			x = x.next;
		}

		return x;
	}

	@Override
	public String toString() {
		// 노드가 없을 시 [] 리턴
		if (head == null) {
			return "[]";
		}
		Node temp = head;
		String str = "[";
		// 다음 노드가 없을 때까지 반복문 실행
		while (temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}
		// 마지막 노드는 다음 노드가 없기 때문에 별도로 출력결과에 포함.
		str += temp.data;

		return str + "]";
	}

	public Object removeFirst() {
		// 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경
		Node temp = head;
		head = head.next;
		Object returnData = temp.data;
		temp = null;
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
			if (todoDeleted == tail) {
				tail = temp;
			}
			todoDeleted = null;
			size--;
			return returnData;
		}
	}

	// tail 값만 삭제하면 되는 것 아닐까? but, tail의 이전 노드의 next 값을 지워줘야 한다.
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

		public boolean hasNext() {
			return nextIndex < size();
		}

		public void add(Object input) {
			Node newNode = new Node(input);

			if (lastReturned == null) {
				head = newNode;
				newNode.next = next;
			} else if (nextIndex == size) {
				tail = newNode;
				lastReturned.next = newNode;
			} else {
				lastReturned.next = newNode;
				newNode.next = next;
			}

			lastReturned = newNode;
			nextIndex++;
			size++;
		}

		public void remove() {
			if (nextIndex == 0) {
				throw new IllegalStateException();
			}
			LinkedList.this.remove(nextIndex - 1);
			nextIndex--;
		}
	}
}
