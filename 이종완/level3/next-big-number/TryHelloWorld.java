public class TryHelloWorld {
    public int nextBigNumber(int n) {
        String binary = binaryString(n);
        binary = "0" + binary;
        int length = binary.length();
        int split = 0;

        for (int i = length - 1; i > 0; i--) {
            String part = "" + binary.charAt(i-1) + binary.charAt(i);
            if ("01".equals(part)) {
                split = i;
                break;
            }    
        }

        String front = substring(binary, 0, split-1) + "1";
        String rear = "0" + substring(binary, split+1, binary.length());

        int rearLength = rear.length();
        int oneCount = 0;
        int zeroCount = 0;
        for (int i = 0; i < rearLength; i++) {
            if (rear.charAt(i) == '1') {
                oneCount++;
            } else {
                zeroCount++;
            }
        }
        rear = "";
        while(zeroCount > 0) {
            rear += '0';
            zeroCount--;
        }
        while(oneCount > 0) {
            rear += '1';
            oneCount--;
        }

        String nextBigNumberBinary = front + rear;
        return decimalNumber(nextBigNumberBinary);
    }

    String substring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    String binaryString(int n) {
        String result = "";
        while (n > 0) {
            result = (n % 2) + result;
            n /= 2;
        }
        return result;
    }

    int decimalNumber(String binary) {
        int length = binary.length(); 
        int result = 0;
        for (int i = 0; i < length; i++) {
            int digit = binary.charAt(i) - '0';
            result = result * 2 + digit;
        }
        return result;
    }

    public static void main(String[] args) {
        TryHelloWorld test = new TryHelloWorld();
        int n = 78;
        System.out.println(test.nextBigNumber(n));

    }
}