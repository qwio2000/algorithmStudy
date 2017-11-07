import java.util.function.Function;
import java.util.Map;
import java.util.HashMap;

class SumDivisor {

    public Map<Long, Function<Long, Long>> algorithms = new HashMap<>();

    public SumDivisor() {
        algorithms.put(0L, this::sumDivisor0);
        algorithms.put(1L, this::sumDivisor1);
        algorithms.put(2L, this::sumDivisor2);
    }

    public long sumDivisor2(long num) {
        long sum = 0;
        long divisor = 1;
        while (divisor <= num) {
            if (num % divisor == 0) {
                sum += divisor;
            }
            divisor++;
        }
        return sum;
    }

    public long sumDivisor0(long num) {
        long sum = 1;
        long divisor = 2;
        long primeFactor = 2;
        long exponent = 0;

        while (divisor * divisor <= num || divisor == num) {
            if (num % divisor == 0) {
                if (primeFactor != divisor) {
                    if (exponent != 0) {
                        sum *= seriesSum(primeFactor, exponent);
                    }
                    primeFactor = divisor;
                    exponent = 1;
                } else {
                    exponent++;
                }
                num /= divisor;
            } else {
                divisor++;
            }
        }

        sum *= seriesSum(primeFactor, exponent);
        if (num != 1) {
            sum *= seriesSum(num, 1);
        }

        return sum;
    }

    private long seriesSum(long base, long exponent) {
        if (base == 1) {
            return (exponent + 1);
        }
        return (pow(base, exponent + 1) - 1) / (base - 1);
    }

    private long pow(long base, long exponent) {
        long result = 1;
        for (long i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public long sumDivisor1(long num) {

        long sum = 0;
        long divisor = 1;
        long tmpDivisor = 1;
        boolean isJumping = false;

        while (divisor * divisor <= num || isJumping) {
            if (num % divisor == 0) {
                sum += divisor;
                if (isJumping == false) {
                    tmpDivisor = divisor;
                    divisor = num / divisor;
                    if (tmpDivisor != divisor) {
                        isJumping = true;
                    } else {
                        divisor++;
                    }
                } else {
                    divisor = tmpDivisor + 1;
                    isJumping = false;
                }
            } else {
                divisor++;
            }
        }

        return sum;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {

        Function<Long, Long> algorithm = null;
        long numberOfAlgorithm = 0;
        long number = 12;

        if (args.length >= 2) {
            try {
                number = Long.parseLong(args[1]);
            } catch (NumberFormatException e) { }
            try {
                numberOfAlgorithm = Long.parseLong(args[0]);
            } catch (NumberFormatException e) { }
        }

        SumDivisor c = new SumDivisor();

        algorithm = c.algorithms.get(numberOfAlgorithm);
        if (algorithm == null) {
            numberOfAlgorithm = 0;
            algorithm = c.algorithms.get(numberOfAlgorithm);
        }

        long start = System.currentTimeMillis();
        long result = algorithm.apply(number);
        long end = System.currentTimeMillis(); 

        System.out.println("====================================");
        System.out.println("방법 (" + numberOfAlgorithm + ")로 구한 " + number + " 의 약수의 합");
        System.out.println("정답: " + result);
        System.out.println("elapsed time: " + (end - start) + " ms");

    }
}