package queue.implementation;


public class Main {

	public static void main(String[] args) {
		ArrayQueue<Integer> n1 = new ArrayQueue<>(10);

		n1.offer(1);
		n1.offer(2);
		n1.offer(3);
		n1.offer(4);
		n1.offer(5);
		n1.offer(6);
		n1.offer(7);
		n1.offer(8);
		n1.offer(9);
		n1.offer(10);
		n1.offer(11);
		n1.offer(12);
		n1.offer(13);
		n1.offer(14);
		n1.offer(15);
		
//		System.out.println(n1.toString());
//		int s = n1.size();
//		for (int i = 0; i < s; i++) {
//			System.out.println(n1.poll());
//		}
//		System.out.println(n1.toString());
		  
		/******************************************************************/
		LinkedQueue<Integer> n2 = new LinkedQueue<>();
		
		n2.offer(1);
		n2.offer(2);
		n2.offer(3);
		
		System.out.println(n2.toString());
		System.out.println(n2.poll());
		System.out.println(n2.toString());
		
		n2.clear();
		System.out.println(n2.toString());
		
		
	}
}
