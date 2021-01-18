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

	}
}
