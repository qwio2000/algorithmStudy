import java.util.function.Function;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;

class NLCM {

    Map<Integer, Function<int[], Long>> algorithms = new HashMap<>();

    public NLCM() {
        algorithms.put(0, this::nlcm0);
        algorithms.put(1, this::nlcm1);
    }


    public long nlcm0(int[] num) {
        if (num.length == 0) return -1;
        int length = num.length;

        int max = num[0];
        int maxIndex = 0;
        for (int i = 1; i < length; i++) {
            if (num[i] > max) {
                max = num[i];
                maxIndex = i;
            }
        }
        int tmp = num[0];
        num[0] = num[maxIndex];
        num[maxIndex] = tmp;

        long lcm = 0;
        for (int n = 1;; n++) {
            long candidate = (long)max * n;
            boolean isCM = true;
            for (int i = 1; i < length; i++) {
                if (candidate % num[i] != 0) {
                    isCM = false;
                    break;
                }
            }
            if (isCM) {
                lcm = candidate;
                break;
            }
        }

        return lcm;
    }

    long nlcm1(int[] num) {
        int[] number = new int[num.length];
        for (int i = 0 ; i < num.length; i++) {
            number[i] = num[i];
        }

        long lcm = 1;
        boolean isAllOne = false;
        int length = number.length;
        int divisor = 2;
        boolean isDivided = false;
        while (isAllOne == false) {
            for (int i = 0; i < length; i++) {
                if (number[i] % divisor == 0) {
                    number[i] /= divisor;
                    isDivided = true;
                }
            }
            if (isDivided) {
               lcm *= divisor;
               isDivided = false;
            } else {
                divisor++;
            }

            isAllOne = true;
            for (int i = 0; i < length; i++) {
                if (number[i] != 1) {
                    isAllOne = false;
                    break;
                }
            }
        }

        return lcm;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        int numberOfAlgorithm = 0;
        Function<int[], Long> algorithm = null;
        int[] testCase = { 2, 6, 8, 14 };

        if (args.length >= 1) {
            try {
                numberOfAlgorithm = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) { }
        }


        List<Integer> list = Stream.of(args)
            .skip(1)
            .map(str -> {
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException e) { 
                    return null;
                }
            })
            .filter(n -> n != null)
            .collect(Collectors.toList());

            if (list.size() > 0) {

                testCase = new int[list.size()];
                for (int i=0; i<list.size(); i++) {
                    testCase[i] = list.get(i);
                }
            }

            System.out.println(list);
            System.out.println(Arrays.toString(testCase));

            NLCM c = new NLCM();

        algorithm = c.algorithms.get(numberOfAlgorithm);
        if (algorithm == null) {
            numberOfAlgorithm = 0;
            algorithm = c.algorithms.get(numberOfAlgorithm);
        }

        long start = System.currentTimeMillis();
        long result = algorithm.apply(testCase);
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("====================================");
        System.out.println("Method: " + numberOfAlgorithm);
        System.out.println("TestCase: " + Arrays.toString(testCase));
        System.out.println("Result: " + result);
        System.out.println("elapsed time: " + elapsed + " ms");
    }
}
