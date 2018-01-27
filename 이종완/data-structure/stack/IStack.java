public interface IStack {
	void push(Object data);
	Object pop();
	Object peek();
	boolean isEmpty();
	boolean isFull();

}