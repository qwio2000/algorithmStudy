package vo;

public class LinearQueue implements Queue {
	private final int DEFAULT_QUEUE_SIZE = 5;
	
	private Object[] queueData;
	private int front;
	private int rear;
	
	public LinearQueue() {
		queueData = new Object[DEFAULT_QUEUE_SIZE];
		this.front = 0;
		this.rear = 0;
	}
	public LinearQueue(int size) {
		queueData = new Object[size];
		this.front = 0;
		this.rear = 0;
	}
	
	@Override
	public void enqueue(Object data) {
		if(isFull()) {
			System.out.println("Queue Is Full !");
		} else {
			queueData[rear++] = data;
		}
	}
	@Override
	public Object dequeue() {
		Object returnObject = null;
		if(isEmpty()){ 
			System.out.println("Queue Is Empty !");
		} else {
			returnObject = queueData[front];
			queueData[front] = null;
			front++;
		}
		return returnObject;
	}
	@Override
	public Object peek() {
		Object returnObject = null;
		if(isEmpty()){ 
			System.out.println("Queue Is Empty !");
		} else {
			returnObject = queueData[front];
		}
		return returnObject;
	}
	@Override
	public boolean isEmpty() {
		return front == rear;
	}
	@Override
	public boolean isFull() {
		return rear >= this.queueData.length;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Current Pointer - front : " + front + ", rear : " + rear + "\n");
		sb.append("------------------------------------------------------------\n");
		for (int i = 0; i < queueData.length; i++) {
			sb.append(i + " : " + queueData[i]);
			if(i != queueData.length-1 ) sb.append(", ");
			else sb.append("\n");
		}
		sb.append("------------------------------------------------------------\n");
		return sb.toString();
	}
	
	
}
