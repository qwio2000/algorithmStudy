package vo;

public interface Queue {
	void enqueue(Object data);
	Object dequeue();
	Object peek();
	boolean isEmpty();
	boolean isFull();
}
