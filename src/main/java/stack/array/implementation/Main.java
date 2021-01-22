package stack.array.implementation;

public class Main {

	public static void main(String[] args) {
		ArrayStack as = new ArrayStack(3);
		
		as.push("A");
		System.out.println(as.toString());

		as.push("B");
		System.out.println(as.toString());
		
		as.push("C");
		System.out.println(as.toString());
		
		System.out.println(as.pop());
		System.out.println(as.toString());

		System.out.println(as.pop());
		System.out.println(as.toString());
		
		System.out.println(as.pop());
		System.out.println(as.toString());
		
		as.clear();
		System.out.println(as.toString());

	}
}
