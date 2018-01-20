public interface IArray {
	void add(Object data);
	void add(Object data, int index);
	Object remove(int index);
	void clear();
	void swap(int firstIndex, int secondIndex);
	void replace(Object data, int index);
	Object read(int index);
	int dataCount();
	int size();
}