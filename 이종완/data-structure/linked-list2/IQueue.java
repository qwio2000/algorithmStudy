public interface IQueue {
	void enqueue(Object data);
	Object dequeue();
	Object peek();
	boolean isEmpty();
	boolean isFull();
}