import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

class Divisible {
    public int[] divisible(int[] array, int divisor) {

        int count = 0;
        int length = array.length;
        int[] tmp = new int[length];

        for (int i = 0; i < length; i++) {
            if (array[i] % divisor == 0) {
                tmp[count++] = array[i];
            }
        }

        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = tmp[i];
        }

        return result;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {

        int divisor = 5;
        if (args.length >= 1) {
            try {
                divisor = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) { }
        }

        List<Integer> numbers = Stream.of(args)
        .skip(1)
        .map(str -> {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return null;
            }
        })
        .filter(n -> n != null)
        .collect(toList());

        int[] arrays = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            arrays[i] = numbers.get(i);
        }

        Divisible div = new Divisible();
        long start = System.currentTimeMillis();
        int[] result = div.divisible(arrays, divisor); 
        long end = System.currentTimeMillis();

        System.out.println("==============================");
        System.out.println(Arrays.toString(result));
        System.out.println("elapsed time: " + (end - start) + " ms");
    }
}