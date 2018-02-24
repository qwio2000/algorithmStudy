public class Queue implements IQueue {

    private LinkedList list = new LinkedList();

	public void enqueue(Object data){
        list.addLast(data);
    }

	public Object dequeue(){
        return list.removeFirst();
    }

	public Object peek(){
        return list.get(0);
    }

	public boolean isEmpty(){
        return list.size() == 0;
    }

	public boolean isFull(){
        return false;
    }

    public String toString() {
        return list.toString();
    }
}
