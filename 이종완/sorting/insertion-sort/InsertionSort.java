import java.util.Arrays;
import java.util.stream.Stream;


public class InsertionSort {
    void sort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            // index i는 끼워넣을 수
            for (int j = 0; j < i; j++) {
                // index j는 정렬된 배열들의 각각을 끼워넣을 수와 비교
                if (array[i] > array[j]) {
                    int tmp;
                    tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

    void sort2(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            // index i는 정렬할 수
            for (int j = i ; j > 0; j--) {
                if (array[j] > array[j-1]) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                } else {
                    break;
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
        is.sort2(testCase);
        System.out.println("After: " + Arrays.toString(testCase));
    }
}