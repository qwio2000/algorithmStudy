public class GetMinMaxString {

    public String getMinMaxString(String str) {
        int length = str.length();
        int max = 0;
        int min = 0;
        int number = 0;

        boolean isNumberFound = false;
        boolean isFirstNumber = true;
        boolean isNegative = false;

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);

            if (c == '-') {
                isNumberFound = true;
                isNegative = true;
            } else if (c >= '0' && c <= '9') {
                isNumberFound = true;
                number = number * 10 + (c - '0');
            }

            if (c == ' ' || i == length - 1) {
                if (isNumberFound) {
                    if (isNegative) {
                        number = -number;
                    }

                    if (isFirstNumber) {
                        max = number;
                        min = number;
                        isFirstNumber = false;
                    } else {
                        if (number > max) {
                            max = number;
                        }
                        if (number < min) {
                            min = number;
                        }
                    }
                    
                    isNumberFound = false;
                    isNegative = false;
                    number = 0;
                }
            }
        }

        return min + " " + max;
    }

    public static void main(String[] args) {

        String testCase = "1 2 3 4";

        if (args.length >= 1) {
            testCase = args[0];
        }

        GetMinMaxString minMax = new GetMinMaxString();
        long start = System.currentTimeMillis();
        String result = minMax.getMinMaxString(testCase);
        long end = System.currentTimeMillis();

        System.out.println("==============================");
        System.out.println("최대값과 최소값: " + result);
        System.out.println("elapsed time: " + (end - start) + " ms");
    }
}