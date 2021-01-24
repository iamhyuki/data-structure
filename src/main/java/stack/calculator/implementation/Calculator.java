package stack.calculator.implementation;

import stack.linkedlist.implementation.LinkedListStack;

public class Calculator {

	/**
	 * 후위표기 알고리즘
	 * 
	 * 중위 표기법 : 연산자가 피연산자 가운데에 위치하는 것(일반적으로 사용하는 ex. 1+3) 
	 * 후위 표기법 : 연산자가 피연산자 뒤에
	 * 위치시키는 것(ex. 1 3 +) 
	 * => 컴퓨터는 식을 보고 우선순위를 파악하고 계산하는 능력이 없으므로 중위 표기법을 후위 표기법으로 바꿔야 한다.
	 */

	// 후위표기 알고리즘의 연산자 우선순위는 '(' < '+', '-' < '*', '/' 순이다.
	public int priority(char operator) {
		if (operator == '*' || operator == '/') {
			return 2;
		} else if (operator == '+' || operator == '-') {
			return 1;
		} else {
			return 0;
		}
	}
	
	public String getPostFix(String inFix) {
		char[] inFixArray = inFix.toCharArray();
		LinkedListStack<Character> stack = new LinkedListStack<>();
		String postFix = "";

		// 입력받은 중위 표기식에서 한 글자씩 읽어들인다.
		for (char c : inFixArray) {
			// '('를 만나면 스택에 push
			if (c == '(') {
				stack.push(c);
			
			// ')' 를 만나면 '(' 가 나올 때 까지 연산자를 pop해서 string에 더하고 '(' 는 버리기
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					postFix += stack.pop();
				}
				stack.pop();
			
			// 연산자를 만나면 동일 또는 하위연산자가 나올때까지 상위연산자를 모두 pop해서 string에 더하고 자기자신을 push
			} else if (c == '+' || c == '-' || c == '*' || c == '/') {
				while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
					postFix += stack.pop();
				}
				stack.push(c);
			// 숫자를 만나면 string에 더한다.
			} else if (c >= '0' && c <= '9') {
				postFix += c;
			}
		}
		// 모든 문자를 처리하고 스택에 연산자가 남았다면 순서대로 string에 더한다.
		while (!stack.isEmpty()) {
			postFix += stack.pop();
		}
		return postFix;
	}
	
	/**
	 * 계산 알고리즘
	 * */
	public int calculate(String inFix) {
		LinkedListStack<Integer> stack = new LinkedListStack<>();
		String formula = getPostFix(inFix);
		System.out.println("formula : " + formula);
		char[] f = formula.toCharArray();

		for (char c : f) {
			System.out.println(c);
			// 숫자를 만나면 stack에 push
			if (c >= '0' && c <= '9') {
				stack.push(Integer.parseInt(String.valueOf(c)));
				
			// 연산자를 만나면 2개 pop해서 연산 (먼저 뺀 것이 뒤로 가야한다.)
			} else if (c == '+' || c == '-' || c == '*' || c == '/') {
				int a = stack.pop();
				int b = stack.pop();

				switch (c) {
				case '+':
					stack.push(b + a);
					break;
				case '-':
					stack.push(b - a);
					break;
				case '*':
					stack.push(b * a);
					break;
				case '/':
					stack.push(b / a);
					break;
				}
			}
		}
		return stack.pop();
	}
}
