public class CircularQueue implements IQueue {

    private final int MAX_SIZE = 10;
    private Object[] dataArray;
    private int front, rear;

    public CircularQueue() {
        dataArray = new Object[MAX_SIZE];
        front = rear = 0;
    }

    public void enqueue(Object data) {
        if (isFull())
            throw new QueueFullException();
        dataArray[rear] = data;
        rear = (rear + 1) % MAX_SIZE;
    }

    public Object dequeue() {
        if (isEmpty())
            throw new QueueEmptyException();
        Object data = dataArray[front];
        front = (front + 1) % MAX_SIZE;

        return data;
    }

    public Object peek() {
        if (isEmpty())
            throw new QueueEmptyException();

        return dataArray[front];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % MAX_SIZE == front;
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("Front: " + front + ", Rear: " + rear + "\n");
        str.append("  ");
        int first = front;
        int last = rear;
        String firstC = "F";
        String lastC = "R";
        if (front > rear) {
            first = rear;
            last = front;
            firstC = "R";
            lastC = "F";
        } 
        for (int i = 0; i < first; i++)
            str.append("  ");
        str.append(firstC);
        if (last == first) {
            str.append(lastC);
        } else {
            str.append(" ");
            for (int i = 0; i < last - first - 1; i++)
                str.append("  ");
            str.append(lastC);
        }

        str.append("\n");
        str.append("[ ");
        for (int i = 0; i < MAX_SIZE; i++) {
            if (front <= rear && i >= front && i < rear) {
                str.append(dataArray[i] + " ");
            } else if (front > rear && (i >= front || i < rear)) {
                str.append(dataArray[i] + " ");
            } else {
                str.append("- ");
            }
        }
        str.append("]");
        return str.toString();
    }

}
