import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;

public class ReverseInt {

    Map<Integer, Function<Long, Long>> algorithms = new HashMap<>();

    public ReverseInt() {
        algorithms.put(0, this::reverseInt0);
    }

    public long reverseInt0(long n) {

        long[] occurrences = new long[10];

        while (n > 0) {
            int digit = (int) (n % 10L);
            n /= 10;
            occurrences[digit]++;
        }

        long result = 0;
        for (int digit = 9; digit >= 0; digit--) {
            long countOfDigit = occurrences[digit];
            for (long i = 0; i < countOfDigit; i++) {
                result = result * 10 + digit;
            }
        }

        return result;
    }

    public long reverseInt1(long n) {
        int count = 0;
        long number = n;
        while (number > 0) {
            count++;
            number /= 10;
        }

        long result = 0;

        int[] array = new int[count];
        int index = 0;
        number = n;
        while (number > 0) {
            int digit = (int) (number % 10);
            array[index++] = digit;
        }

        quickSort(array, 0, array.length);

        for (int i = count-1; i >= 0; i--) {
            result = result * 10 + array[i];
        }

        return result;
    }

    void quickSort(int[] array, int start, int end) {
        int length = end - start;
        if (length == 0 || length == 1) {
            return;
        }
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot);
        quickSort(array, pivot + 1, end);
    }

    int partition(int[] array, int start, int end) {
        int length = end - start;
        if (length == 0) {
            return start;
        }
        int pivotIndex = start;

        for (int i = start + 1; i < end; i++) {
            if (array[i] <= array[start]) {
                pivotIndex++;
                int tmp = array[i];
                array[i] = array[pivotIndex];
                array[pivotIndex] = array[i];
            }
        }
        int tmp = array[start];
        array[start] = array[pivotIndex];
        array[pivotIndex] = tmp;

        return pivotIndex;
    }

    public static void main(String[] args) {
        long testCase = 118372;
        int numberOfAlgorithm = 0;
        Function<Long, Long> algorithm = null;

        if (args.length >= 2) {
            try {
                numberOfAlgorithm = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) { }
            try {
                testCase = Long.parseLong(args[1]);
            } catch (NumberFormatException e) { }
        }

        ReverseInt ri = new ReverseInt();

        algorithm = ri.algorithms.get(numberOfAlgorithm);
        if (algorithm == null) {
            numberOfAlgorithm = 0;
            algorithm = ri.algorithms.get(numberOfAlgorithm);
        }

        long start = System.currentTimeMillis();
        long result = algorithm.apply(testCase);
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("===================================");
        System.out.println("Method: " + numberOfAlgorithm + ", TestCase: " + testCase);
        System.out.println(result);
        System.out.println("elapsed time: " + elapsed + " ms");
    }
}