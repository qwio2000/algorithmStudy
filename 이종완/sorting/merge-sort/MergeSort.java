import java.util.Arrays;
import java.util.stream.Stream;

public class MergeSort {

    public void sort(int[] array, int start, int end) {
        int length = end - start;
        if (length <= 1) {
            return;
        }

        int mid = (start + end) / 2;
        sort(array, start, mid);
        sort(array, mid, end);
        merge(array, start, mid, end);
    }

    void merge(int[] array, int start, int middle, int end) {
        int length = end - start;

        if (length <= 1) {
            return;
        }
        int left = start;
        int right = middle;
        int[] merged = new int[length];

        for (int i = 0; i < length; i++) {
            if (left < middle && right < end) {
                if (array[left] < array[right]) {
                    merged[i] = array[left++];
                } else {
                    merged[i] = array[right++];
                }
            } else if (left < middle) {
                merged[i] = array[left++];
            } else if (right < end) {
                merged[i] = array[right++];
            }
        }

        for (int i = 0; i < length; i++) {
            array[start + i] = merged[i];
        }

    }

    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
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
        sorter.sort(testCase, 0, testCase.length);
        System.out.println("After: " + Arrays.toString(testCase));
    }
}