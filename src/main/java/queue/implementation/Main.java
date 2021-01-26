package queue.implementation;

public class Main {

	public static void main(String[] args) {
		ArrayQueue<Integer> numbers = new ArrayQueue<>(10);
//		ArrayBlockingQueue<Integer> numbers = new ArrayBlockingQueue<>(64);
		numbers.offer(1);
		numbers.offer(2);
		numbers.offer(3);
		numbers.offer(4);
		numbers.offer(5);
		numbers.offer(6);
		numbers.offer(7);
		numbers.offer(8);
		numbers.offer(9);
		numbers.offer(10);
		numbers.offer(11);
		numbers.offer(12);
		numbers.offer(13);
		numbers.offer(14);
		numbers.offer(15);
		
		System.out.println(numbers.toString());
		int s = numbers.size();
		for (int i = 0; i < s; i++) {
			System.out.println(numbers.poll());
		}
		System.out.println(numbers.toString());

	}
}
