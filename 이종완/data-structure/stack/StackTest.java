public class StackTest {

	public static void main(String[] args) {
		IStack stack = new Stack(5);
		System.out.println("동작: 최초 생성");
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: isFull?");
		System.out.println(stack.isFull());
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: isEmpty?");
		System.out.println(stack.isEmpty());
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: push 30");
		stack.push(30);
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: push 23");
		stack.push(23);
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: push 31");
		stack.push(31);
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: isEmpty?");
		System.out.println(stack.isEmpty());
		System.out.println(stack);
		System.out.println();


		System.out.println("동작: pop");
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: pop");
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: peek");
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: pop");
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: push 1");
		stack.push(1);
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: isFull?");
		System.out.println(stack.isFull());
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: push 2");
		stack.push(2);
		System.out.println(stack);
		System.out.println();


		System.out.println("동작: push 3");
		stack.push(3);
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: isFull?");
		System.out.println(stack.isFull());
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: push 4");
		stack.push(4);
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: peek");
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: push 5");
		stack.push(5);
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: peek");
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println();

		System.out.println("동작: isFull?");
		System.out.println(stack.isFull());
		System.out.println(stack);
		System.out.println();

	}


}