import java.util.Iterator;

public class LinkedList implements Iterable<Object> {

    class Node {
        private Object data;
        private Node next;

        private Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void addFirst(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, Object data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(data);

        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node node = head;
            for (int i = 0; i < index-1; i++) {
                node = node.next; 
            }
            newNode.next = node.next;
            node.next = newNode;
            size++;
        }
    }

    public Object removeFirst() {
        if (head == null) {
            return null;
        }

        Object rdata = head.data;
        Node newHead = head.next;
        head.next = null;
        head = newHead;
        if (head == null) {
            tail = null;
        }
        size--;
        
        return rdata;
    }

    public Object removeLast() {
        if (head == null) {
            return null;
        }

        Object rdata = tail.data;
        
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return rdata;
        }
        
        Node node = head;
        while (node.next != tail) {
            node = node.next;
        }
        node.next = null;
        tail = node;
        size--;

        return rdata;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        if (index == 0) {
            return removeFirst();
        } else if (index == size-1) {
            return removeLast();
        } else {
            Node node = head;
            for (int i = 0; i < index-1; i++) {
                node = node.next;
            }
            Object rdata = node.next.data;
            node.next = node.next.next;
            size--;
            return rdata;
        }
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == size-1) {
            return tail.data;
        }

        Node node = head;
        
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.data;
    }

    public boolean contains(Object data) {
        Node node = head;
        while (node != null) {
            if (node.data.equals(data)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public Iterator<Object> iterator() {
        
        return new Iterator<Object>() {
            Node current = head;

            public boolean hasNext() {
                return current != null;
            }

            public Object next() {
                Object data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("{");
        boolean started = false;
        for (Object data : this) {
            if (started) {
                str.append(", ");
            } else {
                started = true; 
            }
            str.append(data);
        }
        str.append(String.format("}"));
        return str.toString();
    }

}
