package list.doublylinkedlist.implemetation;

public class Main {
	
	public static void main(String[] args) {
		DoublyLinkedList dl = new DoublyLinkedList();
		
		dl.addLast(10);
		dl.addLast(20);
		dl.addLast(30);
		
		DoublyLinkedList.ListIterator it = dl.listIterator();
		
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		
		System.out.println("-------------------------");
		System.out.println(dl);
	}
	
	
}
