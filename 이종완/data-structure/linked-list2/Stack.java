public class Stack implements IStack {
    private LinkedList list = new LinkedList();

    public void push(Object data) {
        list.addLast(data); 
    }

    public Object pop() {
        return list.removeLast();
    }

    public Object peek() {
        return list.get(list.size()-1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public boolean isFull() {
        return false;
    }

    public String toString() {
        return list.toString();
    }
}
