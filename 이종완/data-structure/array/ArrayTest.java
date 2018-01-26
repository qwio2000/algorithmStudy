public class ArrayTest {

	public static void main(String[] args) {

		Array array = new Array(10);
		
		printArray(array);
		array.add(3);
		printArray(array);
		array.add(4);
		printArray(array);
		array.add(10, 0);
		printArray(array);
		array.add(11, 2);
		printArray(array);
		System.out.println(array.remove(3));
		printArray(array);
		System.out.println(array.read(1));
		printArray(array);
		array.add(5);
		printArray(array);
		array.add(23);
		printArray(array);
		array.replace(2, 4);
		printArray(array);
		array.replace(0, 3);
		printArray(array);
		array.swap(1, 4);
		printArray(array);
		array.swap(0, 2);
		printArray(array);
		array.remove(3);
		printArray(array);
		array.remove(0);
		printArray(array);
		array.remove(2);
		printArray(array);

		array.clear();
		printArray(array);


	}

	static void printArray(IArray array) {
		System.out.print("[");
		for (int i = 0; i < array.dataCount(); i++) {
			System.out.print(array.read(i));
			if (i < array.dataCount()-1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
		System.out.print(", length: ");
		System.out.print(array.dataCount());
		System.out.print(", size: ");
		System.out.println(array.size());
	}
}