package list.arraylist.implementation;

public class Main {

	public static void main(String[] args) {

		// 같은 패키지 내의 ArrayList 객체
		ArrayList numbers = new ArrayList();

		// 데이터 추가
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);

		// 특정 위치에 데이터 추가
		numbers.add(1, 50);

		// 처음 위치에 데이터 추가
		numbers.addFirst(5);

		// 데이터 삭제
		numbers.remove(2);

		// 처음, 마지막 데이터 삭제
		numbers.removeFirst();
		numbers.removeLast();

		// 데이터 조회
		System.out.println(numbers.get(0));

		// 데이터 크기
		System.out.println(numbers.size());

		// 데이터 탐색
		System.out.println(numbers.indexOf(30));
		System.out.println(numbers.indexOf(100));

		// Override toString
		System.out.println(numbers);

		// 반복
//		for (int i = 0; i < numbers.size(); i++) {
//			System.out.println(numbers.get(i));
//		}
	
		
		ArrayList.ListIterator it = numbers.listIterator();
		
		// 반복은 아래와 같이 사용하는 것이 더 좋은 방법 -> 이유는 LinkedList에서 살펴볼 예정
//		while(it.hasNext()) {
//			int value = (int) it.next();
//			System.out.println(value);
//		}
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
		
		
		while(it.hasNext()) {
			int number = (int) it.next();
			if(number == 20) {
				it.add(25);
//				it.remove();
			}
		}
		System.out.println(numbers);
		
	}
}
