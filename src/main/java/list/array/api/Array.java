package list.array.api;

public class Array {

	public static void main(String[] args) {
		// 배열 생성
		int[] numbers1 = new int[4];
		String[] strings = new String[4];
		
		// 배열에 값 저장
		numbers1[0] = 10;
		numbers1[1] = 20;
		numbers1[2] = 30;
		numbers1[3] = 30;
		
		/**
		 *  배열 number1[0]에서 숫자 0은 배열의 인덱스를 가리킨다. 즉 numbers1[0] = 10; 은
		 *  인덱스 0번째 엘리먼트가 10이라는 의미
		 * */
		
		// 배열의 생성과 값 설정을 한번에
		int[] numbers2 = {10, 20, 30, 40};
		int[] numbers3 = new int[] {10, 20, 30, 40};
		
		// 값 가져오기
		System.out.println(numbers1[0]);
		
		// 지정되지 않은 엘리먼트를 조회하면 숫자는 0 / 문자열은 null
		System.out.println(numbers1[3]); 
		System.out.println(strings[3]);
		
		// 배열의 크기
		System.out.println(numbers1.length);
		System.out.println(strings.length);
		
		/**
		 * 만약 값이 지정된 배열의 개수를 알고 싶다면?
		 * : 자바의 배열은 기능이 기본적으로 제공되지 않는다.
		 * -> 이런 이유에서 ArrayList나 LinkedList를 사용.
		 * */
		
		// 배열의 반복
		int i=0;
		while(numbers1.length > i) {
			System.out.println(numbers1[i]);
			i++;
		}
		
		/**
		 * 배열의 크기를 배열을 생성할 때 지정하며 크기를 변경할 수 없다.
		 * 배열에서 값이 설저왼 엘리먼트의 개수를 알아낼 수 없다.
		 * But. 데이터의 크기가 확정적일 때 배열을 사용하는 것이 메모리나 처리속도 면에서 좋다.
		 * 또한 다른 데이터 스트럭처의 부품이 된다.
		 * 
		 * => 배열 다음 배울 자료구조인 List에 관한 설명
		 * https://opentutorials.org/module/1335/8636 
		 * */
	}
}
