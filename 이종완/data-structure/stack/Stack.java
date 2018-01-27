public class Stack implements IStack {

	int top = 0;
	Object[] internalArray;

	public Stack(int size) {
		internalArray = new Object[size];
	}

	public void push(Object data) {
		if (top >= internalArray.length) {
			throw new StackFullException();
		}

		internalArray[top++] = data;
	}

	public Object pop() {
		if (top <= 0) {
			throw new StackEmptyException();
		}

		return internalArray[--top];
	}

	public Object peek() {
		if (top <= 0) {
			throw new StackEmptyException();
		}
		return internalArray[top-1];
	}

	public boolean isEmpty() {
		return top <= 0;
	}

	public boolean isFull() {
		return top >= internalArray.length;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("B:[ ");
		for (int i = 0; i < top; i++) {
			str.append(internalArray[i]);
			if (i != top-1) {
				str.append(", ");
			}
		}

		str.append(" ]:T");
		return str.toString();
	}
}