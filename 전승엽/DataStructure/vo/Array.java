package vo;

public class Array {
	private Object[] array;
	private int dataCount;
	private int arraySize;
	
	public Array(int arraySize) {
		this.arraySize = arraySize;
		this.dataCount = 0;
		this.array = new Object[arraySize];
	}
	
	public void add(Object data) {
		if (!isFull()) {
			array[dataCount++] = data;
		}
	}
	
	public void add(Object data, int index){
		if (!isFull() && index < this.arraySize) {
			for (int i = this.arraySize - 1; i >= index; i--) {
				//삽입하려는 인덱스보다 상위 인덱스에 있는 elements들을 이동
				if(i >= index && this.read(i) != null) {
					this.replace(this.read(i), i+1);
				}
			}
			this.replace(data, index);
			dataCount++;
		}
	}
	
	public void remove(int index){
		if (!isEmpty()) {
			for (int i = this.arraySize - 1; i >= index; i--) {
				//삽입하려는 인덱스보다 상위 인덱스에 있는 elements들을 이동
				if(i == index) this.replace(null, i);
				else if(i > index) this.replace(this.read(i), i-1);
			}
			dataCount--;
		}
	}

	public void clear(){
		for (int i = 0; i < array.length; i++) this.remove(i);
	}
	
	public void swap(int targetIndex1, int targetIndex2){
		if(this.arraySize > targetIndex1 && this.arraySize > targetIndex2){
			Object temp = this.read(targetIndex1);
			this.replace(this.read(targetIndex2), targetIndex1);
			this.replace(temp, targetIndex2);
		}
	}
	
	public void replace(Object data, int index) {
		if(this.arraySize > index)
			this.array[index] = data;
	}
	
	public Object read(int index){
		if(dataCount > index) {
			return this.array[index];
		}
		return null;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public int getArraySize() {
		return arraySize;
	}

	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}
	
	public boolean isFull(){
		return dataCount >= arraySize;
	}
	
	public boolean isEmpty() {
		return dataCount == 0;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < this.arraySize; i++) {
			if(this.array[i] != null) {
				sb.append(i+" : "+this.array[i].toString());
			} else {
				sb.append(i+" : null");
			}
			if(i != this.arraySize-1) sb.append(", ");
		}
		return sb.toString();
	}
}