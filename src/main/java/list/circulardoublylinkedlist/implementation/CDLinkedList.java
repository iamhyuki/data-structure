package list.circulardoublylinkedlist.implementation;

/**
 * CircularDoublyLinkedList(이중원형연결리스트)
 * : 이중연결리스트와 원형연결리스트를 합친 개념이다.
 * 
 * 특징 : 각 노드가 이전 노드와 다음 노드를 가리키는 동시에 마지막 노드는 첫번째 노드를 가리키는 구조
 * 양방향으로 순회가 가능하며 꼬리에 꼬리를 문다고 생각하면 된다.
 * head 대신 last가 있다.
 * 
 * ps. 자료구조를 익히기 위해 유튜브 자료로 구현했다.
 * 학습을 조금 더 한 뒤에 코드 개선할 예정!
 * */
public class CDLinkedList<E> implements ICircleDoublyLinkedList<E> {
	public CDNode<E> last;
	public int size;

	public CDLinkedList() {
		last = null;
		size = 0;
	}

	@Override
	public boolean search(E data) {
		CDNode<E> pointer = last;
		for (int i = 0; i < size; i++) {
			if (data == pointer.data) {
				return true;
			}
			pointer = pointer.rightLink;
		}
		return false;
	}

	public CDNode<E> findNode(E data) {
		CDNode<E> pointer = last;
		for (int i = 0; i < size; i++) {
			if (data == pointer.data) {
				return pointer;
			}
			pointer = pointer.rightLink;
		}
		return null;

	}

	@Override
	public void insertAfter(E target, E data) {
		CDNode<E> newNode = new CDNode<E>(null, data, null);
		if (last == null) {
			newNode.rightLink = newNode;
			newNode.leftLink = newNode;
			last = newNode;
		} else {
			if (search(target)) {
				CDNode<E> t = findNode(target);
				CDNode<E> p = t.rightLink;
				t = p.leftLink;

				newNode.leftLink = t;
				newNode.rightLink = p;
				t.rightLink = newNode;
				p.leftLink = newNode;
			}
		}
		size++;
	}

	@Override
	public void insertPrevious(E target, E data) {
		CDNode<E> newNode = new CDNode<E>(null, data, null);
		if (last == null) {
			newNode.rightLink = newNode;
			newNode.leftLink = newNode;
			last = newNode;
		} else {
			if (search(target)) {
				CDNode<E> t = findNode(target);
				CDNode<E> p = t.leftLink;
				t = p.rightLink;

				newNode.leftLink = p;
				newNode.rightLink = t;
				p.rightLink = newNode;
				t.leftLink = newNode;
				if (t == last) {
					last = newNode;
				}
			}
		}
		size++;
	}

	@Override
	public void insertFront(E data) {
		CDNode<E> newNode = new CDNode<E>(null, data, null);
		if (last == null) {
			newNode.rightLink = newNode;
			newNode.leftLink = newNode;
			last = newNode;
		} else {
			CDNode<E> p = last.leftLink;
			p.rightLink = last;

			newNode.leftLink = p;
			newNode.rightLink = last;
			p.rightLink = newNode;
			last.leftLink = newNode;

			last = newNode;
		}
		size++;
	}

	@Override
	public void insertLast(E data) {
		CDNode<E> newNode = new CDNode<E>(null, data, null);
		if (last == null) {
			newNode.rightLink = newNode;
			newNode.leftLink = newNode;
			last = newNode;
		} else {
			CDNode<E> p = last.leftLink;
			p.rightLink = last;

			newNode.leftLink = p;
			newNode.rightLink = last;
			p.rightLink = newNode;
			last.leftLink = newNode;
		}
		size++;
	}

	@Override
	public void removeAfter(E target) {
		CDNode<E> t = findNode(target);
		if (last == null) {
			System.out.println("no data");
		} else if (size == 1) {
			last = null;
			size--;
		} else {
			CDNode<E> p = t.rightLink.rightLink;
			t=p.leftLink.leftLink;
			t.rightLink = p;
			p.leftLink = t;
			size--;
		}
	}

	@Override
	public void removePrevious(E target) {
		CDNode<E> t = findNode(target);
		if (last == null) {
			System.out.println("no data");
		} else if (size == 1) {
			last = null;
			size--;
		} else {
			CDNode<E> p = t.leftLink.leftLink;
			t=p.rightLink.rightLink;
			
			p.rightLink = t;
			t.leftLink = p;
			size--;
		}
	}

	@Override
	public void printAll() {
		if(last==null) {
			System.out.println("no data");
		} else {
			System.out.print("List = [");
			for(int i=0; i<size; i++) {
				System.out.print(last.data + ", ");
				last = last.rightLink;
			}
			System.out.println("]");
		}
	}

}
