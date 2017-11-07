import java.util.function.Function;
import java.util.Map;
import java.util.HashMap;

public class ReverseStr {

    Map<Integer, Function<String, String>> algorithms;

    public ReverseStr() {
        algorithms = new HashMap<>();
        algorithms.put(0, this::reverseStr0);
        algorithms.put(1, this::reverseStr1);
    }

    public String reverseStr1(String str) {
        int length = str.length();
        char[] charSequence = new char[length];
        for (int i = 0; i < length; i++) {
            charSequence[i] = str.charAt(i);
        }

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (charSequence[j] < charSequence[j + 1]) {
                    char tmp = charSequence[j];
                    charSequence[j] = charSequence[j + 1];
                    charSequence[j + 1] = tmp;
                }
            }
        }

        String result = "";
        for (int i = 0; i < length; i++) {
            result += charSequence[i];
        }

        return result;
    }

    public String reverseStr0(String str) {
        int length = str.length();
        char[] charSequence = new char[length];
        for (int i = 0; i < length; i++) {
            charSequence[i] = str.charAt(i);
        }
        sort(charSequence, 0, length - 1);

        String result = "";
        for (int i = 0; i < length; i++) {
            result += charSequence[i];
        }

        return result;
    }

    private void sort(char[] origin, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(origin, low, mid);
            sort(origin, mid + 1, high);
            merge(origin, low, mid, high);
        }
    }

    private void merge(char[] origin, int low, int mid, int high) {
        char[] tmp = new char[high - low + 1];
        int lowIndex = low;
        int highIndex = mid + 1;
        int tmpIndex = 0;
        while (lowIndex <= mid && highIndex <= high) {
            if (origin[lowIndex] < origin[highIndex]) {
                tmp[tmpIndex++] = origin[highIndex++];
            } else {
                tmp[tmpIndex++] = origin[lowIndex++];
            }
        }

        while (lowIndex <= mid) {
            tmp[tmpIndex++] = origin[lowIndex++];
        }

        while (highIndex <= high) {
            tmp[tmpIndex++] = origin[highIndex++];
        }

        for (int i = 0, j = low; i < tmp.length; i++, j++) {
            origin[j] = tmp[i];
        }
    }

    public static void main(String[] args) {
        Function<String, String> algorithm = null;
        int numberOfAlogrithm = 0;
        String stringToReverse = "Zbcdefg";

        if (args.length >= 2) {
            try {
                numberOfAlogrithm = Integer.parseInt(args[0]);

            } catch (NumberFormatException e) { }
            stringToReverse = args[1];
        }


        ReverseStr rs = new ReverseStr();
        algorithm = rs.algorithms.get(numberOfAlogrithm);
        if (algorithm == null) {
            numberOfAlogrithm = 0;
            algorithm = rs.algorithms.get(numberOfAlogrithm);
        }

        long start = System.currentTimeMillis();
        String result = algorithm.apply(stringToReverse);
        long end = System.currentTimeMillis();
        System.out.println("=======================================");
        System.out.println("* Argument: " + String.join(", ", args));
        System.out.println("* Method(" + numberOfAlogrithm + ")");
        System.out.println("* Original => Result:");
        System.out.println("'" + stringToReverse + "'");
        System.out.println("'" + result + "'");
        System.out.println("* elapsed time: " + (end - start) + " ms");
    }
}