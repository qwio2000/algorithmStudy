package vo;

public class Stack  {
	private final int DEFAULT_STACK_SIZE = 5;

	private Object[] stack;
	private int top;

	public Stack() {
		stack = new Object[DEFAULT_STACK_SIZE];
		this.top = 0;
	}

	public Stack(int size) {
		stack = new Object[size];
		this.top = 0;
	}

	public void push(Object data) {
		if(isFull()) {
			System.out.println("Stack Is Full");
		} else {
			stack[top++] = data;
		}
	}

	public Object pop() {
		Object returnObject = null;
		if(isEmpty()){
			System.out.println("Stack Is Empty");
		} else {
			top--;
			returnObject = stack[top];
			stack[top] = null;
		}
		return returnObject;
	}

	public Object peek() {
		Object returnObject = null;
		if(isEmpty()){
			System.out.println("Stack Is Empty");
		} else {
			returnObject = stack[top-1];
		}
		return returnObject;
	}

	public boolean isEmpty(){
		return this.top == 0;
	}
	
	public boolean isFull(){
		return this.top >= this.stack.length;
	}
	
	public String printStack(){
		StringBuffer sb = new StringBuffer();
		sb.append("Current Top Position : " + this.top + "\n");
		sb.append("-------------------------------------------\n");
		for (int i = top-1; i >= 0; i--) {
			sb.append(i + " : " + stack[i] + "\n");
		}
		sb.append("-------------------------------------------\n");
		return sb.toString();
	}
}
