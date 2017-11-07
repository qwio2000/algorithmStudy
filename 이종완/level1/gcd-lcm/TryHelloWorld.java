import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class TryHelloWorld {
    public Map<Long, BiFunction<Long, Long, long[]>> gcdlcmAlogrithms;

    public TryHelloWorld() {
        gcdlcmAlogrithms = new HashMap<>();
        gcdlcmAlogrithms.put(0L, this::gcdlcm0);
        gcdlcmAlogrithms.put(1L, this::gcdlcm1);
        gcdlcmAlogrithms.put(2L, this::gcdlcm2);
        gcdlcmAlogrithms.put(3L, this::gcdlcm3);
        gcdlcmAlogrithms.put(4L, this::gcdlcm4);
        gcdlcmAlogrithms.put(5L, this::gcdlcm5);
        gcdlcmAlogrithms.put(6L, this::gcdlcm6);
        gcdlcmAlogrithms.put(7L, this::gcdlcm7);
        gcdlcmAlogrithms.put(8L, this::gcdlcm8);
    }

    public long[] gcdlcm8(long a, long b) {
        long[] answer = new long[2];
        long num = 2;
        long maxInt = 1;
        while ((num <= a) && (num <= b)) {
            if ((a % num == 0) && (b % num == 0)) {
                maxInt = maxInt * num;
                a = a / num;
                b = b / num;
            } else {
                num++;
            }
        }
        answer[0] = maxInt;
        answer[1] = maxInt * a * b;

        return answer;
    }


    public long[] gcdlcm7(long a, long b) {
        long[] answer = new long[2];
        long minVal = Math.min(a, b);
        for (long i = 1; i <= minVal; i++) {
            if (a % i == 0 && b % i == 0) answer[0] = i;
        }
        answer[1] = (a * b) / answer[0];
        return answer;
    }

    public long[] gcdlcm6(long a, long b) {
        long[] answer = new long[2];
        long gcd = 0;
        long lcm = 0;
        if (a > b) {
            for (long i = 1; i <= b; i++) {
                if (a % i == 0 && b % i == 0) {
                    gcd = i;
                }
            }

            long count = 1;
            long mul;
            while (true) {
                mul = a * count;
                if (mul % b == 0) {
                    lcm = mul;
                    break;
                }
                count++;
            }
        }
        if (a < b) {
            for (long i = 1; i <= a; i++) {
                if (a % i == 0 && b % i == 0) {
                    gcd = i;
                }
            }

            long count = 1;
            long mul;
            while (true) {
                mul = b * count;
                if (mul % a == 0) {
                    lcm = mul;
                    break;
                }
                count++;
            }
        }
        answer[0] = gcd;
        answer[1] = lcm;

        return answer;
    }


    public long[] gcdlcm5(long a, long b) {
        long[] answer = new long[2];

        answer[0] = gcd(a, b);
        answer[1] = (a * b) / answer[0];
        return answer;
    }

    public long gcd(long p, long q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }


    // 오류가 있는 알고리즘
    // 작은 수의 제곱근보다 큰 공약수는 없다고 전제 (틀림)
    public long[] gcdlcm0(long a, long b) {
        long count = 0;
        long loop = 0;

        if (a < b) {
            count++;
            long tmp = a;
            a = b;
            b = tmp;
        }

        long commonDivisor = 1;
        long divisor = 2;

        while (divisor <= b) {
            loop++;
            if (divisor < b && divisor * divisor > b) {
                count++;
                divisor = b;
            } else if (a % divisor == 0 && b % divisor == 0) {
                count += 2;
                commonDivisor *= divisor;
                a /= divisor;
                b /= divisor;
                divisor = 2;
            } else {
                count += 2;
                divisor++;
            }
        }

        long[] answer = {commonDivisor, commonDivisor * a * b};
        System.out.println("Count: " + count + ", Loop: " + loop);

        return answer;
    }

    // 손으로 최대공약수/최대공배수 구하듯이, 두 수를 약수로 나눈 몫을 가지고 계속 계산
    public long[] gcdlcm1(long a, long b) {
        long count = 0;
        long loop = 0;

        long commonDivisor = 1;
        long divisor = 2;

        while (divisor <= a && divisor <= b) {
            loop++;
            count++;
            if (a % divisor == 0 && b % divisor == 0) {
                commonDivisor *= divisor;
                a /= divisor;
                b /= divisor;
                divisor = 1;
            }
            divisor++;
        }

        long[] answer = {commonDivisor, commonDivisor * a * b};
        System.out.println("Count: " + count + ", Loop: " + loop);

        return answer;
    }

    // 가장 직접적인 방법, 1부터 두 수 중 작은 수까지 차례대로 대입하여 공약수를 구함. 이 결과는 무조건 정확
    public long[] gcdlcm2(long a, long b) {
        long count = 0;
        long loop = 0;

        long divisor = 1;
        long commonDivisor = 1;

        while (divisor <= a && divisor <= b) {
            loop++;
            count++;
            if (a % divisor == 0 && b % divisor == 0) {
                commonDivisor = divisor;
            }
            divisor++;
        }

        long[] answer = {commonDivisor, a * b / commonDivisor};
        System.out.println("Count: " + count + ", Loop: " + loop);

        return answer;
    }

    // 가장 직접적인 방법, 가장 큰 공약수를 구하는 것이므로 거꾸로 두 수 중 작은 수부터 1까지 차례대로 공약수를 구함.
    // 이 결과도 무조건 정답
    public long[] gcdlcm3(long a, long b) {
        long count = 0;
        long loop = 0;

        long divisor;
        long commonDivisor = 1;

        count++;
        if (a > b) {
            divisor = b;
        } else {
            divisor = a;
        }

        while (divisor > 1) {
            loop++;
            count++;
            if (a % divisor == 0 && b % divisor == 0) {
                commonDivisor = divisor;
                break;
            } else {
                divisor--;
            }
        }

        System.out.println("Count: " + count + ", Loop: " + loop);
        return new long[] {commonDivisor, a * b / commonDivisor};

    }

    // 반복(Loop) 횟수를 줄이기 위해 작은 수의 약수가 될 수 없는 수는 루프에서 배제하도록 구현 (특히 소수의 경우 모든 수를 다 검사하게 됨)
    // 작은 수의 약수가 발견되면, 그 약수의 짝이 되는 약수를 먼저 검사하고 돌아옴.
    // 작은 수의 제곱근까지 검사하면 그 이상 되는 약수는 이미 검사했음. 즉, 더 해볼 필요 없음
    public long[] gcdlcm4(long a, long b) {

        long count = 0;
        long loop = 0;

        if (a < b) {
            count++;
            long tmp = a;
            a = b;
            b = tmp;
        }

        long commonDivisor = 1;
        long divisor = b;
        long tmpDivisor = 1;
        boolean isJumping = true;


        while (divisor * divisor <= b || isJumping) {
            loop++;
            count++;
            if (b % divisor == 0) {
                count++;
                if (a % divisor == 0) {
                    commonDivisor *= divisor;
                    a /= divisor;
                    b /= divisor;

                    count++;
                    if (b == 1) {
                        break;
                    }

                    divisor = b;
                    tmpDivisor = 1;
                    isJumping = true;

                } else {
                    count++;
                    if (isJumping == false) {
                        tmpDivisor = divisor;
                        divisor = b / divisor;
                    } else {
                        divisor = tmpDivisor + 1;
                    }
                    isJumping = !isJumping;
                }
            } else {
                divisor++;
            }
        }

        System.out.println("Count: " + count + ", Loop: " + loop);
        return new long[] {commonDivisor, a * b * commonDivisor};
    }


    public static void main(String[] args) {
        TryHelloWorld c = new TryHelloWorld();
        System.out.println("==========================================");
        System.out.println("Arguments: " + String.join(", ", args) + "\n");
        BiFunction<Long, Long, long[]> algorithm;
        long numberOfAlgorithm = 0;
        long numberA = 14;
        long numberB = 21;

        if (args.length >= 3) {
            try {
                long select = Long.parseLong(args[0]);
                numberOfAlgorithm = select;
            } catch (NumberFormatException e) {}

            try {
                numberA = Long.parseLong(args[1]);
                numberB = Long.parseLong(args[2]);
            } catch (NumberFormatException e) {}
        }

        algorithm = c.gcdlcmAlogrithms.get(numberOfAlgorithm);
        if (algorithm == null) {
            numberOfAlgorithm = 0;
            algorithm = c.gcdlcmAlogrithms.get(numberOfAlgorithm);
        }

        System.out.println(numberA + ", " + numberB + "의 최소공배수, 최대공약수 (방법 " + numberOfAlgorithm + ")");

        long startTime = System.currentTimeMillis();
        long[] result = algorithm.apply(numberA, numberB);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(result));
        System.out.println("elapsedTime: " + (endTime - startTime) + " ms\n");
    }

}


