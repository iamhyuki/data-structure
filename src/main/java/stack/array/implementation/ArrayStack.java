package stack.array.implementation;

interface Stack {
	boolean isEmpty();

	boolean isFull();

	void push(Object item);

	Object pop();

	Object peek();

	void clear();
}

/**
 * Stack
 * 
 * 특징 : LIFO (LastIn FirstOut)
 * 
 * 배열로 스택을 구현해보았다!
 */
public class ArrayStack implements Stack {

	private int top;
	private int stackSize;
	private Object stackArr[];

	public ArrayStack(int stackSize) {
		top = -1;
		this.stackSize = stackSize;
		stackArr = new Object[this.stackSize];
	}

	@Override
	public boolean isEmpty() {
		return (top == -1);
	}

	@Override
	public boolean isFull() {
		return (top == this.stackSize - 1);
	}

	@Override
	public void push(Object item) {
		if (isFull()) {
			throw new StackOverflowError();
		} else {
			stackArr[++top] = item;
		}
	}

	@Override
	public Object pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		} else {
			Object returnData = stackArr[top];
			stackArr[top] = null;
			top--;
			return returnData;
		}
	}

	@Override
	public Object peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		} else {
			return stackArr[top];
		}
	}

	@Override
	public void clear() {
		if (isEmpty()) {
			System.out.println("Stack is already empty");
		} else {
			top = -1;
			stackArr = new Object[this.stackSize];
			System.out.println("Stack is clear");
		}
	}

	@Override
	public String toString() {
		String str = "[";
		for (int i = 0; i < stackSize; i++) {
			str += stackArr[i];
			if (i < stackSize - 1) {
				str += ",";
			}
		}
		return str + "]";
	}

}
