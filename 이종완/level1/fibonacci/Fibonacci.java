import java.util.function.Function;
import java.util.Map;
import java.util.HashMap;

class Fibonacci {

    Map<Integer, Function<Integer, Long>> algorithms = new HashMap<>();

    public Fibonacci() {
        algorithms.put(0, this::fibonacci0);
        algorithms.put(1, this::fibonacci1);
    }

    public long fibonacci1(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        }

        long previous = 0;
        long value = 1;
        
        for (int i = 2; i <= num; i++) {
            long tmp = value;
            value += previous;
            previous = tmp;
        }
        return value;
    }

    public long fibonacci0(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return fibonacci0(num-2) + fibonacci0(num-1);
        }
    }

    public static void main(String[] args) {
        int testCase = 3;
        int numberOfAlgorithm = 0;
        Function<Integer, Long> algorithm = null;

        if (args.length >= 2) {
            try {
                numberOfAlgorithm = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) { }
            try {
                testCase = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) { }
        }

        Fibonacci c = new Fibonacci();

        algorithm = c.algorithms.get(numberOfAlgorithm);
        if (algorithm == null) {
            numberOfAlgorithm = 0;
            algorithm = c.algorithms.get(numberOfAlgorithm);
        }

        long start = System.currentTimeMillis();
        long result = algorithm.apply(testCase);
        long end = System.currentTimeMillis();
        System.out.println("========================");
        System.out.println("Fibonacci 수열 " + testCase + " 번째 수");
        System.out.println(result);
        System.out.println("elapsed time: " + (end - start) + " ms");
    }
}