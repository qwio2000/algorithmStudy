public class LinearQueue implements IQueue {

	private int front = 0;
	private int rear = 0;
	private Object[] internalArray;

	public LinearQueue(int size) {
		internalArray = new Object[size];
	}

	public void enqueue(Object data) {
		if (isFull()) {
			throw new QueueFullException();
		}

		internalArray[rear++] = data;
	}

	public Object dequeue() {
		if (isEmpty()) {
			throw new QueueEmptyException();
		}

		return internalArray[front++];
	}
	public Object peek() {
		if (isEmpty()) {
			throw new QueueEmptyException();
		}

		return internalArray[front];
	}
	public boolean isEmpty(){
		return front == rear;
	}
	public boolean isFull(){
		return rear == internalArray.length;
	}

	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("F:[ ");
		int size = internalArray.length;
		for (int i = 0; i < size; i++) {
			if (i < front || i >= rear) {
				str.append("-");
			} else {
				str.append(internalArray[i]);
			}

			if (i != size-1) {
				str.append(", ");
			}
		}
		str.append("]:R");
		return str.toString();
	}
}