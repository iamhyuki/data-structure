package list.compare;

import list.arraylist.implementation.ArrayList;
import list.linkedlist.implemetation.LinkedList;

/**
 * ArrayList와 LinkedList 비교
 * 
 * */
public class Main {

	public static void main(String[] args) {
		// ArrayList는 크기를 정해놓는다. (실제 자바 컬렉션의 경우에는 크기가 꽉차면 크기를 늘린다.)
		ArrayList array = new ArrayList();
		array.addLast(10);
		array.addLast(20);
		array.addLast(30);
		array.addFirst(5); // 데이터를 삽입하려면 삽입 위치 뒤의 데이터 모두를 뒤로 밀어야 한다.
		array.get(2); // 인덱스를 알고 있기 때문에, RAM의 특성 상 어느 주소던 동일한 속도로 조회가 가능!
		ArrayList.ListIterator ai = array.listIterator();
		while(ai.hasNext()) { // 이 또한 데이터 배열을 뒤로 옮겨줘야하기 때문에 성능이 낮다.
			if((int) ai.next() == 20) {
				ai.add(25);
			}
		}
		
		// 크기를 정해놓지 않기 때문에 한계가 없다.
		LinkedList linked = new LinkedList();
		linked.addLast(10);
		linked.addLast(20);
		linked.addLast(30);
		linked.addFirst(5); // 데이터를 삽입 시 삽입 위치의 앞, 뒤의 데이터만 연결 참조값 을 바꾸면 된다.
		linked.get(2); // 데이터를 일일히 찾아야 하기 때문에 시간이 오래 걸린다.
		LinkedList.ListIterator li = linked.listIterator();
		while(li.hasNext()) { // 이 또한 연결 참조값만 바꾸면 되기 때문에 빠르다.
			if((int) li.next() == 20) {
				li.add(25);
			}
		}
	}
}
