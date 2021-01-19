package list.linkedlist.implemetation;

public class Main {

	public static void main(String[] args) {
		// 비교 <->
		java.util.LinkedList<Integer> list = new java.util.LinkedList<>();

		LinkedList numbers = new LinkedList();

		// 데이터 추가
		numbers.addFirst(30);
		numbers.addFirst(20);
		numbers.addFirst(10);

		numbers.addLast(40);
		numbers.addLast(50);
		numbers.addLast(60);

		// 특정 위치 노드 조회
//		System.out.println(numbers.node(2));

		// 특정 위치에 데이터 추가
		numbers.add(2, 25);

		// 데이터 삭제
//		numbers.removeFirst();
//		numbers.remove();
//		numbers.removeLast();

		System.out.println(numbers.indexOf(40));
//		System.out.println(numbers.get(5));
		System.out.println(numbers);

		/**
		 * Iterator
		 * 
		 * LinkedList에서 get은 효율적이지 않다. <- 내부적으로 반복문이 실행되기 때문! 
		 * 고로 Iterator 사용이 유리하다.
		 */
		LinkedList.ListIterator i = numbers.listIterator();
		
//		while (i.hasNext()) {
//			System.out.println(i.next());
//		}
		
//		i.add(5);

		// 데이터 삭제 (이 방법은 효율적이지 않다. 내부적으로 한번 더 반복문이 실행되기 때문!
		// 해결을 하기 위해서는 전,후 노드를 알 수 있어야 하는데,
		// 이 부분은 DoubleLinkedList 때 알아보기로!
		while (i.hasNext()) {
			if ((int) i.next() == 15) {
				i.remove();
			}
		}
		System.out.println(numbers);

	}
}
