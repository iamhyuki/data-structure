package stack.calculator.implementation;

/**
 * 후위 표기법과 계산알고리즘으로 기본적인 스택 사용을 해봤다.
 * (디테일한 부분은 신경쓰진 않았다.)
 * */
public class Main {

	public static void main(String[] args) {

		Calculator cal = new Calculator();
		String inFix = "4+3*(6/2)";
		
		System.out.println("정답은? " + cal.calculate(inFix));
		

	}
}
