public class Array implements IArray {

	private Object[] internalArray;
	private final int size;
	private int dataCount;

	public Array(int size) {
		this.internalArray = new Object[size];
		this.size = size;
		this.dataCount = 0;
	}

	public void add(Object data) {
		if (dataCount == size) {
			throw new DataFullException();
		}

		internalArray[dataCount++] = data;
	}

	public void add(Object data, int index) {
		if (index == dataCount) {
			add(data);
			return;
		}

		if (dataCount == size) {
			throw new DataFullException();
		}

		rotateForwardFrom(index);
		internalArray[index] = data;
		dataCount += 1;
	}

	public Object remove(int index) {
		Object removedItem = internalArray[index];
		rotateBackwardFrom(index);
		dataCount -= 1;
		return removedItem;	
	}

	public void clear() {
		for (int i = 0; i < dataCount; i++) {
			internalArray[i] = null;
		}
		dataCount = 0;
	}

	public void swap(int firstIndex, int secondIndex) {
		if (firstIndex > dataCount || secondIndex > dataCount) {
			throw new IndexOutOfBoundsException();
		}

		if (firstIndex == secondIndex) return;

		Object tmp = internalArray[firstIndex];
		internalArray[firstIndex] = internalArray[secondIndex]; 
		internalArray[secondIndex] = tmp;
	}

	public void replace(Object data, int index) {
		if (index >= dataCount) {
			throw new IndexOutOfBoundsException();
		}

		internalArray[index] = data;
	}

	public Object read(int index) {
		if (index >= dataCount) {
			throw new IndexOutOfBoundsException();
		}

		return internalArray[index];
	}

	public int dataCount() {
		return dataCount;
	}

	public int size() {
		return size;
	}

	private void rotateForwardFrom(int index) {
		if (index >= dataCount) {
			throw new IndexOutOfBoundsException();
		}

		int i;
		for (i = dataCount-1; i >= index; i--) {
			internalArray[i+1] = internalArray[i];
		}
		internalArray[index] = null;
	}

	private void rotateBackwardFrom(int index) {
		if (index >= dataCount) {
			throw new IndexOutOfBoundsException();
		}

		int i;
		for (i = index; i < dataCount-1; i++) {
			internalArray[i] = internalArray[i+1];
		}
		internalArray[dataCount] = null;
	}

}