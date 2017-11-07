public class StrToInt {
    public int getStrToInt(String str) {
        int result = 0;
        int length = str.length();
        boolean isNegative = false;

        for (char c : str) {
            char c = str.charAt(i);
            if (c == '-') {
                isNegative = true;
            } else if (c >= '0' && c <= '9') {
                result = result * 10 + (c - 48);
            }
        }

        return isNegative ? -result : result;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다. 
    public static void main(String args[]) {
        StrToInt strToInt = new StrToInt();
        System.out.println(strToInt.getStrToInt("-1234"));

    }
}