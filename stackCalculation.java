package java_main;

import java.util.Stack;

public class stackCalculation {
	public static void main(String args[]) {
		System.out.println(calculation("231*+9-"));
	}

	public static int calculation(String s) {

		Stack<Integer> stack = new Stack();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				stack.push(c - '0');

			}
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			switch (c) {
			case '*':
				stack.push(stack.pop() * stack.pop());
			case '-':
				stack.push(stack.pop() - stack.pop());
			case '/':
				stack.push(stack.pop() / stack.pop());
			case '+':
				stack.push(stack.pop() + stack.pop());
			default:
				break;
			}

		}
		return stack.pop();
		
	}

	
}
