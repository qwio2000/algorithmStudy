import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.Arrays;

public class Expressions {

    Map<Integer, Function<Long, Long>> algorithms = new HashMap<>();

    public Expressions() {
        algorithms.put(0, this::expressions0);
        algorithms.put(1, this::expressions1);
    }

    /**
      * 연속된 3 개의 자연수의 합은 
      * 1 + 2 + 3 = 6
      * 2 + 3 + 4 = 9
      * 3 + 4 + 5 = 12
      * 과 같이 1 부터 3까지의 합에 3씩 더한 수들이다. 
      *
      * 즉, 연속된 n개의 자연수의 합은 
      * 1부터 n까지의 합에 n의 배수를 더한 수들로
      * 어떤 수 S가 연속된 n개의 자연수의 합으로 나타낼 수 있는지 보려면
      * S에서 1부터 n까지의 합을 뺀 수가 n으로 나누어지는지 보면 된다.
      */
    public long expressions1(long num) {
        long answer = 0;
        long firstSum = 0;
        long count = 0;

        while(firstSum < num) {
            count++;
            firstSum += count;
            if ((num - firstSum) % count == 0) {
                answer++;
                // long first = (num - firstSum) / count + 1L;
                // printRange(first, first + count - 1L);
            }
        }
        return answer;
    }

    public long expressions0(long num) {
        long count = 0;
        for (long i = 1; i <= num; i++) {
            long start = i;
            long sum = 0;
            while(sum < num) {
                sum += start++;
            }
            if (sum == num) {
                count++;
                // printRange(i, start-1);
            }
        }
        return count;
    }

    void printRange(long start, long end) {
        System.out.print("(");
        for (long i = start; i < end; i++) {
            System.out.print(i + "+");
        }
        System.out.println(end + ")");
    }

    public static void main(String args[]) {

        Function<Long, Long> algorithm = null;
        int numberOfAlgorithm = 0;
        long testCase = 15;
        if (args.length >= 2) {
            try {
                numberOfAlgorithm = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) { }
            try {
                testCase = Long.parseLong(args[1]);
            } catch (NumberFormatException e) { }
        }

        Expressions expressions = new Expressions();

        algorithm = expressions.algorithms.get(numberOfAlgorithm);
        if (algorithm == null) {
            numberOfAlgorithm = 0;
            algorithm = expressions.algorithms.get(numberOfAlgorithm);
        }

        System.out.println("\n========================================");
        long started = System.currentTimeMillis();
        long result = algorithm.apply(testCase);
        long elapsed = System.currentTimeMillis() - started;
        System.out.println("----------------");
        System.out.println("Test Case: " + testCase);
        System.out.println("Method: " + numberOfAlgorithm);
        System.out.println("Result: " + result + " 개");
        System.out.println("elapsed time: " + elapsed + " ms");
    }
}
