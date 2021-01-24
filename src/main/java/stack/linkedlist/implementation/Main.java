package stack.linkedlist.implementation;

public class Main {

	public static void main(String[] args) {
		LinkedListStack<Integer> numbers = new LinkedListStack<>();
		numbers.push(1);
		numbers.push(2);
		numbers.push(3);
		numbers.push(4);
		System.out.println(numbers.toString());
		numbers.clear();
		System.out.println(numbers.toString());
		
	}
	

}
