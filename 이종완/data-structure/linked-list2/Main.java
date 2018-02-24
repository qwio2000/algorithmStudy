public class Main {

    public static void main(String[] args) {
        testLinkedList();
        testStack();
        testQueue();
    }

    private static void testLinkedList() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 5; i++) {
            System.out.printf("add first %d\n", i);
            list.addFirst(i); 
        }
        System.out.printf("%s, [size:%d]\n", list, list.size());

        for (int i = 5; i < 10; i++) {
            System.out.printf("add last %d\n", i);
            list.addLast(i);
        }
        System.out.printf("%s, [size:%d]\n", list, list.size());

        for (int i = 0; i < 4; i++) {
            System.out.printf("add %d at index %d\n", i+10, i*2);
            list.add(i*2, i+10);
        }
        System.out.printf("%s, [size:%d]\n", list, list.size());

        for (int i = 0; i < 3; i++) {
            System.out.printf("get at index %d, [%d]\n", i*3, list.get(i));
        }
        System.out.printf("%s, [size:%d]\n", list, list.size());

        for (int i = 0; i < 5; i++) {
            System.out.printf("contains %d, [%b]\n", i*5, list.contains(i*5));
        }
        System.out.printf("%s, [size:%d]\n", list, list.size());

        for (int i = 0; i < 4; i++) {
            System.out.printf("remove at index %d, [%d]\n", i*2+1, list.remove(i*2+1));
        }
        System.out.printf("%s, [size:%d]\n", list, list.size());

        for (int i = 0; i < 5; i++) {
            System.out.printf("remove last, [%d]\n", list.removeLast());
        }
        System.out.printf("%s, [size:%d]\n", list, list.size());

        for (int i = 0; i < 5; i++) {
            System.out.printf("remove first, [%d]\n", list.removeFirst());
        }
        System.out.printf("%s, [size:%d]\n", list, list.size());

        try {
            System.out.printf("remove at index %d, %d\n", 0, list.remove(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.printf("remove first, %d\n", list.removeFirst());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.printf("remove last, %d\n", list.removeLast());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("%s, [size:%d]\n", list, list.size());
    }

    private static void testStack() {
        Stack stack = new Stack();

        for (int i = 0; i < 10; i++) {
            System.out.printf("push %d\n", i);
            stack.push(i);
        }
        System.out.println(stack);
        System.out.printf("peek, [%d]\n", stack.peek());

        for (int i = 0; i < 10; i++) {
            System.out.printf("pop, [%d]\n", stack.pop());
            System.out.printf("stack is Full? [%b]\n", stack.isFull());
            System.out.printf("stack is Empty? [%b]\n", stack.isEmpty());
        }
        System.out.println(stack);
    }

    private static void testQueue() {
        Queue queue = new Queue();

        for (int i = 0; i < 10; i++) {
            System.out.printf("enqueue %d\n", i);
            queue.enqueue(i);
        }
        System.out.println(queue);
        System.out.printf("peek, [%d]\n", queue.peek());

        for (int i = 0; i < 10; i++) {
            System.out.printf("dequeue, [%d]\n", queue.dequeue());
            System.out.printf("queue is Full? [%b]\n", queue.isFull());
            System.out.printf("queue is Empty? [%b]\n", queue.isEmpty());
        }
        System.out.println(queue);
    }

}
