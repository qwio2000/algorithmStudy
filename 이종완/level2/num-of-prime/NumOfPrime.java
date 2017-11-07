import java.util.function.Function;
import java.util.Map;
import java.util.HashMap;

class NumOfPrime {

    Map<Integer, Function<Integer, Integer>> algorithms = new HashMap<>();

    public NumOfPrime() {
        algorithms.put(0, this::numberOfPrime0);
        algorithms.put(1, this::numberOfPrime1);
    }

    int numberOfPrime1(int n) {
        int capacity = 100;
        int[] primes = new int[capacity];
        int primeEndIndex = 0;

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 0; j < primeEndIndex; j++) {
                if (i % primes[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (primeEndIndex >= primes.length) {
                primes = extendCapacity(primes, capacity);
            }
            if (isPrime) {
                primes[primeEndIndex++] = i;
            }
        }
        return primeEndIndex;
    }

    int[] extendCapacity(int[] input, int capacityIncresse) {
        int[] result = new int[input.length + capacityIncresse];
        for (int i = 0; i < input.length; i++) {
            result[i] = input[i];
        }
        return result;
    }


    int numberOfPrime0(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testCase = 10;
        int numberOfAlgorithm = 0;
        Function<Integer, Integer> algorithm;

        if (args.length >= 2) {
            try {
                numberOfAlgorithm = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) { }
            try {
                testCase = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) { }
        }

        NumOfPrime prime = new NumOfPrime();

        algorithm = prime.algorithms.get(numberOfAlgorithm);
        if (algorithm == null) {
            numberOfAlgorithm = 0;
            algorithm = prime.algorithms.get(numberOfAlgorithm);
        }

        long start = System.currentTimeMillis();
        int result = algorithm.apply(testCase);
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("=================================");
        System.out.println("Method: " + numberOfAlgorithm + ", Test Case: " + testCase);
        System.out.println(result);
        System.out.println("elapsed time: " + elapsed + " ms");
    }
}