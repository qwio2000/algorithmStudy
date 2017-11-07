import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Arrays;

class TryHelloWorld {

    public int getMinSum(int[] A, int[] B) {
        int length = A.length;
        if (length == 0 || B.length != length)
            throw new IllegalArgumentException();

        final int NOT_FOUND = 2147483647;

        int[] order = getNumberArray(length);

        return getMinSumWithOrderArray(A, B, NOT_FOUND, order, 0, order.length);
    }

    int getMinSumWithOrderArray(int[] A, int[] B, int min, int[] order, int start, int end) {
        int length = end - start;
        if (length > 1) {
            for (int i = 0; i < length; i++) {
                rotateArray(order, start, end);
                min = getMinSumWithOrderArray(A, B, min, order, start + 1, end);
            }
        } else {
            int sum = getProductSum(A, B, order);
            if (min > sum) {
                min = sum;
                printCombination(A, B, order);
            }
        }
        return min;
    }

    void printCombination(int[] A, int[] B, int[] order) {
        int length = A.length;
        int i;
        int sum = 0;
        for (i = 0; i < length - 1; i++) {
            System.out.print(A[i] + "\t");
        }
        System.out.println(A[i]);
        for (i = 0; i < length-1; i++) {
            System.out.print(B[order[i]] + "\t");
        }
        System.out.println(B[order[i]]);
        System.out.println("------------------------------");
        for (i = 0; i < length-1; i++) {
            System.out.print(A[i] * B[order[i]] + "\t");
            sum += A[i] * B[order[i]];
        }
        System.out.print(A[i] * B[order[i]]);
        sum += A[i] * B[order[i]];
        System.out.println("\t=>\t" + sum);
        System.out.println();
        System.out.println();
    }


    int getProductSum(int[] A, int[] B, int[] order) {
        int length = A.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += A[i] * B[order[i]];
        }
        return sum;
    }

    int[] getNumberArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }

    void rotateArray(int[] array, int start, int end) {
        int length = end - start;
        if (length <= 1) return;
        int tmp = array[start];
        int i;
        for (i = start; i < end - 1; i++) {
            array[i] = array[i + 1];
        }
        array[i] = tmp;
    }

    public static void main(String[] args) {
        TryHelloWorld test = new TryHelloWorld();

        Scanner scan = new Scanner(System.in);
        System.out.print("수열 1: ");
        int[] seriesA = getIntArrayFromInput(scan.nextLine());
        System.out.print("수열 2: ");
        int[] seriesB = getIntArrayFromInput(scan.nextLine());

        long start = System.currentTimeMillis();
        int result = test.getMinSum(seriesA, seriesB);
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("========================");
        System.out.println("SeriesA: " + Arrays.toString(seriesA));
        System.out.println("SeriesB: " + Arrays.toString(seriesB));
        System.out.println("Min Sum: " + result);
        System.out.println("elapsed time: " + elapsed + " ms");
    }

    public static int[] getIntArrayFromInput(String input) {
        String[] array = input.split("\\s+");
        List<Integer> list = Stream.of(array)
        .map(str -> {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return null;
            }
        })
        .filter(n -> n != null)
        .collect(Collectors.toList());

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}