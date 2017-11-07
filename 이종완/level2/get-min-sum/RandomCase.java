public class RandomCase {
    public int printRandomCase(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        return findCaseArray(array, 0, array.length, 0);

    }

    void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    int findCaseArray(int[] array, int start, int end, int count) {
        int length = end - start;
        if (length > 1) {
            for (int i = 0; i < length; i++) {
                rotate(array, start, end);  
                count = findCaseArray(array, start + 1, end, count);
            }
        } else {
            count++;
            printArray(array);
        }

        return count;
    }

    void rotate(int[] array, int start, int end) {
        int length = end - start;
        if (length == 0) return;

        int tmp = array[start];
        int i;
        for (i = start; i < end - 1; i++) {
            array[i] = array[i + 1];
        }
        array[i] = tmp;
    }

    boolean isArrayEqual(int[] array, int[] compared) {
        if (array.length != compared.length) return false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != compared[i]) return false;
        }
        return true;
    }

    void printArray(int[] array) {
        System.out.print("[ ");
        int i;
        for (i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[i] + " ]");
    }

    int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int testCase = 10;

        if (args.length >= 1) {
            try {
                testCase = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) { }
        }

        System.out.println("=================================");

        RandomCase rc = new RandomCase();
        long start = System.currentTimeMillis();
        int countResult = rc.printRandomCase(testCase);
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("Number: " + testCase);
        System.out.println("Factorial: " + rc.factorial(testCase));
        System.out.print("Count: ");
        System.out.println(countResult);
        System.out.println("elapsed time: " + elapsed + " ms");
    }
}