public class LinkedList implements IList {

    class Node {
        final Object data;
        Node next;

        Node(Object data) {
            this.data = data;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    public void add(Object data) {
        Node newNode = new Node(data); 

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        size++;
        tail = newNode;
    }

    public void remove(Object data) {
        if (head == null) return;
        if (head.data.equals(data)) {
            head = head.next; 
            size--;
            return;
        }
        Node current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next == null) {
            return;
        }

        current.next = current.next.next;
        size--;
        if (current.next == null) {
            tail = current;
        }
    }

    public int size(){
        return size;
    }

    public Object removeAtIndex(int index){
        if (index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            Node removed = head;
            head = head.next;
            size--;
            return removed.data;
        }

        Node current = head;
        int i = 0;
        while (i+1 < index) {
            current = current.next;
            i++;
        }

        Node removed = current.next;
        current.next = current.next.next;
        size--;
        if (current.next == null) {
            tail = current;
        }

        return removed.data;
    }

    public Object removeFirst(){
        return removeAtIndex(0);
    }
    public Object removeLast(){
        return removeAtIndex(size-1);
    }
    public Object findAtIndex(int index){
        if (index >= size) throw new IndexOutOfBoundsException();

        Node current = head;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }

        return current.data;
    }

    public boolean contains(Object data){
        if (head == null) return false;
        
        Node current = head;
        do {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        } while (current != null);
        
        return false;
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("[");
        if (head != null) {
            Node current = head;
            while (current != null) {
                if (current != head) {
                    str.append(", ");
                }
                str.append(current.data);
                current = current.next;
            }
        }
        str.append("] Size: ");
        str.append(size);
        return str.toString();
    }
}
