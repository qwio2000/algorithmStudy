public class ArrayTest {

	public static void main(String[] args) {

		Array array = new Array(10);
		
		array.add(3);
		array.add(4);
		array.add(10, 0);
		array.add(11, 2);
		System.out.print(array.remove(3));


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
	}
}