package list.arraylist.api;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList
 * 
 * 데이터 삽입 : 데이터가 삽입되면서 데이터가 뒤로 밀리게 된다.
 * 데이터 삭제 : 데이터가 삭제되면서 데이터가 앞으로 당겨진다.
 * 
 * 장점 : (내부적으로 배열을 이용하기 때문에) 데이터를 조회할 때, 인덱스 값을 알고 있기에 해당 인덱스를 조회할 때의 속도가 빠르다.
 * 단점 : 데이터가 추가 or 삭제될 때 마다 데이터를 하나씩 앞으로 당겨야 한다.
 */
public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();

		// 데이터 추가 : 단순히 배열에 더해지는 것이기 때문에 빠르게 동작한다.
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		
		// 데이터 특정 위치에 추가 : 특정 위치에 추가, add 인덱스에 인자 추가
		numbers.add(1, 50);
		
		// 데이터 삭제
		numbers.remove(2);
		
		// 데이터 가져오기
		numbers.get(2);
		
		// 데이터 반복 - 단순 출력
		Iterator<?> it = numbers.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

		// 데이터 반복 - 순회 삭제
		it = numbers.iterator();
		while(it.hasNext()) {
			
			int value = (int) it.next();
			if(value == 30) {
				it.remove();
			}
		}
		
		// 데이터 조회
		for(int value : numbers) {
			System.out.println(value);
		}
		
	}
}
