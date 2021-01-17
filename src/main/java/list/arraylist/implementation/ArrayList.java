package list.arraylist.implementation;

public class ArrayList {

	// ArrayList 객체 생성
	private int size = 0;
	private Object[] elementData = new Object[100];

	// 데이터에 새로운 데이터 추가(마지막 위치에 추가)
	public boolean addLast(Object element) {
		elementData[size] = element;
		size++;
		return true;
	}

	// List 중간에 데이터 추가
	public boolean add(int index, Object element) {
		// 엘리먼트 중간에 데이터를 추가하기 위해서는 끝의 엘리먼트부터 index의 노드까지 뒤로 한칸씩 이동시켜야 한다.
		for (int i = size - 1; i >= index; i--) {
			elementData[i + 1] = elementData[i];
		}

		// index에 노드를 추가
		elementData[index] = element;

		// 엘리먼트의 숫자를 1 증가시킨다.
		size++;

		return true;
	}

	// List 처음에 데이터 추가
	public boolean addFirst(Object element) {
		return add(0, element);
	}

	// 데이터 조회 - toString 메서드 Override
	@Override
	public String toString() {
		String str = "[";
		for (int i = 0; i < size; i++) {
			str += elementData[i];
			if (i < size - 1) {
				str += ",";
			}
		}
		return str + "]";
	}

	// 데이터 삭제
	public Object remove(int index) {
		// 엘리먼트를 삭제하기 전에 삭제할 데이터를 removed 변수에 저장
		Object removed = elementData[index];

		// 삭제된 엘리먼트 다음 엘리먼트부터 마지막 엘리먼트까지 순차적으로 이동해서
		for (int i = index + 1; i <= size - 1; i++) {
			elementData[i - 1] = elementData[i];
		}
		// 크기를 줄인다.
		size--;

		// 마지막 위치의 엘리먼트를 명시적으로 삭제해준다.
		elementData[size] = null;

		return removed;
	}

	// 처음 데이터 삭제
	public Object removeFirst() {
		return remove(0);
	}

	// 마지막 데이터 삭제
	public Object removeLast() {
		return remove(size - 1);
	}

	// 데이터 가져오기
	public Object get(int index) {
		return elementData[index];
	}

	// 데이터 크기
	public int size() {
		return size;
	}

	// 탐색(특정한 값을 가진 엘리먼트의 인덱스) - 값이 있다면 발견된 첫번째 인덱스 / 없다면 -1 리턴
	public Object indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elementData[i])) {
				return i;
			}
		}
		return -1;
	}
	
	// 반복
	

}
