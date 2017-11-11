import java.util.Arrays;
import java.util.stream.Stream;


public class InsertionSort {
    void sort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    int tmp;
                    tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] testCase = {30, 23, 11, 15, 45, 2, 36};

        if (args.length > 0) {
            int[] argArray =
                Stream.of(args)
            .map(str -> {
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    return null;
                }
            })
            .filter(n -> n != null)
            .mapToInt(Integer::intValue)
            .toArray();

            if (argArray.length > 0) {
                testCase = argArray;
            }


        }
        System.out.println("Before: " + Arrays.toString(testCase));
        is.sort(testCase);
        System.out.println("After: " + Arrays.toString(testCase));
    }
}