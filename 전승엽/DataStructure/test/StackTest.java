package test;

import vo.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack stack = new Stack();
		for (int i = 0; i < 6; i++) {
			System.out.println("PUSH : TEST"+i);
			stack.push("TEST"+i);
			System.out.println(stack.printStack());
		}
		System.out.println("Peek : " + stack.peek());
		System.out.println(stack.printStack());
		
		for (int i = 0; i < 6; i++) {
			System.out.println("Pop : " + stack.pop());
			System.out.println(stack.printStack());
		}
		System.out.println("Peek : " + stack.peek());
		System.out.println(stack.printStack());
	}

}
