public class ListTest {
    public static void main(String[] args) {
        IList list = new LinkedList();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        System.out.println(list);

        for (int i = 3; 4*i+3 < 100; i++) {
            int r = 4*i+3;
            System.out.println("remove " + r);
            list.remove(r);
        }

        System.out.println(list);
        
        for (int i = 1; 2*i+1 < list.size(); i++) {
            int rindex = 2*i+1; 
            System.out.print("remove at index " + rindex);
            System.out.println(", [" + list.removeAtIndex(rindex) + "]");
        }

        System.out.println(list);

        for (int i = 0; i < list.size()/3; i++) {
            System.out.println("remove first [" + list.removeFirst() + "]");
            System.out.println(list);
        }

        for (int i = 0; i < list.size()/3; i++) {
            System.out.println("remove last [" + list.removeLast() + "]");
            System.out.println(list);
        }

        for (int i = 1; i < 20; i++) {
            Object data = i * 3 + 2;
            System.out.println("list contains " + data + "? " + list.contains(data));
        }

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Find at index " + i + ", [" + list.findAtIndex(i) + "]");
        }

        System.out.println(list);
    }
}
