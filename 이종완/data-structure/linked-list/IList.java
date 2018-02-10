public interface IList {
    void add(Object data);
    void remove(Object data);
    int size();
    Object removeAtIndex(int index);
    Object removeFirst();
    Object removeLast();
    Object findAtIndex(int index);
    boolean contains(Object data);
}
